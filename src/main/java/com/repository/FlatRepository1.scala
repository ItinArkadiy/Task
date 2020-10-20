package com.repository

import java.awt.print.Pageable

import com.model.Flat
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository

trait FlatRepository1 extends JpaRepository[Flat, Long]{



}
