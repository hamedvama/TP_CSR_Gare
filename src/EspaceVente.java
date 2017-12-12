import java.util.ArrayList;

/**
 * Created by 18004032 on 27/11/17.
 */
public class EspaceVente {
    private int nbrebillet = 100;
    private ArrayList<Voyageur> listVoyEspacVent = new ArrayList<>();
    private EspaceQuai espaceQuai;


    public synchronized boolean achatbillet(Voyageur voyageur) {
        boolean achat = false;
        int manque = 0;
        if (this.nbrebillet > 0) {
            nbrebillet--;
            System.out.println("Vous pouvez chercher à embarquer..." + voyageur.getNom());
            achat = true;
            listVoyEspacVent.add(voyageur);
            voyageur.setStateV(Constante.ETAT2VOYAGEUR);
            System.out.println("Etat du voyageur : " + voyageur.getNom() + " est : " + voyageur.getStateV());
            espaceQuai.getListVoyAQaui().add(voyageur);
        } else {
            System.out.println(" ++++ il n'y a plus de billets, veiller patientez... ");
        }
        return achat;
    }

    public int getNbrebillet() {
        return nbrebillet;
    }

    public void setNbrebillet(int nbrebillet) {
        this.nbrebillet = nbrebillet;
    }

    public ArrayList<Voyageur> getListVoyEspacVent() {
        return listVoyEspacVent;
    }

    public void setListVoyEspacVent(ArrayList<Voyageur> listVoyEspacVent) {
        this.listVoyEspacVent = listVoyEspacVent;
    }

    public EspaceQuai getEspaceQuai() {
        return espaceQuai;
    }

    public void setEspaceQuai(EspaceQuai espaceQuai) {
        this.espaceQuai = espaceQuai;
    }
}