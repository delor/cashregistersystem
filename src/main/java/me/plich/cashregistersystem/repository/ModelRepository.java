package me.plich.cashregistersystem.repository;

import me.plich.cashregistersystem.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ModelRepository extends JpaRepository<Model, Long> {
}
