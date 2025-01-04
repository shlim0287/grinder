package com.grinder.domain.seller.apply.repository;

import com.grinder.domain.seller.apply.entity.SellerApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerApplyRepository extends JpaRepository<SellerApply, Long> {
}
