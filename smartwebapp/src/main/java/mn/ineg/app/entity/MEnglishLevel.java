/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn.ineg.app.entity;

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
@Table(name = "m_english_level")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MEnglishLevel.findAll", query = "SELECT m FROM MEnglishLevel m"),
    @NamedQuery(name = "MEnglishLevel.findById", query = "SELECT m FROM MEnglishLevel m WHERE m.id = :id"),
    @NamedQuery(name = "MEnglishLevel.findByName", query = "SELECT m FROM MEnglishLevel m WHERE m.name = :name")})
public class MEnglishLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "engLevelId")
    private List<MStaff> mStaffList;

    public MEnglishLevel() {
    }

    public MEnglishLevel(Integer id) {
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

    @XmlTransient
    public List<MStaff> getMStaffList() {
        return mStaffList;
    }

    public void setMStaffList(List<MStaff> mStaffList) {
        this.mStaffList = mStaffList;
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
        if (!(object instanceof MEnglishLevel)) {
            return false;
        }
        MEnglishLevel other = (MEnglishLevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mn.ineg.model.MEnglishLevel[ id=" + id + " ]";
    }
    
}
