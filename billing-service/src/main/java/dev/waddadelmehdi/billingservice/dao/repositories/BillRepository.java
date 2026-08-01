package dev.waddadelmehdi.billingservice.dao.repositories;

import dev.waddadelmehdi.billingservice.dao.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {

}
