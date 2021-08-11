public class Pair{
	private Points a;
	private Points b;
	private double dist;

	public Pair(Points a, Points b, double dist){
		this.a = a;
		this.b = b;
		this.dist = dist;
	}
	public Points getPtA(){
		return a;
	}
	public Points getPtB(){
		return b;
	}
	public double getDist(){
		return dist;
	}
	public int compare(Pair other){
		if(this.dist <= other.getDist()){
			return -1;
		}
		else{
			return 1;
		}
	}
}