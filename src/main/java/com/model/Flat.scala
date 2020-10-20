package com.model

import javax.persistence._

@Entity
@Table(name = "Flats")
class Flat( idC: Long,
            streetC: String,
            statusC: String,
            priceC: Long,
            bedroomsC: Int,
            bathroomsC: Int,
            sq_ftC: Int,
            latC: Double,
            lngC: Double) {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Int = _

  var street: String = streetC
  var status: String = statusC
  var price: Long = priceC
  var bedrooms: Int = bedroomsC
  var bathrooms: Int = bathroomsC
  var sq_ft: Int = sq_ftC
  var lat: Double = latC
  var lng: Double = lngC


  def this() = this(0, null, null, 0, 0, 0, 0, 0, 0)
}








