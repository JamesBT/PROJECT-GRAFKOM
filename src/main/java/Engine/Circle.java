package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_LINES;

public class Circle extends Object2d{
    double x, y, r, cx, cy,ratio;
    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double r,double cx,double cy)

    {
        super(shaderModuleDataList, vertices, color);
        this.r = r;
        this.cx = cx;
        this.cy = cy;
        createCircle();
//        createRectangle();
//        createSegitiga();
//        createStar();
//        ->segilima
        setupVAOVBO();
    }

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double r,double ratio, double cx,double cy)
    {
        super(shaderModuleDataList, vertices, color);
        this.r = r;
        this.ratio = ratio;
        this.cx = cx;
        this.cy = cy;
        createEclipse();
        setupVAOVBO();
    }

    public void createCircle()
    {
        //clear vertices
        vertices.clear();

        for (float i = 0; i < 360; i+=0.1)
        {
            x = cx + r * Math.cos(Math.toRadians(i));
            y = cy + r * Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float) x, (float) y, 0.0f));
        }
    }

    public void createEclipse()
    {
        //clear vertices
        vertices.clear();

        for (float i = 0; i < 360; i+=0.1)
        {
            x = cx + r * Math.cos(Math.toRadians(i));
            y = cy + r/ratio * Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float) x, (float) y, 0.0f));
        }
    }

    public void createSegitiga()
    {
        //clear vertices
        vertices.clear();

        for (float i = 90; i < 360; i+=120)
        {
            x = cx + r * Math.cos(Math.toRadians(i));
            y = cy + r * Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float) x, (float) y, 0.0f));
        }
    }

    public void createRectangle()
    {
        //clear vertices
        vertices.clear();

        for (float i = 45; i < 360; i+=90)
        {
            x = cx + r * Math.cos(Math.toRadians(i));
            y = cy + r * Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float) x, (float) y, 0.0f));
        }
    }

    public void createStar()
    {
        //clear vertices
        vertices.clear();

        for (float i = 0; i < 360; i+=72)
        {
            x = cx + r * Math.cos(Math.toRadians(i));
            y = cy + r * Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float) x, (float) y, 0.0f));
        }
    }
    @Override
    public void draw(){
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        //GL_TRIANGLES
        //GL_LINE_LOOP
        //GL_LINE_STRIP
        //GL_LINES
        //GL_POINTS
        //GL_TRIANGLE_FAN
        glDrawArrays(GL_POLYGON,0,vertices.size());
    }










//    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
//        super(shaderModuleDataList, vertices, color);
//    }
//
//    public void createCircle(){
//        //vertices di clear
//        //untuk lingkaran
//        for(double i=0;i<360;i+=0.01f){
////            r*cos(teta)
//            //gak pakai math.round
////            x = centerpoint.x + r*cos(teta);
////            y = centerpoint.y + r*sin(teta);
////            vertices.add(new Vector3f(x,y,0.0f));
//        }
//
//        //untuk persegi
//        int degree = 45;
//        //awalnya 45 terus ditambah 90 dst
//        for(double i=0;i<360;i+=0.01f){
////            r*cos(teta)
//            //gak pakai math.round
////            x = centerpoint.x + r*cos(teta);
////            y = centerpoint.y + r*sin(teta);
////            vertices.add(new Vector3f(x,y,0.0f));
//        }
//        //untuk segitiga
//        //awalnya 90 kemudian ditambah 135 kemudian 90
//
//    }
}
