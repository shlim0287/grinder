package com.grinder.domain.order.repository;

import com.grinder.domain.order.entity.OrderMenuInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMenuInfoRepository extends JpaRepository<OrderMenuInfo, Long> {
}
