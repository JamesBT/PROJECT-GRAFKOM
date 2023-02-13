import Engine.Window;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
//jangan pakai gl30

public class Main {
    private Window window =  new Window(1366,768,"Hello World!");
    public void run(){
        init();
        loop();
    }

    public void init(){
        window.init();
        GL.createCapabilities();
        //jika buat harus dibuat dibawah GL.createCapabilities
        //code
    }

    public void loop(){
        while(window.isOpen()){
            window.update();
            //warna dibagi 255 (r/255,g/255,b/255)
            glClearColor(1.0f,0.0f,0.0f,0.0f);
            GL.createCapabilities();
            //code
            //dibawah createcapabilities



            //diatas disablevertex+pollevent
            glDisableVertexAttribArray(0);
            glfwPollEvents();
        }
    }
    public static void main(String[] args){
        new Main().run();
    }
}