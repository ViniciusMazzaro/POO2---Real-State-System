package Principal_ViniciusMazzaro;
import java.security.Principal;
import java.util.ArrayList;
import Seguros_ViniciusMazzaro.Seguro;
import Usuarios_ViniciusMazzaro.Cliente;
import Usuarios_ViniciusMazzaro.Corretor;
import Imoveis_ViniciusMazzaro.Imovel;
import java.time.LocalDate;
import Pagamentos_ViniciusMazzaro.Aluguel;

    public class Imobiliaria {
        private String nome;
        private String endereco;
        private ArrayList<Aluguel> alugueis;
        private ArrayList<Venda> vendas;
        private ArrayList<Imovel> imoveis;
        private ArrayList<Usuario> clientes;
        private ArrayList<Usuario> corretores;
        private ArrayList<Seguro> seguros;
        private Configuracao configuracoes;

        public Imobiliaria() {}

        public Imobiliaria(String nome, String endereco) {
            this.nome = nome;
            this.endereco = endereco;
        }

        // Getters e Setters
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEndereco() {
            return endereco;
        }
        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public ArrayList<Aluguel> getAlugueis() {
            return alugueis;
        }
        public void setAlugueis(ArrayList<Aluguel> alugueis) {
            this.alugueis = alugueis;
        }

        public ArrayList<Venda> getVendas() {
            return vendas;
        }
        public void setVendas(ArrayList<Venda> vendas) {
            this.vendas = vendas;
        }

        public ArrayList<Imovel> getImoveis() {
            return imoveis;
        }
        public void setImoveis(ArrayList<Imovel> imoveis) {
            this.imoveis = imoveis;
        }

        public ArrayList<Usuario> getClientes() {
            return clientes;
        }
        public void setClientes(ArrayList<Usuario> clientes) {
            this.clientes = clientes;
        }

        public ArrayList<Usuario> getCorretores() {
            return corretores;
        }
        public void setCorretores(ArrayList<Usuario> corretores) {
            this.corretores = corretores;
        }

        public ArrayList<Seguro> getSeguros() {
            return seguros;
        }
        public void setSeguros(ArrayList<Seguro> seguros) {
            this.seguros = seguros;
        }

        public Configuracao getConfiguracoes() {
            return configuracoes;
        }
        public void setConfiguracoes(Configuracao configuracoes) {
            this.configuracoes = configuracoes;
        }

        @Override
        public String toString() {
            return "Imobiliaria {" +
                    "nome='" + nome + '\'' +
                    ", endereco='" + endereco + '\'' +
                    ", totalImoveis=" + imoveis.size() +
                    ", totalClientes=" + clientes.size() +
                    ", totalCorretores=" + corretores.size() +
                    ", totalVendas=" + vendas.size() +
                    ", totalAlugueis=" + alugueis.size() +
                    ", totalSeguros=" + seguros.size() +
                    '}';
        }
    }

