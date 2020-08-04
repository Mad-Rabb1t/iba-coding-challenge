package app.security;


import app.entity.InvalidJsonRequestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/error")
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidJsonRequestException.class)
    public String handleUnexpectedException(InvalidJsonRequestException ex) {
        log.error(ex.getMessage());
        return "invalid-parameters-page";
    }
}
