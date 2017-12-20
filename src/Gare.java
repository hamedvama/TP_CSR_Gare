import java.util.ArrayList;
import java.util.List;

public class Gare {


    static ArrayList<Train> lestrain = new ArrayList<>();
    static ArrayList<Voyageur> lesvoyageurs = new ArrayList<>();

    static EspaceQuai espaceQuai = new EspaceQuai();
    static EspaceVente espaceVente = new EspaceVente();

    public static void main(String[] args) {

        Gare gare = new Gare();
        gare.lancer();

    }

    public void lancer() {

        Train train1 = new Train("RER A");
        Train train2 = new Train("RER B");
        Train train3 = new Train("RER C");

        System.out.println();

        lestrain.add(train1);
        lestrain.add(train2);
        lestrain.add(train3);

        Voyageur voyageur1 = new Voyageur("Alpha");
        Voyageur voyageur2 = new Voyageur("Beta");
        Voyageur voyageur3 = new Voyageur("Gama");
        Voyageur voyageur4 = new Voyageur("Lamda");
        Voyageur voyageur5 = new Voyageur("Silva");
        Voyageur voyageur6 = new Voyageur("Diakite");
        Voyageur voyageur7 = new Voyageur("Khabaz");

        System.out.println();

        lesvoyageurs.add(voyageur1);
        lesvoyageurs.add(voyageur2);
        lesvoyageurs.add(voyageur3);
        lesvoyageurs.add(voyageur4);
        lesvoyageurs.add(voyageur5);
        lesvoyageurs.add(voyageur6);
        lesvoyageurs.add(voyageur7);


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
