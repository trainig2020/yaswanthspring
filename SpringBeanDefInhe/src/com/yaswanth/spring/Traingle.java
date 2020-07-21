package com.yaswanth.spring;

public class Traingle {
	
	
	   private Point pointA;
	   private Point pointB;
	   private Point PointC;
	   
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return PointC;
	}

	public void setPointC(Point pointC) {
		PointC = pointC;
	}

	public void draw() {
    	System.out.println(getPointA().getX()+"-------"+getPointA().getY());
    	System.out.println(getPointB().getX()+"-------"+getPointB().getY());
    	System.out.println(getPointC().getX()+"-------"+getPointC().getY());
    }
}
