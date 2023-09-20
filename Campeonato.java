public class Campeonato {
    private Jogador[] players = new Jogador[5];
    
    public void incluirJogador(String nome, String tipo){
        int i=0;
        //percorre array de jogador para adicionar no próximo espaço vazio;
        while(players[i].getNome()!=null && i<players.length){
            i++;
        }
        //caso array cheio, não adiciona o jogador;
        if(i<players.length){
            players[i] = new Jogador(nome, tipo);
        }
        else{
            System.out.println("Numero máximo de jogadores atingido!!");
        }        
    }

    public boolean removerJogador(String nome){
        //percorre array de jogador, procurando pelo nome, caso não ache, retorna falso;
        for(int i=0;i<players.length;i++){
            if(players[i].getNome()==nome){
                players[i].setNome(null); 
                players[i].setTipo(null);
                return true;
            }
        }
        return false;
    }


}
