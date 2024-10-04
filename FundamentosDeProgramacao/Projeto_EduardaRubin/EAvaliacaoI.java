
/**
 * Avaliação 1
 * 
 * @EduardaRubin 
 * @17/03/2023
 */
import java.util.*;
public class EAvaliacaoI
{
    public static void main(String args[]){
        Scanner in= new Scanner(System.in);
        
        System.out.println("\fInforme quantos quartos tem no  hotel: ");
        int q = in.nextInt();
        System.out.println("Informe o valor da diaria por apartamentos durante o fim de semana: ");
        double d = in.nextDouble();
        
        double p = d - (d * 0.25); //p= promoção
        double v_total = d * q * 2;
        double v_pago = p * q * 2;
        double v_perdido = v_total - v_pago;
        
        System.out.println("O valor promocional da diaria durante o fim de semana é: "+ p);
        System.out.println("Caso a ocupação seja 100%, o valor total arrecadado vai ser: " + v_pago); //2 dias no fim de semana
        System.out.println("Caso a ocupação seja 70%, o valor total arrecadado vai ser: " + (v_pago * 0.70));
        System.out.println("O valor que o hotel deixará de arrecadar em virtude da promoção é:  " + v_perdido);
        }
        }
