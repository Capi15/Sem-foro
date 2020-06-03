package semaforo;

import java.io.Serializable;

//lista ligada que aceita vários tipos de objetos
public class ListaLigada<T> implements Serializable {

    //atributos da lista
    private Nodo<T> cabeca;
    private int size;

    //construtor da ListaLigada
    public ListaLigada() {
        this.cabeca = null;
        this.size = 0;
    }

    //verifica se existem elementos na lista
    public boolean isEmpty() {
        return this.cabeca == null; // se o valor da variavel cabeca for nulo, a lista está vazia
    }

    //método responsável por adicionar novos elementos à ListaLigada
    public ListaLigada<T> Push(T dados) { // é preciso receber os dados de cada nó como parametro
        Nodo<T> noTemporario;
        //caso a lista esteja vazia
        if (isEmpty()) {
            noTemporario = new Nodo<T>(dados);
            this.cabeca = noTemporario; // o nó é a propria cabeça da lista
            this.size += 1; //aumenta o tamanho da lista
            return this; //retorna a lista
        } else if (!this.isEmpty()) { // se a lista já tiver elementos | são adicionados os elementos no incio da lista
            noTemporario = new Nodo<T>(dados);
            this.size += 1; // aumenta o tamanho da lista conforme os nós que vão ser inseridos
            return this; // retorna a lista
        }
        return this; // retorna a lista
    }

    public ListaLigada<T> DeleteStart() {
        if (this.isEmpty()) {
            return this; // caso a lista esteja vazia retorna a lista
        } else if (this.size == 1) {
            this.cabeca = null; // a cabeça da lista passa a ser nula
            this.size -= 1; // diminui o tamanho da lista
            return this; // retorna a lista
        } else {
            this.cabeca = this.cabeca.getNext(); // a cabeça desaparece da lista e o proximo elemento passa a ser a cabeça da lista
            return this; // retorna a lista
        }
    }

    public ListaLigada<T> DeleteEnd() {
        Nodo<T> noTemporario;
        if (this.isEmpty()) {
            return this; // caso a lista esteja vazia retorna a lista
        } else if (this.size == 1) {
            this.cabeca = null; // a cabeça da lista passa a ser nula
            this.size -= 1; // diminui o tamanho da lista
            return this; // retorna a lista
        } else {
            for(noTemporario = this.cabeca; noTemporario.getNext().getNext() != null; noTemporario = noTemporario.getNext()){
                noTemporario.setNext(null); // depois de percorrer a lista até ao fim remove o ultimo elemento
            }
            return this; // retorna a lista
        }
    }
    
    
    //permite aceder ao primeiro elemento da lista
    public Nodo<T> getHead() {
        return this.cabeca;
    }
    
    //devolve o tamanho atual da lista
    public int size() {
        return this.size;
    }
}
