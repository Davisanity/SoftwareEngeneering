package y2015.protoE;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Frame extends JFrame implements KeyListener{
	private int keycode;
	Map map;
	Frame(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	setSize(500,300);
	setTitle("prototypeE");
	addKeyListener(this);
	map = new Map();
	add(map);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		keycode = e.getKeyCode();
		switch(keycode)
		{
		case KeyEvent.VK_LEFT:
			map.setX(-25);
			map.update();
			break;
		case KeyEvent.VK_UP:
			map.setY(-25);
			map.update();
			break;
		case KeyEvent.VK_RIGHT:
			map.setX(25);
			map.update();
			break;
		case KeyEvent.VK_DOWN:
			map.setY(25);
			map.update();
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {}

}
