import Engine.ObjectJames;
import Engine.*;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
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
    float degreezcamera = 0f;

    float tempdegreexcamera = 0f;
    float tempdegreeycamera = 0f;
    float tempdegreezcamera = 0f;
    float degreekakikiri =0f;
    float degreekakikanan = 0f;
    float degreetanganbawah = 0f;
    float degreetanganatas = 0f;
    float degreekepala = 0f;
    float degree =0.5f;
    float degree2 = 0.005f;
    float degree3 =0.05f;
    float arahkakikiri = -1.0f;
    float arahkakikanan = 1.0f;
    boolean keyEditekan = true;
    boolean keyQditekan = true;
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
        obj.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.035f,0.035f,0.03f);
        obj.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(-0.275f,0.0f,-0.35f);
        obj.get(0).getChildObject().get(1).getChildObject().get(0).rotateObject((float)Math.toRadians(270f),1.0f,0.0f,0.0f);

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
        //paraboloid tangan kanan
        obj.get(0).getChildObject().get(2).getChildObject().add(
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
                        4
                )
        );
        obj.get(0).getChildObject().get(2).getChildObject().get(0).scaleObject(0.035f,0.035f,0.03f);
        obj.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(0.275f,0.0f,-0.35f);
        obj.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(270f),1.0f,0.0f,0.0f);

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
//                                                new Vector4f(1f,0f,0f,1.0f),
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

        //alis mata
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new ObjectJames(
                Arrays.asList(
                        //Nama file disini bisa di custom (yang bagian secene.vart atau scene.frag)
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                new ArrayList<>()
                ,new Vector4f(0.0f, 0.0f, 0.0f, 1.0f)
        ));
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).addVertices(new Vector3f(-0.05f, 1.03f, 0.4f));
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).addVertices(new Vector3f(0.0f, 1.045f, 0.4f));
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).addVertices(new Vector3f(0.05f, 1.03f, 0.4f));
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).updateCurve(obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getVertices());
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).setThickness(1);

        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new ObjectJames(
                Arrays.asList(
                        //Nama file disini bisa di custom (yang bagian secene.vart atau scene.frag)
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                new ArrayList<>()
                ,new Vector4f(0.0f, 0.0f, 0.0f, 1.0f)
        ));
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).addVertices(new Vector3f(-0.1f, 1.04f, 0.4f));
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).addVertices(new Vector3f(0.0f, 1.07f, 0.4f));
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).addVertices(new Vector3f(0.1f, 1.04f, 0.4f));
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).updateCurve(obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).getVertices());
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).setThickness(1);

        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new ObjectJames(
                Arrays.asList(
                        //Nama file disini bisa di custom (yang bagian secene.vart atau scene.frag)
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                new ArrayList<>()
                ,new Vector4f(0.0f, 0.0f, 0.0f, 1.0f)
        ));
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(-0.075f, 1.07f, 0.4f));
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(0.0f, 1.09f, 0.4f));
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(0.075f, 1.07f, 0.4f));
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).updateCurve(obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).getVertices());
        obj.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).setThickness(1);

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

        //aksi 2 - praise the sun
        if(window.isKeyPressed(GLFW_KEY_E)){
            if(keyEditekan){
                keyEditekan = false;
            }if(window.isKeyPressed(GLFW_KEY_E) &&!keyEditekan){
                if(derajatsebelumnya != 0){
                    obj.get(0).rotateObject((float)Math.toRadians(-derajatsebelumnya),0.0f,1.0f,0.0f);
                }

                //gerakkan kepala ke bawah
                float x1 = obj.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,0);
                float x2 = obj.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,1);
                float x3 = obj.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,2);
                obj.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-x1, -x2, -x3);
                if(degreekepala > -0f){
                    obj.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(degreekepala),1.0f,0.0f,0.0f);
                    degreekepala -= degree2;
                }
                obj.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(x1, x2, x3);

                //gerakkan tangan ke bawah
                x1 = obj.get(0).getChildObject().get(1).getMatrix().get(3,0);
                x2 = obj.get(0).getChildObject().get(1).getMatrix().get(3,1);
                x3 = obj.get(0).getChildObject().get(1).getMatrix().get(3,2);
                float x4 = obj.get(0).getChildObject().get(2).getMatrix().get(3,0);
                float x5 = obj.get(0).getChildObject().get(2).getMatrix().get(3,1);
                float x6 = obj.get(0).getChildObject().get(2).getMatrix().get(3,2);
                obj.get(0).getChildObject().get(1).translateObject(-x1, -x2, -x3);
                obj.get(0).getChildObject().get(2).translateObject(-x4, -x5, -x6);
                if (degreetanganbawah > 0.0f) {
                    obj.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(degreetanganbawah), 1.0f, 0.0f, 0.0f);
                    obj.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(degreetanganbawah), 1.0f, 0.0f, 0.0f);
                    degreetanganbawah -= degree2;
                }
