package uz.example.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.NoSuchElementException;

/**
 * Me: muhammadqodir
 * Project: SpringMyProject/IntelliJ IDEA
 * Date:Mon 24/10/22 14:43
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(HttpServletRequest request, Exception ex) {
        log.info("SQLException Occured:: URL=" + request.getRequestURL());
        return "database_error";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = " Bu login va paroldagi Doctor topilmadi ")
    @ExceptionHandler(DoctorNotFoundException.class)
    public void handleDoctorNotFoundException() {
        log.error("DoctorNotFoundException handler executed");
//        model.addAttribute("error", "Doctor not found");
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = " Ushbu kunlarda hisobotlar yo'q ")
    @ExceptionHandler(NoSuchElementException.class)
    public void noSuchElementException() {
        log.error("NoSuchElementException handler executed");
//        model.addAttribute("error", "Doctor not found");
    }
}