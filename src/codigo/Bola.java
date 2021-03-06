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
		if (this.getY() > ark.getHeight()|| getY() < 10){
			dy = dy * -1;
		}
		
		//rebota con la pared de la derecha y izquierda
		if ( this.getX()+ getWidth() > ark.ANCHO_PANTALLA-110|| getX() < 65){
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
		
		if (auxiliar == ark.miCursor){// si entra aqu? es que choca con el cursor
			dy = dy * -1;
			noHaChocado = false;
		}else if (auxiliar == null){// si vale null es que no hab?a nada ah?
			
		}else if (auxiliar instanceof Ladrillo2){//si es un ladrillo
			if(auxiliar.getY()-1 + getHeight()+2<=posy || auxiliar.getY()== posy){
				dy = dy * -1;
			}
			else if(auxiliar.getX()-1 + getWidth()+2<=posx || auxiliar.getX()== posx){
				dx = dx * -1;;
			}
			ark.miMarcador.incrementaMarcador(1);
			ark.remove(auxiliar);
			noHaChocado = false;
		}
		
		
		return noHaChocado;
	}
	
}
