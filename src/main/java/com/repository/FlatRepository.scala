package com.repository

import com.model.Flat
import org.springframework.data.jpa.repository.JpaRepository

trait FlatRepository extends JpaRepository[Flat, Long]{

}
