package com.model

import javax.persistence._

@Entity
@Table(name = "Flats")
class Flat(@Id var id: Long,
           var street: String,
           var status: String,
           var price: Long,
           var bedrooms: Int,
           var bathrooms: Int,
           var sq_ft: Int,
           var lat: Double,
           var lng: Double) {


  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long = _



  private def this() = this(0, null, null, 0, 0, 0, 0, 0, 0)
}





