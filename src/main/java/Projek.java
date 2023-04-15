import Engine.ObjectJames;
import Engine.*;
import org.joml.Vector2f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Projek {
    private final Window window = new Window(800, 800, "Projek Spongebob");

    private ArrayList<ObjectJames> obj = new ArrayList<>();

    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(),window.getHeight());

    float degreexcamera = 0f;
    float degreeycamera = 0f;
    float degreezcamera = 2.5f;
    float degreekakikiri =0f;
    float degreekakikanan = 0f;
    float degreetanganbawah = 0f;
    float degreetanganatas = 0f;
    float degreekepala = 0f;
    float degree =0.5f;
    float degree2 = 0.005f;
    float arahkakikiri = -1.0f;
    float arahkakikanan = 1.0f;
    float sudutkamera=0.0f;

    boolean keyJditekan = true;
    boolean keyIditekan = true;
    boolean keyAditekan = true;
    boolean keySditekan = true;
    boolean keyDditekan = true;
    boolean keyWditekan = true;
    float derajatsebelumnya = 0.0f;
    public void init(){
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        camera.setPosition(0,0,2.5f);
        camera.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(0.0f));

        //badan
        obj.add(new SphereJames(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9411764706f,0.7490196078f,0.3137254902f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18,
                1
        ));
        obj.get(0).scaleObject(0.5f,0.5f,1.4f);
        obj.get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);

        //leher
        obj.get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        1
                )
        );
        obj.get(0).getChildObject().get(0).scaleObject(0.125f,0.125f,0.75f);
        obj.get(0).getChildObject().get(0).translateObject(0.0f,0.0f,-0.5f);
        obj.get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
//
        //kepala
        //bola kepala
        obj.get(0).getChildObject().get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
//                        new Vector4f(1.0f,1.0f,1.0f,1.0f),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        2
                )
        );
        obj.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.15f,0.15f,0.15f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f,0.0f,-0.6f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);

        //tabung tengah (mata)
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        1
                )
        );
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.7f,0.7f,0.5f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f,0.0f,-0.75f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //kepala bagian atas
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        3
                )
        );
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(1.25f,0.9f,1.0f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.0f,0.0f,-1.0f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //mulut
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        3
                )
        );
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.85f,0.85f,0.35f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f,0.0f,-0.6f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        // mata kiri
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(1.0f,1.0f,1.0f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        3
                )
        );
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.3f,0.1f,0.3f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.85f,0.05f,0.4f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(90),0f,0f,1f);
        //titik tengah mata kiri
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.4980392157f,0.2352941176f,0.2235294118f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        0
                )
        );
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.05f,0.1f,0.05f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-0.055f,0.835f,0.47f);
        //mata kanan
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(1.0f,1.0f,1.0f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        3
                )
        );
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.3f,0.1f,0.3f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.85f,-0.05f,0.4f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(90),0f,0f,1f);
        //titik tengah mata kanan
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.4980392157f,0.2352941176f,0.2235294118f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        0
                )
        );
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.05f,0.1f,0.05f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.055f,0.835f,0.47f);
        //hidung
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.6862745098f,0.862745098f,0.7882352941f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.01f,
                        0.01f,
                        0.0045f,
                        36,
                        18,
                        4
                )
        );
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f,0.4f,-0.8f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //bagian bawah hidung
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.6862745098f,0.862745098f,0.7882352941f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        2
                )
        );
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).scaleObject(0.125f,0.125f,0.125f);
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).translateObject(0.0f,0.6f,0.4f);

        //tangan kiri
        obj.get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        2
                )
        );
        obj.get(0).getChildObject().get(1).scaleObject(0.25f,0.25f,0.25f);
        obj.get(0).getChildObject().get(1).translateObject(-0.25f,0.225f,0.0f);
        //tabung tangan kiri
        obj.get(0).getChildObject().get(1).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(1.0f,1.0f,1.0f,1.0f),
//                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        1
                )
        );
        obj.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.175f,0.175f,0.5f);
        obj.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(-0.35f,0.0f,-0.13f);
        obj.get(0).getChildObject().get(1).getChildObject().get(0).rotateObject((float)Math.toRadians(270f),1.0f,0.0f,0.0f);
        obj.get(0).getChildObject().get(1).getChildObject().get(0).rotateObject((float)Math.toRadians(-45f),0.0f,0.0f,1.0f);
        //bola tangan kiri
        obj.get(0).getChildObject().get(1).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(1.0f,0.0f,0.0f,1.0f),
//                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        2
                )
        );
        obj.get(0).getChildObject().get(1).getChildObject().get(1).scaleObject(0.175f,0.175f,0.175f);
        obj.get(0).getChildObject().get(1).getChildObject().get(1).translateObject(-0.4225f,0.07f,0.0f);
        //paraboloid tangan kiri
        obj.get(0).getChildObject().get(1).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(1.0f,1.0f,1.0f,1.0f),
