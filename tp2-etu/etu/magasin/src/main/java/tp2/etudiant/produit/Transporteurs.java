package tp2.etudiant.produit;

import tp2.etudiant.produit.AbstractVehiculeRoutiers;

public class Transporteurs extends AbstractVehiculeRoutiers {
    private int poidsRemorque;


    public int getPoidsRemorque() {
        return poidsRemorque;
    }

    public void setPoidsRemorque(int poidsRemorque) {
        this.poidsRemorque = poidsRemorque;
    }


    public Transporteurs(String nom, int volumeProduit, double poidsVehicule, int nbreRoues, int poidsRemorque) {
        super(nom, volumeProduit, poidsVehicule, nbreRoues);
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
