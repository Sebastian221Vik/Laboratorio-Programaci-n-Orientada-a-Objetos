import java.util.Scanner;
import java.io.*;

//SIRVE PARA CREAR UN ARCHIVO Y DARLE TEXTO
public class Archivos1 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Scanner stdIn2 = new Scanner(System.in);
		PrintWriter fileOut;
		System.out.print("Introduzca el contenido del nuevo archivo: ");
		String text = stdIn2.nextLine();
		try {
			System.out.print("Introduzca el nombre del nuevo archivo: (con extensión) ");
			fileOut = new PrintWriter(stdIn.nextLine());
			fileOut.println(text);
			fileOut.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
		stdIn.close();
		stdIn2.close();
	}
}