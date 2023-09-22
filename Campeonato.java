import java.io.Serializable;

public class Campeonato implements Serializable{
    private Jogador[] players = new Jogador[5];
    
    public void incluirJogador(String nome, char tipo){
        int i = 0;
        //percorre array de jogador para adicionar no próximo espaço vazio;
        while (i < players.length && players[i] != null) {
            i++;
        }

        // Caso array cheio, não adiciona o jogador;
        if(i < players.length){
            players[i] = new Jogador(nome, tipo);
        }
        else{
            System.out.println("Numero máximo de jogadores atingido!!");
        }        
    }

    public boolean removerJogador(String nome){        
        //percorre array de jogador, procurando pelo nome, caso não ache, retorna falso;
        for(int i=0;i<players.length;i++)
        {
            if(players[i].getNome().equals(nome)){
                players[i].setNome(null); 
                players[i].setTipo('-');
                return true;
            }
        }
        return false;
    }


}
