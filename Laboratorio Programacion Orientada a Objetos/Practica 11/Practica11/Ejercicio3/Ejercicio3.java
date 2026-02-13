package Ejercicio3;

import java.io.*;
import java.util.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        int op;
        String ruta;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" \n1)De txt a binario\n2)De binario a txt");
        op = scanner.nextInt();
        Scanner stdIn = new Scanner(System.in);
        switch (op) {
            case 1:
                Scanner fileIn;
                String line;
                try {
                    System.out.print("Introduzca la ruta del archivo de texto a convertir: ");
                    fileIn = new Scanner(new FileReader(stdIn.nextLine()));
                    scanner.nextLine();
                    System.out.println("Ingrese la ruta a guardar el archivo binario con su nombre");
                    ruta = scanner.nextLine();
                    FileOutputStream archivo2 = new FileOutputStream(ruta);
                    BufferedOutputStream escribir = new BufferedOutputStream(archivo2);
                    while (fileIn.hasNextLine()) {
                        line = fileIn.nextLine();
                        escribir.write(line.getBytes());
                        escribir.write("\n".getBytes());
                    }
                    System.out.println("Texto convertido a binario con exito");
                    escribir.close();
                    fileIn.close();
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                stdIn.close();
                break;
            case 2:
                String lines = null;
                try {
                    System.out.println("Ingrese la ruta del archivo binario a convertir");
                    scanner.nextLine();
                    ruta = scanner.nextLine();
                    System.out.print("Introduzca la ruta donde guardar el archivo de texto: ");
                    File archivotxt = new File(stdIn.nextLine());
                    FileWriter escribir2 = new FileWriter(archivotxt);
                    BufferedWriter buf = new BufferedWriter(escribir2);
                    PrintWriter prin = new PrintWriter(buf);
                    FileInputStream archivo2 = new FileInputStream(ruta);
                    BufferedInputStream escribir = new BufferedInputStream(archivo2);
                    byte[] contenedor = new byte[1024];
                    int leidos = 0;
                    while ((leidos = escribir.read(contenedor)) != -1) {
                        lines = new String(contenedor, 0, leidos);
                        prin.write(lines);
                        prin.append("\n");
                    }
                    System.out.println("Binario convertido a texto con exito");
                    escribir.close();
                    prin.close();
                    buf.close();
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                stdIn.close();
                break;
            default:
                System.out.println("La opcion dada no es valida");
                break;
        }
        scanner.close();
    }
}
