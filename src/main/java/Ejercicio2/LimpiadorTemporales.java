/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Guille
 */
public class LimpiadorTemporales {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Pido  al usuario que introduzca la ruta
        System.out.print("Introduce la ruta de la carpeta donde buscar: ");
        String rutaUsuario = sc.nextLine();

        //Creo el objeto File apuntando al archivo temp.bak en esa ruta
        File archivoTemporal = new File(rutaUsuario, "temp.bak");

        //Verifico si existe y si es un archivo (no una carpeta)
        if (archivoTemporal.exists() && archivoTemporal.isFile()) {
            
            // A borrar
            if (archivoTemporal.delete()) {
                System.out.println("El archivo 'temp.bak' ha sido eliminado.");
            } else {
                System.out.println("Error: El archivo existe pero no se pudo borrar.");
            }
            
        } else {
            // Aviso si no existe
            System.out.println("No se ha encontrado ningún archivo 'temp.bak' en la ruta indicada.");
        }

        // Cierro el scanner
        sc.close();
    }
    
}
