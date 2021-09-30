package es.florida.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Nom del directori: ");
		String directori = br.readLine();
		File dir = new File(directori);
		if(!dir.exists()) {
			System.out.println("No existeix el directori");
		}
		else {
			System.out.println("El directori existeix");
		}

	}

}
