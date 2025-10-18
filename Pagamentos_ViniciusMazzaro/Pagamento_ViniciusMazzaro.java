package Pagamentos_ViniciusMazzaro;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Pagamento_ViniciusMazzaro implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contadorId = 1;
    
    private int id;
    private double valor;
    private LocalDate dataPagamento;
    private FormaPagamento_ViniciusMazzaro formaPagamento;
    private String descricao;
    private boolean aprovado;
    
    public Pagamento_ViniciusMazzaro(double valor, 
                                      FormaPagamento_ViniciusMazzaro formaPagamento,
                                      String descricao) {
        this.id = contadorId++;
        this.valor = valor;
        this.dataPagamento = LocalDate.now();
        this.formaPagamento = formaPagamento;
        this.descricao = descricao;
        this.aprovado = false;
    }
    

    public boolean processar() {
        this.aprovado = formaPagamento.processar(valor);
        return aprovado;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
    
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    public FormaPagamento_ViniciusMazzaro getFormaPagamento() {
        return formaPagamento;
    }
    
    public void setFormaPagamento(FormaPagamento_ViniciusMazzaro formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public boolean isAprovado() {
        return aprovado;
    }
    
    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
    
    public static void setContadorId(int contador) {
        contadorId = contador;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format(
            "=== PAGAMENTO #%d ===\n" +
            "Valor: R$ %.2f\n" +
            "Data: %s\n" +
            "Forma: %s\n" +
            "Descrição: %s\n" +
            "Status: %s",
            id,
            valor,
            dataPagamento.format(formatter),
            formaPagamento.getTipo(),
            descricao,
            aprovado ? "APROVADO" : "RECUSADO"
        );
    }
}