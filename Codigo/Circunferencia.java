import java.util.Scanner;

public class Circunferencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// 
        System.out.println("Ingrese las coordenadas del centro del círculo (x1, y1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("Ingrese las coordenadas de un punto en el círculo (x2, y2):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        // Calcula el radio del círculo usando la fórmula de distancia entre dos puntos.
        double radio = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        System.out.println("El área del círculo es: " + calcularArea(radio));

        System.out.println("Ingrese las coordenadas de un punto para verificar si está dentro del círculo (x3, y3):");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        // Verifica si el punto (x3, y3) está dentro del círculo.
        boolean estaDentro = Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2) <= Math.pow(radio, 2);

        if (estaDentro) {
            System.out.println("El punto está dentro del círculo.");
        } else {
            System.out.println("El punto está fuera del círculo.");
        }
    }

    public static double calcularArea(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
}