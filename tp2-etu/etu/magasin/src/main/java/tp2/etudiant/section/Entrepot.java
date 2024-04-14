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
        if (rangee == -1) {
            rangee = trouverRangeeLibre();
            if (rangee == -1) {
                System.out.println("Plus de rangee disponible");
                ajoutBoite = false;
            }
        }
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
            if (entreposage[i][0][0] != null && entreposage[i][0][0].getNumeroCategorie() == numeroCategorie) {
                numeroRangee = i;
            }
        }
        return numeroRangee;
    }

    //Retourne le numéro de section du produit dont le numéro  et la rangée sont passés en paramètre
    private int trouverSection(int rangee, int numeroProduit) {
        int numeroSection = -1;
        for (int j = 0; j < NOMBRE_SECTION; j++) {
            if (entreposage[rangee][j][0] != null && entreposage[rangee][j][0].getNumeroProduit() == numeroProduit) {
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
        int numSection = -1;
        boolean condition = true;
        while (condition) {
            for (int i = 0; i < NOMBRE_SECTION; i++) {
                if (sectionVide(entreposage[rangee][i])) {
                    numSection = i;
                    condition = false;
                }
            }
        }
        return numSection;
    }

    public int trouverRangeeLibre() {
        int numRangeeLibre = -1;
        boolean condition = true;
        while (condition) {
            for (int i = 0; i < NOMBRE_CATEGORIES; i++) {
                if (rangeeVide(entreposage[i])) {
                    numRangeeLibre = i;
                    condition = false;
                }
            }
        }
        return numRangeeLibre;
    }

    //Vérifie si une section est vide
    private boolean sectionVide(Boite[] section) {
        boolean estVide = true;
        for (Boite boite : section) {
            if (boite != null) {
                estVide = false;
            }
        }
        return estVide;
    }

    // Vérifie si une rangée est vide
    public boolean rangeeVide(Boite[][] sections) {
        boolean estVide = true;
        for (Boite[] section : sections) {
            if (!sectionVide(section)) {
                estVide = false;
            }
        }
        return estVide;
    }

    public boolean entrepotVide() {
        boolean estVide = true;
        for (Boite[][] rangee: entreposage) {
            if (!rangeeVide(rangee)) {
                estVide = false;
            }
        }
        return estVide;
    }

    // passage 3d vers 2d les 2 premières dimensions sont fusionnées
    public Boite[][] getBoites2D() {
        Boite[][] tab2D = new Boite[NOMBRE_SECTION*NOMBRE_CATEGORIES][NOMBRE_TABLETTE];
        int index = 0;
        for (int i = 0; i < NOMBRE_CATEGORIES; i++) {
            for (int j = 0; j < NOMBRE_SECTION; j++) {
                Boite[] section = entreposage[i][j];
                if (!sectionVide(section)) {
                    for (int k = 0; k < NOMBRE_TABLETTE; k++) {
                        tab2D[index][k] = section[k];
                    }
                }
                else {
                    Boite[] sectionVide = {null, null, null, null, null};
                    tab2D[index] = sectionVide;
                }
            }
            index++;
        }
        return tab2D;
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
        return listTab.toArray(new Boite[0]);
    }

    public Boite[][][] getBoites3D() {
        return entreposage;
    }


}


