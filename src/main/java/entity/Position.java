package entity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import baseEntity.NameDescriptionEntity;

@Entity
@Table(name="positions")
public class Position extends NameDescriptionEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy = "position", fetch = FetchType.LAZY)
	private User user;

	
	
	/*---------------------GETTERS AND SETTERS---------------------*/

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
