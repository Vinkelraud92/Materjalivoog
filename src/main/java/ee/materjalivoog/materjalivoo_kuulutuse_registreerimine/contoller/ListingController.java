package ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.contoller;

import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.*;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ListingController {

    private Map<String, Listing> listingMap = new HashMap<>();

    @Autowired
    private ListingService listingService;

    // TODO 1.0
    //  teenus, mis loob tühja kuulutuse
    @PostMapping("api/listing/create")
    public String createListing(@RequestBody Listing listing) {
        return listingService.createListing(listing);
    }

    // TODO 1.0
    //  teenus, mis kustutab kuulutuse

    // TODO 1.1
    //  teenus, mis tagastab kõik peakategooriad
    @GetMapping("api/listing/categories")
    public List<Category> getCategories() {
        return listingService.getCategories();
    }


    // TODO 1.2.0
    //  teenus, mis tagastab kõik alamkategooriad
    @GetMapping("api/listing/subcategories")
    public List<Subcategory> getSubcategories() {
        return listingService.getSubcategories();
    }


    // TODO 1.2
    //  teenus, mis tagastab peakategooriale vastavalt alamkategooriad
    @GetMapping("api/listing/selectsubcategories/{category_id}")
    public List<Subcategory> selectSubcategories(@PathVariable("category_id") Integer category_id) {
        return listingService.selectSubcategories(category_id);
    }

    //TODO 1.2.1
    //teenus mis salvestab kasutaja valitud pea- ja alamkategooria ning deadstocki
    @PostMapping("api/listing/create/pg1")
    public String addCategories(@RequestBody ListingPg1 listingPg1) {
        return listingService.addCategories(listingPg1);
    }


    // TODO 1.3
    //  teenus, mis uuendab loodud kuulutuse kõiki andmevälju
    @PutMapping("api/listing/create/complete/{listing_id}")
    public Listing updateListing(@RequestBody Listing listing, @PathVariable("listing_id") Integer listingId) {
        return listingService.updateListing(listing, listingId);
    }

    // TODO 1.3.1
    //  teenus, mis uuendab loodud kuulutuse esimesel lehel sisestatud andmevälju (töötab vaid juhul, kui kuulutus on juba andmebaasis olemas!)
    @PutMapping("api/listing/create/pg1/{listing_id}")
    public ListingPg1 updatePg1(@RequestBody ListingPg1 listingPg1, @PathVariable("listing_id") Integer listingId) {
        return listingService.updatePg1(listingPg1, listingId);
    }

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
    @PutMapping("api/listing/create/pg3/{listing_id}")
    public ListingPg3 updatePg3(@RequestBody ListingPg3 listingPg3, @PathVariable("listing_id") Integer listingId) {
        return listingService.updatePg3(listingPg3, listingId);
    }
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

    @PutMapping("api/listing/create/pg4/{listing_id}")
    public ListingPg4 updatePg4(@RequestBody ListingPg4 listingPg4, @PathVariable("listing_id") Integer listingId) {
        return listingService.updatePg4(listingPg4, listingId);
    }

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
