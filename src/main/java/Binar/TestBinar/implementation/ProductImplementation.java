package Binar.TestBinar.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import Binar.TestBinar.configuration.ProductNotFoundException;
import Binar.TestBinar.model.Product;
import Binar.TestBinar.model.ProductInsert;
import Binar.TestBinar.repository.ProductRepository;
import Binar.TestBinar.services.ProductService;

@Service
public class ProductImplementation implements ProductService 
{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product insert(ProductInsert productInsert) 
	{
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setName(productInsert.getName());
		product.setPrice(productInsert.getPrice());
		product.setImage(productInsert.getImageurl());
		return productRepository.save(product);
	}

	@Override
	public List<Product> showAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> showProduct(Integer id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);;
	}

	@Override
	public Product updateProduct(Product product,Integer id) {
		// TODO Auto-generated method stub
		Optional<Product> targetProduct = productRepository.findById(id);
		if(!targetProduct.isPresent())
		{
			 throw new ProductNotFoundException(id+" ini tidak ada");
		}else {
			product.setId(id);
			return productRepository.save(product);
		}
		
	}

}
