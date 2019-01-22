package com.something.someproject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Apple {
	@Value(value="red")
	String color;
	
	@Value(value="4")
	Integer weight;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
}
