package tp2.etudiant.produit;

public abstract class AbstractVehiculeRoutiers extends AbstractVehiculeTerrestre{

//    int nbrChevaux = 0; pour ajouter un attribut unique

    public int getNbreRoues() {
        return nbreRoues;
    }

    public void setNbreRoues(int nbreRoues) {
        this.nbreRoues = nbreRoues;
    }

    private int nbreRoues;
    public AbstractVehiculeRoutiers(String nom, int volumeProduit,  double poidsVehicule, int nbreRoues) {
        super(nom,volumeProduit, poidsVehicule);
        assert nbreRoues >= 1 : "Le véhicule doit aumoins avoir 2 roues";
        this.nbreRoues = nbreRoues;
//        this.nbrChevaux = nbrChevaux;
    }

    public String decrit(){
        return super.decrit() + " son nombre de roues : " + getNbreRoues();
    }
}
