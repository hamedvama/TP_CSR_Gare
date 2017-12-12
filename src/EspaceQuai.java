import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Semaphore;

/**
 * Created by 18004032 on 27/11/17.
 */
public class EspaceQuai {

    private int nbvoie = 1 ;
    boolean oqp = false;
    private EspaceVente espaceVente;
    private ArrayList <Train> listTrainEspQuai = new ArrayList<>();
    private ArrayList<Voyageur> listVoyAQaui = new ArrayList<>();
    Semaphore listTrain = new Semaphore(1);

    public synchronized Boolean OqpVoie(Train train) throws InterruptedException {
        System.out.println(listTrainEspQuai.size());
        while(nbvoie==0) {
            System.out.println(" Pas de voie libre");
            train.setStateTrain(Constante.ETAT2TRAIN);
            System.out.println(train.getTrainName() + " ----  "+ train.getStateTrain());
            wait();
        }
        nbvoie--;
        train.setStateTrain(Constante.ETAT3TRAIN);
        listTrain.acquire();
        listTrainEspQuai.add(train);
        System.out.println(listTrainEspQuai.size());
        System.out.println(train.getTrainName() + " ----  "+ train.getStateTrain());
        train.sleep(500);
        listTrain.release();
        oqp = true;
        return oqp;
    }

    public synchronized void LibereVoie(Train train) throws InterruptedException {

        nbvoie++;
        train.setStateTrain(Constante.ETAT4TRAIN);
        System.out.println(train.getTrainName() + " ----  "+ train.getStateTrain());
        listTrain.acquire();
        listTrainEspQuai.remove(train);
        listTrain.release();
        notify();
        oqp = false;
    }
    public synchronized boolean VoyaquiteQuai(Voyageur voyageur){
        Iterator<Train> iterator = listTrainEspQuai.iterator();
        Boolean monte = false;
        fin:
        while (iterator.hasNext()) {
            Train train = iterator.next();
            System.out.println( voyageur.getNom() + " essai de monter dans letrain : " + train.getTrainName());
            monte = train.voyagmonte(voyageur);
            if (monte) {
                System.out.println("Voyageur monté" + voyageur.getNom());
                break fin;
            }
        }
        return monte;
    }

    public ArrayList<Train> getListTrainEspQuai() {
        return listTrainEspQuai;
    }

    public void setListTrainEspQuai(ArrayList<Train> listTrainEspQuai) {
        this.listTrainEspQuai = listTrainEspQuai;
    }

    public ArrayList<Voyageur> getListVoyAQaui() {
        return listVoyAQaui;
    }

    public void setListVoyAQaui(ArrayList<Voyageur> listVoyAQaui) {
        this.listVoyAQaui = listVoyAQaui;
    }

    public EspaceVente getEspaceVente() {
        return espaceVente;
    }

    public void setEspaceVente(EspaceVente espaceVente) {
        this.espaceVente = espaceVente;
    }
}