//                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        4
                )
        );
        obj.get(0).getChildObject().get(1).getChildObject().get(2).scaleObject(0.025f,0.025f,0.015f);
        obj.get(0).getChildObject().get(1).getChildObject().get(2).translateObject(-0.255f,0.0f,0.075f);
        obj.get(0).getChildObject().get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(270f),1.0f,0.0f,0.0f);
        obj.get(0).getChildObject().get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(45f),0.0f,0.0f,1.0f);


        //tangan kanan
        obj.get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        2
                )
        );
        obj.get(0).getChildObject().get(2).scaleObject(0.25f,0.25f,0.25f);
        obj.get(0).getChildObject().get(2).translateObject(0.25f,0.225f,0.0f);
        //tabung tangan kanan
        obj.get(0).getChildObject().get(2).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
//                        new Vector4f(1.0f,1.0f,1.0f,1.0f),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        1
                )
        );
        obj.get(0).getChildObject().get(2).getChildObject().get(0).scaleObject(0.175f,0.175f,0.5f);
        obj.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(0.35f,0.0f,-0.13f);
        obj.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(270f),1.0f,0.0f,0.0f);
        obj.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(45f),0.0f,0.0f,1.0f);
        //bola tangan kanan
        obj.get(0).getChildObject().get(2).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        2
                )
        );
        obj.get(0).getChildObject().get(2).getChildObject().get(1).scaleObject(0.175f,0.175f,0.175f);
        obj.get(0).getChildObject().get(2).getChildObject().get(1).translateObject(0.4225f,0.07f,0.0f);
        //paraboloid tangan kanan
        obj.get(0).getChildObject().get(2).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
//                        new Vector4f(1.0f,1.0f,1.0f,1.0f),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        4
                )
        );
        obj.get(0).getChildObject().get(2).getChildObject().get(2).scaleObject(0.025f,0.025f,0.015f);
        obj.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(0.255f,0.0f,0.075f);
        obj.get(0).getChildObject().get(2).getChildObject().get(2).rotateObject((float)Math.toRadians(270f),1.0f,0.0f,0.0f);
        obj.get(0).getChildObject().get(2).getChildObject().get(2).rotateObject((float)Math.toRadians(315f),0.0f,0.0f,1.0f);

        //perut bagian kiri bawah
        obj.get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        3
                )
        );
        obj.get(0).getChildObject().get(3).scaleObject(0.25f,0.25f,1.f);
        obj.get(0).getChildObject().get(3).translateObject(-0.05f,-.4f,0.0f);
        //perut bagian kanan bawah
        obj.get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        3
                )
        );
        obj.get(0).getChildObject().get(4).scaleObject(0.25f,0.25f,1.f);
        obj.get(0).getChildObject().get(4).translateObject(0.05f,-.4f,0.0f);

        //kaki kiri depan
//        tabung atas kaki kiri depan
        obj.get(0).getChildObject().get(3).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
//                        new Vector4f(1f,0f,0f,1.0f),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        1
                )
        );
        obj.get(0).getChildObject().get(3).getChildObject().get(0).scaleObject(0.15f,0.15f,1.3f);
        obj.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-0.075f,0.075f,0.8f);
        obj.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //telapak kaki kiri depan
        obj.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                                                new Vector4f(1f,0f,0f,1.0f),
//                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        4
                )
        );
        obj.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(0).scaleObject(0.0175f,0.0175f,0.03f);
        obj.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f,-1.1f,-0.6f);
        obj.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(135),0.0f,1f,0f);

        //kaki kiri belakang
        //tabung kaki kiri belakang
        obj.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
