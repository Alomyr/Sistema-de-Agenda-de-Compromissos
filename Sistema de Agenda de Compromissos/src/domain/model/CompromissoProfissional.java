package domain.model;

import annotation.InfoAutor;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @brief Representa um compromisso de natureza profissional
 *
 * @extends Compromisso
 *
 * @note Subclasse especializada para compromissos profissionais com local
 * @see Compromisso
 * @see CompromissoPessoal
 */
@InfoAutor(
        nome = "Matheus Castro",
        data = "27/11/2025",
        versao = "1.0",
        descricao = "Subclass de compromisso da categoria profissional"
)
public class CompromissoProfissional extends Compromisso {

    /**
     * @brief Construtor parametrizado para compromissos profissionais
     * 
     * @param id Identificador único do compromisso profissional
     * @param data Data do compromisso profissional
     * @param hora Hora do compromisso profissional
     * @param titulo Título descritivo do compromisso profissional
     * @param descricao Descrição detalhada do compromisso profissional
     * @param prioridade Nível de prioridade do compromisso profissional
     * 
     * @note Utiliza o construtor da classe pai Compromisso para inicialização
     *       dos atributos básicos compartilhados
     */
    public CompromissoProfissional(String id, LocalDate data, LocalTime hora, String titulo, String descricao, int prioridade) {
        super(id, data, hora, titulo, descricao, prioridade);
    }
}