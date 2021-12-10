package ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.service;

import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.Listing;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingService {
    @Autowired
    private ListingRepository listingRepository;

    public String createListing(Listing listing) {
        listingRepository.createListing(listing.getListingId(), listing.getUserId(), listing.getCategory(), listing.getSubcategory(),
                listing.isDeadStock(), listing.getTitle(), listing.getDescription1(), listing.getUnitPrice(), listing.getUnitType(),
                listing.getInventory(), listing.isInStock(), listing.getProfit(), listing.getDescription2(), listing.getDiscountPrice(),
                listing.getDiscountPercentage(), listing.getRegion(), listing.getLocation(), listing.getRestriction());
        return "Listing" + listing.getListingId() + "has been added to listing database!";
    }
}
