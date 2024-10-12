package com.mftplus.demo.model.service;

import java.util.List;

public interface Service <T,I>{
    public void save(T t)throws Exception;
    public void edit(T t)throws Exception;
    public void remove(I id)throws Exception;
    public T findById(I id)throws Exception;
    public List<T> findAll()throws Exception;
}
