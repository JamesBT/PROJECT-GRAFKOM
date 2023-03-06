import Engine.*;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window =
            new Window
                    (800,800,"Hello World");

    private ArrayList<Object2d> objects
            = new ArrayList<>();

    private ArrayList<Object2d> objectsRectangle= new ArrayList<>();

    private ArrayList<Object2d> objectsCircle= new ArrayList<>();

    private  ArrayList<Object2d> objectpointcontrol = new ArrayList<>();

    private  ArrayList<Object2d> objectCurve = new ArrayList<>();

    boolean objectClicked = false;
    int objectClikedIndex;

    public void init(){
        window.init();
        GL.createCapabilities();

////        //code
//        objects.add(new Object2d(
//            Arrays.asList(
//                //shaderFile lokasi menyesuaikan objectnya
//                new ShaderProgram.ShaderModuleData
//                ("resources/shaders/scene.vert"
//                , GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData
//                ("resources/shaders/scene.frag"
//                , GL_FRAGMENT_SHADER)
//            ),
//            new ArrayList<>(
//                List.of(
//                    new Vector3f(0.0f,0.5f,0.0f),
//                    new Vector3f(-0.5f,-0.5f,0.0f),
//                    new Vector3f(0.5f,-0.5f,0.0f)
//                )
//            ), new Vector4f(0.0f,1.0f,1.0f,1.0f)
//        ));

        //code
//        objects.add(new Object2d(
//            Arrays.asList(
//                    //shaderFile lokasi menyesuaikan objectnya
//                    new ShaderProgram.ShaderModuleData
//                            ("resources/shaders/sceneWithVerticesColor.vert"
//                                    , GL_VERTEX_SHADER),
//                    new ShaderProgram.ShaderModuleData
//                            ("resources/shaders/sceneWithVerticesColor.frag"
//                                    , GL_FRAGMENT_SHADER)
//            ),
//            new ArrayList<>(
//                    List.of(
//                            new Vector3f(0.0f,0.5f,0.0f),
//                            new Vector3f(-0.5f,-0.5f,0.0f),
//                            new Vector3f(0.5f,-0.5f,0.0f)
//                    )
//            ), new ArrayList<>(
//                List.of(
//                        new Vector3f(1.0f,0.0f,0.0f),
//                        new Vector3f(0.0f,1.0f,0.0f),
//                        new Vector3f(0.0f,0.0f,1.0f)
//                )
//        )
//        ));

        //rumah
//        objects.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-1.0f,-0.4f,0.0f),
//                                new Vector3f(1.0f,-0.4f,0.0f),
//                                new Vector3f(-1.0f,-1.0f,0.0f),
//                                new Vector3f(1.0f,-1.0f,0.0f)
//                        )
//                ), new Vector4f(0.0f,0.5f,0.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        objects.add(new Rectangle(
//            Arrays.asList(
//                //shaderFile lokasi menyesuaikan objectnya
//                new ShaderProgram.ShaderModuleData
//                ("resources/shaders/scene.vert"
//                , GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData
//                ("resources/shaders/scene.frag"
//                , GL_FRAGMENT_SHADER)
//            ),
//            new ArrayList<>(
//                List.of(
//                    new Vector3f(-0.5f,0.3f,0.0f),
//                    new Vector3f(0.5f,0.3f,0.0f),
//                    new Vector3f(-0.8f,-0.2f,0.0f),
//                    new Vector3f(0.8f,-0.2f,0.0f)
//                )
//            ), new Vector4f(1.0f,0.0f,0.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        objects.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.7f,-0.2f,0.0f),
//                                new Vector3f(0.7f,-0.2f,0.0f),
//                                new Vector3f(-0.7f,-0.6f,0.0f),
//                                new Vector3f(0.7f,-0.6f,0.0f)
//                        )
//                ), new Vector4f(1.0f,0.5f,0.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        objects.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.7f,-0.1f,0.0f),
//                                new Vector3f(-0.5f,0.25f,0.0f),
//                                new Vector3f(-0.7f,-0.2f,0.0f),
//                                new Vector3f(-0.3f,-0.2f,0.0f)
//                        )
//                ), new Vector4f(1.0f,0.5f,0.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        //cerobong
//        objects.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.3f,0.2f,0.0f),
//                                new Vector3f(0.4f,0.2f,0.0f),
//                                new Vector3f(0.3f,0.4f,0.0f),
//                                new Vector3f(0.4f,0.4f,0.0f)
//                        )
//                ), new Vector4f(1.0f,0.5f,0.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        objects.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.25f,0.4f,0.0f),
//                                new Vector3f(0.45f,0.4f,0.0f),
//                                new Vector3f(0.25f,0.46f,0.0f),
//                                new Vector3f(0.45f,0.46f,0.0f)
//                        )
//                ), new Vector4f(1.0f,0.0f,0.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//
//        //bulan
//        objects.add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(1.0f,1.0f,0.0f,1.0f), "circle",-0.75, 0.75,0.12,0.12
//        ));
//
//        objects.add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(0.0f,0.0f,1.0f,1.0f), "circle", -0.70, 0.75,0.12,0.12
//        ));
//
//
//        //asap
//        objects.add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(0.7f,0.7f,0.7f,1.0f), "circle", 0.35, 0.51,0.1,0.04
//        ));
//
//        objects.add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(0.7f,0.7f,0.7f,1.0f), "circle", 0.4, 0.57,0.14,0.05
//        ));
//
//        objectsCircle.add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(0.7f,0.7f,0.7f,1.0f), "circle", 0.48, 0.62,0.2,0.05
//        ));
//
//        objects.add(new Star(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(1.0f,1.0f,0.0f,0.0f),  Arrays.asList(0,2,4,1,3), -0.4, 0.8,0.05,45
//        ));
//
//        objects.add(new Star(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(1.0f,1.0f,0.0f,0.0f),  Arrays.asList(0,2,4,1,3), 0.2, 0.9,0.05,0
//        ));
//
//        objects.add(new Star(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ), new Vector4f(1.0f,1.0f,0.0f,0.0f),  Arrays.asList(0,2,4,1,3), -0.2, 0.6,0.03 ,0
//        ));
//
        objectpointcontrol.add(new Object2d(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(

                        )
                ), new Vector4f(0.0f,1.0f,1.0f,1.0f)
        ));
    }

    public void input(){

        if (window.isKeyPressed(GLFW_KEY_W)){
            objectCurve.add(new Curve(
                    Arrays.asList(
                            //shaderFile lokasi menyesuaikan objectnya
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    objectpointcontrol.get(0).vertices, new Vector4f(0.0f,1.0f,1.0f,1.0f)
            ));
        };

        if (objectClicked){
            Vector2f pos = window.getMouseInput().getCurrentPos();

            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);

            System.out.println("x: " + pos.x + " y: " + pos.y);


            if (!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1)) {
                ((Circle) objectsCircle.get(objectClikedIndex)).changeCircle(pos.x, pos.y, 0.1, 0.1);
                objectpointcontrol.get(0).changeVertices(objectClikedIndex, pos.x, pos.y);
//                objectpointcontrol.get(objectClikedIndex)
            }
            if (window.getMouseInput().isLeftButtonPressed()) {
                objectClicked = false;
            }
        }

        if (window.getMouseInput().isLeftButtonPressed()&& !objectClicked){

            Vector2f pos = window.getMouseInput().getCurrentPos();

            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
            pos.y = (pos.y- (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);


            for (int i = 0; i < objectsCircle.size(); i++) {
                if (objectsCircle.get(i).vertices.get(1).x < pos.x && objectsCircle.get(i).vertices.get(0).x > pos.x) {
                    if (objectsCircle.get(i).vertices.get(3).y < pos.y && objectsCircle.get(i).vertices.get(0).y > pos.y) {
                        objectClicked = true;
                        objectClikedIndex = i;
                        break;
                    }
                }
            }

            if (!objectClicked) {
                if (!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1)) {
                    System.out.println("x: " + pos.x + " y: " + pos.y);
                    objectpointcontrol.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
                    objectsCircle.add(new Circle(
                            Arrays.asList(
                                    //shaderFile lokasi menyesuaikan objectnya
                                    new ShaderProgram.ShaderModuleData
                                            ("resources/shaders/scene.vert"
                                                    , GL_VERTEX_SHADER),
                                    new ShaderProgram.ShaderModuleData
                                            ("resources/shaders/scene.frag"
                                                    , GL_FRAGMENT_SHADER)
                            ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), "square", pos.x, pos.y, 0.1, 0.1
                    ));
                }
            }

        }
    }

    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 1.0f,
                    0.0f);
            GL.createCapabilities();
            input();
            //code
//            for(Object2d object: objects){
//                object.drawWithVerticesColor();
//            }

            for(Object2d object: objectsCircle){
                object.draw();
            }

            for(Object2d object: objectpointcontrol){
                object.drawLine();
            }

            for(Object2d object: objectCurve){
                object.drawLine();
            }

//            for(Object2d object: objectsRectangle){
//                object.draw();
//            }
//
//            for(Object2d object: objectsCircle){
//                object.draw();
//            }



            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }
    public void run() {

        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}