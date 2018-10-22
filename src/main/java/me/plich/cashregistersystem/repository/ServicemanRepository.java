package me.plich.cashregistersystem.repository;

import me.plich.cashregistersystem.model.Serviceman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicemanRepository extends JpaRepository<Serviceman, Long> {
}
