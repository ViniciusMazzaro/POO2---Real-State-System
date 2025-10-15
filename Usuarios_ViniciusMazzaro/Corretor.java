package Usuarios_ViniciusMazzaro;

import java.time.LocalDate;


public class Corretor {

    protected String creci;
    protected double salario;
    protected String pis;
    protected  LocalDate dataAdmissao;

    public Corretor() {}

    public Corretor(String creci, double salario, String pis) {
        this.creci = creci;
        this.salario = salario;
        this.pis = pis;
    }

    public String getCreci() {
        return creci;
    }
    public void setCreci(String creci) {
        this.creci = creci;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPis() {
        return pis;
    }
    public void setPis(String pis) {
        this.pis = pis;
    }
    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }
    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    @Override
    public String toString() {
        return "Corretor{" +
                "creci='" + creci + '\'' +
                ", salario=" + salario +
                ", pis='" + pis + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                ", " + super.toString() +
                "}";
    }



}