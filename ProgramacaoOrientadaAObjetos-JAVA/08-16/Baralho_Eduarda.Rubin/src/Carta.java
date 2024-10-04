public class Carta {
    private Naipe naipe;
    private Valor valor;
    private boolean aberto; // se a carta está para cima

    Carta(Naipe naipe, Valor valor) {
        this.naipe = naipe;
        this.valor = valor;
        this.aberto = true;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public Valor getValor() {
        return valor;
    }

    public boolean isAberto() { // se a carta está para cima
        return aberto;
    }

    public void viraCarta() { // vira a carta pra baixo
        aberto = !aberto;
    }

    public boolean eMaior(Carta outra) {
        if (valor.ordinal() > outra.getValor().ordinal()) {
            return true;
        }
        return false;
    }

    public boolean igual(Carta outra) {
        if (valor.ordinal() == outra.getValor().ordinal()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Carta [naipe=" + naipe + ", valor=" + valor + ", aberto=" + aberto + "]";
    }
}
