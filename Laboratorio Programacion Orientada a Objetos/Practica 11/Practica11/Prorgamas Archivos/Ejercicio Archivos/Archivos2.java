import java.util.Scanner;
import java.io.*;

//AGREGA CONTENIDO AL ARCHIVO
public class Archivos2 {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PrintWriter fileOut;
        String text = "Append para el archivo";
        try {
            System.out.print("Introduzca el nombre de un archivo existente: ");
            fileOut = new PrintWriter(new FileWriter(stdIn.nextLine(), true));
            fileOut.println(text);
            fileOut.close();
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        stdIn.close();
    }
}