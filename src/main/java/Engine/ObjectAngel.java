package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15C.glBindBuffer;
import static org.lwjgl.opengl.GL15C.glBufferData;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class ObjectAngel extends ShaderProgram{

    List<Vector3f> vertices;

    List<Vector3f> curveVertices;
    int thickness=5;
    int vao;
    int vbo;
    UniformsMap uniformsMap;
    Vector4f color;

    public Matrix4f model;

    int vboColor;
    List<Vector3f> verticesColor;
    List<ObjectAngel> childObject=new ArrayList<>();
    public Vector3f updateCenterPoint(){
        Vector3f centerTemp=new Vector3f();
        model.transformPosition(0.0f,0.0f,0.0f,centerTemp);
        return centerTemp;
    }
    public List<ObjectAngel> getChildObject() {
        return childObject;
    }
    public void setChildObject(List<ObjectAngel> childObject) {
        this.childObject = childObject;
    }

    public ObjectAngel(List<ShaderModuleData> shaderModuleDataList
            , List<Vector3f> vertices
            , Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        uniformsMap.createUniform("view");
        uniformsMap.createUniform("projection");
        this.color = color;
        model = new Matrix4f().identity();
        this.curveVertices = new ArrayList<>();
    }
    public ObjectAngel(List<ShaderModuleData> shaderModuleDataList,
                       List<Vector3f> vertices,
                       List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();
    }
    public List<Vector3f> getVertices() {
        return vertices;
    }
    public void setupVAOVBO(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);
    }
    public void setupVAOVBOWithVerticesColor(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);

        //set vboColor
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(verticesColor),
                GL_STATIC_DRAW);
    }

    public void setupVAOVBOCurve(){
        // set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);
        // set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        // mengirim vertices
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(curveVertices), GL_STATIC_DRAW);
    }
    public void drawCurve(Camera camera, Projection projection){
        if(vertices.size()<3) {
            if(vertices.size()==2){
                curveVertices.addAll(vertices);
            }
            return;
        }
        setupVAOVBOCurve();
        drawSetup(camera, projection);
        glLineWidth(thickness);
        glPointSize(thickness);
        glDrawArrays(GL_LINE_STRIP, 0, curveVertices.size());
    }
    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void drawSetup(Camera camera,Projection projection){
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);
        uniformsMap.setUniform("view",camera.getViewMatrix());
        uniformsMap.setUniform("projection",projection.getProjMatrix());
        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);

    }
    public void drawSetupWithVerticesColor(){
        bind();
        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);

        // Bind VBOColor
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3,
                GL_FLOAT,
                false,
                0, 0);
    }
    public void draw(Camera camera,Projection projection){
        drawSetup(camera,projection);
        // Draw the vertices
        //optional
        glLineWidth(5); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_LINE_STRIP,0,vertices.size());
        for(ObjectAngel child:childObject){
            child.draw(camera,projection);
        }

        if (curveVertices.size() > 0){
            drawCurve(camera,projection);
        }
    }
    public void drawWithVerticesColor(){
        drawSetupWithVerticesColor();
        // Draw the vertices
        //optional
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_TRIANGLES,
                0,
                vertices.size());
    }
    //    public void drawLine(){
//        drawSetup();
//        // Draw the vertices
//        //optional
//        glLineWidth(1); //ketebalan garis
//        glPointSize(1); //besar kecil vertex
//        glDrawArrays(GL_LINE_STRIP,
//                0,
//                vertices.size());
//    }
    public void addVertices(Vector3f newVertices){
        vertices.add(newVertices);
        setupVAOVBO();
    }
    public void updateCurve(List<Vector3f> points){
        if(vertices.size() < 2) return;
        curveVertices.clear();
        curveVertices.add(vertices.get(0));
        double interval = 0.02;
        for (double i = 0; i <= 1; i += interval) {
            curveVertices.add(new Vector3f(calculateBezierPoint((float) i, points)));
        }
        curveVertices.add(vertices.get(vertices.size()-1));
    }
    public static Vector3f calculateBezierPoint(float t, List<Vector3f> points) {
        int n = points.size() - 1;
        float x = 0, y = 0;

        for (int i = 0; i <= n; i++) {
            double coefficient = calculateCoefficient(n, i, t);
            x += coefficient * points.get(i).x;
            y += coefficient * points.get(i).y;
        }

        return new Vector3f(x, y, 0.0f);
    }
    private static double calculateCoefficient(int n, int i, double t) {
        return binomialCoefficient(n, i) * Math.pow(t, i) * Math.pow(1 - t, n - i);
    }
    private static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
        }
    }

    public void translateObject(Float offsetX,Float offsetY,Float offsetZ){
        model = new Matrix4f().translate(offsetX,offsetY,offsetZ).mul(new Matrix4f(model));
        for(ObjectAngel child:childObject){
            child.translateObject(offsetX,offsetY,offsetZ);
        }
    }
    public void rotateObject(Float degree, Float x,Float y,Float z){
        model = new Matrix4f().rotate(degree,x,y,z).mul(new Matrix4f(model));
        for(ObjectAngel child:childObject){
            child.rotateObject(degree,x,y,z);
        }
    }
    public void scaleObject(Float scaleX,Float scaleY,Float scaleZ){
        model = new Matrix4f().scale(scaleX,scaleY,scaleZ).mul(new Matrix4f(model));
        for(ObjectAngel child:childObject){
            child.scaleObject(scaleX,scaleY,scaleZ);
        }
    }

}