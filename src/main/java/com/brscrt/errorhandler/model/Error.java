package com.brscrt.errorhandler.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@SuppressWarnings("java:S1068")
@ApiModel(description = "Used when an API throws an Error, typically with a HTTP error response-code (3xx, 4xx, 5xx)")
@Validated
@Getter
@Setter
@Builder
public class Error implements Serializable {

    @NotBlank
    @ApiModelProperty(required = true, value = "Application relevant detail, defined in the API or a common list.")
    private String code;

    @NotBlank
    @ApiModelProperty(required = true, value = "Explanation of the reason for the error which can be shown to a client user.")
    private String reason;

    @ApiModelProperty(value = "More details and corrective actions related to the error which can be shown to a client user.")
    private String message;

    @ApiModelProperty(value = "HTTP Error code extension")
    private String status;

    @ApiModelProperty(value = "URI of documentation describing the error.")
    private String referenceError;

    @ApiModelProperty(value = "When sub-classing, this defines the super-class.")
    private String baseType;

    @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")
    private String schemaLocation;

    @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name.")
    private String type;

}
