package br.com.adopt.petsback.service;

import br.com.adopt.petsback.domain.dto.AdoptionRequestDto;
import br.com.adopt.petsback.domain.dto.AdoptionResponseDto;
import br.com.adopt.petsback.repository.AdoptionRepository;
import br.com.adopt.petsback.service.adapter.AdoptionBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptionService {

    private final AdoptionBuilder adoptionBuilder;

    private final AdoptionRepository adoptionRepository;

    public AdoptionResponseDto create(AdoptionRequestDto adoptionRequestDto) {
        var adoption = adoptionBuilder.toAdoption(adoptionRequestDto);
        var createdAdoption = adoptionRepository.save(adoption);
        return adoptionBuilder.toAdoptionResponseDto(createdAdoption);

    }

    public List<AdoptionResponseDto> findAll() {
        return adoptionRepository.findAll()
                .stream()
                .map(adoptionBuilder::toAdoptionResponseDto)
                .toList();
    }
}
