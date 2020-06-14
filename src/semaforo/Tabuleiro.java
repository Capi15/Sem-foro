package semaforo;

/**
 * @authors Bruno Ribeiro nº21514 
 * @authors Tiago Rebelo nº20537
 */

public class Tabuleiro {
    private int pG, pY, pR; //peças  -  pg -> Verde / pY -> Amarela / pR -> Vermelha
    private final ListaLigada casa = new ListaLigada();
    //construtor da classe Tabuleiro
    
        public Tabuleiro() {
            this.pG = 8;
            this.pY = 8;
            this.pR = 8;
        }

    //este método é responsável por imprimir o tabuleiro para o ecrã
    public String mostraTabuleiro() {
        //percorre o array por linha
        for (int linha = 1; linha <= 3; linha++) {
            System.out.println("+----------+----------+----------+----------+");
            //percorre o array por colunas
            for (int coluna = 1; coluna <= 4; coluna++) {
                System.out.printf("|" + mascara(procuraPeca(linha, coluna)) + "");
            }
            System.out.println("|");
        }
        System.out.println("+----------+----------+----------+----------+");
        //não há retorno, portanto é retornado null
        return null;
    }

    public void inserePecas() {
        //percorre o array por linha
        for (int linha = 1; linha <= 3; linha++) {
            //percorre o array por colunas
            for (int coluna = 1; coluna <= 4; coluna++) {
                //System.out.println("teste inserePecas");
                casa.addNodo(new Peca(Cor.NONE, linha, coluna));
            }
        }
    }

    public Peca procuraPeca(int linha, int coluna){
        Nodo aux = casa.getHead();
        while(aux!= null) {
            //System.out.println((Peca)aux.getDados());
            if(((Peca)aux.getDados()).getX()== linha && ((Peca)aux.getDados()).getY()== coluna ){
                return ((Peca)aux.getDados());
            }
            aux = aux.getNext();
        }
        return null;
    }
    
    public String mascara(Peca x){
        switch (x.getCor()) {
                case NONE:
                    return "          ";
                case VERDE:
                    return"  "+ x.toString()+"   ";
                case AMARELO:
                    return" "+ x.toString()+"  ";
                case VERMELHO:
                    return" "+ x.toString()+" ";   
        /*if(x.getCor().equals(Cor.NONE)){
                return "        ";
        }else if(x.getCor().equals(Cor.VERDE)){
            return "  "+ x.toString()+"  ";
        }else if(x.getCor().equals(Cor.AMARELO)){
            return " "+ x.toString()+" ";
        }else if(x.getCor().equals(Cor.VERMELHO)){
            return x.toString();
        }
        return "        ";*/
    }
        return "";
    }

    //para verificar a peça e trocar a cor dela
    public boolean escolha(int linha, int coluna) {
        Peca x = procuraPeca(linha, coluna); //converte o x numa peça para simplificar
        switch (x.getCor()) {
            case NONE:
                pG--;
                if(pG<=0){
                    return false;
                }else{
                    x.setCor(Cor.VERDE);
                    return true;
                }
            case VERDE:
                pY--;
                if(pY<=0){
                    return false;
                }else{
                    x.setCor(Cor.AMARELO);
                    pG++;
                    return true;
                }
            case AMARELO:
                pR--;
                if(pR<=0){
                    pY++;
                    return false;
                }else{
                    x.setCor(Cor.VERMELHO);
                    return true;
                }
            default:
                return false;
        }
    }
    
