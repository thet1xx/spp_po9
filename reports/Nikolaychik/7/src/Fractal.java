import javax.swing.*;
import java.awt.*;
import java.util.Random;

class Triangles extends JPanel {
    private int __n;
    private int __depth;

    Triangles(int n, int depth) {
        __n = n;
        __depth = depth;
    }
    
    public void setColor(Graphics g){
        Random rand = new Random();
        int randNum = rand.nextInt(5);
        if(randNum == 0){
            g.setColor(Color.RED);
        }
        else if(randNum == 1){
            g.setColor(Color.MAGENTA);
        }
        else if(randNum == 2){
            g.setColor(Color.GREEN);
        }
        else if(randNum == 3){
            g.setColor(Color.BLUE);
        }
        else if(randNum == 4){
            g.setColor(Color.YELLOW);
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        drawTri(600, 350, __n, g,0);
    }

    private void drawTri(int x, int y, int length, Graphics g,int cur_depth) {
        setColor(g);
        int xA = (int) Math.round(x- 0.5*length);
        int xB= x;
        int xC= (int) Math.round(x+ 0.5*length);
        int yA =(int)Math.round(y - Math.sqrt(0.75*length*length/3));
        int yB= (int)Math.round(y + Math.sqrt(0.75*length*length/3));
        int yC= (int)Math.round(y - Math.sqrt(0.75*length*length/3));

        g.drawLine(xA, yA, xB, yB);
        g.drawLine(xB, yB, xC, yC);
        g.drawLine(xC, yC, xA, yA);

        if(cur_depth < __depth) {
            drawTri((int) Math.round((x+xA)/2), (int)Math.round((y+yA)/2),length/2, g,cur_depth+1);
            drawTri((int) Math.round((x+xB)/2), (int)Math.round((y+yB)/2),length/2, g,cur_depth+1);
            drawTri((int) Math.round((x+xC)/2), (int)Math.round((y+yC)/2),length/2, g,cur_depth+1);
        }
    }

}