package Ejercicio4;

import java.io.Serializable;
import java.util.Scanner;

public class Computadora implements Serializable {
    String Procesador;
    int memoria;
    int Ram;
    int FuentePoder;
    String PlacaMadre;
    String Propietario;
    static Scanner scanner = new Scanner(System.in);

    public Computadora() {
    }

    public Computadora(String Propietario, String Procesador, int memoria, int Ram, String PlacaMadre,
            int FuentePoder) {
        this.Propietario = Propietario;
        this.Procesador = Procesador;
        this.memoria = memoria;
        this.Ram = Ram;
        this.PlacaMadre = PlacaMadre;
        this.FuentePoder = FuentePoder;
    }

    public Computadora DameDatos() {
        System.out.println("Dime el nombre del propietario");
        Propietario = scanner.nextLine();
        System.out.println("Dime la marca del procesador");
        Procesador = scanner.nextLine();
        System.out.println("Dime la cantidad de memoria");
        memoria = scanner.nextInt();
        System.out.println("Dime la cantidad de Ram");
        Ram = scanner.nextInt();
        System.out.println("Dame la cantidad de watts de la fuente de poder");
        FuentePoder = scanner.nextInt();
        System.out.println("Dame la marca de la placa madre");
        scanner.nextLine();
        PlacaMadre = scanner.nextLine();
        Computadora Pc = new Computadora(Propietario, Procesador, memoria, Ram, PlacaMadre, FuentePoder);
        return Pc;
    }

    public void MostrarDatos() {
        System.out.println("El propietario de la computadora es: " + Propietario);
        System.out.println("La marca del procesador es: " + Procesador);
        System.out.println("La cantidad de memoria es: " + memoria);
        System.out.println("La cantidad de memoria ram es: " + Ram);
        System.out.println("La cantidad de watts de la fuente de poder son: " + FuentePoder);
        System.out.println("La marca de la placa madre es: " + PlacaMadre);
    }

    public void Cambio(String Procesador, int memoria, int Ram) {
        this.Procesador = Procesador;
        this.memoria = memoria;
        this.Ram = Ram;
    }

    public void Cambio(int FuentePoder, String PlacaMadre) {
        this.FuentePoder = FuentePoder;
        this.PlacaMadre = PlacaMadre;
    }

    public void Cambio(String Procesador, int Ram) {
        this.Procesador = Procesador;
        this.Ram = Ram;
    }
}