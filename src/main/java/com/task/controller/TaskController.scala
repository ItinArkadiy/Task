package com.task.controller

import com.service.MyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RestController}

@RestController
class TaskController (val myService: MyService) {

  @GetMapping(value = Array("/start"))
  def downloadData():String = {
    myService.downloadData("https://server-assignment.s3.amazonaws.com/listing-details.csv")
  }


}
