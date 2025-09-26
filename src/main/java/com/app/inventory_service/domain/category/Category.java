package com.app.inventory_service.domain.category;

public class Category {
    private final Long id;
    private String name;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {return id;}
    public String getName() {return name;}

    public void rename(String newName){
        if (newName == null || newName.isBlank()){
            throw new IllegalArgumentException("New name cannot be null or blank");
        }
        this.name = newName;
    }
}
