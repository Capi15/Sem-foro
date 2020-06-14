package semaforo;

/**
 * @authors Bruno Ribeiro nº21514 
 * @authors Tiago Rebelo nº20537
 */

//lista ligada que aceita vários tipos de objetos
public class ListaLigada {

    //atributos da lista
    private Nodo inicio;
    private int size;
    private String mostraDados;

    //construtor da ListaLigada
    public ListaLigada() {
        this.inicio = null;
        this.size = 0;
    }

    //verifica se existem elementos na lista
    public boolean isEmpty() {
        return inicio == null; // se o valor da variavel inicio for nulo, a lista está vazia
    }

    //método responsável por adicionar novos elementos à ListaLigada
    public void addNodo(Peca dados) { // é preciso receber os dados de cada nó como parametro
        Nodo novoNodo = new Nodo(dados);
        //caso a lista esteja vazia
        if (isEmpty()) {
            //System.out.println("lista vazia - teste");
            inicio = novoNodo; // o nó é a propria cabeça da lista
            size ++; //aumenta o tamanho da lista
            //System.out.println("add Nodo ao inicio" + novoNodo.toString());
        } else{ // se a lista já tiver elementos | são adicionados os elementos no incio da lista
            Nodo aux = inicio; 
             while(aux.getNext()!= null){ // percorre até ao último elemento 
                aux = aux.getNext();
                 //System.out.println("add Nodo ao final" + novoNodo.toString());
             }
            aux.setNext(novoNodo);
            size ++; //aumenta o tamanho da lista
            //System.out.println("adicionado novo Nodo com uma Peca no final da lista");
        }
    }
    
    //permite aceder ao primeiro elemento da lista
    public Nodo getHead() {
        return this.inicio;
    }
    
    //devolve o tamanho atual da lista
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return mostraDados; 
    }
}
