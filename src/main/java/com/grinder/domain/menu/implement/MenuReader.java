package com.grinder.domain.menu.implement;

import com.grinder.domain.menu.entity.MenuEntity;
import com.grinder.domain.menu.entity.OptionEntity;
import com.grinder.domain.menu.model.Menu;
import com.grinder.domain.menu.repository.MenuRepository;
import com.grinder.domain.menu.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MenuReader {
    private final MenuRepository menuRepository;
    private final OptionRepository optionRepository;

    public Menu read(Long menuId) {
        return menuRepository.findById(menuId).orElseThrow(
                () -> new IllegalArgumentException("해당 메뉴가 존재하지 않습니다.")
        ).toMenu();
    }

    public List<Menu> readAll(List<Long> menuIds) {
        return menuRepository.findAllById(menuIds).stream().map(MenuEntity::toMenu).collect(Collectors.toList());
    }

    public void changeLockMenu(Long menuId) {
        Menu menu = this.read(menuId);
        this.changeLockMenu(menuId, menu.isLockYn());
    }

    public void changeLockMenu(Long menuId, boolean lockYn) {
        menuRepository.changeLockMenu(menuId, !lockYn);
    }

    @Transactional
    public void createSeasonMenu(Long price, String description, Long imageId, Long cafeId) {
        this.createMenu(price, description, Integer.MAX_VALUE, imageId, cafeId, true);
    }

    @Transactional
    public void createSeasonMenu(Long price, String description, int stock, Long imageId, Long cafeId) {
        this.createMenu(price, description, stock, imageId, cafeId, true);
    }

    @Transactional
    public void createMenu(Long price, String description, int stock, Long imageId, Long cafeId, boolean seasonYn) {
        int count = menuRepository.countByCafeId(cafeId);
        this.createMenu(price, description, stock, count + 1, imageId, cafeId, seasonYn);
    }

    @Transactional
    public void createMenu(Long price, String description, int stock, int sequence, Long imageId, Long cafeId, boolean seasonYn) {
        menuRepository.save(MenuEntity.builder()
                        .price(price)
                        .description(description)
                        .stock(stock)
                        .sequence(sequence)
                        .imageId(imageId)
                        .cafeId(cafeId)
                        .seasonYn(seasonYn)
                .build());
    }

    @Transactional
    public void modifyMenu(Long menuId, Long price) {
        this.modifyMenu(menuId, price, null, null, null, null);
    }

    @Transactional
    public void modifyMenu(Long menuId, String description) {
        this.modifyMenu(menuId, null, description, null, null, null);
    }

    @Transactional
    public void modifyMenu(Long menuId, Long price, String description, Integer stock, Integer sequence, Long imageId) {
        MenuEntity menuEntity = menuRepository.findById(menuId).orElseThrow(
                () -> new IllegalArgumentException("해당 메뉴가 존재하지 않습니다.")
        );

        Optional.ofNullable(price).ifPresent(menuEntity::setPrice);
        Optional.ofNullable(description).ifPresent(menuEntity::setDescription);
        Optional.ofNullable(stock).ifPresent(menuEntity::setStock);
        Optional.ofNullable(sequence).ifPresent(menuEntity::setSequence);
        Optional.ofNullable(imageId).ifPresent(menuEntity::setImageId);
    }

    @Transactional
    public void deleteMenu(Long menuId) {
        menuRepository.deleteById(menuId);
    }

    @Transactional
    public void addOption(Long menuId, String optionName, Long price) {
        optionRepository.save(OptionEntity.builder()
                .menuId(menuId)
                .name(optionName)
                .price(price)
                .build());
    }
}
