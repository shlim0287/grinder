package com.grinder.domain.tabling.service;

import com.grinder.domain.tabling.repository.TablingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TablingService {
    private final TablingRepository tablingRepository;
}
