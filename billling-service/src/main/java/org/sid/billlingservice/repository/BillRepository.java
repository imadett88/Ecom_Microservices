package org.sid.billlingservice.repository;

import org.sid.billlingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}