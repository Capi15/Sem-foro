package semaforo;

/**
 *
 * @author bruno
 */
public class Tabuleiro {
    //atributos
    private Peca peca = new Peca();
    private Peca casa[][] = new Peca[3][4]; //criação do array bidimensional(matriz)
    
    //construtor da classe Tabuleiro
    public Tabuleiro(){
        
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
}
