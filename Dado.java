import java.util.Random;

public class Dado {
     private int faceSup;

        public Die(){
            faceSup = 1;
        }

        public int getFaceSuperior(){ // Retorna a face superior do dado.
            return  faceSup;
        }

        public void roll(){          // Rola o dado.
            Random random = new Random();
            this.faceSup = random.nextInt(6) + 1;
        }
    
}
