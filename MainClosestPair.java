import java.util.*;
import java.io.*;
public class MainClosestPair{
	public static void main(String[] args)throws Exception{


		Scanner scanner = new Scanner(new File("points.txt"));

		int k = 0;
		int i = 0;
		int n = 0;
		if (scanner.hasNextInt()){ 
			n = scanner.nextInt();
		}
		Points [] arr = new Points[n];
		while(scanner.hasNextInt()){
			if (k%2 == 0){
				arr[i] = new Points();
				int x = scanner.nextInt();
				// System.out.println("x: "+ x);
				arr[i].changeX(x);
			}
			else {
				int y = scanner.nextInt();
				// System.out.println("y: " + y);
				arr[i].changeY(y);
				i++;
			}
			k++;
        }

       	FindClosestPair obj = new FindClosestPair(arr);
       	obj.start();

       	String pt1 = obj.getPt1().toString();
       	String pt2 = obj.getPt2().toString();

       	double distance = obj.getFinDist();

       	System.out.println("\nFinal Answer:");
       	System.out.println(pt1);
       	System.out.println(pt2);
       	System.out.println("Distance: " + distance);


       	System.out.println("\nBrute Force Answer:");


       	Points a = arr[0];
		Points b = arr[1];
		double distmin = a.distance(b);
		for (int f = 0; f < n-1; f++){
			for(int j = f+1; j < n; j++){

				double d = arr[f].distance(arr[j]);
				if (d < distmin){
					a = arr[f];
					b = arr[j]; 
					distmin = d;
				}

			}
		}
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println("Distance: " +distmin);

    }



}