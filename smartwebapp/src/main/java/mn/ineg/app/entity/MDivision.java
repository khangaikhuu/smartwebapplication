/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn.ineg.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "m_division")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MDivision.findAll", query = "SELECT m FROM MDivision m")})
public class MDivision implements Serializable {

    @OneToMany(mappedBy = "divisionId")
    private List<MFeedback> mFeedbackList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "vacancy")
    private Integer vacancy;
    @OneToMany(mappedBy = "divisionId")
    
    private List<MStaff> mStaffList;

    @OneToMany(mappedBy = "divisionId")
    
    private List<MDivisionContent> contentList;

    public MDivision() {
    }

    public MDivision(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVacancy() {
        return vacancy;
    }

    public void setVacancy(Integer vacancy) {
        this.vacancy = vacancy;
    }

    @XmlTransient
    @JsonIgnore
    public List<MStaff> getMStaffList() {
        return mStaffList;
    }

    public void setMStaffList(List<MStaff> mStaffList) {
        this.mStaffList = mStaffList;
    }

    @XmlTransient
    @JsonProperty("contentList")
    public List<MDivisionContent> getContentList() {
        return contentList;
    }

    public void setContentList(List<MDivisionContent> contentList) {
        this.contentList = contentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MDivision)) {
            return false;
        }
        MDivision other = (MDivision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mn.ineg.model.MDivision[ id=" + id + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public List<MFeedback> getMFeedbackList() {
        return mFeedbackList;
    }

    public void setMFeedbackList(List<MFeedback> mFeedbackList) {
        this.mFeedbackList = mFeedbackList;
    }

}
