package com.repository;

import com.model.Flat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepository extends JpaRepository<Flat, Long> {

    Page<Flat> findByStatus (String status, Pageable pageable);

    Page<Flat> findByPriceBetween (Long from, Long to, Pageable pageable);

    Page<Flat> findByPriceGreaterThan (Long min, Pageable pageable);

    Page<Flat> findByPriceLessThanEqual (Long max, Pageable pageable);









}
