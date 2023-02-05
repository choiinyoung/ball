import javax.swing.*;
import java.awt.*;

// ImageIcon�� ��ǥ�� ��ġ�� �ο��ϰ��� ImageIcon Ŭ������ �����
public class PosImageIcon extends ImageIcon {
	int pX=0;				// ImageIcon�� X��ǥ
	int pY=0;;				// ImageIcon�� y��ǥ
	int width=0;			// ImageIcon�� ����
	int height=0;			// ImageIcon�� ����
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
