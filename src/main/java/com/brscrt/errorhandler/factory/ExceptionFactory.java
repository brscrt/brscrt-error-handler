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
import com.brscrt.errorhandler.exception.servererror.e500.InternalServerErrorException;
import com.brscrt.errorhandler.exception.servererror.e501.NotImplementedException;
import com.brscrt.errorhandler.exception.servererror.e503.KafkaUnavailableException;
import com.brscrt.errorhandler.exception.servererror.e504.KafkaTimeoutException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExceptionFactory {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Client {

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class Unauthorized {
            public static ApiException throwUnauthorizedException(@Nullable String referenceError) {
                return new UnauthorizedException(referenceError);
            }
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class Forbidden {
            public static ApiException throwForbiddenException(@Nullable String referenceError) {
                return new ForbiddenException(referenceError);
            }
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class NotFound {
            public static ApiException throwNotFoundException(@Nullable String referenceError) {
                return new NotFoundException(referenceError);
            }
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class MethodNotAllowed {
            public static ApiException throwMethodNotAllowedException(@NotNull String method, @NotNull String resource) {
                return new MethodNotAllowedException(method, resource);
            }
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class NotAcceptable {
            public static ApiException throwMissingAcceptHeaderException() {
                return new MissingAcceptHeaderException();
            }

            public static ApiException throwUnsupportedAcceptHeaderException() {
                return new UnsupportedAcceptHeaderException();
            }

            public static ApiException throwMissingContentTypeHeaderException() {
                return new MissingContentTypeHeaderException();
            }

            public static ApiException throwUnsupportedContentTypeHeaderException() {
                return new UnsupportedContentTypeHeaderException();
            }

            public static ApiException throwNotAcceptableHeaderException(@NotNull String header) {
                return new NotAcceptableHeaderException(header);
            }
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class Conflict {
            public static ApiException throwConflictException(@Nullable String referenceError) {
                return new ConflictException(referenceError);
            }
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class PreconditionFailed {
            public static ApiException throwInvalidIfMatchHeaderException(@NotNull String ifMatch) {
                return new InvalidIfMatchHeaderException(ifMatch);
            }
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class UnprocessableEntity {
            public static ApiException throwAdditionalFieldException(@Nullable String referenceError,
                                                                     @NotNull String... additionalAttributes) {
                return new AdditionalFieldException(referenceError, additionalAttributes);
            }

            public static ApiException throwDuplicatedIdException(@Nullable String referenceError, @NotNull String id) {
                return new DuplicatedIdException(referenceError, id);
            }

            public static ApiException throwInvalidDateException(@Nullable String referenceError,
                                                                 @NotNull String field,
                                                                 @NotNull String value) {
                return new InvalidDateException(referenceError, field, value);
            }

            public static ApiException throwInvalidEnumException(@Nullable String referenceError,
                                                                 @NotNull String field,
                                                                 @NotNull String value) {
                return new InvalidEnumException(referenceError, field, value);
            }

            public static ApiException throwInvalidFieldException(@Nullable String referenceError,
                                                                  @NotNull String field,
                                                                  @NotNull String value) {
                return new InvalidFieldException(referenceError, field, value);
            }

            public static ApiException throwInvalidFieldTypeException(@Nullable String referenceError,
                                                                      @NotNull String field,
                                                                      @NotNull String value) {
                return new InvalidFieldTypeException(referenceError, field, value);
            }

            public static ApiException throwInvalidFilterParameterException(@Nullable String referenceError,
                                                                            @NotNull String parameter) {
                return new InvalidFilterParameterException(referenceError, parameter);
            }

            public static ApiException throwInvalidIdException(@Nullable String referenceError, @NotNull String id) {
                return new InvalidIdException(referenceError, id);
            }

            public static ApiException throwInvalidLengthException(@Nullable String referenceError,
                                                                   @NotNull String field,
                                                                   @NotNull String value) {
                return new InvalidLengthException(referenceError, field, value);
            }

            public static ApiException throwInvalidNumberException(@Nullable String referenceError,
                                                                   @NotNull String field,
                                                                   @NotNull String value) {
                return new InvalidNumberException(referenceError, field, value);
            }

            public static ApiException throwInvalidPathParameterException(@Nullable String referenceError) {
                return new InvalidPathParameterException(referenceError);
            }

            public static ApiException throwInvalidRegexException(@Nullable String referenceError,
                                                                  @NotNull String field,
                                                                  @NotNull String value) {
                return new InvalidRegexException(referenceError, field, value);
            }

            public static ApiException throwInvalidSortParameterException(@Nullable String referenceError,
                                                                          @NotNull String parameter) {
                return new InvalidSortParameterException(referenceError, parameter);
            }

            public static ApiException throwMissingFieldException(@Nullable String referenceError,
                                                                  @NotNull String... attributes) {
                return new MissingFieldException(referenceError, attributes);
            }

            public static ApiException throwUnprocessablePayloadException(@Nullable String referenceError) {
                return new UnprocessablePayloadException(referenceError);
            }
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class PreconditionRequired {
            public static ApiException throwInvalidIfMatchHeaderException(@NotNull String ifMatch) {
                return new InvalidIfMatchHeaderException(ifMatch);
            }
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Server {

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class InternalServerError {
            public static ApiException throwInternalServerErrorException(@Nullable String referenceError) {
                return new InternalServerErrorException(referenceError);
            }
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class NotImplemented {
            public static ApiException throwNotImplementedException(@Nullable String referenceError) {
                return new NotImplementedException(referenceError);
            }
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class ServiceUnavailable {
            public static ApiException throwKafkaUnavailableException(@Nullable String referenceError) {
                return new KafkaUnavailableException(referenceError);
            }
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class GatewayTimeout {
            public static ApiException throwKafkaTimeoutException() {
                return new KafkaTimeoutException();
            }
        }
    }


}
