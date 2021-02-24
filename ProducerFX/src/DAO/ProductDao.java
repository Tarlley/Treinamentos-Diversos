package DAO;

import JDBC.ConnectionFactory;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private final Connection connection;

    public ProductDao(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean insert(Product product){
        String sql = "INSERT INTO product(productName, productNote, productAmount)" +
                "values(?,?,?);";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,product.getProductName());
            stmt.setString(2,product.getProductNote());
            stmt.setDouble(3,product.getProductAmout());
            stmt.execute();
            stmt.close();
            connection.close();

            return true;
        }catch (Exception e){
            e.getCause();
            e.printStackTrace();

            return false;
        }
    }

    public boolean update(Product product){

            String sql = "update product set productName = ?, productNote = ?, productAmount = ?" +
                    "where productId = ?;";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,product.getProductName());
            stmt.setString(2,product.getProductNote());
            stmt.setDouble(3,product.getProductAmout());
            stmt.setInt(4,product.getProdutcId());
            stmt.execute();
            connection.close();

            return true;

        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Product product){
        String sql = "delete from product where productId = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,product.getProdutcId());
            stmt.close();
            connection.close();

            return true;

        }catch (Exception e){
            e.getCause();
            e.printStackTrace();

            return false;
        }
    }

    public List<Product> getList(){
        List<Product> products = new ArrayList<>();
        String sql = "select * from produtc";


        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Product product = new Product();
                product.setProdutcId(rs.getInt("productId"));
                product.setProductName(rs.getNString("productName"));
                product.setProductNote(rs.getNString("productNote"));
                product.setProductAmout(rs.getDouble("productAmount"));

                products.add(product);

            }
            stmt.close();
            rs.close();
            connection.close();

        }catch (Exception e){
            e.getCause();
            e.printStackTrace();

            return null;
        }
        return products;
    }
}