//                if (degreetanganatas > 0.0f) {
//                    obj.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(degreetanganatas), 0.0f, 0.0f, 1.0f);
//                    obj.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(degreetanganatas), 0.0f, 0.0f, 1.0f);
//                    degreetanganatas -= degree2;
//                }
                obj.get(0).getChildObject().get(1).translateObject(x1, x2, x3);
                obj.get(0).getChildObject().get(2).translateObject(x4, x5, x6);
                obj.get(0).rotateObject((float)Math.toRadians(derajatsebelumnya),0.0f,1.0f,0.0f);

                if(degreetanganatas<=0 && degreetanganbawah <= 0 &&degreekepala <=0){
                    keyQditekan = true;
                }
            }
        }
//        pindahkan objek
        if(window.isKeyPressed(GLFW_KEY_Q)){
            if(keyQditekan){
                keyQditekan = false;
                keyEditekan = true;
            }
            if(window.isKeyPressed(GLFW_KEY_Q) && !keyQditekan){
                if(derajatsebelumnya != 0){
                    obj.get(0).rotateObject((float)Math.toRadians(-derajatsebelumnya),0.0f,1.0f,0.0f);
                }

                //gerakkan kepala ke atas
                float x1 = obj.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,0);
                float x2 = obj.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,1);
                float x3 = obj.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,2);
                obj.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-x1, -x2, -x3);
                float derajatkepala = 0.55f;
                if(degreekepala < derajatkepala){
                    obj.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(-(float)Math.toRadians(degreekepala),1.0f,0.0f,0.0f);
                    degreekepala += degree2;
                }
                obj.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(x1, x2, x3);

                //gerakkan tangan
                x1 = obj.get(0).getChildObject().get(1).getMatrix().get(3,0);
                x2 = obj.get(0).getChildObject().get(1).getMatrix().get(3,1);
                x3 = obj.get(0).getChildObject().get(1).getMatrix().get(3,2);
                float x4 = obj.get(0).getChildObject().get(2).getMatrix().get(3,0);
                float x5 = obj.get(0).getChildObject().get(2).getMatrix().get(3,1);
                float x6 = obj.get(0).getChildObject().get(2).getMatrix().get(3,2);
                float derajattgn =1.10f;
                obj.get(0).getChildObject().get(1).translateObject(-x1, -x2, -x3);
                obj.get(0).getChildObject().get(2).translateObject(-x4, -x5, -x6);
                if (degreetanganbawah < derajattgn) {
                    obj.get(0).getChildObject().get(1).rotateObject(-(float) Math.toRadians(degreetanganbawah), 1.0f, 0.0f, 0.0f);
                    obj.get(0).getChildObject().get(2).rotateObject(-(float) Math.toRadians(degreetanganbawah), 1.0f, 0.0f, 0.0f);
                    degreetanganbawah += degree2;
                }
