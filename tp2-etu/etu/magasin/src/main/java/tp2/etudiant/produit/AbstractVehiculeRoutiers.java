package tp2.etudiant.produit;

public abstract class AbstractVehiculeRoutiers extends AbstractVehiculeTerrestre{

    public int getNbreRoues() {
        return nbreRoues;
    }

    public void setNbreRoues(int nbreRoues) {
        this.nbreRoues = nbreRoues;
    }

    private int nbreRoues;
    public AbstractVehiculeRoutiers(String nom, int nbreRoues) {
        super(nom);
        this.nbreRoues = nbreRoues;
    }
}
