package repository;

import domain.model.Compromisso;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioSimples {

    private final List<Compromisso> lista = new ArrayList<>();

    public void salvar(Compromisso c) {
        lista.add(c);
    }

    public void remover(Compromisso c) {
        lista.remove(c);
    }

    public List<Compromisso> buscarTodos() {
        return new ArrayList<>(lista);
    }

    public Compromisso buscarPorId(String id) {
        return lista.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public Compromisso buscarPorDataHora(LocalDateTime dt) {
        return lista.stream()
            .filter(c -> c.getDataHora().equals(dt))
            .findFirst()
            .orElse(null);
    }
}
