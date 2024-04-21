package tp2.etudiant.section;


import tp2.etudiant.boite.Boite;

import java.util.*;

public class Entrepot{


    private Map<Integer, Boite [][]> categorieBoite = new HashMap<>();
    public static final int NOMBRE_SECTION = 8;
    public static final int NOMBRE_TABLETTE = 4;
    public static final int NOMBRE_CATEGORIES = 5;
    private String sectionId = "entrepot";
    private Boite[][][] entreposage;//[rangee][section][tablette]->[categorie de produit][type de produit][boite de produit]

    public Entrepot() {
        entreposage = new Boite[NOMBRE_CATEGORIES]
                [NOMBRE_SECTION]
                [NOMBRE_TABLETTE];
        /**
         *         // Ici c'est pour identifier le premier niveau à un ID --> la categorie de quotidien est 0, donc va etre dans le premier tableau de tableau de tableau et etc
         */
        for (int i = 0; i < NOMBRE_CATEGORIES; i++) {
            categorieBoite.put(i, entreposage[i]);
        }

    }


    /**
     * regarde si les sections sont tous vide dans la rangee
     * @param rangee
     * @return
     */
    public boolean sectionSontTousVide (int rangee){
        boolean test = true;
        for (int i = 0; i < NOMBRE_SECTION; i++) {
            if (!sectionVide(entreposage[rangee][i]) && test == true){
                test = false;
            };
        }
        return test;
    }

    public int trouverSectionEnUtilisation (int rangee, int numeroProduit){
        int numSection =-1;
        for (int i = 0; i < NOMBRE_SECTION; i++) {
            if (entreposage[rangee][i][0] != null && entreposage[rangee][i][0].getNumeroProduit() == numeroProduit){
                numSection = i;
                break;
            }
        }
        return numSection;
    }

