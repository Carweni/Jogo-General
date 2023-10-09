import java.util.Scanner;

public class UsaCampeonato {
    public static void main(String []args){
        Scanner tec = new Scanner(System.in);
        char op;
        int sair = 0;
        
        Campeonato league = new Campeonato();

        System.out.println(":..::..: Menu interativo :..::..: ");
        System.out.println("a - Incluir jogador"); 
        System.out.println("b - Remover jogador"); 
        System.out.println("c - Executar rodada"); 
        System.out.println("d - Mostrar cartela de resultados"); 
        System.out.println("e - Gravar os resultados em arquivo"); 
        System.out.println("f - Ler os dados em arquivo"); 
        System.out.println("g - Sair do jogo"); 
        System.out.println("j - Mostrar tabela de jogadores");
        System.out.println("r - Mostrar regras do jogo");

        while(sair == 0){
            // Escolhe-se uma opcao do menu. Se for invalida, informa-se o usuario e esse informa uma nova escolha.
            do{
                System.out.println("Escolha a sua opcao (m mostra o menu novamente): ");
                op = tec.next().charAt(0);
    
                if (op != 'a' && op != 'b' && op != 'c' && op != 'd' && op != 'e' && op != 'f' && op != 'g' && op != 'm' && op != 'j' && op != 'r'){
                    System.out.println("Opcao invalida! Tente novamente.");
                }
            }while(op != 'a' && op != 'b' && op != 'c' && op != 'd' && op != 'e' && op != 'f' && op != 'g' && op != 'm' && op != 'j' && op != 'r');
            
            tec.nextLine(); // Limpa o buffer do teclado.
    
            switch(op){
                case 'a': // Se a escolha foi 'a', incluie-se um jogador:
                    char tipo;
                    String nome;
                    int n = league.jogadorLivre();

                    if(n < league.getLength()){ //Verifica se não atingiu numero maximo de jogadores
                        System.out.println("Informe o apelido(nickname) do jogador a ser adicionado: ");
                        nome = tec.nextLine();
                        
                        do{
                            System.out.println("Informe o tipo do jogador(H - Humano ou M - Maquina): ");
                            tipo = tec.next().charAt(0);
        
                            if (tipo != 'M' && tipo != 'm' && tipo != 'H' && tipo != 'h'){
                                System.out.println("Tipo invalido! Tente novamente.");
                                tec.nextLine();
                            }
                        }while(tipo != 'M' && tipo != 'm' && tipo != 'H' && tipo != 'h');
        
                        league.incluirJogador(nome, tipo, n);
                    }
                    else{
                        System.out.println("Numero maximo de jogadores atingido!!! Nao foi possivel incluir");
                    }
                    
                    break;
                case 'b': // Se a escolha foi 'b', remove-se um jogador:

                    System.out.println("Informe o apelido(nickname) do jogador a ser excluido: ");
                    String name = tec.nextLine();
                    
                    boolean foiExcluido = league.removerJogador(name);
    
                    if(foiExcluido){
                        System.out.println("Remocao bem-sucedida!");
                    }
                    else{
                        System.out.println("Jogador nao encontrado!");
                    }
                    
                    break;
                case 'c': // Se a escolha foi 'c', executa-se uma nova rodada:
                    league.iniciarCampeonato();
                    break;
                case 'd': // Se a escolha foi 'd', mostra-se a cartela:
                    league.mostrarCartela();
    
                    break;
                case 'e': // Se a escolha foi 'e', grava-se a partida em arquivo:
                    System.out.println("..::Gravando em arquivo::..");
                    league.gravarEmArquivo();
                    System.out.println("Gravacao completa!");
    
                    break;
                case 'f': // Se a escolha foi 'f', lê-se os dados salvos em arquivo:
                    league.lerDoArquivo();
    
                    break;
                case 'g': // Se a escolha foi 'g', sai da aplicacao:
                    sair = 1;
                    System.out.println("Saindo do jogo...até a próxima! ");

                    break;
                case 'j': // Se a escolha foi 'j', mostra-se os jogadores que já foram registrados:
                    league.mostrarJogadores();

                    break;
                case 'r': // Se a escolha for 'r', mostra-se as regras do jogo:
                    System.out.println(" #--- Regras ---#\n" + 
                            "\n" + 
                            "(1) Sendo 13 o número de jogadas possíveis e o número máximo de linhas para cada coluna na cartela de marcação, uma rodada consiste de 13 jogadas para cada jogador.\r\n" + 
                            "\n" +
                            "(2) Cada jogador (humano ou máquina), em sua vez, tem apenas uma chance de arremessar os dados.\r\n" + 
                            "\n" +
                            "(3) O resultado obtido ao final do arremesso deve ser classificado, pelo próprio jogador, como uma das seguintes 13 possibilidades:\r\n" + 
                            "\n" +
                            "-Jogada de 1: um certo número de dados marcando o número 1; sendo que a jogada vale mais pontos conforme a quantidade de dados que marcarem o número 1. Por exemplo: 1-1-1-4-5 vale 3 pontos.\r\n" + 
                            "\n" +
                            "-Jogadas de 2, 3, 4, 5 e 6: correspondentes à jogada de 1 para os demais números. Por exemplo: 3-3-4-4-5 vale 6 pontos caso considerada uma jogada de 3; ou 8 pontos se for considerada uma jogada de 4; ou ainda 5 pontos se for uma jogada de 5.\r\n" + 
                            "\n" +
                            "-Trinca (T): três dados marcando o mesmo número. Vale a soma dos 5 dados. Exemplo: 4-4-4-5-6 vale 23 pontos.\r\n" + 
                            "\n" +
                            "-Quadra (Q): quatro dados marcando o mesmo n´umero. Vale a soma dos 5 dados. Exemplo: 1-5-5-5-5 vale 21 pontos.\r\n" + 
                            "\n" +
                            "-Full-hand (F) ou Full-house: uma trinca e um par (exemplo: 2-2-2-6-6). Vale 25 pontos para qualquer combinação.\r\n" + 
                            "\n" +
                            "-Sequência alta (S+): 2-3-4-5-6. Vale 30 pontos.\r\n" + 
                            "\n" +
                            "-Sequência baixa (S-): 1-2-3-4-5. Vale 40 pontos.\r\n" + 
                            "\n" +
                            "-General (G): cinco dados marcando o mesmo número (por exemplo: 4-4-4-4-4). Vale 50 pontos.\r\n" + 
                            "\n" +
                            "-Jogada aleatória (X) : qualquer combinação. Vale a soma dos 5 dados. Por exemplo: 1-4-4-5-6 vale 20 pontos.\r\n" + 
                            "\n" +
                            "(4) O resultado deverá ser mostrado na forma de cartela, na coluna do jogador e na linha correspondente à jogada.  Aquela linha (e portanto aquela jogada) não poderá mais ser utilizada pelo jogador na mesma rodada.\r\n" + 
                            "r\n" +
                            "(5) Se um determinado resultado não cumprir os requisitos para a jogada escolhida, o jogador zera a respectiva jogada. E ainda, caso determinado resultado não puder ser classificado como nenhuma das jogadas ainda restantes para aquele jogador, ele deverá escolher qual delas será descartada, marcando 0.\r\n" + 
                            "\n" +
                            "(6) Ao final de 13 rodadas, com a cartela toda preenchida, somam-se os valores de cada coluna, e o jogador que obtiver mais pontos será considerado o vencedor.\r\n" + 
                            " ");
                    break;
                case 'm': // Se a escolha foi 'm', mostra-se o menu novamente:
                    System.out.println(":..::..: Menu interativo :..::..: ");
                    System.out.println("a - Incluir jogador");
                    System.out.println("b - Remover jogador");
                    System.out.println("c - Executar rodada"); 
                    System.out.println("d - Mostrar cartela de resultados"); 
                    System.out.println("e - Gravar os resultados em arquivo"); 
                    System.out.println("f - Ler os dados em arquivo"); 
                    System.out.println("g - Sair do jogo");
                    System.out.println("j - Mostrar tabela de jogadores"); 
                    System.out.println("r - Mostrar regras do jogo");
                    break;
                default:
                    System.out.println("ERRO");
            }
        }

        // Fecha-se o teclado:
        tec.close();
    }
    
}
