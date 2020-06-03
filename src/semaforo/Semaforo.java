package semaforo;

/**
 *
 * @author Bruno Ribeiro Tiago Rebelo
 */
public class Semaforo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        run();

    }

    private static void iniciaJogo() {
        System.out.println("Jogo iniciado");
    }

    private static void menu() {
        System.out.println("===========Semáforo========================\n");
        System.out.println("***********1- Iniciar Jogo*****************");
        System.out.println("***********0- Sair        *****************\n\n\n");
        System.out.println("===========================================");
        System.out.println("***********Digite uma opção do menu********");
    }
    
    private static void run(){
        int opcoesMenu = -1;
        
        menu();
        opcoesMenu = Le.umInt();
        switch (opcoesMenu) {
            case 0:
                return;
            case 1:
                iniciaJogo();
        }
    }

}
