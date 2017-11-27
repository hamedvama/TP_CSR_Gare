import java.util.ArrayList;

public class Gare {

    private Voyageur voyageur;


    public static void main(String[] args) {

        ArrayList<Train> lestrain = new ArrayList<>();
        Train train1 = new Train();
        Train train2 = new Train();
        Train train3 = new Train();
        Train train4 = new Train();
        Train train5 = new Train();
        lestrain.add(train1);
        lestrain.add(train2);
        lestrain.add(train3);
        lestrain.add(train4);
        lestrain.add(train5);

        for (Train train : lestrain){
            train.start();
        }


        ArrayList<Voyageur> lesvoyageurs= new ArrayList<>();

        Voyageur voyageur1 = new Voyageur(2);
        Voyageur voyageur2 = new Voyageur(2);
        Voyageur voyageur3 = new Voyageur(2);
        Voyageur voyageur4 = new Voyageur(6);
        Voyageur voyageur5 = new Voyageur(2);
        lesvoyageurs.add(voyageur1);
        lesvoyageurs.add(voyageur2);
        lesvoyageurs.add(voyageur3);
        lesvoyageurs.add(voyageur4);
        lesvoyageurs.add(voyageur5);

        for (Voyageur voyageur : lesvoyageurs){
            voyageur.start();
        }
            }
}
