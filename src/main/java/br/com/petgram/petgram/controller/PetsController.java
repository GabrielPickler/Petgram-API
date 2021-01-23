package br.com.petgram.petgram.controller;

import br.com.petgram.petgram.dto.PetDto;
import br.com.petgram.petgram.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private PetsService petsService;

    @GetMapping
    public List<PetDto> listAll() {
        return PetDto.listToDto(petsService.findAll());
    }

}
