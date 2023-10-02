import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Random;

public class Campeonato implements Serializable{
    private Jogador[] players = new Jogador[10];

    public int jogadoresCheio(){
        int i = 0;

        while(i <= 9 && players[i] != null && players[i].getNome() != null){
            i++;
        }

        return i;
    }
    
    public void incluirJogador(String nome, char tipo, int i){
        // Caso o array esteja cheio, nao adiciona o jogador:
        if(players[i] == null && i < 10){
            players[i] = new Jogador(nome, tipo);
        }
        // Caso tenha um espaco que nao ultrapasse os limites de tamanho do vetor jogador, adiciona um novo: 
        else if(players[i] != null && i < players.length){
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
        Scanner teclado = new Scanner(System.in);
        char confirma;
        int maior = 0, tot = 0, maiorInd = 0;
        Random random = new Random();

        if(players.length == 0){
            System.out.println("Nenhum jogador foi registrado! ");
        }
        else{
            for(Jogador jog : players){
                if(jog != null){
                    jog.inicializarPartida();
                }
            }

            for (int rodada = 1; rodada <= 13; rodada++) {
                System.out.println("\n-.-.-.-.-.-.-.-.-.-.-.-.-.-\nRodada " + rodada + "\n-.-.-.-.-.-.-.-.-.-.-.-.-.-");

                // Loop para permitir que cada jogador realize sua jogada:
                for (Jogador jogador : players) {
                    if(jogador != null){
                        System.out.println("\n" + jogador.getNome() + ", é a sua vez.");
                        jogador.jogada();

                        if(jogador.getTipo() == 'H' || jogador.getTipo() == 'h'){
                            int guia = 0; 
                            int escolha;

                            System.out.println("Deseja jogar (S/N)? ");
                            confirma = teclado.next().charAt(0);
        
                            if (confirma == 'N' || confirma == 'n') {
                                // Se o jogador escolheu pular a vez...
                                int jogadaAleatoria = random.nextInt(13) + 1;
                                while(!jogador.validar(jogadaAleatoria)){
                                    jogadaAleatoria = random.nextInt(13) + 1;
                                }

                                System.out.println("Você pulou a vez. Sua jogada aleatória zerada foi: " + jogadaAleatoria);
                                jogador.gravarPontos(jogadaAleatoria, 0); // ...Zera-se uma jogada aleatória
                            }
                            else{
                                while(guia == 0){
                                    do{
                                        System.out.println("Escolha uma jogada:");
                                        escolha = teclado.nextInt();

                                        if(escolha < 1 || escolha > 13){
                                            System.out.println("Favor, informar um numero entre 1 e 13. ");
                                        }    
                                    }while(escolha < 1 || escolha > 13);

                                    // Verificar se a jogada é válida:
                                    if (jogador.validar(escolha)) {
                                        // Calcular a pontuação da jogada:
                                        int pontuacao = jogador.pontuar(escolha);

                                        System.out.println("Essa jogada gera o seguinte numero de pontos: " + pontuacao);
                                        // O jogador deve decidir se quer validar a jogada:
                                        do{
                                            System.out.println("Deseja confirma-la(S/N)? ");
                                            confirma = teclado.next().charAt(0);
                                        }while(confirma != 's' && confirma != 'S' && confirma != 'n' && confirma != 'N');

                                        // Se o jogador confirmar, a escolha sera validada e a ponntuacao, gravada:
                                        if(confirma == 'S' || confirma == 's'){
                                            jogador.gravarPontos(escolha, pontuacao);
                                            guia = 1;
                                        }
                                        // Se a jogada for negada, outra sera pedida.
                                        else if(confirma == 'N' || confirma == 'n'){
                                            System.out.print("Ok. ");
                                        }
                                    } 
                                    // Se a jogada estiver indisponivel, pede-se para informar outra:
                                    else {
                                        System.out.println("Jogada inválida. Escolha outra jogada.");
                                    }
                                }
                            }
                            
                        }

                        if(jogador.getTipo() == 'M' || jogador.getTipo() == 'm'){
                            int melhorJogada = 1;
                            int melhorPontuacao = 0;
                        
                            for (int choice = 1; choice <= 13; choice++) {
                                if (jogador.validar(choice)) {
                                    int pontuacao = jogador.pontuar(choice);
                                    if (pontuacao > melhorPontuacao) {
                                        melhorPontuacao = pontuacao;
                                        melhorJogada = choice;
                                    }
                                }
                            }
                        
                            System.out.println("Essa jogada gera o seguinte numero de pontos: " + melhorPontuacao);
                            jogador.gravarPontos(melhorJogada, melhorPontuacao);
                        }
                    }
                }
            }
        }

        for (int k = 0; k < 10; k++){
            if(players[k] != null){
                tot = players[k].total();
                if(tot > maior){
                    maior = tot;
                    maiorInd = k;
                }
            }
        }

        System.out.println("\nQuem venceu foi " + players[maiorInd].getNome() + ", com " + maior + " pontos. ");
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
        File arquivo = new File("Campeonato.dat");

        try {
			FileInputStream fin = new FileInputStream(arquivo);
			ObjectInputStream oin = new ObjectInputStream(fin);

			players = (Jogador[])oin.readObject();
			oin.close();
			fin.close();
            mostrarCartela();
		}catch (Exception ex) {
			System.err.println("erro: " + ex.toString());
		}
    }

    public void mostrarCartela(){
        String s = new String();

        System.out.println("---- Cartela de Resultados ----\n \t");

        for(int i = 0; i < players.length; i++){
            if(players[i] != null){
                s = s + "\t" + players[i].getNome() + "(" + players[i].getTipo() + ")";
            }
        }
        System.out.printf(s +"\n");
        
        for(int j = 1; j <= 13; j++){
            s = "";
            s = s + j;
            if(j == 7){
                s = s + "(T)  ";
            }
            else if(j == 8){
                s = s + "(Q)  ";
            }
            else if(j == 9){
                s = s + "(F)  ";
            }
            else if(j == 10){
                s = s + "(S+)";
            }
            else if(j == 11){
                s = s + "(S-)";
            }
            else if(j == 12){
                s = s + "(G) ";
            }
            else if(j == 13){
                s = s + "(X) ";
            }
            else{
                s = s + "     ";
            }

            s = s + "   ";
            for(int i = 0; i < players.length; i++){
                if(players[i]!= null){
                    s += players[i].cartela(j);
                }
            }
            s = s + "\n";
            System.out.println(s);
        }
    }
}
