import java.util.ArrayList;

/**
 * Created by 18004032 on 27/11/17.
 */
public class Train extends Thread{

    private EspaceQuai espaceQuai;
    private int capacite = 100;
    private int vitesse;
    private ArrayList<Voyageur> lesvoyageur;

    public Train (){
       vitesse = (int) (50 + (Math.random()*(300-50)));
    }

    public void run(){
        try {
            espaceQuai.OqpVoie();
            System.out.println(" Je suis sur le Quai");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            sleep(1000);
            System.out.println("Je recupere les passagers");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        espaceQuai.LibereVoie();
    }

    public void voyagmonte(Voyageur voyageur){

        if(voyageur.getNbrebilletvoulu()>this.capacite){
            System.out.println("Train complet");
        }else {
            capacite = capacite-voyageur.getNbrebilletvoulu();
            lesvoyageur.add(voyageur);
        }
    }



}
