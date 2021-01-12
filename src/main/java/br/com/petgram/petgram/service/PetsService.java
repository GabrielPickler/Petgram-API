package br.com.petgram.petgram.service;

import br.com.petgram.petgram.model.Pet;
import br.com.petgram.petgram.model.UserAccount;
import br.com.petgram.petgram.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsService {

    @Autowired
    PetsRepository petsRepository;

    public List<Pet> findAll() {
        return petsRepository.findAll();
    }
}
