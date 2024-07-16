/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova2.entities;

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

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "cadeira")
@NamedQueries({
    @NamedQuery(name = "Cadeira.findAll", query = "SELECT c FROM Cadeira c"),
    @NamedQuery(name = "Cadeira.findById", query = "SELECT c FROM Cadeira c WHERE c.id = :id"),
    @NamedQuery(name = "Cadeira.findByTipo", query = "SELECT c FROM Cadeira c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Cadeira.findByMaterial", query = "SELECT c FROM Cadeira c WHERE c.material = :material"),
    @NamedQuery(name = "Cadeira.findByPernas", query = "SELECT c FROM Cadeira c WHERE c.pernas = :pernas"),
    @NamedQuery(name = "Cadeira.findByUso", query = "SELECT c FROM Cadeira c WHERE c.uso = :uso")})
public class Cadeira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "material")
    private String material;
    @Basic(optional = false)
    @Column(name = "pernas")
    private int pernas;
    @Basic(optional = false)
    @Column(name = "uso")
    private String uso;

    public Cadeira() {
    }

    public Cadeira(Integer id) {
        this.id = id;
    }

    public Cadeira(Integer id, String tipo, String material, int pernas, String uso) {
        this.id = id;
        this.tipo = tipo;
        this.material = material;
        this.pernas = pernas;
        this.uso = uso;
    }
    
    public Cadeira(String tipo, String material, int pernas, String uso) {
        this.tipo = tipo;
        this.material = material;
        this.pernas = pernas;
        this.uso = uso;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getPernas() {
        return pernas;
    }

    public void setPernas(int pernas) {
        this.pernas = pernas;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
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
        if (!(object instanceof Cadeira)) {
            return false;
        }
        Cadeira other = (Cadeira) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova2.entities.Cadeira[ id=" + id + " ]";
    }
    
}
