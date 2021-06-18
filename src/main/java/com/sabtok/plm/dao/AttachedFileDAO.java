/**
 * 
 */
package com.sabtok.plm.dao;

import java.util.Optional;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabtok.plm.entity.AttachedFile;

/**
 * @author Sunil
 *
 * AttachedFileDAO.java Aug 5, 2020 4:23:47 PM
 */
@Repository
public interface AttachedFileDAO extends JpaRepository<AttachedFile, Integer> {
	Optional<AttachedFile> findByDocumentName(String documentName);
	Optional<AttachedFile> findByParentIdAndDocumentName(String parentId, String documentName);
}
