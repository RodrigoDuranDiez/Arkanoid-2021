package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Marcador extends GRect {
	
	GLabel texto = new GLabel(" ");
	GLabel nivel = new GLabel(" ");
	int puntuacion = 0;
	GImage fondoMiMarcadors = new GImage("imagenes/marioMiedo.jpg");

	public Marcador(double width, double height) {
		super(width, height);
		setFilled(true);
		setFillColor(Color.BLACK);
		texto.setLabel("SUERTE  0");
		texto.setColor(Color.WHITE);
		texto.setFont(new Font("Among Us Regular",Font.BOLD, 20));
		
	}
	
	//suma el nº de puntos que se indica en la variable puntos
	//a la puntuacion actual
	public void incrementaMarcador(int puntos){
		puntuacion = puntuacion + puntos;//puntuacion += puntos;
		texto.setLabel(""+puntuacion);
	}
	public void addMarcador(Arkanoid arkanoid){
		arkanoid.add(this,arkanoid.getWidth()- 100,20 );
		arkanoid.add(texto,arkanoid.getWidth()-160,260);
		
	}
}
