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
    public void adicionarEstoque(int peca) throws EntradaInvalidaException{
        if (peca < 1)
            throw new EntradaInvalidaException("Adicione pelo menos 1 peça!");
        else
            estoque += peca;
    }

    @Override
    public void retirarEstoque(int retirado) throws EntradaInvalidaException {
        int restante = abs(estoque - retirado);

        if ( estoque - retirado == 0) {
            throw new EntradaInvalidaException("Estoque esvaziado, você retirou " + restante +" alem do estoque!");
        }
        if (retirado > estoque)
            throw new EntradaInvalidaException("Retire pelo menos 1 peça!");
        else
            estoque -= retirado;
    }
}
