package domain.exception;

import annotation.InfoAutor;

/**
 * @brief Exceção personalizada para violações de regras de negócio
 * 
 * 
 * @extends RuntimeException
 * 
 * @note Usada para validações de data, conflitos de horário, etc.
 * @see service.CompromissoService
 */
@InfoAutor(
    nome = "Matheus Castro", 
    data = "27/11/2025",
    versao = "1.0",
    descricao = "Classe base para as exceções de regra de negócios"
)
public class NegocioException extends RuntimeException {

    /**
     * @brief Construtor com mensagem de erro
     * 
     * @param mensagem A mensagem descritiva do erro de negócio
     * 
     * @note Cria exceção com mensagem personalizada para regras violadas
     */
    public NegocioException(String mensagem) {
        super(mensagem);
    }

    /**
     * @brief Construtor com mensagem e causa original
     * 
     * @param mensagem A mensagem descritiva do erro de negócio
     * @param causa A exceção original que causou este erro
     * 
     * @note Útil para encadeamento de exceções mantendo a causa raiz
     */
    public NegocioException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}