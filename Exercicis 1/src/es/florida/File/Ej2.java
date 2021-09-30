package es.florida.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Nom del directori: ");
		String directori = br.readLine();
		File dir = new File(directori);
		File[] contingut = dir.listFiles();
		System.out.println("Contingut del directori: ");
		for(int i = 0;i<contingut.length;i++) {
			System.out.println("\t" + contingut[i].getName());
		}
		System.out.println();
		System.out.println("Nom del directori: " + dir.getName());
		System.out.println("Ruta: " + dir.getPath());
		System.out.println("Ruta absoluta: " + dir.getAbsolutePath());
		System.out.println("Es pot llegir: " + dir.canRead());
		System.out.println("Es pot escriure: " + dir.canWrite());
		System.out.println("Tamany: " + dir.length());

	}

}
