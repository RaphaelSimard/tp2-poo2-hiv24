package tp2.etudiant.produit;

import tp2.application.AbstractProduit;

public abstract class AbstractVehicule extends AbstractProduit {

    private double poidsVehicule;
    public double getPoidsVehicule() {
        return poidsVehicule;
    }

    public void setPoidsVehicule(double poidsVehicule) {
        this.poidsVehicule = poidsVehicule;
    }



    public AbstractVehicule(String nom, int volumeProduit, double poidsVehicule) {
        super(nom, volumeProduit);
        assert poidsVehicule > 0 : "Le poids doit être positif (kg)";
        assert poidsVehicule < 100000 : "Valeur un peu trop haute (kg)";
        this.poidsVehicule = poidsVehicule;
    }

    public String decrit(){
        return "Nom du véhicule : " + getNom() + ", son poids : " + poidsVehicule;
    }
}
