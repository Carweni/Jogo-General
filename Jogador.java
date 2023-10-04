import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Jogador implements Serializable {
    private String nome = new String();
    private char tipo;
    private JogoGeneral jogo = new JogoGeneral(-1);

    public Jogador(String nome, char tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public char getTipo() {
        return tipo;
    }

    public JogoGeneral getJogo() {
        return jogo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String mostraJogadasExecutadas(){
        String s = new String();

        s = "1\t2\t3\t4\t5\t6\t7(T)\t8(Q)\t9(F)\t10(S+)\t11(S-)\t12(G)\t13(X)\n";

        for(int i = 1; i <= 13; i++){
            s = s + this.cartela(i);
        }
        return s;
    }

    public void inicializarPartida(){
        jogo.inicializarJogadas();
    }

    public void jogada(){
       jogo.rolarDados();
       String s = jogo.toString(); 

       System.out.printf(s);
    }

    public boolean validar(int escolha){
        return jogo.validarJogada(escolha);
    }

    public int total(){
        return jogo.calculaTotal();
    }

    public String cartela(int i){
        String s = new String();
        s = jogo.montarTabela(i);
        return s;
    }

    public void escolherJogada(){
        Scanner teclado = new Scanner(System.in);
        char confirma;
        Random random = new Random();
        System.out.println("\n" + this.nome + ", é a sua vez.");
        this.jogada();
        System.out.println(mostraJogadasExecutadas());

        if(this.tipo == 'H' || this.tipo == 'h'){
            int guia = 0; 
            int escolha;

            while(guia == 0){ // O guia grava se a jogada foi ou nao confirmada.
                do{
                    System.out.println("Escolha uma jogada de 1 a 13 (digite 0 para pular a vez): ");
                    escolha = teclado.nextInt();
                    
                    if(escolha < 0 || escolha > 13){
                        System.out.println("Favor, informar um numero entre 0 e 13. ");
                    }    
                }while(escolha < 0 || escolha > 13);
            
                if (escolha == 0) {
                    int jogadaAleatoria;
                    do {
                        jogadaAleatoria = random.nextInt(13) + 1;
                    } while (!this.validar(jogadaAleatoria));
                
                    System.out.println("Você pulou a vez. Sua jogada aleatória zerada foi: " + jogadaAleatoria);
                    jogo.setJogada(jogadaAleatoria, 0); // Atribui zero a ela.
                }
                else{
                    // Verificar se a jogada é válida:
                    if (validar(escolha)) {
                        // Calcular a pontuação da jogada:
                        int pontuacao = jogo.pontuarJogada(escolha);

                        System.out.println("Essa jogada gera o seguinte numero de pontos: " + pontuacao);
                        // O jogador deve decidir se quer validar a jogada:
                        do{
                            System.out.println("Deseja confirma-la(S/N)? ");
                            confirma = teclado.next().charAt(0);
                            teclado.nextLine();
                        }while(confirma != 's' && confirma != 'S' && confirma != 'n' && confirma != 'N');

                        // Se o jogador confirmar, a escolha sera validada e a ponntuacao, gravada:
                        if(confirma == 'S' || confirma == 's'){
                            jogo.setJogada(escolha, pontuacao);
                            guia = 1;
                        }
                        // Se a jogada for negada, outra sera pedida.
                        else if(confirma == 'N' || confirma == 'n'){
                            System.out.print("Ok. ");
                            teclado.nextLine();
                        }
                    } 
                    // Se a jogada estiver indisponivel, pede-se para informar outra:
                    else {
                        System.out.println("Jogada inválida. Escolha outra jogada.");
                    }
                }
            }
                            
        }

        if(this.tipo == 'M' || this.tipo == 'm'){
            int melhorJogada = -1;
            int melhorPontuacao = 0;
                        
            for (int choice = 1; choice <= 13; choice++) {
                if (validar(choice)) {
                    int pontuacao = jogo.pontuarJogada(choice);
                    if (pontuacao > melhorPontuacao) {
                        melhorPontuacao = pontuacao;
                        melhorJogada = choice;
                    }
                }
            }

            if(melhorJogada == -1){
                melhorJogada = random.nextInt(13) + 1;
                while(!validar(melhorJogada)){
                    melhorJogada = random.nextInt(13) + 1;
                }
                melhorPontuacao = 0;
            }
                        
            System.out.println("Essa jogada gera o seguinte numero de pontos: " + melhorPontuacao);
            jogo.setJogada(melhorJogada, melhorPontuacao);
        }
    }            
}