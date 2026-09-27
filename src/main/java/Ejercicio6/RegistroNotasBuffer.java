/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Guille
 */
public class RegistroNotasBuffer {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = "calificaciones.txt";

        //'true' en FileWriter para que se abra en modo append
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            
            for (int i = 1; i <= 3; i++) {
                System.out.print("Introduzca el nombre del alumno " + i + ": ");
                String nombre = sc.nextLine();
                
                System.out.print("Introduzca la nota de " + nombre + ": ");
                String nota = sc.nextLine(); 
                
                
                bw.write("Alumno: " + nombre + " - Nota: " + nota);
                bw.newLine(); //Salto de linea
            }
            
            System.out.println("\n Los datos se han guardado correctamente en '" + nombreArchivo + "'.");
            
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
    
}
