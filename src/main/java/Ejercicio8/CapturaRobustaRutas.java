/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Guille
 */
public class CapturaRobustaRutas {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la ruta de un archivo: ");
        String rutaArchivo = sc.nextLine();

        //Intento abrir el archivo
        try (FileReader fr = new FileReader(rutaArchivo)) {
            
            System.out.println("Archivo abierto");
            

        } catch (FileNotFoundException e) {
            System.err.println("\nNo se ha encontrado el archivo");
            
        } catch (IOException e) {
            System.err.println("Error de lectura/escritura" + e.getMessage());
            
        } finally {
            // Cierro el scanner
            sc.close();
            System.out.println("\nCerrando el programa. ¡Hasta pronto!");
        }
    }
    
}
