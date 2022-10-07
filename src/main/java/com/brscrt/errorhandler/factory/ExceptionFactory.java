package com.brscrt.errorhandler.factory;

import com.brscrt.errorhandler.exception.ApiException;
import com.brscrt.errorhandler.exception.clienterror.e405.MethodNotAllowedException;
import com.brscrt.errorhandler.exception.clienterror.e409.ConflictException;
import com.brscrt.errorhandler.exception.clienterror.e422.AdditionalFieldException;
import com.brscrt.errorhandler.exception.clienterror.e422.MissingFieldException;
import com.brscrt.errorhandler.exception.clienterror.e422.UnprocessablePayloadException;

public final class ExceptionFactory {

    public static class MethodNotAllowed {
        public static ApiException throwMethodNotAllowedException(String method, String resource) {
            return new MethodNotAllowedException(method, resource);
        }
    }

    public static class Conflict {
        public static ApiException throwConflictException() {
            return new ConflictException();
        }
    }

    public static class UnprocessableEntity {
        public static ApiException throwAdditionalFieldException(String referenceError, String... additionalAttributes) {
            return new AdditionalFieldException(referenceError, additionalAttributes);
        }

        public static ApiException throwMissingFieldException(String referenceError, String[] missingAttributes) {
            return new MissingFieldException(referenceError, missingAttributes);
        }

        public static ApiException throwMissingFieldException(String... missingAttributes) {
            return new MissingFieldException(missingAttributes);
        }

        public static ApiException throwUnprocessablePayloadException() {
            return new UnprocessablePayloadException();
        }
    }
}
