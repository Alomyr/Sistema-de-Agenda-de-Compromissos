package repository;

import domain.model.Compromisso;
import java.time.LocalDateTime;

public class Arvore {
    private NoArvore raiz;

    public Arvore(){
        raiz = new NoArvore();
    }

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

    //Aux functions
    public NoArvore getMin(NoArvore root){
        while (root.left != null){
            return getMin(root.left);
        }
        return root;
    }
    public NoArvore getMax(NoArvore root){
        while (root.right != null){
            return getMin(root.right);
        }
        return root;
    }

    public NoArvore getPred(NoArvore root){
        if (root.left != null){
            return getMax(root.left);
        }
        return null;
    }

    public NoArvore getSucc(NoArvore root){
        if (root.right != null){
            return getMin (root.right);
        }
        return null;
        
    }

    public NoArvore getRaiz(){
        return this.raiz;
    }

    public void printTree(NoArvore no){
        if (no.left != null) printTree(no.left);
        System.out.println(no.value.getDataHora() + " ");
        if (no.right != null) printTree(no.right);
    }
    
}
