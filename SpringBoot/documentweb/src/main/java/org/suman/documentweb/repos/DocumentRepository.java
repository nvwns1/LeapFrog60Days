package org.suman.documentweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.suman.documentweb.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
