package repository;

import domain.model.Compromisso;
import java.time.LocalDateTime;

public class Arvore {
    private NoArvore raiz;

    public Arvore(){
        this.raiz = null;
    }

    public void Adicionar(Compromisso compromisso, NoArvore noAtual){
        NoArvore novoNo = new NoArvore(compromisso, null, null);
        if (this.raiz == null){ this.raiz = novoNo;}
        else{

            if (compromisso.getDataHora().isAfter(noAtual.value.getDataHora())){
                if (noAtual.right != null){
                    Adicionar(compromisso, noAtual.right);
                } else {
                    noAtual.right = novoNo;
                }
            }
            else if (compromisso.getDataHora().isBefore(noAtual.value.getDataHora())){
                if (noAtual.left != null){
                    Adicionar(compromisso, noAtual.left);
                } else {
                    noAtual.left = novoNo;
                }
            }
        }
    }

    //TODO: Remover @TheooHenrique
    public void Remover(Compromisso compromisso, NoArvore noAtual){

    }

    /**
     * @brief Busca um compromisso pela data e hora específicas
     * @param dt Data e hora do compromisso a ser buscado
     * @return Compromisso encontrado ou null se não existir
     * 
     * @note Útil para verificar conflitos de horário na agenda
     */
    public Compromisso buscarPorDataHora(NoArvore no, LocalDateTime dt) {
        if (no == null) return null;
        
        if (dt.equals(no.value.getDataHora())) {
            return no.value;
        } else if (dt.isBefore(no.value.getDataHora())) {
            return buscarPorDataHora(no.left, dt);
        } else {
            return buscarPorDataHora(no.right, dt);
        }
    }

    public NoArvore getRaiz(){
        return this.raiz;
    }
    
}
