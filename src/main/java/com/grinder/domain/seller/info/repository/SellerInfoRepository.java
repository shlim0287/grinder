package com.grinder.domain.seller.info.repository;

import com.grinder.domain.seller.info.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerInfoRepository extends JpaRepository<SellerInfo, Long> {
}