//                if (degreetanganatas < 0.75f) {
//                    obj.get(0).getChildObject().get(1).rotateObject(-(float) Math.toRadians(degreetanganatas), 0.0f, 0.0f, 1.0f);
//                    obj.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(degreetanganatas), 0.0f, 0.0f, 1.0f);
//                    degreetanganatas += degree2;
//                }
                obj.get(0).getChildObject().get(1).translateObject(x1, x2, x3);
                obj.get(0).getChildObject().get(2).translateObject(x4, x5, x6);
                obj.get(0).rotateObject((float)Math.toRadians(derajatsebelumnya),0.0f,1.0f,0.0f);
            }
        }

        if(window.isKeyPressed(GLFW_KEY_V)){
            if(degreexcamera != 0 || degreeycamera!=0 || degreezcamera != 0){
                while(degreexcamera!=0.0f){
                    if(degreexcamera >0){
                        for(float i=0;i<degreexcamera;i+=0.05f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(-0.05f, 1f, 0f, 0f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                            System.out.println("masuk loop x positif");
                        }
                    }
                    if(degreexcamera<0){
                        for(float i=0;i<Math.abs(degreexcamera);i+=0.05f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(0.05f, 1f, 0f, 0f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                            System.out.println("masuk loop x negatif");
                        }
                    }
                    if(degreexcamera >= 0.0001f || degreexcamera <= 0.0001f){
                        degreexcamera = 0f;
                    }
                }
                tempdegreexcamera = degreexcamera;
                degreexcamera = 0;
                while(degreeycamera!=0.0f){
                    if(degreeycamera > 0){
                        for(float i=0;i<degreeycamera;i+=0.05f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(-0.05f, 0f, 1f, 0f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                            System.out.println("masuk loop y positif");
                        }
                    }
                    if(degreeycamera<0){
                        for(float i=0;i<Math.abs(degreeycamera);i+=0.05f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(0.05f, 0f, 1f, 0f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                            System.out.println("masuk loop y negatif");
                        }
                    }

                    if(degreeycamera >= 0.0001f || degreeycamera <= 0.0001f){
                        degreeycamera = 0f;
                    }
                }
                System.out.println("degree y: "+degreeycamera);
                tempdegreeycamera = degreeycamera;
                degreeycamera = 0;

                while(degreezcamera != 0.0f){
                    if(degreezcamera >0){
                        for(float i=0f;i<degreezcamera;i+=0.05f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(-0.05f, 0f, 0f, 1f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                            System.out.println("masuk loop z positif");
                        }
                    }
                    if(degreezcamera <0){
                        for(float i=0;i<Math.abs(degreezcamera);i+=0.05f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(0.05f, 0f, 0f, 1f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                            System.out.println("masuk loop z negatif");
                        }
                    }

                    if(degreezcamera >= 0.0001f || degreezcamera <= 0.0001f){
                        degreezcamera = 0f;
                    }
                }
                System.out.println("degree z: "+degreezcamera);
                tempdegreezcamera = degreezcamera;
                degreezcamera = 0;

            }
        }


        //aksi 1 - gerak kaki (depan, kiri, belakang, kanan)
        if(window.isKeyPressed(GLFW_KEY_W)){
            if(keyWditekan){
                System.out.println(degreekakikiri);
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

                //rotasi objek terhadap sumbu x
                if(degreexcamera != 0 || degreeycamera!=0 || degreezcamera != 0){
                    if(degreexcamera >0){
                        for(float i=0;i<degreexcamera;i+=0.05f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(-0.005f, 1f, 0f, 0f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                        }
                    }else if(degreexcamera<0){
                        for(float i=0;i<Math.abs(degreexcamera);i+=0.05f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(0.005f, 1f, 0f, 0f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                        }
                    }

                    if(degreeycamera > 0){
                        for(float i=0;i<degreeycamera;i+=0.05f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(-0.005f, 0f, 1f, 0f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                        }
                    }else if(degreeycamera<0){
                        for(float i=0;i<Math.abs(degreeycamera);i+=0.05f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(0.005f, 0f, 1f, 0f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                        }
                    }

                    if(degreezcamera >0){
                        for(float i=0f;i<degreezcamera;i+=0.05f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(-0.005f, 0f, 0f, 1f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                        }
                    }else if(degreezcamera <0){
                        for(float i=0;i<Math.abs(degreezcamera);i+=0.05f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(0.005f, 0f, 0f, 1f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                        }
                    }

                    tempdegreexcamera = degreexcamera;
                    tempdegreeycamera = degreeycamera;
                    tempdegreezcamera = degreezcamera;
                    degreexcamera = 0;
                    degreeycamera = 0;
                    degreezcamera = 0;

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
                System.out.println("tahan W"+degreekakikiri);
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

                if(tempdegreezcamera != 0){
                    if(tempdegreezcamera >0){
                        for(float i=0f;i<tempdegreezcamera;i+=0.5f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(0.5f, 0f, 0f, 1f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                        }
                    }else if(tempdegreezcamera <0){
                        for(float i=0;i<Math.abs(tempdegreezcamera);i+=0.5f){
                            for(ObjectJames objek:obj){
                                ((SphereJames)objek).rotateObjectOnPoint(-0.5f, 0f, 0f, 1f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                            }
                        }
                    }
                    degreezcamera = tempdegreezcamera;
                    tempdegreezcamera = 0;
                }

                keyAditekan = true;
                keySditekan = true;
                keyDditekan = true;
            }
        }
        if(window.isKeyPressed(GLFW_KEY_A)){
            if(keyAditekan){
                //perbaiki posisi kaki
                float x1 = obj.get(0).getChildObject().get(3).getMatrix().get(3,0);
                float x2 = obj.get(0).getChildObject().get(3).getMatrix().get(3,1);
                float x3 = obj.get(0).getChildObject().get(3).getMatrix().get(3,2);
                float x4 = obj.get(0).getChildObject().get(4).getMatrix().get(3,0);
                float x5 = obj.get(0).getChildObject().get(4).getMatrix().get(3,1);
                float x6 = obj.get(0).getChildObject().get(4).getMatrix().get(3,2);
                System.out.println(degreekakikiri);
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
                System.out.println("tahan A"+degreekakikiri);
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
            for(ObjectJames objek:obj){
                if(objek instanceof SphereJames){
                    ((SphereJames)objek).rotateObjectOnPoint(0.05f, 0f, 0f, 1f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                    degreezcamera+=degree3;
                }
                System.out.println("degreez"+degreezcamera);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_J)){
            for(ObjectJames objek:obj){
                if(objek instanceof SphereJames){
                    ((SphereJames)objek).rotateObjectOnPoint(-0.05f, 0f, 0f, 1f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                    degreezcamera-=degree3;
                }

                System.out.println("degreez"+degreezcamera);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_K)){
            for(ObjectJames objek:obj){
                if(objek instanceof SphereJames){
                    ((SphereJames)objek).rotateObjectOnPoint(0.05f, 1f, 0f, 0f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                    degreexcamera+=degree3;
                }

                System.out.println("degreex"+degreexcamera);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_L)){
            for(ObjectJames objek:obj){
                if(objek instanceof SphereJames){
                    ((SphereJames)objek).rotateObjectOnPoint(-0.05f, 1f, 0f, 0f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                    degreexcamera-=degree3;
                }

                System.out.println("degreex"+degreexcamera);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_U)){
            for(ObjectJames objek:obj){
                if(objek instanceof SphereJames){
                    ((SphereJames)objek).rotateObjectOnPoint(0.05f, 0f, 1f, 0f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                    degreeycamera+=degree3;
                }

                System.out.println("degreey"+degreeycamera);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_O)){
            for(ObjectJames objek:obj){
                if(objek instanceof SphereJames){
                    ((SphereJames)objek).rotateObjectOnPoint(-0.05f, 0f, 1f, 0f, obj.get(0).getMatrix().get(3,0), obj.get(0).getMatrix().get(3,1),obj.get(0).getMatrix().get(3,2));
                    degreeycamera-=degree3;
                }

                System.out.println("degreey"+degreeycamera);
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