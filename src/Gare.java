import java.util.ArrayList;
import java.util.List;

public class Gare {

    private Voyageur voyageur;
    static ArrayList<Train> lestrain = new ArrayList<>();
    static ArrayList<Voyageur> lesvoyageurs = new ArrayList<>();

    static EspaceQuai espaceQuai = new EspaceQuai();
    static EspaceVente espaceVente = new EspaceVente();

    public static void main(String[] args) {

        Gare gare = new Gare();
        gare.run();

    }

    public void run(){

        Train train1 = new Train("RER A");
        Train train2 = new Train("RER B");

        lestrain.add(train1);
        lestrain.add(train2);

        Voyageur voyageur1 = new Voyageur("Alpha");
        Voyageur voyageur2 = new Voyageur("Beta");
        Voyageur voyageur3 = new Voyageur("Gama");
        Voyageur voyageur4 = new Voyageur("Lamda");

        lesvoyageurs.add(voyageur1);
        lesvoyageurs.add(voyageur2);
        lesvoyageurs.add(voyageur3);
        lesvoyageurs.add(voyageur4);

        espaceQuai.setEspaceVente(espaceVente);
        espaceVente.setEspaceQuai(espaceQuai);

        for (Train train : lestrain) {
            train.setEspaceQuai(espaceQuai);
            train.start();
        }

        for (Voyageur voyageur : lesvoyageurs) {
            voyageur.setEspaceVente(espaceVente);
            voyageur.setEspaceQuai(espaceQuai);
            voyageur.start();

        }
    }
}
