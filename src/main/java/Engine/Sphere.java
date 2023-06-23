package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

public class Sphere extends Circle{
    float radiusZ;
    int stackCount;
    int sectorCount;
    List<Vector3f> normal;

    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                  int sectorCount,int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        createBoxVertices();
//        createSphere();
        setupVAOVBO();
    }
    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                  int sectorCount,int stackCount,String filePath) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        File f = new File(filePath);
        Model m = new Model();
        try
        {
            m = ObjLoader.loadModel(f);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        this.vertices = m.sortedVertices;
        this.texture = m.texture;
        this.index = m.vertexIndices;
        this.normal = m.sortedNormals;

//        createSphere();
        setupVAOVBO();
    }
    public void createBoxVertices()
    {
        System.out.println("code");
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //Titik 1 kiri atas belakang
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 2 kiri bawah belakang
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 3 kanan bawah belakang
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 4 kanan atas belakang
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 5 kiri atas depan
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 6 kiri bawah depan
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 7 kanan bawah depan
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 8 kanan atas depan
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));
        //kotak depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));
        //kotak samping kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(4));

        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak samping kanan
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));
        //kotak bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(1));
        //kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(3));

        normal = new ArrayList<>(Arrays.asList(
                new Vector3f(0.0f,  0.0f, -1.0f),
                new Vector3f(0.0f,  0.0f, -1.0f),
                new Vector3f(0.0f,  0.0f, -1.0f),
                new Vector3f(0.0f,  0.0f, -1.0f),
                new Vector3f(0.0f,  0.0f, -1.0f),
                new Vector3f(0.0f,  0.0f, -1.0f),

                new Vector3f(0.0f,  0.0f,  1.0f),
                new Vector3f(0.0f,  0.0f,  1.0f),
                new Vector3f(0.0f,  0.0f,  1.0f),
                new Vector3f(0.0f,  0.0f,  1.0f),
                new Vector3f(0.0f,  0.0f,  1.0f),
                new Vector3f(0.0f,  0.0f,  1.0f),

                new Vector3f(-1.0f,  0.0f,  0.0f),
                new Vector3f(-1.0f,  0.0f,  0.0f),
                new Vector3f(-1.0f,  0.0f,  0.0f),
                new Vector3f(-1.0f,  0.0f,  0.0f),
                new Vector3f(-1.0f,  0.0f,  0.0f),
                new Vector3f(-1.0f,  0.0f,  0.0f),

                new Vector3f(1.0f,  0.0f,  0.0f),
                new Vector3f(1.0f,  0.0f,  0.0f),
                new Vector3f(1.0f,  0.0f,  0.0f),
                new Vector3f(1.0f,  0.0f,  0.0f),
                new Vector3f(1.0f,  0.0f,  0.0f),
                new Vector3f(1.0f,  0.0f,  0.0f),

                new Vector3f(0.0f, -1.0f,  0.0f),
                new Vector3f(0.0f, -1.0f,  0.0f),
                new Vector3f( 0.0f, -1.0f,  0.0f),
                new Vector3f(0.0f, -1.0f,  0.0f),
                new Vector3f(0.0f, -1.0f,  0.0f),
                new Vector3f(0.0f, -1.0f,  0.0f),

                new Vector3f(0.0f,  1.0f,  0.0f),
                new Vector3f(0.0f,  1.0f,  0.0f),
                new Vector3f(0.0f,  1.0f,  0.0f),
                new Vector3f(0.0f,  1.0f,  0.0f),
                new Vector3f(0.0f,  1.0f,  0.0f),
                new Vector3f(0.0f,  1.0f,  0.0f)
        ));
    }

    public void drawSetup(Camera camera, Projection projection){
        super.drawSetup(camera,projection);

        // Bind VBO
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, nbo);
        glVertexAttribPointer(1, 3,
                GL_FLOAT,
                false,
                0, 0);

    }
    //    public void draw(){
//        drawSetup();
//        glLineWidth(2); //ketebalan garis
//        glPointSize(2); //besar kecil vertex
//        glDrawArrays(GL_LINE_STRIP,
//                0,
//                vertices.size());
//    }
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
}