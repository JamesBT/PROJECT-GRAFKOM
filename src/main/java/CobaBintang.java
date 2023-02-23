import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL20.*;
//jangan pakai gl30

public class CobaBintang {
    private Window window =  new Window(800,800,"Hello World!");

    ArrayList<Bintang> objects = new ArrayList<>();

    public void init(){
        window.init();
        GL.createCapabilities();
        //jika buat harus dibuat dibawah GL.createCapabilities
        //code

        objects.add(new Bintang(
                Arrays.asList(
                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                    ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                    List.of(
                            new Vector3f(-0.85f,0.85f,0.0f),
                            new Vector3f(-0.8f,0.75f,0.0f),
                            new Vector3f(-0.95f,0.8f,0.0f),
                            new Vector3f(-0.75f,0.8f,0.0f),
                            new Vector3f(-0.9f,0.75f,0.0f)
                    )
                ),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0,1,1,2,2,3,3,4,4,0)
            )
        );



    }



    public void loop(){
        while(window.isOpen()){
            window.update();
            //warna dibagi 255 (r/255,g/255,b/255)
            glClearColor(0.0f,0.0f,1.0f,0.0f);
            GL.createCapabilities();
            //code
            //dibawah createcapabilities
            for(Bintang object:objects){
                object.draw();
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
        new CobaBintang().run();
    }
}