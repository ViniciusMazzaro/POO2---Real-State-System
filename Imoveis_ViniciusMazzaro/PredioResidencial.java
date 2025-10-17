import java.time.LocalDate;

public class PredioResidencial extends Imovel {

    protected int andar;
    protected float valorCondominio;

    public PredioResidencial(int codigoImovel, String endereco, LocalDate dataConstrucao, float areaTotal,
                             float areaConstruida, int qtdDormitorios, int qtdBanheiros, int qtdVagasGaragem,
                             float valorIPTU, float valorVenda, float valorAluguel,
                             int andar, float valorCondominio) {
        super(codigoImovel, endereco, dataConstrucao, areaTotal, areaConstruida,
                qtdDormitorios, qtdBanheiros, qtdVagasGaragem, valorIPTU, valorVenda, valorAluguel);
        this.andar = andar;
        this.valorCondominio = valorCondominio;
    }

    public int getAndar() {
        return andar;
    }
    public void setAndar(int andar) {
        this.andar = andar;
    }

    public float getValorCondominio() {
        return valorCondominio;
    }
    public void setValorCondominio(float valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    @Override
    public float getValorAluguel() {
        return this.valorAluguel + this.valorCondominio;
    }

    @Override
    public String toString() {
        return "ApartamentoResidencial{" +
                "andar=" + andar +
                ", valorCondominio=" + valorCondominio +
                ", " + super.toString() +
                "}";
    }
}