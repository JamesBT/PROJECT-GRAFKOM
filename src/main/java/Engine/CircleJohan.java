package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class CircleJohan extends ObjectJohan {

    Float radiusX;
    Float radiusY;

    float height;

    public CircleJohan(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
//        createCircle();
        setupVAOVBO();

    }

    public CircleJohan(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, float height) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.height = height;
//        createCircle();
        createCylinder();
        setupVAOVBO();

    }
    public double degToRad(float degree){
        return (degree * Math.PI / (float) 180);
    }

    public void createCylinder() {
        float count = 300;

        vertices.clear();
        for (float j = 0; j <= height; j += height/count) {
            for (float i = 0; i < 360; i += 360/count) {
                double rad = degToRad(i);
                float x = (float) (centerPoint.get(0) + Math.cos(rad) * radiusX);
                float y = (float) (centerPoint.get(1) + Math.sin(rad) * radiusY);
                vertices.add(new Vector3f(x, y, j));
            }
        }
    }


    public void createCircle(){
        vertices.clear();
        for(float i = 0;i<360;i+=0.1){
            double rad = degToRad(i);
            Float x = (float) (centerPoint.get(0)+Math.cos(rad)*radiusX);
            Float y = (float) (centerPoint.get(1)+Math.sin(rad)*radiusY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x,y,z));
        }
    }
    public void createRectangle(){
        vertices.clear();
        int degree = 45;
        for(float i = 0;i<4;i++){
            double rad = degToRad(degree);
            Float x = (float) (centerPoint.get(0)+Math.cos(rad)*radiusX);
            Float y = (float) (centerPoint.get(1)+Math.sin(rad)*radiusY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x,y,z));
            degree+=90;
        }
    }
    public void createTriangle(){
        vertices.clear();
        int degree = 90;
        for(float i = 0;i<3;i++){
            double rad = degToRad(degree);
            Float x = (float) (centerPoint.get(0)+Math.cos(rad)*radiusX);
            Float y = (float) (centerPoint.get(1)+Math.sin(rad)*radiusY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x,y,z));
            if(degree == 90){
                degree += 135;
            }
            else{
                degree += 90;
            }
        }
    }
//    public void draw(){
//        drawSetup();
//        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
//    }
}
