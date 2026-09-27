/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Guille
 */
public class Validador {
    
    public static void main(String[] args) {
        String rutaArchivo = "datos_notas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            
            String linea;
            int numeroLinea = 1; //Variable almacenar la línea
            
            // Leo todas las líneas con este bucle
            while ((linea = br.readLine()) != null) {
                
                try {
                    // Intento convertir la línea a un double
                    double nota = Double.parseDouble(linea);
                    System.out.println("Línea " + numeroLinea + ": Nota registrada correctamente -> " + nota);
                    
                } catch (NumberFormatException e) {
                    System.err.println("Línea " + numeroLinea + ": No es un número válido. Se ignora.");
                }
                numeroLinea++;
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
