package com.iragreenberg;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;

public class ocIcon {

	/**
	 *
	 */
	public PApplet p;
	public float iconRadius;
	public ocIconDetail shape;
	public ArrayList<PVector> vecs;
	public int circleDetail = 36;

	public ocIcon() {
	}

	public ocIcon(PApplet p, float iconRadius, ocIconDetail shape) {
		this.p = p;
		this.iconRadius = iconRadius;
		this.shape = shape;
		vecs = new ArrayList<PVector>();
		float theta = 0.0f;
		switch (shape) {
		case CIRCLE:
			for (int i = 0; i < circleDetail; i++) {
				vecs.add(new PVector(p.cos(theta) * iconRadius, p.sin(theta) * iconRadius));
				theta += p.TWO_PI / circleDetail;
			}
			break;
		case TRIANGLE:
			break;
		case SQUARE:
			break;
		case RECTANGLE:
			break;
		default:
			break;
		}
	}

	public void draw() {
		p.beginShape();
		for(PVector v: vecs){
			p.vertex(v.x, v.y);
		}
		p.endShape(p.CLOSE);
	}
		

}
