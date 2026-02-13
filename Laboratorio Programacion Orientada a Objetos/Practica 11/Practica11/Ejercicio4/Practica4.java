package Ejercicio4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Practica4 {
    public static ArrayList<Computadora> main(String[] args, int op) throws ClassNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        int opcion = op;
        String Procesador, PlacaMadre;
        int memoria, Ram, FuentePoder;
        Computadora Pc = new Computadora();
        ArrayList<Computadora> ListaComputadoras = new ArrayList<Computadora>();
        do {
            if (op == 0) {
                System.out.println("Estas son las opciones de la lista de computadoras internas");
                System.out.println("Por lo que no modifica las del archivo");
                System.out.println("\nPresiona 1) Para Crear una computadora");
                System.out.println("Presiona 2) Para Modificar una computadora");
                System.out.println("Presiona 3) Para Ver computadoras actuales");
                System.out.println("Presiona 4) Para Eliminar una computadora");
                System.out.println("Presiona 5) Terminar");
                opcion = scanner.nextInt();
            }
            switch (opcion) {
                case 1:
                    System.out.println("\nElegiste crear una nueva computadora\n");
                    Computadora Pc2 = Pc.DameDatos();
                    ListaComputadoras.add(Pc2);
                    break;
                case 2:
                    Scanner stdIn2 = new Scanner(System.in);
                    ArrayList<Computadora> Pcs2 = new ArrayList<>();
                    System.out.println("\nElegiste Modificar una computadora\n");
                    System.out.print("Introduzca la ruta del archivo para eliminar Computadora: ");
                    String filename2 = stdIn2.nextLine();
                    FileInputStream archivo2 = new FileInputStream(filename2);
                    ObjectInputStream leer2 = new ObjectInputStream(archivo2);
                    Computadora pcrecuperada2;
                    pcrecuperada2 = (Computadora) leer2.readObject();
                    try {
                        while (pcrecuperada2 != null) {
                            Pcs2.add(pcrecuperada2);
                            pcrecuperada2 = (Computadora) leer2.readObject();
                        }
                    } catch (EOFException e) {
                        System.out.println("El archivo se leyo");
                    }
                    leer2.close();
                    archivo2.close();
                    System.out.println("Dame el indice de la Computadora a modificar");
                    int modificar = scanner.nextInt();
                    int modi;
                    do {
                        System.out.println("Opciones de modificacion: ");
                        System.out.println("Presiona 1) Para Modificar El Procesador, Memoria y Ram");
                        System.out.println("Presiona 2) Para Modificar La Fuente de Poder y Placa Madre");
                        System.out.println("Presiona 3) Para Modificar El Procesador y Ram");
                        System.out.println("Presiona 4) Para terminar las modificaciones");
                        modi = scanner.nextInt();
                        switch (modi) {
                            case 1:
                                scanner.nextLine();
                                System.out.println("Dime la marca del procesador");
                                Procesador = scanner.nextLine();
                                System.out.println("Dime la cantidad de memoria");
                                memoria = scanner.nextInt();
                                System.out.println("Dime la cantidad de Ram");
                                Ram = scanner.nextInt();
                                Pcs2.get(modificar - 1).Cambio(Procesador, memoria, Ram);
                                break;
                            case 2:
                                System.out.println("Dame la cantidad de watts de la fuente de poder");
                                FuentePoder = scanner.nextInt();
                                System.out.println("Dame la marca de la placa madre");
                                scanner.nextLine();
                                PlacaMadre = scanner.nextLine();
                                Pcs2.get(modificar - 1).Cambio(FuentePoder, PlacaMadre);
                                break;
                            case 3:
                                scanner.nextLine();
                                System.out.println("Dime la marca del procesador");
                                Procesador = scanner.nextLine();
                                System.out.println("Dime la cantidad de Ram");
                                Ram = scanner.nextInt();
                                Pcs2.get(modificar - 1).Cambio(Procesador, Ram);
                        }
                    } while (modi != 4);
                    FileOutputStream archivo3 = new FileOutputStream(filename2);
                    ObjectOutputStream escribir3 = new ObjectOutputStream(archivo3);
                    for (Computadora pc : Pcs2) {
                        escribir3.writeObject(pc);
                    }
                    escribir3.close();
                    archivo3.close();
                    stdIn2.close();
                    opcion = 5;
                    break;
                case 3:
                    System.out.println("\nElegiste Ver computadoras actuales: \n");
                    int i = 0;
                    for (Computadora elemento : ListaComputadoras) {
                        System.out.println("El indice de la Pc es: " + i);
                        elemento.MostrarDatos();
                        System.out.println();
                        i++;
                    }
                    break;
                case 4:
                    System.out.println("\nElegiste Eliminar una computadora\n");
                    Scanner stdIn = new Scanner(System.in);
                    ArrayList<Computadora> Pcs = new ArrayList<>();
                    String filename = null;
                    try {
                        int indice = 1;
                        System.out.print("Introduzca la ruta del archivo para eliminar Computadora: ");
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
                                Pcs.add(pcrecuperada);
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
                    System.out.println("Dame el indice de la Computadora a eliminar");
                    int borrar = scanner.nextInt();
                    Pcs.remove(borrar - 1);
                    System.out.println("La computadora fue eliminada.");
                    FileOutputStream archivo = new FileOutputStream(filename);
                    ObjectOutputStream escribir = new ObjectOutputStream(archivo);
                    for (Computadora pc : Pcs) {
                        escribir.writeObject(pc);
                    }
                    escribir.close();
                    archivo.close();
                    stdIn.close();
                    opcion = 5;
                    break;
                case 5:
                    break;
                default:
                    System.out.println("La opcion no es valida");
                    break;
            }
        } while (opcion != 5);
        scanner.close();
        return ListaComputadoras;
    }

}
