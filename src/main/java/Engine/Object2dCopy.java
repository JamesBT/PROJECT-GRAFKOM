package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;

public class Object2dCopy extends ShaderProgram
{
    List<Vector3f> vertices;

    int vao, vbo;
    Vector4f color;
    List<Vector3f> verticesColor;
    UniformsMap uniformsMap;
    int vboColor;

    public Object2dCopy(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color)
    {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();

        this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");     //bikin uniform buat ditangkap shader
    }

    public Object2dCopy(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor)
    {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();
    }

    public void setupVAOVBO()
    {
        //setup vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //setup vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }

    public void setupVAOVBOWithVerticesColor()
    {
        //setup vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //setup vbocolor
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

        //setup vbocolor
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }

    public void drawSetup()
    {
        bind();
        uniformsMap.setUniform("uni_color", color);
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void drawSetupWithVerticesColor()
    {
        bind();
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0);
    }

    public void addVertices(Vector3f newVector)
    {
        vertices.add(newVector);
        setupVAOVBO();
    }

    public void addVertices(double firstX, double firstY, double secondX, double secondY, double thirdX, double thirdY)
    {
        vertices.clear();
        vertices.add(new Vector3f((float)firstX, (float)firstY, 0));
        double newX, newY;
        for(double i = 0; i <=1; i+= 0.01)
        {
            //p(t) = ((1-t) * v1) + (t * v2)
            //p(t) = ((1-t)^2 * v1) + (2(1-t) * t * v2) + (t^2 * v3)
//            newX = ((1-i) * prevX) + (i * nextX);
//            newY = ((1-i) * prevY) + (i * nextY);
            newX = (Math.pow((1-i), 2) * firstX) + (2 * (1-i) * i * secondX) + (Math.pow(i, 2) * thirdX);
            newY = (Math.pow((1-i), 2) * firstY) + (2 * (1-i) * i * secondY) + (Math.pow(i, 2) * thirdY);
//            System.out.println(newX + "                " + newY);
            vertices.add(new Vector3f((float)newX, (float)newY, 0));
        }
        vertices.add(new Vector3f((float)thirdX, (float)thirdY, 0));
        setupVAOVBO();
    }

    public void updateVertice(int index, Vector3f value)
    {
        vertices.set(index, value);
        setupVAOVBO();
    }

    public void clearVertices()
    {
        vertices.clear();
    }

    public void draw()
    {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_TRIANGLES, 0, vertices.size());
    }

    public void drawWithVerticesColor()
    {
        drawSetupWithVerticesColor();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_TRIANGLES, 0, vertices.size());
    }

    public void drawLine()
    {
        drawSetup();
        glLineWidth(4);
        glPointSize(0);
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }
}