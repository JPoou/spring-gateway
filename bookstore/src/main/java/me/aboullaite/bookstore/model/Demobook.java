package me.aboullaite.bookstore.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author mmendez
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Demobook.findAll", query = "SELECT d FROM Demobook d")})
@Cacheable
@Cache(region = "demoBook", usage = CacheConcurrencyStrategy.READ_ONLY)
public class Demobook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String name;

    public Demobook() {
    }

    public Demobook(Integer id) {
        this.id = id;
    }

    public Demobook(Integer id, String name) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demobook)) {
            return false;
        }
        Demobook other = (Demobook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Demobook[ id=" + id + " ]";
    }

}
