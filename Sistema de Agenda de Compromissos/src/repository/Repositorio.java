package repository;

import annotation.InfoAutor;
import domain.model.Compromisso;
import java.util.ArrayList;
import java.util.List;

/**
 * @brief Implementação concreta de repositório para entidades Compromisso
 *
 * @note Implementa operações CRUD básicas para gerenciamento de compromissos
 * @see Compromisso
 */
@InfoAutor(
        nome = "Matheus Castro",
        data = "27/11/2025",
        versao = "1.0",
        descricao = "Classe básica para as funções que o usuário pode usar respeitando as regras de negócios"
)
public class Repositorio {

    private final Arvore tree = new Arvore();
    private final List<Compromisso> lista = new ArrayList<>(); //tirar isso aqui depois (tem que ser árvore não lista)

    /**
     * @brief Adiciona um novo compromisso ao repositório
     * @param c Compromisso a ser salvo no repositório
     */
    public void salvar(Compromisso c) {
        tree.Adicionar(c, tree.getRaiz());
    }

    /**
     * @brief Remove um compromisso existente do repositório
     * @param c Compromisso a ser removido do repositório
     */
    public void remover(Compromisso c) {
        
    }

    /**
     * @brief Retorna todos os compromissos armazenados
     * @return List<Compromisso> contendo todos os compromissos do repositório
     * 
     * @note Retorna uma nova lista para evitar modificações externas na lista interna
     */
    public List<Compromisso> buscarTodos() {
        return new ArrayList<>(lista);
    }

    /**
     * @brief Busca um compromisso pelo seu identificador único
     * @param id Identificador do compromisso a ser buscado
     * @return Compromisso encontrado ou null se não existir
     */
    public Compromisso buscarPorId(String id) {
        return lista.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Arvore getTree(){
        return this.tree;
    }
}
