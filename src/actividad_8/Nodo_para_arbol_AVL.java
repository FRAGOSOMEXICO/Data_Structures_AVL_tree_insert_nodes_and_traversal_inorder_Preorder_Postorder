/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad_8;

/**
 *
 * @author biosh
 */
public class Nodo_para_arbol_AVL 
{

 private int Factor_de_equilibrio;
 private double dato_double;
    Nodo_para_arbol_AVL hijoIzquierdo;
    Nodo_para_arbol_AVL hijoDerecho;

    /*CONSTRUCTOR DE NODO ARBOL*/
    public Nodo_para_arbol_AVL(double double_nodo) {
        this.dato_double = double_nodo;
        this.hijoIzquierdo = null;
        /*SON LOS NODOS HOJA QUE SERAN HIJOS DEL NODO ACTUAL */
        this.hijoDerecho = null;
        this.Factor_de_equilibrio=0;
    }

    public String mostrar_string_con_num_dato() {
        return "El nodo tiene a '" + dato_double + "' como dato ";
    }

    /**
     * @return the dato
     */
    public double getDato() {
        return dato_double;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(double dato_doble) {
        this.dato_double = dato_doble;
    }

    public Nodo_para_arbol_AVL getHijoIzquierdo() {
        return hijoIzquierdo;
    }

 
    public void setHijoIzquierdo(Nodo_para_arbol_AVL nodo_hijo_izq) {
        this.hijoIzquierdo = nodo_hijo_izq;
    }

   
    public Nodo_para_arbol_AVL getHijoDerecho() {
        return hijoDerecho;
    }

   
    public void getHijoDerecho(Nodo_para_arbol_AVL nodo_hijo_der) {
        this.hijoDerecho = nodo_hijo_der;
    }    
    /**
     * @return the Factor_de_equilibrio
     */
    public int getFactor_de_equilibrio() {
        return Factor_de_equilibrio;
    }

    /**
     * @param Factor_de_equilibrio the Factor_de_equilibrio to set
     */
    public void setFactor_de_equilibrio(int Factor_de_equilibrio) {
        this.Factor_de_equilibrio = Factor_de_equilibrio;
    }
}
