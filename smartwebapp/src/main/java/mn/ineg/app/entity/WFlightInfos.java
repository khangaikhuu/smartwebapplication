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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "w_flight_infos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WFlightInfos.findAll", query = "SELECT w FROM WFlightInfos w"),
    @NamedQuery(name = "WFlightInfos.findById", query = "SELECT w FROM WFlightInfos w WHERE w.id = :id"),
    @NamedQuery(name = "WFlightInfos.findByNumber", query = "SELECT w FROM WFlightInfos w WHERE w.number = :number"),
    @NamedQuery(name = "WFlightInfos.findByDate", query = "SELECT w FROM WFlightInfos w WHERE w.date = :date")})
public class WFlightInfos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne
    private WFlightInfoType typeId;

    public WFlightInfos() {
    }

    public WFlightInfos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JsonIgnore
    public WFlightInfoType getTypeId() {
        return typeId;
    }

    public void setTypeId(WFlightInfoType typeId) {
        this.typeId = typeId;
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
        if (!(object instanceof WFlightInfos)) {
            return false;
        }
        WFlightInfos other = (WFlightInfos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mn.ineg.model.WFlightInfos[ id=" + id + " ]";
    }
    
}
