import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Campeonato implements Serializable{
    private Jogador[] players = new Jogador[5];
    
    public void incluirJogador(String nome, char tipo){
        int i = 0;
        // Percorre array de jogador para adicionar no próximo espaço vazio:
        while (i < players.length && players[i] != null) {
            i++;
        }

        // Caso array cheio, não adiciona o jogador;
        if(i < players.length){
            players[i] = new Jogador(nome, tipo);
        }
        else{
            System.out.println("Numero máximo de jogadores atingido!!! Nao foi possivel incluir");
        }        
    }

    public boolean removerJogador(String nome){        
        // Percorre array de jogador, procurando pelo nome. Caso não ache, retorna falso:
        if(this.players != null){
            for(int i = 0; i < players.length; i++){
                if(this.players[i] != null){
                    if(this.players[i].getNome().equals(nome)){
                        players[i].setNome(null); 
                        players[i].setTipo('-');
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void iniciarCampeonato(){
        if(players.length == 0){
            System.out.println("Nenhum jogador foi registrado! ");
        }
        else{

        }
    }

    public void gravarEmArquivo(){
		File arquivo = new File("Campeonato.dat");
        try {
			FileOutputStream fout = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fout);

			oos.writeObject(players);
            oos.flush();
			oos.close();
			fout.close();
		}catch(Exception ex) {
			System.err.println("erro: " + ex.toString());
        }
		break;
    }

    public void lerDoArquivo(){
        try {
			FileInputStream fin = new FileInputStream(arquivo);
			ObjectInputStream oin = new ObjectInputStream(fin);

			players = (Jogador[]) oin.readObject();
			oin.close();
			fin.close();
		}catch (Exception ex) {
			System.err.println("erro: " + ex.toString());
		}

 		break;
    }

}
