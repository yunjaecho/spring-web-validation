package com.yunjea.springwebvalidation;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class Holoman {
    @Min(0)
    private Integer age;

    @NotEmpty
    private String name;
}
