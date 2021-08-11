import java.util.*;
import java.io.*;
public class FindClosestPair{
	private Points [] origArr;
	private Points [] arrx;
    private Points [] arry;

    private Points pt1;
    private Points pt2;

    private double finalDist;


    public FindClosestPair(Points origArr[]){
    	this.origArr = origArr;
    }

    public void start(){
    	this.arrx = origArr.clone();
        this.arry = origArr.clone();
    	MergeSort(arrx, 0, arrx.length-1, "x");
        MergeSort(arry, 0, arry.length-1, "y");
        System.out.println();
        Pair answer = split(arrx, 0, arrx.length-1);


        pt1 = answer.getPtA();
        pt2 = answer.getPtB();
        finalDist = answer.getDist();

    }

    public void MergeSort(Points arr[], int l, int r, String coor){
		if((r-l+1) >1){
			int m = (l+r)/2;
			MergeSort(arr, l, m, coor);
			MergeSort(arr, m+1,r, coor);
			Merge(arr, l, m, r, coor);
		}
	}
	public void Merge(Points arr[], int l, int m, int r, String coor){
		int n1 = m-l+1;
		int n2 = r-m;

		Points left[] = new Points [n1]; 
        Points right[] = new Points[n2];

        for (int i=0; i<n1; ++i){ 
            left[i] = arr[l + i];
        }
        for (int j=0; j<n2; ++j){
            right[j] = arr[m + 1+ j]; 
        }


        int i = 0, j = 0; 
        int k = l; 
        while (i < n1 && j < n2) { 
            if (left[i].compare(right[j], coor) < 0) { 
                arr[k] = left[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = right[j]; 
                j++; 
            } 
            k++; 
        }

        while (i < n1) { 
            arr[k] = left[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) { 
            arr[k] = right[j]; 
            j++; 
            k++; 
        } 
	}
	public Pair split(Points arr[], int l, int r){
		if(r - l + 1 <= 4){
			return brute(arr, l, r);
		}
		else {
			int m = (l+r)/2;
			Pair a = split(arr, l, m);
			Pair b = split(arr, m+1, r);

			Pair curr_best, otherPair;
			if (a.compare(b) < 0){
				curr_best = a;
			}
			else{
				curr_best = b;
			}

			double delta = curr_best.getDist();
			int x_val = arr[m].getX();

			Points[] otherArr = middleArr(delta, x_val);

			if (otherArr.length <= 1){
				return curr_best;
			}
			else{
				otherPair = middle(otherArr);
			}

			if (curr_best.compare(otherPair) < 0){
				return curr_best;
			}

			else{
				return otherPair;
			}
		}
	}
	public Pair brute(Points arr[], int l, int r){
		Points a = arr[l];
		Points b= arr[l+1];
		double distmin = a.distance(b);
		for (int i = l; i <= r-1; i++){
			for(int j = i+1; j <= r; j++){

				double distance = arr[i].distance(arr[j]);
				if (distance < distmin){
					a = arr[i];
					b = arr[j]; 
					distmin = distance;
				}

			}
		}
		Pair pair = new Pair(a,b, distmin);
		// System.out.println("Best Curr Pair: " + pair.getPtA().toString() + ", " + pair.getPtB().toString());
		return pair;
	}
	public Pair middle (Points[] arr){
		Points a = arr[0];
		Points b= arr[0+1];
		double distmin = a.distance(b);

		for (int i = 0; i < arr.length-7; i++){
			for (int j = i+1; j<i+8; j++){
				double distance = arr[i].distance(arr[j]);
				if (distance < distmin){
					a = arr[i];
					b = arr[j]; 
					distmin = distance;
				}
			}
		}
		Pair pair = new Pair(a,b, distmin);
		return pair;
	}
	public Points[] middleArr(double delta, int x_val){
		ArrayList<Points> newList = new ArrayList<>();
		for (int i = 0; i < arry.length; i++){
			int x = arry[i].getX();

			if(x < (x_val + delta) && x > (x_val - delta)){
				newList.add(arry[i]);
			}
		}

		Points[] newList2 = new Points[newList.size()];
		for (int i = 0; i < newList2.length; i++){
			newList2[i] = newList.get(i);
		}
		return newList2;
	}

	public Points getPt1(){
		return pt1;
	}
	public Points getPt2(){
		return pt2;
	}
	public double getFinDist(){
		return finalDist;
	}

}
