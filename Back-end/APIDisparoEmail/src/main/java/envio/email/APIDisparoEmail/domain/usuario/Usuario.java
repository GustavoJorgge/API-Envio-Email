package envio.email.APIDisparoEmail.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "usuarios")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = "id")
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primeiroNome")
    private String primeiroNome;

    @Column(name = "sobreNome")
    private String sobreNome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    public Usuario(DadosCadastroUsuario dados) {
        this.primeiroNome = dados.primeiroNome();
        this.sobreNome = dados.sobreNome();
        this.email = dados.email();
        this.senha = dados.senha();
    }
}
