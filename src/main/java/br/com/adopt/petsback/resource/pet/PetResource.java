package br.com.adopt.petsback.resource.pet;


import br.com.adopt.petsback.domain.dto.PetRequestDto;
import br.com.adopt.petsback.domain.dto.PetResponseDto;
import br.com.adopt.petsback.service.PetService;
import br.com.adopt.petsback.service.adapter.PetBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/api/v1/pets")
@RestController
public class PetResource {

    private final PetService petService;

    private final PetBuilder petBuilder;

    @GetMapping
    public ResponseEntity<List<PetResponseDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.findAll());
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PetResponseDto create(@RequestBody @Valid final PetRequestDto petRequestDto) {
        return petService.create(petRequestDto);
    }
}
