/**
 * Enum que representa os possíveis status de um imóvel
 */
public enum StatusImovel_ViniciusMazzaro {
    DISPONIVEL("Disponível"),
    ALUGADO("Alugado"),
    VENDIDO("Vendido");
    
    private String descricao;
    
    StatusImovel_ViniciusMazzaro(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}