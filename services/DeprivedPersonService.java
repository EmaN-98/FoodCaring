package ro.tuc.ds2020.services ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.DeprivedPersonDetailsDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.entities.DeprivedPerson;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.repositories.DeprivedPersonRepository;
import ro.tuc.ds2020.repositories.UserRepository;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class DeprivedPersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeprivedPersonService.class);
    private final DeprivedPersonRepository deprivedPersonRepository;
    private final UserRepository userRepository;
    @Autowired
    public DeprivedPersonService(DeprivedPersonRepository deprivedPersonRepository,UserRepository userRepository ) {
        this.deprivedPersonRepository=deprivedPersonRepository;
        this.userRepository=userRepository;
    }


    public DeprivedPerson findUserByUserId(UUID userId) {
//        return this.deprivedPersonRepository.findAll()
//                .stream().filter( a -> a.getUser().getId() == userId)
//                .collect(Collectors.toList()).get(0);

        List<DeprivedPerson> list = this.deprivedPersonRepository.findAll();

        for(DeprivedPerson d:list){
            if (d.getUser().getId().equals(userId)){
                return d;
            }
        }

        return null;
    }

    public void updateDeprived(DeprivedPersonDetailsDTO userDTO) {
        DeprivedPerson foundUser = deprivedPersonRepository.findById(userDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id: " + userDTO.getId()));
        foundUser.setAllergies(userDTO.getAllergies());
        foundUser.setWishlist(userDTO.getWishlist());
        foundUser.setAddress(userDTO.getAddress());
        foundUser.setNr_donations(userDTO.getNr_donations());
        foundUser.setUser(userDTO.getUser());
        deprivedPersonRepository.save(foundUser);

        userRepository.save(userDTO.getUser());
    }
}
