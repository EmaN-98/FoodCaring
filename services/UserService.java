package ro.tuc.ds2020.services ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.dtos.builders.UserBuilder;
import ro.tuc.ds2020.entities.DeprivedPerson;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.entities.Wishlist;
import ro.tuc.ds2020.repositories.DeprivedPersonRepository;
import ro.tuc.ds2020.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final DeprivedPersonRepository deprivedPersonRepository;
    @Autowired
    public UserService(UserRepository userRepository, DeprivedPersonRepository deprivedPersonRepository) {
        this.userRepository=userRepository;
        this.deprivedPersonRepository=deprivedPersonRepository;
    }

    public String findUser(String username, String password) {
        User user=null;
        user=userRepository.findByUsername(username);
        if(user!=null && user.getPassword().equals(password)) {
            return user.getRole() + "," + user.getId();
        }
        else return "not found";
    }

    public List<User> findUser(String role) {
        List<User> users = userRepository.findAll();
        List<User> foundUsers = new ArrayList<>();
        for(User user: users){
            if(user.getRole().equals(role)){
                foundUsers.add(user);
            }
        }

        return foundUsers;
    }

    public UUID insert(UserDetailsDTO user) {
        //System.out.println("*************service: "+user.toString());
        User entity=UserBuilder.toEntity(user);
        entity =userRepository.save(entity);
        LOGGER.debug("User with id {} was inserted in db", entity.getId());

        if (entity.getRole().equals("deprived")){
            DeprivedPerson deprivedPerson = new DeprivedPerson();
            deprivedPerson.setUser(entity);
            deprivedPerson.setAddress("");
            deprivedPerson.setAllergies("");
            deprivedPerson.setNr_donations(0);

            deprivedPersonRepository.save(deprivedPerson);
        }
        return entity.getId();
    }

    public List<UserDetailsDTO> findUsers() {
        List<User> userList = userRepository.findAll();
       // for(User c:userList) {
       // }
        return  userList.stream()
                .map(UserBuilder::toUserDetailsDTO)
                .collect(Collectors.toList());
    }

    public UserDetailsDTO findUserById(UUID id) {
        Optional<User> prosumerOptional = userRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("User with id {} was not found in db", id);
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with id: " + id);
        }
        //System.out.println(prosumerOptional.get().getAddress()+"  ..........   "+id);
        return UserBuilder.toUserDetailsDTO(prosumerOptional.get());
    }

    public void deleteById(UUID idUser) {
        userRepository.deleteById(idUser);
    }

    public ResponseEntity<User> updateUser(UserDetailsDTO user){
        User foundUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id: " + user.getId()));
        foundUser.setName(user.getName());
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());
        foundUser.setEmail(user.getEmail());
        foundUser.setRole(user.getRole());
        User updatedUser = userRepository.save(foundUser);
        return ResponseEntity.ok(updatedUser);
    }

}
