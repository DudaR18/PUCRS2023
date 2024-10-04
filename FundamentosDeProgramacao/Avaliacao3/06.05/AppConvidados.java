import java.util.*;

/**
 * Escreva uma descrição da classe AppConvidados aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class AppConvidados
{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        ListaConvidados convidados = new ListaConvidados(10);
        convidados.inserir("Gabriel");
        convidados.inserir("João");
        convidados.inserir("Janna");
        convidados.inserir("Mati");
        convidados.inserir("Braum");
        convidados.inserir("Luxanna");
        convidados.inserir("Lulu");
        convidados.inserir("Florisvaldo");
        System.out.println(convidados);
        System.out.println();

        System.out.println(">> Removendo o último nome da lista: ");
        System.out.println();
        convidados.remover();
        System.out.println(convidados);

        System.out.println(">> Verificando se o nome está presente na lista: ");
        convidados.verifica("Florisvaldo");
        System.out.println();

        System.out.println(">> Editar um nome");
        System.out.println("Qual posição você quer alterar? ");
        int p = in.nextInt();
        convidados.edita(p);

        System.out.println(">> Lista em ordem alfabética: ");
        System.out.println();
        convidados.ordemA();

        System.out.println("Lista redefinida.");
        System.out.println();
        convidados.redefinir();
        System.out.println(convidados + " \nvazia.");

    }
}
