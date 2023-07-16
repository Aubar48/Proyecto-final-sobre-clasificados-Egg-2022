package arg.cuarteto.Proyecto_clasificados.Service;


import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EnvioMail {


@Autowired 
private JavaMailSender msj;

@Async
public void enviarMail(String mail, String titulo, String descripcion){
  
    SimpleMailMessage mensaje= new SimpleMailMessage();
    mensaje.setTo(mail);
    mensaje.setFrom("ALGUIEN");
    mensaje.setSubject(titulo);
    mensaje.setText(descripcion);
    mensaje.setSentDate(new Date());
    msj.send(mensaje);
}




    
}
