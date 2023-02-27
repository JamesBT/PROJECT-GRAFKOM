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
import static org.lwjgl.opengl.GL20.*;
//jangan pakai gl30

public class Main {
    private Window window =  new Window(800,800,"Hello World!");

    ArrayList<Object2d> objects = new ArrayList<>();
    ArrayList<Object2d> objectsPointsControl = new ArrayList<>();
    ArrayList<Object2d> kotak = new ArrayList<>();
    ArrayList<Rectangle> objectsRectangle = new ArrayList<>();
    ArrayList<Bintang> objectsBintang = new ArrayList<>();



    public void init(){
        window.init();
        GL.createCapabilities();
        //jika buat harus dibuat dibawah GL.createCapabilities
        //code
        objectsPointsControl.add(new Object2d(
                Arrays.asList(
                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                    ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.0f,1.0f,1.0f,1.0f)
            )
        );
    }
    public void input(){
        Kotak ktk;
        List<ShaderProgram.ShaderModuleData> shader = Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        );
        if(window.isKeyPressed(GLFW_KEY_W)){
            System.out.println("W");
        }
        if(window.getMouseInput().isLeftButtonPressed()){
            Vector2f pos = window.getMouseInput().getCurrentPos();
//            System.out.println("x: "+pos.x+" y : "+pos.y);
            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
            pos.y = (pos.y - (window.getWidth())/2.0f) / (-window.getHeight()/2.0f);
//            System.out.println("x: "+pos.x+" y : "+pos.y);
            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))){
                System.out.println("x: "+pos.x+" y : "+pos.y);
                objectsPointsControl.get(0).addVertices(new Vector3f(pos.x,pos.y,0));

                kotak.add(new Kotak(
                        shader,new ArrayList<>(),new Vector4f(0.996f,0.0f,0.0f,1.0f),
                        pos.x,pos.y,0.05,0.05));

                for(Object2d object : kotak){
                    if(object instanceof Kotak){
                        ktk = (Kotak) object;
//                        ktk.getCx();
                        System.out.println("REEEE");
                    }
                }

            }
        }
    }
    public void loop(){
        while(window.isOpen()){
            window.update();
            //warna dibagi 255 (r/255,g/255,b/255)
            glClearColor(0.0f,0.0f,1.0f,0.0f);
            GL.createCapabilities();
            input();
            //code
            //dibawah createcapabilities
            for(Object2d object:objectsPointsControl){
                object.drawLine();
            }
            for(Object2d object2:kotak){
                object2.draw();
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