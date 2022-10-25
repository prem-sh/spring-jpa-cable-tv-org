package com.premsh.jpaexperiment.data.userbase.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.premsh.jpaexperiment.data.userbase.models.PurchaseOrder;

@Repository
public interface PurchaseOrdersRepository extends JpaRepository<PurchaseOrder, Integer> {

}
