package br.com.kassioschaider.fakereddit.config.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorValidationHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorFormDTO> handle(MethodArgumentNotValidException exception) {
        List<ErrorFormDTO> errorsFormDTO = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorFormDTO error = new ErrorFormDTO(fieldToTitle(e.getField()), message);
            errorsFormDTO.add(error);
        });

        return errorsFormDTO;
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public List<ErrorFormDTO> handle(NoSuchElementException exception) {
        List<ErrorFormDTO> errorsFormDTO = new ArrayList<>();
        ErrorFormDTO error = new ErrorFormDTO("PostId", exception.getMessage());
        errorsFormDTO.add(error);

        return errorsFormDTO;
    }

    private String fieldToTitle(String field) {
        if ("content".equals(field)) {
            return "Content";
        }
        return field;
    }
}
