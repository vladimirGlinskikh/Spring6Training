package kz.zhelezyaka.spring6Training_5.controller;

import kz.zhelezyaka.spring6Training_5.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
//@ControllerAdvice
public class ExceptionController {

//    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException() {
        log.info("This exception handler is called from ExceptionController.class");
        return ResponseEntity.notFound().build();
    }
}
