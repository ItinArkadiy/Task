package com.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence._

@Entity
@Table(name = "Flats")
case class Flat ( idC: Long,
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
  @JsonProperty
  var id: Long = idC

  @JsonProperty
  var street: String = streetC
  @JsonProperty
  var status: String = statusC
  @JsonProperty
  var price: Long = priceC
  @JsonProperty
  var bedrooms: Int = bedroomsC
  @JsonProperty
  var bathrooms: Int = bathroomsC
  @JsonProperty
  var sq_ft: Int = sq_ftC
  @JsonProperty
  var lat: Double = latC
  @JsonProperty
  var lng: Double = lngC



  def this() = this(0, null, null, 0, 0, 0, 0, 0, 0)
}








