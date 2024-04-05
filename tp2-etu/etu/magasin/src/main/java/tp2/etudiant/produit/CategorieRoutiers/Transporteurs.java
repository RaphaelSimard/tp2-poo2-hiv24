package tp2.etudiant.produit.CategorieRoutiers;

import tp2.etudiant.produit.AbstractVehiculeRoutiers;

public class Transporteurs extends AbstractVehiculeRoutiers {

    public int getPoidsRemorque() {
        return poidsRemorque;
    }

    public void setPoidsRemorque(int poidsRemorque) {
        this.poidsRemorque = poidsRemorque;
    }

    private int poidsRemorque;
    public Transporteurs(String nom, int poidsRemorque) {
        super(nom);
        this.poidsRemorque = poidsRemorque;
    }

    @Override
    public int getNumeroCategorie() {
        return 0;
    }

    @Override
    public String decrit() {
        return null;
    }
}
