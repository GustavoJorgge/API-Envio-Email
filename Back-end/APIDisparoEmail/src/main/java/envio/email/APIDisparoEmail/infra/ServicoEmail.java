package envio.email.APIDisparoEmail.infra;

import envio.email.APIDisparoEmail.domain.usuario.DadosCadastroUsuario;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class ServicoEmail {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${support.mail}") //recuperando o e-mail do suporte para realizar envio
    private String supportMail;

    public void envioEmailCadastro(String assunto, String email, String nome) throws MessagingException{
        MimeMessage mail = mailSender.createMimeMessage(); //Esta instância será usada para construir o e-mail.

        String conteudo = getSupportMail(nome);

        MimeMessageHelper mensagem = new MimeMessageHelper(mail);
        mensagem.setSubject(assunto);
        mensagem.setText(conteudo, true);
        mensagem.setFrom(supportMail);
        mensagem.setTo(email);

        mailSender.send((MimeMessagePreparator) mensagem);
    }

    public String getSupportMail(String nome){

        return "<p>" + nome + "! Como vai??</p>\n" +
                "<p>Muito obrigado por cadastrar-se em nossa plataforma!!</p>";
    }

}
