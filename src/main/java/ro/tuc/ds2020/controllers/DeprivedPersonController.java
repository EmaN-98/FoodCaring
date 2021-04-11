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
	@Autowired
	public DeprivedPersonController(DeprivedPersonService deprivedPersonService) {
		this.deprivedPersonService = deprivedPersonService;
	}

	
}