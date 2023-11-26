/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author dl631
 */
public class DecimalBinarioPositivoNegativo {
     public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa un número decimal: ");
        int numeroDecimal = scanner.nextInt();

        String numeroBinario = convertirABinario(numeroDecimal);

        System.out.println("El número binario equivalente es: " + numeroBinario);
    }

    private static String convertirABinario(int numeroDecimal) {
        StringBuilder binario = new StringBuilder();

        if (numeroDecimal == 0) {
            return "0";
        }

        boolean esNegativo = false;
        if (numeroDecimal < 0) {
            esNegativo = true;
            numeroDecimal = -numeroDecimal;
        }

        // Convertir el número decimal a binario
        while (numeroDecimal > 0) {
            int residuo = numeroDecimal % 2;
            binario.insert(0, residuo);
            numeroDecimal /= 2;
        }

        // Calcular el complemento a dos si el número es negativo
        if (esNegativo) {
            // Invertir los bits
            for (int i = 0; i < binario.length(); i++) {
                char bit = binario.charAt(i);
                binario.setCharAt(i, (bit == '0') ? '1' : '0');
            }
            
            // Sumar 1 al complemento invertido
            int carry = 1;
            for (int i = binario.length() - 1; i >= 0; i--) {
                int bit = (binario.charAt(i) - '0') + carry;
                binario.setCharAt(i, (char) (bit % 2 + '0'));
                carry = bit / 2;
            }
        }

        return binario.toString();
    }
}