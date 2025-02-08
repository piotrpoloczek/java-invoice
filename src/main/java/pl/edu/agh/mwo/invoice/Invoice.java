package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private final Collection<Product> products;

    public Invoice() {
        this.products = new ArrayList<Product>();
    }

    public Invoice(Collection<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        try{
            this.products.add(product);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public void addProduct(Product product, Integer quantity) {
        if(quantity == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < quantity; i++) {
            addProduct(product);
        }
    }

    public BigDecimal getSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (Product product : products) {
            subtotal = subtotal.add(product.getPrice());
        }
        return subtotal;
    }

    public BigDecimal getTax() {
        BigDecimal tax = BigDecimal.ZERO;
        for (Product product : products) {
            tax = tax.add(product.getTaxValue());
        }
        return tax;
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Product product : products) {
            total = total.add(product.getPriceWithTax());
        }
        return total;
    }
}
