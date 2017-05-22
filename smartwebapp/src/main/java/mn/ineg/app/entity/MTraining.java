/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn.ineg.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "m_training")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MTraining.findAll", query = "SELECT m FROM MTraining m"),
    @NamedQuery(name = "MTraining.findById", query = "SELECT m FROM MTraining m WHERE m.id = :id"),
    @NamedQuery(name = "MTraining.findByTrainingDesc", query = "SELECT m FROM MTraining m WHERE m.trainingDesc = :trainingDesc"),
    @NamedQuery(name = "MTraining.findByStartDate", query = "SELECT m FROM MTraining m WHERE m.startDate = :startDate"),
    @NamedQuery(name = "MTraining.findByEndDate", query = "SELECT m FROM MTraining m WHERE m.endDate = :endDate"),
    @NamedQuery(name = "MTraining.findByCreatedDate", query = "SELECT m FROM MTraining m WHERE m.createdDate = :createdDate")})
public class MTraining implements Serializable {

    @OneToMany(mappedBy = "trainingId")
    private List<MTrainingStaff> mTrainingStaffList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2000)
    @Column(name = "training_desc")
    private String trainingDesc;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    @ManyToOne
    private MStaff staffId;
    @JoinColumn(name = "training_type_id", referencedColumnName = "id")
    @ManyToOne
    private MTrainingType trainingTypeId;

    public MTraining() {
    }

    public MTraining(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainingDesc() {
        return trainingDesc;
    }

    public void setTrainingDesc(String trainingDesc) {
        this.trainingDesc = trainingDesc;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public MStaff getStaffId() {
        return staffId;
    }

    public void setStaffId(MStaff staffId) {
        this.staffId = staffId;
    }

    public MTrainingType getTrainingTypeId() {
        return trainingTypeId;
    }

    public void setTrainingTypeId(MTrainingType trainingTypeId) {
        this.trainingTypeId = trainingTypeId;
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
        if (!(object instanceof MTraining)) {
            return false;
        }
        MTraining other = (MTraining) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mn.ineg.model.MTraining[ id=" + id + " ]";
    }

    @XmlTransient
    public List<MTrainingStaff> getMTrainingStaffList() {
        return mTrainingStaffList;
    }

    public void setMTrainingStaffList(List<MTrainingStaff> mTrainingStaffList) {
        this.mTrainingStaffList = mTrainingStaffList;
    }
    
}
