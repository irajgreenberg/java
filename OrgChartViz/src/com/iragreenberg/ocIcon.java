package com.iragreenberg;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;

public class ocIcon {

	/**
	 *
	 */
	public PApplet p;
	public PVector pos, initPos;
	public float radius;
	public ocIconDetail shape;
	public ArrayList<PVector> vecs;
	public int detail = 36;
	private boolean isBeingHit = false;
	private boolean isResettable;
	private float spd = 10.2f;
	private PVector resetVector = new PVector();
	private PVector temp = new PVector();

	public ocIcon() {
	}

	public ocIcon(PApplet p, PVector pos, float radius, ocIconDetail shape) {
		this.p = p;
		this.pos = pos;
		initPos = new PVector(pos.x, pos.y);
		//spd = new PVector
		this.radius = radius;
		this.shape = shape;
		vecs = new ArrayList<PVector>();
		float theta = 0.0f;
		switch (shape) {
		case CIRCLE:
			theta = 0;
			for (int i = 0; i < detail; i++) {
				vecs.add(new PVector(p.cos(theta) * radius, p.sin(theta) * radius));
				theta += p.TWO_PI / detail;
			}
			break;
		case TRIANGLE:
			theta = -p.PI/2.0f;
			for (int i = 0; i < 3; i++) {
				vecs.add(new PVector(p.cos(theta) * radius, p.sin(theta) * radius));
				theta += p.TWO_PI / 3;
			}
			break;
		case SQUARE:
			theta = -p.PI/4.0f;
			for (int i = 0; i < 4; i++) {
				vecs.add(new PVector(p.cos(theta) * radius, p.sin(theta) * radius));
				theta += p.TWO_PI / 4;
			}
			break;
		case RECTANGLE:
			theta = -p.PI/4.0f;
			for (int i = 0; i < 4; i++) {
				vecs.add(new PVector(p.cos(theta) * radius*1.5f, p.sin(theta) * radius));
				theta += p.TWO_PI / 4;
			}
			break;
		default:
			break;
		}
	}

	public void draw() {
		p.pushMatrix();
		p.translate(pos.x, pos.y);
		p.beginShape();
		for(PVector v: vecs){
			p.vertex(v.x, v.y);
		}
		p.endShape(p.CLOSE);
		p.popMatrix();
		
		if(p.mousePressed && isBeingHit){
			pos.x = p.mouseX;
			pos.y = p.mouseY;
			
			temp.set(pos);
			temp.sub(initPos);
			temp.normalize();
			temp.mult(spd);
//			//resetVector
		}
		
		if(isResettable){
			if(p.dist(pos.x, pos.y, initPos.x, initPos.y)> 5){
				pos.sub(temp);
			}
		}
		
		
	}
	
	public boolean isHit(int mx, int my) {
		if(p.dist(mx, my, pos.x, pos.y)<radius){
			isBeingHit = true;
			return true;
		}
		isBeingHit = false;
		return false;
	}
	
	public void reset() {
		pos.mult(.99f);
//		PVector delta = new PVector();
//		delta.set(pos);
//		delta.sub(initPos);
//		while(delta.mag() > 0){
//			pos.mult(.95f);
//		}
		
	}
	
	public void setIsResettable(boolean isResettable){
		this.isResettable = isResettable;
	}
		

}
