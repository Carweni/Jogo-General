import java.util.Scanner;

public class UsaCampeonato {
    public static void main(String []args){
        Campeonato league = new Campeonato();
        Scanner tec = new Scanner(System.in);
        char c;

        System.out.println(":..::..: Menu interativo :..::..: ");
        System.out.println("a - Incluir jogador"); // Informar nome e tipo.
        System.out.println("b - Remover jogador"); // Remover pelo nome.
        System.out.println("c - Executar rodada"); 
        System.out.println("d - Mostrar cartela de resultados"); 
        System.out.println("e - Gravar os resultados em arquivo"); 
        System.out.println("f - Ler os dados em arquivo"); 
        System.out.println("g - Sair do jogo"); 

        // Escolhe-se uma opcao do menu. Se for invalida, informa-se o usuario e esse informa uma nova escolha.
        do{
            System.out.println("Escolha a sua opcao(m mostra o menu novamente): ");
            c = tec.next().charAt(0);

            if (c != 'a' && c != 'b' && c != 'c' && c != 'd' && c != 'e' && c != 'f' && c != 'g' && c != 'm'){
                System.out.println("Opcao invalida! Tente novamente.");
            }
        }while(c != 'a' && c != 'b' && c != 'c' && c != 'd' && c != 'e' && c != 'f' && c != 'g' && c != 'm');

        switch(c){
            case 'a':
                System.out.println("Informe o apelido(nickname) do jogador: ");
                String nome = tec.nextLine();
                char tipo;
                do{
                    System.out.println("Informe o tipo do jogador(H - Humano ou M - Maquina): ");
                    tipo = tec.next().charAt(0);

                    if (tipo != 'M' && tipo != 'm' && tipo != 'H' && tipo != 'h'){
                        System.out.println("Tipo invalido! Tente novamente.")
                    }
                }while(tipo != 'M' && tipo != 'm' && tipo != 'H' && tipo != 'h');

                league.incluirJogador(nome, tipo);

                break;
            case 'b':
                break;
            case 'c':
                break;
            case 'd':
                break;
            case 'e':
                break;
            case 'f':
                break;
            case 'g':
                break;
            case 'm':
                System.out.println(":..::..: Menu interativo :..::..: ");
                System.out.println("a - Incluir jogador"); // Informar nome e tipo.
                System.out.println("b - Remover jogador"); // Remover pelo nome.
                System.out.println("c - Executar rodada"); 
                System.out.println("d - Mostrar cartela de resultados"); 
                System.out.println("e - Gravar os resultados em arquivo"); 
                System.out.println("f - Ler os dados em arquivo"); 
                System.out.println("g - Sair do jogo"); 
                break;
        }
    }
    
}
