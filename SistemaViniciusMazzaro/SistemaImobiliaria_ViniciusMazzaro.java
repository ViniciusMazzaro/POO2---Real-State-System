import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe principal do sistema de imobiliária
 * Gerencia todas as operações e entidades do sistema
 */
public class SistemaImobiliaria_ViniciusMazzaro {
    
    private List<Cliente_ViniciusMazzaro> clientes;
    private List<Corretor_ViniciusMazzaro> corretores;
    private List<Imovel_ViniciusMazzaro> imoveis;
    private List<Venda_ViniciusMazzaro> vendas;
    private List<Aluguel_ViniciusMazzaro> alugueis;
    private List<Seguro_ViniciusMazzaro> seguros;
    private GerenciadorArquivos_ViniciusMazzaro gerenciadorArquivos;
    
    public SistemaImobiliaria_ViniciusMazzaro() {
        this.clientes = new ArrayList<>();
        this.corretores = new ArrayList<>();
        this.imoveis = new ArrayList<>();
        this.vendas = new ArrayList<>();
        this.alugueis = new ArrayList<>();
        this.seguros = new ArrayList<>();
        this.gerenciadorArquivos = new GerenciadorArquivos_ViniciusMazzaro();
        inicializarSeguros();
    }
    
    /**
     * Inicializa os tipos de seguros disponíveis no sistema
     */
    private void inicializarSeguros() {
        seguros.add(new SeguroRoubo_ViniciusMazzaro());
        seguros.add(new SeguroDesastres_ViniciusMazzaro());
        seguros.add(new SeguroIncendio_ViniciusMazzaro());
        seguros.add(new SeguroCompleto_ViniciusMazzaro());
    }
    
    // ==================== CADASTROS ====================
    
    /**
     * Cadastra um novo cliente
     */
    public boolean cadastrarCliente(Cliente_ViniciusMazzaro cliente) {
        if (cliente == null || buscarClientePorCpf(cliente.getCpf()) != null) {
            return false;
        }
        return clientes.add(cliente);
    }
    
    /**
     * Cadastra um novo corretor
     */
    public boolean cadastrarCorretor(Corretor_ViniciusMazzaro corretor) {
        if (corretor == null || buscarCorretorPorCreci(corretor.getCreci()) != null) {
            return false;
        }
        return corretores.add(corretor);
    }
    
    /**
     * Cadastra um novo imóvel
     */
    public boolean cadastrarImovel(Imovel_ViniciusMazzaro imovel) {
        if (imovel == null) {
            return false;
        }
        return imoveis.add(imovel);
    }
    
    /**
     * Cadastra um novo seguro
     */
    public boolean cadastrarSeguro(Seguro_ViniciusMazzaro seguro) {
        if (seguro == null) {
            return false;
        }
        return seguros.add(seguro);
    }
    
    // ==================== BUSCAS ====================
    
