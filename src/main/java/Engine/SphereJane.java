package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

public class SphereJane extends CircleJane {
    float radiusZ;
    int stackCount;
    int sectorCount;
    List<Integer> index;
    int ibo;


    public SphereJane(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                      int sectorCount, int stackCount, int bentuk) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        if(bentuk==1){

            createHyperboloid1side();
            //hyperboloid1side_gemuk();
        }
        else if(bentuk==2){
            //bola mata
            createSphere();
        }
        else if(bentuk==3){
            //badan
            createEllipsoid();
        }
        else if(bentuk==4){
            //cangkang
            createHalfSphere();
        }
        else if(bentuk==5){
            createHyperboloid2side();
        }
        else if(bentuk==6){
            createElipticCone();
        }
        else if (bentuk==7){
            createElipticParaboloid();
        }
        else if (bentuk==8){
            createHyperboloidParaboloid();
        }
        else if(bentuk==9){
            createHyperboloid1side_gemuk();
        }
        else if(bentuk==10){
            createTabung();
        }
        setupVAOVBO();
    }
    public void createBox(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //TITIK 1
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 2
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 3
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 4
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 5
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 6
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 7
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 8
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak yg sisi belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //kotak yg sisi kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        //kotak yg sisi atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak yg sisi bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }
    public void draw(){
        //drawSetup();
        glLineWidth(2); //ketebalan garis
        glPointSize(2); //besar kecil vertex
        glDrawArrays(GL_TRIANGLES,
                0,
                vertices.size());
    }

    public void createTabung(){
        float x,y,z;
        for(float v = -radiusY; v<= radiusY; v+=0.1f){
            for(float i = 0;i<360;i+=0.1){
                double rad = degToRad(i);
                x = radiusX * (float)(Math.cos(rad));
                y = radiusY * (float)(Math.sin(rad));
                z = v ;
                vertices.add(new Vector3f(x,z,y));
            }
        }
    }
    public void createSphere(){
        float pi = (float)Math.PI;

        float sectorStep = 2 * (float)Math.PI / sectorCount;
        float stackStep = (float)Math.PI / stackCount;
        float sectorAngle, StackAngle, x, y, z;

        for (int i = 0; i <= stackCount; ++i)
        {
            StackAngle = pi / 2 - i * stackStep;
            x = radiusX * (float)Math.cos(StackAngle);
            y = radiusY * (float)Math.cos(StackAngle);
            z = radiusZ * (float)Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount; ++j)
            {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x * (float)Math.cos(sectorAngle);
                temp_vector.y = centerPoint.get(1) + y * (float)Math.sin(sectorAngle);
                temp_vector.z = centerPoint.get(2) + z;
                vertices.add(temp_vector);
            }
        }


    }

    public void createEllipsoid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createHyperboloid1side(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(1/Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(1/Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.tan(v));
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createHalfSphere(){
        float pi = (float)Math.PI;

        float sectorStep = 2 * (float)Math.PI / sectorCount;
        float stackStep = (float)Math.PI / stackCount;
        float sectorAngle, StackAngle, x, y, z;

        for (int i = 0; i <= stackCount/2; ++i)
        {
            StackAngle = i * stackStep;
            x = radiusX * (float)Math.cos(StackAngle);
            y = radiusY * (float)Math.cos(StackAngle);
            z = radiusZ * (float)Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount; ++j)
            {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x * (float)Math.cos(sectorAngle);
                temp_vector.y = centerPoint.get(1) + y * (float)Math.sin(sectorAngle);
                temp_vector.z = centerPoint.get(2) + z;
                vertices.add(temp_vector);
            }
        }
    }

    public void createHyperboloid1side_gemuk(){
        float x,y,z;
        for(double v = -Math.PI/3; v< Math.PI/3; v+=Math.PI/180){
            for(double u = -Math.PI; u< Math.PI; u+=Math.PI/180){
                x = 0.1f * (float)(1/Math.cos(v) * Math.cos(u));
                y = 0.1f * (float)(1/Math.cos(v) * Math.sin(u));
                z = 0.1f * (float)(Math.tan(v));
                vertices.add(new Vector3f(x,z,y));
            }
        }
    }

    public void createHyperboloid2side(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
                float x = 0.1f * (float)(Math.tan(v) * Math.cos(u));
                float y = 0.1f * (float)(Math.tan(v) * Math.sin(u));
                float z = 0.1f * (float)(1/Math.cos(v));
                temp.add(new Vector3f(x,z,y));
            }


        }
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60) {
            for (double u = Math.PI / 2; u <= 3 * Math.PI / 2; u += Math.PI / 60) {
                float x = 0.3f * (float) (Math.tan(v) * Math.cos(u));
                float y = 0.3f * (float) (Math.tan(v) * Math.sin(u));
                float z = -0.3f * (float) (1 / Math.cos(v));
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createElipticCone(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 2*Math.PI; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(v * Math.cos(u));
                float y = 0.5f * (float)(v * Math.sin(u));
                float z = 0.5f * (float)(v);
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;
    }

    public void createElipticParaboloid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 1; v+=0.05){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(v * Math.cos(u));
                float y = 0.5f * (float)(v * Math.sin(u));
                float z = (float) Math.pow(v,2);
                temp.add(new Vector3f(z,y,x));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createHyperboloidParaboloid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 1; v+=0.05){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(v * Math.tan(u));
                float y = 0.5f * (float)(v * 1/Math.sin(u));
                float z = (float) Math.pow(v,2);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void drawIndicies(){
        //drawSetup();
        // Draw the vertices
        //optional
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);

        glDrawElements(GL_TRIANGLES,
                index.size(),GL_UNSIGNED_INT,0);
    }


    public void rotateObjectOnPoint(float degree, float offsetX, float offsetY, float offsetZ, float rotateX, float rotateY,float rotateZ)
    {
        translateObject(-rotateX, -rotateY, -rotateZ);

        model = new Matrix4f().rotate(degree, offsetX, offsetY, offsetZ).mul(new Matrix4f(model));

        float newcpx =(float) (centerPoint.get(0) * Math.cos((double) degree) - centerPoint.get(1) * Math.sin((double) degree));
        float newcpy =(float) (centerPoint.get(0) * Math.sin((double) degree) + centerPoint.get(1) * Math.cos((double) degree));

        centerPoint.set(0,newcpx);
        centerPoint.set(1,newcpy);

        translateObject(rotateX, rotateY, rotateZ);
        for (ObjectJane i: childObjectJane)
        {
            if(i instanceof SphereJane) {
                ((SphereJane) i).rotateObjectOnPoint(degree, offsetX, offsetY, offsetZ, rotateX, rotateY, rotateZ);
            }
        }

    }



}