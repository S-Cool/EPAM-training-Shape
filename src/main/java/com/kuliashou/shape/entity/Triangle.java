package com.kuliashou.shape.entity;

import com.kuliashou.shape.creator.Figure;
import com.kuliashou.shape.event.TriangleEvent;
import com.kuliashou.shape.generator.IdGenerator;
import com.kuliashou.shape.observer.TriangleObserved;
import com.kuliashou.shape.observer.TriangleObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Triangle implements Figure, TriangleObserved {

    private List<TriangleObserver> observers = new ArrayList<>();

    private long triangleId;
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.triangleId = IdGenerator.generateId();
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public long getTriangleId() {
        return triangleId;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
        notifyObservers();
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
        notifyObservers();
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(pointA, triangle.pointA) &&
                Objects.equals(pointB, triangle.pointB) &&
                Objects.equals(pointC, triangle.pointC);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pointA, pointB, pointC);
    }

    @Override
    public String toString() {
        return "TriangleRegister{" +
                "triangleId=" + triangleId +
                ", pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                '}';
    }

    @Override
    public void showFigure() {
        toString();
    }

    @Override
    public void addObserver(TriangleObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(TriangleObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (TriangleObserver o : observers) {
            if (o != null) {
                o.handleEvent(new TriangleEvent(this));
            }
        }
    }
}
