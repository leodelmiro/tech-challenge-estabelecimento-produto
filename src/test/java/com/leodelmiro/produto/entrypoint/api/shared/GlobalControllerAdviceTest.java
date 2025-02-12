package com.leodelmiro.produto.entrypoint.api.shared;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.*;

class GlobalControllerAdviceTest {

    private GlobalControllerAdvice globalControllerAdvice;

    @BeforeEach
    void setUp() {
        globalControllerAdvice = new GlobalControllerAdvice();
    }

    @Test
    void deveLidarComIllegalArgumentExceptionRetornandoBadRequest() {
        Exception ex = new IllegalArgumentException("Invalid argument");
        ResponseEntity<GlobalControllerAdvice.ErrorResponse> response = globalControllerAdvice.handleIllegalArgumentException(ex);

        assertNotNull(response);
        assertEquals(BAD_REQUEST, response.getStatusCode());
        assertEquals("Illegal Argument Exception", response.getBody().error());
        assertEquals("Invalid argument", response.getBody().message());
    }

    @Test
    void deveLidarComIllegalStateExceptionRetornandoBadRequest() {
        IllegalStateException ex = new IllegalStateException("Invalid state");
        ResponseEntity<GlobalControllerAdvice.ErrorResponse> response = globalControllerAdvice.handleIllegalStateException(ex);

        assertNotNull(response);
        assertEquals(BAD_REQUEST, response.getStatusCode());
        assertEquals("Illegal State Exception", response.getBody().error());
        assertEquals("Invalid state", response.getBody().message());
    }

    @Test
    void deveLidarGenericExceptionRetornandoInternalServerError() {
        Exception ex = new Exception("Unexpected error");
        ResponseEntity<GlobalControllerAdvice.ErrorResponse> response = globalControllerAdvice.handleGenericException(ex);

        assertNotNull(response);
        assertEquals(INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal server error", response.getBody().error());
        assertEquals("Unexpected error", response.getBody().message());
    }
}