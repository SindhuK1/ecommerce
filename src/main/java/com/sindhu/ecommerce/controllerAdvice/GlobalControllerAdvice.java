package com.sindhu.ecommerce.controllerAdvice;

import com.sindhu.ecommerce.dto.ErrorResponseDTO;
import com.sindhu.ecommerce.exceptions.DBNotFoundException;
import com.sindhu.ecommerce.exceptions.DBTimeoutException;
import com.sindhu.ecommerce.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalControllerAdvice {


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundException(ProductNotFoundException errorObject){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setErrorMessage(" general error " + errorObject.getMessage());
        ResponseEntity<ErrorResponseDTO> responseEntity = new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    @ExceptionHandler(DBNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleDBNotFoundException(DBNotFoundException errorObject){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setErrorMessage(errorObject.getMessage());
        ResponseEntity<ErrorResponseDTO> responseEntity = new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    @ExceptionHandler(DBTimeoutException.class)
    public ResponseEntity<ErrorResponseDTO> handleDBTimeoutException(DBTimeoutException errorObject){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setErrorMessage(errorObject.getMessage());
        ResponseEntity<ErrorResponseDTO> responseEntity = new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponseDTO> handleHttpClientErrorException(DBNotFoundException errorObject){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setErrorMessage(errorObject.getMessage());
        ResponseEntity<ErrorResponseDTO> responseEntity = new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception e){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setErrorMessage(" general exception "+ e.getMessage());
        ResponseEntity<ErrorResponseDTO> responseEntity = new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

}
