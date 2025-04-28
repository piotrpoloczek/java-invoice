package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class FuelCanister extends OtherProduct {

    private static final BigDecimal EXCISE = new BigDecimal("5.56");

    public FuelCanister(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public BigDecimal getPriceWithTax() {
        return super.getPriceWithTax().add(EXCISE);
    }
}
