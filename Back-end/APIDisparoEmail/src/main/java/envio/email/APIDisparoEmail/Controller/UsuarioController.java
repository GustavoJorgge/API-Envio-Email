package envio.email.APIDisparoEmail.Controller;

import envio.email.APIDisparoEmail.domain.usuario.DadosCadastroUsuario;
import envio.email.APIDisparoEmail.domain.usuario.Usuario;
//import envio.email.APIDisparoEmail.domain.usuario.UsuarioRepository;
import envio.email.APIDisparoEmail.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("cadastro")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroUsuario dados){
        var usuario = new Usuario(dados);
        repository.save(usuario);
        System.out.println(usuario);
    }

}
