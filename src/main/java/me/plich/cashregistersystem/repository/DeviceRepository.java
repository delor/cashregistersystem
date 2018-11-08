package me.plich.cashregistersystem.repository;

import me.plich.cashregistersystem.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findByUser_idAndCustomer_id(Long user_id, Long customer_id);
    List<Device> findByUser_id(Long user_id);
}
