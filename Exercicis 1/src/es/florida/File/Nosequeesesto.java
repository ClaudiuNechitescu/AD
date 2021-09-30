package es.florida.File;

import java.io.File;

public class Nosequeesesto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fichero = new File("Ejemplo_T1_1_File.txt");
		
		System.out.println("Nombre del archivo: " + fichero.getName());
		System.out.println("Ruta: " + fichero.getPath());
		System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
		System.out.println("Se puede leer: " + fichero.canRead());
		System.out.println("Se puede escribir: " + fichero.canWrite());
		System.out.println("Tamaño: " + fichero.length());
	}

}
