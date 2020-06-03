package semaforo;

public class Peca {
    //atributos
    private int id;
    private String cor;
    
    //construtor da Peça
    public Peca(){
        this.id = 0;
        this.cor = "Verde";
    }

    
    //getters e setter e cada atributo
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
