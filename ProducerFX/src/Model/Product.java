package Model;

public class Product {
    private int produtcId;
    private String productName;
    private Double productAmout;
    private String productNote;

    public Product(){

    }

    public Product(int produtcId, String productName, Double productAmout, String productNote) {
        this.produtcId = produtcId;
        this.productName = productName;
        this.productAmout = productAmout;
        this.productNote = productNote;
    }

    public Product(String productName, Double productAmout, String productNote) {
        this.productName = productName;
        this.productAmout = productAmout;
        this.productNote = productNote;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductAmout() {
        return productAmout;
    }

    public void setProductAmout(Double productAmout) {
        this.productAmout = productAmout;
    }

    public String getProductNote() {
        return productNote;
    }

    public void setProductNote(String productNote) {
        this.productNote = productNote;
    }

    public int getProdutcId() {
        return produtcId;
    }

    public void setProdutcId(int produtcId) {
        this.produtcId = produtcId;
    }
}
