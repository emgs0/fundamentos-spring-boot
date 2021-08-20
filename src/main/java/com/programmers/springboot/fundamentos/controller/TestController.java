package com.programmers.springboot.fundamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping //acepta solicitudes http
    @ResponseBody   //envia respuesta body http
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("hello from controller", HttpStatus.OK);
    }
}
