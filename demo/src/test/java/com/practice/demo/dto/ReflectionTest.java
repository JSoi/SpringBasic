package com.practice.demo.dto;

import com.practice.demo.reflection.Goat;
import com.practice.demo.reflection.ReflectionDto;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionTest {
    @Test
    void reflectionFields(){
        Object dto = new ReflectionDto();
        Field[] fields = dto.getClass().getDeclaredFields();
        List<String> fieldNames =
                Arrays.stream(fields).map(Field::getName).toList();;
        assertTrue(fieldNames.containsAll(List.of("name", "age")));
    }
    
    @Test
    void reflectionMethods(){
        Object dto = new ReflectionDto();
        Method[] methods = dto.getClass().getDeclaredMethods();
        List<String> methodList = Arrays.stream(methods).map(Method::getName).toList();
        methodList.forEach(System.out::println);
        assertTrue(methodList.containsAll(List.of("getName", "setName", "getAge", "setAge")));
    }
    
    @Test
    void getReflectionClassInfo(){
        Object goat = new Goat();
        Class<?> clazz = goat.getClass();
        assertTrue(clazz.isAssignableFrom(Goat.class));
        assertEquals(clazz.getSimpleName(), "Goat");
        assertEquals("com.practice.demo.reflection.Goat", clazz.getName());
        assertEquals("com.practice.demo.reflection.Goat", clazz.getCanonicalName());
    }
    
    @Test
    void getConstructor(){
        Object goat = new Goat();
        Class<?> clazz = goat.getClass();
        Arrays.stream(clazz.getConstructors()).forEach(System.out::println);
        assertEquals(1, clazz.getConstructors().length);
        assertEquals("public com.practice.demo.reflection.Goat()",
                clazz.getConstructors()[0].toString());
        
//        assertEquals("Goat()", clazz.getConstructors()[0].getName());
    }
    @Test
    void getPrivateMethodAndInvoke(){
        Class<?> clazz = Goat.class;
        try {
            Method getName = clazz.getMethod("getPrivateName");
            Method setName = clazz.getMethod("setPrivateName", String.class);
            getName.setAccessible(true);
            
            Object instance = clazz.getDeclaredConstructor().newInstance();
            setName.invoke(instance, "noArgsConstructorName");
            assertEquals("noArgsConstructorName", getName.invoke(instance));
            
            Object instanceWithName = clazz.getDeclaredConstructor(String.class)
                    .newInstance("testName");
            assertEquals("testName", getName.invoke(instanceWithName));
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // invoke
    @Test
    void invokeClass(){
        Object goat = new Goat();
        Class<?> clazz = goat.getClass();
        try {
            Method method = clazz.getMethod("getSound");
            assertEquals("bleat", method.invoke(goat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}