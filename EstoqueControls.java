import static java.lang.Math.abs;

public class EstoqueControls implements Estoque {
    private int estoque = 0;

    public EstoqueControls(int estoque) {
        this.estoque = estoque;
    }

    public int getEstoque() {
        return estoque;
    }

    @Override
    public void adicionarEstoque(int peca) throws EntradaInvalidaException {
        if (peca < 1)
            throw new EntradaInvalidaException("Adicione pelo menos 1 peça!");
        else
            estoque += peca;
    }

    @Override
    public void retirarEstoque(int retirado) throws EntradaInvalidaException {
        if (retirado < 1) {
            throw new EntradaInvalidaException("Retire pelo menos 1 peça!");
        }
        if (retirado > estoque) {
            int excesso = retirado - estoque;
            throw new EntradaInvalidaException("Estoque insuficiente, você tentou retirar " + excesso + " além do estoque!");
        }
        else {
            estoque -= retirado;
        }
    }
}
