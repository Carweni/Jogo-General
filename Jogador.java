import java.io.Serializable;

public class Jogador implements Serializable {
    private String nome = new String();
    private char tipo;
    private JogoGeneral jogo = new JogoGeneral();

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

    public String toString(){
        String s = new String();
        s = "Nome: " + this.nome;

        if(this.tipo == 'H'){
            s = s + " - Tipo: Humano";
        }
        else if(this.tipo == 'M'){
            s = s + " - Tipo: Maquina";
        }

        s = s + "\n" + jogo.toString();
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

    public int pontuar(int escolha){
        return jogo.pontuarJogada(escolha);
    }

    public void gravarPontos(int i, int pontuacao){
        jogo.setJogada(i, pontuacao);
    }

    public int total(){
        return jogo.calculaTotal();
    }

    public String cartela(int i){
        String s = new String();
        s = jogo.montarTabela(i);
        return s;
    }
}