import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Campeonato implements Serializable{
    private Jogador[] players = new Jogador[5];

    public int jogadoresCheio(){
        int i = 0;

        while(i <= 4 && players[i] != null && players[i].getNome() != null){
            i++;
        }

        return i;
    }
    
    public void incluirJogador(String nome, char tipo, int i){
        //caso array cheio, não adiciona o jogador;
        if(players[i]==null && i < 5){
            players[i] = new Jogador(nome, tipo);
        }
        else if(players[i]!=null && i < players.length){
            players[i].setNome(nome);
            players[i].setTipo(tipo);
        }      
    }

    public boolean removerJogador(String nome){        
        // Percorre array de jogador, procurando pelo nome. Caso não ache, retorna falso:
        if(this.players != null){
            for(int i = 0; i < 5; i++){
                if(this.players[i] != null){
                    if(this.players[i].getNome().equals(nome)){
                        players[i].setNome(null); 
                        players[i].setTipo(' ');
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void iniciarCampeonato(){
        Scanner tec = new Scanner(System.in);

        if(players.length == 0){
            System.out.println("Nenhum jogador foi registrado! ");
        }
        else{
            for (int rodada = 1; rodada <= 13; rodada++) {
                System.out.println("\nRodada " + rodada);

                // Loop para permitir que cada jogador realize sua jogada:
                for (Jogador jogador : players) {
                    if(jogador != null){
                        System.out.println(jogador.getNome() + ", é a sua vez.");
                        jogador.jogada();

                        System.out.println("Escolha uma jogada:");
                        int escolha = tec.nextInt();

                        // Verificar se a jogada é válida:
                        if (jogador.validarJogada(escolha)) {
                            // Calcular a pontuação da jogada:
                            int pontuacao = jogador.pontuar(escolha);
                        } 
                        else {
                            System.out.println("Jogada inválida. Escolha outra jogada.");
                        }
                    }
                }
            }
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
    }

    public void lerDoArquivo(){
        try {
            File arquivo = new File("Campeonato.dat");
			FileInputStream fin = new FileInputStream(arquivo);
			ObjectInputStream oin = new ObjectInputStream(fin);

			players = (Jogador[]) oin.readObject();
			oin.close();
			fin.close();
		}catch (Exception ex) {
			System.err.println("erro: " + ex.toString());
		}
    }

}
