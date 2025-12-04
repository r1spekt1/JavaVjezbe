package konvertorvaluta;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.HashMap;

public class konvertorValuta extends JFrame {

    private final HashMap<String, Double> rates = new HashMap<>();
    private boolean blockUpdate = false;

    public konvertorValuta() {

        // --- KURSEVI ---
        rates.put("EUR_USD", 1.17);
        rates.put("EUR_GBP", 0.87);
        rates.put("USD_GBP", 0.74);

        setTitle("Konverzija valuta");
        setSize(400, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4,4,4,4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels
        JLabel eurLabel = new JLabel("EUR");
        JLabel usdLabel = new JLabel("USD");
        JLabel gbpLabel = new JLabel("GBP");

        // Text fields
        JTextField txtEUR = new JTextField();
        JTextField txtUSD = new JTextField();
        JTextField txtGBP = new JTextField();
        
        txtEUR.setPreferredSize(new Dimension(120, 28));
        txtUSD.setPreferredSize(new Dimension(120, 28));
        txtGBP.setPreferredSize(new Dimension(120, 28));

        // Dodajemo redom EUR
        gbc.gridx = 0; gbc.gridy = 0;
        add(eurLabel, gbc);
        gbc.gridx = 1;
        add(txtEUR, gbc);

        // USD
        gbc.gridx = 0; gbc.gridy = 1;
        add(usdLabel, gbc);
        gbc.gridx = 1;
        add(txtUSD, gbc);

        // GBP
        gbc.gridx = 0; gbc.gridy = 2;
        add(gbpLabel, gbc);
        gbc.gridx = 1;
        add(txtGBP, gbc);

        // --- EVENT LISTENER ---
        addListener(txtEUR, "EUR", txtUSD, txtGBP);
        addListener(txtUSD, "USD", txtEUR, txtGBP);
        addListener(txtGBP, "GBP", txtEUR, txtUSD);
    }

    private void addListener(JTextField sourceField, String currency,
                             JTextField f1, JTextField f2) {

        sourceField.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { convert(); }
            @Override public void removeUpdate(DocumentEvent e) { convert(); }
            @Override public void changedUpdate(DocumentEvent e) { convert(); }

            private void convert() {
                if (blockUpdate) return;

                try {
                    double amount = Double.parseDouble(sourceField.getText());
                    blockUpdate = true;

                    if (currency.equals("EUR")) {
                        f1.setText(String.format("%.2f", convertDirect(amount, "EUR", "USD")));
                        f2.setText(String.format("%.2f", convertDirect(amount, "EUR", "GBP")));
                    } else if (currency.equals("USD")) {
                        f1.setText(String.format("%.2f", convertDirect(amount, "USD", "EUR")));
                        f2.setText(String.format("%.2f", convertDirect(amount, "USD", "GBP")));
                    } else if (currency.equals("GBP")) {
                        f1.setText(String.format("%.2f", convertDirect(amount, "GBP", "EUR")));
                        f2.setText(String.format("%.2f", convertDirect(amount, "GBP", "USD")));
                    }

                } catch (Exception ignored) {
                    f1.setText("");
                    f2.setText("");
                } finally {
                    blockUpdate = false;
                }
            }
        });
    }

    private double convertDirect(double amount, String from, String to) {
        String key = from + "_" + to;
        if (rates.containsKey(key)) return amount * rates.get(key);

        String reverse = to + "_" + from;
        if (rates.containsKey(reverse)) return amount / rates.get(reverse);

        return amount;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new konvertorValuta().setVisible(true));
    }
   }