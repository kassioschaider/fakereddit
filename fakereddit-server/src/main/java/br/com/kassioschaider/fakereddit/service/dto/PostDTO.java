package br.com.kassioschaider.fakereddit.service.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PostDTO {

    private Long id;

    @NotEmpty(message = "Can not be empty!")
    @Length(min = 3, message = "Must have at least 3 characters!")
    private String content;

    @NotNull(message = "It cannot be null!")
    private int upvotes;
}
