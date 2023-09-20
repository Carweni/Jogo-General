public class JogoGeneral {
    private[] Dado dice = new Dado[5];
    private[] int jogadas = new int[13];

    public JogoGeneral(){
        int i;
        int j;

        for(i = 0; i < 5; i++){
            this.dice[i] = new Dado();  // Inicializa os dados.
        }
        for(j = 0; j < 13; j++){
            this.jogadas[i] = -1;   // Se o indice marca -1, significa que a jogada ainda nao foi realizada.
        }
    }

    public void rolarDados(){ // Aos 5 dados serao atribuidos valores entre 1 e 6, referentes às suas faces superiores 
        int i;
        
        for(i = 0; i < 5; i++){
            this.dice[i].roll();
        }
    }

    public String toString(){ // Imprime os valores dos dados.
        int i;
        String str = new String();

        System.out.println("Valores dos dados:");
        for(i = 0; i < 5; i++){
            str.append(dice[i]);
            if (i < 4){
                str.append("-");
            }
        }

        return str;
    }

    public boolean validarJogada(int n){
        if(jogadas[i - 1] == -1){
            return true;
        }
        else{
            return false;
        }
    }

    public int pontuarJogada(int n){
        int i, j;
        int[] armazenaValores = new int[5];

        for(i = 0; i < 6; i++){
            armazenaValores[dice[i].getFaceSuperior() - 1] += 1;
        }

        if(n == 1){
            return armazenaValores[0] * 1;
        }
        else if(n == 2){
            return armazenaValores[1] * 1;
        }
        else if(n == 3){
            return armazenaValores[2] * 1;
        }
        else if(n == 4){
            return armazenaValores[3] * 1;
        }
        else if(n == 5){
            return armazenaValores[4] * 1;
        }
        else if(n == 6){
            return armazenaValores[5] * 1;
        }
        else if(n == 7){
            int soma = 0;

            for(i = 0; i < 6; i++){
                if(armazenaValores[i] == 3){
                    for(j = 0; j < 5; j++){
                        soma += dice[i].getFaceSuperior();
                    }
                    break;
                }
            }

            return soma;
        }
        else if(n == 8){
            int sum = 0;

            for(i = 0; i < 6; i++){
                if(armazenaValores[i] == 3){
                    for(j = 0; j < 5; j++){
                        sum += dice[i].getFaceSuperior();
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
                        if(armazenaValores[i] == 2){
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
            int c = 0;

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
                s += dice[i].getFaceSuperior();
            }
            return s;
        }
    }
    
}
