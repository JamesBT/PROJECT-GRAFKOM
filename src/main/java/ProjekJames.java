import Engine.ObjectJames;
import Engine.*;
import org.joml.*;
import org.lwjgl.opengl.GL;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class ProjekJames {
    private final Window window = new Window(800, 800, "Projek Spongebob");

    private ArrayList<ObjectJames> objekjames = new ArrayList<>();
    private ArrayList<ObjectJames> enviroment = new ArrayList<>();

    private ArrayList<ObjectJames> objekBurger = new ArrayList<>();

    private ArrayList<ObjectJames> enviromentMrKrab = new ArrayList<>();
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(),window.getHeight());
    int state = 0;
    float currentDeg = 0.0f, countDeg = 1.5f;
    float directionBodyX = 0f, directionBodyY = -1f;
    float currentBodyDegree = 270f;
    float directionX = 1f;
    boolean isPressed = false;
    float degreekepala = 0f;
    float countDegKepala = 1.5f;
    float degreetangan =0f;
    float countDegTangan = 1.5f;
    boolean keyEditekan = true;
    boolean keyQditekan = true;
    float timerkeyQ = -30f;

    boolean aksi2 = false;
    public void init(){
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        camera.setPosition(0,1.5f,2.0f);
//        camera.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(0.0f));
        camera.setRotation((float)Math.toRadians(30.0f),(float)Math.toRadians(0.0f));

        //lantai
        enviromentMrKrab.add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.3921568627f,0.6823529412f,0.38823529411f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 0));
        enviromentMrKrab.get(0).scaleObject(12f,24.0f,0.5f);
        enviromentMrKrab.get(0).translateObject(0.0f,0.0f,1.25f);
        enviromentMrKrab.get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);

        //dinding belakang
        enviromentMrKrab.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(),new Vector4f(0.6196078431f,0.7019607843f,0.7215686275f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 0));
        enviromentMrKrab.get(0).getChildObject().get(0).scaleObject(12f,12.0f,0.5f);
        enviromentMrKrab.get(0).getChildObject().get(0).translateObject(0.0f,0.0f,-1.3f);

        //dinding kiri
        enviromentMrKrab.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.7529411765f,0.6196078431f,0.4745098039f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 0));
        enviromentMrKrab.get(0).getChildObject().get(1).scaleObject(24.0f,10f,0.25f);
        enviromentMrKrab.get(0).getChildObject().get(1).translateObject(0.0f,0.0f,2.75f);
        enviromentMrKrab.get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(270),0f,1f,0f);

        //dinding kanan
        enviromentMrKrab.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.7529411765f,0.6196078431f,0.4745098039f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 0));
        enviromentMrKrab.get(0).getChildObject().get(2).scaleObject(24.0f,10f,0.25f);
        enviromentMrKrab.get(0).getChildObject().get(2).translateObject(0.0f,0.0f,2.75f);
        enviromentMrKrab.get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(90),0f,1f,0f);

        //atap
        enviromentMrKrab.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.4509803922f,0.2352941176f,0.2470588235f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 0));
        enviromentMrKrab.get(0).getChildObject().get(3).scaleObject(11.0f,24.0f,0.5f);
        enviromentMrKrab.get(0).getChildObject().get(3).translateObject(0.0f,0.0f,-1.75f);
        enviromentMrKrab.get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(90),1f,0f,0f);

        //meja
        enviromentMrKrab.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.4509803922f,0.2352941176f,0.2470588235f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 0));
        enviromentMrKrab.get(0).getChildObject().get(4).scaleObject(4f,2.0f,6.5f);
        enviromentMrKrab.get(0).getChildObject().get(4).translateObject(0.0f,0.0f,1.75f);
        enviromentMrKrab.get(0).getChildObject().get(4).rotateObject((float)Math.toRadians(90),1f,0f,0f);

        //kursi
        enviromentMrKrab.get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(1.0f,0.0f,0.0f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        0
                )
        );
        enviromentMrKrab.get(0).getChildObject().get(5).scaleObject(2f,0.5f,9.5f);
        enviromentMrKrab.get(0).getChildObject().get(5).translateObject(0.0f,-1.0f,1.75f);
        enviromentMrKrab.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(90),1f,0f,0f);

        //brangkas bagian besar
        enviromentMrKrab.get(0).getChildObject().add(
            new SphereJames(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.6f,0.5529411765f,0.7725490196f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18,
                1
            )
        );
        enviromentMrKrab.get(0).getChildObject().get(6).scaleObject(1.0f,1.0f,0.5f);
        enviromentMrKrab.get(0).getChildObject().get(6).translateObject(1.75f,0.5f,-1.075f);

        //brankas bagian kecil
        enviromentMrKrab.get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.4078431373f,0.3725490196f,0.4784313725f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        1
                )
        );
        enviromentMrKrab.get(0).getChildObject().get(7).scaleObject(0.75f,0.75f,0.5f);
        enviromentMrKrab.get(0).getChildObject().get(7).translateObject(1.75f,0.5f,-0.975f);

        //lemari
        enviromentMrKrab.get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.2549019608f,0.1215686275f,0.1490196078f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        0
                )
        );
        enviromentMrKrab.get(0).getChildObject().get(8).scaleObject(3.0f,4f,0.25f);
        enviromentMrKrab.get(0).getChildObject().get(8).translateObject(2.1f,0.0f,2.65f);
        enviromentMrKrab.get(0).getChildObject().get(8).rotateObject((float)Math.toRadians(270),0f,1f,0f);
        //pintu
        enviromentMrKrab.get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.5294117647f,0.5921568627f,0.7450980392f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        0
                )
        );
        enviromentMrKrab.get(0).getChildObject().get(9).scaleObject(2.5f,3f,0.25f);
        enviromentMrKrab.get(0).getChildObject().get(9).translateObject(-1.0f,-0.25f,2.65f);
        enviromentMrKrab.get(0).getChildObject().get(9).rotateObject((float)Math.toRadians(90),0f,1f,0f);
        enviromentMrKrab.get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.5294117647f,0.5921568627f,0.7450980392f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        1
                )
        );
        enviromentMrKrab.get(0).getChildObject().get(10).scaleObject(1.25f,1.25f,0.25f);
        enviromentMrKrab.get(0).getChildObject().get(10).translateObject(-1.0f,0.5f,2.65f);
        enviromentMrKrab.get(0).getChildObject().get(10).rotateObject((float)Math.toRadians(90),0f,1f,0f);
        //jendela di pintu
        enviromentMrKrab.get(0).getChildObject().add(
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
                        1
                )
        );
        enviromentMrKrab.get(0).getChildObject().get(11).scaleObject(0.95f,0.95f,0.25f);
        enviromentMrKrab.get(0).getChildObject().get(11).translateObject(-1.0f,0.5f,2.6f);
        enviromentMrKrab.get(0).getChildObject().get(11).rotateObject((float)Math.toRadians(90),0f,1f,0f);
        //jendela kecil di pintu
        enviromentMrKrab.get(0).getChildObject().add(
                new SphereJames(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.9490196078f,0.9333333333f,0.4117647059f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.5f,
                        0.5f,
                        0.5f,
                        36,
                        18,
                        1
                )
        );
        enviromentMrKrab.get(0).getChildObject().get(12).scaleObject(0.65f,0.65f,0.25f);
        enviromentMrKrab.get(0).getChildObject().get(12).translateObject(-1.0f,0.5f,2.5f);
        enviromentMrKrab.get(0).getChildObject().get(12).rotateObject((float)Math.toRadians(90),0f,1f,0f);


        //burger
        //roti bawah
        objekBurger.add(new SphereJames(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.7098039216f,0.368627451f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18,
                1
        ));
        objekBurger.get(0).scaleObject(0.5f,0.5f,0.2f);
        objekBurger.get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //daging
        objekBurger.get(0).getChildObject().add(new SphereJames(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
//                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                new Vector4f(0.5333333333f,0.2274509804f,0.06666666667f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18,
                1
        ));
        objekBurger.get(0).getChildObject().get(0).scaleObject(0.45f,0.45f,0.125f);
        objekBurger.get(0).getChildObject().get(0).translateObject(0.0f,0.0f,-0.075f);
        objekBurger.get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //selada
        objekBurger.get(0).getChildObject().add(new SphereJames(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
//                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                new Vector4f(0.6862745098f,0.9098039216f,0.4235294118f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18,
                1
        ));
        objekBurger.get(0).getChildObject().get(1).scaleObject(0.55f,0.55f,0.05f);
        objekBurger.get(0).getChildObject().get(1).translateObject(0.0f,0.0f,-0.1f);
        objekBurger.get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //tomat
        objekBurger.get(0).getChildObject().add(new SphereJames(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.0f,0.0f,0.0f),
//                new Vector4f(0.3921568627f,0.6823529412f,0.38823529411f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18,
                1
        ));
        objekBurger.get(0).getChildObject().get(2).scaleObject(0.4f,0.4f,0.05f);
        objekBurger.get(0).getChildObject().get(2).translateObject(0.0f,0.0f,-0.12f);
        objekBurger.get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //roti atas
        objekBurger.get(0).getChildObject().add(new SphereJames(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
//                new Vector4f(1.0f,1.0f,1.0f,0.0f),
                new Vector4f(1.0f,0.7098039216f,0.368627451f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18,
                1
        ));
        objekBurger.get(0).getChildObject().get(3).scaleObject(0.5f,0.5f,0.15f);
        objekBurger.get(0).getChildObject().get(3).translateObject(0.0f,0.0f,-0.17f);
        objekBurger.get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        objekBurger.get(0).getChildObject().add(
            new SphereJames(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
//                new Vector4f(1.0f,1.0f,1.0f,0.0f),
                new Vector4f(1.0f,0.7098039216f,0.368627451f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18,
                2
            )
        );
        objekBurger.get(0).getChildObject().get(4).scaleObject(0.5f,0.15f,0.5f);
        objekBurger.get(0).getChildObject().get(4).translateObject(0.0f,0.2f,0.0f);



        //===============================================================================================================














        //badan
        objekjames.add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.9411764706f,0.7490196078f,0.3137254902f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 1));
        objekjames.get(0).scaleObject(0.5f,0.5f,1.4f);
        objekjames.get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //leher
        objekjames.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 1));
        objekjames.get(0).getChildObject().get(0).scaleObject(0.125f,0.125f,0.75f);
        objekjames.get(0).getChildObject().get(0).translateObject(0.0f,0.0f,-0.5f);
        objekjames.get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //kepala
        //bola kepala
        objekjames.get(0).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 2));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.15f,0.15f,0.15f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f,0.0f,-0.6f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //tabung tengah (mata)
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 1));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.7f,0.7f,0.5f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f,0.0f,-0.75f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //kepala bagian atas
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 3));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(1.25f,0.9f,1.0f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.0f,0.0f,-1.0f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //mulut
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 3));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.85f,0.85f,0.35f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f,0.0f,-0.6f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        // mata kiri
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(1.0f,1.0f,1.0f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 3));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.3f,0.1f,0.3f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.85f,0.05f,0.4f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(90),0f,0f,1f);
        //titik tengah mata kiri
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.4980392157f,0.2352941176f,0.2235294118f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 0));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.05f,0.15f,0.05f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-0.055f,0.835f,0.47f);
        //mata kanan
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(1.0f,1.0f,1.0f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 3));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.3f,0.1f,0.3f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.85f,-0.05f,0.4f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(90),0f,0f,1f);
        //titik tengah mata kanan
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.4980392157f,0.2352941176f,0.2235294118f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 0));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.05f,0.15f,0.05f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.055f,0.835f,0.47f);
        //hidung
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.6862745098f,0.862745098f,0.7882352941f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.01f, 0.01f, 0.0045f, 36, 18, 4));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f,0.4f,-0.8f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //bagian bawah hidung
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.6862745098f,0.862745098f,0.7882352941f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 2));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).scaleObject(0.125f,0.125f,0.125f);
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).translateObject(0.0f,0.6f,0.4f);
        //tangan kiri
        objekjames.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 2));
        objekjames.get(0).getChildObject().get(1).scaleObject(0.25f,0.25f,0.25f);
        objekjames.get(0).getChildObject().get(1).translateObject(-0.25f,0.225f,0.0f);
        //paraboloid tangan kiri
        objekjames.get(0).getChildObject().get(1).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 4));
        objekjames.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.035f,0.035f,0.03f);
        objekjames.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(-0.275f,0.0f,-0.35f);
        objekjames.get(0).getChildObject().get(1).getChildObject().get(0).rotateObject((float)Math.toRadians(270f),1.0f,0.0f,0.0f);
        //tangan kanan
        objekjames.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 2));
        objekjames.get(0).getChildObject().get(2).scaleObject(0.25f,0.25f,0.25f);
        objekjames.get(0).getChildObject().get(2).translateObject(0.25f,0.225f,0.0f);
        //paraboloid tangan kanan
        objekjames.get(0).getChildObject().get(2).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 4));
        objekjames.get(0).getChildObject().get(2).getChildObject().get(0).scaleObject(0.035f,0.035f,0.03f);
        objekjames.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(0.275f,0.0f,-0.35f);
        objekjames.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(270f),1.0f,0.0f,0.0f);
        //perut bagian kiri bawah
        objekjames.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 3));
        objekjames.get(0).getChildObject().get(3).scaleObject(0.25f,0.25f,1.f);
        objekjames.get(0).getChildObject().get(3).translateObject(-0.05f,-.4f,0.0f);
        //perut bagian kanan bawah
        objekjames.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 3));
        objekjames.get(0).getChildObject().get(4).scaleObject(0.25f,0.25f,1.f);
        objekjames.get(0).getChildObject().get(4).translateObject(0.05f,-.4f,0.0f);
        //kaki kiri depan
        //tabung atas kaki kiri depan
        objekjames.get(0).getChildObject().get(3).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 1));
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).scaleObject(0.15f,0.15f,1.3f);
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-0.075f,0.075f,0.8f);
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //telapak kaki kiri depan
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 4));
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(0).scaleObject(0.0175f,0.0175f,0.0275f);
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f,-1.1f,-0.6f);
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(135),0.0f,1f,0f);
        //kaki kiri belakang
        //tabung kaki kiri belakang
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 1));
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(1).scaleObject(0.15f,0.15f,1.3f);
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(1).translateObject(-0.075f,-0.075f,0.8f);
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //telapak kaki kiri belakang
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 4));
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(2).scaleObject(0.0175f,0.0175f,0.0275f);
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f,-1.1f,-0.6f);
        objekjames.get(0).getChildObject().get(3).getChildObject().get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(45),0.0f,1f,0f);
        //kaki kanan depan
        objekjames.get(0).getChildObject().get(4).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 1));
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).scaleObject(0.15f,0.15f,1.3f);
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(0.075f,0.075f,0.75f);
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //bagian kaki kanan depan
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 4));
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(0).scaleObject(0.0175f,0.0175f,0.0275f);
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f,-1.1f,-0.6f);
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(225),0.0f,1f,0f);
        //kaki kanan belakang
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 1));
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(1).scaleObject(0.15f,0.15f,1.3f);
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(1).translateObject(0.075f,-0.075f,0.75f);
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //bagian kaki kanan depan
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.768627451f,0.862745098f,0.831372549f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 4));
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(2).scaleObject(0.0175f,0.0175f,0.0275f);
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f,-1.1f,-0.6f);
        objekjames.get(0).getChildObject().get(4).getChildObject().get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(315),0.0f,1f,0f);
        //alis mata bawah
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new ObjectJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(),new Vector4f(0.0f, 0.0f, 0.0f, 1.0f)));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).addVertices(new Vector3f(-0.05f, 1.03f, 0.4f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).addVertices(new Vector3f(0.0f, 1.045f, 0.4f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).addVertices(new Vector3f(0.05f, 1.03f, 0.4f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).updateCurve(objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getVertices());
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).setThickness(3);
        //alis tengah
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new ObjectJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(),new Vector4f(0.0f, 0.0f, 0.0f, 1.0f)));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).addVertices(new Vector3f(-0.1f, 1.04f, 0.4f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).addVertices(new Vector3f(0.0f, 1.07f, 0.4f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).addVertices(new Vector3f(0.1f, 1.04f, 0.4f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).updateCurve(objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).getVertices());
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).setThickness(3);
        //alis atas
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new ObjectJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(),new Vector4f(0.0f, 0.0f, 0.0f, 1.0f)));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(-0.075f, 1.07f, 0.4f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(0.0f, 1.09f, 0.4f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(0.075f, 1.07f, 0.4f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).updateCurve(objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).getVertices());
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).setThickness(3);
        //mulut
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new ObjectJames(
                Arrays.asList(
                        //Nama file disini bisa di custom (yang bagian secene.vart atau scene.frag)
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                new ArrayList<>()
                ,new Vector4f(0.0f, 0.0f, 0.0f, 1.0f)
        ));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).addVertices(new Vector3f(-0.3f, 0.55f, 0.275f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).addVertices(new Vector3f(0.0f, 0.45f, 0.275f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).addVertices(new Vector3f(0.3f, 0.55f, 0.275f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).updateCurve(objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).getVertices());
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).setThickness(3);


    }

    public void input(){
//        camera.setPosition(0,1.5f,2.0f);
//        camera.setPosition(objekjames.get(0).getMatrix().get(3,0),objekjames.get(0).getMatrix().get(3,1)+1.5f,objekjames.get(0).getMatrix().get(3,2)+2.0f);
        if(window.isKeyPressed(GLFW_KEY_F)){
            for(ObjectJames objek:objekjames){
                float x1 = objek.getMatrix().get(3,0);
                float x2 = objek.getMatrix().get(3,1);
                float x3 = objek.getMatrix().get(3,2);
                objek.translateObject(-x1,-x2,-x3);
                objek.rotateObject(0.5f,1.0f,0.0f,0.0f);
                objek.translateObject(x1,x2,x3);
            }
        }


        //aksi 1 - praise the sun
        if(!window.isKeyPressed(GLFW_KEY_Q)){
            isPressed = false;
        }
        if(window.isKeyPressed(GLFW_KEY_Q)){
            if(!isPressed){
                isPressed = true;
                if(keyQditekan){
                    keyQditekan = false;
                    keyEditekan = true;
                    aksi2 = false;
                    timerkeyQ = -30f;
                }else{
//                    System.out.println("awal:");
                    objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getDerajat();
                    if(currentBodyDegree != 0){
                        objekjames.get(0).rotateObject((float)Math.toRadians(-currentBodyDegree),0.0f,1.0f,0.0f);
                    }

                    if(degreekepala >= 36f){
                        countDegKepala = 0f;
                        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getDerajat();
                    }
//                    objekjames.get(0).updateCenterPoint();
                    //gerakkan kepala ke atas
                    float x1 = objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,0);
                    float x2 = objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,1);
                    float x3 = objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,2);
                    objekjames.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-x1, -x2, -x3);
                    //- buat ke atas dulu
                    if(currentBodyDegree == 0.0f || currentBodyDegree == 360.0f){
                        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepala),0.0f,0.0f,1.0f);
                    }if(currentBodyDegree == 90.0f){
                        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepala),0.0f,0.0f,1.0f);
                    }else if(currentBodyDegree == 180.0f){
                        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepala),0.0f,0.0f,1.0f);
                    }else if(currentBodyDegree == 270.0f){
                        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepala),0.0f,0.0f,1.0f);
                    }
                    objekjames.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(x1, x2, x3);
                    degreekepala += countDegKepala;

                    //gerakan tangan
                    if(degreetangan >= 135f){
                        countDegTangan = 0f;
                    }
                    objekjames.get(0).getChildObject().get(1).updateCenterPoint();
                    objekjames.get(0).getChildObject().get(2).updateCenterPoint();
                    x1 = objekjames.get(0).getChildObject().get(1).getMatrix().get(3,0);
                    x2 = objekjames.get(0).getChildObject().get(1).getMatrix().get(3,1);
                    x3 = objekjames.get(0).getChildObject().get(1).getMatrix().get(3,2);
                    float x4 = objekjames.get(0).getChildObject().get(2).getMatrix().get(3,0);
                    float x5 = objekjames.get(0).getChildObject().get(2).getMatrix().get(3,1);
                    float x6 = objekjames.get(0).getChildObject().get(2).getMatrix().get(3,2);
                    objekjames.get(0).getChildObject().get(1).translateObject(-x1, -x2, -x3);
                    objekjames.get(0).getChildObject().get(2).translateObject(-x4, -x5, -x6);
                    if(currentBodyDegree == 0.0f || currentBodyDegree == 360.0f){
                        objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
                        objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
                    }if(currentBodyDegree == 90.0f){
                        objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
                        objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
                    }else if(currentBodyDegree == 180.0f){
                        objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
                        objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
                    }else if(currentBodyDegree == 270.0f){
                        objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
                        objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
                    }
                    objekjames.get(0).getChildObject().get(1).translateObject(x1, x2, x3);
                    objekjames.get(0).getChildObject().get(2).translateObject(x4, x5, x6);
                    degreetangan += countDegTangan;

                    if(currentBodyDegree != 0){
                        objekjames.get(0).rotateObject((float)Math.toRadians(currentBodyDegree),0.0f,1.0f,0.0f);
                    }
                }
                isPressed = false;
            }
        }
        timerkeyQ+=0.1f;
        if(timerkeyQ > 0.1f){
            timerkeyQ = -30f;
        }
        if(!keyQditekan && timerkeyQ > 0){
            aksi2=true;
        }
        //turunin tangan
        if(aksi2){
            keyEditekan = false;
            keyQditekan = true;

            if(currentBodyDegree != 0){
                objekjames.get(0).rotateObject((float)Math.toRadians(-currentBodyDegree),0.0f,1.0f,0.0f);
            }

            objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getDerajat();

            if(degreekepala <= 0f){
                countDegKepala = 0f;
            }else if(degreekepala <= 36f){
                countDegKepala = -1.5f;
            }
//            System.out.println("degreekepala: "+degreekepala+"   count deg kepala:"+countDegKepala);
            //gerakkan kepala ke bawah
            float x1 = objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,0);
            float x2 = objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,1);
            float x3 = objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,2);
            objekjames.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-x1, -x2, -x3);