//                        new Vector4f(1f,0f,0f,1.0f),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        1
                )
        );
        obj.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(1).scaleObject(0.15f,0.15f,1.3f);
        obj.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(1).translateObject(-0.075f,-0.075f,0.8f);
        obj.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //telapak kaki kiri belakang
        obj.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        4
                )
        );
        obj.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(2).scaleObject(0.0175f,0.0175f,0.03f);
        obj.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f,-1.1f,-0.6f);
        obj.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(45),0.0f,1f,0f);



        //kaki kanan depan
        obj.get(0).getChildObject().get(4).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        1
                )
        );
        obj.get(0).getChildObject().get(4).getChildObject().get(0).scaleObject(0.15f,0.15f,1.3f);
        obj.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(0.075f,0.075f,0.75f);
        obj.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //bagian kaki kanan depan
        obj.get(0).getChildObject().get(4).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        4
                )
        );
        obj.get(0).getChildObject().get(4).getChildObject().get(1).scaleObject(0.0175f,0.0175f,0.03f);
        obj.get(0).getChildObject().get(4).getChildObject().get(1).translateObject(0.0f,-1.1f,-0.6f);
        obj.get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float)Math.toRadians(225),0.0f,1f,0f);

        //kaki kanan belakang
        obj.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        1
                )
        );
        obj.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(0).scaleObject(0.15f,0.15f,1.3f);
        obj.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(0).translateObject(0.075f,-0.075f,0.75f);
        obj.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //bagian kaki kanan depan
        obj.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        4
                )
        );
        obj.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(1).scaleObject(0.0175f,0.0175f,0.03f);
        obj.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(1).translateObject(0.0f,-1.1f,-0.6f);
        obj.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(315),0.0f,1f,0f);



    }

    public void input(){
        if(window.isKeyPressed(GLFW_KEY_F)){
            for(ObjectJames objek:obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject()){
                float x1 = objek.getMatrix().get(3,0);
                float x2 = objek.getMatrix().get(3,1);
                float x3 = objek.getMatrix().get(3,2);
                objek.translateObject(-x1,-x2,-x3);
                objek.rotateObject(-0.005f,1.0f,0.0f,0.0f);
                objek.translateObject(x1,x2,x3);
            }
        }

        if(window.isKeyPressed(GLFW_KEY_E)){
            if(keyJditekan){
                keyJditekan = false;
            }if(window.isKeyPressed(GLFW_KEY_E) &&!keyJditekan){
                System.out.println("dikembalikan "+derajatsebelumnya);
                if(derajatsebelumnya != 0){
                    obj.get(0).rotateObject((float)Math.toRadians(-derajatsebelumnya),0.0f,1.0f,0.0f);
                }
                //gerakkan kepala ke bawah
                float x1 = obj.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,0);
                float x2 = obj.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,1);
                float x3 = obj.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,2);
                obj.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-x1, -x2, -x3);
                if(degreekepala > 0){
                    obj.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(degreekepala),1.0f,0.0f,0.0f);
                    degreekepala -= degree2;
                }
                obj.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(x1, x2, x3);

                //tangan ke bawah
                x1 = obj.get(0).getChildObject().get(1).getMatrix().get(3,0);
                x2 = obj.get(0).getChildObject().get(1).getMatrix().get(3,1);
                x3 = obj.get(0).getChildObject().get(1).getMatrix().get(3,2);
                float x4 = obj.get(0).getChildObject().get(2).getMatrix().get(3,0);
                float x5 = obj.get(0).getChildObject().get(2).getMatrix().get(3,1);
                float x6 = obj.get(0).getChildObject().get(2).getMatrix().get(3,2);
                obj.get(0).getChildObject().get(1).translateObject(-x1, -x2, -x3);
                obj.get(0).getChildObject().get(2).translateObject(-x4, -x5, -x6);
                if (degreetanganbawah > 0) {
                    obj.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(degreetanganbawah), 1.0f, 0.0f, 0.0f);
                    obj.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(degreetanganbawah), 1.0f, 0.0f, 0.0f);
                    degreetanganbawah -= degree2;
                }
                obj.get(0).getChildObject().get(1).translateObject(x1, x2, x3);
                obj.get(0).getChildObject().get(2).translateObject(x4, x5, x6);

                //lipat tangan ke dalam
                x1 = obj.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,0);
                x2 = obj.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,1);
                x3 = obj.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,2);
                x4 = obj.get(0).getChildObject().get(2).getChildObject().get(1).getMatrix().get(3,0);
                x5 = obj.get(0).getChildObject().get(2).getChildObject().get(1).getMatrix().get(3,1);
                x6 = obj.get(0).getChildObject().get(2).getChildObject().get(1).getMatrix().get(3,2);
                obj.get(0).getChildObject().get(1).getChildObject().get(2).translateObject(-x1, -x2, -x3);
                obj.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(-x4, -x5, -x6);
                if (degreetanganatas >0 ) {
                    obj.get(0).getChildObject().get(1).getChildObject().get(2).rotateObject(-(float) Math.toRadians(degreetanganatas), 1.0f, 0.0f, 1.0f);
                    obj.get(0).getChildObject().get(2).getChildObject().get(2).rotateObject(-(float) Math.toRadians(degreetanganatas), 1.0f, 0.0f, 0.0f);
                    obj.get(0).getChildObject().get(2).getChildObject().get(2).rotateObject((float) Math.toRadians(degreetanganatas), 0.0f, 0.0f, 1.0f);
                    degreetanganatas -= degree2;
                }
                obj.get(0).getChildObject().get(1).getChildObject().get(2).translateObject(x1, x2, x3);
                obj.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(x4, x5, x6);

                obj.get(0).rotateObject((float)Math.toRadians(derajatsebelumnya),0.0f,1.0f,0.0f);

                if(degreetanganatas<=0 && degreetanganbawah <= 0 &&degreekepala <=0){
                    keyJditekan = true;
                }
            }

        }
