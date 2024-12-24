package org.bank;

public class CompteCourant extends CompteBancaire{
    private double overdraftLimit;

    public CompteCourant(String numeroCompte, double solde, String nom, double overdraftLimit) {
        super(numeroCompte , solde, nom);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void retrait(double solde_retrait) throws FondsInsuffisantsException {
        if (this.solde + this.overdraftLimit < solde_retrait) {
            throw new FondsInsuffisantsException("Tu ne peux pas retrait le solde pour le compte " + this.numeroCompte);
        }
        this.solde -= solde_retrait;
    }
}
