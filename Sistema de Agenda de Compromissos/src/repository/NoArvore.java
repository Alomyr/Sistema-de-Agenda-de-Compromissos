package repository;

import domain.model.Compromisso;

public class NoArvore {
    Compromisso value;
    NoArvore left;
    NoArvore right;
    NoArvore pai;

    public NoArvore(Compromisso compromisso, NoArvore left, NoArvore right){
        this.value = compromisso;
        this.left = left;
        this.right = right;
    }

    public NoArvore(){
        this.value = null;
        this.left = null;
        this.right = null;
        this.pai = null;
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
    public NoArvore getPai(){
        return this.pai;
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
    public void setPai(NoArvore pai){
        this.pai = pai;
    }
}
