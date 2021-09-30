package es.florida.AE1_AD;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AE1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Boolean repetir = false;
		do {
			System.out.println("Què vols fer?" + "\n1. Obtindre informació d'un element" + "\n2. Crear una carpeta"
					+ "\n3. Crear un fitxer" + "\n4. Eliminar un element" + "\n5. Renomenar un element" + "\n6. Eixir");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String resposta = br.readLine();
			switch (resposta) {
			case "1": {
				getInformacio();
				System.in.read();
				repetir=true;
				break;
			}
			case "2": {
				creaCarpeta();
				System.in.read();
				repetir=true;
				break;
			}
			case "3": {
				creaFitxer();
				System.in.read();
				repetir=true;
				break;
			}
			case "4": {
				elimina();
				System.in.read();
				repetir=true;
				break;
			}
			case "5": {
				renomena();
				System.in.read();
				repetir=true;
				break;
			}
			case "6": {
				System.exit(1);
			}
			default: {
				repetir = true;
			}
			}
		} while (repetir);

	}

	public static void getInformacio() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Introdueix el nom del directori/fitxer a consultar: ");
		String nom = br.readLine();
		File element = new File(nom);
		if (element.exists()) {
			System.out.println("Nom: " + element.getName());
			if (element.isFile()) {
				System.out.println("Tipus: Fitxer");
			} else {
				System.out.println("Tipus: Directori");
			}
			System.out.println("Ubicació: " + element.getAbsolutePath());
			SimpleDateFormat format = new SimpleDateFormat("EEEE d MMMM 'de' yyyy", new Locale("ca", "ES"));
			String data = format.format(new Date(element.lastModified()));
			System.out.println("Última modificació: " + data);
			System.out.println("Ocult: " + (element.isHidden() ? "Si" : "No"));
			System.out.println(element.isFile() ? "Grandària: " + element.length()
					: "Elements totals: " + element.list().length + "\nEspai usat: "
							+ (element.getTotalSpace() - element.getFreeSpace()) + "\nEspai disponible: "
							+ element.getFreeSpace() + "\nEspai total: " + element.getTotalSpace());
		} else {
			System.out.println(nom + " no existeix");
		}
	}

	public static void creaCarpeta() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Introdueix el nom de la carpeta a crear: ");
		String nom = br.readLine();
		File carpeta = new File(nom);
		carpeta.mkdir();
	}

	public static void creaFitxer() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Introdueix el nom del fitxer a crear: ");
		String nom = br.readLine();
		File fitxer = new File(nom);
		fitxer.createNewFile();
	}

	public static void elimina() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Introdueix el nom del element a eliminar: ");
		String nom = br.readLine();
		File fitxer = new File(nom);
		fitxer.delete();
	}

	public static void renomena() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Introdueix el nom del element a renomenar: ");
		String nom = br.readLine();
		File fitxer = new File(nom);
		System.out.print("Introdueix el nou nom: ");
		String nounom = br.readLine();
		File noufitxer = new File(nounom);

		fitxer.renameTo(noufitxer);
	}
}
