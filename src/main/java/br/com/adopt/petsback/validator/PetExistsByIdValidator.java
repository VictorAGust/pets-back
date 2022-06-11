package br.com.adopt.petsback.validator;

import br.com.adopt.petsback.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class PetExistsByIdValidator implements ConstraintValidator<PetExistsById, Long> {

    private final PetRepository petRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return petRepository.existsById(value);
    }
}
