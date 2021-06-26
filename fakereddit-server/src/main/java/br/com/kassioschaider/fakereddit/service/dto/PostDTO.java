package br.com.kassioschaider.fakereddit.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Long id;

    @NotEmpty(message = "Can not be empty!")
    @Length(min = 3, message = "Must have at least 3 characters!")
    private String content;

    private int upvotes;
}
