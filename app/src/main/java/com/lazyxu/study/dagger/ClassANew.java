package com.lazyxu.study.dagger;

public class ClassANew {
    private ClassBNew classB;
    public ClassANew(ClassBNew classB) {
        this.classB = classB;
    }
    public String show() {
        return classB.getDsecribe();
    }
}
