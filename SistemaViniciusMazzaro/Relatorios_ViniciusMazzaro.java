import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável por gerar todos os relatórios do sistema
 * Implementa os 19 relatórios obrigatórios do TP1
 */
public class Relatorios_ViniciusMazzaro {
    
    private SistemaImobiliaria_ViniciusMazzaro sistema;
    
    public Relatorios_ViniciusMazzaro(SistemaImobiliaria_ViniciusMazzaro sistema) {
        this.sistema = sistema;
    }
    
    // ==================== RELATÓRIOS DE IMÓVEIS (9) ====================
    
    /**
     * 1. Listar todos os imóveis cadastrados
     */
    public void listarTodosImoveis() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║          RELATÓRIO: TODOS OS IMÓVEIS CADASTRADOS           ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        List<Imovel_ViniciusMazzaro> imoveis = sistema.getImoveis();
        
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado no sistema.");
            return;
        }
        
        System.out.println("Total de imóveis: " + imoveis.size() + "\n");
        
        for (Imovel_ViniciusMazzaro imovel : imoveis) {
            System.out.println(imovel);
            System.out.println("─────────────────────────────────────────────────────────────\n");
        }
    }
    
    /**
     * 2. Listar todos os imóveis de categoria Casa Residencial
     */
    public void listarCasasResidenciais() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              RELATÓRIO: CASAS RESIDENCIAIS                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        List<Imovel_ViniciusMazzaro> casas = sistema.getImoveis().stream()
            .filter(i -> i instanceof CasaResidencial_ViniciusMazzaro)
            .collect(Collectors.toList());
        
        if (casas.isEmpty()) {
            System.out.println("Nenhuma casa residencial cadastrada.");
            return;
        }
        
        System.out.println("Total de casas residenciais: " + casas.size() + "\n");
        
        for (Imovel_ViniciusMazzaro casa : casas) {
            System.out.println(casa);
            System.out.println("─────────────────────────────────────────────────────────────\n");
        }
    }
    
    /**
     * 3. Listar todos os imóveis de categoria Prédio Residencial
     */
    public void listarPrediosResidenciais() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║             RELATÓRIO: PRÉDIOS RESIDENCIAIS                ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        List<Imovel_ViniciusMazzaro> predios = sistema.getImoveis().stream()
            .filter(i -> i instanceof PredioResidencial_ViniciusMazzaro)
            .collect(Collectors.toList());
        
        if (predios.isEmpty()) {
            System.out.println("Nenhum prédio residencial cadastrado.");
            return;
        }
        
        System.out.println("Total de prédios residenciais: " + predios.size() + "\n");
        
        for (Imovel_ViniciusMazzaro predio : predios) {
            System.out.println(predio);
            System.out.println("─────────────────────────────────────────────────────────────\n");
        }
    }
    
    /**
     * 4. Listar todos os imóveis de categoria Comercial
     */
    public void listarComerciais() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║               RELATÓRIO: IMÓVEIS COMERCIAIS                ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        List<Imovel_ViniciusMazzaro> comerciais = sistema.getImoveis().stream()
            .filter(i -> i instanceof Comercial_ViniciusMazzaro)
            .collect(Collectors.toList());
        
        if (comerciais.isEmpty()) {
            System.out.println("Nenhum imóvel comercial cadastrado.");
            return;
        }
        
        System.out.println("Total de imóveis comerciais: " + comerciais.size() + "\n");
        
        for (Imovel_ViniciusMazzaro comercial : comerciais) {
            System.out.println(comercial);
            System.out.println("─────────────────────────────────────────────────────────────\n");
        }
    }
    
    /**
     * 5. Listar todos os imóveis disponíveis para locação
     */
    public void listarImoveisDisponiveisLocacao() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║         RELATÓRIO: IMÓVEIS DISPONÍVEIS P/ LOCAÇÃO         ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        List<Imovel_ViniciusMazzaro> disponiveis = sistema.getImoveis().stream()
            .filter(Imovel_ViniciusMazzaro::isDisponivelAluguel)
            .collect(Collectors.toList());
        
        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum imóvel disponível para locação.");
            return;
        }
        
        System.out.println("Total de imóveis disponíveis: " + disponiveis.size() + "\n");
        
        for (Imovel_ViniciusMazzaro imovel : disponiveis) {
            System.out.println(imovel);
            System.out.println("─────────────────────────────────────────────────────────────\n");
        }
    }
    
    /**
     * 6. Listar todos os imóveis alugados
     */
    public void listarImoveisAlugados() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              RELATÓRIO: IMÓVEIS ALUGADOS                   ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        List<Imovel_ViniciusMazzaro> alugados = sistema.getImoveis().stream()
            .filter(i -> i.getStatus() == StatusImovel_ViniciusMazzaro.ALUGADO)
            .collect(Collectors.toList());
        
        if (alugados.isEmpty()) {
            System.out.println("Nenhum imóvel alugado no momento.");
            return;
        }
        
        System.out.println("Total de imóveis alugados: " + alugados.size() + "\n");
        
        for (Imovel_ViniciusMazzaro imovel : alugados) {
            System.out.println(imovel);
            System.out.println("─────────────────────────────────────────────────────────────\n");
        }
    }
    
    /**
     * 7. Listar todos os imóveis disponíveis para venda
     */
    public void listarImoveisDisponiveisVenda() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║          RELATÓRIO: IMÓVEIS DISPONÍVEIS P/ VENDA          ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        List<Imovel_ViniciusMazzaro> disponiveis = sistema.getImoveis().stream()
            .filter(Imovel_ViniciusMazzaro::isDisponivelVenda)
            .collect(Collectors.toList());
        
        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum imóvel disponível para venda.");
            return;
        }
        
        System.out.println("Total de imóveis disponíveis: " + disponiveis.size() + "\n");
        
        for (Imovel_ViniciusMazzaro imovel : disponiveis) {
            System.out.println(imovel);
            System.out.println("─────────────────────────────────────────────────────────────\n");
        }
    }
    
    /**
     * 8. Listar todos os imóveis vendidos
     */
    public void listarImoveisVendidos() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║               RELATÓRIO: IMÓVEIS VENDIDOS                  ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        List<Imovel_ViniciusMazzaro> vendidos = sistema.getImoveis().stream()
            .filter(i -> i.getStatus() == StatusImovel_ViniciusMazzaro.VENDIDO)
            .collect(Collectors.toList());
        
        if (vendidos.isEmpty()) {
            System.out.println("Nenhum imóvel vendido.");
            return;
        }
        
        System.out.println("Total de imóveis vendidos: " + vendidos.size() + "\n");
        
        for (Imovel_ViniciusMazzaro imovel : vendidos) {
            System.out.println(imovel);
            System.out.println("─────────────────────────────────────────────────────────────\n");
        }
    }
    
    /**
     * 9. Listar todos os imóveis com atraso no pagamento do aluguel
     */
    public void listarImoveisComAtraso() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║          RELATÓRIO: IMÓVEIS COM ALUGUEL ATRASADO          ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        List<Aluguel_ViniciusMazzaro> atrasados = sistema.verificarAlugueisAtrasados();
        
        if (atrasados.isEmpty()) {
            System.out.println("Nenhum imóvel com aluguel atrasado.");
            return;
        }
        
        System.out.println("Total de aluguéis atrasados: " + atrasados.size() + "\n");
        
        for (Aluguel_ViniciusMazzaro aluguel : atrasados) {
            System.out.println(aluguel);
            System.out.println("─────────────────────────