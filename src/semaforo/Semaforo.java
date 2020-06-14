package semaforo;

import java.util.HashSet;

/**
 * @authors Bruno Ribeiro nº21514 
 * @authors Tiago Rebelo nº20537
 */

public class Semaforo {

    //atributos da classe
    private static Jogador jogador1;
    private static Jogador jogador2;
    private static int count = 0;
    private static int opcoesMenu = -1;
    private static int linha, coluna;
    private static boolean validado = false;

    public static void main(String[] args) {
        run(); //chama o método que vai dar inicio ao jogo
    }

    //método responsável pelo inicio de um jogo
    private static void iniciaJogo() {
        int continuar;
        boolean opcoesJogo = false;//as opçoes disponiveis nos jogo são criadas aqui
        
        System.out.println("Jogo iniciado");
        // instanciação de um Tabuleiro
        Tabuleiro tabu = new Tabuleiro();
        tabu.inserePecas();
        tabu.mostraTabuleiro();
        while (opcoesJogo == false) {
            count++; // esta variavel é atualizada a cada jogada, permite saber o numero de jogadas total num jogo
            if (count % 2 == 0) {//permite distinguir as jogadas de cada jogador. caso seja par ou impar
                System.out.printf("Jogador(a) " + jogador2.getNome() + " é a sua vez de jogar\n");
            } else {
                System.out.printf("Jogador(a) " + jogador1.getNome() + " é a sua vez de jogar\n");
            }
            System.out.println("Caso pretenda desistir escreva 0, caso contrario precione 1\n");
            continuar = Le.umInt();
            switch (continuar) {
                case 0:
                    if (count % 2 == 0) { //permite determinar qual o jogador vencedor caso algum dos jogadores desista
                        System.out.printf("\n\nO(A) Jogador(a) " + jogador1.getNome() + " Venceu!!!\n\n\n\n");
                        count=0;
                    } else {
                        System.out.printf("\n\nO(A) Jogador(a) " + jogador2.getNome() + " Venceu!!!\n\n\n\n");
                        count=0;
                    }
                    return;
                case 1:
                    while(validado == false){
                        System.out.println("Escolha a linha onde pretende jogar:");
                        linha = Le.umInt();
                        System.out.println("Escolha a coluna onde pretende jogar:");
                        coluna = Le.umInt();
                        if(linha <= 3 && linha > 0 && coluna <= 4 && coluna > 0){
                                if(tabu.escolha(linha, coluna)==false){
                                    System.out.println("Não é possível alterar a peça vermelha. Regra de jogo.\n Por favor faça outra jogada");
                                }else{
                                    tabu.mostraTabuleiro();
                                    opcoesJogo = tabu.jogada(linha, coluna);
                                    System.out.println(opcoesJogo);
                                    validado = true;
                                }
                            
                            }else{
                                System.out.println("Os valores colocados são invalidos.\nPor favor verifique as coordenadas de cada casa no tabuleiro");
                            }
                        
                        }
                        validado = false;
                        if (opcoesJogo == true) {
                            if (count % 2 == 0) { //permite determinar qual o jogador vencedor caso algum dos jogadores desista
                                System.out.printf("\n\nO(A) Jogador(a) " + jogador2.getNome() + " Venceu!!!\n\n\n\n");
                                count=0;
                            } else {
                                System.out.printf("\n\nO(A) Jogador(a) " + jogador1.getNome() + " Venceu!!!\n\n\n\n");
                                count=0;
                            }
                    }
                    break;
                default:
                    return;
            }
        }

        opcoesMenu = -1; // a variável das opçoes de menu passa a ter o seu valor inicial
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
    private static void run() {
        menu(); // são chamados os menus
        opcoesMenu = Le.umInt(); // é atualizada a variável de menu
        switch (opcoesMenu) {
            case 0:// caso  a variável de menu seja 0 o jogo termina
                return;
            case 1:// caso  a variável de menu seja 1 o são criados os jogadores e posteriormente é iniciado o jogo
                criaJogadores();
                iniciaJogo();
            default:
                run();// para qualquer outro valor o jogo continua a correr
        }
    }

    //responsável pela criação dos jogadores
    private static void criaJogadores() {
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
