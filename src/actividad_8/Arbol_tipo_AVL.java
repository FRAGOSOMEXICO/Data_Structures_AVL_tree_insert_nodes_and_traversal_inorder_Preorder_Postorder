/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad_8;

import javax.swing.JOptionPane;

/**
 *
 * @author biosh
 */
public class Arbol_tipo_AVL 
{

    /**
     * @return the si_es_simple_rotation
     */
    public boolean isSi_es_simple_rotation() {
        return si_es_simple_rotation;
    }

    /**
     * @param si_es_simple_rotation the si_es_simple_rotation to set
     */
    public void setSi_es_simple_rotation(boolean si_es_simple_rotation) {
        this.si_es_simple_rotation = si_es_simple_rotation;
    }

    /**
     * @return the si_es_doble_rotation
     */
    public boolean isSi_es_doble_rotation() {
        return si_es_doble_rotation;
    }

    /**
     * @param si_es_doble_rotation the si_es_doble_rotation to set
     */
    public void setSi_es_doble_rotation(boolean si_es_doble_rotation) {
        this.si_es_doble_rotation = si_es_doble_rotation;
    }
  private boolean si_es_simple_rotation,si_es_doble_rotation;  
  private int si_es_simple_rotation_insertasub,si_es_doble_rotation_insertasub;
  private Nodo_para_arbol_AVL raiz;
  /*CONSTRUCTOR PARA ARBOL*/
  public Arbol_tipo_AVL ()
  {
   raiz=null;    
  }
  public Nodo_para_arbol_AVL saber_nuestra_raiz()
  {
      return getRaiz();
  }
   public boolean arbolVacio() 
   {
        return getRaiz() == null;
   }

    public Nodo_para_arbol_AVL busca (double integer_a_buscar ,Nodo_para_arbol_AVL avl_tree_node,Arbol_tipo_AVL avl_tree)
    {
        if(avl_tree.getRaiz()==null)/* empty avl tree*/
        {
            return null;
        }
        else if(avl_tree_node.getDato()==integer_a_buscar)
        {
            return avl_tree_node;
        }
        else if(avl_tree_node.getDato()<integer_a_buscar)/*SI EL INTEGER A BUSCAR ES MAYOR ,PUEDE ESTAR EN EL NODO DERECHO*/
        {   /*DEBE BUSCAR EN HIJO DERECHO*/
           if(avl_tree_node.getHijoDerecho()!=null)/*SI NO SE HACE ESTE IF ,SUCEDE UN ERROR*/
           {
           return busca(integer_a_buscar, avl_tree_node.getHijoDerecho(),avl_tree);
           }
            
        }
         else /*SI EL INTEGER A BUSCAR ES MENOR ,PUEDE ESTAR EN EL NODO IZQUIERDO*/
        {   /*DEBE BUSCAR EN HIJO IZQUIERDO*/
            if(avl_tree_node.getHijoIzquierdo()!=null)/*SI NO SE HACE ESTE IF ,SUCEDE UN ERROR*/
           {
         return busca(integer_a_buscar, avl_tree_node.getHijoIzquierdo(),avl_tree);
           }
        }
      return null;
    }
    
