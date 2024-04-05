package tp2.etudiant.produit;

public abstract class AbstractVehiculeRoutiers extends AbstractVehiculeTerrestre{

    public int getNbreRoues() {
        return nbreRoues;
    }

    public void setNbreRoues(int nbreRoues) {
        this.nbreRoues = nbreRoues;
    }

    private int nbreRoues;
    public AbstractVehiculeRoutiers(String nom,  double poidsVehicule, int nbreRoues) {
        super(nom, poidsVehicule);
        assert nbreRoues >= 1 : "Le véhicule doit aumoins avoir 2 roues";
        this.nbreRoues = nbreRoues;
    }

    public String decrit(){
        return super.decrit() + " son nombre de roues : " + getNbreRoues();
    }
}
