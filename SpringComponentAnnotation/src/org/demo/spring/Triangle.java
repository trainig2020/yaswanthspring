package org.demo.spring;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Triangle implements Shape{
    
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
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
		return pointC;
	}


	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}


	public void draw() {
		
		System.out.println("Drawing Triangle ");
   
		System.out.println("Point A = {" + getPointA().getX() + " , " + getPointA().getY() + "}");
				
		System.out.println("Point B = {" + getPointB().getX() + " , " + getPointB().getY() + "}");
			
		System.out.println("Point C = {" + getPointC().getX() + " , " + getPointC().getY() + "}");
				

	}



	
}
