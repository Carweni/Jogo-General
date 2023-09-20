public class JogoGeneral {
    private[] Dado dice = new Dado[5];
    private[] int jogadas = new int[13];

    public JogoGeneral(){
        int i;

        for(i = 0; i < 5; i++){
            this.dice[i] = new Dado();  // Inicializa os dados.
        }
        for(j = 0; j < 13; j++){
            this.jogadas[i] = -1;   // Se o indice marca -1, significa que a jogada ainda nao foi realizada.
        }
    }

    public void jogarDados(){
        int i;
        
        for(i = 0; i < 5; i++){
            this.dice[i].roll();
        }
    }
    
}
