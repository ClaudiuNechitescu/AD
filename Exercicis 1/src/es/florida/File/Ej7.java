package es.florida.File;

import java.io.File;

public class Ej7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File(args[0]);
		String[] nombres = null;
		if(args.length == 1) {
			nombres=dir.list();
			for(String nom : nombres) {
				System.out.println(nom);
			}

		}
		else if(args.length >1) {
			for(int i=1; i<args.length;i++) {
				FiltroExtension filtre = new FiltroExtension(args[i]);
				
				nombres = dir.list(filtre);
				for(String nom : nombres) {
					System.out.println(nom);
				}

			}
		FiltroExtension filtre = new FiltroExtension(args[1]);

		nombres = dir.list(filtre);
		}else{
			System.out.println("Has de passar 1 o 2 paràmetres");
		}

	}

}
