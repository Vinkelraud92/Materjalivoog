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
        listingRepository.createListing(listing.getListingId(), listing.getUserId());
        return "Empty listing has been added to listing database!";
    }
}
