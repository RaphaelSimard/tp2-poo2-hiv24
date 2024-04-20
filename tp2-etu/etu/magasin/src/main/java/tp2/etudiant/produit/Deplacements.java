package tp2.etudiant.produit;

import tp2.etudiant.produit.AbstractVehiculeFerroviers;

public class Deplacements extends AbstractVehiculeFerroviers {

    private int capaciteNbrePersonnes;
    public Deplacements(String nom, int volumeProduit, double poidsVehicule, int capaciteNbrePersonnes) {
        super(nom, volumeProduit, poidsVehicule);
        this.capaciteNbrePersonnes = capaciteNbrePersonnes;
    }

    @Override
    public int getNumeroCategorie() {
        return 4;
    }

    @Override
    public String decrit() {
        return super.decrit() + " et la capacité du nombre de personne : " + capaciteNbrePersonnes;
    }
}
