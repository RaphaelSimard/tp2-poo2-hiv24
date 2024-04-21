package tp2.etudiant.section;

import tp2.application.AbstractProduit;
import tp2.echange.Descriptible;

import java.util.ArrayList;
import java.util.Collection;

public class Charite implements Descriptible {

    private Collection<AbstractProduit> produitsDeCharite;

    public Charite(){
        this.produitsDeCharite = new ArrayList<>();
    }

    public void donneProduits(Collection<AbstractProduit> produits) {

    }

    public void donneProduit(AbstractProduit produit) {
        produitsDeCharite.add(produit);
    }

    @Override
    public String decrit() {
        return produitsDeCharite.toString();
    }
}
