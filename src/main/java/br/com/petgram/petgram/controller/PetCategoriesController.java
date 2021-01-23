package br.com.petgram.petgram.controller;

import br.com.petgram.petgram.dto.PetCategoriesDto;
import br.com.petgram.petgram.service.PetCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/petcategories")
public class PetCategoriesController {

    @Autowired
    private PetCategoriesService petCategoriesService;

    @GetMapping
    public List<PetCategoriesDto> listAll() {
        return PetCategoriesDto.listToDto(petCategoriesService.findAll());
    }

    @GetMapping(value = "/{id}")
    public Optional<List<PetCategoriesDto>> listAllById(@PathVariable("id") Long id){
        return PetCategoriesDto.optionalToDto(petCategoriesService.findById(id));
    }
}
