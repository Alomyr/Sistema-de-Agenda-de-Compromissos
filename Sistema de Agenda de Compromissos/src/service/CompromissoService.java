package service;

import annotation.InfoAutor;
import domain.model.Compromisso;
import domain.model.CompromissoPessoal;
import domain.exception.NegocioException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import repository.Repositorio;

/**
 * @brief Serviço principal para gestão de compromissos e regras de negócio
 * 
 * @note Coordena repositório, árvore ABB e validações de negócio
 * @see Compromisso
 * @see Repositorio
 * @see Arvore
 */
@InfoAutor(
    nome = "Matheus Castro", 
    data = "27/11/2025",
    versao = "1.0",
    descricao = "Serviço principal para gestão de compromissos com validações de negócio, " +
               "controle de conflitos e integração com repositório e árvore ABB"
)
public class CompromissoService {

    private final Repositorio repo;
    private int sequence = 1;

    /**
     * @brief Construtor do serviço de compromissos
     * @param repo Repositório utilizado para persistência dos compromissos
     */
    public CompromissoService(Repositorio repo) {
        this.repo = repo;
    }

    /**
     * @brief Cadastra um novo compromisso com validações de negócio
     * @param data Data do compromisso
     * @param hora Hora do compromisso
     * @param titulo Título do compromisso
     * @param descricao Descrição detalhada do compromisso
     * @param prioridade Nível de prioridade do compromisso
     * 
     * @throws NegocioException Se a data for no passado
     * @throws NegocioException Se houver conflito de horário
     * 
     * @note Gera ID sequencial automaticamente e valida regras de negócio
     */
    public void cadastrar(LocalDate data, LocalTime hora, String titulo, String descricao, int prioridade) {

        if (data.isBefore(LocalDate.now())) {
            throw new NegocioException("Data no passado.");
        }

        LocalDateTime dt = LocalDateTime.of(data, hora);

        if (repo.buscarPorDataHora(dt) != null) {
            throw new NegocioException("Conflito de horário.");
        }

        String id = String.valueOf(sequence++);
        Compromisso c = new CompromissoPessoal(id, data, hora, titulo, descricao, prioridade);

        repo.salvar(c);
    }

    /**
     * @brief Edita um compromisso existente com validações
     * @param id Identificador do compromisso a ser editado
     * @param novaData Nova data do compromisso
     * @param novaHora Nova hora do compromisso
     * @param novoTitulo Novo título do compromisso
     * @param novaDesc Nova descrição do compromisso
     * @param novaPrioridade Nova prioridade do compromisso
     * 
     * @throws NegocioException Se o compromisso não for encontrado
     * @throws NegocioException Se a nova data for no passado
     * @throws NegocioException Se houver conflito de horário com outro compromisso
     * 
     * @note Mantém a mesma instância do compromisso, apenas atualiza os atributos
     */
    public void editar(String id, LocalDate novaData, LocalTime novaHora, String novoTitulo,
                       String novaDesc, int novaPrioridade) {

        Compromisso c = repo.buscarPorId(id);

        if (c == null) throw new NegocioException("Não encontrado.");

        if (novaData.isBefore(LocalDate.now())) {
            throw new NegocioException("Data no passado.");
        }

        LocalDateTime dt = LocalDateTime.of(novaData, novaHora);

        Compromisso conflito = repo.buscarPorDataHora(dt);
        if (conflito != null && conflito != c) {
            throw new NegocioException("Conflito de horário.");
        }

        c.setData(novaData);
        c.setHora(novaHora);
        c.setTitulo(novoTitulo);
        c.setDescricao(novaDesc);
        c.setPrioridade(novaPrioridade);
    }

    /**
     * @brief Remove um compromisso pelo ID
     * @param id Identificador do compromisso a ser removido
     * 
     * @note Se o compromisso não existir, a operação é silenciosamente ignorada
     */
    public void remover(String id) {
        Compromisso c = repo.buscarPorId(id);
        if (c != null) {
            repo.remover(c);
        }
    }

    /**
     * @brief Retorna todos os compromissos cadastrados
     * @return List<Compromisso> Lista com todos os compromissos
     * 
     * @note A lista retornada é uma cópia para evitar modificações externas
     */
    public List<Compromisso> listarTodos() {
        return repo.buscarTodos();
    }
}