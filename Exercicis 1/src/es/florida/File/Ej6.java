package es.florida.File;

import java.io.File;

public class Ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File(args[0]);
		String[] nombres = null;
		if(args.length == 1) {
			nombres=dir.list();
		}
		else if(args.length ==2){
		FiltroExtension filtre = new FiltroExtension(args[1]);

		nombres = dir.list(filtre);
		}else{
			System.out.println("Has de passar 1 o 2 paràmetres");
		}
		for(String nom : nombres) {
			System.out.println(nom);
		}

	}

}
