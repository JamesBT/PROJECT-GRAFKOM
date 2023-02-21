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

public class TugasRumah {
    private Window window =  new Window(800,800,"Hello World!");

    ArrayList<Object2d> objects = new ArrayList<>();

    ArrayList<Bintang> objectsBintang = new ArrayList<>();
    ArrayList<Circle> objectsCircle = new ArrayList<>();
    ArrayList<Rectangle> objectsRectangle = new ArrayList<>();


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
//        objects.add(new Object2d(
//                        Arrays.asList(
//                            new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert",GL_VERTEX_SHADER)
//                            ,new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag",GL_FRAGMENT_SHADER)
//                        ), new ArrayList<>(
//                            List.of(
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f)
//                            )
//                        ), new ArrayList<>(
//                                List.of(
//                                        new Vector3f(1.0f,0.0f,0.0f),
//                                        new Vector3f(0.0f,1.0f,0.0f),
//                                        new Vector3f(0.0f,0.0f,1.0f)
//                                )
//                        )
//                )
//        );
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
//                    ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                    List.of(
//                        new Vector3f(0.0f,0.0f,0.0f),
//                        new Vector3f(0.5f,0.0f,0.0f),
//                        new Vector3f(0.0f,0.5f,0.0f),
//                        new Vector3f(0.5f,0.5f,0.0f)
//                    )
//                ),
//                new Vector4f(0.0f,1.0f,1.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//            )
//        );

        //persegi hijau
        objectsRectangle.add(new Rectangle(
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
                                new Vector3f(-1.0f,-0.7f,0.0f),
                                new Vector3f(1.0f,-0.7f,0.0f),
                                new Vector3f(-1.0f,-1.0f,0.0f),
                                new Vector3f(1.0f,-1.0f,0.0f)
                        )
                ), new Vector4f(0.0f,0.502f,0.004f,1.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));

        //Body Rumah Coklat
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.6f,-0.3f,0.0f),
                                new Vector3f(0.6f,-0.3f,0.0f),
                                new Vector3f(-0.6f,-0.8f,0.0f),
                                new Vector3f(0.6f,-0.8f,0.0f)
                        )
                ), new Vector4f(0.694f,0.502f,0.0f,1.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));


        //Trapesium Merah
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.45f,0.1f,0.0f),
                                new Vector3f(-0.45f,0.1f,0.0f),
                                new Vector3f(0.7f,-0.3f,0.0f),
                                new Vector3f(-0.7f,-0.3f,0.0f)
                        )
                ), new Vector4f(1.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));

        //segitiga rumah
        objectsRectangle.add(new Rectangle(
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
                                new Vector3f(-0.45f,0.02f,0.0f), // Top right
                                new Vector3f(-0.3f,-0.3f,0.0f), // Bot left
                                new Vector3f(-0.6f,-0.22f,0.0f), //Bot Right
                                new Vector3f(-0.6f,-0.3f,0.0f)
                        )
                ), new Vector4f(0.694f,0.502f,0.0f,1.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));

        //cerobong asap 1
        objectsRectangle.add(new Rectangle(
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
                                new Vector3f(0.3f,0.2f,0.0f),//Top Right
                                new Vector3f(0.2f,0.2f,0.0f),//Top Left
                                new Vector3f(0.2f,0.0f,0.0f),//Bot Left
                                new Vector3f(0.3f,0.0f,0.0f)// Bot Right
                        )
                ), new Vector4f(0.694f,0.502f,0.0f,1.0f),
                Arrays.asList(0,1,2,0,2,3)
        ));

        //tutup asap 1
        objectsRectangle.add(new Rectangle(
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
                                new Vector3f(0.18f,0.25f,0.0f),//Top Right
                                new Vector3f(0.32f,0.25f,0.0f),//Top Left
                                new Vector3f(0.18f,0.2f,0.0f),//Bot Left
                                new Vector3f(0.32f,0.2f,0.0f)// Bot Right
                        )
                ), new Vector4f(0.694f,0.2f,0.0f,1.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));

        //bintang kiri
        objectsBintang.add(new Bintang(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                                ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                        ), new ArrayList<>(
                        List.of(
                                new Vector3f(-0.65f,0.45f,0.0f),
                                new Vector3f(-0.69f,0.38f,0.0f),
                                new Vector3f(-0.62f,0.41f,0.0f),
                                new Vector3f(-0.70f,0.43f,0.0f),
                                new Vector3f(-0.65f,0.375f,0.0f)
                        )
                ),
                        new Vector4f(1.0f,1.0f,0.0f,1.0f),
                        Arrays.asList(0,1,1,2,2,3,3,4,4,0)
                )
        );

        //bintang tengah
        objectsBintang.add(new Bintang(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                                ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                        ), new ArrayList<>(
                        List.of(
                                new Vector3f(-0.05f,0.85f,0.0f),
                                new Vector3f(-0.03f,0.8f,0.0f),
                                new Vector3f(-0.08f,0.83f,0.0f),
                                new Vector3f(-0.02f,0.83f,0.0f),
                                new Vector3f(-0.07f,0.8f,0.0f)
                        )
                ),
                        new Vector4f(1.0f,1.0f,0.0f,1.0f),
                        Arrays.asList(0,1,1,2,2,3,3,4,4,0)
                )
        );

        //bintang kanan
        objectsBintang.add(new Bintang(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                                ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                        ), new ArrayList<>(
                        List.of(
                                new Vector3f(0.85f,0.65f,0.0f),
                                new Vector3f(0.89f,0.58f,0.0f),
                                new Vector3f(0.82f,0.61f,0.0f),
                                new Vector3f(0.90f,0.63f,0.0f),
                                new Vector3f(0.85f,0.575f,0.0f)
                        )
                ),
                        new Vector4f(1.0f,1.0f,0.0f,1.0f),
                        Arrays.asList(0,1,1,2,2,3,3,4,4,0)
                )
        );
    }



    public void loop(){
        while(window.isOpen()){
            window.update();
            //warna dibagi 255 (r/255,g/255,b/255)
            glClearColor(0.2f,0.196f,0.898f,1.0f);
            GL.createCapabilities();
            //code
            //dibawah createcapabilities
            for(Bintang object:objectsBintang){
                object.draw();
            }
            for(Rectangle object2:objectsRectangle){
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
        new TugasRumah().run();
    }
}