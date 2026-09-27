/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Guille
 */
public class ContadorCaracteres {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        String archivo = "quijote.txt"; //archivo en el que busca
        String palabra = "Quijote";  //palabra a buscar
        
        //contadores
        int numLineas = 0;
        int numQuijote = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            // Voy leyendo línea a línea el archivo
            while ((linea = br.readLine()) != null) {
                numLineas++;

                // Busco cuántas veces aparece Quijote en cada línea. 
                //Para ello me defino una variable auxiliar para contar el número Quijotes en cada línea para después sumarlos al contador.
                /*
                Lo que hace el bucle en la primera vuelta es buscar la palabra en la línea, si encuentra la palabra guarda la posición en aux, y aumenta numQuijote
                En la segunda, vuelve a buscar en la posición en la que se quedó por si hubiera más Quijotes antes de pasar a la siguiente línea
                Si llega al fin de la línea el indexOf devuelve -1, por lo que no entra en el segundo while y pasa a la siguiente línea
                */
                int aux = 0;
                while ((aux = linea.indexOf(palabra, aux)) != -1) {
                    numQuijote++;
                    aux += palabra.length(); // Avanzar el índice para buscar la siguiente repetición
                }
            }
            
            System.out.println("Líneas totales: " + numLineas);
            System.out.println("Veces que aparece '" + palabra + "': " + numQuijote);
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