    public int calcula_Factor_equilibrio(Nodo_para_arbol_AVL avl_tree_node)
    {
        if(avl_tree_node==null)
        {
            return -1;
        }
        else
           {
           return avl_tree_node.getFactor_de_equilibrio();
           }
    }    
    /*ROTACION SIMPLE A LA DERECHA*/
    public Nodo_para_arbol_AVL right_rotation(Nodo_para_arbol_AVL el_nuevo,Nodo_para_arbol_AVL avl_tree_node)
    {
        /*puntero nodo arbol*/
      Nodo_para_arbol_AVL auxiliar =avl_tree_node.getHijoIzquierdo();
      avl_tree_node.hijoIzquierdo=auxiliar.hijoDerecho;
      auxiliar.hijoDerecho=avl_tree_node;
      avl_tree_node.setFactor_de_equilibrio(Math.max(calcula_Factor_equilibrio(avl_tree_node.hijoIzquierdo), calcula_Factor_equilibrio(avl_tree_node.hijoDerecho))+1);
      auxiliar.setFactor_de_equilibrio(Math.max(calcula_Factor_equilibrio(auxiliar.hijoIzquierdo), calcula_Factor_equilibrio(auxiliar.hijoDerecho))+1);
      System.out.println(
          "///////////////////////////////////////////////////////////////////"
        +"\n Se hace rotacion simple derecha "
      +"\n///////////////////////////////////////////////////////////////////");
      if(auxiliar.getHijoDerecho()!=null&&auxiliar.getHijoIzquierdo()!=null)
      {
      System.out.println(" Ahora el nodo  "+auxiliar.getHijoIzquierdo().getDato()+" esta en el subarbol izquierdo de "+auxiliar.getDato()+
              "\n y "+auxiliar.hijoDerecho.getDato()+" esta en el subarbol derecho de "+auxiliar.getDato());  
      //System.out.println(" Estara en el lugar de "+auxiliar.getHijoDerecho().getDato());     
      }else if(auxiliar.getHijoDerecho()!=null&&auxiliar.getHijoIzquierdo()==null)
      {
        System.out.println(" Ahora el nodo "+auxiliar.getHijoDerecho().getDato()+
              " esta en el subarbol derecho de "+auxiliar.getDato());  
       }else if(auxiliar.getHijoDerecho()==null&&auxiliar.getHijoIzquierdo()!=null)
       {
        System.out.println(" Ahora el nodo  "+auxiliar.getHijoIzquierdo().getDato()+" esta en el subarbol izquierdo de "+auxiliar.getDato());  
     }
      return auxiliar;
    }
     /*ROTACION SIMPLE A LA IZQUIERDA*/ 
    public Nodo_para_arbol_AVL left_rotation(Nodo_para_arbol_AVL el_nuevo,Nodo_para_arbol_AVL avl_tree_node)
    {
        /*puntero nodo arbol*/
      Nodo_para_arbol_AVL auxiliar =avl_tree_node.getHijoDerecho();
      avl_tree_node.hijoDerecho=auxiliar.hijoIzquierdo;
      auxiliar.hijoIzquierdo=avl_tree_node;
      avl_tree_node.setFactor_de_equilibrio(Math.max(calcula_Factor_equilibrio(avl_tree_node.hijoIzquierdo), calcula_Factor_equilibrio(avl_tree_node.hijoDerecho))+1);
      auxiliar.setFactor_de_equilibrio(Math.max(calcula_Factor_equilibrio(auxiliar.hijoIzquierdo), calcula_Factor_equilibrio(auxiliar.hijoDerecho))+1);
       System.out.println(
      "///////////////////////////////////////////////////////////////////"
        +"\n Se hace rotacion simple izquierda "
      +"\n///////////////////////////////////////////////////////////////////");
      if(auxiliar.getHijoDerecho()!=null&&auxiliar.getHijoIzquierdo()!=null)
      {
       System.out.println(" Ahora el nodo  "+auxiliar.getHijoDerecho().getDato()+" esta en el subarbol derecho de "+auxiliar.getDato()+
              "\n y "+auxiliar.hijoIzquierdo.getDato()+" esta en el subarbol izquierdo de "+auxiliar.getDato());  
      }else if(auxiliar.getHijoDerecho()==null&&auxiliar.getHijoIzquierdo()!=null)
      {
        System.out.println(" Ahora el nodo "+auxiliar.hijoIzquierdo.getDato()+" esta en el subarbol izquierdo de "+auxiliar.getDato());     
      }else if(auxiliar.getHijoDerecho()!=null&&auxiliar.getHijoIzquierdo()==null)
      {
        System.out.println(" Ahora el nodo  "+auxiliar.getHijoDerecho().getDato()+" esta en el subarbol derecho de "+auxiliar.getDato()
        );     
      }
          
      //System.out.println(" Estara en el lugar de "+auxiliar.getDato());
     return auxiliar;
    }
    
    public boolean si_es_rotacion_simple_left_o_right(int numero_de_insertasub)
    {
     boolean rotacion_simple=false;
     if(numero_de_insertasub==1)
     {
     return rotacion_simple=true;       
     }else if(numero_de_insertasub==0)
     {
     return rotacion_simple;           
     }
     return rotacion_simple;
    }
    public boolean si_es_doble_left_o_right(int numero_de_insertasub)
    {
     boolean doble_rotation=false;
     if(numero_de_insertasub==1)
     {
     return doble_rotation=true;       
     }else if(numero_de_insertasub==0)
     {
     return doble_rotation=false;           
     }
     return doble_rotation;   
    }
    /*ROTACION DOBLE A LA IZQUIERDA*/
    /*  ROTACION SIMPLE IZQUIERDA =  ROTACION SIMPLE IZQUIERDA + ROTACION SIMPLE DERECHA  */
    
