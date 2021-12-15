package ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.service;

import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.Category;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.Listing;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {
    @Autowired
    private ListingRepository listingRepository;

    public String createListing(Listing listing) {
        listingRepository.createListing(listing.getListingId(), listing.getUserId(), listing.getCategory(), listing.getSubcategory(),
                listing.isDeadStock(), listing.getTitle(), listing.getDescription1(), listing.getUnitPrice(), listing.getUnitType(),
                listing.getInventory(), listing.isInStock(), listing.getProfit(), listing.getDescription2(), listing.getDiscountPrice(),
                listing.getDiscountPercentage(), listing.getRegion(), listing.getLocation(), listing.getRestriction(), listing.getTransport());
        return "Listing" + listing.getListingId() + "has been added to listing database!";
    }

    public List getCategories() {
        return listingRepository.getCategories();
    }
    public List getSubcategories() {
        return listingRepository.getSubcategories();
    }
    public List selectSubcategories(Integer category_id) {
        List result = listingRepository.selectSubcategories(category_id);
        return result;
    }
  public String addCategories(Listing listing) {
      listingRepository.createListing(listing.getListingId(), listing.getUserId(), listing.getCategory(), listing.getSubcategory(),
               listing.isDeadStock(), listing.getTitle(), listing.getDescription1(), listing.getUnitPrice(), listing.getUnitType(),
               listing.getInventory(), listing.isInStock(), listing.getProfit(), listing.getDescription2(), listing.getDiscountPrice(),
               listing.getDiscountPercentage(), listing.getRegion(), listing.getLocation(), listing.getRestriction(), listing.getTransport());
        return "Selected categories " + listing.getCategory() + " & " + listing.getSubcategory() + " have been saved to listing database!";
    }
}
