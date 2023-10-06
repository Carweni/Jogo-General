import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Jogador implements Serializable {
    private String nome = new String();
    private char tipo;
    private JogoGeneral jogo = new JogoGeneral(-1);

    public Jogador(String nome, char tipo) { //Inicializa jogador
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() { //Retorna o nome
        return nome;
    }

    public char getTipo() { //Retorna o tipo
        return tipo;
    }

    public void setNome(String nome) { //Altera nome
        this.nome = nome;
    }

    public void setTipo(char tipo) { //Altera tipo
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

    public void jogada(){ //Efetua uma jogada, rolando os dados e imprimindo
       jogo.rolarDados();
       String s = jogo.toString(); 

       System.out.printf(s);
    }

    public boolean validar(int escolha){ //Valida a jogada
        return jogo.validarJogada(escolha);
    }

    public int total(){ //Calcula pontuacao total
        return jogo.calculaTotal();
    }

    public String cartela(int i){ //Retorna pontuacao de uma jogada especifica
        String s = new String();
        s = jogo.montarTabela(i);
        return s;
    }

    public void escolherJogada(){
        Scanner teclado = new Scanner(System.in);
        char confirma;
        Random random = new Random();

        System.out.println("\n" + this.nome + "(" + this.tipo + "), é a sua vez.\nRolando os dados... ");
        this.jogada();
        System.out.println(mostraJogadasExecutadas());
        
        //Verifica se jogador eh humano.
        if(this.tipo == 'H' || this.tipo == 'h'){
            int guia = 0; 
            int escolha = 0;
            int rolou = 0; // Variavel que marca se o jogador ja rolou os dados uma segunda vez.

            while(guia == 0){ // O guia grava se a jogada foi ou nao confirmada.
                do{ 
                    if(rolou == 0){
                        System.out.println("Escolha uma jogada de 1 a 13 (digite 0 para pular a vez ou 14 para rolar os dados novamente): ");
                        escolha = teclado.nextInt();
                    }
                    else if(rolou == 1){
                        System.out.println("Escolha uma jogada de 1 a 13 (digite 0 para pular a vez): ");
                        escolha = teclado.nextInt();
                    }
                    
                    if(escolha < 0 || escolha > 14){
                        if(rolou == 0){
                            System.out.println("Favor, informar um numero entre 0 e 14. ");
                        }

                        if(rolou == 1){
                            System.out.println("Favor, informar um numero entre 0 e 13. ");
                        }
                    }    
                }while(escolha < 0 || escolha > 14); // Verifica se eh um numero valido.
            
                if (escolha == 0) { // Caso pule a vez:
                    int jogadaAleatoria;
                    do {
                        jogadaAleatoria = random.nextInt(13) + 1;
                    } while (!this.validar(jogadaAleatoria));
                
                    System.out.println("Você pulou a vez. Sua jogada aleatória zerada foi: " + jogadaAleatoria);
                    jogo.setJogada(jogadaAleatoria, 0); // Atribui zero a ela.
                    guia = 1;
                }
                // Se o jogador escolher rolar os dados novamente,
                // ele ganha uma unica chance de fazer isso:
                else if(escolha == 14 && rolou == 0){ 
                    this.jogada();
                    System.out.println(mostraJogadasExecutadas());
                    rolou = 1;
                }
                else if(escolha == 14 && rolou == 1){
                    System.out.println("Os dados ja rolaram uma segunda vez. Escolha uma jogada entre 1 e 13 ou pule a vez. ");
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

        //Verifica se o jogador eh maquina
        if(this.tipo == 'M' || this.tipo == 'm'){
            int melhorJogada = -1;
            int melhorPontuacao = 0;
            
            //Percorre jogadas para determinar a melhor
            for (int choice = 1; choice <= 13; choice++) {
                if (validar(choice)) {
                    int pontuacao = jogo.pontuarJogada(choice);
                    if (pontuacao > melhorPontuacao) {
                        melhorPontuacao = pontuacao;
                        melhorJogada = choice;
                    }
                }
            }

            //caso todas as pontuacoes forem 0, escolhe uma aleatoria para zerar
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