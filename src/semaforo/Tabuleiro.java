package semaforo;

/**
 *
 * @author bruno
 */
public class Tabuleiro {
    private Peca peca = new Peca();
    private Peca casa[][] = new Peca[3][4];
    
    
    public Tabuleiro(){
        
    }
    
    public String mostraTabuleiro(){
        for (int linha = 0; linha < 3; linha++){
            System.out.println("-----------------");
            for(int coluna = 0; coluna < 4; coluna++){
                System.out.printf("| " + casa[linha][coluna] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------");
        return null;
    }
}
