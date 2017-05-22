/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn.ineg.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "m_feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MFeedback.findAll", query = "SELECT m FROM MFeedback m"),
    @NamedQuery(name = "MFeedback.findById", query = "SELECT m FROM MFeedback m WHERE m.id = :id"),
    @NamedQuery(name = "MFeedback.findByTitle", query = "SELECT m FROM MFeedback m WHERE m.title = :title"),
    @NamedQuery(name = "MFeedback.findByDescription", query = "SELECT m FROM MFeedback m WHERE m.description = :description"),
    @NamedQuery(name = "MFeedback.findByCreatedDate", query = "SELECT m FROM MFeedback m WHERE m.createdDate = :createdDate")})
public class MFeedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "title")
    private String title;
    @Size(max = 2000)
    @Column(name = "description")
    private String description;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    @ManyToOne
    private MDivision divisionId;
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    @ManyToOne
    private MStaff staffId;

    public MFeedback() {
    }

    public MFeedback(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @JsonIgnore
    public MDivision getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(MDivision divisionId) {
        this.divisionId = divisionId;
    }
    
    @JsonIgnore
    public MStaff getStaffId() {
        return staffId;
    }

    public void setStaffId(MStaff staffId) {
        this.staffId = staffId;
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
        if (!(object instanceof MFeedback)) {
            return false;
        }
        MFeedback other = (MFeedback) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mn.ineg.model.MFeedback[ id=" + id + " ]";
    }
    
}
