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

    public CircleJohan(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, float height, int option) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.height = height;
//        createCircle();
        if (option == 1){
            createCylinder();
        } else if (option == 2) {
            createHalfCylinder();
        } else if (option ==3) {
            createTriangleCylinder();
        } else if (option == 4) {
            createBucket();
        }
        setupVAOVBO();
    }
    public double degToRad(float degree){
        return (degree * Math.PI / (float) 180);
    }

    public void createCylinder() {
        float count = 100;

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

    public void createBucket() {
        float count = 300;
        float diameterIncrease = 0.001f; // increase in diameter for each level
        float tempX = radiusX;
        float tempY = radiusY;
        vertices.clear();
        for (float j = 0; j <= height; j += height/count) {
            float radiusIncreaseX = (radiusX * diameterIncrease); // increase in radius for each level
            float radiusIncreaseY = (radiusY * diameterIncrease); // increase in radius for each level
            radiusX += radiusIncreaseX;
            radiusY += radiusIncreaseY;
            for (float i = 0; i < 360; i += 360/count) {
                double rad = degToRad(i);
                float x = (float) (centerPoint.get(0) + Math.cos(rad) * radiusX);
                float y = (float) (centerPoint.get(1) + Math.sin(rad) * radiusY);
                vertices.add(new Vector3f(x, y, j));
            }
        }
        radiusX = tempX;
        radiusY = tempY;
    }

    public void createTriangleCylinder() {
        float count = 300;

        vertices.clear();
        for (float j = 0; j <= height; j += height/count) {
            for (float i = 0; i < 360; i += 120) {
                double rad1 = degToRad(i);
                double rad2 = degToRad(i + 120);
                float x1 = (float) (centerPoint.get(0) + Math.cos(rad1) * radiusX);
                float y1 = (float) (centerPoint.get(1) + Math.sin(rad1) * radiusY);
                float x2 = (float) (centerPoint.get(0) + Math.cos(rad2) * radiusX);
                float y2 = (float) (centerPoint.get(1) + Math.sin(rad2) * radiusY);
                float x3 = centerPoint.get(0);
                float y3 = centerPoint.get(1);
                vertices.add(new Vector3f(x1, y1, j));
                vertices.add(new Vector3f(x2, y2, j));
                vertices.add(new Vector3f(x3, y3, j));
            }
        }
    }


    public void createHalfCylinder() {
        float count = 300;

        vertices.clear();
        for (float j = 0; j <= height; j += height/count) {
            for (float i = 0; i < 360; i += 360/count) {
                double rad = degToRad(i);
                float x = (float) (centerPoint.get(0) + Math.cos(rad) * radiusX);
                float y = (float) (centerPoint.get(1) + Math.sin(rad) * radiusY);
                //                Kasi batas separuh aja yg di add
                if (y >= centerPoint.get(1)) {
                    vertices.add(new Vector3f(x, y, j));
                }

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

    public Float getRadiusX() {
        return radiusX;
    }

    public Float getRadiusY() {
        return radiusY;
    }

    //    public void draw(){
//        drawSetup();
//        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
//    }
}
