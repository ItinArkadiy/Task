package com

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application {
}

object Main {
  def main(args: Array[String]): Unit = {
    SpringApplication run classOf[Application]
  }
}
