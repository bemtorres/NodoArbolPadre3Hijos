/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import app.Perro;

/**
 *
 * @author Alumno
 */
public class DAOPerro {

    private Perro raiz;

    public void imprimir() {
        imprimir(raiz, "  ");
    }

    public void imprimir(Perro aux) {
        imprimir(aux, "  ");
    }

    public void imprimir(Perro aux, String blancos) {
        if (aux == null) {
            return;
        }
        System.out.print(blancos);
        aux.imprimir();
        imprimir(aux.hijo1, blancos + " Cachorro1    ");
        imprimir(aux.hijo2, blancos + " Cachorro2    ");
        imprimir(aux.hijo3, blancos + " Cachorro3    ");
    }

    //Agrega de forma normal los parametros que se ingresan, no los ordena
    public boolean add(int idPadre, Perro perro) throws Exception {
        if (raiz == null) {
            raiz = perro;
            return true;
        }
        return add(raiz, idPadre, perro);
    }

    private boolean add(Perro aux, int idPadre, Perro perro) throws Exception {
        if (aux == null) {
            return false;
        }
        if (aux.getId() == idPadre) {

            if (aux.hijo1 == null) {
                aux.hijo1 = perro;
                return true;
            }
            if (aux.hijo2 == null) {
                aux.hijo2 = perro;
                return true;
            }
            if (aux.hijo3 == null) {
                aux.hijo3 = perro;
                return true;
            }
            throw new Exception("No Existen Más cupos");
        }
        if (add(aux.hijo1, idPadre, perro)) {
            return true;
        }
        if (add(aux.hijo2, idPadre, perro)) {
            return true;
        }
        if (add(aux.hijo3, idPadre, perro)) {
            return true;
        }
        return false;
    }

    //Ordena la edad de MAYOR A MENOR
    public boolean addEdad(int idPadre, Perro perro) throws Exception {
        if (raiz == null) {
            raiz = perro;
            return true;
        }
        return addEdad(raiz, idPadre, perro);
    }
    
    //Ordena la edad de MAYOR A MENOR    
    private boolean addEdad(Perro aux, int idPadre, Perro perro) throws Exception {
        if (aux == null) {
            return false;
        }
        if (aux.getId() == idPadre) {

            if (aux.hijo1 == null) {
                aux.hijo1 = perro;
                return true;
            }
            if (aux.hijo2 == null) { //condiciones de borde para cada posicion
                if (aux.hijo1.getEdad() > perro.getEdad()) {
                    aux.hijo2 = aux.hijo1;
                    aux.hijo1 = perro;
                    return true;
                } else {
                    aux.hijo2 = perro;
                    return true;
                }
            }
            if (aux.hijo3 == null) {
                if (aux.hijo1.getEdad() > perro.getEdad()) {
                    aux.hijo3 = aux.hijo2;
                    aux.hijo2 = aux.hijo1;
                    aux.hijo1 = perro;
                    return true;
                } else {
                    if (aux.hijo2.getEdad() > perro.getEdad()) {
                        aux.hijo3 = aux.hijo2;
                        aux.hijo2 = perro;
                        return true;
                    } else {
                        aux.hijo3 = perro;
                        return true;
                    }
                }
            }
            throw new Exception("No existen mas cupos :´c");
        }
        if (add(aux.hijo1, idPadre, perro)) {
            return true;
        }
        if (add(aux.hijo2, idPadre, perro)) {
            return true;
        }
        if (add(aux.hijo3, idPadre, perro)) {
            return true;
        }
        return false;
    }

    public Perro buscarId(int id) {
        return buscarId(raiz, id);
    }

    public Perro buscarId(Perro aux, int id) {
        if (aux == null) {
            return null;
        }
        if (aux.getId() == id) {
            return aux;
        }

        Perro cachorro1 = buscarId(aux.hijo1, id);
        if (cachorro1 != null) {
            return cachorro1;
        }

        Perro cachorro2 = buscarId(aux.hijo2, id);
        if (cachorro2 != null) {
            return cachorro2;
        }

        Perro cachorro3 = buscarId(aux.hijo3, id);
        if (cachorro3 != null) {
            return cachorro3;
        }

        return null;
    }

    public void imprimirHijos(Perro aux) {
        if (aux == null) {
            return;
        }
        aux.imprimir();
        if (aux.hijo1 != null) {
            System.out.print(" Cachorro 1 ");
            aux.hijo1.imprimir();
        }
        if (aux.hijo2 != null) {
            System.out.print(" Cachorro 2 ");
            aux.hijo2.imprimir();
        }
        if (aux.hijo3 != null) {
            System.out.print(" Cachorro 3 ");
            aux.hijo3.imprimir();
        }
    }
    
    //Agrega ordenando de Menor A Mayor
    public boolean addMenorMayor(int idPadre, Perro perro) throws Exception {
        if (raiz == null) {
            raiz = perro;
            return true;
        }
        return add(raiz, idPadre, perro);
    }

    private boolean addMenorMayor(Perro aux, int idPadre, Perro perro) throws Exception {
        if (aux == null) {
            return false;
        }
        if (aux.getId() == idPadre) {

            if (aux.hijo1 == null) {
                aux.hijo1 = perro;
                return true;
            }
            if (aux.hijo2 == null) { //condiciones de borde para cada posicion
                if (aux.hijo1.getEdad() < perro.getEdad()) {
                    aux.hijo2 = aux.hijo1;
                    aux.hijo1 = perro;
                    return true;
                } else {
                    aux.hijo2 = perro;
                    return true;
                }
            }
            if (aux.hijo3 == null) {
                if (aux.hijo1.getEdad() < perro.getEdad()) {
                    aux.hijo3 = aux.hijo2;
                    aux.hijo2 = aux.hijo1;
                    aux.hijo1 = perro;
                    return true;
                } else {
                    if (aux.hijo2.getEdad() < perro.getEdad()) {
                        aux.hijo3 = aux.hijo2;
                        aux.hijo2 = perro;
                        return true;
                    } else {
                        aux.hijo3 = perro;
                        return true;
                    }
                }
            }
            throw new Exception("No existen mas cupos :´c");
        }
        if (add(aux.hijo1, idPadre, perro)) {
            return true;
        }
        if (add(aux.hijo2, idPadre, perro)) {
            return true;
        }
        if (add(aux.hijo3, idPadre, perro)) {
            return true;
        }
        return false;
    }

}
