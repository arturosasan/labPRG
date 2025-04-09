package exam1;

/**
 * Clase MyString: Ejercicio PrÃ¡ctica 2 - Parcial 1 Lab
 * 
 * @author PRG 
 * @version Curso 2024-25
 */
public class MyString {    
    /** No hay objetos de esta clase */
    private MyString() { }
    
    /**
     * Devuelve true si el char c es una vocal y,
     * en caso contrario, devuelve false.
     */
    private static boolean isVowel(char c) {
        final String VOWELS = "aeiouAEIOU";
        return VOWELS.indexOf(c) != -1;
    }
    
    /**
     * Devuelve el String que resulta de eliminar todas
     * las vocales del String s.
     */
    public static String removeVowels(String s) {
        /* COMPLETAR Y CORREGIR EL VALOR DE RETORNO */
        
        if (s.length() == 0) { return ""; }// Caso base, string vacío
        // Caso general: String no vacia. Tratar la substring posterior.
        else if (isVowel(s.charAt(0)) == false) { return s.charAt(0) + removeVowels(s.substring(1)); } // Si no hay vocal, se devuelve la primera letra y llamo al método otra vez pero con la siguiente letra
        else { return removeVowels(s.substring(1)); } // Si hay vocal, llamo al método SIN añadir esa letra y siguiendo con el substring de s
    } 
    
    /** Muestra el resultado del mÃ©todo para varios String ejemplo.
     *  Puedes probar con otros Strings.  
     */
    public static void main(String[] args) {
        System.out.println("Se realizan 8 llamadas a removeVowels(String).");
        System.out.println("La primera con la cadena vacÃ­a \"\".");
        System.out.println("Se muestra, entre comillas dobles, el String de prueba, la soluciÃ³n correcta y tu soluciÃ³n.\n");
        
        String[] s = {"", "bcd", "abcd", "bcde", "aaa4uuu", "ctrl And Z", "aeiou", "Shine On Until Tomorrow"}; 
        String[] sol = {"", "bcd", "bcd", "bcd", "4", "ctrl nd Z", "", "Shn n ntl Tmrrw"};
        String yourSolution = "";
        
        System.out.printf("%-30s %-25s %-15s\n", "      s", "removeVowels(s)", "Tu soluciÃ³n");
        for (int i = 0; i < s.length; i++) {
            System.out.printf("%-30s %-25s ", "\"" + s[i] + "\"", "\"" + sol[i] + "\"");
            yourSolution = removeVowels(s[i]);
            System.out.printf("%-15s\n", "\"" + yourSolution + "\"");
        }
    }
}