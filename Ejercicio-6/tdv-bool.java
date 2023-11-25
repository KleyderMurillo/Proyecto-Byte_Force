import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class ExamenFuncional {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Se crea un objeto Scanner para la entrada del usuario.
        Set<Integer> filasCambiar = new HashSet<>();  // Se crea un conjunto para almacenar las filas que el usuario desea cambiar.

        System.out.print("Ingrese el Número de Bits que deberá ser la Tabla de Verdad: ");  // Se solicita al usuario el número de bits.
        int numBits = scanner.nextInt();  // Se lee el número de bits proporcionado por el usuario.

        // IMPRIMIR TABLA ==============================================
        for (int i = 0; i < numBits; i++) {
            System.out.print((char) ('A' + i) + "\t");  // Se imprimen los encabezados de las variables (A, B, C, etc.).
        }
        System.out.println("Resultado");  // Se imprime el encabezado de la columna "Resultado".

        for (int i = 0; i < Math.pow(2, numBits); i++) {
            imprimirFilaTabla(i, numBits);  // Se imprime una fila de la tabla de verdad original.
            System.out.println("0");  // Se imprime el resultado, que es siempre 0 en la tabla original.
        }
        // IMPRIMIR TABLA ==============================================

        while (true) {  // Bucle para Cambiar Bits
            System.out.print("Ingrese el número de la fila que desea cambiar el resultado a 1 (1-" + (int) Math.pow(2, numBits) + ") o ingrese 0 para finalizar: ");
            int fila = scanner.nextInt();  // Se lee la fila que el usuario desea cambiar.

            if (fila == 0) { break; }  // Si el usuario ingresa 0, se sale del bucle.

            if (fila < 1 || fila > Math.pow(2, numBits)) {  // Se valida que la fila esté en el rango válido.
                System.out.println("Número de fila inválido. Debe estar entre 1 y " + (int) Math.pow(2, numBits) + ".");
                continue;  // Se vuelve al inicio del bucle si la fila no es válida.
            }
            
            filasCambiar.add(fila);  // Se agrega la fila al conjunto de filas a cambiar.
            imprimirTablaActualizada(filasCambiar, numBits);  // Se imprime la tabla actualizada.
        }

        // Resultado BOOLEANO ==========================================================================
        System.out.println("Expresiones booleanas al finalizar:");
        filasCambiar.forEach(fila -> System.out.println(generarExpresionBooleana(fila, numBits)));  // Se imprimen las expresiones booleanas asociadas a las filas modificadas.
        System.out.println("Expresión booleana final: " + generarExpresionFinal(filasCambiar, numBits));  // Se imprime la expresión booleana final.
        // Resultado BOOLEANO ==========================================================================
    }

    private static void imprimirFilaTabla(int valor, int numBits) {
        for (int j = numBits - 1; j >= 0; j--) {
            System.out.print(((valor >> j) & 1) + "\t");  // Se imprime cada bit de la fila en formato binario.
        }
    }

    private static void imprimirTablaActualizada(Set<Integer> filasCambiar, int numBits) {
        System.out.println("Tabla de verdad actualizada:");
        for (int i = 0; i < Math.pow(2, numBits); i++) {
            imprimirFilaTabla(i, numBits);
            boolean resultado = false;
            if (filasCambiar.contains(i + 1)) {
                resultado = true;
            }
            System.out.println(resultado ? "1" : "0");  // Se imprime el resultado (1 o 0) de acuerdo a las filas cambiadas.
        }
    }

    // Función para generar expresiones booleanas
    private static String generarExpresionBooleana(int fila, int numBits) {
        StringBuilder expresion = new StringBuilder();
        for (int i = 0; i < numBits; i++) {
            expresion.append(((fila - 1) >> (numBits - 1 - i) & 1) == 1 ? (char) ('A' + i) : (char) ('A' + i) + "'");
            if (i < numBits - 1) {
                expresion.append(" + ");
            }
        }
        return expresion.toString();  // Se genera la expresión booleana para una fila específica.
    }

    private static String generarExpresionFinal(Set<Integer> filasCambiar, int numBits) {
        StringBuilder expresionesConcatenadas = new StringBuilder();
        filasCambiar.forEach(fila -> {
            String expresion = generarExpresionBooleana(fila, numBits);
            if (expresionesConcatenadas.length() > 0) {
                expresionesConcatenadas.append(" + ");
            }
            expresionesConcatenadas.append("(").append(expresion).append(")");
        });
        return expresionesConcatenadas.toString();  // Se genera la expresión booleana final concatenando las expresiones de las filas modificadas.
    }
}