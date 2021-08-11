public class Points{
	private int x;
	private int y;

	public Points(int x, int y){
		this.x  = x;
		this.y = y;
	}
	public Points(){
		this.x = 0;
		this.y = 0;
	}
	public void changeX(int a){
		this.x = a;
	}
	public void changeY(int a){
		this.y = a;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public String toString(){
		return "x: " + this.x + ", y: " + this.y;
	}
	public double distance(Points b){
		double x1 = Math.pow(this.x - b.getX(), 2);
		double y1 = Math.pow(this.y - b.getY(), 2);
		double answer = Math.sqrt(x1 + y1);
		return answer;
	}
	public int compare(Points b, String coor){
		if(coor.equals("x")){
			if(this.x <= b.getX()){
				return -1;
			}
			else{
				return 1;
			}
		}
		else if (coor.equals("y")){
			if(this.y <= b.getY()){
				return -1;
			}
			else{
				return 1;
			}
		}
		return 0;
	}
}