import java.time.LocalDate;

public class CasaResidencial extends Imovel {

    public CasaResidencial(int codigoImovel, String endereco, LocalDate dataConstrucao, float areaTotal,
                           float areaConstruida, int qtdDormitorios, int qtdBanheiros, int qtdVagasGaragem,
                           float valorIPTU, float valorVenda, float valorAluguel) {
        super(codigoImovel, endereco, dataConstrucao, areaTotal, areaConstruida,
                qtdDormitorios, qtdBanheiros, qtdVagasGaragem, valorIPTU, valorVenda, valorAluguel);
    }

    @Override
    public float getValorAluguel() {
        return this.valorAluguel;
    }

    @Override
    public String toString() {
        return "CasaResidencial{" + super.toString() + "}";
    }
}
