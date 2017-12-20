import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 18004032 on 27/11/17.
 */
public class Voyageur extends Thread {

    private EspaceVente espaceVente;
    private EspaceQuai espaceQuai;
    private List<Train> listtrain = new ArrayList<>();
    private boolean valider = false;
    private String StateVoy;
    private String nom;

    public Voyageur(String nom) {
        this.nom = nom;
        this.StateVoy = Constante.ETAT1VOYAGEUR;
        System.out.println(this.getNom() + "  ********  " + this.getStateV());
    }

    public void run() {
       // while (true) {
            Boolean payer;
            payer = espaceVente.achatbillet(this);
            if (payer == true) {
                boolean monte = false;
                fin1:
                while (!monte) {
                    monte = espaceQuai.VoyaquiteQuai(this);
                }
            }
       // }
    }

    public EspaceVente getEspaceVente() {
        return espaceVente;
    }

    public void setEspaceVente(EspaceVente espaceVente) {
        this.espaceVente = espaceVente;
    }

    public EspaceQuai getEspaceQuai() {
        return espaceQuai;
    }

    public void setEspaceQuai(EspaceQuai espaceQuai) {
        this.espaceQuai = espaceQuai;
    }

    public List<Train> getListtrain() {
        return listtrain;
    }

    public void setListtrain(List<Train> listtrain) {
        this.listtrain = listtrain;
    }

    public boolean isValider() {
        return valider;
    }

    public void setValider(boolean valider) {
        this.valider = valider;
    }

    public String getStateV() {
        return StateVoy;
    }

    public void setStateV(String state) {
        StateVoy = state;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
