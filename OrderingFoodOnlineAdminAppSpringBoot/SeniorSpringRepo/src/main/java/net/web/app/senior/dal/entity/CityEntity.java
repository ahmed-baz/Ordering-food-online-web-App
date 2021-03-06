package net.web.app.senior.dal.entity;
// Generated Feb 3, 2020 1:56:25 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * City generated by hbm2java
 */

@Entity
@Table(name = "city",
        catalog = "senior_app",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "name_ar")
            , @UniqueConstraint(columnNames = "name_en")}
)
public class CityEntity implements java.io.Serializable {

    private Integer id;
    private String nameAr;
    private String nameEn;
    private Set<AreaEntity> areas = new HashSet<AreaEntity>(0);

    public CityEntity() {
    }

    public CityEntity(String nameAr, String nameEn) {
        this.nameAr = nameAr;
        this.nameEn = nameEn;
    }

    public CityEntity(String nameAr, String nameEn, Set<AreaEntity> areas) {
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.areas = areas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name_ar", unique = true, nullable = false, length = 100)
    public String getNameAr() {
        return this.nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    @Column(name = "name_en", unique = true, nullable = false, length = 100)
    public String getNameEn() {
        return this.nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city", cascade = {CascadeType.ALL, CascadeType.REMOVE})
    public Set<AreaEntity> getAreas() {
        return this.areas;
    }

    public void setAreas(Set<AreaEntity> areas) {
        this.areas = areas;
    }

}
