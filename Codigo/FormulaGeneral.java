import java.util.Scanner;
 
public class FormulaGeneral {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada= new Scanner (System.in);
        //Entrada
        System.out.println ("Ingresa el valor de A");
        double a= entrada.nextDouble();
        System.out.println ("Ingresa el valor de B");
        double b= entrada.nextDouble();
        System.out.println ("Ingresa el valor de C");
        double c= entrada.nextDouble();
        
        //Proceso
        double discriminante= Math.pow (b,2)-4*a*c;
        
        if (discriminante >0) {
            double x1 = (-b + Math.sqrt(discriminante)/ (2 *a));
            double x2 = (-b - Math.sqrt(discriminante)/ (2 *a));
            System.out.println ("La solucion es x1:" + x1+  "y x2:" + x2);
            
        } else if (discriminante ==0) {
            double x= -b/ (2*a);
            System.out.println ("La unica solucion es x:" + x);
            
        
        } else {
            System.out.println ("La ecuacion no tiene soluciones reales");
        }
    }
    
}