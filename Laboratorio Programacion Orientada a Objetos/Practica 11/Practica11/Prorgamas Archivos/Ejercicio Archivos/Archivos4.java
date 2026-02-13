import java.io.*;
import java.util.Scanner;

public class Archivos4 {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        ObjectOutputStream fileOut;
        TestObject testObject = new TestObject(1, "prueba 1", 2.0);
        TestObject testObject2 = new TestObject(2, "Cadena texta", 5.6);
        String filename;
        System.out.print("Introduzca el nombre del archivo: ");
        filename = stdIn.nextLine();
        try {
            fileOut = new ObjectOutputStream(new FileOutputStream(filename));
            fileOut.writeObject(testObject);
            fileOut.writeObject(testObject2);
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        stdIn.close();
    }
}
