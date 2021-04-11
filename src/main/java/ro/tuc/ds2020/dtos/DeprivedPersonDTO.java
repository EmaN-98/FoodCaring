package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.User;

import java.util.Objects;
import java.util.UUID;

public class DeprivedPersonDTO extends RepresentationModel<DeprivedPersonDTO> {
    private UUID id;
    private User user;

    public DeprivedPersonDTO() {
    }

    public DeprivedPersonDTO(User user) {
		super();
		this.user = user;
	}

	public DeprivedPersonDTO(UUID id, User user) {
		super();
		this.id = id;
		this.user = user;
	}

	public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

  

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeprivedPersonDTO deprivedPersonDTO = (DeprivedPersonDTO) o;
        return (user == deprivedPersonDTO.user) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
