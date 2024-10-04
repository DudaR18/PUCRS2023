import java.util.Scanner;

public class appRetangulo {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("\fDê um valor para a Base: ");
        double b = in.nextDouble();
        System.out.println("Dê um valor para a Altura: ");
        double a = in.nextDouble(); 

        Retangulo r1 = new Retangulo(a, b);
        System.out.println("altura: " + r1.getAltura());
        System.out.println("base: " + r1.getBase());
        System.out.println("area: " + r1.Area());
        System.out.println("Perimetro: " + r1.Perimetro());
        System.out.println("Diagonal: " + r1.diagonal());

        System.out.println("Você quer alterar os valores de r1? Digite 1 para SIM ou 2 para NAO ");
        int palavra=in.nextInt();


        if (palavra==1) {
            
            System.out.println("Digite um novo valor para a altura: ");
            double a2 = in.nextDouble();
            r1.setAltura(a2);
            System.out.println("Nova altura: "+ r1.getAltura());

            System.out.println("Digite um novo valor para a base: ");
            double b2 = in.nextDouble();
            r1.setBase(b2);
            System.out.println(r1.toString());
            System.out.println("Perimetro: " + r1.Perimetro());
            System.out.println("Diagonal: " + r1.diagonal());
            
        } else if (palavra==2) {
            System.out.println("ok. Fim :( )");
        }

        
    }

}
