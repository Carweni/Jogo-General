import java.util.Random;
import java.io.Serializable;

public class Dado implements Serializable{
    private int faceSup;

    public Dado(){
        faceSup = 1;
    }

    public int getFaceSuperior(){ // Retorna a face superior do dado.
        return  faceSup;
    }

    public void roll(){   // Rola o dado. Para sua face superior sera atribuido um valor entre 1 e 6.
        Random random = new Random();
        this.faceSup = random.nextInt(6) + 1;
    }

    public String toStringDado(){   // Imprime a face superior do dado.  
        return Integer.toString(faceSup);
    }
    
}