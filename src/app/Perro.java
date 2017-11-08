/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Alumno
 */
public class Perro {
    private int id;
    private String nombre;
    private int edad;
    private String raza;
    
    public Perro hijo1;
    public Perro hijo2;
    public Perro hijo3;

    public Perro(int id, String nombre, int edad, String raza) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    public Perro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Perro:   id:" + id + ", Nombre:" + nombre + ", edad:" + edad + " años, raza:" + raza;
    }
    
    public void imprimir(){
        System.out.println(this.toString());
    }
}
