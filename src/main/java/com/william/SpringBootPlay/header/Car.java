package com.william.SpringBootPlay.header;

class Car {

    private String model;
    private int displacement;

    public Car(String model, int displacement) {
        this.model = model;
        this.displacement = displacement;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

}



