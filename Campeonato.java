public class Campeonato {
    private Jogador[] players = new Jogador[5];
    
    public void incluirJogador(String nome, String tipo){
        int i=0;
        while(players[i].getNome()!=null && i<players.length){
            i++;
        }

        players[i] = new Jogador(nome, tipo);
        
    }

    public boolean removerJogador(String nome){
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