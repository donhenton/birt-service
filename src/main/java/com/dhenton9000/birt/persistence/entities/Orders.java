/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.persistence.entities;

import com.dhenton9000.jpa.domain.Identifiable;
import static com.dhenton9000.jpa.util.EntityUtils.trimField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/*
orderNumber SERIAL PRIMARY KEY,
  orderDate timestamp NOT NULL,
  requiredDate timestamp NOT NULL,
  shippedDate timestamp NULL,
  status CHAR(15) NOT NULL,
  comments TEXT NULL,
  customerNumber INT NOT NULL
*/

@Entity
@Table(name = "orders")
@ApiModel(description = "the orders entity")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT e FROM Orders e"),
    @NamedQuery(name = "Orders.findByid", query = "SELECT e FROM Orders e WHERE e.orderNumber = :id")})

@XmlRootElement
public class Orders implements Serializable, Identifiable<Integer> {

    
    private Date  orderDate;
    private Date  requiredDate;
    private Date  shippedDate;
    private String status;
    private String comments;
    private Integer customerNumber;
    private Integer orderNumber;

    @Override
    @Transient
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public Integer getPrimaryKey() {
        if (getOrderNumber() != null) {
            return getOrderNumber();
        } else {
            return null;
        }
    }

    @Override
    public void setPrimaryKey(Integer id) {
        this.setOrderNumber(id);
    }

    @Override
    @Transient
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public boolean isPrimaryKeySet() {
        return this.getOrderNumber() != null;
    }

    /**
     * @return the officeCode
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ORDERNUMBER", nullable = false)
    public Integer getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(Integer n) {
        this.orderNumber = n;
    }

    /**
     * @return the phone
     */
    @Column(name = "ORDERDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(example = "2/2/2014", required = true)
    @Basic(optional = false)
    public Date getorderDate() {
        return this.orderDate;
    }

    /**
     * @param orderDate the order date to set
     */
    public void setorderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the requiredDate
     */
    @Column(name = "REQUIREDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(example = "2/22/2013", required = true)
    @Basic(optional = false)
    public Date getRequiredDate() {
        return requiredDate;
    }

    /**
     * @param rDate the date to set
     */
    public void setRequiredDate(Date rDate) {
        this.requiredDate = rDate;
    }

    /**
     * @return the shippedDate
     */
    @Column(name = "SHIPPEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(example = "2/22/2013", required = true)
    @Basic(optional = false)
    public Date getShippedDate() {
        return shippedDate;
    }

    /**
     * @param rDate the date to set
     */
    public void setShippedDate(Date rDate) {
        this.shippedDate = rDate;
    }

    /**
     * @return the state
     */
    @Column(name = "STATUS", length = 15)
    @ApiModelProperty(example = "DONE", required = true)
    @Basic(optional = false)
    public String getStatus() {
        return trimField(status);
    }

    /**
     * @param st the status to set
     */
    public void setStatus(String st) {
        this.status = st;
    }

    /**
     * @return the country
     */
    @Column(name = "COMMENTS", length = 50)
    @ApiModelProperty(example = "stuff", required = true)
    @Basic(optional = false)
    public String getComments() {
        return trimField(comments);
    }

    /**
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    

   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.getOrderNumber());
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
        final Orders other = (Orders) obj;
        if (!Objects.equals(this.orderNumber, other.orderNumber)) {
            return false;
        }
        return true;
    }

    /**
     * @return the customerNumber
     */
    @Column(name = "CUSTOMERNUMBER")
    @ApiModelProperty(example = "33", required = true)
    @Basic(optional = false)
    public Integer getCustomerNumber() {
        return customerNumber;
    }

    /**
     * @param customerNumber the customerNumber to set
     */
    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }
 
 

}
