package br.com.adopt.petsback.resource.adoption;

import br.com.adopt.petsback.domain.dto.AdoptionRequestDto;
import br.com.adopt.petsback.domain.dto.AdoptionResponseDto;
import br.com.adopt.petsback.service.AdoptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/adoption")
public class AdoptionResource {

    private final AdoptionService adoptionService;

    @PostMapping
    public ResponseEntity<AdoptionResponseDto> create(@RequestBody @Valid final AdoptionRequestDto adoptionRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adoptionService.create(adoptionRequestDto));
    }

    @GetMapping
    public List<AdoptionResponseDto> findAll() {
        return adoptionService.findAll();
    }
}
