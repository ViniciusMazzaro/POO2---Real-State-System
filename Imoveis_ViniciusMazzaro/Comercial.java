import java.time.LocalDate;


public class Comercial extends Imovel {

    protected float taxaImpostoFederal;

    public Comercial(int codigoImovel, String endereco, LocalDate dataConstrucao, float areaTotal,
                     float areaConstruida, int qtdDormitorios, int qtdBanheiros, int qtdVagasGaragem,
                     float valorIPTU, float valorVenda, float valorAluguel, float taxaImpostoFederal) {

        super(codigoImovel, endereco, dataConstrucao, areaTotal, areaConstruida,
                qtdDormitorios, qtdBanheiros, qtdVagasGaragem, valorIPTU, valorVenda, valorAluguel);
        this.taxaImpostoFederal = taxaImpostoFederal;
    }

    public float getTaxaImpostoFederal() {
        return taxaImpostoFederal;
    }
    public void setTaxaImpostoFederal(float taxaImpostoFederal) {
        this.taxaImpostoFederal = taxaImpostoFederal;
    }

    @Override
    public float getValorAluguel() {
        return this.valorAluguel + (this.valorAluguel * this.taxaImpostoFederal);
    }

    @Override
    public String toString() {
        return "Comercial{" +
                "taxaImpostoFederal=" + taxaImpostoFederal +
                ", " + super.toString() +
                "}";
    }
}
