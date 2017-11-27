/**
 * Created by 18004032 on 27/11/17.
 */
public class EspaceQuai {

    private int nbvoie = 4;



    public synchronized void OqpVoie() throws InterruptedException {

        while(nbvoie==0) {
            wait();
        }
        nbvoie--;
    }


    public synchronized void LibereVoie(){
        nbvoie++;
        notify();
    }

}
