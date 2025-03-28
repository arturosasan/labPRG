package pract1;

import graph2D.Graph2D;

import java.util.Scanner;
import java.awt.Color;

public class RSquare {    
    /** No hay objetos de esta clase. */
    private RSquare() { }

    public static void main (String [] args) {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Elige cómo quieres que se representen los cuadrados");
        int bye = 0;
        int opc;
        Color fillColor = Color.LIGHT_GRAY;
        Color borderColor = Color.BLUE;

        do {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("          (1) --> rSquareA                                               ");
            System.out.println("          (2) --> rSquareB                                               ");
            System.out.println("          (3) --> Elegir color de relleno                                ");
            System.out.println("          (4) --> Elegir color del borde                                 ");
            System.out.println("          (0) --> Finish                                                 ");
            System.out.println("-------------------------------------------------------------------------");
            opc = kbd.nextInt();
            if (opc < 0 || opc > 4) {
                System.out.println("Error, no has introducido una opción correcta");
            }
            if (opc == 0) {
                System.out.println("FIN DEL MÉTODO");
                bye = 1;
            }
            if (opc == 1) {
                System.out.println("Elige el orden de la figura rSquareA");
                int order = kbd.nextInt();
                rSquareA(order, fillColor, borderColor);
                System.out.println("Has elegido hacer la figura rSquareA con un orden de --> " + order);
            }
            if (opc == 2) {
                System.out.println("Elige el orden de la figura rSquareB");
                int order = kbd.nextInt();
                rSquareB(order, fillColor, borderColor);
                System.out.println("Has elegido hacer la figura rSquareB con un orden de --> " + order);
            }
            if (opc == 3) {
                fillColor = chooseColor(kbd);
            }
            if (opc == 4) {
                borderColor = chooseColor(kbd);
            }
        } while (bye != 1); 
    }

    private static Color chooseColor(Scanner kbd) {
        System.out.println("Elige un color:"); System.out.println("1. Negro"); System.out.println("2. Azul"); System.out.println("3. Cian");
        System.out.println("4. Gris oscuro"); System.out.println("5. Gris"); System.out.println("6. Verde"); System.out.println("7. Gris claro");
        System.out.println("8. Magenta"); System.out.println("9. Naranja"); System.out.println("10. Rosa"); System.out.println("11. Rojo");
        System.out.println("12. Blanco"); System.out.println("13. Amarillo");
        int colorChoice = kbd.nextInt();
        switch (colorChoice) {
            case 1: return Color.BLACK; case 2: return Color.BLUE; case 3: return Color.CYAN; case 4: return Color.DARK_GRAY; case 5: return Color.GRAY;
            case 6: return Color.GREEN; case 7: return Color.LIGHT_GRAY; case 8: return Color.MAGENTA; case 9: return Color.ORANGE; case 10: return Color.PINK;
            case 11: return Color.RED; case 12: return Color.WHITE; case 13: return Color.YELLOW;
            default: return Color.LIGHT_GRAY;
        }
    }

    public static void drawCentSquare(Graph2D gd, double cX, double cY, double l, Color fillColor, Color borderColor) {
        delay(); // Tarda un huevo si metemos delay                                           
        double luX = cX - (l/2);
        double luY = cY + (l/2);      
        // Dibujo de un rectangulo solido de color fillColor, de lados l x l, 
        // y cuya esquina superior izquierda se encuentra en (luX, luY):
        gd.fillRect(luX, luY, l, l, fillColor, 2);
        // Dibujo de un rectangulo de color borderColor, de lados l x l, 
        // y cuya esquina superior izquierda se encuentra en (luX, luY):
        gd.drawRect(luX, luY, l, l, borderColor, 2);
    }

    public static void rSquareA(Graph2D gd, int n, double cX, double cY, double l, Color fillColor, Color borderColor) {
        if (n==1) {
            drawCentSquare(gd,cX,cY,l, fillColor, borderColor);
        }else {
            n--;
            
            double x0 = cX - l/2;
            double x1 = cX + l/2;
            double y0 = cY - l/2;
            double y1 = cY + l/2;
            
            rSquareA(gd, n, x0, y1, l/2, fillColor, borderColor);
            rSquareA(gd, n, x1, y1, l/2, fillColor, borderColor);
            rSquareA(gd, n, x0, y0, l/2, fillColor, borderColor);
            rSquareA(gd, n, x1, y0, l/2, fillColor, borderColor);
            
            drawCentSquare(gd,cX,cY,l, fillColor, borderColor);
        }  
    } 

    public static void rSquareA(int n, Color fillColor, Color borderColor) {
        Graph2D g = new Graph2D(-1,1,-1,1);
        rSquareA(g,n, 0, 0, 1, fillColor, borderColor);      
    }

    public static void rSquareB(Graph2D gd, int n, double cX, double cY, double l, Color fillColor, Color borderColor) {
        if (n==1) {
            drawCentSquare(gd,cX,cY,l, fillColor, borderColor);
        }else {
            n--;
            
            drawCentSquare(gd, cX, cY, l, fillColor, borderColor);
            
            double x0 = cX - l/2;
            double x1 = cX + l/2;
            double y0 = cY - l/2;
            double y1 = cY + l/2;
            
            rSquareB(gd, n, x0, y1, l/2, fillColor, borderColor);
            rSquareB(gd, n, x1, y1, l/2, fillColor, borderColor);
            rSquareB(gd, n, x0, y0, l/2, fillColor, borderColor);
            rSquareB(gd, n, x1, y0, l/2, fillColor, borderColor);
            
        } 
    }     

    public static void rSquareB(int n, Color fillColor, Color borderColor) {
        Graph2D gd = new Graph2D(-1,1,-1,1);
        rSquareB(gd,n, 0, 0, 1, fillColor, borderColor);                  
    }
    
    private static void delay() {
        try { Thread.sleep(100); } catch (Exception e) { ; }
    }
}
