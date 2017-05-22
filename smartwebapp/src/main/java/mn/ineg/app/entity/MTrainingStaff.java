/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn.ineg.app.entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "m_training_staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MTrainingStaff.findAll", query = "SELECT m FROM MTrainingStaff m"),
    @NamedQuery(name = "MTrainingStaff.findById", query = "SELECT m FROM MTrainingStaff m WHERE m.id = :id"),
    @NamedQuery(name = "MTrainingStaff.findByFileName", query = "SELECT m FROM MTrainingStaff m WHERE m.fileName = :fileName")})
public class MTrainingStaff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "file_name")
    private String fileName;
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    @ManyToOne
    private MStaff staffId;
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    @ManyToOne
    private MTraining trainingId;

    public MTrainingStaff() {
    }

    public MTrainingStaff(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MStaff getStaffId() {
        return staffId;
    }

    public void setStaffId(MStaff staffId) {
        this.staffId = staffId;
    }

    public MTraining getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(MTraining trainingId) {
        this.trainingId = trainingId;
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
        if (!(object instanceof MTrainingStaff)) {
            return false;
        }
        MTrainingStaff other = (MTrainingStaff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mn.ineg.model.MTrainingStaff[ id=" + id + " ]";
    }
    
}
