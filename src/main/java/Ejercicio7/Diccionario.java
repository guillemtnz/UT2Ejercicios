/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio7;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Guille
 */
public class Diccionario {
    
    public static void main(String[] args) {
        String nombreArchivo = "datos.dat";

        // Abro el archivo en modo rw (lec/escr)
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw")) {
            
            // Escribo 3 enteros consecutivos
            raf.writeInt(1); //bytes 0-3
            raf.writeInt(2); //bytes 4-7
            raf.writeInt(3); //bytes 8-11
            

            //Voy a la posición del segundo número y cambio su valor por 999
            raf.seek(4);
            raf.writeInt(999);

            //Ahora voy a leer 
            raf.seek(0); //Vamos a la primera posición
            
            for (int i = 1; i <= 3; i++) {
                // Leo 4 bytes y voy al siguiente
                int numero = raf.readInt();
                System.out.println("Número " + i + ": " + numero);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
}
