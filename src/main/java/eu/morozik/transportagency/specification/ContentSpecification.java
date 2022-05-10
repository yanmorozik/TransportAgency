package eu.morozik.transportagency.specification;

import eu.morozik.transportagency.model.Content;
import eu.morozik.transportagency.model.Driver;
import eu.morozik.transportagency.specification.GenericSpecification;
import eu.morozik.transportagency.specification.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ContentSpecification extends GenericSpecification<Content> {
    public ContentSpecification(SearchCriteria criteria) {
        super(criteria);
    }
}
