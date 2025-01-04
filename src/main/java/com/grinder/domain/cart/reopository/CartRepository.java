package com.grinder.domain.cart.reopository;

import com.grinder.domain.cart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    boolean existsByMemberIdAndCafeIdAndIsOrderedIsFalse(Long memberId, Long cafeId);

    Optional<CartEntity> findByMemberIdAndCafeIdAndIsOrderedIsFalse(Long memberId, Long cafeId);

    Optional<CartEntity> findByMemberIdAndIsOrderedIsFalse(Long memberId);

    @Modifying
    @Query("update CartEntity c set c.cafeId = :cafeId where c.id = :cartId and c.isOrdered = false")
    void updateCafeId(Long cartId, Long cafeId);
}
