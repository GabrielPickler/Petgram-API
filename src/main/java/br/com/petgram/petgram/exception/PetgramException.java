package br.com.petgram.petgram.exception;

public class PetgramException extends RuntimeException {

    public PetgramException(String message) {
        super(message);
    }

    public PetgramException(String message, Throwable cause) {
        super(message, cause);
    }
}
