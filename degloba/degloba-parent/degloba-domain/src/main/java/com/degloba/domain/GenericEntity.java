package com.degloba.domain;

/**
 * 
 * @author pere
 *
 * https://ultimate.systems/web/blog/generic-controllers-and-services-in-spring-boot-java
 * 
 * @param <T>
 */
public interface GenericEntity<T> {

    // update current instance with provided data
    void update(T source);

    Long getId();

    // based on current data create new instance with new id
    T createNewInstance();

}
