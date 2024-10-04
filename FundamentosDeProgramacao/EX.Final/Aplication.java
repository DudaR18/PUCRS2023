import java.util.*;

public class Aplication {

    static boolean rand = false;

    static Scanner in = new Scanner(System.in); 

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void random(CadastroPacientes[] cad) {
        if (rand == false) {
            for (int i = 0; i < cad.length; i++) {
                for (int j = 0; j < cad[i].getLength(); j++) {
                    cad[i].add("jeff"+j, 21039+j, 123132, "Nem sei oq é isso", 1, 12);
                }
            }
        } else System.out.println("Pacientes já foram preenchidos anteriormente");
    }

    public static void random2 (Clinica c) {
        if (rand == false) {
            for (int i = 0; i < c.getLength(); i++) {
                c.addCad(("set"+i), (1+i));
            }
        } else System.out.println("Setores já foram preenchidos anteriormente");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public static boolean addpac(Clinica c, int i) {

        if(c.cad[i].testa()==false) return false;

        System.out.println("Insira o nome do paciente: ");
        String n = in.next();
        System.out.println("Insira o cpf do paciente: ");
        int cpf = in.nextInt();
        System.out.println("Insira o telefone do paciente: ");
        int t = in.nextInt();
        System.out.println("Insira o convenio do paciente: ");
        String con = in.next();
        System.out.println("Insira o diagnostico do paciente: (1- Covid / 2- Dengue / 3- Influenza / 4- Meningite / 5- Outro)");
        int d = in.nextInt();
        System.out.println("Insira o numero de consultas no mes do paciente: ");
        int nmr = in.nextInt();

        c.cad[i].add(n, cpf, t, con, d, nmr);
        return true;

    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void menuC(Clinica c){
        /* Scanner in = new Scanner(System.in); */
        int opt;
        int id;
        boolean clinic = false;

        do {

            if (clinic == false) {
                System.out.println("\n---------- Menu ---------------------------------\n\n1.Cadastrar clínica\n0.Encerrar Sistema");
                System.out.print("insira a opcao desejada: ");
                opt = in.nextInt();
                System.out.println();
                switch (opt) {
                    case 1:
                        System.out.println("Insira o número de setores da clínica:");
                        int nc = in.nextInt();
                        c = new Clinica(nc);
                        clinic = true;
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }

            else {
                System.out.println("\n---------- Menu ---------------------------------\n\n1.Cadastrar um setor da clínica\n2.Remover setor\n3.Mostrar setores"+
                "\n4.Selecionar setor para ver mais opções\n5.Mostrar visão geral da clínica\n6.Preencher clínica automaticamente para testes no sistema\n0.Encerrar Sistema");
                System.out.print("insira a opcao desejada: ");
                opt = in.nextInt();
                System.out.println();
                switch (opt) {
                    case 1:
                        System.out.println("Insira o nome do setor: ");
                        String nm = in.next();
                        System.out.println("Insira a quantidade disponível de pacientes no setor: ");
                        int nmr = in.nextInt();
                        c.addCad(nm, nmr);
                        break;
                    case 2:
                        System.out.println("Insira o id do setor a ser removido: ");
                        id = in.nextInt();
                        c.remove(id);
                    case 3:
                        c.printS();
                        break;
                    case 4:
                        System.out.println("Insira o id do setor a ser explorado: ");
                        id = in.nextInt();
                        testa(id, c);
                        break;
                    case 5:
                        c.printG();
                        break;
                    case 6:
                        random2(c);
                        random(c.cad);
                        rand = true;
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
        } while (opt!=0);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void testa(int id, Clinica c) {
        for (int i = 0; i < c.getNset(); i++) {
            if(c.getIdSetor(i)==id) menuS(i, c);
        }   
        System.out.println("Id não encontrado");
    }

    public static void menuS(int id, Clinica c) {

        Scanner in = new Scanner(System.in);

        int opt;
        int cpf;
        boolean cont = true;

        do {
            System.out.println("\n---------- Menu Setor " + (id+1) + " ---------------------------------\n\n1.Adicionar paciente no cadastro\n2.Remover paciente no cadastro\n3.Mostrar todos os pacientes cadastrados"+
            "\n4.Ordem alfabética dos nomes dos pacientes\n5.Média das consultas dos pacientes cadastrados\n6.Porcentagem dos diagnósticos dos pacientes\n7.Custo total do paciente por mês\n0.Voltar ao menu geral\n");
            System.out.print("insira a opcao desejada: ");
            opt = in.nextInt();
            System.out.println();
            switch (opt) {
                case 1:
                    addpac(c, id);
                    break;
                case 2:
                    System.out.println("Insira o cpf do paciente a ser removido: ");
                    cpf = in.nextInt();
                    c.cad[id].remove(cpf);
                    break;
                case 3:
                    System.out.println(c.cad[id].printsolo());
                    break;
                case 4:
                    c.cad[id].ordA();
                    break;
                case 5:
                    c.cad[id].medCon();
                    break;
                case 6:
                    c.cad[id].porsche();
                    break;
                case 7:
                    System.out.println("Insira o cpf do paciente que voce deseja saber o custo total: ");
                    cpf = in.nextInt();
                    c.cad[id].tCons(cpf);
                    break;
                case 0:
                    cont = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            
            if(cont==false) break;

        } while (opt!=0);

        menuC(c);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        Clinica c = new Clinica(0);
        menuC(c);
        
    }
}
