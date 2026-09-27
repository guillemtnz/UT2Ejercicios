/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Guille
 */
public class VerificadorEntornos {
    
    public static void main(String[] args) {
        
        String ruta = "C:/ficheros_dam";
        File carpeta = new File(ruta);
        
        try{
        
        if (carpeta.exists()){
            if (carpeta.isDirectory()){
                File[] contenido = carpeta.listFiles();
                int numArchivos = (contenido != null) ? contenido.length:0;
                
                System.out.println("El directorio ya existe");
                System.out.println("Contiene " + numArchivos + " elementos.");
            }
            else{
                System.out.println("Existe un elemento llamado así pero no es un directorio");
            }
        }
        else{
            System.out.println("La carpeta NO existe, a crearla");
        
            if (carpeta.mkdirs()) {
                System.out.println("Carpeta 'ficheros_dam' creada correctamente.");
                
                // Preparamos el archivo setup.log dentro de la carpeta
                File archivoLog = new File(carpeta, "setup.log");
                
                try {
                    // createNewFile() crea el archivo vacío
                    if (archivoLog.createNewFile()) {
                        System.out.println("Archivo 'setup.log' creado correctamente.");
                    } else {
                        System.out.println("El archivo 'setup.log' ya existía.");
                    }
                } catch (IOException e) {
                    System.out.println("Error al crear el archivo 'setup.log': " + e.getMessage());
                }
                
            } else {
                System.out.println("Error: No se pudo crear la carpeta.");
            }
        }    
    }catch(Exception e){
        System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
