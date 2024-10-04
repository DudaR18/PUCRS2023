import java.util.*;

public class Paciente {

    Scanner in = new Scanner(System.in);

    private String nome;
    private int cpf;
    private int tel;
    private String con;
    private String diag;
    private int nmr;

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public Paciente(String n, int c, int t, String con, int d, int nmr) {
        this.nome = n;
        this.cpf = c;
        this.tel = t;
        this.con = con;
        this.diag = diag(d);
        this.nmr = nmr;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    //retorna os valores das variaveis
    public String getNome() {
        return this.nome;
    }
    public int getCpf() {
        return this.cpf;
    }
    public int getTel() {
        return this.tel;
    }
    public String getCon() {
        return this.con;
    }
    public String getDiag() {
        return this.diag;
    }
    public int getNmr() {
        return this.nmr;
    }

    ///////////////////////////////////////////////////

    //altera o valor das variaveis
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public void setTel(int tel) {
        this.tel = tel;
    }
    public void setCon(String con) {
        this.con = con;
    }
    public void setDiag(int diag) {
        this.diag = diag(diag);
    }
    public void setNmr(int nmr) {
        this.nmr = nmr;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public void total() {
        System.out.println("Insira o valor por consulta: ");
        double v = in.nextInt();
        double vt = v*this.nmr;
        System.out.println("\nValor total no mês: " + vt + "\n");
    }

    public String diag(int d) {

        switch (d) {
            case 1:
                return "covid";
        
            case 2:
                return "dengue";
        
            case 3:
                return "influenza";
        
            case 4:
                return "meningite";
        
            case 5:
                return outro();
        
            default:
                return "erro";
        
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public String outro() {
        System.out.println("Digite o diagnostico: ");
        String d = in.next();
        return d;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public String toString() {
        String msg = "Nome: " + this.nome + "\nCpf: " + this.cpf
        + "\nTelefone: " + this.tel + "\nConvênio: " + this.con 
        + "\nDiagnostico: " + this.diag + "\nNúmero de consultas no mês: " + this.nmr +"\n";
        return msg;
    }

}