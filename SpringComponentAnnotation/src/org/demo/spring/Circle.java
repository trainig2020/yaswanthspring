package org.demo.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


//@Controller
//@Service
@Component
public class Circle implements Shape {

	private Point center;
	
	
	public Point getCenter() {
		return center;
	}

    @Resource(name = "pointB")
	public void setCenter(Point center) {
		this.center = center;
	}


	@Override
	public void draw() {
		
		System.out.println("Drawing Circle");
		System.out.println("Circle: Point is: (" +center.getX() +" ," +center.getY() + ")");
		
	}
	
	

}
