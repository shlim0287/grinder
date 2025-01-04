package com.grinder.domain.seller.apply.service;

import com.grinder.domain.seller.apply.repository.SellerApplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SellerApplyService {
    private final SellerApplyRepository sellerApplyRepository;
}
