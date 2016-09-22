package io.ravi.services;

public class Result<T, T1> {

    private T value;
    private T1 names;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T1 getNames() {
        return names;
    }

    public void setNames(T1 names) {
        this.names = names;
    }
}
