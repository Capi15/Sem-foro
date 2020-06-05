package semaforo;

public class Peca {
    //atributos
    private int id;
    private CoresEnum cor;
    
    //construtor da Peça
    public Peca(CoresEnum cor){
        this.id = 0;
        this.cor = cor;
    }

    
    //getters e setter e cada atributo
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CoresEnum getCor() {
        return cor;
    }

    public void setCor(CoresEnum cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return  this.cor.toString() ;
    }
}
