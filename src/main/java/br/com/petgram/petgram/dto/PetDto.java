package br.com.petgram.petgram.dto;

import br.com.petgram.petgram.model.Pet;
import br.com.petgram.petgram.model.UserAccount;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PetDto {
    private final Long id;
    private final String name;
    private final double age;
    private final Long categoryId;

    public PetDto(Pet pet){
        this.id = pet.getId();
        this.name = pet.getName();
        this.age = pet.getAge();
        this.categoryId = pet.getPetCategories().getId();
    }

    public static List<PetDto> listToDto(List<Pet> pets){
        return pets.stream().map(PetDto::new).collect(Collectors.toList());
    }

}

