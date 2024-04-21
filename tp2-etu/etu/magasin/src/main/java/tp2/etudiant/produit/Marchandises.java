package tp2.etudiant.produit;

import tp2.etudiant.produit.AbstractVehiculeFerroviers;

public class Marchandises extends AbstractVehiculeFerroviers {

    public int getPoidsMarchandises() {
        return poidsMarchandises;
    }

    public void setPoidsMarchandises(int poidsMarchandises) {
        this.poidsMarchandises = poidsMarchandises;
    }

    private int poidsMarchandises;
    public Marchandises(String nom, int volumeProduit, double poidsVehicule, int poidsMarchandises) {
        super(nom,volumeProduit, poidsVehicule);
        this.poidsMarchandises = poidsMarchandises;
    }

    @Override
    public int getNumeroCategorie() {
        return 3;
    }

    @Override
    public String decrit() {
        return super.decrit() + "et la capacité de poids de marchandise : " + poidsMarchandises;
    }
}
