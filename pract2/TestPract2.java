package pract2;

/**
 * Clase TestPract2: clase programa que prueba 
 * los metodos isPrefix, isSubstring de PRGString
 * 
 * @author PRG - ETSINF - DSIC - UPV
 * @version Curso 2024/2025
 */
public class TestPract2 {
    /** No hay objetos de esta clase */
    private TestPract2() { }

    public static void testIsPrefix() {
        String[] s = {"", "rec", "pecur","recurso", "remursi","123456789", "recursion"};
        System.out.printf("%8s %12s %20s %12s\n","a", "b", "isPrefix(a, b)", "b.startsWith(a)");
        // a y b vacias
        compareIsPrefix(s[0],s[0]);
        // solo a vacia
        compareIsPrefix(s[0],s[6]);
        // solo b vacia
        compareIsPrefix(s[6],s[0]);
        // a de mayor longitud que b
        compareIsPrefix(s[6],s[1]);
        // a y b de igual longitud y a es prefijo de b
        compareIsPrefix(s[6],s[6]);
        // a y b de igual longitud y a no es prefijo de b
        compareIsPrefix(s[5],s[6]);
        // a de menor longitud que b y a es prefijo de b
        compareIsPrefix(s[1],s[6]);
        // a de menor longitud que b y a no es prefijo de b: por el primer caracter
        compareIsPrefix(s[2],s[6]);
        // a de menor longitud que b y a no es prefijo de b: por el ultimo caracter
        compareIsPrefix(s[3],s[6]);
        // a de menor longitud que b y a no es prefijo de b: por un caracter intermedio
        compareIsPrefix(s[4],s[6]);
    }

    public static void testIsSubstring() {
        String[] s = {"", "rec", "pecur","recurso", "remursi","123456789", "recursion","sion", "curs"};
        System.out.printf("%8s %12s %20s %10s\n","a", "b", "isSubstring(a,b)", "b.contains(a)");
        // a y b vacias
        compareIsSubstring(s[0],s[0]);
        // solo a vacia
        compareIsSubstring(s[0],s[6]);
        // solo b vacia
        compareIsSubstring(s[6],s[0]);
        // a de mayor longitud que b
        compareIsSubstring(s[6],s[1]);
        // a y b de igual longitud y a es subcadena de b
        compareIsSubstring(s[6],s[6]);
        // a y b de igual longitud y a no es subcadena de b
        compareIsSubstring(s[5],s[6]);
        // a de menor longitud que b y a es sucadena de b porque a es prefijo de b
        compareIsSubstring(s[1],s[6]);
        // a de menor longitud que b y a es sucadena de b porque a es sufijo de b
        compareIsSubstring(s[7],s[6]);
        // a de menor longitud que b y a es sucadena de b porque a esta en b a partir de una posicion intermedia
        compareIsSubstring(s[8],s[6]);
    }

    private static void compareIsPrefix(String a, String b) {
        System.out.printf("%12s %12s %12b %12b\n", a, b, PRGString.isPrefix(a, b),b.startsWith(a));
    }

    private static void compareIsSubstring(String a, String b) {
        System.out.printf("%12s %12s %12b %12b\n", a, b, PRGString.isSubstring(a, b),b.contains(a));
    }

}