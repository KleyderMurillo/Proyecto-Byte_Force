import java.util.Scanner;
public class Decimal_Binario {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner entrada = new Scanner(System.in);

        // Solicitar al usuario que ingrese un número decimal
        System.out.print("Ingrese un número decimal: ");
        int numeroDecimal = entrada.nextInt();

        // Verificar si el número es no negativo
        if (numeroDecimal < 0) {
            System.out.println("El número debe ser un entero no negativo.");
            return;
        }

        // Inicializar una cadena para almacenar el número binario
        String numeroBinario = "";

        // Manejar el caso especial cuando el número decimal es 0
        if (numeroDecimal == 0) {
            numeroBinario = "0";
        } else {
            // Convertir el número decimal a binario
            while (numeroDecimal > 0) {
                int residuo = numeroDecimal % 2; // Obtener el residuo de la división por 2
                numeroBinario = residuo + numeroBinario; // Agregar el residuo al inicio de la cadena binaria
                numeroDecimal = numeroDecimal / 2; // Dividir el número decimal por 2
            }
        }

        // Imprimir el número binario resultante
        System.out.println("El número binario equivalente es: " + numeroBinario);

    }

}