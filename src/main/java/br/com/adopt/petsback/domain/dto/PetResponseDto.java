package br.com.adopt.petsback.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetResponseDto {

    private Long id;
    private String name;
    private String history;
    private String photo;
}