//        pindahkan objek
        if(window.isKeyPressed(GLFW_KEY_Q)){
            if(keyIditekan){
                keyIditekan = false;
            }
            if(window.isKeyPressed(GLFW_KEY_Q) && !keyIditekan){
                //gerakkan tangan (semuanya)
                if(derajatsebelumnya != 0){
                    obj.get(0).rotateObject((float)Math.toRadians(-derajatsebelumnya),0.0f,1.0f,0.0f);
                }
                float x1 = obj.get(0).getChildObject().get(1).getMatrix().get(3,0);
                float x2 = obj.get(0).getChildObject().get(1).getMatrix().get(3,1);
                float x3 = obj.get(0).getChildObject().get(1).getMatrix().get(3,2);
                float x4 = obj.get(0).getChildObject().get(2).getMatrix().get(3,0);
                float x5 = obj.get(0).getChildObject().get(2).getMatrix().get(3,1);
                float x6 = obj.get(0).getChildObject().get(2).getMatrix().get(3,2);
                float derajattgn =1.125f;
                obj.get(0).getChildObject().get(1).translateObject(-x1, -x2, -x3);
                obj.get(0).getChildObject().get(2).translateObject(-x4, -x5, -x6);
                if (degreetanganbawah < derajattgn) {
                    obj.get(0).getChildObject().get(1).rotateObject(-(float) Math.toRadians(degreetanganbawah), 1.0f, 0.0f, 0.0f);
                    obj.get(0).getChildObject().get(2).rotateObject(-(float) Math.toRadians(degreetanganbawah), 1.0f, 0.0f, 0.0f);
                    degreetanganbawah += degree2;
                }
                obj.get(0).getChildObject().get(1).translateObject(x1, x2, x3);
                obj.get(0).getChildObject().get(2).translateObject(x4, x5, x6);

                //gerakkan kepala ke atas
                x1 = obj.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,0);
                x2 = obj.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,1);
                x3 = obj.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,2);
                obj.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-x1, -x2, -x3);
                float derajatkepala = 0.55f;
                if(degreekepala < derajatkepala){
                    obj.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(-(float)Math.toRadians(degreekepala),1.0f,0.0f,0.0f);
                    degreekepala += degree2;
                }
                obj.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(x1, x2, x3);

                //gerakkan tangan dari siku ke atas
                x1 = obj.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,0);
                x2 = obj.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,1);
                x3 = obj.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,2);
                x4 = obj.get(0).getChildObject().get(2).getChildObject().get(1).getMatrix().get(3,0);
                x5 = obj.get(0).getChildObject().get(2).getChildObject().get(1).getMatrix().get(3,1);
                x6 = obj.get(0).getChildObject().get(2).getChildObject().get(1).getMatrix().get(3,2);
                obj.get(0).getChildObject().get(1).getChildObject().get(2).translateObject(-x1, -x2, -x3);
                obj.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(-x4, -x5, -x6);
                if (degreetanganatas < 1.33f) {
                    obj.get(0).getChildObject().get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(degreetanganatas), 1.0f, 0.0f, 1.0f);
                    obj.get(0).getChildObject().get(2).getChildObject().get(2).rotateObject((float) Math.toRadians(degreetanganatas), 1.0f, 0.0f, 0.0f);
                    obj.get(0).getChildObject().get(2).getChildObject().get(2).rotateObject(-(float) Math.toRadians(degreetanganatas), 0.0f, 0.0f, 1.0f);
                    degreetanganatas += degree2;
                }
                obj.get(0).getChildObject().get(1).getChildObject().get(2).translateObject(x1, x2, x3);
                obj.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(x4, x5, x6);
                System.out.println(derajatsebelumnya);

                obj.get(0).rotateObject((float)Math.toRadians(derajatsebelumnya),0.0f,1.0f,0.0f);

            }




        }

        //aksi 1 - gerak kaki (depan, kiri, belakang, kanan)
        if(window.isKeyPressed(GLFW_KEY_W)){
            if(keyWditekan){
                //perbaiki posisi kaki
                float x1 = obj.get(0).getChildObject().get(3).getMatrix().get(3,0);
                float x2 = obj.get(0).getChildObject().get(3).getMatrix().get(3,1);
                float x3 = obj.get(0).getChildObject().get(3).getMatrix().get(3,2);
                float x4 = obj.get(0).getChildObject().get(4).getMatrix().get(3,0);
                float x5 = obj.get(0).getChildObject().get(4).getMatrix().get(3,1);
                float x6 = obj.get(0).getChildObject().get(4).getMatrix().get(3,2);
                if(degreekakikiri != 0f){
                    while(degreekakikiri < -0.6f || degreekakikiri > 0.6f ){
                        obj.get(0).getChildObject().get(3).translateObject(-x1,-x2,-x3);
                        if(degreekakikiri < -0.6f){
                            arahkakikiri = 1.0f;
                        }else if(degreekakikiri > 0.6f){
                            arahkakikiri = -1.0f;
                        }
                        obj.get(0).getChildObject().get(3).rotateObject(arahkakikiri*(float)Math.toRadians(degree), 1.0f, 0.0f, 0.0f);
                        degreekakikiri+=arahkakikiri*degree;

                        obj.get(0).getChildObject().get(3).translateObject(x1,x2,x3);

                        if(degreekakikiri == 0.0f){
                            break;
                        }
                    }
                }
                if(degreekakikanan !=0f){
                    while(degreekakikanan > 0.6f || degreekakikanan < -0.6f ){
                        obj.get(0).getChildObject().get(4).translateObject(-x4,-x5,-x6);
                        if(degreekakikanan < -0.6f){
                            arahkakikanan = 1.0f;
                            System.out.println("kaki kanan ke belakang");
                        }else if(degreekakikanan > 0.6f){
                            arahkakikanan = -1.0f;
                        }

                        obj.get(0).getChildObject().get(4).rotateObject(arahkakikanan*(float)Math.toRadians(degree), 1.0f, 0.0f, 0.0f);
                        degreekakikanan+=arahkakikanan*degree;

                        obj.get(0).getChildObject().get(4).translateObject(x4,x5,x6);

                        if(degreekakikanan == 0.0f){
                            break;
                        }
                    }
                }



                if(derajatsebelumnya != 0){
                    obj.get(0).rotateObject((float)Math.toRadians(-derajatsebelumnya),0.0f,1.0f,0.0f);
                }
                obj.get(0).rotateObject((float)Math.toRadians(180),0.0f,1.0f,0.0f);
                derajatsebelumnya = 180f;
                keyWditekan=false;
            }
            if(window.isKeyPressed(GLFW_KEY_W) && !keyWditekan)
            {
                float x1 = obj.get(0).getChildObject().get(3).getMatrix().get(3,0);
                float x2 = obj.get(0).getChildObject().get(3).getMatrix().get(3,1);
                float x3 = obj.get(0).getChildObject().get(3).getMatrix().get(3,2);
                float x4 = obj.get(0).getChildObject().get(4).getMatrix().get(3,0);
                float x5 = obj.get(0).getChildObject().get(4).getMatrix().get(3,1);
                float x6 = obj.get(0).getChildObject().get(4).getMatrix().get(3,2);

                for(ObjectJames objek:obj.get(0).getChildObject().get(3).getChildObject()){
                    objek.translateObject(-x1,-x2,-x3);
                    obj.get(0).getChildObject().get(4).translateObject(-x4,-x5,-x6);

                    //arah pertamanya - (ke depan) (kaki kiri)
                    if(degreekakikiri < -10.5f){
                        arahkakikiri = 1.0f;
                    }else if(degreekakikiri > 10.5f){
                        arahkakikiri = -1.0f;
                    }
                    //arah pertamanya + (ke belakang) (kaki kanan)
                    if(degreekakikanan < -10.5f){
                        arahkakikanan = 1.0f;
                    }else if(degreekakikanan > 10.5f){
                        arahkakikanan = -1.0f;
                    }

                    obj.get(0).getChildObject().get(4).rotateObject(arahkakikanan*(float)Math.toRadians(degree), 1.0f, 0.0f, 0.0f);
                    objek.rotateObject(arahkakikiri*(float)Math.toRadians(degree), 1.0f, 0.0f, 0.0f);
                    degreekakikiri+=arahkakikiri*degree;
                    degreekakikanan+=arahkakikanan*degree;

                    objek.translateObject(x1,x2,x3);
                    obj.get(0).getChildObject().get(4).translateObject(x4,x5,x6);
                }
                keyAditekan = true;
                keySditekan = true;
                keyDditekan = true;
            }
        }
        if(window.isKeyPressed(GLFW_KEY_A)){
//            camera.moveLeft(cameraspeed);
            if(keyAditekan){
                //perbaiki posisi kaki
                float x1 = obj.get(0).getChildObject().get(3).getMatrix().get(3,0);
                float x2 = obj.get(0).getChildObject().get(3).getMatrix().get(3,1);
                float x3 = obj.get(0).getChildObject().get(3).getMatrix().get(3,2);
                float x4 = obj.get(0).getChildObject().get(4).getMatrix().get(3,0);
                float x5 = obj.get(0).getChildObject().get(4).getMatrix().get(3,1);
                float x6 = obj.get(0).getChildObject().get(4).getMatrix().get(3,2);
                if(degreekakikiri != 0f){
                    while(degreekakikiri < -0.6f || degreekakikiri > 0.6f ){
                        obj.get(0).getChildObject().get(3).translateObject(-x1,-x2,-x3);
                        if(degreekakikiri < -0.6f){
                            arahkakikiri = 1.0f;
                        }else if(degreekakikiri > 0.6f){
                            arahkakikiri = -1.0f;
                        }
                        obj.get(0).getChildObject().get(3).rotateObject(arahkakikiri*(float)Math.toRadians(degree), 1.0f, 0.0f, 0.0f);
                        degreekakikiri+=arahkakikiri*degree;

                        obj.get(0).getChildObject().get(3).translateObject(x1,x2,x3);

                        if(degreekakikiri == 0.0f){
                            break;
                        }
                    }
                }
                if(degreekakikanan != 0f){
                    while(degreekakikanan > 0.6f || degreekakikanan < -0.6f ){
                        obj.get(0).getChildObject().get(4).translateObject(-x4,-x5,-x6);
                        if(degreekakikanan < -0.6f){
                            arahkakikanan = 1.0f;
                        }else if(degreekakikanan > 0.6f){
                            arahkakikanan = -1.0f;
                        }

                        obj.get(0).getChildObject().get(4).rotateObject(arahkakikanan*(float)Math.toRadians(degree), 1.0f, 0.0f, 0.0f);
                        degreekakikanan+=arahkakikanan*degree;

                        obj.get(0).getChildObject().get(4).translateObject(x4,x5,x6);

                        if(degreekakikanan == 0.0f){
                            break;
                        }
                    }
                }

                //rotate ke depan baru ke sudut selanjutnya
                if(derajatsebelumnya != 0){
                    obj.get(0).rotateObject((float)Math.toRadians(-derajatsebelumnya),0.0f,1.0f,0.0f);
                }
                obj.get(0).rotateObject((float)Math.toRadians(270),0.0f,1.0f,0.0f);
                derajatsebelumnya = 270f;
                keyAditekan=false;
            }
            if(window.isKeyPressed(GLFW_KEY_A) && !keyAditekan)
            {
                float x1 = obj.get(0).getChildObject().get(3).getMatrix().get(3,0);
                float x2 = obj.get(0).getChildObject().get(3).getMatrix().get(3,1);
                float x3 = obj.get(0).getChildObject().get(3).getMatrix().get(3,2);
                float x4 = obj.get(0).getChildObject().get(4).getMatrix().get(3,0);
                float x5 = obj.get(0).getChildObject().get(4).getMatrix().get(3,1);
                float x6 = obj.get(0).getChildObject().get(4).getMatrix().get(3,2);

                for(ObjectJames objek:obj.get(0).getChildObject().get(3).getChildObject()){
                    objek.translateObject(-x1,-x2,-x3);
                    obj.get(0).getChildObject().get(4).translateObject(-x4,-x5,-x6);

                    //arah pertamanya - (ke depan) (kaki kiri)
                    if(degreekakikiri < -10.5f){
                        arahkakikiri = 1.0f;
                    }else if(degreekakikiri > 10.5f){
                        arahkakikiri = -1.0f;
                    }
                    //arah pertamanya + (ke belakang) (kaki kanan)
                    if(degreekakikanan < -10.5f){
                        arahkakikanan = 1.0f;
                    }else if(degreekakikanan > 10.5f){
                        arahkakikanan = -1.0f;
                    }

                    obj.get(0).getChildObject().get(4).rotateObject(arahkakikanan*(float)Math.toRadians(degree), 0.0f, 0.0f, 1.0f);
                    objek.rotateObject(arahkakikiri*(float)Math.toRadians(degree), 0.0f, 0.0f, 1.0f);
                    degreekakikiri+=arahkakikiri*degree;
                    degreekakikanan+=arahkakikanan*degree;

                    objek.translateObject(x1,x2,x3);
                    obj.get(0).getChildObject().get(4).translateObject(x4,x5,x6);
                }
                keyWditekan = true;
                keySditekan = true;
                keyDditekan = true;
            }
        }
        if(window.isKeyPressed(GLFW_KEY_S)){
            if(keySditekan){
                //perbaiki posisi kaki
                float x1 = obj.get(0).getChildObject().get(3).getMatrix().get(3,0);
                float x2 = obj.get(0).getChildObject().get(3).getMatrix().get(3,1);
                float x3 = obj.get(0).getChildObject().get(3).getMatrix().get(3,2);
                float x4 = obj.get(0).getChildObject().get(4).getMatrix().get(3,0);
                float x5 = obj.get(0).getChildObject().get(4).getMatrix().get(3,1);
                float x6 = obj.get(0).getChildObject().get(4).getMatrix().get(3,2);
                if(degreekakikiri != 0f){
                    while(degreekakikiri < -0.6f || degreekakikiri > 0.6f ){
                        obj.get(0).getChildObject().get(3).translateObject(-x1,-x2,-x3);
                        if(degreekakikiri < -0.6f){
                            arahkakikiri = 1.0f;
                        }else if(degreekakikiri > 0.6f){
                            arahkakikiri = -1.0f;
                        }
                        obj.get(0).getChildObject().get(3).rotateObject(arahkakikiri*(float)Math.toRadians(degree), 1.0f, 0.0f, 0.0f);
                        degreekakikiri+=arahkakikiri*degree;

                        obj.get(0).getChildObject().get(3).translateObject(x1,x2,x3);

                        if(degreekakikiri == 0.0f){
                            break;
                        }
                    }
                }
                if(degreekakikanan != 0f){
                    while(degreekakikanan > 0.6f || degreekakikanan < -0.6f ){
                        obj.get(0).getChildObject().get(4).translateObject(-x4,-x5,-x6);
                        if(degreekakikanan < -0.6f){
                            arahkakikanan = 1.0f;
                        }else if(degreekakikanan > 0.6f){
                            arahkakikanan = -1.0f;
                        }

                        obj.get(0).getChildObject().get(4).rotateObject(arahkakikanan*(float)Math.toRadians(degree), 1.0f, 0.0f, 0.0f);
                        degreekakikanan+=arahkakikanan*degree;

                        obj.get(0).getChildObject().get(4).translateObject(x4,x5,x6);

                        if(degreekakikanan == 0.0f){
                            break;
                        }
                    }
                }



                if(derajatsebelumnya != 0){
                    obj.get(0).rotateObject((float)Math.toRadians(-derajatsebelumnya),0.0f,1.0f,0.0f);
                }
//                obj.get(0).rotateObject((float)Math.toRadians(0),0.0f,1.0f,0.0f);
                derajatsebelumnya = 0f;
                keySditekan=false;
            }
            if(window.isKeyPressed(GLFW_KEY_S) && !keySditekan)
            {
                float x1 = obj.get(0).getChildObject().get(3).getMatrix().get(3,0);
                float x2 = obj.get(0).getChildObject().get(3).getMatrix().get(3,1);
                float x3 = obj.get(0).getChildObject().get(3).getMatrix().get(3,2);
                float x4 = obj.get(0).getChildObject().get(4).getMatrix().get(3,0);
                float x5 = obj.get(0).getChildObject().get(4).getMatrix().get(3,1);
                float x6 = obj.get(0).getChildObject().get(4).getMatrix().get(3,2);

                for(ObjectJames objek:obj.get(0).getChildObject().get(3).getChildObject()){
                    objek.translateObject(-x1,-x2,-x3);
                    obj.get(0).getChildObject().get(4).translateObject(-x4,-x5,-x6);

                    //arah pertamanya - (ke depan) (kaki kiri)
                    if(degreekakikiri < -10.5f){
                        arahkakikiri = 1.0f;
                    }
                    else if(degreekakikiri > 10.5f){
                        arahkakikiri = -1.0f;
                    }
                    //arah pertamanya + (ke belakang) (kaki kanan)
                    if(degreekakikanan < -10.5f){
                        arahkakikanan = 1.0f;
                    }
                    else if(degreekakikanan > 10.5f){
                        arahkakikanan = -1.0f;
                    }

                    obj.get(0).getChildObject().get(4).rotateObject(arahkakikanan*(float)Math.toRadians(degree), 1.0f, 0.0f, 0.0f);
                    objek.rotateObject(arahkakikiri*(float)Math.toRadians(degree), 1.0f, 0.0f, 0.0f);
                    degreekakikiri+=arahkakikiri*degree;
                    degreekakikanan+=arahkakikanan*degree;

                    objek.translateObject(x1,x2,x3);
                    obj.get(0).getChildObject().get(4).translateObject(x4,x5,x6);
                }
                keyWditekan = true;
                keyAditekan = true;
                keyDditekan = true;
            }
        }
        if(window.isKeyPressed(GLFW_KEY_D)){
            if(keyDditekan){
                //perbaiki posisi kaki
                float x1 = obj.get(0).getChildObject().get(3).getMatrix().get(3,0);
                float x2 = obj.get(0).getChildObject().get(3).getMatrix().get(3,1);
                float x3 = obj.get(0).getChildObject().get(3).getMatrix().get(3,2);
                float x4 = obj.get(0).getChildObject().get(4).getMatrix().get(3,0);
                float x5 = obj.get(0).getChildObject().get(4).getMatrix().get(3,1);
                float x6 = obj.get(0).getChildObject().get(4).getMatrix().get(3,2);
                if(degreekakikiri != 0f){
                    while(degreekakikiri < -0.6f || degreekakikiri > 0.6f ){
                        obj.get(0).getChildObject().get(3).translateObject(-x1,-x2,-x3);
                        if(degreekakikiri < -0.6f){
                            arahkakikiri = 1.0f;
                        }else if(degreekakikiri > 0.6f){
                            arahkakikiri = -1.0f;
                        }
                        obj.get(0).getChildObject().get(3).rotateObject(arahkakikiri*(float)Math.toRadians(degree), 1.0f, 0.0f, 0.0f);
                        degreekakikiri+=arahkakikiri*degree;

                        obj.get(0).getChildObject().get(3).translateObject(x1,x2,x3);

                        if(degreekakikiri == 0.0f){
                            break;
                        }
                    }
                }
                if(degreekakikanan != 0f){
                    while(degreekakikanan > 0.6f || degreekakikanan < -0.6f ){
                        obj.get(0).getChildObject().get(4).translateObject(-x4,-x5,-x6);
                        if(degreekakikanan < -0.6f){
                            arahkakikanan = 1.0f;
                        }else if(degreekakikanan> 0.6f){
                            arahkakikanan = -1.0f;
                        }

                        obj.get(0).getChildObject().get(4).rotateObject(arahkakikanan*(float)Math.toRadians(degree), 1.0f, 0.0f, 0.0f);
                        degreekakikanan+=arahkakikanan*degree;

                        obj.get(0).getChildObject().get(4).translateObject(x4,x5,x6);

                        if(degreekakikanan == 0.0f){
                            break;
                        }
                    }
                }



                if(derajatsebelumnya != 0){
                    obj.get(0).rotateObject((float)Math.toRadians(-derajatsebelumnya),0.0f,1.0f,0.0f);
                }
                obj.get(0).rotateObject((float)Math.toRadians(90),0.0f,1.0f,0.0f);
                derajatsebelumnya = 90f;
                keyDditekan=false;
            }
            if(window.isKeyPressed(GLFW_KEY_D) && !keyDditekan)
            {
                float x1 = obj.get(0).getChildObject().get(3).getMatrix().get(3,0);
                float x2 = obj.get(0).getChildObject().get(3).getMatrix().get(3,1);
                float x3 = obj.get(0).getChildObject().get(3).getMatrix().get(3,2);
                float x4 = obj.get(0).getChildObject().get(4).getMatrix().get(3,0);
                float x5 = obj.get(0).getChildObject().get(4).getMatrix().get(3,1);
                float x6 = obj.get(0).getChildObject().get(4).getMatrix().get(3,2);

                for(ObjectJames objek:obj.get(0).getChildObject().get(3).getChildObject()){
                    objek.translateObject(-x1,-x2,-x3);
                    obj.get(0).getChildObject().get(4).translateObject(-x4,-x5,-x6);

                    //arah pertamanya - (ke depan) (kaki kiri)
                    if(degreekakikiri < -10.5f){
                        arahkakikiri = 1.0f;
                    }else if(degreekakikiri > 10.5f){
                        arahkakikiri = -1.0f;
                    }
                    //arah pertamanya + (ke belakang) (kaki kanan)
                    if(degreekakikanan < -10.5f){
                        arahkakikanan = 1.0f;
                    }else if(degreekakikanan > 10.5f){
                        arahkakikanan = -1.0f;
                    }

                    obj.get(0).getChildObject().get(4).rotateObject(arahkakikanan*(float)Math.toRadians(degree), 0.0f, 0.0f, 1.0f);
                    objek.rotateObject(arahkakikiri*(float)Math.toRadians(degree), 0.0f, 0.0f, 1.0f);
                    degreekakikiri+=arahkakikiri*degree;
                    degreekakikanan+=arahkakikanan*degree;

                    objek.translateObject(x1,x2,x3);
                    obj.get(0).getChildObject().get(4).translateObject(x4,x5,x6);
                }
                keyAditekan = true;
                keyWditekan = true;
                keySditekan = true;
            }
        }

        if(window.isKeyPressed(GLFW_KEY_I)){
            camera.setPosition(degreexcamera,degreeycamera,degreezcamera);
            degreeycamera-=0.005f;
        }
        if(window.isKeyPressed(GLFW_KEY_J)){
            camera.setPosition(degreexcamera,degreeycamera,degreezcamera);
            degreexcamera+=0.005f;
        }
        if(window.isKeyPressed(GLFW_KEY_K)){
            camera.setPosition(degreexcamera,degreeycamera,degreezcamera);
            degreeycamera+=0.005f;
        }
        if(window.isKeyPressed(GLFW_KEY_L)){
            camera.setPosition(degreexcamera,degreeycamera,degreezcamera);
            degreexcamera-=0.005f;
        }
        if(window.isKeyPressed(GLFW_KEY_U)){
            camera.setPosition(degreexcamera,degreeycamera,degreezcamera);
            degreezcamera+=0.005f;
        }
        if(window.isKeyPressed(GLFW_KEY_O)){
            camera.setPosition(degreexcamera,degreeycamera,degreezcamera);
            degreezcamera-=0.005f;
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
            for(ObjectJames objectJames : obj){
                objectJames.draw(camera,projection);
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
        new Projek().run();
    }

    public Vector2f getPosition(Window window)
    {
        Vector2f pos = window.getMouseInput().getCurrentPos();

        pos.x = (pos.x - (window.getWidth())/2f) / (window.getWidth() / 2f);
        pos.y = (pos.y - (window.getHeight())/2f) / (window.getHeight() / 2f);
        return pos;
    }
}