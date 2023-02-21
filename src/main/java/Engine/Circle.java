package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class Circle extends Object2d{
    float x, y, r, cpx = 0, cpy = 0;
    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float r)
    {
        super(shaderModuleDataList, vertices, color);
        this.r = r;
        createCircle();
        setupVAOVBO();
    }

    public void createCircle()
    {
        System.out.println("mulai fungsi");
        //clear vertices
        vertices.clear();

        for (float i = 0; i < 360; i+=0.1)
        {
            x = cpx + r * (float)Math.cos(Math.toRadians(i));
            y = cpy + r * (float)Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f(x, y, 0.0f));
        }
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
