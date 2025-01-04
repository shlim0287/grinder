package com.grinder.domain.order.service;

import com.grinder.domain.order.repository.OrderMenuInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderMenuInfoService {
    private final OrderMenuInfoRepository orderMenuInfoRepository;
}
