# Exception Handler

This is the project which covers the exceptions in spring boot. It is well-structured in a TMForum-compliant way. There are several predefined exceptions inside. All exceptions are extended from ApiException. For more custom exceptions, ApiException can be extended.

All exceptions are returned as Error object which TMF provides.

### Error response structure

    @ApiModel(description = "Used when an API throws an Error, typically with a HTTP error response-code (3xx, 4xx, 5xx)")  
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
