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
@Table (name = "sectors")
public class Sector extends NameDescriptionEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy = "sector", fetch = FetchType.LAZY)
	private Company company;

	/*---------------------GETTERS AND SETTERS---------------------*/

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
