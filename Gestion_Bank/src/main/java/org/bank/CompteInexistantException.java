package org.bank;

public class CompteInexistantException extends Exception {
    public CompteInexistantException(String message) {
        super(message);
    }
}