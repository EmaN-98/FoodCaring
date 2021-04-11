package ro.tuc.ds2020.services ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.repositories.MenuRepository;
import ro.tuc.ds2020.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class MenuService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuService.class);
    private final MenuRepository menuRepository;
    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository=menuRepository;
    }

   
}
