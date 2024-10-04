import java.util.Scanner;

//EDUARDA rubin
public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("--- JOGO DE CARTAS ---");
        System.out.println("  ");
        System.out.println(
                "Imformações: \n O baralho é distribuído entre dois jogadores e a cada rodada os jogadores devem jogar as cartas de cima de seu deck. A carta com maior valor numérico ganha a rodada e o jogador recebe as duas cartas jogadas. Caso ocorra algum empate, o resultado será decidido na próxima rodada. Ganha aquele que possuir todas as 52 carta em seu deck.");
        System.out.println("  ");

        // Pede o nome dos jogadores
        System.out.println("Digite o nome do jogador 1: ");
        String nomeJog1 = in.next();
        System.out.println("Digite o nome do jogador 2: ");
        String nomeJog2 = in.next();

        // Cria o baralho e embaralha
        Baralho baralho = new Baralho();
        baralho.embaralha();

        // Cria os decks dos jogadores
        Deck jogador1 = new Deck();
        Deck jogador2 = new Deck();
        Deck empate = new Deck(); // deck de empate (onde as cartas de empate vão ficar)

        // Distribui todas as cartas entre os dois jogadores
        while (!baralho.vazio()) {
            jogador1.insereEmbaixo(baralho.retiraDeCima());
            jogador2.insereEmbaixo(baralho.retiraDeCima());
        }

        // Loop do jogo
        boolean acabou = false;
        int rodada = 1;
        while (!acabou) {
            // Embaralha as cartas após cada rodada
            jogador1.embaralha();
            jogador2.embaralha();

            // Pega uma carta de cada jogador
            Carta cj1 = jogador1.retiraDeCima();
            Carta cj2 = jogador2.retiraDeCima();
            System.out.println("------");
            System.out.println("-> Rodada: " + rodada);
            System.out.println("Cada jogador joga uma carta na mesa!");
            System.out.println(
                    "Temos na mesa uma carta de cada jogadore e " + empate.qtdadeCartas() + " cartas do DeckEmpate.");
            System.out.println("  ");

            // Mostra o número de cartas que cada jogador possui
            System.out.println(nomeJog1 + " possui " + jogador1.qtdadeCartas() + " cartas depois de jogar na mesa.");
            System.out.println(nomeJog2 + " possui " + jogador2.qtdadeCartas() + " cartas depois de jogar na mesa.");
            System.out.println("DeckEmpate possui " + empate.qtdadeCartas() + " cartas.");
            System.out.println("  ");

            System.out.println("Carta de " + nomeJog1 + ":" + cj1.toString());
            System.out.println("Carta de " + nomeJog2 + ":" + cj2.toString());
            System.out.println("  ");

            if (cj1.eMaior(cj2)) {
                if (!empate.vazio()) {
                    System.out.println(
                            nomeJog1 + " GANHOU a rodada de empate e RECEBEU todas as cartas acumuladas do empate.");
                    System.out.println("  ");
                    jogador1.recebeCartas(empate);
                    // Limpa o deck de empate após transferir as cartas
                    empate.limpa();

                    System.out.println(nomeJog1 + " recebeu as cartas de empate e agora possui "
                            + jogador1.qtdadeCartas() + " cartas.");
                    System.out.println(nomeJog2 + " agora possui " + jogador2.qtdadeCartas() + " cartas.");
                    System.out.println("  ");
                }
                jogador1.insereEmbaixo(cj1);
                jogador1.insereEmbaixo(cj2);
                System.out.println(nomeJog1 + " GANHOU a rodada e RECEBEU as cartas jogadas da rodada!");
            } else if (cj2.eMaior(cj1)) {
                if (!empate.vazio()) {
                    System.out
                            .println(nomeJog2 + " GANHOU a rodada de empate e RECEBEU as cartas acumuladas do empate.");
                    System.out.println("  ");
                    jogador2.recebeCartas(empate);
                    empate.limpa();

                    System.out.println(nomeJog1 + " agora possui " + jogador1.qtdadeCartas() + " cartas.");
                    System.out.println(nomeJog2 + " recebeu as cartas de empate e agora possui "
                            + jogador2.qtdadeCartas() + " cartas.");
                    System.out.println("  ");
                }
                jogador2.insereEmbaixo(cj2);
                jogador2.insereEmbaixo(cj1);
                System.out.println(nomeJog2 + " GANHOU a rodada e RECEBEU as cartas jogadas da rodada!");
            } else {
                System.out.println("Empate!");
                empate.insereEmbaixo(cj2);
                empate.insereEmbaixo(cj1);
            }

            // Verifica se acabou
            if (jogador1.vazio() || jogador2.vazio()) {
                // acabou = true;
                break;
            }
            // Incrementa a rodada
            rodada++;
        }
        // Verifica quem ganhou o jogo com base no jogador com o deck vazio
        if (jogador1.vazio() && !jogador2.vazio()) {
            System.out.println("------");
            System.out.println("  ");
            System.out.println(
                    "PARABÉNS! -" + nomeJog2 + "- GANHOU o jogo com " + jogador2.qtdadeCartas() + " cartas! :) ");
            System.out.println("  ");
            System.out
                    .println("POXA! -" + nomeJog1 + "- PERDEU o jogo com " + jogador1.qtdadeCartas() + " cartas! :( ");
            System.out.println("  ");
            System.out.println("------");
        } else {
            System.out.println("------");
            System.out.println("  ");
            System.out.println(
                    "PARABÉNS! -" + nomeJog1 + "- GANHOU o jogo com " + jogador1.qtdadeCartas() + " cartas! :) ");
            System.out.println("  ");
            System.out
                    .println("POXA! -" + nomeJog2 + "- PERDEU o jogo com " + jogador2.qtdadeCartas() + " cartas! :( ");
            System.out.println("  ");
            System.out.println("------");
        }
        System.out.println("------");
        System.out.println("  ");
        System.out.println("FIM DO JOGO!");
    }
}
