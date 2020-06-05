package semaforo;

import java.io.Serializable;

// Classe genérica de nós, permite receber diversos objetos
public class Nodo<T> implements Serializable {
    
    private T dados;
    private Nodo<T> next;

    //o construtor da classe recebe qualquer tipo de dados e o seu respetivo nó
    public Nodo(T dados) {
        this.dados = dados;
        this.next = next;
    }

    //getters e setters genericos
    //é de notar que não faz falta um setter para os dados, visto que estes nunca vão ser atualizados
    public T getDados() {
        return dados;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }
    
    
}
