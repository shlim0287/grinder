package com.grinder.domain.member.repository;

import com.grinder.domain.member.entity.MemberEntity;
import com.grinder.domain.member.model.LoginType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByEmail(String email);
    Optional<MemberEntity> findByEmailAndLoginType(String email, LoginType loginType);

    boolean existsByEmail(String email);
}
