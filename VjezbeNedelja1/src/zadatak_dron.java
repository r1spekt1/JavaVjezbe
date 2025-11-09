import java.util.Scanner;

public class zadatak_dron {

	public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static void main() {
    	
        Scanner sc = new Scanner(System.in);
        
        int unos = sc.nextInt();
        double dron_x = sc.nextDouble();
        double dron_y = sc.nextDouble();
        int i = 0, x, y;
        double distanca = 0;
        
        while (i < unos) {
            i++;
            System.out.print(i);
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            if (x > 0 && y > 0) {
                distanca += calculateDistance(dron_x, dron_y, x, y);
                
             
            }
        }
        System.out.println(distanca);
        sc.close();
    }

}
