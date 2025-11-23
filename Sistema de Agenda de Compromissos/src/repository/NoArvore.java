package repository;

import domain.model.Compromisso;

public class NoArvore {
    Compromisso value;
    NoArvore left;
    NoArvore right;

    public NoArvore(Compromisso compromisso, NoArvore left, NoArvore right){
        this.value = compromisso;
        this.left = left;
        this.right = right;
    }



    public Compromisso getCompromisso(){
        return this.value;
    };
    public NoArvore getLeft(){
        return this.left;
    }
    public NoArvore getRight(){
        return this.right;
    }

    public void setCompromisso(Compromisso compromisso){
        this.value = compromisso;
    }
    public void setLeft(NoArvore left){
        this.left = left;
    }
    public void setRight(NoArvore right){
        this.right = right;
    }
}
