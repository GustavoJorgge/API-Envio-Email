package envio.email.APIDisparoEmail.domain.usuario;

import org.springframework.stereotype.Component;

public record DadosCadastroUsuario(
        String primeiroNome,
        String sobreNome,
        String email,
        String senha) {
}
