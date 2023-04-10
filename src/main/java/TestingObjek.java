import Engine.Object;
import Engine.*;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class TestingObjek {
    private final Window window = new Window(800, 800, "Tugas III");

    private  ArrayList<Object> objkotak = new ArrayList<>();

    public void init(){
        window.init();
        GL.createCapabilities();
//        kotak 1
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
        objkotak.get(0).scaleObject(0.3f,0.3f,0.3f);
//        kotak anak 1.1
        objkotak.get(0).getChildObject().add(
                new Sphere(
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
                )
        );
        objkotak.get(0).getChildObject().get(0).scaleObject(0.2f,0.2f,0.2f);
        objkotak.get(0).getChildObject().get(0).translateObject(0.2f,0.0f,0.0f);
//        kotak anak 1.2
        objkotak.get(0).getChildObject().add(
                new Sphere(
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
                )
        );
        objkotak.get(0).getChildObject().get(1).scaleObject(0.2f,0.2f,0.2f);
        objkotak.get(0).getChildObject().get(1).translateObject(0.4f,0.0f,0.0f);
//        tambahi anak di kotak 1.2
        objkotak.get(0).getChildObject().get(1).getChildObject().add(
                new Sphere(
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
                )
        );
        objkotak.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.075f,0.075f,0.075f);
        objkotak.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.5f,0.0f,0.0f);
    }

    public void input(){
        if(window.isKeyPressed(GLFW_KEY_W)){
            objkotak.get(0).rotateObject(0.01f,0.0f,0.0f,1.0f);

            for(Object child:objkotak.get(0).getChildObject()){
                Vector3f tempCenterPoint = child.updateCenterPoint();
                child.translateObject(tempCenterPoint.x*(-1),tempCenterPoint.y*(-1),tempCenterPoint.z*(-1));
                child.rotateObject((float)Math.toRadians(0.1f),0.0f,0.0f,1.0f);
                child.translateObject(tempCenterPoint.x*(1),tempCenterPoint.y*(1),tempCenterPoint.z*(1));

                //rotasi terhadap parentnya
                for(Object child2:objkotak.get(0).getChildObject().get(1).getChildObject()){
                    Vector3f tempCenterPoint2 = child2.updateCenterPoint();
                    child2.translateObject(tempCenterPoint2.x*(-1),tempCenterPoint2.y*(-1),tempCenterPoint2.z*(-1));
                    child2.rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
                    child2.translateObject(tempCenterPoint2.x*(1),tempCenterPoint2.y*(1),tempCenterPoint2.z*(1));
                }
            }
        }
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
                object.draw();
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
        new TestingObjek().run();
    }

}