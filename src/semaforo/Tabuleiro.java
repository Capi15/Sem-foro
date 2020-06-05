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
    private final ListaLigada<Peca> casa = new ListaLigada<>();

    //construtor da classe Tabuleiro
    public Tabuleiro() {
        this.totalPecas = 24;
        this.pecasVerdes = this.pecasAmarelas = this.pecasVermelhas = 8;
        inserePecas();
    }

    //este método é responsável por imprimir o tabuleiro para o ecrã
    public String mostraTabuleiro() {
        //percorre o array por linha
        for (int linha = 0; linha < 3; linha++) {
            System.out.println("-----------------");
            //percorre o array por colunas
            for (int coluna = 0; coluna < 4; coluna++) {
                System.out.printf("| " +  + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------");
        //não há retorno, portanto é retornado null
        return null;
    }

    public void inserePecas() {
        //percorre o array por linha
        for (int linha = 0; linha < 3; linha++) {
            //percorre o array por colunas
            for (int coluna = 0; coluna < 4; coluna++) {
                casa.Push(new Peca(null, linha, coluna));
            }
        }
    }

    public Peca procuraPeca(int linha, int coluna){
         
    }

public void escolha(int li, int co) {
        ListaLigada<Peca> listaPecas = new ListaLigada<>();
        casa[li][co] = listaPecas.Push(new Peca(CoresEnum.VERDE)).toString();
//        if (casa[li][co] == listaPecas.Push(new Peca(CoresEnum.VERDE)).toString()) {
//            casa[li][co] = listaPecas.Push(new Peca(CoresEnum.AMARELO)).toString();
//        } else {
//            return;
//        }
//
//        if (casa[li][co] == listaPecas.Push(new Peca(CoresEnum.AMARELO)).toString()) {
//            casa[li][co] = listaPecas.Push(new Peca(CoresEnum.VERMELHO)).toString();
//        }else{
//           return;
//        } 

    }
    
    public void criaLista
}
