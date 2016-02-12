package uk.gov.scotland.afrc.applications.model.dto;
/**
 * This class is a common class and can be used for code or id and name fields.
 * @author d608865
 *
 */
public class CodeNameDTO {
	 private Long code;
	 private String name;
	 
	 public CodeNameDTO(){
		 
	 }

	public CodeNameDTO(long code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CodeNameDTO other = (CodeNameDTO) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CodeNameDTO [code=" + code + ", name=" + name + "]";
	}

}
