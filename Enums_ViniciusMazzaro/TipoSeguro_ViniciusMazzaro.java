/**
 * Enum que representa os tipos de seguro disponíveis
 */
public enum TipoSeguro_ViniciusMazzaro {
    ROUBO("Seguro Roubo", 150.00),
    DESASTRES_NATURAIS("Seguro Desastres Naturais", 200.00),
    INCENDIO("Seguro Incêndio", 180.00),
    COMPLETO("Seguro Completo", 450.00);
    
    private String descricao;
    private double valorBase;
    
    TipoSeguro_ViniciusMazzaro(String descricao, double valorBase) {
        this.descricao = descricao;
        this.valorBase = valorBase;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public double getValorBase() {
        return valorBase;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}