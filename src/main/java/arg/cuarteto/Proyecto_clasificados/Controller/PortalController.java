package arg.cuarteto.Proyecto_clasificados.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {
    @GetMapping("/")
    public String inicio(){
        return"index.html";
    }
}
