package tech.reliab.course.course.fakhretdinov_vs.bank.service.core;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.util.ArrayList;
import java.util.function.Function;


public interface ServiceContainer<T extends Identifier> {

    public T get(Long id);
    public void update(T model);
    public void delete(T model);
    public ArrayList<T> grep(Function<T, Boolean> func);

}