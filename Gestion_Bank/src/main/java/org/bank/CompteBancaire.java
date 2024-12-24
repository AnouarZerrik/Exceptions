package org.bank;

public class CompteBancaire {
    public String numeroCompte;
    public double solde ;
    public String nom;

    public CompteBancaire() {
    }

    public CompteBancaire(String numeroCompte, double solde, String nom) {
        this.solde = solde;
        this.nom = nom;
        this.numeroCompte = numeroCompte;
    }

    public void depot(double solde_depot){
        this.solde += solde_depot;
    }

    public void retrait(double solde_retrait) throws FondsInsuffisantsException {
        if (this.solde < solde_retrait) throw new FondsInsuffisantsException("Tu ne peux pas retrait le solde pour le compte " + this.numeroCompte);
        this.solde -= solde_retrait;
    }

    public void afficher_solde(){
        System.out.println("le solde de " + this.nom +" c'est : " + this.solde );
    }

    public void transfert(CompteBancaire to,double montant) throws CompteInexistantException, FondsInsuffisantsException {
        if ( to == null && !(to instanceof CompteBancaire)) throw new CompteInexistantException("Cette compte n'est pas exist !!");
        this.retrait(montant);
        to.depot(montant);
    }

}
