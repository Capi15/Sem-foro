package semaforo;

/**
 *
 * @author bruno
 */
public class Peca {
    private int id;
    private String cor;
    
    public Peca(){
        this.id = 0;
        this.cor = "Verde";
    }

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
