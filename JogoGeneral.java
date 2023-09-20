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

    public void toString(){ // Imprime os valores dos dados.
        int i;

        System.out.println("Valores dos dados:");
        for(i = 0; i < 5; i++){
            System.out.print(dice[i] + " ");
        }
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
        int i;
        int[] armazenaValores = new int[5];

        for(i = 0; i < 5; i++){
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
            
        }
        else if(n == 8){
            
        }
        else if(n == 9){
            
        }
        else if(n == 10){
            
        }
        else if(n == 11){
            
        }
        else if(n == 12){
            
        }
        else if(n == 13){
            
        }
    }
    
}
