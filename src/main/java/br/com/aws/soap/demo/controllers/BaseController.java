package br.com.aws.soap.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Map;

public class BaseController {

    @SuppressWarnings("unchecked")
    protected <T, K> ResponseEntity<T> createResponse(T instance) {
        if (instance == null || (instance instanceof Collection && ((Collection<T>) instance).isEmpty())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        if ((instance instanceof Map && ((Map<T, K>) instance).isEmpty())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(instance, HttpStatus.OK);
    }

    protected  <T> ResponseEntity<T> createResponse(T instance, HttpStatus status) {
        return new ResponseEntity<>(instance, status);
    }

}
