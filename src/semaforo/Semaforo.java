package semaforo;

import java.util.HashSet;

/**
 *
 * @author Bruno Ribeiro Tiago Rebelo
 */
public class Semaforo {
    private static Jogador jogador1;
    private static Jogador jogador2;
    private static int count = 0;
    private static int opcoesMenu = -1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        run();
    }

    private static void iniciaJogo() {
        int opcoesJogo = -1;
        System.out.println("Jogo iniciado");
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.mostraTabuleiro();
        
        while(opcoesJogo != 0){
            count++;
            if(count % 2 == 0){
                System.out.printf("Jogador(a) " + jogador1.getNome() + " é a sua vez de jogar\n");
                System.out.printf("Caso pretenda desistir precione 0\n");
            }else{
                System.out.printf("Jogador(a) " + jogador2.getNome() + " é a sua vez de jogar\n");
                System.out.printf("Caso pretenda desistir precione 0\n");
            }
            opcoesJogo = Le.umInt();
            tabuleiro.mostraTabuleiro();
        }
        
        if(count % 2 == 0 && opcoesJogo == 0){
            System.out.printf("\n\nO(A) Jogador(a) " + jogador2.getNome() + " Venceu!!!\n\n\n\n");
        }else{
            System.out.printf("\n\nO(A) Jogador(a) " + jogador1.getNome() + " Venceu!!!\n\n\n\n");
        }
        
        opcoesMenu = -1;
        run();
    }

    private static void menu() {
        System.out.println("===========Semáforo========================\n");
        System.out.println("***********1- Iniciar Jogo*****************");
        System.out.println("***********0- Sair        *****************\n\n");
        System.out.println("===========================================");
        System.out.println("***********Digite uma opção do menu********");
    }
    
    private static void run(){
        menu();
        opcoesMenu = Le.umInt();
        switch (opcoesMenu) {
            case 0:
                return;
            case 1:
                criaJogadores();
                iniciaJogo();
            default: run();
        }
    }
    
    private static void criaJogadores(){
        String j1;
        String j2;
        System.out.println("Digite o nome do Primeiro Jogador");
        j1 = Le.umaString();
        System.out.println("Digite o nome do Segundo Jogador");
        j2 = Le.umaString();
        jogador1 = new Jogador(j1);
        jogador2 = new Jogador(j2);
    }

}
