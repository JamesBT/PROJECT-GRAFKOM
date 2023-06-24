package Engine;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import static org.lwjgl.opengl.GL15C.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

public class Sphere extends Circle
{
    List<Integer> index = new ArrayList<>();
    ArrayList<Vector2f> texture;
    ArrayList<Vector3f> normal;

    String filename = "";

    int ibo, nbo, stackCount, sectorCount;
    double cpz;
    float radiusX, radiusY, radiusZ;


    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, String filePath)
    {
        super(shaderModuleDataList, vertices, color, 0, 0, 0);

        filename = filePath;
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
        setupVAOVBO();
    }


    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, String filePath, boolean fbx)
    {
        super(shaderModuleDataList, vertices, color, 0, 0, 0);

        ObjLoader m = new ObjLoader(filePath);

        this.vertices = m.vertices;
        this.index = m.indicies;
        this.normal = m.normals;

        System.out.println("PJG" + index.size());
        for (Vector3f i: this.vertices)
        {
            System.out.println(i.x + " " + i.y + " " + i.z);
        }

        setupVAOVBO();
    }

    public void translateObject(float offsetX, float offsetY, float offsetZ)
    {
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        cpx += offsetX;
        cpy += offsetY;
        cpz += offsetZ;

        for (Object i: childObjects) {
            i.translateObject(offsetX, offsetY, offsetZ);
        }
    }

    public void rotateObject(float degree, float offsetX, float offsetY, float offsetZ)
    {
        //offset x, y, sama z itu maksudnya rotasi terhadap sumbunya misal z=1 berarti rotasi thd sb z
        model = new Matrix4f().rotate((float)(Math.toRadians(degree)), offsetX, offsetY, offsetZ).mul(new Matrix4f(model));

        float newcpx =(float) (cpx * Math.cos((double) degree) - cpy * Math.sin((double) degree));
        float newcpy =(float) (cpx * Math.sin((double) degree) + cpy * Math.cos((double) degree));

        cpx = newcpx;
        cpy = newcpy;

        for (Object i: childObjects)
        {
            i.rotateObject(degree, offsetX, offsetY, offsetZ);
//            ((Sphere)i).rotateObjectOnPoint(degree, offsetX, offsetY, offsetZ, (float)((Sphere) i).getCpx(), (float)((Sphere) i).getCpy());

        }
    }


    public void setupVAOVBO()
    {
        super.setupVAOVBO();

        //set nbo
        nbo = glGenBuffers();
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, nbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(normal), GL_STATIC_DRAW);

    }

    public void setupVariabel(int jarak){
        if(jarak!=65){
//            pagi
            this.light1x = 0f;
            this.light1y = -4000f;
            this.light1z = 1.75f;
            this.light2x = -3.6f;
            this.light2y = -4000f;
            this.light2z = 14.5f;
            this.light3x = 16.07f;
            this.light3y = -4000f;
            this.light3z = 7.152f;
            this.light4x = -100f;
            this.light4y = 80f;
            this.light4z = 0f;
            if(jarak == 650){
                this.lightLinear = 0.007f;
                this.lightQuadratic = 0.0002f;
            }
            else if(jarak == 3250){
                this.lightLinear = 0.0014f;
                this.lightQuadratic = 0.000007f;
            }
        }else if(jarak == 65){
//       malam
            this.light1x = -23.85f;
            this.light1y = 17.8f;
            this.light1z = 1.75f;
            this.light2x = -3.6f;
            this.light2y = 18f;
            this.light2z = 14.5f;
            this.light3x = 16.07f;
            this.light3y = 17.23f;
            this.light3z = 7.152f;
            this.light4x = 80f;
            this.light4y = -1000f;
            this.light4z = 0f;

            this.lightLinear = 0.07f;
            this.lightQuadratic = 0.017f;
        }
    }

    public void drawSetup(Camera camera, Projection projection){
        super.drawSetup(camera,projection);
        // Bind VBO
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, nbo);
        glVertexAttribPointer(1, 3, GL_FLOAT,false, 0, 0);
        //directional Light
        uniformsMap.setUniform("dirLight.direction", new Vector3f(2000.0f,-80.0f,-0.0f));
        uniformsMap.setUniform("dirLight.ambient", new Vector3f(0.05f,0.05f,0.05f));
        uniformsMap.setUniform("dirLight.diffuse", new Vector3f(0.4f,0.4f,0.4f));
        uniformsMap.setUniform("dirLight.specular", new Vector3f(0.5f,0.5f,0.5f));
        //posisi pointLight
        Vector3f[] _pointLightPositions =
                {
                        new Vector3f(light1x, light1y, light1z),
                        new Vector3f(light1x, light1y, light1z),
                        new Vector3f(light2x, light2y, light2z),
                        new Vector3f(light2x, light2y, light2z),
                        new Vector3f(light3x, light3y, light3z),
                        new Vector3f(light3x, light3y, light3z),
                        new Vector3f(light4x, light4y, light4z),
                        new Vector3f(light4x, light4y, light4z)
                };
        for(int i = 0;i< _pointLightPositions.length;i++)
        {
            uniformsMap.setUniform("pointLights["+ i +"].position",_pointLightPositions[i]);
            uniformsMap.setUniform("pointLights["+ i +"].ambient", new Vector3f(0.05f,0.05f,0.05f));
            uniformsMap.setUniform("pointLights["+ i +"].diffuse", new Vector3f(0.8f,0.8f,0.8f));
            uniformsMap.setUniform("pointLights["+ i +"].specular", new Vector3f(1.0f,1.0f,1.0f));
            uniformsMap.setUniform("pointLights["+ i +"].constant",lightConstantD );
            uniformsMap.setUniform("pointLights["+ i +"].linear", lightLinear);
            uniformsMap.setUniform("pointLights["+ i +"].quadratic", lightQuadratic);
        }
        uniformsMap.setUniform("spotLight.position",camera.getPosition());
        uniformsMap.setUniform("spotLight.direction",camera.getDirection());
        uniformsMap.setUniform("spotLight.ambient",new Vector3f(0.0f,0.0f,0.0f));
        uniformsMap.setUniform("spotLight.diffuse",new Vector3f(1.0f,1.0f,1.0f));
        uniformsMap.setUniform("spotLight.specular",new Vector3f(1.0f,1.0f,1.0f));
        uniformsMap.setUniform("spotLight.constant",1.0f);
        uniformsMap.setUniform("spotLight.linear",0.09f);
        uniformsMap.setUniform("spotLight.quadratic",0.032f);
        uniformsMap.setUniform("spotLight.cutOff",(float)Math.cos(Math.toRadians(12.5f)));
        uniformsMap.setUniform("spotLight.outerCutOff",(float)Math.cos(Math.toRadians(12.5f)));

        uniformsMap.setUniform("viewPos",camera.getPosition());

        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void draw(Camera camera, Projection projection)
    {
        drawSetup(camera, projection);
        glLineWidth(1);
        glPointSize(0);
        glDrawElements(GL_TRIANGLES, index.size(),GL_UNSIGNED_INT,0);
        for (Object i: childObjects)
        {
            i.draw(camera, projection);
        }
    }

    public float getCpz()
    {
        return (float) cpz;
    }

    public float getRadiusX() {
        return radiusX;
    }

    public float getRadiusY() {
        return radiusY;
    }

    public float getRadiusZ() {
        return radiusZ;
    }

    public String getFilename() {
        return filename;
    }
}