package tp2.etudiant.section;


import tp2.etudiant.boite.Boite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Entrepot {
    public static final int NOMBRE_SECTION = 5;
    public static final int NOMBRE_TABLETTE = 5;
    public static final int NOMBRE_CATEGORIES = 3;
    private String sectionId = "entrepot";
    private Boite[][][] entreposage;//[rangee][section][tablette]->[categorie de produit][type de produit][boite de produit]

    public Entrepot() {
        entreposage = new Boite[NOMBRE_CATEGORIES]
                [NOMBRE_SECTION]
                [NOMBRE_TABLETTE];
    }

    
    public boolean entreposeBoite(Boite boite) {
        boolean ajoutBoite = true;
        int numeroCategorie = boite.getNumeroCategorie();
        int numeroProduit = boite.getNumeroProduit();
        int rangee = trouverRangee(numeroCategorie);
        int section = trouverSection(rangee, numeroProduit);
        if (section == -1) {
            section = trouverSectionLibre(rangee);
            if (section == -1) {
                System.out.println("Pas de section disponible pour ce type de produit");
                ajoutBoite = false;
            }
        }
        if (ajoutBoite) {
            reorganisation(rangee, section);
            if (entreposage[rangee][section][NOMBRE_TABLETTE - 1] != null) {
                ajoutBoite = false;
                System.out.println("Section pleine: boîte refusée");
            } else {
                decalage(rangee, section);
                entreposage[rangee][section][0] = boite;
            }
        }
        return ajoutBoite;
    }

    public void retireBoite(Boite boite) {
        int numeroCategorie = boite.getNumeroCategorie();
        int numeroProduit = boite.getNumeroProduit();
        int rangee = trouverRangee(numeroCategorie);
        int section = trouverSection(rangee, numeroProduit);
        for (int i = 0; i < NOMBRE_TABLETTE; i++) {
            if (entreposage[rangee][section][i].equals(boite)) {
                entreposage[rangee][section][i] = null;
                System.out.println("La boite " + boite.decrit() + " a été retirée");
            }
        }
        reorganisation(rangee, section);
    }

    //Retourne le numéro de rangée de la categorie dont le numéro est passé en paramètre
    private int trouverRangee(int numeroCategorie) {
        int numeroRangee = -1;
        for (int i = 0; i < NOMBRE_CATEGORIES; i++) {
            if (entreposage[i][0][0].getNumeroCategorie() == numeroCategorie) {
                numeroRangee = i;
            }
        }
        return numeroRangee;
    }

    //Retourne le numéro de section du produit dont le numéro  et la rangée sont passés en paramètre
    private int trouverSection(int rangee, int numeroProduit) {
        int numeroSection = -1;
        for (int j = 0; j < NOMBRE_SECTION; j++) {
            if (entreposage[rangee][j][0].getNumeroProduit() == numeroProduit) {
                numeroSection = j;
            }
        }
        return numeroSection;
    }


    //Monte toutes les boites de la section passée en paramètre d'une tablette
    public void decalage(int rangee, int section) {
        int lastIndex = -1;
        for (int i = 0; i < NOMBRE_TABLETTE; i++) {
            if (entreposage[rangee][section][i] != null || entreposage[rangee][section][i + 1] == null) {
                lastIndex = i;
            }
        }
        for (int i = lastIndex; i >= 0; i--) {
            entreposage[rangee][section][i + 1] = entreposage[rangee][section][i];
            entreposage[rangee][section][i] = null;
        }
    }


    //Comble tout les vides qui peuvent se trouver entre deux boites de la section passée en paramètre
    public void reorganisation(int rangee, int section) {
        for (int i = 0; i < NOMBRE_TABLETTE - 1; i++) {
            if (entreposage[rangee][section][i] == null || entreposage[rangee][section][i + 1] != null) {
                entreposage[rangee][section][i] = entreposage[rangee][section][i + 1];
                entreposage[rangee][section][i + 1] = null;
            }
        }
    }

    public int trouverSectionLibre(int rangee) {
        int numSectionLibre = -1;
        for (int i = 0; i < NOMBRE_SECTION; i++) {
            boolean sectionVide = true;
            for (int j = 0; j < NOMBRE_TABLETTE; j++) {
                if (entreposage[rangee][i][j] != null) {
                    sectionVide = false;
                    break;
                }
            }
            if (sectionVide) {
                numSectionLibre = i;
                break;
            }
        }
        return numSectionLibre;
    }

    // passage 3d vers 2d les 2 preière dimension sont fusionnées
    public Boite[][] getBoites2D() {

        return null;
    }

    public Boite[] getBoites1D() {
        List<Boite> listTab = new ArrayList<Boite>();
        for (int i = 0; i < entreposage.length; i++) {
            for (int j = 0; j < entreposage[0].length; j++) {
                for (int k = 0; k < entreposage[0][0].length; k++) {
                    listTab.add(entreposage[i][j][k]);
                }
            }
        }
        Boite[] tab = (Boite[]) listTab.toArray();
        return tab;
    }

    public Boite[] getBoites3D() {

        return null;
    }


}

//test push tom//