    /**
     * Busca cliente por CPF
     */
    public Cliente_ViniciusMazzaro buscarClientePorCpf(String cpf) {
        return clientes.stream()
            .filter(c -> c.getCpf().equals(cpf))
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Busca corretor por CRECI
     */
    public Corretor_ViniciusMazzaro buscarCorretorPorCreci(String creci) {
        return corretores.stream()
            .filter(c -> c.getCreci().equals(creci))
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Busca imóvel por ID
     */
    public Imovel_ViniciusMazzaro buscarImovelPorId(int id) {
        return imoveis.stream()
            .filter(i -> i.getId() == id)
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Busca seguro por ID
     */
    public Seguro_ViniciusMazzaro buscarSeguroPorId(int id) {
        return seguros.stream()
            .filter(s -> s.getId() == id)
            .findFirst()
            .orElse(null);
    }
    
    // ==================== OPERAÇÕES DE VENDA ====================
    
    /**
     * Realiza uma venda de imóvel
     * Apenas pagamento por Cartão é permitido
     */
    public Venda_ViniciusMazzaro realizarVenda(String cpfCliente, 
                                                String creciCorretor, 
                                                int idImovel) {
        // Validações
        Cliente_ViniciusMazzaro cliente = buscarClientePorCpf(cpfCliente);
        if (cliente == null) {
            System.out.println("Erro: Cliente não encontrado!");
            return null;
        }
        
        Corretor_ViniciusMazzaro corretor = buscarCorretorPorCreci(creciCorretor);
        if (corretor == null) {
            System.out.println("Erro: Corretor não encontrado!");
            return null;
        }
        
        Imovel_ViniciusMazzaro imovel = buscarImovelPorId(idImovel);
        if (imovel == null) {
            System.out.println("Erro: Imóvel não encontrado!");
            return null;
        }
        
        if (!imovel.isDisponivelVenda()) {
            System.out.println("Erro: Imóvel não está disponível para venda!");
            return null;
        }
        
        // Criar venda (apenas Cartão permitido)
        Cartao_ViniciusMazzaro cartao = new Cartao_ViniciusMazzaro();
        Venda_ViniciusMazzaro venda = new Venda_ViniciusMazzaro(
            cliente, corretor, imovel, cartao
        );
        
        // Processar venda
        if (venda.processar()) {
            vendas.add(venda);
            System.out.println("Venda realizada com sucesso!");
            return venda;
        }
        
        System.out.println("Erro ao processar venda!");
        return null;
    }
    
    /**
     * Lista vendas de um mês específico e calcula o lucro total
     */
    public double calcularLucroMes(int mes, int ano) {
        return vendas.stream()
            .filter(v -> v.getMesVenda() == mes && v.getAnoVenda() == ano)
            .mapToDouble(Venda_ViniciusMazzaro::getLucroLiquido)
            .sum();
    }
    
    // ==================== OPERAÇÕES DE ALUGUEL ====================
    
    /**
     * Realiza um aluguel de imóvel
     * Permite pagamento em Dinheiro ou Cartão
     */
    public Aluguel_ViniciusMazzaro realizarAluguel(String cpfCliente,
                                                    String creciCorretor,
                                                    int idImovel,
                                                    LocalDate dataInicio,
                                                    LocalDate dataFim,
                                                    String tipoPagamento,
                                                    List<Integer> idsSeguros) {
        // Validações
        Cliente_ViniciusMazzaro cliente = buscarClientePorCpf(cpfCliente);
        if (cliente == null) {
            System.out.println("Erro: Cliente não encontrado!");
            return null;
        }
        
        Corretor_ViniciusMazzaro corretor = buscarCorretorPorCreci(creciCorretor);
        if (corretor == null) {
            System.out.println("Erro: Corretor não encontrado!");
            return null;
        }
        
        Imovel_ViniciusMazzaro imovel = buscarImovelPorId(idImovel);
        if (imovel == null) {
            System.out.println("Erro: Imóvel não encontrado!");
            return null;
        }
        
        if (!imovel.isDisponivelAluguel()) {
            System.out.println("Erro: Imóvel não está disponível para aluguel!");
            return null;
        }
        
        if (dataFim.isBefore(dataInicio)) {
            System.out.println("Erro: Data fim não pode ser antes da data início!");
            return null;
        }
        
        // Criar forma de pagamento
        FormaPagamento_ViniciusMazzaro formaPagamento;
        if (tipoPagamento.equalsIgnoreCase("DINHEIRO")) {
            formaPagamento = new Dinheiro_ViniciusMazzaro();
        } else if (tipoPagamento.equalsIgnoreCase("CARTAO")) {
            formaPagamento = new Cartao_ViniciusMazzaro();
        } else {
            System.out.println("Erro: Forma de pagamento inválida!");
            return null;
        }
        
        // Buscar seguros selecionados
        List<Seguro_ViniciusMazzaro> segurosEscolhidos = new ArrayList<>();
        if (idsSeguros != null) {
            for (Integer idSeguro : idsSeguros) {
                Seguro_ViniciusMazzaro seguro = buscarSeguroPorId(idSeguro);
                if (seguro != null) {
                    segurosEscolhidos.add(seguro);
                }
            }
        }
        
        // Criar aluguel
        Aluguel_ViniciusMazzaro aluguel = new Aluguel_ViniciusMazzaro(
            cliente, corretor, imovel, dataInicio, dataFim, formaPagamento, segurosEscolhidos
        );
        
        // Processar aluguel
        if (aluguel.processar()) {
            alugueis.add(aluguel);
            System.out.println("Aluguel realizado com sucesso!");
            return aluguel;
        }
        
        System.out.println("Erro ao processar aluguel!");
        return null;
    }
    
    /**
     * Finaliza um aluguel
     */
    public boolean finalizarAluguel(int idAluguel) {
        Aluguel_ViniciusMazzaro aluguel = alugueis.stream()
            .filter(a -> a.getId() == idAluguel)
            .findFirst()
            .orElse(null);
        
        if (aluguel == null) {
            System.out.println("Erro: Aluguel não encontrado!");
            return false;
        }
        
        aluguel.finalizar();
        System.out.println("Aluguel finalizado com sucesso!");
        return true;
    }
    
    /**
     * Verifica todos os aluguéis atrasados
     */
    public List<Aluguel_ViniciusMazzaro> verificarAlugueisAtrasados() {
        List<Aluguel_ViniciusMazzaro> atrasados = new ArrayList<>();
        for (Aluguel_ViniciusMazzaro aluguel : alugueis) {
            if (aluguel.verificarAtraso()) {
                atrasados.add(aluguel);
            }
        }
        return atrasados;
    }
    
    /**
     * Registra pagamento de um aluguel
     */
    public boolean registrarPagamentoAluguel(int idAluguel) {
        Aluguel_ViniciusMazzaro aluguel = alugueis.stream()
            .filter(a -> a.getId() == idAluguel)
            .findFirst()
            .orElse(null);
        
        if (aluguel == null) {
            System.out.println("Erro: Aluguel não encontrado!");
            return false;
        }
        
        return aluguel.registrarPagamento();
    }
    
    // ==================== REMOÇÕES ====================
    
    public boolean removerCliente(String cpf) {
        Cliente_ViniciusMazzaro cliente = buscarClientePorCpf(cpf);
        return cliente != null && clientes.remove(cliente);
    }
    
    public boolean removerCorretor(String creci) {
        Corretor_ViniciusMazzaro corretor = buscarCorretorPorCreci(creci);
        return corretor != null && corretores.remove(corretor);
    }
    
    public boolean removerImovel(int id) {
        Imovel_ViniciusMazzaro imovel = buscarImovelPorId(id);
        if (imovel != null && imovel.getStatus() == StatusImovel_ViniciusMazzaro.DISPONIVEL) {
            return imoveis.remove(imovel);
        }
        return false;
    }
    
    // ==================== PERSISTÊNCIA ====================
    
    /**
     * Salva todos os dados em arquivos
     */
    public void salvarDados() {
        try {
            gerenciadorArquivos.salvarClientes(clientes);
            gerenciadorArquivos.salvarCorretores(corretores);
            gerenciadorArquivos.salvarImoveis(imoveis);
            gerenciadorArquivos.salvarSeguros(seguros);
            gerenciadorArquivos.salvarVendas(vendas);
            gerenciadorArquivos.salvarAlugueis(alugueis);
            System.out.println("Dados salvos com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
    
    /**
     * Carrega todos os dados dos arquivos
     */
    public void carregarDados() {
        try {
            this.clientes = gerenciadorArquivos.carregarClientes();
            this.corretores = gerenciadorArquivos.carregarCorretores();
            this.imoveis = gerenciadorArquivos.carregarImoveis();
            this.seguros = gerenciadorArquivos.carregarSeguros();
            
            // Carregar vendas e alugueis requer referências
            this.vendas = gerenciadorArquivos.carregarVendas(clientes, corretores, imoveis);
            this.alugueis = gerenciadorArquivos.carregarAlugueis(clientes, corretores, imoveis, seguros);
            
            // Atualizar contadores de IDs
            atualizarContadores();
            
            System.out.println("Dados carregados com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
            // Se houver erro, inicializa com listas vazias
            inicializarSeguros();
        }
    }
    
    /**
     * Atualiza os contadores de ID das classes após carregar dados
     */
    private void atualizarContadores() {
        if (!vendas.isEmpty()) {
            int maxId = vendas.stream().mapToInt(Venda_ViniciusMazzaro::getId).max().orElse(0);
            Venda_ViniciusMazzaro.setContadorId(maxId + 1);
        }
        
        if (!alugueis.isEmpty()) {
            int maxId = alugueis.stream().mapToInt(Aluguel_ViniciusMazzaro::getId).max().orElse(0);
            Aluguel_ViniciusMazzaro.setContadorId(maxId + 1);
        }
    }
    
    // ==================== GETTERS ====================
    
    public List<Cliente_ViniciusMazzaro> getClientes() {
        return new ArrayList<>(clientes);
    }
    
    public List<Corretor_ViniciusMazzaro> getCorretores() {
        return new ArrayList<>(corretores);
    }
    
    public List<Imovel_ViniciusMazzaro> getImoveis() {
        return new ArrayList<>(imoveis);
    }
    
    public List<Venda_ViniciusMazzaro> getVendas() {
        return new ArrayList<>(vendas);
    }
    
    public List<Aluguel_ViniciusMazzaro> getAlugueis() {
        return new ArrayList<>(alugueis);
    }
    
    public List<Seguro_ViniciusMazzaro> getSeguros() {
        return new ArrayList<>(seguros);
    }
    
    // ==================== ESTATÍSTICAS ====================
    
    public int getTotalClientes() {
        return clientes.size();
    }
    
    public int getTotalCorretores() {
        return corretores.size();
    }
    
    public int getTotalImoveis() {
        return imoveis.size();
    }
    
    public int getTotalVendas() {
        return vendas.size();
    }
    
    public int getTotalAlugueis() {
        return alugueis.size();
    }
    
    public int getTotalAlugueisAtivos() {
        return (int) alugueis.stream()
            .filter(a -> a.getStatus() == StatusAluguel_ViniciusMazzaro.ATIVO)
            .count();
    }
    
    public int getTotalAlugueisAtrasados() {
        return verificarAlugueisAtrasados().size();
    }
}