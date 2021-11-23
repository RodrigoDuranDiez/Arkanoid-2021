package codigo;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval{
	int dx = 1; //velocidad en el eje x
	int dy = 1; //velocidad en el eje y
	
	public Bola(double width, double height) {
		super(width, height);
		
	}
	public Bola(double width, double height, Color c) {
		super(width, height);
		this.setFillColor(c);
		this.setFilled(true);
	}
	public void muevete(Arkanoid ark){
		//rebota con el suelo y techo
		if (this.getY() > ark.getHeight()|| getY() < 0){
			dy = dy * -1;
		}
		
		//rebota con la pared de la derecha y izquierda
		if ( this.getX()+ getWidth() > ark.getWidth()|| getX() < 0){
			dx = dx * -1;
		}
		//chequeo la esquina superior izquierda
		 if (chequeaColision(getX (), getY(),ark)){
			 if (chequeaColision(getX ()+ getWidth(), getY(),ark)){
				 if (chequeaColision(getX (), getY()+ getHeight(),ark)){
					 if (chequeaColision(getX ()+ getWidth(), getY()+ getHeight(),ark)){
						 
					 }
				 }
			 }
		 }

		
		//mueve la bola en la direccion correcta
		this.move(dx,dy);
	}
	private boolean chequeaColision(double posx, double posy,Arkanoid ark){
		boolean noHaChocado = true;
		GObject auxiliar;
		
		auxiliar = ark.getElementAt(posx,posy);
		
		if (auxiliar == ark.miCursor){// si entra aquí es que choca con el cursor
			dy = dy * -1;
			noHaChocado = false;
		}else if (auxiliar == null){// si vale null es que no había nada ahí
			
		}else if (auxiliar instanceof Ladrillo){//si es un ladrillo
			if(auxiliar.getY() + getHeight()<=posy || auxiliar.getY()== posy){
				dy = dy * -1;
			}
			else if(auxiliar.getX() + getWidth()<=posx || auxiliar.getX()== posx){
				dx = dx * -1;;
			}
			ark.remove(auxiliar);
			noHaChocado = false;
		}
		
		
		return noHaChocado;
	}
	
}
