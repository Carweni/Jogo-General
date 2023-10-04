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

        while(sair == 0){
            // Escolhe-se uma opcao do menu. Se for invalida, informa-se o usuario e esse informa uma nova escolha.
            do{
                System.out.println("Escolha a sua opcao (m mostra o menu novamente): ");
                op = tec.next().charAt(0);
    
                if (op != 'a' && op != 'b' && op != 'c' && op != 'd' && op != 'e' && op != 'f' && op != 'g' && op != 'm'){
                    System.out.println("Opcao invalida! Tente novamente.");
                }
            }while(op != 'a' && op != 'b' && op != 'c' && op != 'd' && op != 'e' && op != 'f' && op != 'g' && op != 'm');
    
            tec.nextLine(); // Limpa o buffer do teclado.
    
            switch(op){
                case 'a': // Se a escolha foi 'a', incluie-se um jogador:
                    char tipo;
                    int n = league.jogadorLivre();

                    if(n < league.getLength()){
                        do{
                            System.out.println("Informe o apelido(nickname) do jogador a ser adicionado: ");
                            String nome = tec.nextLine();
                            System.out.println("Informe o tipo do jogador(H - Humano ou M - Maquina): ");
                            tipo = tec.next().charAt(0);
        
                            if (tipo != 'M' && tipo != 'm' && tipo != 'H' && tipo != 'h'){
                                System.out.println("Tipo invalido! Tente novamente.");
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
                    break;
                case 'm':
                    System.out.println(":..::..: Menu interativo :..::..: ");
                    System.out.println("a - Incluir jogador");
                    System.out.println("b - Remover jogador");
                    System.out.println("c - Executar rodada"); 
                    System.out.println("d - Mostrar cartela de resultados"); 
                    System.out.println("e - Gravar os resultados em arquivo"); 
                    System.out.println("f - Ler os dados em arquivo"); 
                    System.out.println("g - Sair do jogo"); 
                    break;
            }
        }

        // Fecha-se o teclado:
        tec.close();
    }
    
}
