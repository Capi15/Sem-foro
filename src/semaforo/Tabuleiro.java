package semaforo;

/**
 *
 * @author bruno
 */
public class Tabuleiro {
    //atributos
    private final int totalPecas;
    private final int pecasVerdes;
    private final int pecasAmarelas;
    private final int pecasVermelhas;
    //private ListaLigada<Peca> casa[][] = new ListaLigada[3][4]; //criação do array bidimensional(matriz)
    private final String casa[][] = new String[3][4];
    
    //construtor da classe Tabuleiro
    public Tabuleiro(){
        this.totalPecas = 24;
        this.pecasVerdes = this.pecasAmarelas = this.pecasVermelhas = 8;
    }
    
    //este método é responsável por imprimir o tabuleiro para o ecrã
    public String mostraTabuleiro(){
        //percorre o array por linha
        for (int linha = 0; linha < 3; linha++){
            System.out.println("-----------------");
            //percorre o array por colunas
            for(int coluna = 0; coluna < 4; coluna++){
                System.out.printf("| " + casa[linha][coluna] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------");
        //não há retorno, portanto é retornado null
        return null;
    }
    
    public void escolha(int li, int co){
        ListaLigada<Peca> listaPecas = new ListaLigada<>();
        casa[li][co] = listaPecas.Push(new Peca(CoresEnum.VERDE)).toString();
    }
}
