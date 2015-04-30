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

/**
 * Objet Tortue. C'est le curseur qui se deplace sur le canvas pour dessiner
 * @author Q & A
 *
 */
public class Tortue {
	private int x;
	private int y;
	
	private int angle;
	
	public boolean haut=true;
	
	/**
	 * Cree une tortue a  sa position de depart
	 */
	public Tortue(){
		x=0;
		y=0;
		angle=90;
	}

	/**
	 * Fait avancer la tortue de la distance donnee en argument.
	 * @param distance
	 */
	public void avancer(int distance){
		int dX=(int)(distance*Math.cos(Math.toRadians(angle)));
		int dY=(int)(distance*Math.sin(Math.toRadians(angle)));
		x+=dX;
		y+=dY;
	}
	
	/**
	 * Fait tourner la Tortue de l'angle donne en argument
	 * @param angle
	 */
	public void tourner(int angle){
		//Cette operation permet d'etre sur que l'angle est entre 0 et 360
		this.angle=this.angle+angle;
	}
	
	/**
	 * Recupere la position horizontale de la tortue
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * Modifie la position horizontale de la tortue
	 * @return
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Recupere la position verticale de la tortue
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * Modifie la position verticale de la tortue
	 * @return
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Donne l'angle de la tortue
	 * @return
	 */
	public int getAngle() {
		return angle;
	}
	
	/**
	 * Modifie l'angle de la tortue
	 * @return
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

	/**
	 * Dit si la tortue est en position haute ou non
	 * @return
	 */
	public boolean isHaut() {
		return haut;
	}

	/**
	 * Permet de choisir si la tortue est en position haute ou non
	 * @param haut
	 */
	public void setHaut(boolean haut) {
		this.haut = haut;
	}
	
	/**
	 * ReInintialise la tortue a son point de depart sur le canvas
	 */
	public void reIni(){
		x=0;
		y=0;
		angle=90;
	}
	
}
