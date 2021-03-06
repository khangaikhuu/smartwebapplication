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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "w_external_link")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WExternalLink.findAll", query = "SELECT w FROM WExternalLink w"),
    @NamedQuery(name = "WExternalLink.findById", query = "SELECT w FROM WExternalLink w WHERE w.id = :id"),
    @NamedQuery(name = "WExternalLink.findByName", query = "SELECT w FROM WExternalLink w WHERE w.name = :name"),
    @NamedQuery(name = "WExternalLink.findByUrl", query = "SELECT w FROM WExternalLink w WHERE w.url = :url")})
public class WExternalLink implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "name")
    private String name;
    @Size(max = 2000)
    @Column(name = "url")
    private String url;

    public WExternalLink() {
    }

    public WExternalLink(Integer id) {
        this.id = id;
    }

    public WExternalLink(Integer id, String name) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof WExternalLink)) {
            return false;
        }
        WExternalLink other = (WExternalLink) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mn.ineg.model.WExternalLink[ id=" + id + " ]";
    }
    
}
