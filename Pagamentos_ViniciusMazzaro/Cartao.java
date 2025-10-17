
public class Cartao extends Pagamento {

    private String nome;
    private String numero;
    private String bandeira;

    public Cartao() {}

    public Cartao(String tipoPagamento, String nome, String numero, String bandeira) {
        super(tipoPagamento);
        this.nome = nome;
        this.numero = numero;
        this.bandeira = bandeira;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBandeira() {
        return bandeira;
    }
    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    @Override
    public String toString() {
        return "Pagamento com Cartão {" +
                "tipoPagamento='" + getTipoPagamento() + '\'' +
                ", nome='" + nome + '\'' +
                ", bandeira='" + bandeira + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}