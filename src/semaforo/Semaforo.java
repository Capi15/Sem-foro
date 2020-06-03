package semaforo;

import java.util.HashSet;

/**
 *
 * @authors
 * Bruno Ribeiro nº21514
 * Tiago Rebelo nº20537
 */
public class Semaforo {
    //atributos da classe
    private static Jogador jogador1;
    private static Jogador jogador2;
    private static int count = 0;
    private static int opcoesMenu = -1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        run(); //chama o método que vai dar inicio ao jogo
    }

    //método responsável pelo inicio de um jogo
    private static void iniciaJogo() {
        int opcoesJogo = -1; //as opçoes disponiveis nos jogo são criadas aqui
        System.out.println("Jogo iniciado");
        // instanciação de um Tabuleiro
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.mostraTabuleiro();
        
        while(opcoesJogo != 0){
            count++; // esta variavel é atualizada a cada jogada, permite saber o numero de jogadas total num jogo
            if(count % 2 == 0){//permite distinguir as jogadas de cada jogador
                System.out.printf("Jogador(a) " + jogador1.getNome() + " é a sua vez de jogar\n");
                System.out.printf("Caso pretenda desistir precione 0\n");
            }else{
                System.out.printf("Jogador(a) " + jogador2.getNome() + " é a sua vez de jogar\n");
                System.out.printf("Caso pretenda desistir precione 0\n");
            }
            opcoesJogo = Le.umInt();
            tabuleiro.mostraTabuleiro();
        }
        
        if(count % 2 == 0 && opcoesJogo == 0){ //permite determinar qual o jogador vencedor caso algum dos jogadores desista
            System.out.printf("\n\nO(A) Jogador(a) " + jogador2.getNome() + " Venceu!!!\n\n\n\n");
        }else{
            System.out.printf("\n\nO(A) Jogador(a) " + jogador1.getNome() + " Venceu!!!\n\n\n\n");
        }
        
        opcoesMenu = -1; // a variáve das opçoes de menu passa a ter o seu valor inicial
        count = 0; // a variável de contador volta ao inicio
        run(); // volta a reiniciar o jogo
    }

    //mostra o menu inicial
    private static void menu() {
        System.out.println("===========Semáforo========================\n");
        System.out.println("***********1- Iniciar Jogo*****************");
        System.out.println("***********0- Sair        *****************\n\n");
        System.out.println("===========================================");
        System.out.println("***********Digite uma opção do menu********");
    }
    
    //primeiro metodo do jogo
    private static void run(){
        menu(); // são chamados os menus
        opcoesMenu = Le.umInt(); // é atualizada a variável de menu
        switch (opcoesMenu) {
            case 0:// caso  a variável de menu seja 0 o jogo termina
                return; 
            case 1:// caso  a variável de menu seja 1 o são criados os jogadores e posteriormente é iniciado o jogo
                criaJogadores();
                iniciaJogo();
            default: run();// para qualquer outro valor o jogo continua a correr
        }
    }
    
    //responsável pela criação dos jogadores
    private static void criaJogadores(){
        String j1;
        String j2;
        //nesta parte são recolidos os nomes dos dois jogadores
        System.out.println("Digite o nome do Primeiro Jogador");
        j1 = Le.umaString();
        System.out.println("Digite o nome do Segundo Jogador");
        j2 = Le.umaString();
        // as variáveis dos jogadores são atualizadas com os nomes inseridos pelo utilizador
        jogador1 = new Jogador(j1);
        jogador2 = new Jogador(j2);
    }

}
