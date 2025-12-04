package projekat5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameGUI extends JFrame {
    private JTextField nameField;
    private JTextField healthField;
    private JTextField xField;
    private JTextField yField;
    private JComboBox<String> colliderCombo;
    private JTextField minEnemiesField;
    private JTextField maxEnemiesField;
    private JCheckBox useRandomEnemiesCheckBox;
    private JTextArea resultArea;
    
    public GameGUI() {
        setTitle("Game Setup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Panel za unos podataka
        JPanel inputPanel = createInputPanel();
        add(inputPanel, BorderLayout.NORTH);
        
        // Dugme za pokretanje
        JButton startButton = new JButton("Pokreni igru");
        startButton.addActionListener(new StartGameListener());
        add(startButton, BorderLayout.CENTER);
        
        // Prikaz rezultata
        resultArea = new JTextArea(20, 50);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Ime
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Ime:"), gbc);
        gbc.gridx = 1;
        nameField = new JTextField(15);
        panel.add(nameField, gbc);
        
        // Health
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Health (0-100):"), gbc);
        gbc.gridx = 1;
        healthField = new JTextField("", 15);
        panel.add(healthField, gbc);
        
        // X pozicija
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("X pozicija:"), gbc);
        gbc.gridx = 1;
        xField = new JTextField("10", 15);
        panel.add(xField, gbc);
        
        // Y pozicija
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Y pozicija:"), gbc);
        gbc.gridx = 1;
        yField = new JTextField("10", 15);
        panel.add(yField, gbc);
        
        // Tip kolajdera
        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(new JLabel("Tip kolajdera:"), gbc);
        gbc.gridx = 1;
        colliderCombo = new JComboBox<>(new String[]{"Pravougaonik 32x32", "Krug r=16"});
        panel.add(colliderCombo, gbc);
        
        // Checkbox za random neprijatelje
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        useRandomEnemiesCheckBox = new JCheckBox("Koristi specifičan broj neprijatelja", false);
        panel.add(useRandomEnemiesCheckBox, gbc);
        gbc.gridwidth = 1;
        
        // Min broj neprijatelja
        gbc.gridx = 0; gbc.gridy = 6;
        panel.add(new JLabel("Min neprijatelja:"), gbc);
        gbc.gridx = 1;
        minEnemiesField = new JTextField("1", 15);
        minEnemiesField.setEnabled(false);
        panel.add(minEnemiesField, gbc);
        
        // Max broj neprijatelja
        gbc.gridx = 0; gbc.gridy = 7;
        panel.add(new JLabel("Max neprijatelja:"), gbc);
        gbc.gridx = 1;
        maxEnemiesField = new JTextField("6", 15);
        maxEnemiesField.setEnabled(false);
        panel.add(maxEnemiesField, gbc);
        
        // Listener za checkbox
        useRandomEnemiesCheckBox.addActionListener(e -> {
            boolean enabled = useRandomEnemiesCheckBox.isSelected();
            minEnemiesField.setEnabled(enabled);
            maxEnemiesField.setEnabled(enabled);
        });
        
        return panel;
    }
    
    private class StartGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Kreiranje igrača
                Player player = createPlayerFromInput();
                
                // Kreiranje igre
                Game game = new Game(player);
                
                // Učitavanje neprijatelja iz CSV fajla
                ArrayList<Enemy> enemies;
                
                if (useRandomEnemiesCheckBox.isSelected()) {
                    // Korisnik je specificirao min/max
                    int minEnemies = Integer.parseInt(minEnemiesField.getText().trim());
                    int maxEnemies = Integer.parseInt(maxEnemiesField.getText().trim());
                    enemies = Game.loadEnemiesFromCSV("enemies.csv", minEnemies, maxEnemies);
                } else {
                    // Potpuno random (1 do svi dostupni)
                    enemies = Game.loadEnemiesFromCSV("enemies.csv");
                }
                
                for (Enemy enemy : enemies) {
                    game.addEnemy(enemy);
                }
                
                // Pokretanje logike kolizije
                game.resolveCollisions();
                
                // Prikaz rezultata
                displayResults(game, player);
                
                // Provjera stanja igrača
                checkGameStatus(player);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(GameGUI.this, 
                    "Greška: " + ex.getMessage(), 
                    "Greška", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private Player createPlayerFromInput() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Ime ne može biti prazno");
        }
        
        int health = Integer.parseInt(healthField.getText().trim());
        int x = Integer.parseInt(xField.getText().trim());
        int y = Integer.parseInt(yField.getText().trim());
        
        Collidable collider;
        if (colliderCombo.getSelectedIndex() == 0) {
            // Pravougaonik 32x32
            collider = new RectangleCollider(x, y, 32, 32);
        } else {
            // Krug r=16
            collider = new CircleCollider(x, y, 16);
        }
        
        return new Player(name, x, y, collider, health);
    }
    
    private void displayResults(Game game, Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== INFORMACIJE O IGRI ===\n");
        sb.append("Učitano neprijatelja: ").append(game.getEnemies().size()).append("\n\n");
        
        sb.append("=== STATUS IGRAČA ===\n");
        sb.append(player).append("\n\n");
        
        sb.append("=== SVI NEPRIJATELJI ===\n");
        for (Enemy enemy : game.getEnemies()) {
            sb.append(enemy).append("\n");
        }
        
        sb.append("\n=== NEPRIJATELJI U KOLIZIJI ===\n");
        ArrayList<Enemy> colliding = game.collidingWithPlayer();
        if (colliding.isEmpty()) {
            sb.append("Nema kolizija\n");
        } else {
            for (Enemy enemy : colliding) {
                sb.append(enemy).append("\n");
            }
        }
        
        sb.append("\n=== LOG DOGAĐAJA ===\n");
        for (String event : game.getEventLog()) {
            sb.append(event).append("\n");
        }
        
        resultArea.setText(sb.toString());
    }
    
    private void checkGameStatus(Player player) {
        if (player.getHealth() <= 0) {
            JOptionPane.showMessageDialog(this, 
                "Igrač je poražen! Zdravlje: " + player.getHealth(), 
                "Kraj igre", 
                JOptionPane.ERROR_MESSAGE);
        } else if (player.getHealth() == 100) {
            JOptionPane.showMessageDialog(this, 
                "Igrač je pobijedio! Puno zdravlje!", 
                "Pobjeda", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Igrač je preživio sa manjim brojem healtha
            JOptionPane.showMessageDialog(this, 
                "Igrač je preživio! Preostalo zdravlje: " + player.getHealth() + "/100", 
                "Preživljavanje", 
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameGUI().setVisible(true);
        });
    }
}