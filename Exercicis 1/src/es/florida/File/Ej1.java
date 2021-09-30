package es.florida.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Nom del directori: ");
		String directori = br.readLine();
		File dir = new File(directori);
		File[] contingut = dir.listFiles();
		for(int i = 0;i<contingut.length;i++) {
			System.out.println(contingut[i].getName());
		}
	}

}
