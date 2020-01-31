package com.example.idempotencia;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/idem")
public class IdempotenciaController {

    @GetMapping
    public ResponseEntity getIdempotencia(@RequestHeader("transactionId") String transactionId,
                                          @RequestHeader("canal") String canal) {
        return ResponseEntity.status(HttpStatus.OK).header("transactionCompletede", transactionId).build();
    }
}
