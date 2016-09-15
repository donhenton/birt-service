
package com.dhenton9000.birt.persistence.dao;

import com.dhenton9000.birt.persistence.entities.Offices;
import com.dhenton9000.jpa.dao.support.GenericDao;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface OfficesDao extends GenericDao<Offices, String> {
    
    public List<Offices> getAllOffices();
}
