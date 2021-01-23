package br.com.petgram.petgram.service;

import br.com.petgram.petgram.model.PetCategories;
import br.com.petgram.petgram.repository.PetCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetCategoriesService {

    @Autowired
    PetCategoriesRepository petCategoriesRepository;

    public List<PetCategories> findAll() {
        return petCategoriesRepository.findAll();
    }

    public Optional<PetCategories> findById(Long id) {
        return petCategoriesRepository.findById(id);
    }
}
