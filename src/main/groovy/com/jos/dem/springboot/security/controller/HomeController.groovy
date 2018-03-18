package com.jos.dem.springboot.security.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller
class HomeController {

  Logger log = LoggerFactory.getLogger(this.class)

  @RequestMapping('/')
  String index(){
    log.info 'Calling Index'
    'index'
  }

}
