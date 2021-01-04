package br.com.petgram.petgram.controller;

import br.com.petgram.petgram.dto.UserAccountDto;
import br.com.petgram.petgram.dto.UserAccountFormDto;
import br.com.petgram.petgram.model.UserAccount;
import br.com.petgram.petgram.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.petgram.petgram.repository.UserAccountRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/useraccount")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping
    public List<UserAccountDto> listAll() {
        return UserAccountDto.listToDto(userAccountService.findAll());
    }

    @PostMapping(value = "/auth")
    public ResponseEntity<UserAccountDto> logIn(@RequestBody UserAccountFormDto form) {
        if(form == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userAccountService.findByUsername(form));
    }

    @PostMapping
    public ResponseEntity<UserAccountDto> create(@RequestBody UserAccountFormDto form, UriComponentsBuilder uriBuilder) throws Exception {
        UserAccount userAccount = form.toDto();
        userAccountService.save(userAccount);
        URI uri = uriBuilder.path("/useraccount").buildAndExpand(userAccount.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserAccountDto(userAccount));
    }
}