//            System.out.println(currentBodyDegree);
            if(currentBodyDegree == 0.0f || currentBodyDegree == 360.0f){
                objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepala),0.0f,0.0f,1.0f);
            }if(currentBodyDegree == 90.0f){
                objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepala),0.0f,0.0f,1.0f);
            }else if(currentBodyDegree == 180.0f){
                objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepala),0.0f,0.0f,1.0f);
            }else if(currentBodyDegree == 270.0f){
                objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepala),0.0f,0.0f,1.0f);
            }
            objekjames.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(x1, x2, x3);
            degreekepala += countDegKepala;

            //gerakan tangan
            if(degreetangan <= 0f){
                countDegTangan = 0f;
            }else if(degreetangan <= 135f){
                countDegTangan = -1.5f;
            }
            objekjames.get(0).getChildObject().get(1).updateCenterPoint();
            objekjames.get(0).getChildObject().get(2).updateCenterPoint();
            x1 = objekjames.get(0).getChildObject().get(1).getMatrix().get(3,0);
            x2 = objekjames.get(0).getChildObject().get(1).getMatrix().get(3,1);
            x3 = objekjames.get(0).getChildObject().get(1).getMatrix().get(3,2);
            float x4 = objekjames.get(0).getChildObject().get(2).getMatrix().get(3,0);
            float x5 = objekjames.get(0).getChildObject().get(2).getMatrix().get(3,1);
            float x6 = objekjames.get(0).getChildObject().get(2).getMatrix().get(3,2);
            objekjames.get(0).getChildObject().get(1).translateObject(-x1, -x2, -x3);
            objekjames.get(0).getChildObject().get(2).translateObject(-x4, -x5, -x6);
            if(currentBodyDegree == 0.0f || currentBodyDegree == 360.0f){
                objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
                objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
            }if(currentBodyDegree == 90.0f){
                objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
                objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
            }else if(currentBodyDegree == 180.0f){
                objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
                objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
            }else if(currentBodyDegree == 270.0f){
                objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
                objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTangan), 0.0f, 0.0f, 1.0f);
            }
            objekjames.get(0).getChildObject().get(1).translateObject(x1, x2, x3);
            objekjames.get(0).getChildObject().get(2).translateObject(x4, x5, x6);
            degreetangan += countDegTangan;

            if(currentBodyDegree != 0){
                objekjames.get(0).rotateObject((float)Math.toRadians(currentBodyDegree),0.0f,1.0f,0.0f);
            }
            if(degreetangan<=0f && degreekepala <= 0){
                keyQditekan = true;
                keyEditekan = true;
                aksi2 = false;
                countDegKepala = 1.5f;
                degreekepala = 0f;
                countDegTangan = 1.5f;
                degreetangan = 0f;
            }
        }

        //aksi 1 - gerak kaki ke depan
        if(!window.isKeyPressed(GLFW_KEY_S)){
            isPressed = false;
        }
        if(window.isKeyPressed(GLFW_KEY_S)){
            if(!isPressed){
                isPressed = true;

                if (currentDeg >= 36f){
                    countDeg = -1.5f;
                    directionX = -1f;
                } else if (currentDeg <= -36f){
                    countDeg =  1.5f;
                    directionX = 1f;
                }
                objekjames.get(0).updateCenterPoint();
//                System.out.println("Current degree : " + currentDeg + " | direction : " + directionX + " | Countdeg : "  + countDeg);
                //kaki kiri
                float x1 = objekjames.get(0).getChildObject().get(3).getMatrix().get(3,0);
                float x2 = objekjames.get(0).getChildObject().get(3).getMatrix().get(3,1);
                float x3 = objekjames.get(0).getChildObject().get(3).getMatrix().get(3,2);
                //kaki kanan
                float x4 = objekjames.get(0).getChildObject().get(4).getMatrix().get(3,0);
                float x5 = objekjames.get(0).getChildObject().get(4).getMatrix().get(3,1);
                float x6 = objekjames.get(0).getChildObject().get(4).getMatrix().get(3,2);

                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-x1,-x2,-x3);
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(1.5f),directionX,0.0f,0.0f);
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(x1,x2,x3);

                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-x4,-x5,-x6);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(-1.5f),directionX,0.0f,0.0f);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(x4,x5,x6);

                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(true);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(true);

                objekjames.get(0).translateObject(0.0f, 0.0f, 0.05f);
                Vector3f temp = objekjames.get(0).getUpdateCenterPoint();
                objekjames.get(0).translateObject(-temp.x, -temp.y, -temp.z);

                switch (state){
                    case 1:
                        directionBodyX = 0.0f;
                        directionBodyY = 1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                        break;
                    case 2:
                        directionBodyX = 0.0f;
                        directionBodyY = -1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(180f), directionBodyX, directionBodyY, 0.0f);
                        break;
                    case 3:
                        directionBodyX = 0.0f;
                        directionBodyY = -1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                        break;
                }
                state = 0;
                objekjames.get(0).translateObject(temp.x, temp.y, temp.z);
                currentBodyDegree = currentBodyDegree + (270f - currentBodyDegree);
                currentDeg += countDeg;

                //set exclude balik normal
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(false);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(false);
                isPressed = false;
            }
        }
        if(!window.isKeyPressed(GLFW_KEY_W)){
            isPressed = false;
        }
        if(window.isKeyPressed(GLFW_KEY_W)){
            if(!isPressed){
                isPressed = true;
                if (currentDeg >= 35f){
                    countDeg = -1.5f;
                    directionX = -1f;
                } else if (currentDeg <= -35f){
                    countDeg =  1.5f;
                    directionX = 1f;
                }
                objekjames.get(0).updateCenterPoint();
//                System.out.println("Current degree : " + currentDeg + " | direction : " + directionX + " | Countdeg : "  + countDeg);

                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).updateCenterPoint();
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).updateCenterPoint();

                //kaki kiri
                float x1 = objekjames.get(0).getChildObject().get(3).getMatrix().get(3,0);
                float x2 = objekjames.get(0).getChildObject().get(3).getMatrix().get(3,1);
                float x3 = objekjames.get(0).getChildObject().get(3).getMatrix().get(3,2);
                //kaki kanan
                float x4 = objekjames.get(0).getChildObject().get(4).getMatrix().get(3,0);
                float x5 = objekjames.get(0).getChildObject().get(4).getMatrix().get(3,1);
                float x6 = objekjames.get(0).getChildObject().get(4).getMatrix().get(3,2);

                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-x1,-x2,-x3);
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(1.5f),directionX,0.0f,0.0f);
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(x1,x2,x3);

                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-x4,-x5,-x6);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(-1.5f),directionX,0.0f,0.0f);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(x4,x5,x6);

                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(true);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(true);

                objekjames.get(0).translateObject(0.0f, 0.0f, -0.05f);
                Vector3f temp = objekjames.get(0).getUpdateCenterPoint();
                objekjames.get(0).translateObject(-temp.x, -temp.y, -temp.z);

                switch (state){
                    case 0:
                        directionBodyX = 0.0f;
                        directionBodyY = 1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(180f), directionBodyX, directionBodyY, 0.0f);
                        break;
                    case 1:
                        directionBodyX = 0.0f;
                        directionBodyY = -1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                        break;
                    case 3:
                        directionBodyX = 0.0f;
                        directionBodyY = 1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                        break;
                }
                state = 2;
                objekjames.get(0).translateObject(temp.x, temp.y, temp.z);
                currentBodyDegree = currentBodyDegree + (90f - currentBodyDegree);
                currentDeg += countDeg;

                //set exclude balik normal
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(false);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(false);
                isPressed = false;
            }
        }
        if(!window.isKeyPressed(GLFW_KEY_A)){
            isPressed = false;
        }
        if (window.isKeyPressed(GLFW_KEY_A)){
            if (!isPressed) {
                isPressed = true;
                if (currentDeg >= 35f) {
                    countDeg = -1.5f;
                    directionX = -1f;
                } else if (currentDeg <= -35f) {
                    countDeg = 1.5f;
                    directionX = 1f;
                }
                objekjames.get(0).updateCenterPoint();
//                System.out.println("Current degree : " + currentDeg + " | direction : " + directionX + " | Countdeg : " + countDeg);

                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).updateCenterPoint();
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).updateCenterPoint();

                //kaki kiri
                float x1 = objekjames.get(0).getChildObject().get(3).getMatrix().get(3,0);
                float x2 = objekjames.get(0).getChildObject().get(3).getMatrix().get(3,1);
                float x3 = objekjames.get(0).getChildObject().get(3).getMatrix().get(3,2);
                //kaki kanan
                float x4 = objekjames.get(0).getChildObject().get(4).getMatrix().get(3,0);
                float x5 = objekjames.get(0).getChildObject().get(4).getMatrix().get(3,1);
                float x6 = objekjames.get(0).getChildObject().get(4).getMatrix().get(3,2);

                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-x1,-x2,-x3);
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,0.0f,directionX);
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(x1,x2,x3);

                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-x4,-x5,-x6);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(-1.5f),0.0f,0.0f,directionX);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(x4,x5,x6);

