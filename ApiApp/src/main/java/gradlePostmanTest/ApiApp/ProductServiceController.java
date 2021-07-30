package gradlePostmanTest.ApiApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProductServiceController {

	private static Map<String, Product> productRepo = new HashMap<>();
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);

		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		if (!productRepo.containsKey(id)) throw new ProductNotFoundException(); 
		productRepo.remove(id);
		return new ResponseEntity<Object>("Product was deleted sucessfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		if (!productRepo.containsKey(id)) throw new ProductNotFoundException();
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
		return new ResponseEntity<Object>("Product udpated sucessfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		productRepo.put(product.getId(), product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/products")
	public ResponseEntity<Object> getProduct() {
		List<Product> productos = new ArrayList<Product>(productRepo.values());
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/{id}")
	public  ResponseEntity<Object> getProductById(@PathVariable("id") String id){
		if (!productRepo.containsKey(id)) throw new ProductNotFoundException();
		
		return new ResponseEntity<Object>(productRepo.get(id), HttpStatus.OK);
	}
}
