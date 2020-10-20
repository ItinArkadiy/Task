package com.service

import org.springframework.stereotype.Service

@Service
class MyServiceImpl extends MyService {

  override def downloadData(url: String): String = {
    try {
      val src = scala.io.Source.fromURL(url)
      val out = new java.io.FileWriter("src/main/resources/data.csv")
      out.write(src.mkString)
      out.close()
      "Data downloaded"
    } catch {
      case e: Exception => "Download Error"
    }
  }
}
