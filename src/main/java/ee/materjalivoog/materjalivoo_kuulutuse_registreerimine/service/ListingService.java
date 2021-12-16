package ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.service;

import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.Category;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.Listing;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.ListingPg1;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.ListingPg3;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Listing updateListing(Listing listing, int listingId) {
        listingRepository.updateListing(listingId, listing.getUserId(), listing.getCategory(), listing.getSubcategory(),
                listing.isDeadStock(), listing.getTitle(), listing.getDescription1(), listing.getUnitPrice(), listing.getUnitType(),
                listing.getInventory(), listing.isInStock(), listing.getProfit(), listing.getDescription2(), listing.getDiscountPrice(),
                listing.getDiscountPercentage(), listing.getRegion(), listing.getLocation(), listing.getRestriction(), listing.getTransport());
        return listing;
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

    public String addCategories(ListingPg1 listingPg1) {
        listingRepository.createListingPg1(listingPg1.getListingId(),listingPg1.getCategory(), listingPg1.getSubcategory(),
                listingPg1.isDeadStock());
        return "Selected categories " + listingPg1.getCategory() + " & " + listingPg1.getSubcategory() + " have been saved to listing database!";
    }

    public ListingPg1 updatePg1(ListingPg1 listingPg1, int listingId) {
        listingRepository.updatePg1(listingId, listingPg1.getCategory(), listingPg1.getSubcategory(), listingPg1.isDeadStock());
        return listingPg1;
    }

    public ListingPg3 updatePg3(ListingPg3 listingPg3, int listingId) {
        listingRepository.updatePg3(listingId, listingPg3.getTitle(), listingPg3.getDescription1(), listingPg3.getTag());
        return listingPg3;
    }
}
