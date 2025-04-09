package pract3;

import java.util.Locale;
/** Clase MeasuringSortingAlgorithms: Estudio empirico de costes de 
 *  los metodos de ordenacion.
 *  @author PRG - ETSInf
 *  @version Curso 2022-2023
 */
public class MeasuringSortingAlgorithms {
    // Constantes que definen los parametros de medida
    public static final int MAXTALLA = 10000, INITALLA = 1000; 
    public static final int INCRTALLA = 1000;
    public static final int REPETICIONESQ = 200, REPETICIONESL = 20000;
    public static final double NMS = 1e3;  // relacion micro - nanosegons

    /** No hay objetos de esta clase. */
    private MeasuringSortingAlgorithms() { }

    /** Crea un array de int de talla t con valores a 0.
     *  @param t int, la talla.
     *  @result int[], el array generado.
     */
    private static int[] createArray(int t) { 
        int[] a = new int[t];
        return a;
    }

    /** Rellena los elementos de un array a de int 
     *  con valores aleatorios entre 0 y a.length-1.
     *  @param a int[], el array.
     */
    private static void fillArrayRandom(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * a.length);
        }
    }

    /** Rellena los elementos de un array a de forma creciente,
     *  con valores desde 0 hasta a.length-1.
     *  @param a int[], el array.
     */
    private static void fillArraySortedInAscendingOrder(int[] a) { 
        for(int i = 0; i < a.length; i++){
            a[i] = i; 
        }
    }

    /** Rellena los elementos de un array a de forma decreciente,
     *  con valores desde a.length-1 hasta 0.
     *  @param a int[], el array.
     */
    private static void fillArraySortedInDescendingOrder(int[] a) { 
        for(int i = 0; i < a.length; i++){
            a[i] = a.length - 1 - i; 
        }
    }

    public static void measuringSelectionSort() {
        long ti = 0, tf = 0, tt = 0; // Tiempos inicial, final y total
        //int t = 100; // Talla del array
        // Imprimir cabecera

        System.out.println("# Seleccion. Tiempos en microsegundos");
        System.out.print("# Talla    Promedio \n");
        System.out.print("#------------------\n");

        for (int t = INITALLA; t <= MAXTALLA; t += INCRTALLA) {
            int[] a = createArray(t); // Creo el array SOLAMENTE UNA VEZ POR PASADA
            tt = 0;
            for(int repes = 1; repes <= REPETICIONESQ; repes++){
                fillArrayRandom(a); // Lo relleno con valores aleatorios
                ti = System.nanoTime(); // Mido el tiempo inicial
                MeasurableAlgorithms.selectionSort(a); // Ordeno el array
                tf = System.nanoTime(); // Mido el tiempo final
                tt += tf-ti; // Calculo el tiempo total
            }
            double tPromedio = (double) tt / REPETICIONESQ;
            System.out.printf(Locale.US,"%7d %11.3f\n",t, tPromedio / NMS);
        }       
    }

    public static void measuringInsertionSort() {
        long ti = 0, tf = 0, tt = 0; // Temps inicial, final i total        
        // Imprimir cabecera de resultados
        System.out.println("# Insercion. Tiempos en microsegundos.");
        System.out.print("# Talla    Mejor       Peor     Promedio \n");
        System.out.print("#----------------------------------------\n");

        // COMPLETAR
        for(int t = INITALLA; t<=MAXTALLA; t += INCRTALLA){
            int [] a = createArray(t);

            // CASO MEJOR
            fillArraySortedInAscendingOrder(a);
            tt=0;
            for(int r = 1; r <= REPETICIONESL; r++) {
                ti= System.nanoTime();
                MeasurableAlgorithms.insertionSort(a);
                tf= System.nanoTime();
                tt += tf -ti;
            }
            double tMejor = (double) tt / REPETICIONESL;

            // CASO PEOR

            tt=0;
            for(int r = 1; r <= REPETICIONESQ; r++) {
                fillArraySortedInDescendingOrder(a);
                ti= System.nanoTime();
                MeasurableAlgorithms.insertionSort(a);
                tf= System.nanoTime();
                tt += tf -ti;
            }
            double tPeor = (double) tt / REPETICIONESQ;

            // CASO PROMEDIO
            tt=0;
            for(int r = 1; r <= REPETICIONESQ; r++) {
                fillArrayRandom(a);
                ti= System.nanoTime();
                MeasurableAlgorithms.insertionSort(a);
                tf= System.nanoTime();
                tt += tf -ti;
            }
            double tPromedio = (double) tt / REPETICIONESQ;

            System.out.printf(Locale.US, "%7d %11.3f %11.3f %11.3f\n ", t, tMejor / NMS,
                tPeor /NMS , tPromedio/NMS);
        }
    }

    private static void help() {
        String msg = "Uso: java MeasurigSortingAlgorithms num_algoritmo";
        System.out.println(msg);
        System.out.println("   donde num_algoritmo es: ");
        System.out.println("   1 -> Seleccion");
        System.out.println("   2 -> Insercion");
    }

    public static void main(String[] args) {
        if (args.length != 1) { help(); } 
        else {
            try {
                int a = Integer.parseInt(args[0]);
                switch (a) {
                    case 1: 
                        measuringSelectionSort(); 
                        break;
                    case 2: 
                        measuringInsertionSort(); 
                        break;
                    default: 
                        help();
                }
            } catch (Exception e) {
                help(); 
            }
        }
    }
}