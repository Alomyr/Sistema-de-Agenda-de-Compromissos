package domain.model;

import annotation.InfoAutor;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @brief Representa um compromisso de natureza pessoal
 *
 *
 * @extends Compromisso
 *
 * @note Subclasse especializada para compromissos pessoais com categoria
 * @see Compromisso
 * @see CompromissoProfissional
 */
@InfoAutor(
        nome = "Matheus Castro",
        data = "27/11/2025",
        versao = "1.0",
        descricao = "Subclass de compromisso da categoria pessoal"
)
public class CompromissoPessoal extends Compromisso {

    /**
     * @brief Construtor parametrizado para compromissos pessoais
     *
     * @param id Identificador único do compromisso pessoal
     * @param data Data do compromisso pessoal
     * @param hora Hora do compromisso pessoal
     * @param titulo Título descritivo do compromisso pessoal
     * @param descricao Descrição detalhada do compromisso pessoal
     * @param prioridade Nível de prioridade do compromisso pessoal
     *
     * @note Utiliza o construtor da classe pai Compromisso para inicialização
     */
    public CompromissoPessoal(String id, LocalDate data, LocalTime hora, String titulo, String descricao, int prioridade) {
        super(id, data, hora, titulo, descricao, prioridade);
    }
}
