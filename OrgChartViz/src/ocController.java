import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

import com.iragreenberg.*;

public class ocController extends PApplet {

	/**
	 *
	 * 
	 */
	public ocIcon icon;

	public void setup() {
		icon = new ocIcon(this, new PVector(200, 100), 23.0f, ocIconDetail.RECTANGLE);
	}

	public void draw() {
		background(255);
		//translate(width/2, height/2);
		icon.draw();
		
		println(icon.isHit(mouseX, mouseY));
	}

	public void settings() {
		size(620, 500);
	}

	static public void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "ocController" };
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
	}
	
	public void mouseReleased(){
		icon.setIsResettable(true);
	}
}
