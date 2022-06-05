package br.com.adopt.petsback.service.adapter;

import br.com.adopt.petsback.domain.dto.AdoptionRequestDto;
import br.com.adopt.petsback.domain.dto.AdoptionResponseDto;
import br.com.adopt.petsback.domain.entity.Adoption;
import br.com.adopt.petsback.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdoptionMapper {

    private final PetRepository petRepository;
    private final PetMapper petMapper;

    public Adoption toAdoption(AdoptionRequestDto adoptionRequestDto){
        final var adoption = new Adoption();
        adoption.setEmail(adoptionRequestDto.getEmail());
        adoption.setValue(adoptionRequestDto.getValue());
        adoption.setPet(petRepository.findByIdOrElseThrow(adoptionRequestDto.getPetId()));
        return adoption;
    }

    public AdoptionResponseDto toResponseDto(Adoption adoption) {
        var adoptionResponse = new AdoptionResponseDto();
        adoptionResponse.setId(adoption.getId());
        adoptionResponse.setEmail(adoption.getEmail());
        adoptionResponse.setValue(adoption.getValue());
        adoptionResponse.setPet(petMapper.toPetResponseDto(adoption.getPet()));
        return adoptionResponse;
    }
}