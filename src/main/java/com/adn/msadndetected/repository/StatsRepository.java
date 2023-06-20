package com.adn.msadndetected.repository;

import com.adn.msadndetected.entity.StatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends JpaRepository<StatsEntity, Long> {
}
