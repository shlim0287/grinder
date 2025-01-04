package com.grinder.domain.cafe.implement;

import com.grinder.domain.cafe.model.Cafe;
import com.grinder.domain.cafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CafeReader {
    private final CafeRepository cafeRepository;

    public Cafe read(Long id) {
        return cafeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 카페가 존재하지 않습니다.")
        ).toBasicInfo();
    }

}
