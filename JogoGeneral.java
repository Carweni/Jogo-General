import java.io.Serializable;

public class JogoGeneral implements Serializable {
    private Dado[] dice = new Dado[5];
    private int[] jogadas = new int[13];

    public JogoGeneral(){
        int i;

        for(i = 0; i < 5; i++){
            this.dice[i] = new Dado();  // Inicializa os dados.
        }
    }

    public JogoGeneral(int jogada){
        for(int i = 0; i < 5; i++){
            this.dice[i] = new Dado();  // Inicializa os dados.
        }
        for(int j = 0; j < 13; j++){
            this.jogadas[j] = jogada;   // Se o indice marca -1, significa que a jogada ainda nao foi realizada.
        }
    }

    public void inicializarJogadas(){
        for(int j = 0; j < 13; j++){
            this.jogadas[j] = -1;   // Se o indice marca -1, significa que a jogada ainda nao foi realizada.
        }
    }

    public void setJogada(int i, int pontuacao){
        this.jogadas[i - 1] = pontuacao;    // Marca a pontuacao da jogada em sua posicao no vetor.
    }

    public void rolarDados(){ // Aos 5 dados serao atribuidos valores entre 1 e 6, referentes as suas faces superiores.
        int i;
        
        for(i = 0; i < this.dice.length; i++){
            this.dice[i].roll();
        }
    }

    public String toString(){ // Imprime os valores dos dados.
        int i;
        String str = new String();

        System.out.println("Valores obtidos:");

        for(i = 0; i < 5; i++){
            str = str + this.dice[i].toString();

            if (i < 4){
                str = str + "-";
            }
            else{
                str = str + "\n";
            }
        }

        return str;
    }

    // O seguinte metodo retorna false para jogadas ja executadas e true para as disponiveis:
    public boolean validarJogada(int n){
        if(jogadas[n - 1] == -1){
            return true;
        }
        else{
            return false;
        }
    }

    // O seguinte metodo verifica qual jogada foi escolhida e retorna a pontuacao que ela rende:
    public int pontuarJogada(int n){
        int i, j;
        int[] armazenaValores = new int[6];

        for(i = 0; i < 5; i++){
            armazenaValores[dice[i].getFaceSuperior() - 1] += 1;
        }

        if(n == 1){
            return armazenaValores[0] * 1;
        }
        else if(n == 2){
            return armazenaValores[1] * 2;
        }
        else if(n == 3){
            return armazenaValores[2] * 3;
        }
        else if(n == 4){
            return armazenaValores[3] * 4;
        }
        else if(n == 5){
            return armazenaValores[4] * 5;
        }
        else if(n == 6){
            return armazenaValores[5] * 6;
        }
        else if(n == 7){
            int soma = 0;

            for(i = 0; i < 6; i++){
                if(armazenaValores[i] >= 3){
                    for(j = 0; j < 5; j++){
                        soma += dice[j].getFaceSuperior();
                    }
                    break;
                }
            }

            return soma;
        }
        else if(n == 8){
            int sum = 0;

            for(i = 0; i < 6; i++){
                if(armazenaValores[i] >= 4){
                    for(j = 0; j < 5; j++){
                        sum += dice[j].getFaceSuperior();
                    }
                    break;
                }
            }

            return sum;
            
        }
        else if(n == 9){
            for(i = 0; i < 6; i++){
                if(armazenaValores[i] == 3){
                    for(j = 0; j < 6; j++){
                        if(armazenaValores[j] == 2){
                            return 25;
                        }
                    }
                    break;
                }
            }

            return 0;
        }
        else if(n == 10){
            int cont = 0;

            for(i = 1; i < 6; i++){
                if(armazenaValores[i] == 1){
                    cont += 1;
                }
                else{
                    return 0;
                }
            }
            
            if(cont == 5){
                return 30;
            }
        }
        else if(n == 11){
            int c = 0;

            for(i = 0; i < 5; i++){
                if(armazenaValores[i] == 1){
                    c += 1;
                }
                else{
                    return 0;
                }
            }
            
            if(c == 5){
                return 40;
            }
        }
        else if(n == 12){
            for(i = 0; i < 6; i++){
                if(armazenaValores[i] == 5){
                    return 50;
                }
            }

            return 0;
        }
        else if(n == 13){
            int s = 0;

            for(j = 0; j < 5; j++){
                s += dice[j].getFaceSuperior();
            }
            return s;
        }

        return 0;
    }
   
    // O seguinte metodo calcula a pontuacao total de um jogador:
    public int calculaTotal(){
        int total = 0;

        for(int i = 0; i < 13; i++){
            total += this.jogadas[i];
        }

        return total;
    }

    // O seguinte metodo grava em string a pontuacao de uma jogada especifica:
    public String montarTabela(int i){
        String s = new String();

        if(jogadas[i - 1] == -1){
            s = s + "-\t|\t";
        }
        else{
            s = s + jogadas[i - 1] + "\t|\t";
        }

        return s;
    }

    // O seguinte metodo, como o anterior, grava em string a pontuacao de uma jogada, mas com uma formatacao diferente:
    public String montarTabela2(int i){
        String s = new String();

        if(jogadas[i - 1] == -1){
            s = s + "-\t";
        }
        else{
            s = s + jogadas[i - 1] + "\t";
        }

        return s;
    }
}