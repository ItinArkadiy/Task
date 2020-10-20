package com.service

import com.repository.FlatRepository
import com.model.Flat
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import scala.io.Source

@Service
@Transactional
class MyService(flatRepository: FlatRepository) {
  def downloadData(): String = {
    try {
      val csv = Source.fromURL("https://server-assignment.s3.amazonaws.com/listing-details.csv").getLines.toList
      val res = csv.tail.map {
        case s"$id,$street,$status,$price,$bedrooms,$bathrooms,$sq_ft,$lat,$lng" => Right(Flat(id.toLong,
          street,
          status,
          price.toLong,
          bedrooms.toInt,
          bathrooms.toInt,
          sq_ft.toInt,
          lat.toDouble,
          lng.toDouble))
        case line => Left(s"Cannot read '$line'")
      }
      "Data downloaded"
    } catch {
      case e: Exception => "Download Error"
    }
  }
}
