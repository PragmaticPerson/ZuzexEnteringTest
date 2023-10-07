package com.zuzex.jpa;

import com.zuzex.service.models.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseJpaRepository extends JpaRepository<House, Integer> {
}
