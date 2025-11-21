package service;

import domain.model.Compromisso;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import repository.RepositorioSimples;

public class CompromissoService {

    private final RepositorioSimples repo;
    private int sequence = 1;

    public CompromissoService(RepositorioSimples repo) {
        this.repo = repo;
    }

    public void cadastrar(LocalDate data, LocalTime hora, String titulo, String descricao, int prioridade) {

        if (data.isBefore(LocalDate.now())) {
            throw new RuntimeException("Data no passado.");
        }

        LocalDateTime dt = LocalDateTime.of(data, hora);

        if (repo.buscarPorDataHora(dt) != null) {
            throw new RuntimeException("Conflito de horário.");
        }

        String id = String.valueOf(sequence++);
        Compromisso c = new Compromisso(id, data, hora, titulo, descricao, prioridade);

        repo.salvar(c);
    }

    public void editar(String id, LocalDate novaData, LocalTime novaHora, String novoTitulo,
                       String novaDesc, int novaPrioridade) {

        Compromisso c = repo.buscarPorId(id);

        if (c == null) throw new RuntimeException("Não encontrado.");

        if (novaData.isBefore(LocalDate.now())) {
            throw new RuntimeException("Data no passado.");
        }

        LocalDateTime dt = LocalDateTime.of(novaData, novaHora);

        Compromisso conflito = repo.buscarPorDataHora(dt);
        if (conflito != null && conflito != c) {
            throw new RuntimeException("Conflito de horário.");
        }

        c.setData(novaData);
        c.setHora(novaHora);
        c.setTitulo(novoTitulo);
        c.setDescricao(novaDesc);
        c.setPrioridade(novaPrioridade);
    }

    public void remover(String id) {
        Compromisso c = repo.buscarPorId(id);
        if (c != null) {
            repo.remover(c);
        }
    }

    public List<Compromisso> listarTodos() {
        return repo.buscarTodos();
    }
}
