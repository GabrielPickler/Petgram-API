package br.com.petgram.petgram.repository;

import br.com.petgram.petgram.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    List<UserAccount> findByUsername(String username);
    List<UserAccount> findByEmail(String email);
}
