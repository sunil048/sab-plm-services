package com.sabtok.plm.dao;

import com.sabtok.plm.entity.BucketTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketTaskDao extends JpaRepository<BucketTask, String > {
}
