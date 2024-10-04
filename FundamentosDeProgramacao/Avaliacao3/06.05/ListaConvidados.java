import java.util.*;

/**
 * Você recebeu um problema inicialmente resolvido, 
 * porém você precisa entender o problema e dar continuidade
 * à solução...
 * Operacoes
 * 1)Inserir um convidado (nome) na lista ok
 * 2) Escrever a lista de convidados numerada ok
 * 3) Excluir um convidado da lista ok
 * 4) Verificar se um nome está na lista ok
 * 5) Editar um nome da lista ok
 * 6) Redefinir a quantidade de convidados da lista ok
 * 7) Ordenar a lista (ordem alfabetica) 
 */
public class ListaConvidados
{
    private String[] lista;
    private int posicao;
    
    public ListaConvidados(int quantidade){
        if(quantidade<5) quantidade = 5;
        lista = new String[quantidade];
        posicao = 0;
    }
    
    public boolean inserir(String nome){   
        if(posicao==lista.length) return false;
        lista[posicao] = nome;
        posicao++;
        return true;
    }

    /* public boolean removerN(String nome){   
        int i
        if(posicao==1) return false;
        for(i = 0; i < posicao; i++) {
            if(lista[i] == nome) {
                break;
            }
        }
        for(int j = i; j<posicao-1; j++) {
            String temp = lista[j];
            lista[j] = lista[j+1];
            lista[j+1] = temp;
        }
    } 
    Não foi terminado*/

    public boolean remover(){   
        if(posicao==1) return false;
        lista[posicao-1] = "";
        posicao--;
        return true;
    }
     
    public boolean verifica(String nome) {
        for (int i = 0; i < lista.length; i++) {
            if(lista[i] == nome) {
                System.out.println("O nome: " + nome + " está presente na lista na posição: " + i);
                return false;
            } 
        }
        System.out.println("O nome " + nome + " não está na lista.");
        return true;
    }

    public void edita(int p) {
        Scanner in = new Scanner(System.in);
        System.out.println("insira um novo nome: ");
        lista[p-1] = in.next();
        System.out.println(toString());
    }

    public void redefinir() {
        for (int i = 0; i < posicao; i++) {
            lista[i] = "";
        }
        posicao=0;
    }

    public void ordemA() {
        for (int i = 0; i < posicao; i++) {
            for (int j = i + 1; j < posicao; j++) {
                if (lista[i].compareTo(lista[j]) > 0) {
                    String temp = lista[i];
                    lista[i] = lista[j];
                    lista[j] = temp;
                }
            }
        }
        System.out.println(toString());
    }
    
    public String toString(){
        String msg = "Lista de Convidados\n";
        for(int i=0; i<posicao; i++){
            msg = msg + (i+1) + ". " + lista[i] + "\n";
        }
        return msg;
    }
}
