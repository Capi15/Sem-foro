package semaforo;

/**
 * @authors Bruno Ribeiro nº21514 
 * @authors Tiago Rebelo nº20537
 */

public class Peca {
    //atributos
    private Cor cor;
    private int x;
    private int y;
    
    //construtor da Peça
    public Peca(Cor cor, int x, int y){
        this.cor = cor;
        this.x = x;
        this.y = y;
    }

    //getters e setter e cada atributo
    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return cor.toString();
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
