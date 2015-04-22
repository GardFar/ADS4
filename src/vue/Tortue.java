/*
 * Copyright (C) <2015>  <AmbroiseT et QuentinP>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 */


package vue;

public class Tortue {
	private int x;
	private int y;
	
	private int angle;
	
	public boolean haut=true;
	
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
