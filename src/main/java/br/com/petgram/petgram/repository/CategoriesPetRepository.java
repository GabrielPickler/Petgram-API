package br.com.petgram.petgram.repository;

import br.com.petgram.petgram.model.PetCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesPetRepository extends JpaRepository<PetCategories, Long> {
}
