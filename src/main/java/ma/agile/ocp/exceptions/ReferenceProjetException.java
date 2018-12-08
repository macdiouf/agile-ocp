package ma.agile.ocp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReferenceProjetException extends RuntimeException{
	
	public ReferenceProjetException(String msg) {
		super(msg);
	}

}
