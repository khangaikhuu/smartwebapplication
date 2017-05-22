/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn.ineg.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "mn_reg_doc_ineg_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MnRegDocInegDetails.findAll", query = "SELECT m FROM MnRegDocInegDetails m"),
    @NamedQuery(name = "MnRegDocInegDetails.findById", query = "SELECT m FROM MnRegDocInegDetails m WHERE m.id = :id"),
    @NamedQuery(name = "MnRegDocInegDetails.findByRegNumber", query = "SELECT m FROM MnRegDocInegDetails m WHERE m.regNumber = :regNumber"),
    @NamedQuery(name = "MnRegDocInegDetails.findByRegApprovedYear", query = "SELECT m FROM MnRegDocInegDetails m WHERE m.regApprovedYear = :regApprovedYear"),
    @NamedQuery(name = "MnRegDocInegDetails.findByRegDoneBy", query = "SELECT m FROM MnRegDocInegDetails m WHERE m.regDoneBy = :regDoneBy"),
    @NamedQuery(name = "MnRegDocInegDetails.findByRegCreatedBy", query = "SELECT m FROM MnRegDocInegDetails m WHERE m.regCreatedBy = :regCreatedBy"),
    @NamedQuery(name = "MnRegDocInegDetails.findByFilePath", query = "SELECT m FROM MnRegDocInegDetails m WHERE m.filePath = :filePath")})
public class MnRegDocInegDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "reg_number")
    private String regNumber;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "reg_content")
    private String regContent;
    @Column(name = "reg_approved_year")
    @Temporal(TemporalType.DATE)
    private Date regApprovedYear;
    @Size(max = 300)
    @Column(name = "reg_done_by")
    private String regDoneBy;
    @Size(max = 300)
    @Column(name = "reg_created_by")
    private String regCreatedBy;
    @Size(max = 1000)
    @Column(name = "file_path")
    private String filePath;
    @JoinColumn(name = "doc_type_id", referencedColumnName = "id")
    @ManyToOne
    private MRegDocTypeTypes docTypeId;

    public MnRegDocInegDetails() {
    }

    public MnRegDocInegDetails(Integer id) {
        this.id = id;
    }

    public MnRegDocInegDetails(Integer id, String regNumber, String regContent) {
        this.id = id;
        this.regNumber = regNumber;
        this.regContent = regContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    @JsonProperty("name")
    public String getRegContent() {
        return regContent;
    }

    public void setRegContent(String regContent) {
        this.regContent = regContent;
    }

    public Date getRegApprovedYear() {
        return regApprovedYear;
    }

    public void setRegApprovedYear(Date regApprovedYear) {
        this.regApprovedYear = regApprovedYear;
    }

    public String getRegDoneBy() {
        return regDoneBy;
    }

    public void setRegDoneBy(String regDoneBy) {
        this.regDoneBy = regDoneBy;
    }

    public String getRegCreatedBy() {
        return regCreatedBy;
    }

    public void setRegCreatedBy(String regCreatedBy) {
        this.regCreatedBy = regCreatedBy;
    }

    @JsonProperty("path")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @JsonIgnore
    public MRegDocTypeTypes getDocTypeId() {
        return docTypeId;
    }

    public void setDocTypeId(MRegDocTypeTypes docTypeId) {
        this.docTypeId = docTypeId;
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
        if (!(object instanceof MnRegDocInegDetails)) {
            return false;
        }
        MnRegDocInegDetails other = (MnRegDocInegDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mn.ineg.model.MnRegDocInegDetails[ id=" + id + " ]";
    }
    
}
