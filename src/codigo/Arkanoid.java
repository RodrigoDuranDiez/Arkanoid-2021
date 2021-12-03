package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram{
	
	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;
	static final int ANCHO_PANTALLA = 520;
	
	Bola bola1 = new Bola(10, 10,Color.BLUE);
	//declaro el cursor del juego
	Cursor miCursor = new Cursor(0, 300, 60, 10,Color.RED);
	
	GImage fondo = new GImage("imagenes/mario2.png");
	GImage fondoMiMarcadors = new GImage("imagenes/rayo.gif");
	GImage gameover= new GImage("imagenes/gameover.gif");
	GImage start = new GImage("imagenes/amongus2.gif");
	GImage levelUP= new GImage("imagenes/levelup.gif");
	GImage ladrillo=new GImage("imagenes/ladrillo mario.png");
	GImage victoria = new GImage("imagenes/victoria2.gif");
	GRect fondoMarcador = new GRect(300,600);
	Marcador miMarcador=new Marcador(20,40);
	
	public void init(){
		start.setBounds(0, 0, 815, 510);
		add(start);
		waitForClick();
		fondoMarcador.setFilled(true);
		add(fondoMarcador, ANCHO_PANTALLA-40,0);
		add(fondo);
		addMouseListeners();
		add(bola1 ,250,320);
		add(miCursor,250,350);
		add(fondoMiMarcadors,ANCHO_PANTALLA-40,0);
		miMarcador.addMarcador(this);
		setSize(ANCHO_PANTALLA+300,500);
	}
	public void run(){//se inicia el programa
		miMarcador.addMarcador(this);
		creaPiramide();
		while(true){
			//acciones que cambian el contenido de la pantalla
			bola1.muevete(this);//paso el objeto arkanoid que se está ejecutando
				pause(5);
				miCursor.muevete(ANCHO_PANTALLA-30,(int)bola1.getX());//Hace que juegue de forma automática
				if(miMarcador.puntuacion==45){
					levelUP.setBounds(0, 0, 815, 510);
					add(levelUP);
					waitForClick();
					creaMuro();
					remove(levelUP);
				}
				if(miMarcador.puntuacion==100){//Sale la imagen de victoria y se reinicia el juego al llegar a 100 puntos//
					removeAll();
					victoria.setBounds(0, 0, 815, 510);
					add(victoria);
					waitForClick();
					init();
					run();
				}
				if( bola1.getY()-40 > miCursor.getY()){//Cuando la bola esta por debajo del cursor pierdes
					removeAll();
					gameover.setBounds(0, 0, 815, 510);
					add(gameover);
					waitForClick();
					init();
					run();
					
					
					
				}
		}
	}
	public void mouseClicked(MouseEvent evento){
		int posicionX = evento.getX();//Donde se ha producido el click en eje X
		int posicionY = evento.getY();//Donde se ha producido el click en eje Y
	}


public void mouseMoved(MouseEvent evento){
	miCursor.muevete(ANCHO_PANTALLA-110,evento.getX()+70);
}
public void creaPiramide(){//crea una piramide en una posición
	int numeroLadrillos= 9;
	int desplazamiento_inicial_X =77;
	int desplazamiento_inicial_Y= 0;
	
	for (int j=0; j<numeroLadrillos; j++){
		for (int i=j; i<numeroLadrillos; i++){
			Ladrillo2 miLadrillo = new Ladrillo2("imagenes/ladrillo mario.png");		
			add(miLadrillo , ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j+ desplazamiento_inicial_X,
					ALTO_LADRILLO*j+ desplazamiento_inicial_Y );
			pause(10);
		}
	}
}
public void creaMuro(){//crea una segunda piramide al subir de nivel
	int numeroLadrillos= 10;
	int desplazamiento_inicial_X =77;
	int desplazamiento_inicial_Y= 0;
	
	for (int j=0; j<numeroLadrillos; j++){
		for (int i=j; i<numeroLadrillos; i++){
			Ladrillo2 miLadrillo = new Ladrillo2("imagenes/ladrillo mario.png");
			add(miLadrillo , ANCHO_LADRILLO*i - ANCHO_LADRILLO/15*j+ desplazamiento_inicial_X,
					ALTO_LADRILLO*j+ desplazamiento_inicial_Y );
			add(miLadrillo);
			pause(10);
			
		}
	}
}

}