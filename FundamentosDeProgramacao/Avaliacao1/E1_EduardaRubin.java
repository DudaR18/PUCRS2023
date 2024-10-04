
/**
 * E1_EduardaRubin.
 * 
 * @Eduarda Rubin 
 * @03/04/2023
 */

import java.util.Scanner;
public class E1_EduardaRubin
{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        double aux;
        
        System.out.println("\f-> Digite aqui cinco valores: ");
        double valor_1= in.nextDouble();
        double valor_2= in.nextDouble();
        double valor_3= in.nextDouble();
        double valor_4= in.nextDouble();
        double valor_5= in.nextDouble();
        
        if (valor_1 > valor_2) {
            aux= valor_1;
            valor_1= valor_2;
            valor_2= aux;
        }
        if(valor_1 > valor_3) {
            aux= valor_1;
            valor_1= valor_3;
            valor_3= aux;
        }
        if (valor_1 > valor_4) {
            aux= valor_1;
            valor_1= valor_4;
            valor_4= aux;
        }
        if (valor_1 > valor_5) {
            aux= valor_1;
            valor_1= valor_5;
            valor_5= aux;
        }

        if(valor_2 > valor_3) {
            aux= valor_2;
            valor_2= valor_3;
            valor_3= aux;
        }
        if (valor_2 > valor_4) {
            aux= valor_2;
            valor_2= valor_4;
            valor_4= aux;
        }
        if (valor_2 > valor_5) {
            aux= valor_2;
            valor_2= valor_5;
            valor_5= aux;
        }
        
        if (valor_3 > valor_4) {
            aux= valor_3;
            valor_3= valor_4;
            valor_4= aux;
        }
        if (valor_3 > valor_5) {
            aux= valor_3;
            valor_3= valor_5;
            valor_5= aux;
        }
        
        if (valor_4 > valor_5) {
            aux= valor_4;
            valor_4= valor_5;
            valor_5= aux;
        }
        
        System.out.println("Seus números em ordem crescente ficam: " + valor_1 + ", " + valor_2 + ", " + valor_3 + ", " + valor_4 + ", " + valor_5 + ".");
        // ", " é o espaço entre cada valor e "." é o ponto final.
        System.out.println("-> A partir disso, temos que: ");
        System.out.println("Ao descartar o maior e o menor valor, a média dos números é igual a: " + ((valor_2 + valor_3 + valor_4)/3));
        System.out.println("Ao descartar os dois menores valores, a média dos números é igual a: " + ((valor_3 + valor_4 + valor_5)/3));
    }
}
