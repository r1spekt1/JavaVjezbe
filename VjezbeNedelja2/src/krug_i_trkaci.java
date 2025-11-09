import java.util.Scanner;

public class krug_i_trkaci {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double cx = sc.nextDouble();
		double cy = sc.nextDouble();
		double R1 = sc.nextDouble();
		double R2 = sc.nextDouble();
		int N = sc.nextInt();
		
		
		// Kvadrati poluprečnika (da izbjegnemo nepotrebne korijene u poređenju)
		double R1sq = R1 * R1;
		double R2sq = R2 * R2;
		int countInRingUpper = 0;
		
		// Za najudaljenijeg:
		double maxDistSq = -1.0; // čuvamo kvadrat rastojanja
		double farX = 0.0, farY = 0.0;
		for (int i = 0; i < N; i++) {
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double dx = x - cx;
		double dy = y - cy;
		double d2 = dx * dx + dy * dy;
		
		// U prstenu (uključujući granice) i u gornjoj poluravni (y >= cy)
		if (d2 >= R1sq && d2 <= R2sq && y >= cy) {
		countInRingUpper++;
		}
		
		// Najudaljeniji od centra
		if (d2 > maxDistSq) {
		maxDistSq = d2;
		farX = x;
		farY = y;
		}
}
		
		sc.close();
		// Ispisi
		System.out.println(countInRingUpper);
		System.out.printf("%.6f %.6f %.6f%n", farX, farY,
		Math.sqrt(maxDistSq));
		}
	
	
}
