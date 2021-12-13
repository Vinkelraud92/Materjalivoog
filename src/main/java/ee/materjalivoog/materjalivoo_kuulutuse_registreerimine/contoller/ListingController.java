package ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.contoller;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.Category;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.Listing;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.Payment;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.Tag;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.User;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ListingController {

    private Map<String, Listing> listingMap = new HashMap<>();

    @Autowired private ListingService listingService;
    // TODO 1.0
    //  teenus, mis loob tühja kuulutuse
    @PostMapping("listing/create")
    public String createListing(@RequestBody Listing listing){
        return listingService.createListing(listing);
    }

    // TODO 1.0
    //  teenus, mis kustutab kuulutuse

    // TODO 1.1
    //  teenus, mis tagastab kõik peakategooriad
    @GetMapping("listing/category")
    public List<Category> getCategory(){
        return listingService.getCategory();
    }


    // TODO 1.2
    //  teenus, mis tagastab peakategooriale vastavalt alamkategooriad

    //  TODO 1.2.1
    //   teenus mis salvestab kasutaja valitud pea- ja alamkategooria

    // TODO 1.3
    //  teenus, mis salvestab materjalisaadavuse

    // TODO 2.0
    //  teenus, mis tagastab kasutaja meediateegi sisu

    // TODO 2.1
    //  teenus, mis laeb üles 1 meedia faili meediateeki (Kas ka "lae kõik üles" teenus?)

    // TODO 2.1.0
    //  teenus, mis kustutuab 1 faili meediateegist(?)

    // TODO 2.1.1
    //  teenus, mis salvestab meediateegist valitud failid kuulutuse tabelisse

    // TODO 3.0
    //  teenus, mis salvestab title (pealkirja)

    // TODO 3.1
    //  teenus, mis salvestab description1

    // Todo 3.2
    //  teenus, mis tagastab tag´ide nimekirja

    // Todo 3.2.1
    //  teenus, mis salvestab valitud tag´ide kuulutuse tabelisse

    // Todo 4.1
    //  teenus, mis salvestab ühiku hinna

    // Todo 4.2
    //  teenus, mis tagastab ühiku tüübi

    // Todo 4.3
    //  teenus, mis salvestab description2

    // Todo 4.4
    //  teenus, mis tagastab description2

    // Todo 4.4
    //  teenus, mis salvestab soodushinna

    // Todo 4.4.1
    //  teenus, mis tagastab soodushinna

    // Todo 4.5
    //  teenus, mis salvestab laojäägi (inventory)

    // Todo 4.5.1
    //  teenus, mis tagastab laojäägi booleani (in stock)

    // Todo 4.5.1
    //  teenus, mis tagastab laojäägi (inventory)

    // TODO 5.0
    //  teenus, mis salvestab regioni kuulutuse külge

    // TODO 5.1
    //  teenus, mis salvestab kaubavahetuse vormi kuulutuse külge

    //TODO 5.2
    // teenus, mis salvestab kaubavahetuse aadressi

    // TODO 5.3
    //  teenus, mis salvestab restriction teksti kuulutuse külge

    //TODO 5.4
    //kasutaja loomine


}
