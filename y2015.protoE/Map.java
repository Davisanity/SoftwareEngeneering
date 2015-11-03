package y2015.protoE;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Map extends JPanel{
	private int x,y;
	BasicBlock[][] scene = new BasicBlock[20][50]; //scene is a BasicBlock type array
	public Map()
	{
		setBounds(0,0,500,300);
		x = 2500;
		y = 1000;
		for(int y=0;y<20;y++){
			for(int x=0;x<50;x++){
				scene[y][x] = new BasicBlock();
				scene[y][x].type = BasicBlock.grass;
			}
		}
			/* allocate trees*/
		for(int i=0;i<trees_cor.length;i++){
			Point tempTree = trees_cor[i];
			scene[tempTree.y][tempTree.x].type = BasicBlock.tree;
		}
			/* allocate roads */
		for(int i=0;i<road_rect.length;i++){
			Rectangle tempRect = road_rect[i];
			int h = tempRect.y+tempRect.height,w=tempRect.x+tempRect.width;
			for(int y=tempRect.y;y<h;y++){
				for(int x=tempRect.x;x<w;x++){
					scene[y][x].type = BasicBlock.road;
				}
			}
		}	
			/* allocate rocks */
		for(int i=0;i<rocks_cor.length;i++){
			Point tempRock = rocks_cor[i];
			scene[tempRock.y][tempRock.x].type = BasicBlock.rock;
		}
			/* allocate woods */
		for(int i=0;i<wood_cor.length;i++){
			Point tempWood = wood_cor[i];
			scene[tempWood.y][tempWood.x].type = BasicBlock.wood;
		}

	}
	Point[] trees_cor = {
			new Point(0,0),
			new Point(40,2),
			new Point(35,6),
			new Point(23,12),
			new Point(32,12),
			new Point(3,4),
			new Point(22,7),
			new Point(6,13),
			new Point(32,12),
			new Point(3,6),
	};
	Rectangle[] road_rect = new Rectangle[]{
			new Rectangle(0,9,50,1), //橫的
			new Rectangle(0,15,50,1),
			new Rectangle(0,5,50,1),
			new Rectangle(2,0,1,20), //直的
			new Rectangle(10,0,1,20),
			new Rectangle(17,0,1,20),
	};
	Point[] rocks_cor = new Point[]{
			new Point(0,1),
			new Point(3,2),
			new Point(32,2),
			new Point(18,19),
			new Point(15,13),
			new Point(22,13),
			new Point(22,17),
			new Point(28,3),
			new Point(42,6),
			new Point(2,9),
	};
	Point[] wood_cor = new Point[]{
			new Point(1,0),
			new Point(3,3),
			new Point(32,10),
			new Point(38,9),
			new Point(14,13),
			new Point(23,8),
			new Point(12,12),
			new Point(25,12),
			new Point(37,9),
			new Point(2,10),
	};

	public void paintComponent(Graphics g)
	{
		int Xout=0,Yout=0; //out 就是如果碰到邊界 圖出去的部分
		int offset_x=0,offset_y=0;//移動25單位造成的偏移
		int imore=0,jmore=0;//負責判斷圖片(?)
		super.paintComponent(g);
		switch(x)
		{
			case 0:
				Xout = 250;
				break;
			case 5000:
				Xout = -250;
				offset_x = -200;
				jmore = -7;
				break;
			default:
				Xout = 0;
				if(x < 100)
				{
					switch(x%100)
					{	
						case 0:
							offset_x = 150;
							break;
						case 25:
							offset_x = 225;
							break;
						case 50:
							offset_x = 200;
							break;
						case 75:
							offset_x = 175;
							break;
					}
				}
				else if(x >= 100 && x < 200)
				{
					jmore = -1;
					switch(x%100)
					{	
						case 0:
							offset_x = 150;
							break;
						case 25:
							offset_x = 125;
							break;
						case 50:
							offset_x = 100;
							break;
						case 75:
							offset_x = 75;
							break;
					}
				}
				else if(x >= 200 && x < 300)
				{
					jmore = -2;
					switch(x%100)
					{	
						case 0:
							offset_x = 50;
							break;
						case 25:
							offset_x = 25;
							break;
						case 50:
							offset_x = 0;
							break;
						case 75:
							offset_x = -25;
							break;
					}
				}
				else if(x >= 300 && x < 4700)
				{
					jmore = -3;
					switch(x%100)
					{	
						case 0:
							offset_x = -50;
							break;
						case 25:
							offset_x = -75;
							break;
						case 50:
							offset_x = -100;
							break;
						case 75:
							offset_x = -125;
							break;
					}
				}
				else if(x >= 4700 && x < 4800)
				{
					jmore = -4;
					switch(x%100)
					{	
						case 0:
							offset_x = -150;
							break;
						case 25:
							offset_x = -175;
							break;
						case 50:
							offset_x = -200;
							break;
						case 75:
							offset_x = -225;
							break;
					}
				}
				else if(x >= 4800 && x < 4900)
				{
					jmore = -5;
					switch(x%100)
					{	
						case 0:
							offset_x = -250;
							break;
						case 25:
							offset_x = -275;
							break;
						case 50:
							offset_x = -300;
							break;
						case 75:
							offset_x = -325;
							break;
					}
				}
				else
				{
					jmore = -6;
					switch(x%100)
					{	
						case 0:
							offset_x = -350;
							break;
						case 25:
							offset_x = -375;
							break;
						case 50:
							offset_x = -400;
							break;
						case 75:
							offset_x = -425;
							break;
					}
				}
				break;
		}
		switch(y)
		{
			case 0:
				Yout = 150;
				break;
			case 2000:
				Yout = -150;
				offset_y = -200;
				imore = -5;
				break;
			default:
				Yout = 0;
				if(y <= 100)
				{
					switch(y%100)
					{
						case 0:
							imore = -1;
							offset_y = 50;
							break;
						case 25:
							offset_y = 125;
							break;
						case 50:
							offset_y = 100;
							break;
						case 75:
							offset_y = 75;
							break;
					}
				}
				else if(y > 100 && y <200)
				{
					imore = -1;
					switch(y%100)
					{
						case 0:
							offset_y = 50;
							break;
						case 25:
							offset_y = 25;
							break;
						case 50:
							offset_y = 0;
							break;
						case 75:
							offset_y = -25;
							break;
					}
				}
				else if(y >= 200 && y < 1800)
				{
					imore = -2;
					switch(y%100)
					{
						case 0:
							offset_y = -50;
							break;
						case 25:
							offset_y = -75;
							break;
						case 50:
							offset_y = -100;
							break;
						case 75:
							offset_y = -125;
							break;
					}
				}
				else if(y >= 1800 && y < 1900)
				{
					imore = -3;
					switch(y%100)
					{
						case 0:
							offset_y = -150;
							break;
						case 25:
							offset_y = -175;
							break;
						case 50:
							offset_y = -200;
							break;
						case 75:
							offset_y = -225;
							break;
					}
				}
				else
				{
					imore = -4;
					switch(y%100)
					{
						case 0:
							offset_y = -250;
							break;
						case 25:
							offset_y = -275;
							break;
						case 50:
							offset_y = -300;
							break;
						case 75:
							offset_y = -325;
							break;
					}
				}
				break;
		}
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<7;j++)
			{
				g.drawImage(BasicBlock.tileImages[scene[(y/100+i+imore)][(x/100+j+jmore)].type],j*100 + offset_x + Xout,i*100 + offset_y + Yout,100,100,null);
				g.fillOval(247,147,6,6);
				System.out.println("x:"+x+" y: "+y+"  ori_x: "+(x/100+j+jmore)+" ori_y: "+(y/100+i+imore));
			}
		}
		System.out.println("*******************");
	}
	
	public void setX(int moveX)
	{
		if(moveX > 0)
		{
			if(x < 5000)
				x = x + moveX;
		}
		else
		{
			if(x > 0)
				x = x + moveX;
		}
	}
	
	public void setY(int moveY)
	{
		if(moveY > 0)
		{
			if(y < 2000)
				y = y + moveY;
		}
		else
		{
			if(y > 0)
				y = y + moveY;
		}
	}
	
	public void update()
	{
		repaint();
	}
}
