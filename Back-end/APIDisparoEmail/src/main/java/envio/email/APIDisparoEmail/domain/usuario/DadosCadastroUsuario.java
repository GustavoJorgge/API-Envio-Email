package envio.email.APIDisparoEmail.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

public record DadosCadastroUsuario(

        @NotBlank (message = "O nome é obrigatorio!")
        String primeiroNome,

        @NotBlank (message = "O nome é obrigatorio!")
        String sobreNome,

        @NotBlank(message = "O E-mail é obrigatorio!")
        @Email(message = "Formato de E-mail invalido!")
        String email,
        String senha) {
}
