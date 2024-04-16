package tp2.etudiant.section;

import tp2.application.AbstractProduit;

import java.util.Map;
import java.util.Set;

public class Vrac {
    Map<String, Set<AbstractProduit>> contenu;

    public Vrac(Map<String, Set<AbstractProduit>> contenu) {
        this.contenu = contenu;
    }
}
