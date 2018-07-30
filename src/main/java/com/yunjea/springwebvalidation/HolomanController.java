package com.yunjea.springwebvalidation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HolomanController {

    @GetMapping("/holoman")
    // @Valid 지정 필요
    // BindingResult Valid 오류를 잡아서 처리 할수 있음
    public ResponseEntity holoman(@Valid Holoman holoman, BindingResult error) {
        System.out.println(holoman);
        // custom validation
        if (error.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        System.out.println("name : " + holoman.getName());
        System.out.println("age : " + holoman.getAge());
        return ResponseEntity.ok("hey");
    }
}
