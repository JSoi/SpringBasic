package com.practice.demo.mvc.validator;

import com.practice.demo.mvc.annotation.ArgReq;
import com.practice.demo.mvc.dto.ArgDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArgValidator implements ConstraintValidator<ArgReq, ArgDto> {
    @Override
    public boolean isValid(ArgDto argDto, ConstraintValidatorContext context) {
        // custom validation logic
        boolean lengthVal = argDto.getName().length() > 3;
        log.warn("the length: {}", lengthVal);
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("name length must be greater than 3")
                .addPropertyNode("name")
                .addConstraintViolation();
        return lengthVal;
        // 이 정도 validation은 커스텀 annotation보다는 기존의 validation을 사용하는게 좋다.
        // 하지만 예제니까!
    }
    
    @Override
    public void initialize(ArgReq constraintAnnotation) {
        log.info("validation works : {}", this.getClass().getName());
    }
}
