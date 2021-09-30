package es.florida.File;

import java.io.File;

public class Ej5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiltroExtension filtre = new FiltroExtension(args[1]);
		File dir = new File(args[0]);
		String[] nombres = dir.list(filtre);
		for(String nom : nombres) {
			System.out.println(nom);
		}
	}

}
