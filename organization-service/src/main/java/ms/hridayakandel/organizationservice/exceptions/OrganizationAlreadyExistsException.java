package ms.hridayakandel.organizationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OrganizationAlreadyExistsException extends RuntimeException{
    private String resourceName;
    private String fieldValue;
    private String message;
    public OrganizationAlreadyExistsException(String resourceName, String fieldValue, String message){
        super(String.format("%s with code %S : %s ", resourceName, fieldValue, message));
        this.resourceName=resourceName;
        this.fieldValue = fieldValue;
        this.message= message;
    }

}