//                set exclude kaki dari rotate
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(true);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(true);

                objekjames.get(0).translateObject(-0.05f, 0.0f, 0.0f);
                Vector3f temp = objekjames.get(0).getUpdateCenterPoint();
                objekjames.get(0).translateObject(-temp.x, -temp.y, -temp.z);
                // state 0 = S, 1 = A, 2 = W, 3 = D
                switch (state){
                    case 0:
                        directionBodyX = 0.0f;
                        directionBodyY = -1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                        break;
                    case 2:
                        directionBodyX = 0.0f;
                        directionBodyY = 1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                        break;
                    case 3:
                        directionBodyX = 0.0f;
                        directionBodyY = -1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(180f), directionBodyX, directionBodyY, 0.0f);
                        break;
                }
                state = 1;
                objekjames.get(0).translateObject(temp.x, temp.y, temp.z);
                currentBodyDegree = currentBodyDegree + (180f - currentBodyDegree);
                currentDeg += countDeg;

////                set exclude balik normal
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(false);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(false);
                isPressed = false;
            }
        }
        if(!window.isKeyPressed(GLFW_KEY_D)){
            isPressed = false;
        }
        if (window.isKeyPressed(GLFW_KEY_D)){
            if (!isPressed) {
                isPressed = true;
                if (currentDeg >= 35f) {
                    countDeg = -1.5f;
                    directionX = -1f;
                } else if (currentDeg <= -35f) {
                    countDeg = 1.5f;
                    directionX = 1f;
                }
                objekjames.get(0).updateCenterPoint();
//                System.out.println("Current degree : " + currentDeg + " | direction : " + directionX + " | Countdeg : " + countDeg);

                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).updateCenterPoint();
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).updateCenterPoint();

                //kaki kiri
                float x1 = objekjames.get(0).getChildObject().get(3).getMatrix().get(3,0);
                float x2 = objekjames.get(0).getChildObject().get(3).getMatrix().get(3,1);
                float x3 = objekjames.get(0).getChildObject().get(3).getMatrix().get(3,2);
                //kaki kanan
                float x4 = objekjames.get(0).getChildObject().get(4).getMatrix().get(3,0);
                float x5 = objekjames.get(0).getChildObject().get(4).getMatrix().get(3,1);
                float x6 = objekjames.get(0).getChildObject().get(4).getMatrix().get(3,2);

                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-x1,-x2,-x3);
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,0.0f,directionX);
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(x1,x2,x3);

                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-x4,-x5,-x6);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(-1.5f),0.0f,0.0f,directionX);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(x4,x5,x6);

