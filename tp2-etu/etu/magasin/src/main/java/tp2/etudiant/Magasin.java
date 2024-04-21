package tp2.etudiant;

import tp2.application.AbstractProduit;
import tp2.echange.Descriptible;
import tp2.echange.Modele;
import tp2.etudiant.boite.Boite;
import tp2.etudiant.client.Achat;
import tp2.etudiant.section.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Magasin implements Modele {


    private Collection<Achat> achats = new ArrayList<>();
    private Collection <AireI> sections;
    private Entrepot entrepot;

    private Charite charite;



    public Magasin() {
        // Instanciez les attributs nécessaires
        sections = new ArrayList<>();
        entrepot = new Entrepot();
        sections.add(new Vrac());
        sections.add(new Presentoire(1));
        charite = new Charite();

    }
    @Override
    public Collection<AireI> getAllSections() {
        return sections;
    }

    @Override
    public Descriptible getCharite() {
        return charite;
    }

    @Override
    public int recevoirCommande(Collection<Boite> commande) {

        boolean boitesRestantes;
        int boiteDeTrop = 0;
        for (Boite boite : commande) {
            boitesRestantes = entrepot.entreposeBoite(boite);
            if (boitesRestantes != true) {
                boiteDeTrop ++;
            }
        }
        return boiteDeTrop;
    }
        /**
        int nbreBoiteAjout = -1;

        for (Boite boite : commande){
            if (entrepot.entreposeBoite(boite)){
                nbreBoiteAjout++;
            }
        }
        return nbreBoiteAjout;
         */



    public void placerProduits(Collection<Boite> boites, AireI section) {
        Iterator<Boite> iteratorDeBoite = boites.iterator();
        while(iteratorDeBoite.hasNext()){
            section.placerProduits(iteratorDeBoite.next());
        }
//        List<Boite> boitesNonPlacees = new ArrayList<>();
//        for (Boite boite : boites) {
//            if (section.estSectionClient()) {
//                boitesNonPlacees.add(boite);
//            }
//        }
//        if (!boitesNonPlacees.isEmpty()) {
//            if (section.estSectionClient()) {
//                charite.ajouterBoites(boitesNonPlacees);
//            } else {
//                vrac.ajouterBoites(boitesNonPlacees);
//            }
//        }
//        Iterator<Boite> iteratorDeBoite = boites.iterator();
//        while (iteratorDeBoite.hasNext()){
//            section.placerProduits(iteratorDeBoite.next());
//        }
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
        return entrepot;
    }

}
