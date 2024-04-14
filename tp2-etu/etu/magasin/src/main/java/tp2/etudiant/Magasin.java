package tp2.etudiant;

import tp2.application.AbstractProduit;
import tp2.echange.Descriptible;
import tp2.echange.Modele;
import tp2.etudiant.boite.Boite;
import tp2.etudiant.client.Achat;
import tp2.etudiant.section.AireI;
import tp2.etudiant.section.Entrepot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Magasin implements Modele {


    private Collection<Achat> achats = new ArrayList<>();
    private Collection <AireI> sections;
    private Entrepot entrepot;

//    private EntrepotClient entrepotClient;



    public Magasin() {
        // Instanciez les attributs nécessaires
        sections = new ArrayList<>();
        entrepot = new Entrepot();
        //sections.add(EntrepotClient);

    }


    @Override
    public Collection<AireI> getAllSections() {
        return null;
    }

    @Override
    public Descriptible getCharite() {
        return null;
    }

    @Override
    public int recevoirCommande(Collection<Boite> commande) {
        int nbreBoiteAjout = 0;

        for (Boite boite : commande){
            if (entrepot.entreposeBoite(boite)){
                nbreBoiteAjout++;
            }
        }
        return nbreBoiteAjout;
    }

    public void placerProduits(Collection<Boite> boites, AireI section) {

    }

    @Override
    public void mettreDansPanier(Collection<AbstractProduit> items) {

    }

    @Override
    public Collection<AbstractProduit> getContenuPanier() {
        return null;
    }

    @Override
    public void retirerDuPanier(List<AbstractProduit> itemARetirer) {

    }

    public Achat acheterPanier(String achateur, LocalDateTime dateTime) {
        return null;
    }

    @Override
    public void init() {

    }

    public Entrepot getEntrepot() {
        return null;
    }

}
