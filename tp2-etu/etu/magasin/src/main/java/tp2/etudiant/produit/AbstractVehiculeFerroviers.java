package tp2.etudiant.produit;

public abstract class AbstractVehiculeFerroviers extends AbstractVehiculeTerrestre{

//    double capacité = 0; pour ajouter un attribut unique

    public AbstractVehiculeFerroviers(String nom, double poidsVehicule) {
        super(nom, poidsVehicule);
//        this.capacité = capacité;
    }


    /**
     *Vide pour l'instant, pourrait ajouter un attribut commun entre les trains de marchandises et de déplacements, pas plus compliqué que ça
     * @return
     */
    public String decrit(){
        return super.decrit();
    }

}
