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
    try {
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
        case Left(x) => throw new RuntimeException
      }))
      "Data downloaded"
    } catch {
      case e: Exception => "Download Error"
    }
  }

  def getFlats(page: Int, pageSize: Int, status: String, max: Long, min: Long): java.util.List[Flat]  = {
    val pageable = PageRequest.of(page, pageSize)
    if (status.length == 0){
      val pageResult = flatRepository.findByPriceBetween(min, max, pageable)
      println(pageResult.getContent)
      pageResult.getContent
    } else {
      val pageResult = flatRepository.findByStatusAndPriceBetween(status, min, max, pageable)
      pageResult.getContent
    }
  }

}
