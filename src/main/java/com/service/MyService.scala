package com.service

import com.model.Flat
import com.repository.FlatRepository
import org.springframework.data.domain.{Page, PageRequest}
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
        case s"$id,$street,$status,$price,$bedrooms,$bathrooms,$sq_ft,$lat,$lng" => Right(new Flat(id.toLong,
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

  def getFlats(page: Int, pageSize: Int, status: String, max: Long, min: Long): Page[Flat]  = {
    val pageable = PageRequest.of(page, pageSize)
  //  if (status.length == 0){
      val pageResult = flatRepository.findAll(pageable)
      pageResult
  //  }
  }

//  def getFlatsBetweenValue (page: Int, pageSize: Int, status: String, from : Long, to : Long): Unit = {
//    val pageable = PageRequest.of(page, pageSize);
//    flatRepository.findByPriceBetween(from, to, pageable)
//  }
//
//
//
//  private def flatToJson(event: Flat):String = {
//    val out = new StringWriter
//    mapper.writeValue(out, event)
//    out.toString
//  }

}
