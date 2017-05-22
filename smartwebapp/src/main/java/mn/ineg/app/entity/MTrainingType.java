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
@Table(name = "m_training_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MTrainingType.findAll", query = "SELECT m FROM MTrainingType m"),
    @NamedQuery(name = "MTrainingType.findById", query = "SELECT m FROM MTrainingType m WHERE m.id = :id"),
    @NamedQuery(name = "MTrainingType.findByName", query = "SELECT m FROM MTrainingType m WHERE m.name = :name"),
    @NamedQuery(name = "MTrainingType.findByOrderView", query = "SELECT m FROM MTrainingType m WHERE m.orderView = :orderView")})
public class MTrainingType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "order_view")
    private Integer orderView;
    @OneToMany(mappedBy = "trainingTypeId")
    private List<MTraining> mTrainingList;

    public MTrainingType() {
    }

    public MTrainingType(Integer id) {
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

    public Integer getOrderView() {
        return orderView;
    }

    public void setOrderView(Integer orderView) {
        this.orderView = orderView;
    }

    @XmlTransient
    public List<MTraining> getMTrainingList() {
        return mTrainingList;
    }

    public void setMTrainingList(List<MTraining> mTrainingList) {
        this.mTrainingList = mTrainingList;
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
        if (!(object instanceof MTrainingType)) {
            return false;
        }
        MTrainingType other = (MTrainingType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mn.ineg.model.MTrainingType[ id=" + id + " ]";
    }
    
}
