//import Engine.*;
//import org.joml.Vector3f;
//import org.joml.Vector4f;
//import org.lwjgl.opengl.GL;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.lwjgl.glfw.GLFW.glfwPollEvents;
//import static org.lwjgl.opengl.GL11.glClearColor;
//import static org.lwjgl.opengl.GL20.*;
////jangan pakai gl30
//
//public class TugasRumah {
//    private Window window =  new Window(800,800,"Hello World!");
//
//    ArrayList<Object2d> objects = new ArrayList<>();
//
//    ArrayList<Bintang> objectsBintang = new ArrayList<>();
//    ArrayList<Circle> objectsCircle = new ArrayList<>();
//    ArrayList<Rectangle> objectsRectangle = new ArrayList<>();
//
//
//    public void init(){
//        window.init();
//        GL.createCapabilities();
//
//        //persegi hijau
//        objectsRectangle.add(new Rectangle(
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
//                                new Vector3f(-1.0f,-0.7f,0.0f),
//                                new Vector3f(1.0f,-0.7f,0.0f),
//                                new Vector3f(-1.0f,-1.0f,0.0f),
//                                new Vector3f(1.0f,-1.0f,0.0f)
//                        )
//                ), new Vector4f(0.0f,0.502f,0.004f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        //Body Rumah Coklat
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.6f,-0.3f,0.0f),
//                                new Vector3f(0.6f,-0.3f,0.0f),
//                                new Vector3f(-0.6f,-0.8f,0.0f),
//                                new Vector3f(0.6f,-0.8f,0.0f)
//                        )
//                ), new Vector4f(0.694f,0.502f,0.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//
//        //Trapesium Merah
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.45f,0.1f,0.0f),
//                                new Vector3f(-0.45f,0.1f,0.0f),
//                                new Vector3f(0.7f,-0.3f,0.0f),
//                                new Vector3f(-0.7f,-0.3f,0.0f)
//                        )
//                ), new Vector4f(1.0f,0.0f,0.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        //segitiga rumah
//        objectsRectangle.add(new Rectangle(
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
//                                new Vector3f(-0.45f,0.02f,0.0f), // Top right
//                                new Vector3f(-0.3f,-0.3f,0.0f), // Bot left
//                                new Vector3f(-0.6f,-0.22f,0.0f), //Bot Right
//                                new Vector3f(-0.6f,-0.3f,0.0f)
//                        )
//                ), new Vector4f(0.694f,0.502f,0.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        //cerobong asap 1
//        objectsRectangle.add(new Rectangle(
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
//                                new Vector3f(0.3f,0.2f,0.0f),//Top Right
//                                new Vector3f(0.2f,0.2f,0.0f),//Top Left
//                                new Vector3f(0.2f,0.0f,0.0f),//Bot Left
//                                new Vector3f(0.3f,0.0f,0.0f)// Bot Right
//                        )
//                ), new Vector4f(0.694f,0.502f,0.0f,1.0f),
//                Arrays.asList(0,1,2,0,2,3)
//        ));
//
//        //tutup asap 1
//        objectsRectangle.add(new Rectangle(
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
//                                new Vector3f(0.18f,0.25f,0.0f),//Top Right
//                                new Vector3f(0.32f,0.25f,0.0f),//Top Left
//                                new Vector3f(0.18f,0.2f,0.0f),//Bot Left
//                                new Vector3f(0.32f,0.2f,0.0f)// Bot Right
//                        )
//                ), new Vector4f(0.694f,0.2f,0.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        //bintang kiri
//        objectsBintang.add(new Bintang(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
//                                ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
//                        ), new ArrayList<>(
//                        List.of()
//                ),
//                        new Vector4f(1.0f,1.0f,0.0f,1.0f),
//                        0.05,-0.4,0.3,Arrays.asList(0, 3, 3, 1, 1, 4, 4, 2, 2, 0)
//                )
//        );
//
//        //bintang tengah
//        objectsBintang.add(new Bintang(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
//                                ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
//                        ), new ArrayList<>(
//                        List.of()
//                ),
//                        new Vector4f(1.0f,1.0f,0.0f,1.0f),
//                        0.02,-0.05,0.9,Arrays.asList(0, 3, 3, 1, 1, 4, 4, 2, 2, 0)
//                )
//        );
//
//        objectsBintang.add(new Bintang(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
//                                ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
//                        ), new ArrayList<>(
//                        List.of()
//                ),
//                        new Vector4f(1.0f,1.0f,0.0f,1.0f),
//                        0.05,0.85,0.6,Arrays.asList(0, 3, 3, 1, 1, 4, 4, 2, 2, 0)
//                )
//        );
//
//        //bulan
//        objectsCircle.add(new Circle(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
//                                ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
//                        ), new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                        new Vector4f(1.0f,1.0f,0.0f,1.0f),
//                        0.1f,-0.7,0.7
//                )
//        );
//        objectsCircle.add(new Circle(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
//                                ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
//                        ), new ArrayList<>(
//                        List.of(
//
//                        )
//                ),
//                        new Vector4f(0.2f,0.196f,0.898f,1.0f),
//                        0.1f,-0.65,0.7
//                )
//        );
//
//        //asap 1
//        objectsCircle.add(new Circle(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
//                                ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
//                        ), new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f,0.0f,0.0f),
//                                new Vector3f(0.5f,0.0f,0.0f),
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                        new Vector4f(0.502f,0.502f,0.502f,1.0f),
//                        0.075,1.5,0.25,0.35
//                )
//        );
//        //asap2
//        objectsCircle.add(new Circle(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
//                                ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
//                        ), new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f,0.0f,0.0f),
//                                new Vector3f(0.5f,0.0f,0.0f),
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                        new Vector4f(0.502f,0.502f,0.502f,1.0f),
//                        0.15,2,0.35,0.4
//                )
//        );
//        //asap3
//        objectsCircle.add(new Circle(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
//                                ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
//                        ), new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f,0.0f,0.0f),
//                                new Vector3f(0.5f,0.0f,0.0f),
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                        new Vector4f(0.502f,0.502f,0.502f,1.0f),
//                        0.25,3,0.52,0.48
//                )
//        );
//    }
//
//
//
//    public void loop(){
//        while(window.isOpen()){
//            window.update();
//            //warna dibagi 255 (r/255,g/255,b/255)
//            glClearColor(0.2f,0.196f,0.898f,1.0f);
//            GL.createCapabilities();
//            //code
//            //dibawah createcapabilities
//            for(Bintang object:objectsBintang){
//                object.draw();
//            }
//            for(Circle object2:objectsCircle){
//                object2.draw();
//            }
//            for(Rectangle object3:objectsRectangle){
//                object3.draw();
//            }
//
//
//            //diatas disablevertex+pollevent
//            glDisableVertexAttribArray(0);
//            glfwPollEvents();
//        }
//    }
//
//    public void run(){
//        init();
//        loop();
//    }
//    public static void main(String[] args){
//        new TugasRumah().run();
//    }
//}