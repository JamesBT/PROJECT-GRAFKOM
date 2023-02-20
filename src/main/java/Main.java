import Engine.Object2d;
import Engine.ShaderProgram;
import Engine.Window;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL20.*;
//jangan pakai gl30

public class Main {
    private Window window =  new Window(1366,768,"Hello World!");

    ArrayList<Object2d> objects = new ArrayList<>();


    public void init(){
        window.init();
        GL.createCapabilities();
        //jika buat harus dibuat dibawah GL.createCapabilities
        //code

//        objects.add(new Object2d(
//                Arrays.asList(
//                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
//                    ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                    List.of(
//                        new Vector3f(0.0f,0.5f,0.0f),
//                        new Vector3f(-0.5f,-0.5f,0.0f),
//                        new Vector3f(0.5f,-0.5f,0.0f)
//                    )
//                ),
//                new Vector4f(0.0f,1.0f,1.0f,1.0f)
//            )
//        );
        //with vertices color
        objects.add(new Object2d(
                        Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert",GL_VERTEX_SHADER)
                            ,new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag",GL_FRAGMENT_SHADER)
                        ), new ArrayList<>(
                            List.of(
                                new Vector3f(0.0f,0.5f,0.0f),
                                new Vector3f(-0.5f,-0.5f,0.0f),
                                new Vector3f(0.5f,-0.5f,0.0f)
                            )
                        ), new ArrayList<>(
                                List.of(
                                        new Vector3f(1.0f,0.0f,0.0f),
                                        new Vector3f(0.0f,1.0f,0.0f),
                                        new Vector3f(0.0f,0.0f,1.0f)
                                )
                        )
                )
        );
    }

    public void loop(){
        while(window.isOpen()){
            window.update();
            //warna dibagi 255 (r/255,g/255,b/255)
            glClearColor(0.0f,0.0f,0.0f,0.0f);
            GL.createCapabilities();
            //code
            //dibawah createcapabilities
            for(Object2d object:objects){
                object.drawwithVerticesColor();
            }


            //diatas disablevertex+pollevent
            glDisableVertexAttribArray(0);
            glfwPollEvents();
        }
    }

    public void run(){
        init();
        loop();
    }
    public static void main(String[] args){
        new Main().run();
    }
}