package net.web.app.senior.bll.manager;

import net.web.app.senior.beans.CategoryBean;
import net.web.app.senior.beans.ProductBean;

public interface MenuManager {

    public ProductBean addProduct(ProductBean product);

    public ProductBean updateProduct(ProductBean product);

    public CategoryBean addCategory(CategoryBean product);

    public CategoryBean updateCategory(CategoryBean product);

}
