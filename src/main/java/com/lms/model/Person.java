package com.lms.model;

import java.util.UUID;

public abstract class Person {
  UUID id;
  String name;
  int age;
  String gender;

  public Person(String name, int age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.id = UUID.randomUUID();
  }

  public UUID getId() {
    return this.id;
  }
}
