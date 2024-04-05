package tp2.etudiant.produit;

import tp2.etudiant.produit.AbstractVehiculeRoutiers;

public class Sports extends AbstractVehiculeRoutiers {

    public int getNbreChevaux() {
        return nbreChevaux;
    }

    public void setNbreChevaux(int nbreChevaux) {
        this.nbreChevaux = nbreChevaux;
    }

    private int nbreChevaux;
    public Sports(String nom, int nbreRoues, int nbreChevaux) {
        super(nom, nbreRoues);
        this.nbreChevaux = nbreChevaux;
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
