package br.com.adopt.petsback.domain.dto;

import br.com.adopt.petsback.validator.PetExistsById;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AdoptionRequestDto {

    @NotNull
    @Email
    @NotEmpty
    @Size(max = 255)
    private String email;

    @NotNull
    @Min(10)
    @Max(100)
    private BigDecimal value;

    @NotNull
    @Positive
    @PetExistsById
    private Long petId;
}