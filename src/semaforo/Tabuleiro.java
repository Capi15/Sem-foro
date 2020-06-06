package semaforo;

/**
 * @authors Bruno Ribeiro nº21514 
 * @authors Tiago Rebelo nº20537
 */

public class Tabuleiro {
    private final int totalPecas;
    private final ListaLigada<Peca> casa = new ListaLigada<>();
    //construtor da classe Tabuleiro
    
        public Tabuleiro() {
            this.totalPecas = 24;
        }

    //este método é responsável por imprimir o tabuleiro para o ecrã
    public String mostraTabuleiro() {
        //percorre o array por linha
        for (int linha = 1; linha <= 3; linha++) {
            System.out.println("-----------------");
            //percorre o array por colunas
            for (int coluna = 1; coluna <= 4; coluna++) {
                System.out.printf("| " + procuraPeca(linha, coluna) + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------");
        //não há retorno, portanto é retornado null
        return null;
    }

    public void inserePecas() {
        //percorre o array por linha
        for (int linha = 1; linha <= 3; linha++) {
            //percorre o array por colunas
            for (int coluna = 1; coluna <= 4; coluna++) {
                casa.Push(new Peca(Cor.NONE, linha, coluna));
                System.out.println(casa);
            }
        }
    }

    public Peca procuraPeca(int linha, int coluna){
        Nodo aux = casa.getHead();
        while(aux!= null) {
            if(((Peca)aux.getDados()).getX()== coluna && ((Peca)aux.getDados()).getY()== linha ){
                return ((Peca)aux.getDados());
            }
            aux= aux.getNext();
        }
        return null;
    }
    
    public String mascara(Peca x){
        if(x.getCor().equals(Cor.NONE)){
                return "        ";
        }else{
            return x.getCor().toString();
        }
    }

    //para verificar a peça e trocar a cor dela
    public void escolha(int li, int co) {
        Peca x = procuraPeca(li,co); //converte o x numa peça para simplificar
        switch (x.getCor()) {
            case NONE:
                x.setCor(Cor.VERDE);
                break;
            case VERDE:
                x.setCor(Cor.AMARELO);
                break;
            case AMARELO:
                x.setCor(Cor.VERMELHO);
                break;
            default:
                break;
        }
        }
    
    //---- validação das jogadas-----
    public boolean vizHorizontal(int li, int co){
        
        Peca x = procuraPeca(li,co);
        System.out.println(x.getCor());
        System.out.println(Cor.NONE);
        System.out.println(x);
        if(co==1){
            Peca x2 = procuraPeca(li,co+1);
            System.out.println(x2);
            Peca x3 = procuraPeca(li,co+2);
            System.out.println(x3);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }else if(co==2 || co==3){
            Peca x2 = procuraPeca(li,co-1);
            Peca x3 = procuraPeca(li,co+1);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }else if(co==4){
            Peca x2 = procuraPeca(li,co-1);
            Peca x3 = procuraPeca(li,co-2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }
        System.out.println("teste VH Falso\n");
        return false;
    }
    
    public boolean vizVertical(int li, int co){
        Peca x = procuraPeca(li,co);
        if(li==1){
            Peca x2 = procuraPeca(li+1,co);
            Peca x3 = procuraPeca(li+2,co);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }
        if(li==2){
            Peca x2 = procuraPeca(li-1,co);
            Peca x3 = procuraPeca(li+1,co);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }
        if(li==3){
            Peca x2 = procuraPeca(li-1,co);
            Peca x3 = procuraPeca(li-2,co);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }
        System.out.println("teste VV Falso\n");
        return false;
    }
    
    public boolean vizDiagonal(int li, int co){
        Peca x = procuraPeca(li,co);
        if(co==1 && li==1){
            Peca x2 = procuraPeca(li+1,co+1);
            Peca x3 = procuraPeca(li+2,co+2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }else if(co==2 && li==1){
            Peca x2 = procuraPeca(li+1,co+1);
            Peca x3 = procuraPeca(li+2,co+2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }else if(co==3 && li==1){
            Peca x2 = procuraPeca(li+1,co-1);
            Peca x3 = procuraPeca(li+2,co-2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }else if(co==4 && li==1){
            Peca x2 = procuraPeca(li+1,co-1);
            Peca x3 = procuraPeca(li+2,co-2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }else if(co==1 && li==3){
            Peca x2 = procuraPeca(li-1,co+1);
            Peca x3 = procuraPeca(li-2,co+2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }else if(co==2 && li==3){
            Peca x2 = procuraPeca(li-1,co+1);
            Peca x3 = procuraPeca(li-2,co+2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }else if(co==3 && li==3){
            Peca x2 = procuraPeca(li-1,co-1);
            Peca x3 = procuraPeca(li-2,co-2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }else if(co==4 && li==3){
            Peca x2 = procuraPeca(li-1,co-1);
            Peca x3 = procuraPeca(li-2,co-2);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()))
                    return true;
        }else if(co==2 && li==2){
            Peca x2 = procuraPeca(li-1,co-1);
            Peca x3 = procuraPeca(li+1,co+1);
            Peca x4 = procuraPeca(li-1,co+1);
            Peca x5 = procuraPeca(li+1,co-1);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()) || x4.getCor().equals(x.getCor()) && x5.getCor().equals(x.getCor()))
                    return true;
        }else if(co==3 && li==2){
            Peca x2 = procuraPeca(li-1,co-1);
            Peca x3 = procuraPeca(li+1,co+1);
            Peca x4 = procuraPeca(li-1,co+1);
            Peca x5 = procuraPeca(li+1,co-1);
                if(x2.getCor().equals(x.getCor()) && x3.getCor().equals(x.getCor()) || x4.getCor().equals(x.getCor()) && x5.getCor().equals(x.getCor()))
                    return true;
        }
        System.out.println("teste VD Falso\n");
        return false;
        }

    //--------------------------------
    
    public boolean jogada(int li, int co){
        if(vizHorizontal(li, co) || vizVertical(li, co) || vizDiagonal(li, co)){
            return true;
        }
            return false;
    }
}