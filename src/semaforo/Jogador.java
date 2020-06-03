package semaforo;
public class Jogador {
    //atributos
    private String nome;

    //construtor da calsse Jogador, recebe o nome como parametro
    public Jogador(String nome) {
        this.nome = nome;
    }
    
    
    //getters e setters dos atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
