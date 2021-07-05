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
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.services.UserService;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class UserController {

	private final UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	//@CrossOrigin
	@GetMapping(value = "/loginUser/{username}/{password}")
	public ResponseEntity<?> getUserByCredentials(@PathVariable String username, @PathVariable String password) {
		String result = userService.findUser(username, password);
		String[] arrOfStr = result.split(",", 2);
		JSONObject res = new JSONObject();
		res.put("role", arrOfStr[0]);
		res.put("id", arrOfStr[1]);
		try {
			return ResponseEntity.ok().body(res);
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	//@CrossOrigin
	@GetMapping(value = "/loginUser/{role}")
	public ResponseEntity<?> getUsersByRole(@PathVariable String role) {
		List<User> result = userService.findUser(role);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(result);
		try {
			return ResponseEntity.ok().body(json);
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	//@CrossOrigin
	@PostMapping(value="/registerUser")
	public ResponseEntity<UUID> insertUser(@RequestBody UserDetailsDTO userDTO) {
		UUID userID = userService.insert(userDTO);
		return new ResponseEntity<>(userID, HttpStatus.CREATED);
		//returneaza id-ul user-ului creat si salvat in database
	}

	//     @GetMapping("/getUsers")
//     public ResponseEntity<List<UserDetailsDTO>> getUsers() {
//         List<UserDetailsDTO> dtos = userService.findUsers();
//         for (UserDetailsDTO dto : dtos) {
//             Link userLink = linkTo(methodOn(UserController.class)
//                     .getUser(dto.getId())).withRel("userDetails");
//             dto.add(userLink);
//
//         }
//         return new ResponseEntity<>(dtos, HttpStatus.OK);
//     }
     @CrossOrigin
     @GetMapping(value = "/getUser/{id}")
     public ResponseEntity<UserDetailsDTO> getUserById(@PathVariable("id") UUID userId) {
         UserDetailsDTO dto = userService.findUserById(userId);////
         UserDetailsDTO dto2=new UserDetailsDTO(dto);
         return new ResponseEntity<>(dto2, HttpStatus.OK);
     }


	@CrossOrigin
	@DeleteMapping(value = "/deleteUser/{idUser}")
	public ResponseEntity<String> deleteUser(@PathVariable UUID idUser){
		userService.deleteById(idUser);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping(value = "/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody UserDetailsDTO userDTO){
		userService.updateUser(userDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}