//                set exclude kaki dari rotate
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(true);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(true);

                objekjames.get(0).translateObject(0.05f, 0.0f, 0.0f);
                Vector3f temp = objekjames.get(0).getUpdateCenterPoint();
                objekjames.get(0).translateObject(-temp.x, -temp.y, -temp.z);
                // state 0 = S, 1 = A, 2 = W, 3 = D
                switch (state){
                    case 0:
                        directionBodyX = 0.0f;
                        directionBodyY = 1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                        break;
                    case 1:
                        directionBodyX = 0.0f;
                        directionBodyY = 1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(180f), directionBodyX, directionBodyY, 0.0f);
                        break;
                    case 2:
                        directionBodyX = 0.0f;
                        directionBodyY = -1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                        break;
                }
                state = 3;
                objekjames.get(0).translateObject(temp.x, temp.y, temp.z);
                currentBodyDegree = currentBodyDegree + (360f - currentBodyDegree);
                currentDeg += countDeg;

                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(false);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(false);
                isPressed = false;
            }
        }

        if(window.isKeyPressed(GLFW_KEY_I)){
            switch (state){
                case 0:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;
                    objekjames.get(0).rotateObject((float)Math.toRadians(180f), directionBodyX, directionBodyY, 0.0f);
                    break;
                case 1:
                    directionBodyX = 0.0f;
                    directionBodyY = -1.0f;
                    objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                    break;
                case 3:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;
                    objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                    break;
            }
            state = 2;
            currentBodyDegree = currentBodyDegree + (90f - currentBodyDegree);
            currentDeg += countDeg;
        }
        if(window.isKeyPressed(GLFW_KEY_K)){
            switch (state){
                case 1:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;
                    objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                    break;
                case 2:
                    directionBodyX = 0.0f;
                    directionBodyY = -1.0f;
                    objekjames.get(0).rotateObject((float)Math.toRadians(180f), directionBodyX, directionBodyY, 0.0f);
                    break;
                case 3:
                    directionBodyX = 0.0f;
                    directionBodyY = -1.0f;
                    objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                    break;
            }
            state = 0;
            currentBodyDegree = currentBodyDegree + (270f - currentBodyDegree);

        }
        if(window.isKeyPressed(GLFW_KEY_J)){
            switch (state){
                case 0:
                    directionBodyX = 0.0f;
                    directionBodyY = -1.0f;
                    objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                    break;
                case 2:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;
                    objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                    break;
                case 3:
                    directionBodyX = 0.0f;
                    directionBodyY = -1.0f;
                    objekjames.get(0).rotateObject((float)Math.toRadians(180f), directionBodyX, directionBodyY, 0.0f);
                    break;
            }
            state = 1;
            currentBodyDegree = currentBodyDegree + (180f - currentBodyDegree);
        }
        if(window.isKeyPressed(GLFW_KEY_L)){
            switch (state){
                case 0:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;
                    objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                    break;
                case 1:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;
                    objekjames.get(0).rotateObject((float)Math.toRadians(180f), directionBodyX, directionBodyY, 0.0f);
                    break;
                case 2:
                    directionBodyX = 0.0f;
                    directionBodyY = -1.0f;
                    objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyX, directionBodyY, 0.0f);
                    break;
            }
            state = 3;
            currentBodyDegree = currentBodyDegree + (360f - currentBodyDegree);
        }


        if (window.isKeyPressed(GLFW_KEY_UP)){
            camera.moveForward(0.01f);
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)){
            camera.moveBackwards(0.05f);
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)){
            camera.moveLeft(0.05f);
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT)){
            camera.moveRight(0.05f);
        }
        if(window.isKeyPressed(GLFW_KEY_PAGE_UP)){
            camera.moveUp(0.05f);
        }
        if(window.isKeyPressed(GLFW_KEY_PAGE_DOWN)){
            camera.moveDown(0.05f);
        }
        if (window.isKeyPressed(GLFW_KEY_N)){
            camera.addRotation(0.0f, 0.05f);
        }
        if (window.isKeyPressed(GLFW_KEY_M)){
            camera.addRotation(0.0f, -0.05f);
        }

        System.out.println(camera.getPosition());
    }

    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.08235294118f,
                    0.4980392157f, 0.9647058824f,
                    1.0f);
            GL.createCapabilities();
            input();
            //code
//            for(ObjectJames objectJames : objekjames){
//                objectJames.draw(camera,projection);
//            }

            for(ObjectJames burger : objekBurger){
                burger.draw(camera,projection);
            }

            for(ObjectJames lingkungan : enviromentMrKrab){
                lingkungan.draw(camera,projection);
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
        new ProjekJames().run();
    }
}