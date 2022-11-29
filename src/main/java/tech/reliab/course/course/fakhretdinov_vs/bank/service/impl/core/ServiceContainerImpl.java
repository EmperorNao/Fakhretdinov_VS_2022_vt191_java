package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;


public class ServiceContainerImpl<T extends Identifier> implements ServiceContainer<T> {

    HashMap<Long, T> objects = new HashMap<>();

    @Override
    public T get(Long id) {

        if (objects.containsKey(id)) {
            return objects.get(id);
        }
        //TODO throw exception
        return null;

    }

    @Override
    public void update(T obj) {

        objects.put(obj.getId(), obj);

    }

    @Override
    public void delete(T obj) {

        objects.remove(obj.getId());

    }

    @Override
    public ArrayList<T> getByCondition(Function<T, Boolean> condition) {

        ArrayList<T> filtered_objects = new ArrayList<>();

        for (Long id : objects.keySet()) {
            T obj = this.objects.get(id);
            if (condition.apply(obj)) {
                filtered_objects.add(obj);
            }
        }

        return filtered_objects;

    }


}
