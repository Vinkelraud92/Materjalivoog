package ee.materjalivoog.materjalivoo_kuulutuse_registreerimine;

public class ListingPg1 {
    private int listingId;
    private int category;
    private int subcategory;
    private boolean deadStock;


    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(int subcategory) {
        this.subcategory = subcategory;
    }

    public boolean isDeadStock() {
        return deadStock;
    }

    public void setDeadStock(boolean deadStock) {
        this.deadStock = deadStock;
    }
}



