package br.com.kassioschaider.fakereddit.config.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorFormDTO {

    private String field;
    private String error;
}
