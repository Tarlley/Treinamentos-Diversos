package sample;

import java.sql.Date;
import java.time.LocalDate;
import sample.SQL.Sql;

public class Production {
    String productName;
    int productionAmount;
    LocalDate productionDate;
    String productNote;



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductionAmount() {
        return productionAmount;
    }

    public void setProductionAmount(int productionAmount) {
        this.productionAmount = productionAmount;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        System.out.println("SetProductionDate = "+ productionDate);
        this.productionDate = productionDate;
    }

    public String getProductNote() {
        return productNote;
    }

    public void setProductNote(String productNote) {
        this.productNote = productNote;
    }

    public void setQuery(){
       Sql sql = new Sql();
        LocalDate localDate = getProductionDate();
        System.out.println(localDate);
        String string = localDate.toString();
        Date date = Date.valueOf(string);


        sql.executeInsertion(getProductName(),getProductNote(),date,getProductionAmount());
    }

}
