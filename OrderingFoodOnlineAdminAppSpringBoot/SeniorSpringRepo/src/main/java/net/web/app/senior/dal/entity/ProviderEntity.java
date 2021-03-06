package net.web.app.senior.dal.entity;
// Generated Feb 3, 2020 1:56:25 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Provider generated by hbm2java
 */
@Entity
@Table(name = "provider",
        catalog = "senior_app",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "name_ar")
            , @UniqueConstraint(columnNames = "name_en")}
)
public class ProviderEntity implements java.io.Serializable {

    private Integer id;
    private String nameAr;
    private String nameEn;
    private String hotline;
    private String logoPathAr;
    private String logoPathEn;
    private Set<CategoryEntity> categories = new HashSet<CategoryEntity>(0);
    private Set<BranchEntity> branches = new HashSet<BranchEntity>(0);
    private Set<ProviderUserEntity> providerUsers = new HashSet<ProviderUserEntity>(0);

    public ProviderEntity() {
    }

    public ProviderEntity(String nameAr, String nameEn) {
        this.nameAr = nameAr;
        this.nameEn = nameEn;
    }

    public ProviderEntity(String nameAr, String nameEn, String hotline, String logoPathAr, String logoPathEn, Set<CategoryEntity> categories, Set<BranchEntity> branches, Set<ProviderUserEntity> providerUsers) {
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.hotline = hotline;
        this.logoPathAr = logoPathAr;
        this.logoPathEn = logoPathEn;
        this.categories = categories;
        this.branches = branches;
        this.providerUsers = providerUsers;
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

    @Column(name = "name_ar", unique = true, nullable = false)
    public String getNameAr() {
        return this.nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    @Column(name = "name_en", unique = true, nullable = false)
    public String getNameEn() {
        return this.nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Column(name = "hotline", length = 15, unique = true)
    public String getHotline() {
        return this.hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    @Column(name = "logo_path_ar")
    public String getLogoPathAr() {
        return this.logoPathAr;
    }

    public void setLogoPathAr(String logoPathAr) {
        this.logoPathAr = logoPathAr;
    }

    @Column(name = "logo_path_en")
    public String getLogoPathEn() {
        return this.logoPathEn;
    }

    public void setLogoPathEn(String logoPathEn) {
        this.logoPathEn = logoPathEn;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "provider")
    public Set<CategoryEntity> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "provider")
    public Set<BranchEntity> getBranches() {
        return this.branches;
    }

    public void setBranches(Set<BranchEntity> branches) {
        this.branches = branches;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "provider")
    public Set<ProviderUserEntity> getProviderUsers() {
        return this.providerUsers;
    }

    public void setProviderUsers(Set<ProviderUserEntity> providerUsers) {
        this.providerUsers = providerUsers;
    }

}
