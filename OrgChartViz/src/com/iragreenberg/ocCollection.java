package com.iragreenberg;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class ocCollection {
	
	public int entities = 12;
	public ArrayList<ocIcon> icons;
	private PApplet p;
	public float margin = 100.0f;
	
	public ocCollection(){
	}
	
	//PApplet p, PVector pos, float radius, ocIconDetail shape
	public ocCollection(PApplet p, int entities){
		this.p = p;
		float iconW = p.width/(entities*3.0f);
		float gap = (p.width - margin*2 - iconW*entities)/(entities-1);
		icons = new ArrayList<ocIcon>();
		
		icons.add(new ocIcon(p, new PVector(margin+iconW/2, p.height/2), iconW, ocIconDetail.CIRCLE));
		for(int i=1; i<entities-1; i++){
			icons.add(new ocIcon(p, new PVector(margin+iconW/2 + (iconW+gap)*(i), p.height/2), iconW, ocIconDetail.CIRCLE));
			
		}
		icons.add(new ocIcon(p, new PVector(p.width-margin, p.height/2), iconW, ocIconDetail.CIRCLE));
	}
	
	public void display(){
		for(int i=0; i<entities; i++){
			icons.get(i).display();
		}
	}

}
