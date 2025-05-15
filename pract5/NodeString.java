package pract5;

/**
 * Clase NodeString.
 *
 * @author (PRG. ETSINF. UPV)
 * @version (Curso 2024/25)
 */
public class NodeString {    
    String data;
    NodeString next; 
 
    /** 
     * Crea un nodo con data d y con next igual a null. 
     * @param d String. Dato del nuevo nodo.
     */
    NodeString(String d) {  
        this.data = d;
        this.next = null;
    } 
    
    /** 
     * Crea un nodo con data d y next s. 
     * @param d String. Dato del nuevo nodo.
     * @param s NodeString. Sucesor del nodo que se crea.
     */
    NodeString(String d, NodeString s) {
        this.data = d;
        this.next = s;
    }        
}
