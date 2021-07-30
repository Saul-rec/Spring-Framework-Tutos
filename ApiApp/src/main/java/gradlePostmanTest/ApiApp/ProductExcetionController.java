package gradlePostmanTest.ApiApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExcetionController {
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> exception(ProductNotFoundException exception){
		return new ResponseEntity<>("Product searched  Not Found ", HttpStatus.NOT_FOUND);
	}
	
}
