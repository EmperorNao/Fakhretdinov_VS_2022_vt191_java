package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.function.Function;


public interface Service<T extends Identifier> {

    public T get(Long id);
    public void update(T model);
    public void delete(T model);
    public ArrayList<T> grep(Function<T, Boolean> func)

}