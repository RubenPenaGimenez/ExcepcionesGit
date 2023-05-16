/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Parking.Parking;
import java.util.Scanner;

/**
 *
 * @author rubenpengim
 */
public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking("Parking Centro", 10);
        Scanner scanner = new Scanner(System.in);
        
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("Menú de opciones:");
            System.out.println("1) Entrada de coche");
            System.out.println("2) Salida de coche");
            System.out.println("3) Mostrar parking");
            System.out.println("4) Salir del programa");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        System.out.print("Introduzca la matrícula del coche: ");
                        String matriculaEntrada = scanner.nextLine();
                        System.out.print("Introduzca la plaza donde se colocará: ");
                        int plazaEntrada = Integer.parseInt(scanner.nextLine());
                        
                        try {
                            parking.entrada(matriculaEntrada, plazaEntrada);
                            System.out.println("Coche introducido correctamente.");
                            System.out.println("Plazas totales: " + parking.getPlazasTotales());
                            System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
                            System.out.println("Plazas libres: " + parking.getPlazasLibres());
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        
                        break;

                    case 2:
                        System.out.print("Introduzca la matrícula del coche que sale: ");
                        String matriculaSalida = scanner.nextLine();
                        
                        try {
                            int plazaLiberada = parking.salida(matriculaSalida);
                            System.out.println("Coche salió de la plaza " + plazaLiberada);
                            System.out.println("Plazas totales: " + parking.getPlazasTotales());
                            System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
                            System.out.println("Plazas libres: " + parking.getPlazasLibres());
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        
                        break;

                    case 3:
                        System.out.println(parking.toString());
                        break;
                    case 4:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Introduzca un número entre 1 y 4.");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduzca un número válido.");
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
}
