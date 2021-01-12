package br.com.petgram.petgram.repository;

import br.com.petgram.petgram.model.Pet;
import br.com.petgram.petgram.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Long> {
}
