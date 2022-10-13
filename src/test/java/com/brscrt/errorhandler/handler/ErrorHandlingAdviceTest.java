package com.brscrt.errorhandler.handler;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.factory.ExceptionFactory;
import com.brscrt.errorhandler.model.Error;
import com.brscrt.errorhandler.testutil.TestBase;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

class ErrorHandlingAdviceTest extends TestBase {

    private ErrorHandlingAdvice errorHandlingAdvice;
    private ResponseEntity<Error> defaultErrorResponse;

    @Override
    protected void setup() {
        errorHandlingAdvice = new ErrorHandlingAdvice();
        defaultErrorResponse = generateErrorResponse();
    }

    @Override
    protected void clean() {
    }

    private ResponseEntity<Error> generateErrorResponse() {
        Error error = Error.builder().code("code").reason("reason").message("message").status("status")
                .referenceError("referenceError").baseType("baseType").schemaLocation("schemaLocation").type("type")
                .build();
        return ResponseEntity.of(Optional.of(error));
    }

    private void assertErrorResponse(ResponseEntity<Error> result) {
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getBody());
        Error error = result.getBody();
        Assertions.assertEquals("code", error.getCode());
        Assertions.assertEquals("reason", error.getReason());
        Assertions.assertEquals("message", error.getMessage());
        Assertions.assertEquals("status", error.getStatus());
        Assertions.assertEquals("referenceError", error.getReferenceError());
        Assertions.assertEquals("baseType", error.getBaseType());
        Assertions.assertEquals("type", error.getType());
        Assertions.assertEquals("schemaLocation", error.getSchemaLocation());
    }

    @Test
    void givenException_whenHandleApiException_thenReturnErrorResponse() {
        //given
        ApiException apiException = Mockito.mock(ApiException.class);
        Mockito.when(apiException.getResponse()).thenReturn(defaultErrorResponse);
        //when
        ResponseEntity<Error> result = errorHandlingAdvice.handleApiException(apiException);
        //then
        assertErrorResponse(result);
    }

    @Test
    void givenException_whenHandleHttpRequestMethodNotSupportedException_thenReturnErrorResponse() {
        //given
        PropertyReferenceException propertyReferenceException = Mockito.mock(PropertyReferenceException.class);
        Mockito.when(propertyReferenceException.getMessage()).thenReturn("message");
        Mockito.when(propertyReferenceException.getPropertyName()).thenReturn("property");
        ApiException apiException = ExceptionFactory.Client.UnprocessableEntity
                .throwInvalidSortParameterException(propertyReferenceException.getMessage(),
                        propertyReferenceException.getPropertyName());
        //when
        ResponseEntity<Error> result = errorHandlingAdvice
                .handlePropertyReferenceException(propertyReferenceException);
        //then
        TestUtil.assertErrorResponse(apiException.getResponse(), result);
    }

    @Test
    void givenExceptionAndRequest_whenHandleHttpRequestMethodNotSupportedException_thenReturnErrorResponse() {
        //given
        HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException =
                Mockito.mock(HttpRequestMethodNotSupportedException.class);
        HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
        Mockito.when(httpRequestMethodNotSupportedException.getMethod()).thenReturn("method");
        Mockito.when(httpServletRequest.getRequestURI()).thenReturn("uri");
        ApiException apiException = ExceptionFactory.Client.MethodNotAllowed
                .throwMethodNotAllowedException(httpRequestMethodNotSupportedException.getMethod(),
                        httpServletRequest.getRequestURI());
        //when
        ResponseEntity<Error> result = errorHandlingAdvice.handleHttpRequestMethodNotSupportedException(
                httpRequestMethodNotSupportedException, httpServletRequest);
        //then
        TestUtil.assertErrorResponse(apiException.getResponse(), result);
    }

    @Test
    void givenNoParameter_whenHandleNotAcceptableAcceptHeaderException_thenReturnErrorResponse() {
        //given
        ApiException apiException = ExceptionFactory.Client.NotAcceptable.throwUnsupportedAcceptHeaderException();
        //when
        ResponseEntity<Error> result = errorHandlingAdvice.handleNotAcceptableAcceptHeaderException();
        //then
        TestUtil.assertErrorResponse(apiException.getResponse(), result);
    }

    @Test
    void givenNoParameter_whenHandleNotAcceptableContentTypeHeaderException_thenReturnErrorResponse() {
        //given
        ApiException apiException = ExceptionFactory.Client.NotAcceptable.throwUnsupportedContentTypeHeaderException();
        //when
        ResponseEntity<Error> result = errorHandlingAdvice.handleNotAcceptableContentTypeHeaderException();
        //then
        TestUtil.assertErrorResponse(apiException.getResponse(), result);
    }

    @Test
    void givenRuntimeException_whenHandleOtherException_thenReturnErrorResponse() {
        //given
        RuntimeException runtimeException = Mockito.mock(RuntimeException.class);
        Mockito.when(runtimeException.getMessage()).thenReturn("message");
        ApiException apiException = ExceptionFactory.Server.InternalServerError
                .throwInternalServerErrorException(runtimeException.getMessage());
        //when
        ResponseEntity<Error> result = errorHandlingAdvice.handleOtherException(runtimeException);
        //then
        TestUtil.assertErrorResponse(apiException.getResponse(), result);
    }

    @Test
    void givenException_whenHandleOtherException_thenReturnErrorResponse() {
        //given
        Exception exception = Mockito.mock(Exception.class);
        Mockito.when(exception.getMessage()).thenReturn("message");
        ApiException apiException = ExceptionFactory.Server.InternalServerError
                .throwInternalServerErrorException(exception.getMessage());
        //when
        ResponseEntity<Error> result = errorHandlingAdvice.handleOtherException(exception);
        //then
        TestUtil.assertErrorResponse(apiException.getResponse(), result);
    }

}