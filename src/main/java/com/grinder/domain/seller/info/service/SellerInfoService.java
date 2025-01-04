package com.grinder.domain.seller.info.service;

import com.grinder.domain.seller.info.repository.SellerInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SellerInfoService {
    private final SellerInfoRepository sellerInfoRepository;
}
