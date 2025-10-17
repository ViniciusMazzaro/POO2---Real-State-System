package Usuarios_ViniciusMazzaro;

import java.time.LocalDate;

public class Cliente extends Usuarios {

    protected LocalDate dataCadastro;

    public Cliente() {}

    public Cliente(int codigoUsuario, String nome, String cpf, String rg, LocalDate dataNascimento,
                   String endereco, String cep, String telefone, String email, LocalDate dataCadastro) {
        super(codigoUsuario, nome, cpf, rg, dataNascimento, endereco, cep, telefone, email);
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String toString() {
        return "Cliente{" +
                "dataCadastro=" + dataCadastro +
                ", " + super.toString() +
                "}";
    }
}