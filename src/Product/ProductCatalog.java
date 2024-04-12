package Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductCatalog extends Product {
	public ProductCatalog(String code, String description, double price) {
		super(code, description, price);
		ProductCatalog.products = new ArrayList<>();

		// TODO Auto-generated constructor stub
	}

	private static List<Product> products;

	public void addProduct(Product product) {
		ProductCatalog.products.add(product);
	}

	public static Optional<Product> getProductByCode(String code) {
		for (Product product : products) {
			if (product.getCode().equals(code)) {
				return Optional.of(product);
			}
		}
		return Optional.empty();
	}

	public static void put(String string, Product product) {
		// TODO Auto-generated method stub
		
	}
}