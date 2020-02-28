package me.plich.cashregistersystem.repository;

import me.plich.cashregistersystem.model.Address;
import me.plich.cashregistersystem.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
