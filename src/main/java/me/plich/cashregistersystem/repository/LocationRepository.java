package me.plich.cashregistersystem.repository;

import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface LocationRepository extends JpaRepository<Location, Long> {

}
