package tp2.etudiant.section;


import tp2.etudiant.boite.Boite;

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


    //il manque la gestion en cas de section inexistante pour ce produit, ou si il n'y a plus de section disponible de la part de l'entrepot
    public boolean entreposeBoite(Boite boite) {
        int numeroCategorie = boite.getNumeroCategorie();
        int numeroProduit = boite.getNumeroProduit();
        int rangee = trouverRangee(numeroCategorie);
        int section = trouverSection(rangee, numeroProduit);
        reorganisation(rangee, section);
        assert entreposage[rangee][section][NOMBRE_TABLETTE - 1] == null : "Section pleine, boite refusée";
        decalage(rangee, section);
        entreposage[rangee][section][0] = boite;
        return true;
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

    // passage 3d vers 2d les 2 preière dimension sont fusionnées
    public Boite[][] getBoites2D() {

        return null;
    }

    public Boite[] getBoites1D() {

        return null;
    }

    public Boite[] getBoites3D() {

        return null;
    }


}

