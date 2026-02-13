import java.util.Scanner;
import java.io.*;

// favor de probar este programa con los archivo numeros.txt y texto.txt
//LEE ARCHIVOS
public class Archivos3 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Scanner fileIn;
        String line;
        try {
            System.out.print("Introduzca el nombre del archivo: ");
            fileIn = new Scanner(new FileReader(stdIn.nextLine()));
            while (fileIn.hasNextLine()) {
                line = fileIn.nextLine();
                System.out.println(line);
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        stdIn.close();
    }
}
