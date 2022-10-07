package com.brscrt.errorhandler.model;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@SuppressWarnings("java:S1068")
@ApiModel(description = "Error message")
@Getter
@Setter
@Builder
public class Error implements Serializable {

    private String code;

    private String reason;

    private String message;

    private String status;

    private String referenceError;

    private String baseType;

    private String schemaLocation;

    private String type;

}
