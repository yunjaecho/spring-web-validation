package com.yunjea.springwebvalidation;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Validated // 해당 컨트롤러의 모든 메소드에 validate (javax.validation.ConstraintViolationException)
public class SampleController {

    @GetMapping("/hey")
    // Spring @RequestParam Vailidate(@NotEmpty, @Min(0)) 처리 하지 않음
    public String hey(@NotEmpty String name, @Min(0) Integer age) {
        System.out.println("name : " + name);
        System.out.println("age : " + age);
        return "hey";
    }

    /**
     * 에러 핸들러 (추전 하지 않음)
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map handle(ConstraintViolationException e) {
        List<String> errors = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());

        return Collections.singletonMap("error", errors);
    }
}
