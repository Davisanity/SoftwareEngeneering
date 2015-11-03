package y2015.protoE;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;


public class BasicBlock {
	int type = grass;
	JLabel block;
	Boolean touchable;
	static int grass=0,road=1,rock=2,tree=3,wood=4;
	static Image[] tileImages = new Image[5];
	
	void Readimage(){
		try {
			tileImages[grass] = ImageIO.read(new File("grass.png"));
			tileImages[road] = ImageIO.read(new File("road.png"));
			tileImages[rock] = ImageIO.read(new File("rock.png"));
			tileImages[tree] = ImageIO.read(new File("tree.png"));
			tileImages[wood] = ImageIO.read(new File("wood.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	BasicBlock(){Readimage();}
	
	
}