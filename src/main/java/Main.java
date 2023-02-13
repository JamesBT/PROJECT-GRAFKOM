import Engine.Window;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
//jangan pakai gl30

public class Main {
    private Window window =  new Window(800,800,"Hello World!");
    public void run(){
        init();
        loop();
    }

    public void init(){
        window.init();
        GL.createCapabilities();
    }

    public void loop(){
        while(window.isOpen()){
            window.update();
            glClearColor(0.0f,0.0f,0.0f,0.0f);
            GL.createCapabilities();
            glDisableVertexAttribArray(0);
            glfwPollEvents();
        }
    }
}