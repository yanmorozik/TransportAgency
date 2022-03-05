package eu.morozik.transportagency.converter;

import eu.morozik.transportagency.dto.ContentDto;
import eu.morozik.transportagency.model.Content;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ContentConverter extends Converter <Content, ContentDto>{
    public ContentConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
