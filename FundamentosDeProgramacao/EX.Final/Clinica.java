import java.util.Scanner;

public class Clinica {

    private int nset;
    protected CadastroPacientes cad[];

    ///////////////////////////////////////////////////

    public Clinica(int n) {
        this.cad = new CadastroPacientes[n];
        this.nset = 0;
    }

    ///////////////////////////////////////////////////

    public int getIdSetor(int i) {
        return cad[i].getId();
    }

    public int getLength() {
        return this.cad.length;
    }

    public int getNset() {
        return this.nset;
    }

    ///////////////////////////////////////////////////

    public boolean addCad(String nm, int n){   

        boolean t = false;

        for (int i = 0; i < cad.length; i++) {
            if (cad[i] == null) {
                t = true;
                break;
            } 
        }

        if (t == true) {
            cad[nset] = new CadastroPacientes(nm, n);
            nset++;
            return true;
        } else {
            System.out.println("\nClínica cheio!");
            return false;
        }

    }

    ///////////////////////////////////////////////////

    public boolean remove(double c){

        for (int i = 0; i < nset; i++) {

           if (cad[i].getId()==c) {

                for (int j = i; j < nset-1; j++) {
                    cad[j] = cad[j+1];
                }

                nset--;
                cad[nset] = null;
                System.out.println("Setor removido com sucesso");
                return true;

           }
           
        }

        System.out.println("Id não encontrado");
        return false;

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void printS() {
        System.out.println("Setores Registrados: \n");
        for (int i = 0; i < nset; i++) {
            System.out.println("________________________________________\n\nSetor:" + (i+1) + " Nome:" + cad[i].getNomesetor() + " ID:" + cad[i].getId() + " Qtd.Pacientes:" + cad[i].getLength() + "\n________________________________________\n");
        }
    }

    public void printG() {
        System.out.println("Setores Registrados: \n");
        for (int i = 0; i < nset; i++) {
            System.out.println("________________________________________\n\nSetor:" + (i+1) + " Nome:" + cad[i].getNomesetor() + " ID:" + cad[i].getId() + " Qtd.Pacientes:" + cad[i].getLength() + "\n\n" + cad[i].printf() + "________________________________________\n");
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /* public void altera() {
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
    } */

}
