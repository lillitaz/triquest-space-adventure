package com.codecool.mightytextadventure.data;

public record StaticObject(String name) {

    @Override
    public String toString() {
        return "StaticObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
