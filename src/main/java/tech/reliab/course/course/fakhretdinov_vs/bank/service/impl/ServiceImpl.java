package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.function.Function;


public class ServiceImpl<T extends Identifier> implements Service<T> {

    HashMap<Long, T> objects;

    public T get(Long id) {

        if (objects.containsKey(id)) {
            return objects.get(id);
        }
        return null;

    };

    public void update(T obj) {

        objects.put(obj.getId(), obj);

    };

    public void delete(T obj) {

        objects.remove(obj.getId());

    };

    public ArrayList<T> grep(Function<T, Boolean> func) {

        ArrayList<T> filtered_objects = new ArrayList<>();

        for (Long id : objects.keySet()) {
            T obj = this.objects.get(id);
            if (func.apply(obj)) {
                filtered_objects.add(obj);
            }
        }

        return filtered_objects;

    }


}
