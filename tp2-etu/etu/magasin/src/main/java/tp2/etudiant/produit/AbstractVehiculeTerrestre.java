package tp2.etudiant.produit;

public abstract class AbstractVehiculeTerrestre extends AbstractVehicule{
    public AbstractVehiculeTerrestre(String nom, double poidsVehicule) {
        super(nom, poidsVehicule);
    }

    public String decrit(){
        return super.decrit();
    }
}
