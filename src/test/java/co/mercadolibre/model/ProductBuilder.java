package co.mercadolibre.model;

public class ProductBuilder {

    private String name;
    private double price;
    private int installments;
    private double installmentPrice;

    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder price(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder installments(int installments) {
        this.installments = installments;
        return this;
    }

    public ProductBuilder installmentPrice(double installmentPrice) {
        this.installmentPrice = installmentPrice;
        return this;
    }

    public Product build() {
        return new Product(name, price, installments, installmentPrice);
    }
}
