package Pagamentos_ViniciusMazzaro;

import java.io.Serializable;


public abstract class FormaPagamento_ViniciusMazzaro implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected String tipoPagamento;
    
    public FormaPagamento_ViniciusMazzaro(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
     * @param valor Valor a ser pago
     * @return true se o pagamento foi processado com sucesso
     */
    public abstract boolean processar(double valor);
    
     * @return 
     */
    public abstract String getTipo();
    
    public String getTipoPagamento() {
        return tipoPagamento;
    }
    
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    @Override
    public String toString() {
        return "FormaPagamento{" +
               "tipoPagamento='" + tipoPagamento + '\'' +
               '}';
    }
}