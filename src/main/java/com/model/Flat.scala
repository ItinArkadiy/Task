package com.model

import javax.persistence._

  @Entity
  @Table(name = "Flats")
  case class Flat(id: Long,
                            street: String,
                            status: String,
                            price: Long,
                            bedrooms: Int,
                            bathrooms: Int,
                            sq_ft: Int,
                            lat: Double,
                            lng: Double){

    private def this() = this(0, null, null, 0, 0, 0, 0, 0, 0)
  }





