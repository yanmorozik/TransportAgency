package eu.morozik.transportagency.service;

import eu.morozik.transportagency.api.dao.ContentDao;
import eu.morozik.transportagency.api.service.ContentService;
import eu.morozik.transportagency.converter.ContentConverter;
import eu.morozik.transportagency.dto.ContentDto;
import eu.morozik.transportagency.model.Content;
import eu.morozik.transportagency.specification.SearchCriteria;
import eu.morozik.transportagency.specification.contentspecification.ContentSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {

    public final ContentDao contentDao;

    public final ContentConverter contentConverter;

    @Override
    public ContentDto save(ContentDto contentDto) {
        Content content = contentConverter.convert(contentDto);
        Content response = contentDao.save(content);
        return contentConverter.convert(response);
    }

    @Override
    public ContentDto findById(Long id) throws Exception {
        Content response = contentDao.findById(id).orElseThrow(Exception::new);
        return contentConverter.convert(response);
    }

    @Override
    public List<ContentDto> findAll() {
        List<Content> contents = contentDao.findAll();
        return contentConverter.convert(contents);
    }

    @Override
    public void deleteById(Long id) {
        contentDao.deleteById(id);
    }

    @Override
    public List<ContentDto> findByAnyFieldWithSpecification(String key,String operation,String value) {
        ContentSpecification contentSpecification = new ContentSpecification(new SearchCriteria(key,operation,value));
        List<Content> contents = contentDao.findAll(contentSpecification);
        return contentConverter.convert(contents);
    }
}
