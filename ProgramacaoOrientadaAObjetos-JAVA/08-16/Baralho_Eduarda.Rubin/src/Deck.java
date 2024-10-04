import java.util.Random; //EDUARDA rubin

public class Deck {
    public final int TAMANHO = 104;
    private Random r;
    private Carta[] cartas;
    private int proxLivre;
    private Carta[] empate;
    private int tamanhoEmpate; // cartas no deckEmpate

    public Carta[] getCartas() {
        return cartas;
    }

    public Carta[] getEmpate() {
        return empate;
    }

    public Deck() {
        cartas = new Carta[TAMANHO];
        proxLivre = 0;
        r = new Random();
    }

    public boolean insereEmbaixo(Carta carta) { // insere a carta em baixo do monte
        if (proxLivre < TAMANHO - 1) {
            cartas[proxLivre] = carta;
            if (carta.isAberto()) {
                carta.viraCarta();
            }
            proxLivre++;
            return true;
        }
        return false;
    }

    public Carta retiraDeCima() { // retira a carta de cima do monte
        // Se o deck esta vazio retorna null
        if (proxLivre == 0) {
            return null;
        }
        // Se tem carta retira a de cima
        Carta deCima = cartas[0];
        for (int i = 0; i < proxLivre - 1; i++) {
            cartas[i] = cartas[i + 1];
        }
        proxLivre--;
        return deCima;
    }

    public int qtdadeCartas() {
        return proxLivre;
    }

    public boolean vazio() { // se o jogador esta com 0 cartas
        return qtdadeCartas() == 0;
    }

    public void embaralha() {
        if (tamanhoEmpate <= 1) { // não embaralha as cartas nessa condiçao
            return;
        }
        int vezes = 2000;
        while (vezes > 0) {
            int p1 = r.nextInt(qtdadeCartas());
            int p2 = r.nextInt(qtdadeCartas());
            Carta aux = cartas[p1];
            cartas[p1] = cartas[p2];
            cartas[p2] = aux;
            vezes--;
        }
    }

    // Recebe cartas no deckEmpate
    public void recebeCartas(Deck empatDeck) {
        Carta[] cartasEmpate = new Carta[TAMANHO];
        tamanhoEmpate = 0;

        // Copia as cartas do deckEmpate para um decck temporário
        while (!empatDeck.vazio()) {
            cartasEmpate[tamanhoEmpate] = empatDeck.retiraDeCima();
            tamanhoEmpate++;
        }

        // gerador de num random para determinar a ordem das cartas
        for (int i = tamanhoEmpate - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Carta aux2 = cartasEmpate[i];
            cartasEmpate[i] = cartasEmpate[j];
            cartasEmpate[j] = aux2;
        }

        // Incorpora as cartas ao deck do jogador na nova ordem
        for (int i = 0; i < tamanhoEmpate; i++) {
            insereEmbaixo(cartasEmpate[i]);
        }
    }

    // Limpa todas as cartas do deckEmpate
    public void limpa() {
        empate = new Carta[TAMANHO];
        tamanhoEmpate = 0;
    }

}
