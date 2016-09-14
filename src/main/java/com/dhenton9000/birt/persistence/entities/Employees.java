/**
 * register this is classes/META-INF/persistence.xml
 */
package com.dhenton9000.birt.persistence.entities;

import com.dhenton9000.jpa.domain.Identifiable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
 
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Employees")
@ApiModel(description = "the employee entity")
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findByid", query = "SELECT e FROM Employees e WHERE e.employeeNumber = :id")})

@XmlRootElement
public class Employees implements Serializable, Identifiable<Integer> {

    private static final long serialVersionUID = 1L;
    private Integer employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private String jobTitle;
    private Integer reportsTo;

    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_employeenumber_seq")
    @SequenceGenerator(name = "employees_employeenumber_seq", sequenceName = "employees_employeenumber_seq", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "EMPLOYEENUMBER", nullable = false)
    @ApiModelProperty(example = "1", required = true)
    public Integer getEmployeeNumber() {
        return this.employeeNumber;
    }

    public void setEmployeeNumber(Integer id) {
        this.employeeNumber = id;

    }

    @Override
    @Transient
    @JsonIgnore
     @ApiModelProperty(hidden =true)
    public Integer getPrimaryKey() {
        if (getEmployeeNumber() != null) {
            return getEmployeeNumber();
        } else {
            return null;
        }
    }

    @Override
    public void setPrimaryKey(Integer id) {
        this.employeeNumber = id;
    }

    @Override
    @Transient
    @JsonIgnore
     @ApiModelProperty(hidden =true)
    public boolean isPrimaryKeySet() {
        return this.employeeNumber != null;
    }

    /**
     * @return the lastName
     */
    @Column(name = "LASTNAME", length = 50)
    @ApiModelProperty(example = "Doe", required = true)
    @Basic(optional = false)
    public String getLastName() {
        if (lastName != null)
            return lastName.trim();
        else
            
            return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    @Column(name = "FIRSTNAME", length = 50)
    @ApiModelProperty(example = "Jane", required = true)
    @Basic(optional = false)
    public String getFirstName() {
        if (firstName != null)
            return firstName.trim();
        else
            
            return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the extension
     */
    @Column(name = "EXTENSION", length = 10)
    @ApiModelProperty(example = "9999", required = true)
    @Basic(optional = false)
    public String getExtension() {
         
         if (extension != null)
            return extension.trim();
        else
            
            return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * @return the email
     */
    @Column(name = "EMAIL", length = 100)
    @ApiModelProperty(example = "jane.doe@whattiz.com", required = true)
    @Basic(optional = false)
    public String getEmail() {
        if (email != null)
            return email.trim();
        else
            
            return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the officeCode
     */
    @Column(name = "OFFICECODE", length = 20)
    @ApiModelProperty(example = "35", required = false)
    @Basic(optional = false)
    public String getOfficeCode() {
        
        if (officeCode != null)
            return officeCode.trim();
        else
            
            return officeCode;
    }

    /**
     * @param officeCode the officeCode to set
     */
    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    /**
     * @return the jobTitle
     */
    @Column(name = "JOBTITLE", length = 50)
    @ApiModelProperty(example = "humble servant", required = true)
    @Basic(optional = false)
    public String getJobTitle() {
        if (jobTitle != null)
            return jobTitle.trim();
        else
            
            return jobTitle;
    }

    /**
     * @param jobTitle the jobTitle to set
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * @return the reportsTo
     */
    @Column(name = "REPORTSTO", length = 50, nullable = true)
    public Integer getReportsTo() {
        return reportsTo;
    }

    /**
     * @param reportsTo the reportsTo to set
     */
    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.employeeNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employees other = (Employees) obj;
        if (!Objects.equals(this.employeeNumber, other.employeeNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeNumber=" + employeeNumber + ", lastName=" + lastName + '}';
    }

}
