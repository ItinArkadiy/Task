package com.controller

import com.service.MyService
import org.springframework.web.bind.annotation.{GetMapping, RestController}

@RestController
class TaskController(val myService: MyService) {

  @GetMapping(value = Array("/start"))
  def downloadData(): String = {
    myService.downloadData()
  }


}
