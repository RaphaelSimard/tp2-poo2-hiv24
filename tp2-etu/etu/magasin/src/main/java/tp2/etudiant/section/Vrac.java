package tp2.etudiant.section;

import tp2.application.AbstractProduit;
import tp2.etudiant.boite.Boite;

import java.util.*;

public class Vrac implements AireI {
    public final static int idDefault = 0;
    double capaciteMax = 100;
    int sectionId;
    private Map<String, Set<AbstractProduit>> contenu;

//    public Vrac(Map<String, Set<AbstractProduit>> contenu) {
//        this.sectionId = idDefault;
//        this.contenu = contenu;
//    }

    public Vrac (){
        this.sectionId = idDefault;
        contenu = new HashMap<>();
    }

    @Override
    public String decrit() {
        return "Section Vrac";
    }

    @Override
    public Collection<AbstractProduit> retireProduits(Collection<AbstractProduit> items) {
        for (Map.Entry<String, Set<AbstractProduit>> entry : contenu.entrySet()){
            String cle = entry.getKey();
            contenu.get(cle).removeAll(items);
            if (contenu.get(cle).isEmpty()){
                contenu.remove(cle);
            }
        }
        return null;
    }

    @Override
    public Collection<AbstractProduit> getAllProduits() {
        Collection<AbstractProduit> colProduit = new ArrayList<>();
        for (Map.Entry<String, Set<AbstractProduit>> entry : contenu.entrySet()){
            String cle = entry.getKey();
            colProduit.addAll(contenu.get(cle));
        }


        return null;
    }

    @Override
    public Collection<AbstractProduit> placerProduits(Boite produits) {

        Collection<AbstractProduit> colProduit = new ArrayList<>();
        List<AbstractProduit> listeAbstractProduit = produits.getContenu();
        for (int i = 0; i < listeAbstractProduit.size(); i++) {
            String nomDuProduit = listeAbstractProduit.get(i).getNom();
            int volumeProduit = listeAbstractProduit.get(i).getVolumeProduit();
            int volTotal = calculerVolumeDunBac(nomDuProduit);
            if (contenu.containsKey(nomDuProduit)){
                if (volTotal + volumeProduit >= capaciteMax){
                    contenu.get(nomDuProduit).add(listeAbstractProduit.get(i));
                } else {
                    colProduit.addAll(listeAbstractProduit);
                }
            } else {
                if (volTotal + volumeProduit <= capaciteMax){
                    contenu.put(nomDuProduit, new HashSet<AbstractProduit>());
                    contenu.get(nomDuProduit).add(listeAbstractProduit.get(i));
                } else {
                    colProduit.addAll(listeAbstractProduit);
                }
            }
        }
        return colProduit;
    }

    @Override
    public boolean placerProduits(Collection<AbstractProduit> produits) {
        return false;
    }

    public boolean ajouterProduit(HashSet<AbstractProduit> Produit) {
        boolean ajout = false;
        double volumeTotal = 0;
        for (AbstractProduit produit : Produit) {
//            volumeTotal += produit.getVolume;
        }
        if (volumeTotal <= capaciteMax) {
            //Nom du bac au lieu de toString
//            contenu.put(Produit.toString(), Produit);
        } else {
            while (volumeTotal > capaciteMax) {
                for (AbstractProduit produits : Produit) {
//                    contenu.put(Produit.toString(), produits);
                }
            }
        }
        return ajout;
    }

    public int calculerVolumeDunBac(String nomDuProduit){
        int volumeDuBac = 0;
        if (contenu.containsKey(nomDuProduit)) {
            Set<AbstractProduit> setNom = contenu.get(nomDuProduit);
            Iterator<AbstractProduit> iteratorSetNom = setNom.iterator();
            while (iteratorSetNom.hasNext()) {
                volumeDuBac += iteratorSetNom.next().getVolumeProduit();
            }
        }
        return volumeDuBac;
    }


    @Override
    public void viderAire() {

    }

    @Override
    public void gereSurplus(Collection<AbstractProduit> restant) {

    }
}
