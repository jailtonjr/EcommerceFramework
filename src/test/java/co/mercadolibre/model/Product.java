package co.mercadolibre.model;

public class Product {

    private String name;
    private double price;
    private int installments;
    private double installmentPrice;

    public Product(String name, double price, int installments, double installmentPrice) {
        this.name = name;
        this.price = price;
        this.installments = installments;
        this.installmentPrice = installmentPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInstallments() {
        return installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

    public double getInstallmentPrice() {
        return installmentPrice;
    }

    public void setInstallmentPrice(double installmentPrice) {
        this.installmentPrice = installmentPrice;
    }

    public String toString() {
        return "Product(name = " + this.getName() + ", price = " + this.getPrice() + ", installments = " + this.getInstallments() +
                ", installments price = " + this.getInstallmentPrice() + ")";
    }
}
