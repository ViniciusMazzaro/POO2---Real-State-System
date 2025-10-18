/**
 * Enum que representa os possíveis status de um aluguel
 */
public enum StatusAluguel_ViniciusMazzaro {
    ATIVO("Ativo"),
    ATRASADO("Atrasado"),
    FINALIZADO("Finalizado");
    
    private String descricao;
    
    StatusAluguel_ViniciusMazzaro(String descricao) {
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