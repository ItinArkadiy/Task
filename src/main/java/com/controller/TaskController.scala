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
               @RequestParam(value = "status", defaultValue = "") status: java.util.List[String],
               @RequestParam(value = "priceMax", defaultValue = "9999999") priceMax: Long,
               @RequestParam(value = "priceMin", defaultValue = "0") priceMin: Long,
               @RequestParam(value = "bedroomsMin", defaultValue = "0") bedroomsMin: Int,
               @RequestParam(value = "bedroomsMax", defaultValue = "1000") bedroomsMax: Int,
               @RequestParam(value = "bathroomsMin", defaultValue = "0") bathroomMin: Int,
               @RequestParam(value = "bathroomsMax", defaultValue = "1000") bathroomMax: Int,
              ): java.util.List[Flat] = {
    myService getFlats(page, pageSize, status, priceMax, priceMin, bedroomsMin, bedroomsMax, bathroomMin, bathroomMax)
  }



}