       //---- validação das jogadas-----
    public boolean vizHorizontal(int li, int co){
        Peca x = procuraPeca(li,co);
        System.out.println(x.getCor());
        if(co==1){
            Peca x2 = procuraPeca(li,co+1);
            System.out.println(x2.getCor());
            Peca x3 = procuraPeca(li,co+2);
            System.out.println(x3.getCor());
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada horizontal.\n Peça: " + x.getCor());
                    return true;
                }
        }else if(co==2){
            Peca x2 = procuraPeca(li,co-1);
            System.out.println(x2.getCor());
            Peca x3 = procuraPeca(li,co+1);
            System.out.println(x3.getCor());
            Peca x4 = procuraPeca(li, co+2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada horizontal.\n Peça: " + x.getCor());
                    return true;
                }else if(x3.getCor().equals(x.getCor()) && x4.getCor().equals(x.getCor())){
                    System.out.println("Jogada horizontal.\n Peça: " + x.getCor());
                    return true;
                }
        }else if(co==3){
            Peca x2 = procuraPeca(li,co-1);
            System.out.println(x2.getCor());
            Peca x3 = procuraPeca(li,co+1);
            System.out.println(x3.getCor());
            Peca x4 = procuraPeca(li, co-2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada horizontal.\n Peça: " + x.getCor());
                    return true;
                }else if(x2.getCor().equals(x.getCor()) && x4.getCor().equals(x.getCor())){
                    System.out.println("Jogada horizontal.\n Peça: " + x.getCor());
                    return true;
                }
        }else if(co==4){
            Peca x2 = procuraPeca(li,co-1);
            System.out.println(x2.getCor());
            Peca x3 = procuraPeca(li,co-2);
            System.out.println(x3.getCor());
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada horizontal.\n Peça: " + x.getCor());
                    return true;
        }
        }
        return false;
    }
    
    public boolean vizVertical(int li, int co){
        Peca x = procuraPeca(li,co);
        if(li==1){
            Peca x2 = procuraPeca(li+1,co);
            Peca x3 = procuraPeca(li+2,co);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada Vertical.\n Peça: " + x.getCor());
                    return true;
                }
        }
        if(li==2){
            Peca x2 = procuraPeca(li-1,co);
            Peca x3 = procuraPeca(li+1,co);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada Vertical.\n Peça: " + x.getCor());
                    return true;
                }
        }
        if(li==3){
            Peca x2 = procuraPeca(li-1,co);
            Peca x3 = procuraPeca(li-2,co);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada Vertical.\n Peça: " + x.getCor());
                    return true;
                }
        }
        return false;
    }
    
    public boolean vizDiagonal(int li, int co){
        Peca x = procuraPeca(li,co);
        if(co==1 && li==1){
            Peca x2 = procuraPeca(li+1,co+1);
            Peca x3 = procuraPeca(li+2,co+2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada Diagonal.\n Peça: " + x.getCor());
                    return true;
                }
        }else if(co==2 && li==1){
            Peca x2 = procuraPeca(li+1,co+1);
            Peca x3 = procuraPeca(li+2,co+2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada Diagonal.\n Peça: " + x.getCor());
                    return true;
                }
        }else if(co==3 && li==1){
            Peca x2 = procuraPeca(li+1,co-1);
            Peca x3 = procuraPeca(li+2,co-2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada Diagonal.\n Peça: " + x.getCor());
                    return true;
                }
        }else if(co==4 && li==1){
            Peca x2 = procuraPeca(li+1,co-1);
            Peca x3 = procuraPeca(li+2,co-2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada Diagonal.\n Peça: " + x.getCor());
                    return true;
                }
        }else if(co==1 && li==3){
            Peca x2 = procuraPeca(li-1,co+1);
            Peca x3 = procuraPeca(li-2,co+2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada Diagonal.\n Peça: " + x.getCor());
                    return true;
                }
        }else if(co==2 && li==3){
            Peca x2 = procuraPeca(li-1,co+1);
            Peca x3 = procuraPeca(li-2,co+2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada Diagonal.\n Peça: " + x.getCor());
                    return true;
                }
        }else if(co==3 && li==3){
            Peca x2 = procuraPeca(li-1,co-1);
            Peca x3 = procuraPeca(li-2,co-2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada Diagonal.\n Peça: " + x.getCor());
                    return true;
                }
        }else if(co==4 && li==3){
            Peca x2 = procuraPeca(li-1,co-1);
            Peca x3 = procuraPeca(li-2,co-2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor())){
                    System.out.println("Jogada Diagonal.\n Peça: " + x.getCor());
                    return true;
                }
        }else if(co==2 && li==2){
            Peca x2 = procuraPeca(li-1,co-1);
            Peca x3 = procuraPeca(li+1,co+1);
            Peca x4 = procuraPeca(li-1,co+1);
            Peca x5 = procuraPeca(li+1,co-1);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()) || x4.getCor().equals(x.getCor()) && x5.getCor().equals(x.getCor())){
                    System.out.println("Jogada Diagonal.\n Peça: " + x.getCor());
                    return true;
                }
        }else if(co==3 && li==2){
            Peca x2 = procuraPeca(li-1,co-1);
            Peca x3 = procuraPeca(li+1,co+1);
            Peca x4 = procuraPeca(li-1,co+1);
            Peca x5 = procuraPeca(li+1,co-1);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()) || x4.getCor().equals(x.getCor()) && x5.getCor().equals(x.getCor())){
                    System.out.println("Jogada Diagonal.\n Peça: " + x.getCor());
                    return true;
                }
        }
        return false;
        }
       //--------------------------------

    public boolean jogada(int li, int co){
        boolean teste;
        teste = vizHorizontal(li, co);
        if(teste==false){
            teste= vizVertical(li, co);
            if(teste == false){
                teste= vizDiagonal(li, co);
                if(teste==false){
                }else{
                return true;
            }
            }else{
                return true;
            }
        }else{
            return true;
        }
        return false;
    }
}