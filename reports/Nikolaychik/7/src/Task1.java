import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

class Ugolnik extends JFrame {
    private int[] __x =new int[4];
    private int[] __y =new int[4];
    double angle=0;
    private final int CENTER_X;
    private final int CENTER_Y;
    private final int __windowX;
    private final int __windowY;
    
    public Ugolnik(int windowX, int windowY, int[] __x, int[] __y) {
        super("rect");
        setSize(windowX, windowY);
        setVisible(true);
        setResizable(false);
        this.__x=__x;
        this.__y=__y;
        __windowX = windowX;
        __windowY = windowY;
        int xA=__x[0];
        int yA=__y[0];
        int xB=__x[1];int yB=__y[1];
        int xC=__x[2];int yC=__y[2];
        int xD=__x[3];int yD=__y[3];
        int S1=(int)(0.5*Math.abs((xB-xA)*(yC-yA)-(xC-yA)*(yB-yA)));
        int S2=(int)(0.5*Math.abs((xC-xA)*(yD-yA)-(xD-yA)*(yC-yA)));
        int xm1=(xA+xB+xC)/3; int ym1=(yA+yB+yC)/3;
        int xm2=(xA+xC+xD)/3;int ym2=(yA+yC+yD)/3;
        int x1=(S1*xm1+S2*xm2)/(S1+S2);int y1=(S1*ym1+S2*ym2)/(S1+S2);
        CENTER_X=x1;
        CENTER_Y=y1;

    }
    
    public void paint(Graphics g) {
        g.fillRect(0, 0, __windowX, __windowY);
        g.setColor(Color.BLUE);
        int temp_x1,temp_y1,temp_x2,temp_y2;
        for (int i = 0; i < 3; i++) {

            temp_x1 = (int) (CENTER_X+(__x[i]-CENTER_X)*Math.cos(angle) -
                    (__y[i]-CENTER_Y)*Math.sin(angle));

            temp_x2 = (int) (CENTER_X+(__x[i+1]-CENTER_X)*Math.cos(angle) -
                    (__y[i+1]-CENTER_Y)*Math.sin(angle));

            temp_y1 = (int) (CENTER_Y+(__x[i]-CENTER_X)*Math.sin(angle) +
                    (__y[i]-CENTER_Y)*Math.cos(angle));

            temp_y2 = (int) (CENTER_Y+(__x[i+1]-CENTER_X)*Math.sin(angle) +
                    (__y[i+1]-CENTER_Y)*Math.cos(angle));

            g.drawLine(temp_x1, temp_y1, temp_x2, temp_y2);
        }
        temp_x1 = (int) (CENTER_X+(__x[3]-CENTER_X)*Math.cos(angle) -
                (__y[3]-CENTER_Y)*Math.sin(angle));

        temp_x2 = (int) (CENTER_X+(__x[0]-CENTER_X)*Math.cos(angle) -
                (__y[0]-CENTER_Y)*Math.sin(angle));

        temp_y1 = (int) (CENTER_Y+(__x[3]-CENTER_X)*Math.sin(angle) +
                (__y[3]-CENTER_Y)*Math.cos(angle));

        temp_y2 = (int) (CENTER_Y+(__x[0]-CENTER_X)*Math.sin(angle) +
                (__y[0]-CENTER_Y)*Math.cos(angle));
        g.drawLine(temp_x1, temp_y1, temp_x2, temp_y2);
        this.angle = this.angle + 0.01;
    }

    public void run(){        
        while(true){
            
            repaint();
            
            try{
                Thread.sleep(5);
            }
            catch(InterruptedException ignored){
            }
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter width : ");
        int windowX = sc.nextInt();
        System.out.print("Enter height : ");
        int windowY = sc.nextInt();
        int[] __x =new int[4];
        int[] __y =new int[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter point(x y) : ");
            __x[i] = sc.nextInt();
            __y[i] = sc.nextInt();
        }

        sc.close();

        Ugolnik app = new Ugolnik(windowX, windowY,__x,__y);
        app.run();
    }
}
