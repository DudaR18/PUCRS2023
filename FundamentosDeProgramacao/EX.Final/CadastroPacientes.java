import java.util.Scanner;

public class CadastroPacientes {

    private int ocpt;
    private Paciente v[];
    private String nomesetor;
    private static int nid = 1;
    private int id;

    ///////////////////////////////////////////////////

    public CadastroPacientes(String ns,int n) {
        this.v = new Paciente[n];
        this.nomesetor = ns;
        this.id = nid++;
        ocpt = 0;
    }

    //////////////////////////////////////////////////

    public int getLength() {
        return this.v.length;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNomesetor() {
        return this.nomesetor;
    }
    public void setNomesetor(String nomesetor) {
        this.nomesetor = nomesetor;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////


    public boolean add(String n, int c, int t, String con, int d, int nmr){   

        /* if(testa()==false) return false; */
        for (int i = 0; i < v.length; i++) {
            if (v[i] == null) break;
            else if(v[i].getCpf()==c) {
                System.out.println("Cpf já registrado no cadastro");
                return false;
            }
        }
        
        v[ocpt] = new Paciente(n, c, t, con, d, nmr);
        ocpt++;
        return true;

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean testa() {
        if(ocpt==v.length) {
            System.out.println("Registro de pacientes ja esta cheio\n");
            return false;
        }
        else return true;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean remove(double c){

        for (int i = 0; i < ocpt; i++) {

            if (v[i].getCpf()==c) {

                for (int j = i; j < ocpt-1; j++) {
                    v[j] = v[j+1];
                }

                ocpt--;
                v[ocpt] = null;
                System.out.println("Paciente removido com sucesso\n");
                return true;

            }
           
        }

        System.out.println("Cpf não encontrado");
        return false;

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /* public void print() {
        System.out.println("Pacientes Registrados: \n");
        for (int i = 0; i < ocpt; i++) {
            System.out.println("______________________________________\n\n" + v[i].toString() + "______________________________________\n");
        }
    } */

    public String printsolo() {
        String msg = "Pacientes Registrados: \n";
        for (int i = 0; i < ocpt; i++) {
            msg += "______________________________________\n\n" + v[i].toString() + "______________________________________\n";
        }
        return msg;
    } 

    public String printf() {
        String msg = "Pacientes Registrados: \n";
        for (int i = 0; i < ocpt; i++) {
            msg += "\n" + v[i].toString() + "\n";
        }
        return msg;
    } 

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void ordA() {
        String nomes[] = new String[ocpt];
        for (int i = 0; i < nomes.length; i++) {
            nomes[i] = v[i].getNome();
        }
        String aux;
        int r;
        for(int i=0; i<nomes.length-1; i++){
            for(int j=0; j<nomes.length-1-i; j++){
                r = nomes[j].compareToIgnoreCase(nomes[j+1]);
                if(r>0){
                    aux = nomes[j];
                    nomes[j] = nomes[j+1];
                    nomes[j+1] = aux;
                }
            }
        }
        System.out.println("Nomes dos pacientes em ordem alfabetica: \n");
        for (int i = 0; i < nomes.length; i++) {
            System.out.print(nomes[i] + " ");
        }
        System.out.println("\n");

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void medCon() {
        int med = 0;
        for (int i = 0; i < ocpt; i++) {
            med += v[i].getNmr();
        }
        med /= ocpt;
        System.out.println("Media das consultas dos pacientes cadastrados: " + med + "\n");
    }

    public void porsche() {
        String d1 = "Indices de Covid: \n", d2 = "Indices de Dengue: \n", d3 = "Indices de Influenza: \n", d4 = "Indices de Meningite: \n", d5 = "Indices de Outro: \n";
        double p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0;
        for (int i = 0; i < ocpt; i++) {
            switch (v[i].getDiag()) {
                case "covid":
                    d1 = d1 + (i+1) + " - Nome do paciente - " + v[i].getNome() +"\n";
                    p1++;
                    break;
                case "dengue":
                    d2 = d2 + (i+1) + " - Nome do paciente - " + v[i].getNome() +"\n";
                    p2++;
                    break;
                case "influenza":
                    d3 = d3 + (i+1) + " - Nome do paciente - " + v[i].getNome() +"\n";
                    p3++;
                    break;
                case "meningite":
                    d4 = d4 + (i+1) + " - Nome do paciente - " + v[i].getNome() +"\n";
                    p4++;
                    break;
                default:
                    d5 = d5 + (i+1) + " - Nome do paciente - " + v[i].getNome() +"\n";
                    p5++;
                    break;
            }
        }

        p1 = (p1*100)/ocpt;
        p2 = (p2*100)/ocpt;
        p3 = (p3*100)/ocpt;
        p4 = (p4*100)/ocpt;
        p5 = (p5*100)/ocpt;
        System.out.println("Porcentagem de pacientes com \nCovid: " + p1 +"\n"+ d1 +"\n");
        System.out.println("Porcentagem de pacientes com \nDengue: " + p2 +"\n"+ d2 +"\n");
        System.out.println("Porcentagem de pacientes com \nInfluenza: " + p3 +"\n"+ d3 +"\n");
        System.out.println("Porcentagem de pacientes com \nMeningite: " + p4 +"\n"+ d4 +"\n");
        System.out.println("Porcentagem de pacientes com \nOutros: " + p5 +"\n"+ d5 +"\n");

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void altera() {
        Scanner in = new Scanner(System.in);
        System.out.println("Insira o cpf do paciente que deseja alterar: ");
        int cpf = in.nextInt();
        int index = -1;
        for (int i = 0; i < ocpt; i++) {
            if (v[i].getCpf()==cpf) index = i;
        }
        System.out.println("O que você deseja alterar?\n1.Nome\n2.Cpf\n3.Telefone\n4.Convenio\n5.Diagnóstico\n6.Nmr de consultas");
        int opt = in.nextInt();
        switch (opt) {
            case 1:
                System.out.println("Insira o novo nome:");
                String n = in.next();
                v[index].setNome(n);
                break;

            case 2:
                System.out.println("Insira o novo Cpf:");
                int c = in.nextInt();
                v[index].setCpf(c);
                break;

            case 3:
                System.out.println("Insira o novo Telefone:");
                int t = in.nextInt();
                v[index].setTel(t);
                break;

            case 4:
                System.out.println("Insira o novo Convenio:");
                String con = in.next();
                v[index].setCon(con);
                break;

            case 5:
                System.out.println("Insira o novo Diagnostico: (1- Covid / 2- Dengue / 3- Influenza / 4- Meningite / 5- Outro)");
                int d = in.nextInt();
                v[index].setDiag(d);
                break;

            case 6:
                System.out.println("Insira o novo Numero de consultas no mes:");
                int nmr = in.nextInt();
                v[index].setNmr(nmr);
                break;
        
            default:
                break;
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void tCons(int c) {
        for (int i = 0; i < ocpt; i++) {
            if(v[i].getCpf() == c) {
                v[i].total();
            } else System.out.println("Cpf não encontrado");
        }
    }

}
