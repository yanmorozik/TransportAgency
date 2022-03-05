package eu.morozik.transportagency.specification.firstrealization;

import eu.morozik.transportagency.model.Driver;
import eu.morozik.transportagency.specification.secondrealization.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class DriverSpecification {

    public static Specification<Driver> driverFirstNameIs (final String firstName) {
        return new Specification<Driver>() {
            @Override
            public Predicate toPredicate(Root<Driver> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("firstName"), firstName);
            }
        };
    }
}
