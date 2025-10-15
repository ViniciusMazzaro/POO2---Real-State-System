package Pagamentos_ViniciusMazzaro;

public abstract class Pagamento {

    private String tipoPagamento;

    public Pagamento() {}

    public Pagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public abstract String toString();


}
