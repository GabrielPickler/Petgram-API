package br.com.petgram.petgram.dto;

import br.com.petgram.petgram.model.UserAccount;
import lombok.Getter;
import org.apache.catalina.User;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserAccountDto {
    private Long id;
    private String username;
    private String email;
    private String password;

    public UserAccountDto(UserAccount userAccount){
        this.id = userAccount.getId();
        this.username = userAccount.getUsername();
        this.email = userAccount.getEmail();
        this.password = userAccount.getPassword();
    }

    public static List<UserAccountDto> toDto(List<UserAccount> users){
        return users.stream().map(UserAccountDto::new).collect(Collectors.toList());
    }
}
