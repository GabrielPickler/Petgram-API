package br.com.petgram.petgram.repository;

import br.com.petgram.petgram.model.PetCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetCategoriesRepository extends JpaRepository<PetCategories, Long> {
}
