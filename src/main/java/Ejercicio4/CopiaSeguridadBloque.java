/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Guille
 */
public class CopiaSeguridadBloque {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String archivoOrigen = "logo.png";
        String archivoDestino = "copia_logo.png";

        try (FileInputStream fis = new FileInputStream(archivoOrigen); FileOutputStream fos = new FileOutputStream(archivoDestino)) {

            int byteLeido;


            // El método read() devuelve -1 cuando alcanza el final del archivo
            while ((byteLeido = fis.read()) != -1) {
                fos.write(byteLeido);
            }

            System.out.println("Se ha copiado");

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
