package net.web.app.senior.beans;

public class ProductBean {

    private Integer id;
    private String name;
    private String nameAr;
    private String nameEn;

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

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionAr() {
        return descriptionAr;
    }

    public void setDescriptionAr(String descriptionAr) {
        this.descriptionAr = descriptionAr;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public CategoryBean getCategoryBean() {
        return categoryBean;
    }

    public void setCategoryBean(CategoryBean categoryBean) {
        this.categoryBean = categoryBean;
    }

    public ProductBean(Integer id, String name, String nameAr, String nameEn, float price, String description, String descriptionAr, String descriptionEn, String imagePath, byte active, CategoryBean categoryBean) {
        this.id = id;
        this.name = name;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.price = price;
        this.description = description;
        this.descriptionAr = descriptionAr;
        this.descriptionEn = descriptionEn;
        this.imagePath = imagePath;
        this.active = active;
        this.categoryBean = categoryBean;
    }
    private float price;
    private String description;
    private String descriptionAr;
    private String descriptionEn;
    private String imagePath;
    private byte active;
    private CategoryBean categoryBean;

}
