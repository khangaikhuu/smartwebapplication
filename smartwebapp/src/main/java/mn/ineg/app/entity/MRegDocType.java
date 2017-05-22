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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "m_reg_doc_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MRegDocType.findAll", query = "SELECT m FROM MRegDocType m"),
    @NamedQuery(name = "MRegDocType.findById", query = "SELECT m FROM MRegDocType m WHERE m.id = :id"),
    @NamedQuery(name = "MRegDocType.findByName", query = "SELECT m FROM MRegDocType m WHERE m.name = :name")})
public class MRegDocType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "docTypeId")
    private List<MRegDocTypeTypes> mRegDocTypeTypesList;

    public MRegDocType() {
    }

    public MRegDocType(Integer id) {
        this.id = id;
    }

    public MRegDocType(Integer id, String name) {
        this.id = id;
        this.name = name;
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
    
    public List<MRegDocTypeTypes> getMRegDocTypeTypesList() {
        return mRegDocTypeTypesList;
    }

    public void setMRegDocTypeTypesList(List<MRegDocTypeTypes> mRegDocTypeTypesList) {
        this.mRegDocTypeTypesList = mRegDocTypeTypesList;
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
        if (!(object instanceof MRegDocType)) {
            return false;
        }
        MRegDocType other = (MRegDocType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mn.ineg.model.MRegDocType[ id=" + id + " ]";
    }
    
}
