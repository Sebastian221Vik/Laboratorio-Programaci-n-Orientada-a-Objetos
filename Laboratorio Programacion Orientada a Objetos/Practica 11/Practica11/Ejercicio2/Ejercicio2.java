package Ejercicio2;

import java.io.*;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        int op;
        boolean salir = false;
        String ruta;
        File archivo;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(" \n1)Crear archivo\n2)Abrir archivo\n3)Editar archivo");
            System.out.println("4)Salir");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Ingrese la ruta de creacion del archivo");
                    scanner.nextLine();
                    ruta = scanner.nextLine();
                    archivo = new File(ruta);
                    try {
                        PrintWriter salida = new PrintWriter(archivo);
                        System.out.println("El archivo se ha creado");
                        salida.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("El archivo no se pudo crear");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la ruta del archivo a editar");
                    scanner.nextLine();
                    ruta = scanner.nextLine();
                    archivo = new File(ruta);
                    try {
                        BufferedReader en = new BufferedReader(new FileReader(archivo));
                        String leer = en.readLine();
                        while (leer != null) {
                            System.out.println(leer);
                            leer = en.readLine();
                        }
                        en.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace(System.out);
                    } catch (IOException e) {
                        e.printStackTrace(System.out);
                    }
                    break;
                case 3:
                    String agregar;
                    System.out.println("Ingrese la ruta del archivo a editar");
                    scanner.nextLine();
                    ruta = scanner.nextLine();
                    archivo = new File(ruta);
                    System.out.println("Escriba el texto a agregar");
                    agregar = scanner.nextLine();
                    try {
                        PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
                        salida.println(agregar);
                        salida.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("No se pudo editar el archivo");
                    } catch (IOException e) {
                        System.out.println("No se pudo escribir en el documento");
                    }
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("La opcion dada no es valida");
                    break;
            }
        } while (salir == false);
        scanner.close();
    }
}
