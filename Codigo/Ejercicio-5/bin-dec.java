import java.util.Scanner;
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Entrada 
        Scanner entrada= new Scanner (System.in);
        System.out.println ("Ingrese un numero binario");
        
        String numeroBinario=entrada.nextLine();//Lee la entrada del usuario y la guarda en la variable numeroBinario
        
        int longitud= numeroBinario.length();//Obtiene la longitud de la cadena numeroBinario 
      
        int numeroDecimal=0;
        
        for (int i=0; i<longitud; i++) {//inicia un bucle for que recorre cada dígito del número binario.
            char digito= numeroBinario.charAt(i);//Obtiene el carácter en la posición i de la cadena numeroBinario 
            
            //Verificar si es 0 o 1
            if (digito == '0') { 
                numeroDecimal=numeroDecimal * 2;
                
            }else if (digito == '1'){
                numeroDecimal=numeroDecimal * 2 + 1;
                //Salida
            }else{
                System.out.println ("El numero binario ingresado no es valido");
                return;
                
            }
        }
        System.out.println ("El numero decimal equivalente es:" + numeroDecimal);
        
    }
    
}