package tp2.etudiant.section;

import tp2.application.AbstractProduit;
import tp2.etudiant.boite.Boite;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Presentoire implements AireI{

    public int sectionId;
    private Map<String, Set<AbstractProduit>> contenu;

    public Presentoire(int sectionId) {
        this.sectionId = sectionId;
    }

    public Presentoire(int sectionId, Map<String, Set<AbstractProduit>> contenu) {
        this.sectionId = sectionId;
        this.contenu = contenu;
    }


    @Override
    public String decrit() {
        return "Section Présentoire";
    }

    @Override
    public Collection<AbstractProduit> retireProduits(Collection<AbstractProduit> items) {
        return null;
    }

    @Override
    public Collection<AbstractProduit> getAllProduits() {
        return null;
    }

    @Override
    public Collection<AbstractProduit> placerProduits(Boite produits) {
        return null;
    }

    @Override
    public boolean placerProduits(Collection<AbstractProduit> produits) {
        return false;
    }

    @Override
    public void viderAire() {

    }

    @Override
    public void gereSurplus(Collection<AbstractProduit> restant) {

    }
}
