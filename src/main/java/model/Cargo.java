package model;

import java.util.Objects;

public class Cargo {
    private String type;
    private double length;
    private double width;
    private double depth;
    private double weight;

    public Cargo() {
    }

    public Cargo(String type, double length, double width, double depth, double weight) {
        this.type = type;
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cargo)) return false;
        Cargo cargo = (Cargo) o;
        return Double.compare(cargo.getLength(), getLength()) == 0 &&
                Double.compare(cargo.getWidth(), getWidth()) == 0 &&
                Double.compare(cargo.getDepth(), getDepth()) == 0 &&
                Double.compare(cargo.getWeight(), getWeight()) == 0 &&
                Objects.equals(getType(), cargo.getType());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getType(), getLength(), getWidth(), getDepth(), getWeight());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
