package eu.morozik.transportagency.api.service;

import eu.morozik.transportagency.dto.ContentDto;

import java.util.List;

public interface ContentService {

    ContentDto save(ContentDto contentDto);

    ContentDto findById(Long id) throws Exception;

    List<ContentDto> findAll();

    void deleteById(Long id);

    List<ContentDto> findByAnyFieldWithSpecification(String key, String operation, String value);
}
