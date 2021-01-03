package br.com.petgram.petgram.dto;

import br.com.petgram.petgram.model.UserAccount;
import lombok.Getter;

@Getter
public class UserAccountFormDto {
    private String username;
    private String email;
    private String password;

    public UserAccount toDto() {
        return new UserAccount(username, email, password);
    }
}
