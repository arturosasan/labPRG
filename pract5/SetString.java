package pract5;

import java.util.Scanner;
/**
 * Clase SetString. Implementación de un conjunto de String mediante 
 * una secuencia enlazada ordenada lexicográficamente.
 *
 * @author (PRG. ETSINF. UPV)
 * @version (Curso 2024/25)
 */
public class SetString {
    
    // COMPLETAR ATRIBUTOS
    
    /** Crea un conjunto vacío. */
    public SetString() {
        // COMPLETAR
    }

    /**
     * Inserta s en el conjunto.
     * Si s ya pertenece al conjunto, el conjunto no cambia.
     * @param s String. Elemento que se inserta en el conjunto.
     */
    public void add(String s) {
        // COMPLETAR
    }
    
    /**
     * Comprueba si s pertenece al conjunto.
     * @param s String. Elemento a buscar en el conjunto.
     * @return boolean, true sii s pertenece al conjunto.
     */
    public boolean contains(String s) {
        // COMPLETAR Y CORREGIR EL return
        return false;
    }

    /**
     * Elimina s del conjunto.
     * Si s no pertenece al conjunto, el conjunto no cambia.
     * @param s String. Elemento a eliminar del conjunto.
     */
    public void remove(String s) {
        // COMPLETAR
    }
    
    /**
     * Devuelve la talla o cardinal del conjunto.
     * @return int, la talla del conjunto.
     */
    public int size() { 
        // COMPLETAR Y CORREGIR EL return
        return 0;
    }    
    
    /**
     * Devuelve el conjunto intersección del conjunto y del otro conjunto.
     * @param other SetString.
     * @return SetString, el conjunto intersección.
     */
    public SetString intersection(SetString other) {
        // COMPLETAR Y CORREGIR EL return
        return null;
    }
    
    /**
     * Devuelve el conjunto unión del conjunto y del otro conjunto.
     * @param other SetString.
     * @return SetString, el conjunto unión.
     */
    public SetString union(SetString other) {
        // COMPLETAR Y CORREGIR EL return
        return null;
    }   
    
    /**
     * Devuelve el listado de los Strings en el conjunto, en orden
     * lexicográfico, y separados por saltos de línea.
     * Si el conjunto es vacío, devuelve "", la String vacía.
     * @return String, el listado de los elementos del conjunto.
     */
    public String toString() {
        String result = "";
        NodeString aux = this.first;
        while (aux != null) {
            result += aux.data + "\n"; 
            aux = aux.next; 
        }
        return result;
    }
  
    /**
     * Devuelve el SetString de las palabras leídas de s segun los separadores 
     * con que se haya configurado el Scanner. 
     * @param s Scanner.
     * @return SetString, el conjunto de palabras leídas de s.
     */
    public static SetString setReading(Scanner s) {            
        SetString setS = new SetString();
        while (s.hasNext()) {
            String word = s.next();
            setS.add(word);    
        }
        return setS;
    }
    
}
