package tp2.etudiant.produit;

import tp2.etudiant.produit.AbstractVehiculeRoutiers;

public class Transporteurs extends AbstractVehiculeRoutiers {

    public int getPoidsRemorque() {
        return poidsRemorque;
    }

    public void setPoidsRemorque(int poidsRemorque) {
        this.poidsRemorque = poidsRemorque;
    }

    private int poidsRemorque;
    public Transporteurs(String nom, double poidsVehicule, int nbreRoues, int poidsRemorque) {
        super(nom, poidsVehicule, nbreRoues);
        assert poidsRemorque > 0 : "Valeur sous 0 impossible";
        this.poidsRemorque = poidsRemorque;
    }

    @Override
    public int getNumeroCategorie() {
        return 2;
    }

    @Override
    public String decrit() {
        return super.decrit() + "et le poids de la remorque : " + poidsRemorque;
    }
}
