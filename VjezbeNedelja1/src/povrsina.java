import java.util.Scanner;

public class povrsina {

    static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double P = (a * b) / 100;
        
        System.out.printf("Povrsina %.2f", P);
        
        sc.close();
    }
}

