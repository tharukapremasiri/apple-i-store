
package appleistore;
public class Item {
    private String ItemCode;
    private String ItemName;
    private float ItemPrice;
    private int ItemQty;
    private String ItemCategory;
   
    public String getItemCode() {
        return ItemCode;}

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;}
    
    public String getItemName() {
        return ItemName;
    }
    
    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public float getItemPrice() {
        return ItemPrice;
    }
    
    public void setItemPrice(float ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

    public int getItemQty() {
        return ItemQty;
    }

    public void setItemQty(int ItemQty) {
        this.ItemQty = ItemQty;
    }
  
    public String getItemCategory() {
        return ItemCategory;
    }
    public void setItemCategory(String ItemCategory) {
        this.ItemCategory = ItemCategory;
    }
    Object Float;
    //add method to add a item
    public void addItem(Item item)
     {
         String itemString = item.getItemCode()+","+ item.getItemName()+","+ item.getItemCategory()+ ","+
                 String.valueOf(item.getItemPrice())+ ","+String.valueOf(item.getItemQty());
         
         DBConnection dbconnection = new DBConnection();
         
         dbconnection.itemAddToDatabase(itemString);}
}



