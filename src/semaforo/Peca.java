package semaforo;

public class Peca {
    //atributos
    private CoresEnum cor;
    private int x;
    private int y;
    
    //construtor da Peça
    public Peca(CoresEnum cor, int x, int y){
        this.cor = cor;
        this.x = x;
        this.y = y;
    }

    
    //getters e setter e cada atributo
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
