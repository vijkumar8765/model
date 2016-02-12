package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APPLICATION_STATUS_TYPE")
@javax.persistence.Cacheable
public class ApplicationStatusTypeDBO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "CODE")
    private long code;

    @Column(name = "DESCRIPTION")
    private String description;
    
    @OneToMany(mappedBy="applicationStatusType", cascade=CascadeType.PERSIST)
    private List<ApplicationStatusReasonTypeDBO> applicationStatusReasonTypes;
    
    @Column(name = "NAME")
    private String name;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

   public List<ApplicationStatusReasonTypeDBO> getApplicationStatusReasonTypes() {
        return applicationStatusReasonTypes;
	}
	public String getName() {
		return name;
    }

    public void setApplicationStatusReasonTypes(List<ApplicationStatusReasonTypeDBO> applicationStatusReasonTypes) {
        this.applicationStatusReasonTypes = applicationStatusReasonTypes;
    }

   


	public void setName(String name) {
		this.name = name;
	}
    
}
