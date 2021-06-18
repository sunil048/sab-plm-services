/**
 * 
 */
package com.sabtok.plm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabtok.plm.entity.Records;

/**
 * @author Sunil
 *
 * RecordDao.java Jun 17, 2021 9:08:23 PM
 */
public interface RecordDao extends JpaRepository<Records, Long> {

}
