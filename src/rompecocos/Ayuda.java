/*
 * Programacion interactiva
 * Author: Luis Fernando Lara S - 2024730-3743
 * Email: luis.fernando.lara@correounivalle.edu.co
 * Atento y Rapido Miniproyecto
 */
package rompecocos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import misComponentes.Titulos;

public class Ayuda extends JFrame {
	
	private BufferedImage originalImage;
	private JLabel image;
	private ImageIcon adaptedImage;
	private JButton volver;
	private Escuchas escucha;
	private JFrame rompecocos;
	
	public Ayuda(JFrame rompecocos) {
		try {
			originalImage = ImageIO.read(new File(Rompecocos.rutaFile));
			this.rompecocos=rompecocos;
			initGUI();
			
			//Default window
			this.setUndecorated(true);
			this.pack();
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setVisible(false);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initGUI() {
		//Window container y layout
		
		//Crear escucha
		
		escucha = new Escuchas();
		
		//Crear GUI
		Titulos titulo = new Titulos("Imagen Original",27,Color.BLUE);
		this.add(titulo,BorderLayout.NORTH);
		
		BufferedImage subImage = originalImage.getSubimage(0,0,400,400);
		adaptedImage = new ImageIcon(subImage);
		image = new JLabel(adaptedImage);
		this.add(image,BorderLayout.CENTER);
		
		volver = new JButton("volver");
		volver.addActionListener(escucha);
		this.add(volver,BorderLayout.SOUTH);
	}
	
	private class Escuchas implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Evento boton volver
			//activas la ventana rompecocos y hacer invisible ayuda
			rompecocos.setEnabled(true);
			setVisible(false);
		}
		
	}
}
