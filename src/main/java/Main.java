import Engine.*;
import Engine.Object;
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
    private final Window window = new Window(800, 800, "Tugas III");

    private ArrayList<Object2d> objects = new ArrayList<>();
    private ArrayList<Object2d> objectsRectangle= new ArrayList<>();
    private ArrayList<Object2d> objectsCircle= new ArrayList<>();
    private  ArrayList<Object2d> objectpointcontrol = new ArrayList<>();
    private  ArrayList<Object2d> objectCurve = new ArrayList<>();
    private  ArrayList<Object> objkotak = new ArrayList<>();
    boolean objectClicked = false;
    float derajat = 0.0f;
    Vector2f pos;

    public void init(){
        window.init();
        GL.createCapabilities();
//        matahari
        objkotak.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objkotak.get(0).scaleObject(0.2f,0.2f,0.2f);

//        merkurius
        objkotak.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.255f,0.262f,0.27f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objkotak.get(1).translateObject(2.0f,0.0f,0.0f);
        objkotak.get(1).scaleObject(0.1f,0.1f,0.1f);

//        venus
        objkotak.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.733f,0.502f,0.216f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objkotak.get(2).translateObject(2.5f,0.0f,0.0f);
        objkotak.get(2).scaleObject(0.15f,0.15f,0.15f);
//         bulan
        objkotak.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.855f,0.855f,0.847f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
//        objkotak.get(3).translateObject(10.0f,0.0f,0.0f);
        objkotak.get(3).translateObject(15.0f,0.0f,0.0f);
        objkotak.get(3).scaleObject(0.05f,0.05f,0.05f);
//        bumi
        objkotak.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objkotak.get(4).translateObject(4.10f,0.0f,0.0f);
//        objkotak.get(4).translateObject(4.25f,0.0f,0.0f);
        objkotak.get(4).scaleObject(0.15f,0.15f,0.15f);
//        mars
        objkotak.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.776f,0.714f,0.565f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objkotak.get(5).translateObject(3.85f,0.0f,0.0f);
//        objkotak.get(5).translateObject(3.65f,0.0f,0.0f);
        objkotak.get(5).scaleObject(0.25f,0.25f,0.25f);


//        objkotak.get(0).translateObject(0.5f,0.0f,0.0f);


    }

    public void input(){
        if(window.isKeyPressed(GLFW_KEY_F)){
            derajat += 0.5f;
            objkotak.get(0).rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
            objkotak.get(1).rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
            objkotak.get(2).rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
            objkotak.get(3).rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
            objkotak.get(4).rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
            objkotak.get(5).rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//            System.out.println(objkotak.get(4).getMatrix().get(3,0));
//            System.out.println(objkotak.get(4).getMatrix().get(3,1));
//            System.out.println(((Sphere)objkotak.get(3)).getCenterPoint());

        }
        if(window.isKeyPressed(GLFW_KEY_G)){
            for(Object objek:objkotak){
                float x1 = objek.getMatrix().get(3,0);
                float x2 = objek.getMatrix().get(3,1);
                float x3 = objek.getMatrix().get(3,2);
                objek.translateObject(-x1,-x2,-x3);
                objek.rotateObject(0.005f,1.0f,1.0f,1.0f);
                objek.translateObject(x1,x2,x3);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_H)){

            float titikpusatbumix = objkotak.get(4).getMatrix().get(3,0);
            float titikpusatbumiy = objkotak.get(4).getMatrix().get(3,1);

            ((Sphere)objkotak.get(3)).rotateObjectOnPoint((float) Math.toRadians(1), 0, 0, 1,
                    (float) titikpusatbumix,(float)titikpusatbumiy);

        }
//        if(window.getMouseInput().isLeftButtonPressed()){
//            pos = getPosition(window);
//
//            System.out.println(pos.x);
//            System.out.println(pos.y);
//        }
    }

    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            GL.createCapabilities();
            input();
            //code
            for(Object object: objkotak){
                object.drawIndices();
            }



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

    public Vector2f getPosition(Window window)
    {
        Vector2f pos = window.getMouseInput().getCurrentPos();

        pos.x = (pos.x - (window.getWidth())/2f) / (window.getWidth() / 2f);
        pos.y = (pos.y - (window.getHeight())/2f) / (window.getHeight() / 2f);
        return pos;
    }
}