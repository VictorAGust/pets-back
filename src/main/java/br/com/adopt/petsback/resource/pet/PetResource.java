package br.com.adopt.petsback.resource.pet;


import br.com.adopt.petsback.domain.dto.PetResponseDto;
import br.com.adopt.petsback.service.PetService;
import br.com.adopt.petsback.service.adapter.PetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/api/v1/pets")
@RestController
public class PetResource {

    private final PetService petService;

    private final PetMapper petMapper;

    @GetMapping("/")
    public ResponseEntity<List<PetResponseDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.findAll());
    }
}
