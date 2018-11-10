package me.plich.cashregistersystem.repository;

import me.plich.cashregistersystem.model.Serviceman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicemanRepository extends JpaRepository<Serviceman, Long> {
    List<Serviceman> findByUser_id(Long user_id);
}
