
package com.dhenton9000.birt.persistence.dao;

import com.dhenton9000.birt.persistence.entities.Products;
import com.dhenton9000.jpa.dao.support.GenericDao;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface ProductsDao extends GenericDao<Products, String> {
    
    public List<Products> getAllProducts();
}
