package tp2.etudiant.produit;

public class Quotidien extends AbstractVehiculeRoutiers {

    private int nbrePlaces;
    private boolean est4RouesMotrices;

    public boolean isEst4RouesMotrices() {
        return est4RouesMotrices;
    }

    public void setEst4RouesMotrices(boolean est4RouesMotrices) {
        this.est4RouesMotrices = est4RouesMotrices;
    }

    public int getNbrePlaces() {
        return nbrePlaces;
    }

    public void setNbrePlaces(int nbrePlaces) {
        this.nbrePlaces = nbrePlaces;
    }




    /**
     * Malgré que ce soit basique, j'ai penser que l'on mette nbrePlaces comme étant un attribut propre à sa catégorie,
     * vue que les catégories "transports" et "sport", le nombre de place est pas important, ça reste généralement 2.
     */

    public Quotidien(String nom, double poidsVehicule, int nbreRoues, boolean est4RouesMotrices, int nbrePlaces) {
        super(nom, poidsVehicule, nbreRoues);
        this.est4RouesMotrices = est4RouesMotrices;
        assert nbrePlaces > 0 : "Un véhicule doit aumoins avoir 1 place non?";
        this.nbrePlaces = nbrePlaces;
    }

    @Override
    public int getNumeroCategorie() {
        return 0;
    }

    @Override
    public String decrit() {
        return super.decrit() + " est 4 roues motrices : " + est4RouesMotrices + " et contient : " + nbrePlaces + " place(s)";
    }
}
