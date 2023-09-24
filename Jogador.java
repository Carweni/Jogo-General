public class Jogador {
    private String nome = new String();
    private char tipo;
    private JogoGeneral jogo = new JogoGeneral();

    public Jogador(String nome, char tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public char getTipo() {
        return tipo;
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
            s= s + " - Tipo: Humano";
        }
        else if(this.tipo == 'M'){
            s= s + " - Tipo: Maquina";
        }

        s = s + "\n" + jogo.toString();
        return s;
    }
}
