package me.plich.cashregistersystem.repository;

import me.plich.cashregistersystem.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>, JpaSpecificationExecutor<Device> {
    List<Device> findByUser_IdAndCustomer_Id(Long user_id, Long customer_id);
    List<Device> findByUser_IdAndLocation_Id(Long user_id, Long location_id);
    List<Device> findByUser_Id(Long user_id);

}
