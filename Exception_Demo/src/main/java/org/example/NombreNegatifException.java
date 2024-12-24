package org.example;

public class NombreNegatifException extends Exception {
    public int val;
    public NombreNegatifException(String message, int val) {
        super(message);
        this.val = val;
    }
    public NombreNegatifException(String message) {
        super(message);
    }
     public int getValErronee(){
         return this.val;
     }


}
