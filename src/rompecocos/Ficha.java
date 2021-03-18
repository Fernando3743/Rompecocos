/*
 * Programacion interactiva
 * Author: Luis Fernando Lara S - 2024730-3743
 * Email: luis.fernando.lara@correounivalle.edu.co
 * Atento y Rapido Miniproyecto
 */
package rompecocos;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author ferna
 *
 */
public class Ficha extends JButton {
	
	private static int fichaSize=0;
	private static int maxFichas=0;
	private int row, col, idImage;
	private ImageIcon image;
	
	public Ficha(ImageIcon image,int idImage, int row, int col) {
		
		this.row = row;
		this.col=col;
		setImage(image,idImage);
		
		this.setBackground(Color.WHITE);
		Dimension size = new Dimension(fichaSize,fichaSize);
		this.setPreferredSize(size);
		this.setBorder(null);
		this.setFocusPainted(false);
	}
	
	private void setImage(ImageIcon image, int idImage) {
		this.image=image;
		this.idImage=idImage;
		if(this.idImage<maxFichas-1) {
			setIcon(image);
		}
		else {
			setIcon(null);
		}
	}
	
	public static void setFichaSizeMaxFichas(int tamano, int numerofichas) {
		maxFichas = numerofichas;
		fichaSize = tamano;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getIdImage() {
		return idImage;
	}

	public ImageIcon getImage() {
		return image;
	}
	
	public void mostrarImagen() {
		setIcon(image);
	}
	
	//pieza.intercambiar(pieza2);
	public void intercambiar(Ficha otraFicha) {
		ImageIcon otraImagen = otraFicha.getImage();
		int idOtraImage = otraFicha.getIdImage();
		
		otraFicha.setImage(this.image, this.idImage);
		this.setImage(otraImagen, idOtraImage);
	}
	
	public boolean hasNoImage() {
		return this.getIcon()==null;
	}
}
