public class Campeonato {
    private Jogador[] players = new Jogador[10];
    
    public void incluirJogador(String nome, char tipo){
        int i=0;
        //percorre array de jogador para adicionar no próximo espaço vazio;
        while(players[i]!= null && players[i].getNome()!=" " && i<players.length){
            i++;
        }
        //caso array cheio, não adiciona o jogador;
        if(players[i]==null && i<players.length){
            players[i] = new Jogador(nome, tipo);
        }
        else if(players[i]!=null && i<players.length){
            players[i].setNome(nome);
            players[i].setTipo(tipo);
        }
        else{
            System.out.println("Numero máximo de jogadores atingido!!");
        }

    }

    public boolean removerJogador(String nome){
        //percorre array de jogador, procurando pelo nome, caso não ache, retorna falso;
        for(int i=0;i<players.length;i++){
            if(players[i]!=null && players[i].getNome()==nome){
                players[i].setNome(" "); 
                players[i].setTipo(' ');
                return true;
            }
        }
        return false;
    }

    public void iniciarCampeonato(){
        
    }

    public void mostrarCartela(){

    }

    public void gravarEmArquivo(){

    }

    public void lerDoArquivo(){

    }
}