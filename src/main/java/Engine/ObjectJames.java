package Engine;

import org.joml.*;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;

public class ObjectJames extends ShaderProgram{
    List<Vector3f> vertices;
    int vao;
    int vbo;
    int thickness = 10;
    Vector4f color;
    UniformsMap uniformsMap;
    List<Vector3f> verticesColor;
    int vboColor;
    Matrix4f model;

    List<Vector3f> curveVertices = new ArrayList<>();

    List<ObjectJames> childObjectJames;

    Quaternionf quat;
    Vector3f derajat;
    boolean isExclude = false;


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
        if (curveVertices.size() > 0){
            drawCurve(camera, projection);
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

    public void addVertices(Vector3f newVector){
        vertices.add(newVector);
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
        float x = 0, y = 0, z = 0;

        for (int i = 0; i <= n; i++) {
            double coefficient = calculateCoefficient(n, i, t);
            x += coefficient * points.get(i).x;
            y += coefficient * points.get(i).y;
            z += coefficient * points.get(i).z;
        }

        return new Vector3f(x, y, z);
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
    public void setThickness(int thickness) {
        this.thickness = thickness;
    }
    public List<Vector3f> getVertices() {
        return vertices;
    }

    public void getDerajat(){

        quat = model.getNormalizedRotation(new Quaternionf());
        derajat = quat.getEulerAnglesXYZ(new Vector3f());
        float rotationX = (float) Math.toDegrees(derajat.x);
        float rotationY = (float) Math.toDegrees(derajat.y);
        float rotationZ = (float) Math.toDegrees(derajat.z);

//        System.out.println("Rotation angles: (" + rotationX + ", " + rotationY + ", " + rotationZ + ")");
    }

    public float getDerajatX(){

        quat = model.getNormalizedRotation(new Quaternionf());
        derajat = quat.getEulerAnglesXYZ(new Vector3f());
        float rotationX = (float) Math.toDegrees(derajat.x);
        return rotationX;
    }
    public float getDerajatY(){

        quat = model.getNormalizedRotation(new Quaternionf());
        derajat = quat.getEulerAnglesXYZ(new Vector3f());
        float rotationY = (float) Math.toDegrees(derajat.y);
        return rotationY;
    }
    public float getDerajatZ(){

        quat = model.getNormalizedRotation(new Quaternionf());
        derajat = quat.getEulerAnglesXYZ(new Vector3f());
        float rotationZ = (float) Math.toDegrees(derajat.z);
        return rotationZ;
    }

    public Vector3f getUpdateCenterPoint(){
        Vector3f destTemp = new Vector3f();
        model.transformPosition(0.0f,0.0f,0.0f,destTemp);
        return destTemp;
//        System.out.println(centerPoint.get(0) + " " + centerPoint.get(1));
    }

    public void setExclude(boolean exclude) {
        isExclude = exclude;
    }
}
