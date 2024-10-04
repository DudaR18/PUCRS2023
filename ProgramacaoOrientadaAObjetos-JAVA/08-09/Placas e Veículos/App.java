public class App{
    public static void main(String args[]){
        Placa p1 = new Placa("Brasil","ABC1R23");
        Placa p2 = new Placa("Argentina","FSZ8R95");
        Placa p3 = new Placa("Japão","ABC1R23");
        
        Veiculo v1 = new Veiculo(p1);
        Veiculo v2 = new Veiculo(p2);
        Veiculo v3 = new Veiculo(p3);

        System.out.println(v1.toString());
        System.out.println("----------------");
        System.out.println(v2.toString());
        System.out.println("----------------");
        System.out.println(v3.toString());
        System.out.println("----------------");

        v1.setPais("Coréia");

        System.out.println(v1.toString());
        System.out.println("----------------");
        System.out.println(v2.toString());
        System.out.println("----------------");
        System.out.println(v3.toString());
        System.out.println("----------------");

        System.out.println("Dados do veiculo antes de abastecer:");
        System.out.println(v1);
        System.out.println("----------------");

        v1.abastece(65);
        System.out.println("Dados do veiculo depois de abastecer:");
        System.out.println(v1);
        System.out.println("----------------");

        v1.dirige(250);
        System.out.println("Dados do veiculo depois de percorrer 250Km:");
        System.out.println(v1);
        System.out.println("----------------");

        System.out.println("Dados do veiculo antes de abastecer:");
        System.out.println(v2);
        System.out.println("----------------");

        v2.abastece(60);
        System.out.println("Dados do veiculo depois de abastecer:");
        System.out.println(v2);
        System.out.println("----------------");

        v2.dirige(250);
        System.out.println("Dados do veiculo depois de percorrer 250Km:");
        System.out.println(v2);
        System.out.println("----------------");
        }
}