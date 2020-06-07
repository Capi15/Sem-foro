package semaforo;

/**
 * @authors Bruno Ribeiro nº21514 
 * @authors Tiago Rebelo nº20537
 */

// Classe genérica de nós, permite receber diversos objetos
public class Nodo {
    
    private Peca dados;
    private Nodo next;

    //o construtor da classe recebe qualquer tipo de dados e o seu respetivo nó
    public Nodo(Peca dados) {
        this.dados = dados;
        this.next = next;
    }

    //getters e setters genericos
    //é de notar que não faz falta um setter para os dados, visto que estes nunca vão ser atualizados
    public Peca getDados() {
        return dados;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    
}
