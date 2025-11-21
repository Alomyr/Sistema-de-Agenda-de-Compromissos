package domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompromissoPessoal extends Compromisso {
    public CompromissoPessoal(String id, LocalDate data, LocalTime hora, String titulo, String descricao, int prioridade) {
        super(id, data, hora, titulo, descricao, prioridade);
    }
}
