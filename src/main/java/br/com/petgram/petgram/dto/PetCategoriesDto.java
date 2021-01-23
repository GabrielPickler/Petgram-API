package br.com.petgram.petgram.dto;

import br.com.petgram.petgram.model.PetCategories;
import lombok.Getter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class PetCategoriesDto {
    private final Long id;
    private final String name;

    public PetCategoriesDto(PetCategories categories) {
        this.id = categories.getId();
        this.name = categories.getName();
    }

    public static List<PetCategoriesDto> listToDto(List<PetCategories> categories) {
        return categories.stream().map(PetCategoriesDto::new).collect(Collectors.toList());
    }

    public static Optional<List<PetCategoriesDto>> optionalToDto(Optional<PetCategories> categories) {
        return Optional.of(categories.stream().map(PetCategoriesDto::new).collect(Collectors.toList()));
    }
}
