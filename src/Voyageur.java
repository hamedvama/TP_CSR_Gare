/**
 * Created by 18004032 on 27/11/17.
 */
public class Voyageur extends Thread{

    private EspaceVente unespacevente;
    private Train train;

    private int nbrebilletvoulu;

    public EspaceVente getUnespacevente() {
        return unespacevente;
    }

    public void setUnespacevente(EspaceVente unespacevente) {
        this.unespacevente = unespacevente;
    }

    public int getNbrebilletvoulu() {
        return nbrebilletvoulu;
    }

    public void setNbrebilletvoulu(int nbrebilletvoulu) {
        this.nbrebilletvoulu = nbrebilletvoulu;
    }

    public Voyageur (int nbrticket){
        this.nbrebilletvoulu = nbrticket;
    }

    public void run(){

        unespacevente = new EspaceVente();
        unespacevente.achatbillet(nbrebilletvoulu);
        train.voyagmonte(this);


    }




}
