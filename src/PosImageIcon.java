import javax.swing.*;
import java.awt.*;

// ImageIcon에 좌표의 위치를 부여하고자 ImageIcon 클래스를 상속함public class PosImageIcon extends ImageIcon {
	int pX=0;					// ImageIcon의 X좌표
	int pY=0;;				// ImageIcon의 y좌표
	int width=0;			// ImageIcon의 넓이
	int height=0;			// ImageIcon의 높이
	boolean answer=true;
	public PosImageIcon( int x, int y, int width, int height) {
		pX=x;
		pY=y;
		this.width = width;
		this.height = height;
	}
	
	public void move(int x, int y) {
		pX += x;
		pY += y;
	}
	
	public void draw(Graphics g) {
		if(answer) {
			g.setColor(Color.green);
			g.fillOval(pX,pY,width,height);
		}
		else{
			g.setColor(Color.red);
			g.fillOval(pX,pY,width,height);
		}
	}
	public void blueDraw(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(pX,pY,width,height);
	}
	public void Count() {
		answer=false;
	}
}
