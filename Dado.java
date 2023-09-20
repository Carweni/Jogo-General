import java.util.Random;

public class Dado {
     private int faceSup;

        public Dado(){
            faceSup = 1;
        }

        public int getFaceSuperior(){ // Retorna a face superior do dado.
            return  faceSup;
        }

        public void roll(){          // Rola o dado. Para sua face superior sera atribuido um valor entre 1 e 6.
            Random random = new Random();
            this.faceSup = random.nextInt(6) + 1;
        }

        public String toString(){    
            return "A face superior do dado eh" + this.faceSup;
        }
    
}
