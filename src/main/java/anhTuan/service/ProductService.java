package anhTuan.service;

import anhTuan.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer,Product> products = new HashMap<>();

    static {
        products.put(1,new Product(1, "Ban", 100, "Gay chan", "Anh Toan"));
        products.put(2,new Product(2, "Ghe", 200, "Like New", "Anh Thao"));
        products.put(3,new Product(3, "Tu", 300, "Vo doi", "Mr.Truong"));
        products.put(4,new Product(4, "Noi", 400, "Gay chan", "Mr.Quang Anh"));
        products.put(5,new Product(5, "Chen", 500, "Gay chan", "Mr.Ba Tuan"));

    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        List<Product> productList = findAll();
        for (Product p:productList) {
            if (p.getName().equals(name)) {
                products.add(p);
            }
        }
        return products;
    }
}
