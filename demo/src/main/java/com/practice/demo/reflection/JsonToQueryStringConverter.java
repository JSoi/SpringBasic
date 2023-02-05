package com.practice.demo.reflection;

import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JsonToQueryStringConverter {
    Function<String, String> jsonStrMapper = a -> "{" + a + "}";
    
    public  static <T> String convert(@NotNull List<T> src, Class<T> T) { // generic provides arraylist only
        return src.stream().map(t -> {
                    try {
                        return getJsonObjStr(t, T);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).filter(t->!t.isBlank())
                .collect(Collectors.joining(",", "[", "]"));
    }
    public static <T> String getJsonObjStr(T src, Class<T> clazz) throws IllegalAccessException {
        Field[] declaredFields = clazz.getDeclaredFields();
        LinkedHashMap<String, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
        return Arrays.stream(declaredFields).map(field -> {
                    boolean access = field.canAccess(src);
                    field.setAccessible(true);
                    try {
                        if (field.get(src) == null) return null;
                        String result = "\"" + field.getName() + "\":\"" + field.get(src) + "\"";
                        field.setAccessible(access);
                        return URLEncoder.encode(result, StandardCharsets.UTF_8);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .filter(Objects::nonNull)
                .map(addbraclet -> "{" + addbraclet +"}")
                .collect(Collectors.joining(","));
    }
}

