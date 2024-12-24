package org.example;

public class EntierNaturel {
    private int val;

    public EntierNaturel(int val) throws NombreNegatifException {
        if (val < 0) throw new NombreNegatifException("Le Nombre que tu a rentré c'est negative !!", val);
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) throws NombreNegatifException {
        if (val < 0) throw new NombreNegatifException("Le Nombre que tu a rentré c'est negative !!", val);
        this.val = val;
    }

    public void decrementer() throws NombreNegatifException {
        if (this.val - 1 < 0) throw new NombreNegatifException("Tu ne peux pas decremente Val");
        this.val -= 1;
    }

    public static void main(String[] args) throws NombreNegatifException {
        try {
            EntierNaturel nombre = new EntierNaturel(5);
            System.out.println("Valeur initiale : " + nombre.getVal());

            nombre.setVal(3);
            System.out.println("Valeur mise à jour : " + nombre.getVal());

            nombre.decrementer();
            System.out.println("Après décrémentation : " + nombre.getVal());

            nombre.setVal(-1);

        } catch (NombreNegatifException e) {
            System.out.println("Valeur négative " + e.getValErronee());
            e.printStackTrace();
        }
    }
}
