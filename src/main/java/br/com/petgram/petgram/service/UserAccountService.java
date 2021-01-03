package br.com.petgram.petgram.service;

import br.com.petgram.petgram.dto.UserAccountDto;
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
            if(!userAccountRepository.findByUsername(userAccount.getUsername()).isEmpty()){
                throw new PetgramException("Usuário já cadastrado!");
            }
            if(!userAccountRepository.findByEmail(userAccount.getEmail()).isEmpty()){
                throw new PetgramException("Email já cadastrado!");
            }
            try {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
                userAccountRepository.save(userAccount);
            }catch (Exception e){
                throw new Exception("Algo de errado aconteceu...");
            }
    }

    public List<UserAccountDto> findAll(){
        return UserAccountDto.toDto(userAccountRepository.findAll());
    }

}
