package Ejercicio4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ArrayList<Computadora> ListaComputadoras = new ArrayList<Computadora>();
        Scanner stdIn = new Scanner(System.in);
        String filename;
        int op;
        System.out.println("1)Consultar Computadoras en el archivo\n2)Agregar Primera vez");
        System.out.println("3)Actualizar Datos\n4)Agregar al archivo\n5)Eliminar");
        op = stdIn.nextInt();
        switch (op) {
            case 1:
                int indice = 1;
                try {
                    System.out.print("Introduzca la ruta del archivo: ");
                    stdIn.nextLine();
                    filename = stdIn.nextLine();
                    FileInputStream archivo = new FileInputStream(filename);
                    ObjectInputStream leer = new ObjectInputStream(archivo);
                    Computadora pcrecuperada;
                    pcrecuperada = (Computadora) leer.readObject();
                    try {
                        while (pcrecuperada != null) {
                            System.out.println("\nIndice de la computadora: " + indice);
                            pcrecuperada.MostrarDatos();
                            System.out.println("\n");
                            pcrecuperada = (Computadora) leer.readObject();
                            indice++;
                        }
                    } catch (EOFException e) {
                        System.out.println("El archivo a terminado");
                    }
                    leer.close();
                    archivo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.print("Introduzca la ruta del archivo: ");
                stdIn.nextLine();
                filename = stdIn.nextLine();
                ListaComputadoras = Practica4.main(args, 0);
                try {
                    FileOutputStream archivo = new FileOutputStream(filename);
                    ObjectOutputStream escribir = new ObjectOutputStream(archivo);
                    for (Computadora pc : ListaComputadoras) {
                        escribir.writeObject(pc);
                    }
                    escribir.close();
                    archivo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                ListaComputadoras = Practica4.main(args, 2);
                break;
            case 4:
                System.out.print("Introduzca la ruta del archivo: ");
                stdIn.nextLine();
                filename = stdIn.nextLine();
                ListaComputadoras = Practica4.main(args, 0);
                try {
                    FileOutputStream archivo = new FileOutputStream(filename, true);
                    AgregarContenido escribir = new AgregarContenido(archivo);
                    for (Computadora pc : ListaComputadoras) {
                        escribir.writeObject(pc);
                    }
                    escribir.close();
                    archivo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                int opcion = 4;
                Practica4.main(args, opcion);
                break;
            default:
                System.out.println("La opcion dada no es valida");
                break;
        }
        stdIn.close();
    }
}