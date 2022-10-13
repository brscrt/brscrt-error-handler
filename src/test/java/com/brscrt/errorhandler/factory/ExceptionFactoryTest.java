package com.brscrt.errorhandler.factory;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.exception.clienterror.e401.UnauthorizedException;
import com.brscrt.errorhandler.exception.clienterror.e403.ForbiddenException;
import com.brscrt.errorhandler.exception.clienterror.e404.NotFoundException;
import com.brscrt.errorhandler.exception.clienterror.e405.MethodNotAllowedException;
import com.brscrt.errorhandler.exception.clienterror.e406.accept.MissingAcceptHeaderException;
import com.brscrt.errorhandler.exception.clienterror.e406.accept.UnsupportedAcceptHeaderException;
import com.brscrt.errorhandler.exception.clienterror.e406.content.MissingContentTypeHeaderException;
import com.brscrt.errorhandler.exception.clienterror.e406.content.UnsupportedContentTypeHeaderException;
import com.brscrt.errorhandler.exception.clienterror.e406.other.NotAcceptableHeaderException;
import com.brscrt.errorhandler.exception.clienterror.e409.ConflictException;
import com.brscrt.errorhandler.exception.clienterror.e412.InvalidIfMatchHeaderException;
import com.brscrt.errorhandler.exception.clienterror.e422.*;
import com.brscrt.errorhandler.exception.clienterror.e428.MissingIfMatchHeaderException;
import com.brscrt.errorhandler.exception.servererror.e500.InternalServerErrorException;
import com.brscrt.errorhandler.exception.servererror.e501.NotImplementedException;
import com.brscrt.errorhandler.exception.servererror.e503.KafkaUnavailableException;
import com.brscrt.errorhandler.exception.servererror.e504.KafkaTimeoutException;
import com.brscrt.errorhandler.testutil.TestUtil;
import org.junit.jupiter.api.Test;

class ExceptionFactoryTest {

    @Test
    void givenReferenceError_whenThrowUnauthorizedException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        ApiException expectedException = new UnauthorizedException(referenceError);
        //when
        ApiException resultException = ExceptionFactory.Client.Unauthorized.throwUnauthorizedException(referenceError);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenReferenceError_whenThrowForbiddenException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        ApiException expectedException = new ForbiddenException(referenceError);
        //when
        ApiException resultException = ExceptionFactory.Client.Forbidden.throwForbiddenException(referenceError);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenReferenceError_whenThrowNotFoundException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        ApiException expectedException = new NotFoundException(referenceError);
        //when
        ApiException resultException = ExceptionFactory.Client.NotFound.throwNotFoundException(referenceError);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenParameters_whenThrowMethodNotAllowedException_thenReturnApiException() {
        //given
        String method = "method";
        String resource = "resource";
        ApiException expectedException = new MethodNotAllowedException(method, resource);
        //when
        ApiException resultException = ExceptionFactory.Client.MethodNotAllowed
                .throwMethodNotAllowedException(method, resource);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }


