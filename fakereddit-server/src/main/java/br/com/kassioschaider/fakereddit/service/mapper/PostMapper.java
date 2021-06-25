package br.com.kassioschaider.fakereddit.service.mapper;

import br.com.kassioschaider.fakereddit.model.Post;
import br.com.kassioschaider.fakereddit.service.dto.PostDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface PostMapper extends EntityMapper<PostDTO, Post>{
}
