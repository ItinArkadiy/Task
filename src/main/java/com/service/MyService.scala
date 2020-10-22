package com.service

import com.model.Flat
import com.repository.FlatRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import scala.io.Source


@Service
class MyService(flatRepository: FlatRepository) {

  @Transactional
  def downloadData(): String = {
    val source = Source.fromURL("https://server-assignment.s3.amazonaws.com/listing-details.csv")
    val csv = source.getLines().toList
    source.close()
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
    res.foreach(x => flatRepository.save(x match {
      case Right(x) => x
      case Left(x) => throw new RuntimeException("Download Error")
    }))
    "Data downloaded"
  }

  def getFlats(page: Int, pageSize: Int, status: java.util.List[String], priceMax: Long, priceMin: Long, bedroomsMin: Int, bedroomsMax: Int,
               bathroomsMin: Int, bathroomsMax: Int): java.util.List[Flat] = {
    val pageable = PageRequest.of(page, pageSize)

    if (status.isEmpty) {
      val pageResult = flatRepository.findByPriceBetweenAndBedroomsBetweenAndBathroomsBetween(priceMin, priceMax, bedroomsMin,
        bedroomsMax, bathroomsMin, bathroomsMax, pageable)
      pageResult.getContent
    } else {
      val pageResult = flatRepository.findByStatusInAndPriceBetweenAndBedroomsBetweenAndBathroomsBetween(status, priceMin, priceMax, bedroomsMin,
        bedroomsMax, bathroomsMin, bathroomsMax, pageable)
      pageResult.getContent
    }
  }


}
