package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.entities.Priority;
import ro.tuc.ds2020.repositories.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/priority")
public class PriorityController {
    private final PriorityRepository priorityRepository;

    @Autowired
    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @CrossOrigin
    @GetMapping(value = "/getPriorities")
    public ResponseEntity<List<Priority>> getPriorities() {
        List<Priority> offers = priorityRepository.findAll();
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value="/insertPriority")
    public ResponseEntity<String> insertPriority(@RequestBody Priority priority) {
        List<Priority> priorities = priorityRepository.findAll();
        Priority foundPriority = new Priority();
        boolean found = false;

        for(Priority p: priorities){
            if(p.getId_user_deprived().equals(priority.getId_user_deprived())){
                found = true;
                foundPriority = p;
                break;
            }
        }

        if(found){
            foundPriority.setId_user_deprived(priority.getId_user_deprived());
            foundPriority.setName(priority.getName());
            foundPriority.setPriority(priority.getPriority());

            priorityRepository.save(foundPriority);
        }
        else{
            priorityRepository.save(priority);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/updatePriorities")
    public ResponseEntity<String> updatePriorities(@RequestBody Priority priority){
        Priority foundPriority = priorityRepository.findById(priority.getId())
                .orElse(priorityRepository.save(priority));

        foundPriority.setId_user_deprived(priority.getId_user_deprived());
        foundPriority.setName(priority.getName());
        foundPriority.setPriority(priority.getPriority());

        priorityRepository.save(foundPriority);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
