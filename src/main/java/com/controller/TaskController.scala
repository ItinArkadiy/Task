package com.controller

import com.model.Flat
import com.service.MyService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.{GetMapping, RequestParam, RestController}

@RestController
class TaskController(val myService: MyService) {

  @GetMapping(value = Array("/start"))
  def downloadData(): String = {
    myService.downloadData()
  }

  @GetMapping(value = Array("/listings"))
  def getFlats(@RequestParam(value = "page", defaultValue = "0") page: Int,
               @RequestParam(value = "pageSize", defaultValue = "100") pageSize: Int,
               @RequestParam(value = "status", defaultValue = "") status: String,
               @RequestParam(value = "max", defaultValue = "0") max: Long,
               @RequestParam(value = "min", defaultValue = "0") min: Long,
              ): Unit = {
    println(myService getFlats(page, pageSize, status, max, min))
  }







}
