package me.plich.cashregistersystem.repository;

import me.plich.cashregistersystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    List<Order> findByUser_id(Long user_id);
    List<Order> findByUser_idAndDevice_id(Long user_id, Long device_id);
}

