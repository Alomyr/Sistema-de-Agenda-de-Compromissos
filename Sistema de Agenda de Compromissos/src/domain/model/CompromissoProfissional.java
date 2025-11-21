package domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompromissoProfissional extends Compromisso {
    public CompromissoProfissional(String id, LocalDate data, LocalTime hora, String titulo, String descricao, int prioridade) {
        super(id, data, hora, titulo, descricao, prioridade);
    }
}
