package br.com.petgram.petgram.service;

import br.com.petgram.petgram.dto.UserAccountDto;
import br.com.petgram.petgram.dto.UserAccountFormDto;
import br.com.petgram.petgram.exception.PetgramException;
import br.com.petgram.petgram.model.UserAccount;
import br.com.petgram.petgram.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public void save(UserAccount userAccount) throws Exception {
        if (userAccountRepository.findByUsername(userAccount.getUsername()) == null) {
            throw new PetgramException("Usuário já cadastrado!");
        }
        if (userAccountRepository.findByEmail(userAccount.getEmail()) == null) {
            throw new PetgramException("Email já cadastrado!");
        }
        try {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
            userAccountRepository.save(userAccount);
        } catch (Exception e) {
            throw new Exception("Algo de errado aconteceu...");
        }
    }

    public UserAccountDto findByUsername(UserAccountFormDto userAccount) {

        UserAccount user = userAccountRepository.findByUsername(userAccount.getUsername());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (user == null || !encoder.matches(userAccount.getPassword(), user.getPassword())) {
            throw new PetgramException("Usuário ou senha estão incorretos!");
        }

        return new UserAccountDto(user);
    }

    public List<UserAccount> findAll() {
        return userAccountRepository.findAll();
    }
}
