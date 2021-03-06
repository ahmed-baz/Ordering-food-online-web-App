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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product",
         catalog = "senior_app"
)
public class ProductEntity implements java.io.Serializable {

    private Integer id;
    private CategoryEntity category;
    private String nameAr;
    private String nameEn;
    private float price;
    private String descriptionAr;
    private String descriptionEn;
    private String imagePath;
    private byte active;
    private Set<OrderItemEntity> orderItems = new HashSet<OrderItemEntity>(0);

    public ProductEntity() {
    }

    public ProductEntity(CategoryEntity category, String nameAr, String nameEn, float price, byte active) {
        this.category = category;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.price = price;
        this.active = active;
    }

    public ProductEntity(CategoryEntity category, String nameAr, String nameEn, float price, String descriptionAr, String descriptionEn, String imagePath, byte active, Set<OrderItemEntity> orderItems) {
        this.category = category;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.price = price;
        this.descriptionAr = descriptionAr;
        this.descriptionEn = descriptionEn;
        this.imagePath = imagePath;
        this.active = active;
        this.orderItems = orderItems;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    public CategoryEntity getCategory() {
        return this.category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Column(name = "name_ar", nullable = false)
    public String getNameAr() {
        return this.nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    @Column(name = "name_en", nullable = false)
    public String getNameEn() {
        return this.nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Column(name = "price", nullable = false, precision = 12, scale = 0)
    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Column(name = "description_ar", length = 65535)
    public String getDescriptionAr() {
        return this.descriptionAr;
    }

    public void setDescriptionAr(String descriptionAr) {
        this.descriptionAr = descriptionAr;
    }

    @Column(name = "description_en", length = 65535)
    public String getDescriptionEn() {
        return this.descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    @Column(name = "image_path")
    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Column(name = "active", nullable = false)
    public byte getActive() {
        return this.active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public Set<OrderItemEntity> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(Set<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

}