    public  Nodo_para_arbol_AVL left_right_rotation (Nodo_para_arbol_AVL el_nuevo,Nodo_para_arbol_AVL avl_tree_node)
    {
        System.out.println("\n SE HACE UNA ROTACION LEFT RIGHT  \n");
        Nodo_para_arbol_AVL temporal;
        avl_tree_node.hijoIzquierdo= left_rotation(el_nuevo,avl_tree_node.hijoIzquierdo);
        temporal=right_rotation(el_nuevo,avl_tree_node);
        return temporal;
    }
     /*ROTACION DOBLE A LA DERECHA*/
    /* ROTACION DOBLE A LA DERECHA = ROTACION SIMPLE DERECHA + ROTACION SIMPLE IZQUIERDA */
    public Nodo_para_arbol_AVL right_left_rotation (Nodo_para_arbol_AVL el_nuevo,Nodo_para_arbol_AVL avl_tree_node)
    {
         System.out.println("\n SE HACE UNA ROTACION RIGHT LEFT  \n");
        Nodo_para_arbol_AVL temporal;
        avl_tree_node.hijoDerecho= right_rotation(el_nuevo,avl_tree_node.hijoDerecho);
        temporal=left_rotation(el_nuevo,avl_tree_node); 
        return temporal;
    }  
    /*   nuevo   nodo a agregar  */            /*  raiz   */
    public Nodo_para_arbol_AVL inserta_sub(Nodo_para_arbol_AVL avl_tree_node,Nodo_para_arbol_AVL subarbol)
    {    
        Arbol_tipo_AVL arbol_para_saber_impresion =new Arbol_tipo_AVL();
         Nodo_para_arbol_AVL nuevo_padre = subarbol;
        if(avl_tree_node.getDato()<subarbol.getDato())
        {  /* SI EL NUEVO ES MENOR AL QUE EVALUA*/
        if(subarbol.getHijoIzquierdo()==null)
        {
        subarbol.hijoIzquierdo =avl_tree_node;
         System.out.println("      Se agrega "+subarbol.hijoIzquierdo.getDato()+" como subarbol izquierdo de "+subarbol.getDato());
        }else
           {
           subarbol.hijoIzquierdo=inserta_sub(avl_tree_node, subarbol.hijoIzquierdo);
           if((calcula_Factor_equilibrio(subarbol.hijoIzquierdo)-calcula_Factor_equilibrio(subarbol.hijoDerecho))==2)
           {  /*DESBALANCEO */
               System.out.println("     ---------> Sucede un desvalance <---------       ");
               if(avl_tree_node.getDato()<subarbol.getHijoIzquierdo().getDato())
           {
           setSi_es_simple_rotation_insertasub(1);
           arbol_para_saber_impresion.si_es_rotacion_simple_left_o_right(getSi_es_simple_rotation_insertasub());
           //right rotation
           nuevo_padre=right_rotation(avl_tree_node,subarbol);
           }
           else
           {
           setSi_es_doble_rotation_insertasub(1);
           arbol_para_saber_impresion.si_es_doble_left_o_right(getSi_es_simple_rotation_insertasub());       
           //left right rotation
           nuevo_padre=left_right_rotation(avl_tree_node,subarbol);
           }
           }
           }
     //       System.out.println(" la raiz es "+subarbol.getDato());
         }
        /*            FIN FEL CONDICIONAL PARA SUB ARBOL IZQUIERDO                  */
        else if(avl_tree_node.getDato()>subarbol.getDato())
               {
               if(subarbol.hijoDerecho==null)
               {
               subarbol.hijoDerecho=avl_tree_node;
               System.out.println("      Se agrega "+subarbol.hijoDerecho.getDato()+" como subarbol derecho de "+subarbol.getDato());
               }
           else
               {  
                                                      /*nuevo*/             /*raiz*/
                subarbol.hijoDerecho=inserta_sub(avl_tree_node, subarbol.hijoDerecho);
                if((calcula_Factor_equilibrio(subarbol.hijoDerecho)-calcula_Factor_equilibrio(subarbol.hijoIzquierdo))==2)
               {/*DESBALANCEO */
               System.out.println("     ---------> Sucede un desvalance <---------       ");                      
                
                if(avl_tree_node.getDato()>subarbol.getHijoDerecho().getDato())
                {
               setSi_es_simple_rotation_insertasub(1);
               arbol_para_saber_impresion.si_es_rotacion_simple_left_o_right(getSi_es_simple_rotation_insertasub());
                //left rotation
                nuevo_padre=left_rotation(avl_tree_node,subarbol);
                }
                else{
                     setSi_es_doble_rotation_insertasub(1);
                     arbol_para_saber_impresion.si_es_doble_left_o_right(getSi_es_simple_rotation_insertasub());       
                    //left right rotation
                    nuevo_padre=right_left_rotation(avl_tree_node,subarbol);
                    }
               }
               } 
   //                     System.out.println(" la raiz es "+subarbol.getDato());
   
               }
        /*                FIN DE CONDICIONALES PARA SUB ARBOL DERECHO                  */
               else
                   {
                       System.out.println("EL NODO YA EXISTE EN EL ARBOL");
                   }
             /*              ACTUALIZANDO EL FACTOR DE EQUILIBRIO                     */
             if(subarbol.hijoIzquierdo==null&&subarbol.hijoDerecho!=null)
             {
             subarbol.setFactor_de_equilibrio(subarbol.hijoDerecho.getFactor_de_equilibrio()+1);
             }else if((subarbol.hijoDerecho==null)&&(subarbol.hijoIzquierdo!=null))
             {
                 subarbol.setFactor_de_equilibrio(subarbol.hijoIzquierdo.getFactor_de_equilibrio()+1);
             }else
             {
             subarbol.setFactor_de_equilibrio(Math.max(calcula_Factor_equilibrio(subarbol.hijoIzquierdo), calcula_Factor_equilibrio( subarbol.hijoDerecho))+1);
             }
             return nuevo_padre;
    }
    /*METODO PARA RECORRER*/
      public void recorrerArbol(Nodo_para_arbol_AVL raiz) {
        if (raiz != null) {
             /*RECORRE EN INORDER primero el subarbol izquierdo ,luego la raiz y luego el subarbol derecho*/
            recorrerArbol(raiz.getHijoIzquierdo());
            System.out.println("->" + raiz.getDato());
            recorrerArbol(raiz.getHijoDerecho());
        }
    }
        //Método para recorrido PreOrden
    public void recorridoPreOrden(Nodo_para_arbol_AVL raiz){
        if(raiz!=null){
            System.out.println("-> " + raiz.getDato());
            recorridoPreOrden(raiz.getHijoIzquierdo());
            recorridoPreOrden(raiz.getHijoDerecho());
        }
    }
    
