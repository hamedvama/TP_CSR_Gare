/**
 * Created by 18004032 on 27/11/17.
 */
public class EspaceVente {
    private int nbrebillet = 10;

    public int getNbrebillet() {
        return nbrebillet;
    }

    public void setNbrebillet(int nbrebillet) {
        this.nbrebillet = nbrebillet;
    }

    public void achatbillet(int billet) {

        if (billet<this.nbrebillet){
            nbrebillet--;
        }else{
            System.out.println("il n'y a plus de billets, veiller patientez... ");
        }

    }
}