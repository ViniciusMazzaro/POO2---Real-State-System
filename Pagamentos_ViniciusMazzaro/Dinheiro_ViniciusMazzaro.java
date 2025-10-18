package Pagamentos_ViniciusMazzaro;


public class Dinheiro_ViniciusMazzaro extends FormaPagamento_ViniciusMazzaro {
    
    public Dinheiro_ViniciusMazzaro() {
        super("DINHEIRO");
    }
    
    @Override
    public boolean processar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: Valor inválido para pagamento!");
            return false;
        }
        
        System.out.println("Processando pagamento em Dinheiro...");
        System.out.printf("Valor: R$ %.2f\n", valor);
        System.out.println("Pagamento em Dinheiro aprovado!");
        return true;
    }
    
    @Override
    public String getTipo() {
        return "Dinheiro";
    }
    
    @Override
    public String toString() {
        return "Pagamento em Dinheiro {" +
               "tipoPagamento='" + getTipoPagamento() + '\'' +
               '}';
    }
}