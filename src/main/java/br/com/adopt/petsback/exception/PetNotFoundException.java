package br.com.adopt.petsback.exception;

import javax.persistence.EntityNotFoundException;

public class PetNotFoundException extends EntityNotFoundException {
    public PetNotFoundException() {
        super("Pet not Found");
    }

    public PetNotFoundException(String message) {
        super(message);
    }
}