    @Test
    void givenNoParameter_whenThrowMissingAcceptHeaderException_thenReturnApiException() {
        //given
        ApiException expectedException = new MissingAcceptHeaderException();
        //when
        ApiException resultException = ExceptionFactory.Client.NotAcceptable.throwMissingAcceptHeaderException();
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenNoParameter_whenThrowUnsupportedAcceptHeaderException_thenReturnApiException() {
        //given
        ApiException expectedException = new UnsupportedAcceptHeaderException();
        //when
        ApiException resultException = ExceptionFactory.Client.NotAcceptable.throwUnsupportedAcceptHeaderException();
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenNoParameter_whenThrowMissingContentTypeHeaderException_thenReturnApiException() {
        //given
        ApiException expectedException = new MissingContentTypeHeaderException();
        //when
        ApiException resultException = ExceptionFactory.Client.NotAcceptable.throwMissingContentTypeHeaderException();
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenNoParameter_whenThrowUnsupportedContentTypeHeaderException_thenReturnApiException() {
        //given
        ApiException expectedException = new UnsupportedContentTypeHeaderException();
        //when
        ApiException resultException = ExceptionFactory.Client.NotAcceptable
                .throwUnsupportedContentTypeHeaderException();
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenHeader_whenThrowNotAcceptableHeaderException_thenReturnApiException() {
        //given
        String header = "header";
        ApiException expectedException = new NotAcceptableHeaderException(header);
        //when
        ApiException resultException = ExceptionFactory.Client.NotAcceptable.throwNotAcceptableHeaderException(header);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenReferenceError_whenThrowConflictException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        ApiException expectedException = new ConflictException(referenceError);
        //when
        ApiException resultException = ExceptionFactory.Client.Conflict.throwConflictException(referenceError);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenReferenceError_whenThrowInvalidIfMatchHeaderException_thenReturnApiException() {
        //given
        String ifMatch = "1";
        ApiException expectedException = new InvalidIfMatchHeaderException(ifMatch);
        //when
        ApiException resultException = ExceptionFactory.Client.PreconditionFailed
                .throwInvalidIfMatchHeaderException(ifMatch);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenParameters_whenThrowAdditionalFieldException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        String[] attributes = new String[]{"1", "2"};
        ApiException expectedException = new AdditionalFieldException(referenceError, attributes);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwAdditionalFieldException(referenceError, attributes);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenParameters_whenThrowDuplicatedIdException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        String id = "id";
        ApiException expectedException = new DuplicatedIdException(referenceError, id);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwDuplicatedIdException(referenceError, id);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenParameters_whenThrowInvalidDateException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        String field = "field";
        String value = "value";
        ApiException expectedException = new InvalidDateException(referenceError, field, value);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwInvalidDateException(referenceError, field, value);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenParameters_whenThrowInvalidEnumException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        String field = "field";
        String value = "value";
        ApiException expectedException = new InvalidEnumException(referenceError, field, value);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwInvalidEnumException(referenceError, field, value);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenParameters_whenThrowInvalidFieldException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        String field = "field";
        String value = "value";
        ApiException expectedException = new InvalidFieldException(referenceError, field, value);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwInvalidFieldException(referenceError, field, value);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenParameters_whenThrowInvalidFieldTypeException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        String field = "field";
        String value = "value";
        ApiException expectedException = new InvalidFieldTypeException(referenceError, field, value);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwInvalidFieldTypeException(referenceError, field, value);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenParameters_whenThrowInvalidFilterParameterException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        String parameter = "parameter";
        ApiException expectedException = new InvalidFilterParameterException(referenceError, parameter);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwInvalidFilterParameterException(referenceError, parameter);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenParameters_whenThrowInvalidIdException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        String id = "id";
        ApiException expectedException = new InvalidIdException(referenceError, id);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwInvalidIdException(referenceError, id);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenParameters_whenThrowInvalidLengthException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        String field = "field";
        String value = "value";
        ApiException expectedException = new InvalidLengthException(referenceError, field, value);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwInvalidLengthException(referenceError, field, value);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenParameters_whenThrowInvalidNumberException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        String field = "field";
        String value = "value";
        ApiException expectedException = new InvalidNumberException(referenceError, field, value);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwInvalidNumberException(referenceError, field, value);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenReferenceError_whenThrowInvalidPathParameterException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        ApiException expectedException = new InvalidPathParameterException(referenceError);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwInvalidPathParameterException(referenceError);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenParameters_whenThrowInvalidRegexException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        String field = "field";
        String value = "value";
        ApiException expectedException = new InvalidRegexException(referenceError, field, value);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwInvalidRegexException(referenceError, field, value);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenReferenceError_whenThrowInvalidSortParameterException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        String parameter = "parameter";
        ApiException expectedException = new InvalidSortParameterException(referenceError, parameter);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwInvalidSortParameterException(referenceError, parameter);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenParameters_whenThrowMissingFieldException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        String[] params = new String[]{"1", "2"};
        ApiException expectedException = new MissingFieldException(referenceError, params);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwMissingFieldException(referenceError, params);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenReferenceError_whenThrowUnprocessablePayloadException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        ApiException expectedException = new UnprocessablePayloadException(referenceError);
        //when
        ApiException resultException = ExceptionFactory.Client.UnprocessableEntity
                .throwUnprocessablePayloadException(referenceError);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenReferenceError_whenThrowMissingIfMatchHeaderException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        ApiException expectedException = new MissingIfMatchHeaderException(referenceError);
        //when
        ApiException resultException = ExceptionFactory.Client.PreconditionRequired
                .throwMissingIfMatchHeaderException(referenceError);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenReferenceError_whenThrowInternalServerErrorException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        ApiException expectedException = new InternalServerErrorException(referenceError);
        //when
        ApiException resultException = ExceptionFactory.Server.InternalServerError.
                throwInternalServerErrorException(referenceError);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenReferenceError_whenThrowNotImplementedException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        ApiException expectedException = new NotImplementedException(referenceError);
        //when
        ApiException resultException = ExceptionFactory.Server.NotImplemented.
                throwNotImplementedException(referenceError);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenReferenceError_whenThrowKafkaUnavailableException_thenReturnApiException() {
        //given
        String referenceError = "ref";
        ApiException expectedException = new KafkaUnavailableException(referenceError);
        //when
        ApiException resultException = ExceptionFactory.Server.ServiceUnavailable
                .throwKafkaUnavailableException(referenceError);
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

    @Test
    void givenNoParameter_whenThrowGatewayTimeoutException_thenReturnApiException() {
        //given
        ApiException expectedException = new KafkaTimeoutException();
        //when
        ApiException resultException = ExceptionFactory.Server.GatewayTimeout.throwKafkaTimeoutException();
        //then
        TestUtil.assertErrorResponse(expectedException.getResponse(), resultException.getResponse());
    }

}