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

    public synchronized Boolean OqpVoie(Train train) throws InterruptedException {

        while(nbvoie==0) {

            train.setStateTrain(Constante.ETAT2TRAIN);
            System.out.println(train.getTrainName() + " ----  "+ train.getStateTrain());
            wait();
        }
        nbvoie--;
        train.setStateTrain(Constante.ETAT3TRAIN);
        listTrainEspQuai.add(train);

        System.out.println(train.getTrainName() + " ----  "+ train.getStateTrain());
        train.sleep(5000);
        oqp = true;
        return oqp;
    }

    public synchronized void LibereVoie(Train train) throws InterruptedException {

        nbvoie++;
        train.setStateTrain(Constante.ETAT4TRAIN);
        System.out.println(train.getTrainName() + " ----  "+ train.getStateTrain());
        System.out.println();
        listTrainEspQuai.remove(train);
        notify();
        oqp = false;
    }
    public synchronized boolean VoyaquiteQuai(Voyageur voyageur){
        Iterator<Train> iterator = listTrainEspQuai.iterator();
        Boolean monte = false;
        fin:
        while (iterator.hasNext()) {
            Train train = iterator.next();
            monte = train.voyagmonte(voyageur);
            if (monte) {
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
