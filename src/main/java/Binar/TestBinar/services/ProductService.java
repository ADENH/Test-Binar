package Binar.TestBinar.services;

import java.util.List;
import java.util.Optional;

import Binar.TestBinar.model.Product;
import Binar.TestBinar.model.ProductInsert;


public interface ProductService 
{	
	Product insert(ProductInsert productInsert);
	
	List<Product> showAll();
	
	Optional<Product> showProduct(Integer id);
	
	void delete(Integer id);
	
	Product updateProduct(Product product ,Integer id);
}
