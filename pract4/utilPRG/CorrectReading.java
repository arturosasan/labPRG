package pract4.utilPRG;

import java.io.*;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/**
 * Clase CorrectReading: clase de utilidades que permite realizar la lectura 
 * validada de datos de tipos primitivos desde la entrada estandar.
 * 
 * @author PRG - ETSINF - UPV
 * @version Curso 2024/25
 */
public class CorrectReading {

    /** No hay objetos de esta clase. */ 
    private CorrectReading() { }

    public static void main (String [] args) {
        Scanner t = new Scanner(System.in).useLocale(Locale.US);
        boolean bye = true;
        int act;
        //System.out.println("Elige que actividad quieres comprobar de la Práctica 4");
        do {
            try {
            System.out.println("Elige que actividad quieres comprobar de la Práctica 4");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("          (1) --> Actividad 2.1 (nextInt (Scanner, String))              ");
            System.out.println("          (2) --> Actividad 2.2 (nextDouble (Scanner, String))           ");
            System.out.println("          (3) --> Actividad 3 (nextDoublePositive (Scanner, String))     ");
            System.out.println("          (4) --> Actividad 4 (nextInt (Scanner, String, int, int))      ");
            System.out.println("          (0) --> Finish                                                 ");
            System.out.println("-------------------------------------------------------------------------");
            act = t.nextInt();
            if (act < 0 || act > 4) {
                throw new IllegalArgumentException("Error, no has introducido una opción correcta");
            } else if (act == 0) {
                System.out.println("FIN DEL MÉTODO");
                bye = false;
            } else if (act == 1) {
                System.out.println("Has elegido la Actividad 2.1");
                int valor = CorrectReading.nextInt(t, "Valor: ");
                bye = false; // Para que se salga del bucle, ya que si no no salen por pantalla las diferentes opciones
            } else if (act == 2) {
                System.out.println("Has elegido la Actividad 2.2");
                double valor = CorrectReading.nextDouble(t, "Valor: ");
                bye = false; // Para que se salga del bucle, ya que si no no salen por pantalla las diferentes opciones
            } else if (act == 3) {
                System.out.println("Has elegido la Actividad 3");
                double valor = CorrectReading.nextDoublePositive(t, "Valor: ");
                bye = false; // Para que se salga del bucle, ya que si no no salen por pantalla las diferentes opciones
            } else {
                System.out.println("Has elegido la Actividad 4");
                boolean OK = true;
                bye = false; // Para que se salga del bucle, ya que si no no salen por pantalla las diferentes opciones
                do {
                    try {
                        System.out.println("Dame el valor de lowerBound");
                        int lowerBound = t.nextInt();
                        System.out.println("Dame el valor de upperBound");
                        int upperBound = t.nextInt();
                        if (lowerBound > upperBound) {throw new IllegalArgumentException("El valor lowerBound es mayor que upperBound");}
                        if (lowerBound < upperBound) {CorrectReading.nextInt(t, "Valor: ", lowerBound, upperBound);}
                        OK = false;
                        //bye = false; // Para que se salga del bucle, ya que si no no salen por pantalla las diferentes opciones
                    } catch (InputMismatchException e) {
                        System.out.println("No marees con los datos anda");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage() + ", introduce ambos datos otra vez");
                    } finally {
                        t.nextLine();
                        bye = false; // Para que se salga del bucle, ya que si no no salen por pantalla las diferentes opciones
                    }
                }while (OK);
                bye = false; // Para que se salga del bucle, ya que si no no salen por pantalla las diferentes opciones
                System.out.println("Presiona cualquier tecla para finalizar el método principal");
            }
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número por el amor de Dios");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + ", introduce los datos otra vez");
            }finally {
                t.nextLine(); // Para manejar si el usuario no pone un número
            }
        } while (bye);
    }

    // ACTIVIDAD 2:
    /**
     * Lee un valor desde un objeto de tipo Scanner y devuelve el primer entero leido.
     * <br><br> 
     * Si el valor leido no es un entero, muestra en pantalla el mensaje: 
     * "Por favor, introduzca un numero entero correcto! ... " 
     * <br><br>    
     * La lectura se repite hasta que el token leido sea correcto y devuelve el 
     * primero que sea entero.
     *
     * @param sc Scanner desde el que se lee.
     * @param msg String con la pregunta que se muestra al usuario.
     * @return int, valor entero.
     */
    public static int nextInt(Scanner sc, String msg) {
        int value = 0;
        boolean someError = true; 
        do {
            try {
                System.out.print(msg);
                value = sc.nextInt();
                someError = false;
                throw new IllegalArgumentException("TODO OK"); // Lo lanzo para que en caso de que el usuario haya puesto un número este pueda salir del bucle de una forma más "limpia"
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduzca un numero entero correcto! ... ");
            } catch (IllegalArgumentException e) {
                System.out.println("Presiona cualquier tecla para finalizar"); // EL método ya ha acabado, por lo que le digo al usuario que tiene que presionar una tecla para hacer el finally y salir del bucle
                someError = false; // Para salir del bucle
            } finally {
                sc.nextLine(); // Para manejar si el usuario no pone un número
            }
        } while (someError);
        return value;
    }    

    /**
     * Lee un valor desde un objeto de tipo Scanner y devuelve el primer real leido.
     * <br><br> 
     * Si el valor leido no es un real, muestra en pantalla el mensaje: 
     * "Por favor, introduzca un numero real correcto! ... " 
     * <br><br>    
     * La lectura se repite hasta que el token leido sea correcto y devuelve el 
     * primero que sea real.
     *
     * @param sc Scanner desde el que se lee.
     * @param msg String con la pregunta que se muestra al usuario.
     * @return double, valor real.
     */
    public static double nextDouble(Scanner sc, String msg) {
        double value = 0;
        boolean someError = true; 
        do {
            try {
                System.out.print(msg);
                value = sc.nextDouble();
                someError = false;
                throw new IllegalArgumentException("TODO OK"); // Lo lanzo para que en caso de que el usuario haya puesto un número este pueda salir del bucle de una forma más "limpia"
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduzca un numero real correcto! ... ");
            } catch (IllegalArgumentException e){
                System.out.println("Presiona cualquier tecla para finalizar"); // EL método ya ha acabado, por lo que le digo al usuario que tiene que presionar una tecla para hacer el finally y salir del bucle
                someError = false; // Para salir del bucle
            }
            finally {
                sc.nextLine(); // Para manejar si el usuario no pone un número
            }
        } while (someError);
        return value;
    }    

    // ACTIVIDAD 3:
    /**
     * Lee un valor desde un objeto de tipo Scanner y devuelve el primer numero real 
     * no negativo leido.
     * <br><br>
     * Si el valor leido es un número real negativo, muestra en pantalla el mensaje: 
     * "Por favor, introduzca un valor correcto! ... " 
     * <br><br>   
     * Si el valor no es un real, muestra en pantalla el mensaje: 
     * "Por favor, introduzca un numero real correcto! ... " 
     * <br><br> 
     * La lectura se repite hasta hasta que sea correcto, devolviendo el primero 
     * que sea >= 0.0.
     *      
     * @param sc Scanner desde el que se lee.
     * @param msg String con la pregunta que se muestra al usuario.
     * @return double, valor double no negativo.
     */ 
    public static double nextDoublePositive(Scanner sc, String msg) {
        double value = 0.0;
        boolean someError = true; 
        do {
            try {
                System.out.print(msg);
                value = sc.nextDouble();
                if (value < 0.0) {
                    System.out.println("El valor debe ser positivo, introduzca otro valor");
                } 
                else { 
                    someError = false;
                    System.out.println("Fin del programa");
                    throw new IllegalArgumentException("TODO OK"); // Lo lanzo para que en caso de que el usuario haya puesto un número este pueda salir del bucle de una forma más "limpia"
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduzca un valor correcto! ... ");
            } catch (IllegalArgumentException e){
                System.out.println("Presiona cualquier tecla para finalizar"); // EL método ya ha acabado, por lo que le digo al usuario que tiene que presionar una tecla para hacer el finally y salir del bucle
                someError = false; // Para salir del bucle
            } finally {
                sc.nextLine(); // Para manejar si el usuario no pone un número
            }
        } while (someError);        
        return value;
    }

    // ACTIVIDAD 4:
    /**
     * Lee un valor desde un objeto de tipo Scanner y devuelve el primero que sea de tipo entero
     * y en el rango delimitado por <code>[lowerBound .. upperBound]</code> donde 
     * <code>Integer.MIN_VALUE <= lowerBound</code> y <code>upperBound <= Integer.MAX_VALUE</code>.
     * <br><br>
     * - Si el entero leido esta fuera de rango, lanza una excepcion de tipo 
     *  <code>IllegalArgumentException</code> con el mensaje: 
     *  "v no está en el rango [lowerBound .. upperBound]" 
     * donde v es el valor leido, y lowerBoud, upperBound son los parametros.
     * <br><br>
     *  
     * A continuacion, captura dicha excepcion y muestra por pantalla el mensaje de la excepcion
     * junto con el texto: 
     * ". Por favor, introduzca un valor correcto! ... " 
     * <br><br>
     * 
     * - Si el valor no fuera un entero, muestra por pantalla el mensaje: 
     *  "Por favor, introduzca un numero entero correcto! ... " 
     * <br><br> 
     * La lectura se repite hasta que el token leido sea correcto y devuelve el primero 
     * que sea un entero valido.
     *     
     * @param sc Scanner desde el que se lee.
     * @param msg String con la pregunta que se muestra al usuario.
     * @param lowerBound int, límite inferior.
     * @param upperBound int, límite superior.
     * @return int, valor entero dentro de los límites.
     */   
    public static int nextInt(Scanner sc, String msg, int lowerBound, int upperBound) {
        int value = 0;
        boolean someError = true;
        do {
            try {
                System.out.print(msg);
                value = sc.nextInt();
                if (value < lowerBound || value > upperBound) {
                    throw new IllegalArgumentException("El valor " + value + " no está en el rango [" + lowerBound + "," + upperBound + "]");
                } 
                else {
                    someError = false;
                    throw new IllegalArgumentException("Fin del programa, presiona cualquier tecla para finalizar"); // Lo lanzo para que en caso de que el usuario haya puesto un número este pueda salir del bucle de una forma más "limpia"
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduzca un valor correcto! ... ");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //someError = false;
            } finally {
                //System.out.println("Presiona cualquier tecla para finalizar");
                sc.nextLine(); // Para manejar si el usuario no pone un número
            }
        } while (someError);        
        return value;
    }
}