     //Método para recorrido PostOrden

public void recorridoPostOrden(Nodo_para_arbol_AVL raiz){
         if(raiz!=null){
             recorridoPostOrden(raiz.getHijoIzquierdo());
            recorridoPostOrden(raiz.hijoDerecho);
            System.out.println("-> " + raiz.getDato());
        }
    }
    /*METODO PARA INSERTAR*/
    public void inserta  (double dato_doble,Arbol_tipo_AVL arbol_trabajar)
    {
    Nodo_para_arbol_AVL nuevo =new Nodo_para_arbol_AVL(dato_doble);
    if( arbol_trabajar.getRaiz()==null)
    {
            JOptionPane.showMessageDialog(null,"Agregacion simple de la raiz "+dato_doble);
            arbol_trabajar.setRaiz(nuevo);
    }else
    {
           System.out.println("              HA INGRESADO EL DATO "+dato_doble); 
          System.out.println("      Se lleva a evaluarla posicion de "+dato_doble);
            arbol_trabajar.setRaiz(inserta_sub(nuevo, arbol_trabajar.getRaiz()));
    }
    }

    /**
     * @return the raiz
     */
    public Nodo_para_arbol_AVL getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(Nodo_para_arbol_AVL raiz) {
        this.raiz = raiz;
    }

    /**
     * @return the si_es_simple_rotation_insertasub
     */
    public int getSi_es_simple_rotation_insertasub() {
        return si_es_simple_rotation_insertasub;
    }

    /**
     * @param si_es_simple_rotation_insertasub the si_es_simple_rotation_insertasub to set
     */
    public void setSi_es_simple_rotation_insertasub(int si_es_simple_rotation_insertasub) {
        this.si_es_simple_rotation_insertasub = si_es_simple_rotation_insertasub;
    }

    /**
     * @return the si_es_doble_rotation_insertasub
     */
    public int getSi_es_doble_rotation_insertasub() {
        return si_es_doble_rotation_insertasub;
    }

    /**
     * @param si_es_doble_rotation_insertasub the si_es_doble_rotation_insertasub to set
     */
    public void setSi_es_doble_rotation_insertasub(int si_es_doble_rotation_insertasub) {
        this.si_es_doble_rotation_insertasub = si_es_doble_rotation_insertasub;
    }
}