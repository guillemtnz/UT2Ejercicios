/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

import java.io.File;

/**
 *
 * @author Guille
 */


public class OrganizadorProyectos {

    public static void main(String[] args) {
        
        //Definición de la ruta
        File carpetaAccesoDatos = new File("MurciaFP/2026/AccesoDatos");
        
        //Creación de la estructura de carpetas
        if (carpetaAccesoDatos.exists() || carpetaAccesoDatos.mkdirs()) {
            System.out.println("Estructura base lista.");

            File carpetaBackup = new File("MurciaFP/2026/AD_Backup");

            // 4. Renombro la carpeta
            if (carpetaAccesoDatos.renameTo(carpetaBackup)) {
                System.out.println("Carpeta renombrada a 'AD_Backup'.");
            } else {
                System.out.println("No se pudo renombrar.");
            }
            
        } else {
            System.out.println("No se ha podido crear la estructura de carpetas original.");
        }
    }
}
