package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.entities.Menu;
import ro.tuc.ds2020.entities.Offer;
import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.entities.Restaurant;
import ro.tuc.ds2020.repositories.MenuRepository;
import ro.tuc.ds2020.repositories.OfferRepository;
import ro.tuc.ds2020.repositories.ProductRepository;
import ro.tuc.ds2020.repositories.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/offer")
public class OfferController {

    private final OfferRepository offerRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OfferController(OfferRepository offerRepository, RestaurantRepository restaurantRepository, MenuRepository menuRepository, ProductRepository productRepository) {
        this.offerRepository = offerRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
        this.productRepository = productRepository;
    }

    @CrossOrigin
    @PostMapping(value="/insertOffer")
    public ResponseEntity<UUID> insertOffer(@RequestBody Offer offer) {
        Offer entity = offerRepository.save(offer);
        return new ResponseEntity<>(entity.getId(), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping(value = "/getOffers")
    public ResponseEntity<List<Offer>> getOffers() {
        List<Offer> offers = offerRepository.findAll();
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/getOffers/{idOffer}")
    public ResponseEntity<Offer> getOfferById(@PathVariable UUID idOffer) {
        Offer foundOffer = offerRepository.findById(idOffer)
                .orElseThrow(() -> new ResourceNotFoundException("Offer does not exist with id: " + idOffer));

        return new ResponseEntity<>(foundOffer, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/deleteOffer/{idOffer}")
    public ResponseEntity<String> deleteOffer(@PathVariable UUID idOffer){
        offerRepository.deleteById(idOffer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/updateOffer")
    public ResponseEntity<String> updateOffer(@RequestBody Offer offer){
        Offer foundOffer = offerRepository.findById(offer.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Offer does not exist with id: " + offer.getId()));

        foundOffer.setId_restaurant(offer.getId_restaurant());
        foundOffer.setPercentage(offer.getPercentage());
        foundOffer.setFinal_price(offer.getFinal_price());

        offerRepository.save(foundOffer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/getProductsForOffer/{idRep}")
    public ResponseEntity<List<Product>> getProductsForOffer(@PathVariable UUID idRep) {

        List<Restaurant> restaurants = restaurantRepository.findAll();
        Restaurant restaurant = new Restaurant();

        for(Restaurant r: restaurants){
            if(r.getRepresentative().getId().equals(idRep)){
                restaurant = r;
                break;
            }
        }

        List<Menu> menus = menuRepository.findAll();
        List<Product> products = new ArrayList<>();

        for(Menu m: menus){
            if(m.getId_restaurant().equals(restaurant.getId())){
                Product product = productRepository.findById(m.getId_product())
                        .orElseThrow(() -> new ResourceNotFoundException("Product does not exist with id: " + m.getId_product()));

                products.add(product);
            }
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/makeWeeklyOffer/{idRep}/{percentage}")
    public ResponseEntity<List<Product>> makeWeeklyOffer(@PathVariable UUID idRep, @PathVariable Float percentage) {
        List<Product> products = getProductsForOffer(idRep).getBody();
        List<Restaurant> restaurants = restaurantRepository.findAll();
        Restaurant restaurant = new Restaurant();

        for(Restaurant r: restaurants){
            if(r.getRepresentative().getId().equals(idRep)){
                restaurant = r;
                break;
            }
        }

        Float final_price = new Float(0);

        for(Product p: products){
            p.setPrice(p.getPrice() - (p.getPrice() * percentage));
            final_price += p.getPrice();
        }

        Offer offer = new Offer(restaurant.getId(), percentage, final_price);
        insertOffer(offer);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/getOffer/{idRestaurant}")
    public ResponseEntity<Offer> getOffeById(@PathVariable UUID idRestaurant) {
        List<Offer> mda = offerRepository.findAll();
        Offer send = new Offer();
        for(Offer f : mda){
            if (f.getId_restaurant().equals(idRestaurant)){
                send = f;
            }
        }
        return new ResponseEntity<>(send, HttpStatus.OK);
    }
}
