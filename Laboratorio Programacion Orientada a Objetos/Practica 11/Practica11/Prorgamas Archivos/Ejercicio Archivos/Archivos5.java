import java.io.*;
import java.util.Scanner;

public class Archivos5 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        ObjectInputStream fileIn;
        TestObject testObject, testObject2;
        System.out.print("Introduzca el nombre del archivo: ");
        try {
            fileIn = new ObjectInputStream(new FileInputStream(stdIn.nextLine()));
            testObject = (TestObject) fileIn.readObject();
            testObject.display();
            testObject2 = (TestObject) fileIn.readObject();
            testObject2.display();
            fileIn.close();
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound " + e.getMessage());
        }
        stdIn.close();
    }
}
