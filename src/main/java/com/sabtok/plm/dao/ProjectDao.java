/**
 * 
 */
package com.sabtok.plm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabtok.plm.entity.Project;

/**
 * @author Sunil
 *
 * ProjectDao.java Aug 9, 2020 5:31:53 PM
 */
@Repository
public interface ProjectDao extends JpaRepository<Project, String> {

}
