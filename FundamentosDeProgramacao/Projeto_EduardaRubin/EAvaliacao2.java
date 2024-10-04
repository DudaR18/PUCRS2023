/**
 * Avaliação 2.
 * 
 * @Eduarda Rubin 
 * @27/03
 */
import java.util.Scanner;
public class EAvaliacao2
{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("\fA água está sólida, líquida ou gasosa?");
        System.out.println("--------------------");
        System.out.println("Insira uma temperatura qualquer desejada: ");
        double temperatura = in.nextDouble();
        
        System.out.println("--------------------");
        System.out.println("Escolha dentre as opções: ");
        System.out.println("1- Celsius");
        System.out.println("2- Fahrenheit");
        
        int escala = in.nextInt();
        
        System.out.println("--------------------");
        if (escala == 1) {
            System.out.println("Escala escolhida: Celsius.");
         if (temperatura >= 100) {
            System.out.println("O estado correspondente é: GASOSO.");
        } else if (temperatura < 100 && temperatura >= 0) {
            System.out.println("O estado correspondente é: LIQUIDO.");
        } else if (temperatura < 0) {
            System.out.println("O estado correspondente é: SÓLIDO.");
        }
    } else if (escala == 2) {
        System.out.println("Escala escolhida: Fahrenheit.");
        if (temperatura >= 212) {
            System.out.println("O estado correspondente é: GASOSO.");
        } else if (temperatura < 212 && temperatura >= 32) {
            System.out.println("O estado correspondente é: LIQUIDO.");
        } else if (temperatura < 32) {
            System.out.println("O estado correspondente é: SÓLIDO.");
        }
    }
    }
}
