package ro.tuc.ds2020.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.DeprivedPersonDTO;
import ro.tuc.ds2020.dtos.DeprivedPersonDetailsDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.entities.DeprivedPerson;
import ro.tuc.ds2020.entities.Offer;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.repositories.DeprivedPersonRepository;
import ro.tuc.ds2020.repositories.UserRepository;
import ro.tuc.ds2020.services.DeprivedPersonService;
import ro.tuc.ds2020.services.UserService;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RestController
@CrossOrigin
@RequestMapping(value = "/deprivedPerson")
public class DeprivedPersonController {

	private final DeprivedPersonService deprivedPersonService;
	private final DeprivedPersonRepository deprivedPersonRepository;
	private final UserRepository userRepository;
	@Autowired
	public DeprivedPersonController(DeprivedPersonService deprivedPersonService,DeprivedPersonRepository d, UserRepository u) {
		this.deprivedPersonService = deprivedPersonService;
		this.deprivedPersonRepository=d;
		this.userRepository = u;
	}

	@CrossOrigin
	@GetMapping(value = "/getDeprived/{id}")
	public ResponseEntity<DeprivedPerson> getDeprivedById(@PathVariable("id") UUID userId) {
		DeprivedPerson ent = deprivedPersonService.findUserByUserId(userId);
		return new ResponseEntity<>(ent, HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping(value = "/updateDeprived")
	public ResponseEntity<String> updateUser(@RequestBody DeprivedPersonDetailsDTO userDTO){
		deprivedPersonService.updateDeprived(userDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping(value = "/getDepriveds")
	public ResponseEntity<List<User>> getOffers() {
		List<User> offers = userRepository.findAll();
		List<User> returnList = new ArrayList<>();
		for(User o: offers){
			if (o.getRole().equals("deprived")){
				returnList.add(o);
			}
		}
		return new ResponseEntity<>(returnList, HttpStatus.OK);
	}
}