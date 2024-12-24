package org.bank;

public class CompteEpargne extends CompteBancaire{
    private double interestRate;

    public CompteEpargne(String numeroCompte, double solde, String nom, double interestRate) {
        super(numeroCompte , solde, nom);
        this.interestRate = interestRate;
    }

    public void genererInterets() {
        this.solde += this.solde * this.interestRate;
    }
}
