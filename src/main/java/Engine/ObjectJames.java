package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;

public class ObjectJames extends ShaderProgram{
    List<Vector3f> vertices;
    int vao;
    int vbo;

    Vector4f color;
    UniformsMap uniformsMap;
    List<Vector3f> verticesColor;
    int vboColor;
    Matrix4f model;



    List<ObjectJames> childObjectJames;

    public Vector3f updateCenterPoint(){
        Vector3f centerTemp = new Vector3f();
        model.transformPosition(0.0f,0.0f,0.0f,centerTemp);
        return centerTemp;
    }
    public ObjectJames(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        uniformsMap.createUniform("view");
        uniformsMap.createUniform("projection");
        model = new Matrix4f();
        childObjectJames = new ArrayList<>();
    }

    public ObjectJames(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOwithVerticesColor();
    }

    public ObjectJames(List<ShaderModuleData> shaderModuleDataList) {
        super(shaderModuleDataList);
    }

    public void setupVAOVBO(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);
        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        //kirim data ke shader
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(vertices),GL_STATIC_DRAW);
    }

    public void setupVAOVBOwithVerticesColor(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);
        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        //kirim data ke shader
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(vertices),GL_STATIC_DRAW);
        //set vboColor
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        //kirim data ke shader
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(verticesColor),GL_STATIC_DRAW);
    }

//    public void drawSetup(){
//        bind();
//        uniformsMap.setUniform("uni_color",color);
//        uniformsMap.setUniform("model",model);
//        //bind vbo
//        glEnableVertexAttribArray(0);
//        glBindBuffer(GL_ARRAY_BUFFER,vbo);
//        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
//    }

    public void drawSetup(Camera camera,Projection projection){
        bind();
        uniformsMap.setUniform("uni_color",color);
        uniformsMap.setUniform("model",model);
        uniformsMap.setUniform("view",camera.getViewMatrix());
        uniformsMap.setUniform("projection",projection.getProjMatrix());

        //bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
    }

    public void drawSetupwithVerticesColor(){
        bind();
        //bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
        //bind VBOColor
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER,vboColor);
        glVertexAttribPointer(1,3,GL_FLOAT,false,0,0);
    }

    public void draw(){
//        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        //GL_TRIANGLES
        //GL_LINE_LOOP
        //GL_LINE_STRIP
        //GL_LINES
        //GL_POINTS
        //GL_TRIANGLE_FAN
        glDrawArrays(GL_POLYGON,0,vertices.size());
        for(ObjectJames child: childObjectJames){
            child.draw();
        }
    }

    public void draw(Camera camera,Projection projection){
        drawSetup(camera,projection);
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_POLYGON,0,vertices.size());
        for(ObjectJames child: childObjectJames){
            child.draw(camera,projection);
        }
    }

    public void drawIndices(){
//        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_POLYGON,0,vertices.size());
        for(ObjectJames child: childObjectJames){
            child.drawIndices();
        }
    }
    public void drawwithVerticesColor(){
        drawSetupwithVerticesColor();
        glLineWidth(1);
        glPointSize(0);
        //GL_TRIANGLES
        //GL_LINE_LOOP
        //GL_LINE_STRIP
        //GL_LINES
        //GL_POINTS
        //GL_TRIANGLE_FAN
        glDrawArrays(GL_TRIANGLES,0,vertices.size());
    }
    public void drawLine(){
//        drawSetup();
        glLineWidth(10);
        glPointSize(10);
        //GL_TRIANGLES
        //GL_LINE_LOOP
        //GL_LINE_STRIP
        //GL_LINES
        //GL_POINTS
        //GL_TRIANGLE_FAN
        glDrawArrays(GL_LINE_STRIP,0,vertices.size());
    }

    public void drawSphere(){
//        drawSetup();
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        glDrawArrays(GL_POLYGON,
                0,
                vertices.size());
    }

    public void drawSphereIndices(){
//        drawSetup();
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        glDrawArrays(GL_LINE_STRIP,
                0,
                vertices.size());
    }
    public void addVertices(Vector3f newVector){
        vertices.add(newVector);
        setupVAOVBO();
    }

    public void translateObject(Float offsetX, Float offsetY, Float offsetZ){
        model = new Matrix4f().translate(offsetX,offsetY,offsetZ).mul(new Matrix4f(model));
        for(ObjectJames child: childObjectJames){
            child.translateObject(offsetX,offsetY,offsetZ);
        }
    }

    public void rotateObject(Float degree, Float offsetX, Float offsetY, Float offsetZ){
        model = new Matrix4f().rotate(degree,offsetX,offsetY,offsetZ).mul(new Matrix4f(model));
        for(ObjectJames child: childObjectJames){
            child.rotateObject(degree,offsetX,offsetY,offsetZ);
        }
    }

    public void scaleObject(Float x, Float y, Float z){
        model = new Matrix4f().scale(x,y,z).mul(new Matrix4f(model));
        for(ObjectJames child: childObjectJames){
            child.scaleObject(x,y,z);
        }
    }

    public Matrix4f getMatrix(){
        return model;
    }

    public List<ObjectJames> getChildObject() {
        return childObjectJames;
    }

    public void setChildObject(List<ObjectJames> childObjectJames) {
        this.childObjectJames = childObjectJames;
    }

}
