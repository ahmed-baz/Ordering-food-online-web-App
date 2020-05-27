package net.web.app.senior.bll.transformer;

public interface GeneralTransformer<E, B> {

    public E fromBeanToEntity(B bean);
    public B fromEntityToBean(E entity, String lang);
}
