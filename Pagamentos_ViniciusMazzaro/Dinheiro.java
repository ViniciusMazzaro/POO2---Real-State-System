package Pagamentos_ViniciusMazzaro;
//FALTA ARRUMAR
public  class Dinheiro extends Pagamento {

    public Dinheiro() {}

    public Dinheiro(String tipoPagamento){
        super(tipoPagamento);
    }

    @Override
    public String toString() {
        return "Pagamento em Dinheiro {" +
                "tipoPagamento='" + getTipoPagamento() + '\'' +
                '}';
    }

}
