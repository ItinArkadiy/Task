package com.repository;

import com.model.Flat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlatRepository extends JpaRepository<Flat, Long> {

    Page<Flat> findByStatusInAndPriceBetweenAndBedroomsBetweenAndBathroomsBetween(List<String> status, Long priceFrom, Long priceTo, Integer bedroomFrom,
                                                                                  Integer bedroomTo, Integer bathroomFrom,
                                                                                  Integer bathroomTo, Pageable pageable);

    Page<Flat> findByPriceBetweenAndBedroomsBetweenAndBathroomsBetween(Long priceFrom, Long priceTo, Integer bedroomFrom,
                                                                       Integer bedroomTo, Integer bathroomFrom,
                                                                       Integer bathroomTo, Pageable pageable);




}
