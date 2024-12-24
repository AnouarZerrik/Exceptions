package org.bank;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CompteBancaire> comptes = new ArrayList<>();

        // Ajouter des comptes
        comptes.add(new CompteCourant("001", 1000.0, "Anouar", 500.0));
        comptes.add(new CompteEpargne("002", 2000.0, "Zerrik", 2.5));

        System.out.println(comptes);
        comptes.forEach(compteBancaire -> compteBancaire.afficher_solde());


        CompteBancaire compteBancaire1 = comptes.stream()
                .filter(compteBancaire -> compteBancaire.numeroCompte.equals("001"))
                .findFirst()
                .get();
        CompteBancaire compteBancaire2 = comptes.stream()
                .filter(compteBancaire -> compteBancaire.numeroCompte.equals("002"))
                .findFirst()
                .get();

      comptes.forEach(compteBancaire -> compteBancaire.afficher_solde());

        comptes.removeIf(compteBancaire -> compteBancaire.numeroCompte == "001");
        System.out.println(comptes);




        compteBancaire1.afficher_solde();
        compteBancaire1.depot(2000.0);
        compteBancaire1.afficher_solde();
        try {
            compteBancaire1.retrait(2000.0);
        } catch (FondsInsuffisantsException e) {
            System.out.println(e.getMessage());
        }finally {
            compteBancaire1.afficher_solde();
        }

        try {
            compteBancaire1.transfert(compteBancaire2 , 3000);
        } catch (CompteInexistantException e) {
            e.printStackTrace();
        } catch (FondsInsuffisantsException e) {
            e.printStackTrace();
        }

    }
}