package repository;

import domain.model.Compromisso;
import java.time.LocalDateTime;

public class Arvore {
    private NoArvore raiz;

    /**
     * @brief Constrói a árvore com um nó raíz padrão
     */
    public Arvore(){
        raiz = new NoArvore();
    }

    /**
     * @brief Adiciona um compromisso na Árvore Binária de Busca
     * @param compromisso Compromisso a ser inserido
     * @param noAtual Nó raíz da árvore
     */
    public void Adicionar(Compromisso compromisso, NoArvore noAtual){
        NoArvore novoNo = new NoArvore(compromisso, null, null);
        if (this.raiz.value == null){ this.raiz = novoNo;}
        else{

            if (compromisso.getDataHora().isAfter(noAtual.value.getDataHora())){
                if (noAtual.right != null){
                    Adicionar(compromisso, noAtual.right);
                } else {
                    noAtual.right = novoNo;
                    novoNo.pai = noAtual;
                }
            }
            else if (compromisso.getDataHora().isBefore(noAtual.value.getDataHora())){
                if (noAtual.left != null){
                    Adicionar(compromisso, noAtual.left);
                } else {
                    noAtual.left = novoNo;
                    novoNo.pai = noAtual;
                }
            }
        }
    }

    /**
     * @brief Remove um compromisso da Árvore Binária de Busca
     * @param compromisso Compromisso a ser removido
     * @param noAtual Nó raiz da árvore
     */
    public void Remover(Compromisso compromisso, NoArvore noAtual){
        NoArvore target = buscarPorDataHora(noAtual, compromisso.getDataHora());

        //trata o caso do nó a ser removido ser folha
        if (target.left == null && target.right == null) {
            if (target == this.raiz){ target.value = null; }
            else{
                if (target.pai.left == target){ target.pai.left = null; }
                else if (target.pai.right == target){ target.pai.right = null; }
            }
        }
        //trata o caso do nó a ser removido só ter filho à esquerda
        else if (target.left != null){
            target.value = target.left.value;
            Remover(target.left.value, target.left);
        }
        //trata o caso do nó a ser removido só ter filho à direita
        else if (target.right != null){
            target.value = target.right.value;
            Remover(target.right.value, target.right);
        }
        //trata o caso do nó a ser removido ter dois filhos
        else if (target.left != null && target.right != null){
            NoArvore succ = getSucc(target);
            target.value = succ.value;
            if (succ.right != null){ succ.pai.left = succ.right; }
        }
    }

    /**
     * @brief Busca um compromisso pela data e hora específicas
     * @param dt Data e hora do compromisso a ser buscado
     * @return Compromisso encontrado ou null se não existir
     * 
     * @note Útil para verificar conflitos de horário na agenda
     */
    public NoArvore buscarPorDataHora(NoArvore no, LocalDateTime dt) {
        if (no == null || no.value == null) {return null;}
        
        if (dt.equals(no.value.getDataHora())) {
            return no;
        } else if (dt.isBefore(no.value.getDataHora())) {
            return buscarPorDataHora(no.left, dt);
        } else {
            return buscarPorDataHora(no.right, dt);
        }
    }

    /**
     * @brief Retorna o mínimo de uma árvore específica
     * @param root Nó raíz da árvore
     * @return Nó cuja dataHora é menor nessa Sub-Árvore
     */
    public NoArvore getMin(NoArvore root){
        while (root.left != null){
            return getMin(root.left);
        }
        return root;
    }

    /**
     * @brief Retorna sucessor de uma determinada árvore
     * @param root Nó raíz da árvore
     * @return Nó cuja dataHora é a sucessora do nó raíz
     */
    public NoArvore getSucc(NoArvore root){
        if (root.right != null){
            return getMin (root.right);
        }
        return null;
    }

    /**
     * @return Retorna a raiz da árvore
     */
    public NoArvore getRaiz(){
        return this.raiz;
    }

    //TODO: Ajeitar esse print (Só ta imprimindo a hora, para fins de teste)
    /**
     * @brief Imprime a árvore em In-Order (Ordem de dataHora)
     * @param no
     */
    public void printTree(NoArvore no){
        if (no.left != null || no.value != null) printTree(no.left);
        if (no.value != null) System.out.println(no.value.getDataHora() + " ");
        if (no.right != null || no.value != null) printTree(no.right);
    }
    
}
