public class Jogador {
    private String nome = new String();
    private String tipo = new String();
    private JogoGeneral jogo = new JogoGeneral();

    public Jogador(String nome, String tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    
}
