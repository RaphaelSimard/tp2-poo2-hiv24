package tp2.etudiant.produit;

public abstract class AbstractVehiculeTerrestre extends AbstractVehicule{
    public AbstractVehiculeTerrestre(String nom, int volumeProduit, double poidsVehicule) {
        super(nom, volumeProduit, poidsVehicule);
    }

    public String decrit() {
        return super.decrit();
    }
}
