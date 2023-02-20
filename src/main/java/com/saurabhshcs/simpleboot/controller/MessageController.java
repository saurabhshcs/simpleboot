package com.saurabhshcs.simpleboot.controller;


import com.saurabhshcs.simpleboot.model.StringResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class MessageController
{
    @GetMapping("/defaultHello")
    public ResponseEntity<StringResponse> getMessage(@RequestParam (required = false) String message){
        if(Strings.isNotBlank(message)){
            log.info("___Hello {}", message);
            return ResponseEntity.ok (StringResponse.builder().echo("Hello " + message).build());
        }
        return ResponseEntity.ok(StringResponse.builder().echo("Hello World!").build());
    }

//    @PostMapping(value = "/customHello", produces = "application/json")
//    public ResponseEntity customMessage(@RequestBody String message){
//        log.info("Hello {}", message);
//        if (Strings.isNotBlank(message)){
//            return ResponseEntity.ok("Hello " + message);
//        }
//        log.info("Message information is not present in the request {}", message);
//        return (ResponseEntity) ResponseEntity.notFound();
//
//    }
}
