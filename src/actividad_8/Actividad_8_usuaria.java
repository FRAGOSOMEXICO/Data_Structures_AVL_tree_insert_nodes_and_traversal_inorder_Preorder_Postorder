/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad_8;
import com.sun.org.apache.xerces.internal.dom.AbortException;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.JOptionPane;

    

import java.util.ArrayList;
public class Actividad_8_usuaria
{


    /**
     * @return the permiso
     */
    public boolean isPermiso() {
        return permiso;
    }

    /**
     * @param permiso the permiso to set
     */
    public void setPermiso(boolean permiso) {
        this.permiso = permiso;
    }

    private static double raiz_anterior;
    private boolean permiso;
    private static int noElemento ;
    private static ArrayList<Double> guarda_raices =new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    
        public static void main(String[] args) {
        Arbol_tipo_AVL arbol_avl = new Arbol_tipo_AVL();
        int opcion = 0, pocision_2 = 0, nuevoInteger2 = 0,sustituto_de_integer=0,numero_de_raiz_agregada = 0;
        double nuevoDouble;
        
        String nuevoDouble_1=null;
        nuevoDouble =0.0; /*初期化*/
        Scanner ingreso = new Scanner(System.in);
        String eleccion;

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar un elemento DOUBLE al arbol AVL "
                        + "\n2. Recorrer arbol AVL PreOrden"
                        + "\n3. Recorrer arbol AVL PostOrden"
                        + "\n4. Recorrer arbol AVL InOrden"
                        + "\n5. Buscar elemento en arbol AVL"        
                        + "\n6.  Salir ", " (◕‿‿◕｡) MENU DE OPCIONES (◕‿‿◕｡)",1));
                switch (opcion) {
                    case 1:
                        eleccion = null;
                     
                        try {
                           
                           nuevoDouble= Double.parseDouble(JOptionPane.showInputDialog(
                                    "1 Ingresar el dato numerico de tipo double del nodo a agregar\"",3));
                                   /* Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "1 Ingresar el dato numerico del nodo a agregar\"", 3));*/
                             } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
                        }
                        /*SABER SI ESTA O NO*/
                        if (arbol_avl.arbolVacio()) {
                            arbol_avl.inserta(nuevoDouble,arbol_avl);
                           
                            setNoElemento(getNoElemento() + 1);
                            System.out.println("____________");
                            arbol_avl.recorrerArbol(arbol_avl.getRaiz()); 
                            System.out.println("____________Muestra numero " + getNoElemento() + " del AVL tree ____________");

                        } else {
                          
                             if (arbol_avl.busca(nuevoDouble,arbol_avl.getRaiz(),arbol_avl)== null) 
                            {
                               arbol_avl.inserta(nuevoDouble,arbol_avl);
                                setNoElemento(getNoElemento() + 1);
                                System.out.println("____________");
                                arbol_avl.recorrerArbol(arbol_avl.getRaiz());
                                System.out.println("____________Muestra numero " + getNoElemento() + " de la lista ____________");
                            } else {
                                JOptionPane.showMessageDialog(null, "El dato tipo double "+nuevoDouble+" ya existe en el arbol\"");

                            }

                        }
                       guarda_raices.add(numero_de_raiz_agregada,arbol_avl.getRaiz().getDato());
                       
                       if(guarda_raices.size()>1&&!guarda_raices.get(numero_de_raiz_agregada-1).equals(arbol_avl.getRaiz().getDato()))
                       {
                           System.out.println(" La raiz ha cambiado ,antes era "+guarda_raices.get(numero_de_raiz_agregada-1)
                                   + "\n ahora la raiz es "+guarda_raices.get(numero_de_raiz_agregada)
                                   +"\n____________________________________________________________________________"        );
                       }else
                       {
                       System.out.println(" la raiz es "+arbol_avl.getRaiz().getDato()+
                       
                               "\n____________________________________________________________________________" );
                           
                       }
                  
                       numero_de_raiz_agregada++;
                        break;
                    case 2:
                       /* RECORRE ARBOL AVL PREORDEN"*/
                        if(!arbol_avl.arbolVacio()){
                        setNoElemento(getNoElemento() + 1);
                        System.out.println("\n_______ Recorrido PreOrder_______"); 
                        System.out.println("____________");
                        arbol_avl.recorridoPreOrden(arbol_avl.getRaiz());
                        System.out.println("____________Muestra numero " + getNoElemento() + " del AVL tree ____________");
                            
                        }else{
                        JOptionPane.showMessageDialog(null, "El arbol esta vacio", "V A C I O", 2);
                    }
                        break;
                    case 3:
                        /*  RECORRE ARBOL AVL POSTORDEN */
                        if(!arbol_avl.arbolVacio()){
                         setNoElemento(getNoElemento() + 1);
                        System.out.println("\n_______ Recorrido PostOrder_______"); 
                        System.out.println("____________");
                        arbol_avl.recorridoPostOrden(arbol_avl.getRaiz());
                        System.out.println("____________Muestra numero " + getNoElemento() + " del AVL tree ____________");
                        }else{
                        JOptionPane.showMessageDialog(null, "El arbol esta vacio", "V A C I O", 2);
                    }
                        break;
                     case 4:
                        /*   RECORRE ARBOL AVL INORDER*/
                    if(!arbol_avl.arbolVacio()){
                       setNoElemento(getNoElemento() + 1);
                       System.out.println("\n_______ Recorrido PreOrder_______"); 
                       arbol_avl.recorrerArbol(arbol_avl.getRaiz());
                       System.out.println("____________");
                        System.out.println("____________Muestra numero " + getNoElemento() + " del AVL tree ____________");
                       }else{
                        JOptionPane.showMessageDialog(null, "El arbol esta vacio", "V A C I O", 2);
                    }
                        break;
                    case 5:
                        try {
                            
                            nuevoDouble = Double.parseDouble(JOptionPane.showInputDialog(null,
                                    "1 Ingresar el dato numerico de tipo double del nodo a buscar\""));
                                   /* Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "1 Ingresar el dato numerico del nodo a agregar\"", 3));*/
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
                        }
                        /*SABER SI ESTA O NO*/
                        if (arbol_avl.arbolVacio()) {
                               JOptionPane.showMessageDialog(null, "El arbol AVL esta vacio \"");

                        } else {
                            if (arbol_avl.busca(nuevoDouble,arbol_avl.getRaiz(),arbol_avl) == null) 
                            {
                               JOptionPane.showMessageDialog(null, "El dato double "+nuevoDouble+ " no se encuentra en el arbol AVL \"");
                            } else 
                            {
                               JOptionPane.showMessageDialog(null, "El dato double "+nuevoDouble+" si se encuentra en el arbol AVL\"");
                            }
                           }
                        break;
                    case 6:
                        System.exit(0);
                        break;
                }
            } catch (Exception n) {
                JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
            }
        } while (opcion != 6);

    }

    /**
     * @return the noElemento
     */
    public static int getNoElemento() {
        return noElemento;
    }

    /**
     * @param aNoElemento the noElemento to set
     */
    public static void setNoElemento(int aNoElemento) {
        noElemento = aNoElemento;
    }

    /**
     * @return the raiz_anterior
     */
    public static double getRaiz_anterior() {
        return raiz_anterior;
    }

    /**
     * @param aRaiz_anterior the raiz_anterior to set
     */
    public static void setRaiz_anterior(double aRaiz_anterior) {
        raiz_anterior = aRaiz_anterior;
    }

}
