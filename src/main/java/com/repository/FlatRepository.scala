package com.repository

import com.model.Flat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

trait FlatRepository extends JpaRepository[Flat, Long]{

}
