package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "DATA_CHANGE_EVENT_TYPE")
@EntityListeners(BaseTableListener.class)
public class DataChangeEventTypeDBO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CODE")
    private long code;

    @Column(name = "NAME")
    private String name;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
