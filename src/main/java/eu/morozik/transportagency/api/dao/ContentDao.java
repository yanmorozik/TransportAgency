package eu.morozik.transportagency.api.dao;

import eu.morozik.transportagency.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContentDao extends JpaRepository<Content,Long>, JpaSpecificationExecutor<Content> {
}
