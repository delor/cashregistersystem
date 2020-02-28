package me.plich.cashregistersystem.repository;

import me.plich.cashregistersystem.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByUser_idAndCustomer_id(Long user_id, Long customer_id);
    List<Location> findByUser_id(Long user_id);
}
