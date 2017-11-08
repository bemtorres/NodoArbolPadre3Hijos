/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ded190553388;

import app.Perro;
import dao.DAOPerro;

/**
 *
 * @author Alumno
 */
public class DED190553388 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        pruebaDAOAgregarPorEdad();
    }

    private static void pruebaDAOAgregarPorEdad() {
        //  ************************  Modelo final  ****************************
        // Agregar de MAYOR A MENOR
        // Imprime todas las generaciones de Mayor a menos
        // Busca por id
        // Imprime todos los hijos reciciendo un nodo de padre que lo busca
        // 
        DAOPerro misPerritos = new DAOPerro();
        try {
            // Agregamos el abuelo perruno de todos
            misPerritos.addEdad(0, new Perro(1, "Spack", 30, "labrador"));
            // agregamos 3 hijos cachorros al abuelo perruno
            misPerritos.addEdad(1, new Perro(20, "firulais", 7, "labrador"));
            misPerritos.addEdad(1, new Perro(30, "Benja", 4, "labrador"));
            misPerritos.addEdad(1, new Perro(40, "jack", 10, "labrador"));
            //agregarmos los nietos perrunos
            misPerritos.addEdad(20, new Perro(201, "juanin", 4, "labrador"));
            misPerritos.addEdad(20, new Perro(202, "jose", 1, "labrador"));

            misPerritos.addEdad(30, new Perro(301, "miguel", 3, "labrador"));
            misPerritos.addEdad(30, new Perro(302, "Terremoto", 2, "labrador"));

            misPerritos.addEdad(40, new Perro(401, "Tsunami", 7, "labrador"));
            //Agregamos bi nietos perrunos
            misPerritos.addEdad(201, new Perro(2011, "Albo", 2, "labrador"));
            misPerritos.addEdad(201, new Perro(2012, "Cruzado", 3, "labrador"));
            misPerritos.addEdad(201, new Perro(2013, "BuhuoAzul", 1, "labrador"));

        } catch (Exception ex) {
            System.out.println("Error al cargar cachorritos " + ex.getMessage());
        }
        System.out.println("************************************");
        System.out.println("Imprime todas las generaciones de Edad Mayor a Menor");
        misPerritos.imprimir();
        System.out.println("************************************");
        System.out.println(" Buscar por id: 30");
        System.out.println(misPerritos.buscarId(30));
        System.out.println(" Buscar por id: 2011");
        System.out.println(misPerritos.buscarId(2011));
        System.out.println("************************************");
        System.out.println(" Imprimir cachorritos de 20 (incluye a perrito id 20) ");
        misPerritos.imprimirHijos(misPerritos.buscarId(20));
        System.out.println("************************************");
        System.out.println(" Imprimir toda la generacion 20 (incluye a perrito id 20)");
        misPerritos.imprimir(misPerritos.buscarId(20));
        System.out.println(" *****************************************");

    }

}
