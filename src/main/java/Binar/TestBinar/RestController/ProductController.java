package Binar.TestBinar.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Binar.TestBinar.model.Message;
import Binar.TestBinar.model.Product;
import Binar.TestBinar.model.ProductInsert;
import Binar.TestBinar.model.Response;
import Binar.TestBinar.services.ProductService;


@RestController
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	@GetMapping("v1/products")
	public Response<List<Product>> showData()
	{
		List<Product> product = productService.showAll();
		Response<List<Product>> response = new Response<>();
		response.setStatus("ok");
		response.setResult(product);
		response.setError(null);
		return response;
	}
	
	@GetMapping("v1/products/{id}")
	public Response<Optional<Product>> showProduct(@PathVariable int id)
	{
		Optional<Product> product = productService.showProduct(id);
		Response<Optional<Product>> response = new Response<>();
		response.setStatus("ok");
		response.setResult(product);
		response.setError(null);
		return response;
		
	}
	
	@DeleteMapping("v1/products/{id}")
	public Response<Message> deleteById(@PathVariable Integer id)
	{
		productService.delete(id);
		Message message = new Message();
		message.setMessage(id + " deleted");
		Response<Message> response = new Response<>();
		response.setStatus("ok");
		response.setResult(message);
		response.setError(null);
		return response;
	}
	
	@PutMapping("v1/products/{id}")
	public Response<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Integer id)
	{
		Product updateProduct = productService.updateProduct(product, id);
		Response<Product> response = new Response<>();
		response.setStatus("ok");
		response.setResult(updateProduct);
		response.setError(null);
		return response;
		
	}
	
	@PostMapping("v1/products")
	public Response<Product> createData(@RequestBody ProductInsert productInsert)
	{
		Product product = productService.insert(productInsert);
		Response<Product> response = new Response<>();
		response.setStatus("ok");
		response.setResult(product);
		response.setError(null);
		return response;
	}
}
