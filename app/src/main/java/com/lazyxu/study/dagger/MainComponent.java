package com.lazyxu.study.dagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ModuleTest.class)
public interface MainComponent {
    void inject(DaggerActivity activity);
}