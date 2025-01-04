package com.grinder.domain.member.entity;

import com.grinder.common.annotation.Name;
import com.grinder.common.entity.BaseDateEntity;
import com.grinder.domain.member.model.LoginType;
import com.grinder.domain.member.model.Member;
import com.grinder.domain.member.model.MemberBasicInfo;
import com.grinder.domain.member.model.MemberOauth;
import com.grinder.domain.member.model.TierType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class MemberEntity extends BaseDateEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoginType loginType;

    @Enumerated(EnumType.STRING)
    private TierType tier;

    @Name(name = "결제정보 연관 관계")
    private Long PaymentInfoId;

    @Name(name = "카페 관리자 연관 관계")
    private Long CafeAdminId;

    @Name(name = "삭제 여부")
    private boolean isDeleted;

    public MemberBasicInfo toBasicInfo() {
        return MemberBasicInfo.builder()
                .id(id)
                .email(email)
                .phoneNumber(phoneNumber)
                .tier(tier)
                .build();
    }

    public Member toMember() {
        return Member.builder()
                .id(id)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .loginType(loginType)
                .tier(tier)
                .PaymentInfoId(PaymentInfoId)
                .CafeAdminId(CafeAdminId)
                .isDeleted(isDeleted)
                .build();
    }

//    public MemberOauth toMemberAuth() {
//        return MemberOauth.builder()
//                .email(email)
//                .loginType(loginType)
//                .tier(tier)
//                .build();
//    }

    @Builder(builderClassName = "SocialMemberBuilder", builderMethodName = "socialBuilder")
    public MemberEntity(String email, LoginType loginType, TierType tier, boolean isDeleted) {
        this.email = email;
        this.loginType = loginType;
        this.tier = tier;
        this.isDeleted = isDeleted;
    }

    @Builder(builderClassName = "CommonMemberBuilder", builderMethodName = "commonBuilder")
    public MemberEntity(String email, String password, String phoneNumber,TierType tier,LoginType loginType,boolean isDeleted) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.loginType = loginType;
        this.tier = tier;
        this.isDeleted = isDeleted;
    }
}
