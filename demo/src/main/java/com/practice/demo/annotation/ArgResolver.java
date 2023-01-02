package com.practice.demo.annotation;

import com.practice.demo.dto.ArgDto;
import com.practice.demo.entity.ArgEntity;
import com.practice.demo.mapper.ArgMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Slf4j
public class ArgResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean b = parameter.hasParameterAnnotation(Arg.class)
                && ArgDto.class.isAssignableFrom(parameter.getParameterType());
        log.warn("Parameter support: {}", b);
        return b;
        // 어노테이션이 달려 있는지, 파라미터 타입이 ArgEntity인지 확인한다.
    }
    
    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {
        // 위의 SupportsParameter에서 true를 반환하면 이 메소드가 실행된다.
        // 만약 Security 관련해서 정보가 있다면 여기서 처리한다
        // Request에 관련된 처리가 들어가기 때문에 주로 인증 영역에서 많이 활용하는듯
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String authorization = request.getHeader("Authorization");
        ArgMapper argMapper = ArgMapper.INSTANCE;
        ArgEntity argEntity = argMapper.toEntity(ArgDto.builder().userId(authorization).build());
        log.warn("argEntity: {}", argEntity);
        return ArgDto.builder().userId("hehe").name("Custom Test Name").build();
    }
}
