package vue;

public class Tortue {
	private int x;
	private int y;
	
	private int angle;
	
	public boolean haut=false;
	
	public Tortue(){
		x=0;
		y=0;
		angle=90;
	}

	public void avancer(int distance){
		/*switch(angle){
		case 0:
			x+=distance;
			break;
		case 90:
			y+=distance;
			break;
		case 180:
			x-=distance;
			break;
		case 270:
			y-=distance;
			break;
		}*/
		int dX=(int)(distance*Math.cos(Math.toRadians(angle)));
		int dY=(int)(distance*Math.sin(Math.toRadians(angle)));
		x+=dX;
		y+=dY;
	}
	
	public void tourner(int angle){
		//Cette operation permet d'etre sur que l'angle est entre 0 et 360
		this.angle=this.angle+angle;
		//System.out.println(this.angle);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public boolean isHaut() {
		return haut;
	}

	public void setHaut(boolean haut) {
		this.haut = haut;
	}
	
	public void reIni(){
		x=0;
		y=0;
		angle=90;
	}
	
}