    /**
     * méthode principale qui s'occupe de revevoir le produit commandé, et de le placé selon les contraintes
     * @param boite
     * @return
     */
    public boolean entreposeBoite(Boite boite) {

        boolean ajoutBoite = true;
        int section = 0;
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

        /**
         * après avoir trouvé la rangee selon le produit, l'on cherche si une section est déja utilisé, si oui, l'on compare son numéroCategorie avec le numProduit
         */
        if (!sectionSontTousVide(rangee)) {
             section = trouverSectionEnUtilisation(rangee, numeroProduit);
        } else {
            section = trouverSection(rangee, numeroProduit);
        }

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


    /**
     * retrait de boite lors du transfert hors de l'entrepôt
     * @param boite
     */
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

    /**
     * //Retourne le numéro de rangée de la categorie dont le numéro est passé en paramètre
     * @param numeroCategorie
     * @return
     */
    private int trouverRangee(int numeroCategorie) {
        return categorieBoite.containsKey(numeroCategorie) ? numeroCategorie :-1;
    }

    /**
     * Retourne le numéro de section du produit dont le numéro  et la rangée sont passés en paramètre
     * @param rangee
     * @param numeroProduit
     * @return
     */
    private int trouverSection(int rangee, int numeroProduit) {
        int numSection = -1;
        for (int i = 0; i < NOMBRE_SECTION && numSection == -1 ; i++) {
            if(sectionVide(entreposage[rangee][i])){
                numSection = i;
            }
        }
        return numSection;
    }


    /**
     * Monte toutes les boites de la section passée en paramètre d'une tablette
     * @param rangee
     * @param section
     */
    public void decalage(int rangee, int section) {
        if (entreposage[rangee][section][NOMBRE_TABLETTE-1]==null){
        int lastIndex = -1;
        for (int i = 0; i < NOMBRE_TABLETTE - 1; i++) {
            if (entreposage[rangee][section][i] != null && entreposage[rangee][section][i + 1] == null) {
                lastIndex = i;
            }
        }
        for (int i = lastIndex; i >= 0; i--) {
            if (entreposage[rangee][section][i] != null) {
                entreposage[rangee][section][i + 1] = entreposage[rangee][section][i];
                entreposage[rangee][section][i] = null;
            }
            }
        }
    }


    /**
     * Comble tous les vides qui peuvent se trouver entre deux boites de la section passée en paramètre
     * @param rangee
     * @param section
     */
    public void reorganisation(int rangee, int section) {
        for (int i = 0; i < NOMBRE_TABLETTE - 1; i++) {
            if (entreposage[rangee][section][i] == null && entreposage[rangee][section][i + 1] != null) {
                entreposage[rangee][section][i] = entreposage[rangee][section][i + 1];
                entreposage[rangee][section][i + 1] = null;
            }
        }
    }


    /**
     * trouve la première section de libre avec la rangee en paramètre
     * @param rangee
     * @return
     */
    public int trouverSectionLibre(int rangee) {
        int numSection = -1;
        for (int i = 0; i < NOMBRE_SECTION && numSection ==-1; i++) {
            if (sectionVide(entreposage[rangee][i])) {
                numSection = i;
            }
        }
        return numSection;
    }


    /**
     * trouve et renvoie le numéro de la premiere range de libre
     * @return
     */
    public int trouverRangeeLibre() {
        int numRangeeLibre = -1;
        for (int i = 0; i < NOMBRE_CATEGORIES && numRangeeLibre==-1; i++) {
            if (rangeeVide(entreposage[i])) {
                numRangeeLibre = i;
            }
        }
        return numRangeeLibre;
    }

    /**
     * informe si la rangee est vide
     * @param sections
     * @return
     */
    public boolean rangeeVide(Boite[][] sections) {
        boolean estVide = true;
        for (Boite[] section : sections) {
            if (!sectionVide(section)) {
                estVide = false;
            }
        }
        return estVide;
    }

    /**
     * vérifie si une section est vide
     * @param section
     * @return
     */
    private boolean sectionVide(Boite[] section) {
        boolean estVide = true;
        for (Boite boite : section) {
            if (boite != null) {
                estVide = false;
            }
        }
        return estVide;
    }


    /**
     * passage 3d vers 2d les 2 premières dimensions sont fusionnées
     * @return
     */
    public Boite[][] getBoites2D() {
        Boite[][] tab2D = new Boite[NOMBRE_SECTION * NOMBRE_CATEGORIES][NOMBRE_TABLETTE];
        int index = 0;
        for (int i = 0; i < NOMBRE_CATEGORIES; i++) {
            for (int j = 0; j < NOMBRE_SECTION; j++) {
                Boite[] section = entreposage[i][j];
                if (!sectionVide(section)) {
                    for (int k = 0; k < NOMBRE_TABLETTE; k++) {
                        tab2D[index][k] = section[k];
                    }
                } else {
                    Boite[] sectionVide = {null, null, null, null, null};
                    tab2D[index] = sectionVide;
                }
            }
            index++;
        }
        return tab2D;
    }

    /**
     * montre l'entrepot sous un angle de 1d, utiliser dans MagasinController pour voir l'entrepot dans l'UI
     * @return
     */
    public Boite[] getBoites1D() {
        List<Boite> listTab = new ArrayList<Boite>();
        for (int i = 0; i < NOMBRE_CATEGORIES; i++) {
            for (int j = 0; j < NOMBRE_SECTION; j++) {
                for (int k = 0; k < NOMBRE_TABLETTE; k++) {
                    listTab.add(entreposage[i][j][k]);
                }
            }
        }
        return listTab.toArray(new Boite[0]);
    }

    /**
     * affiche une matrice représentant les boites dans la dimension de base : 3d
     * @return
     */
    public Boite[][][] getBoites3D() {
        Boite[][][] matrice = new Boite[NOMBRE_CATEGORIES][NOMBRE_SECTION][NOMBRE_TABLETTE];
        for (int i = 0; i < NOMBRE_CATEGORIES; i++) {
            matrice[i] = entreposage[i];
        }
        return matrice;
    }


}


