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
    public Sports(String nom, int volumeProduit, double poidsVehicule, int nbreRoues, int nbreChevaux) {
        super(nom,volumeProduit, poidsVehicule, nbreRoues);
        assert nbreChevaux > 0 : "Moins de 0 chevaux???";
        this.nbreChevaux = nbreChevaux;
    }

    @Override
    public int getNumeroCategorie() {
        return 1;
    }

    @Override
    public String decrit() {
        return super.decrit() + " et a " + nbreChevaux + " de chevaux";
    }
}
