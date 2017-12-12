import java.util.*;

/**
 * Created by 18004032 on 27/11/17.
 */
public class Train extends Thread {

    private EspaceQuai espaceQuai;
    private int capacite = 3;
    private String TrainName;
    private int vitesse;
    private List<Voyageur> listVoyDuTrain = new ArrayList<>();
    private String StateTrain;


    public Train(String nom) {
        this.TrainName = nom;
        this.capacite = capacite;
        this.StateTrain = Constante.ETAT1TRAIN;
        this.vitesse = (int) (50 + (Math.random() * (300 - 50)));
    }

    public void run() {
        //while (true) {
            try {
                espaceQuai.OqpVoie(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("J'ai au total : " + listVoyDuTrain.size());

            try {
                espaceQuai.LibereVoie(this);
                sleep(500);
                this.capacite = 5;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
      // }
    }

    public synchronized boolean voyagmonte(Voyageur voyageur) {
        boolean monte = false;
        if (this.capacite > 0) {
            this.capacite--;
            voyageur.setStateV(Constante.ETAT3VOYAGEUR);
            listVoyDuTrain.add(voyageur);
            System.out.println(">>>> le voyageur : " + voyageur.getNom() + " est dans le train"
                    + this.getTrainName() + " Son etat actuel est : " + voyageur.getStateV());
            espaceQuai.getListVoyAQaui().remove(voyageur);
            monte = true;
        } else {
            System.out.println("Train " + this.getTrainName() + " est complet M. " + voyageur.getNom() );
        }
        return monte;
    }

    public EspaceQuai getEspaceQuai() {
        return espaceQuai;
    }

    public void setEspaceQuai(EspaceQuai espaceQuai) {
        this.espaceQuai = espaceQuai;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getTrainName() {
        return TrainName;
    }

    public void setTrainName(String trainName) {
        TrainName = trainName;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public List<Voyageur> getListVoyDuTrain() {
        return listVoyDuTrain;
    }

    public void setListVoyDuTrain(List<Voyageur> listVoyDuTrain) {
        this.listVoyDuTrain = listVoyDuTrain;
    }

    public String getStateTrain() {
        return StateTrain;
    }

    public void setStateTrain(String stateTrain) {
        StateTrain = stateTrain;
    }
}
