package es.florida.AE1_AD;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class AE1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		do {
			System.out.println("Què vols fer?" + "\n1. Obtindre informació d'un element" + "\n2. Crear una carpeta"
					+ "\n3. Crear un fitxer" + "\n4. Eliminar un element" + "\n5. Renomenar un element" + "\n6. Eixir");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String resposta = br.readLine();
			Scanner continuar = new Scanner(System.in);
			switch (resposta) {
			case "1": {
				getInformacio();
				break;
			}
			case "2": {
				creaCarpeta();
				break;
			}
			case "3": {
				creaFitxer();
				break;
			}
			case "4": {
				elimina();
				break;
			}
			case "5": {
				renomena();
				break;
			}
			case "6": {
				System.exit(1);
			}
			default: {
			}
				System.out.println("Has de triar una opció de 1 a 6");
				break;
			}
			System.out.println("<Pressiona ENTER per a continuar>");
			continuar.nextLine();
		} while (true);

	}

	public static void getInformacio() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Introdueix el nom del directori/fitxer a consultar: ");
		String nom = br.readLine();
		File element = new File(nom);
		if (element.exists()) {
			// Verifiquem si tenim permisos de llectura només, perquè no anirem a modificar
			// res.
			if (Files.isReadable(Paths.get(element.getPath()))) { // El métode element.canRead() no funciona, torna
																	// sempre true, independentment de si tens permisos
																	// de llectura o no
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
				System.out.println("No tens permisos de llectura");
			}
		} else {
			System.out.println(element.getName() + " no existeix");
		}
	}

	public static void creaCarpeta() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Introdueix el nom de la carpeta a crear: ");
		String nom = br.readLine();
		File carpeta = new File(nom);
		if (Files.isWritable(Paths.get(carpeta.getParentFile().getPath()))) {
			System.out.println(!carpeta.exists()
					? carpeta.mkdir() ? "Carpeta creada exitosament" : "No s'ha pogut crear la carpeta"
					: carpeta.getName() + " ja existeix");
		} else {
			System.out.println("No tens permisos d'escritura");
		}
	}

	public static void creaFitxer() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Introdueix el nom del fitxer a crear: ");
		String nom = br.readLine();
		File fitxer = new File(nom);
		if (Files.isReadable(Paths.get(fitxer.getParentFile().getPath()))) {
			System.out.println(!fitxer.exists()
					? fitxer.createNewFile() ? "Fitxer creat exitosament" : "No s'ha pogut crear el fitxer"
					: fitxer.getName() + " ja existeix");
		} else {
			System.out.println("No tens permisos d'escritura");
		}
	}

	public static void elimina() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Introdueix el nom del element a eliminar: ");
		String nom = br.readLine();
		File fitxer = new File(nom);
		if (Files.isWritable(Paths.get(fitxer.getPath()))
				&& Files.isWritable(Paths.get(fitxer.getParentFile().getPath()))) {
			System.out.println(fitxer.exists()
					? fitxer.delete() ? "Fitxer eliminat exitosament" : "No s'ha pogut eliminar el fitxer"
					: fitxer.getName() + " no existeix");
		} else {
			System.out.println("No tens permisos d'escritura");
		}
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
		if (Files.isWritable(Paths.get(fitxer.getPath()))
				&& Files.isWritable(Paths.get(fitxer.getParentFile().getPath()))) {
			System.out.println(fitxer.exists()
					? fitxer.renameTo(noufitxer) ? "Fitxer renomenat exitosament" : "No s'ha pogut renomenar el fitxer"
					: fitxer.getName() + " no existeix");
		} else {
			System.out.println("No tens permisos d'escritura");
		}
	}
}
