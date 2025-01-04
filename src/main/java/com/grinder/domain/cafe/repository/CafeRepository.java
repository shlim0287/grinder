package com.grinder.domain.cafe.repository;

import com.grinder.domain.cafe.entity.CafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends JpaRepository<CafeEntity, Long> {
}
