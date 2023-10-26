package br.com.mgckdev.gestao_vagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {

  private UUID id;
  private String name;

  @Pattern(regexp = "\\S+", message = "O campo não deve conter espaços")
  private String username;

  @Email(message = "O campodeve conter um e-mail válido")
  private String email;

  @Length(min = 10, max = 50, message = "o campo deve conter entre 10 e 50 caracteres")
  private String password;
  private String description;
  private String curriculum;

}
