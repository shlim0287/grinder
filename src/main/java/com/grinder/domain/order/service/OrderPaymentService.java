package com.grinder.domain.order.service;

import com.grinder.domain.order.repository.OrderPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderPaymentService {
    private final OrderPaymentRepository orderPaymentRepository;
}