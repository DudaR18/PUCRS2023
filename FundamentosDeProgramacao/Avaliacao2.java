import java.util.Scanner;

public class E2_EduardaRubin_Matthaus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = 0, b = 0;

        do {
            if((b<a)||a<0||b<0) System.out.println("erro, os números têm que ser positivos e o segundo número tem que ser maior que o primeiro.");
            System.out.println("insira o primeiro número:");
            a = in.nextInt();
            System.out.println("insira o segundo número:");
            b = in.nextInt();
        }while(b<a || a<0 || b<0);

        System.out.println("A soma dos números ímpares: " + sumImp(a, b));
        System.out.println("A quantidade de números pares: " + pares(a, b));
        System.out.println("A média dos números primos do intervalo: " + media(a, b));

    }

    public static int sumImp(int a, int b) {

        int sum = 0;

        for (int i = a; i <= b; i++) {
            
            if (i%2!=0) {
                sum += i;
            }

        }

        return sum;

    }

    public static int pares(int a, int b) {

        int cont = 0;

        for (int i=a; i<=b; i++) {
            
            if (i%2 == 0) {
                cont++;
            }

        }
    
        return cont;

    }

    public static double media(int a, int b) {

        double media, sum = 0, cont = 0;

        for (int i = a; i <= b; i++) {
            if (((i%2!=0) && (i%3!=0)) || i==2 || i==3 ) {
                //System.out.println(i + " é primo");
                sum+=i;
                cont++;
            }
        }

        media = sum/cont;

        return media;

    }
}
