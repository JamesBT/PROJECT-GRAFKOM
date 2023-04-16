import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class ProjekGabungan {
    private final Window window = new Window(800, 800, "Projek Spongebob");
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(),window.getHeight());
    //function james ======================================================================================
    private ArrayList<ObjectJames> objekjames = new ArrayList<>();
    private ArrayList<ObjectJames> enviromentJames = new ArrayList<>();
    int stateJames = 0;
    float currentDegJames = 0.0f, countDegJames = 1.5f;
    float directionBodyXJames = 0f, directionBodyYJames = -1f;
    float currentBodyDegreeJames = 270f;
    float directionXJames = 1f;
    boolean isPressedJames = false;
    float degreekepalaJames = 0f;
    float countDegKepalaJames = 1.5f;
    float degreetanganJames =0f;
    float countDegTanganJames = 1.5f;
    boolean keyTurunDitekanJames = true;
    boolean keyNaikDitekanJames = true;
    float timerkeyAksi2James = -30f;
    boolean aksi2James = false;

    //function Johan
    private ArrayList<ObjectJohan> objectJohans = new ArrayList<>();
    float directionBodyXJohan = 0f, directionBodyYJohan = -1f;
    float currentBodyDegreeJohan = 270f;
    float currentDegJohan = 0.0f, countDegJohan = 3.5f;
    float directionXJohan = 1f, directionYJohan = 1f;
    float currentHighJohan = 0f;
    int stateJohan = 0;
    boolean isPressableJohan = true;

    //function Jane
    private ArrayList<ObjectJane> objectJane = new ArrayList<>();
    int countDegreeJane = 0;

    //function angel

    public void init(){
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        camera.setPosition(0,0,2.5f);
        camera.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(0.0f));

        // OBJEK JAMES ======================================================================================================

        //enviroment
        enviromentJames.add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.8901960784f,0.9176470588f,0.7764705882f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 1));
        enviromentJames.get(0).scaleObject(5.0f,5.0f,0.5f);
        enviromentJames.get(0).translateObject(0.0f,0.0f,1.25f);
        enviromentJames.get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //batu kanan (1)
        enviromentJames.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.3254901961f,0.4196078431f,0.3882352941f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 2));
        enviromentJames.get(0).getChildObject().get(0).scaleObject(0.5f,0.5f,0.5f);
        enviromentJames.get(0).getChildObject().get(0).translateObject(1.6f,-1.2f,0.00f);
        //batu kiri (1)
        enviromentJames.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.3254901961f,0.4196078431f,0.3882352941f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 2));
        enviromentJames.get(0).getChildObject().get(1).scaleObject(0.5f,0.5f,0.5f);
        enviromentJames.get(0).getChildObject().get(1).translateObject(-1.8f,-1.2f,0.50f);
        //batu tengah
        enviromentJames.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.3254901961f,0.4196078431f,0.3882352941f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 2));
        enviromentJames.get(0).getChildObject().get(2).scaleObject(0.5f,0.5f,0.5f);
        enviromentJames.get(0).getChildObject().get(2).translateObject(-0.2f,-1.2f,1.50f);
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
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new ObjectJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(),new Vector4f(0.0f, 0.0f, 0.0f, 1.0f)));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).addVertices(new Vector3f(-0.2f, 0.55f, 0.3f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).addVertices(new Vector3f(0.0f, 0.475f, 0.3f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).addVertices(new Vector3f(0.3f, 0.55f, 0.3f));
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).updateCurve(objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).getVertices());
        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).setThickness(3);

        objekjames.get(0).translateObject(-1.0f,0.0f,0.0f);
        // OBJEK JOHAN ======================================================================================================

//        Badan plankton, Silinder
        objectJohans.add(new CircleJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER),new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)), new ArrayList<>(List.of(new Vector3f(0.0f,0.0f,0.0f))), new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f), new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)), -0.175f,0.175f, 0.5f));
        objectJohans.get(0).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).rotateObject((float) Math.toRadians(-90f),0.0f,0.0f,1.0f);
        objectJohans.get(0).rotateObject((float) Math.toRadians(45f),0.0f,1.0f,0.0f);

        // Half sphere Atas
        objectJohans.get(0).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), -0.175f, 0.175f, 0.175f, 100, 100, 1));
        objectJohans.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).translateObject(0.0f,-0.02f,0.0f);

        // Half sphere bawah
        objectJohans.get(0).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f), Arrays.asList(0.0f,0.0f,2.0f), -0.175f, 0.175f, 0.175f, 100, 100, 1));
        objectJohans.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(-180f),0.0f,0.0f,1.0f);
        objectJohans.get(0).getChildObject().get(1).translateObject(0.0f,1.5f,0.0f);

//        Engsel kaki kiri
        objectJohans.get(0).getChildObject().get(1).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), -0.05f, 0.05f, 0.05f, 100, 100, 5));
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(-0.07f,-0.6f,0.0f);
//   Kaki kiri
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), -0.175f, 0.175f, 0.175f, 100, 100, 2));
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(-0.13f/2,-1.6f/2,0.0f);

//        Engsel kaki kanan
        objectJohans.get(0).getChildObject().get(1).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), -0.05f, 0.05f, 0.05f, 100, 100, 5));
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).translateObject(0.07f,-0.6f,0.0f);
//  kaki kanan
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), -0.175f, 0.175f, 0.175f, 100, 100, 2));
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(0.13f/2,-1.6f/2,0.0f);

//        Engsel Tangan Kanan
        objectJohans.get(0).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), -0.05f/2, 0.05f/2, 0.05f/2, 100, 100, 5));
        objectJohans.get(0).getChildObject().get(2).translateObject(-0.6f,0.0f,-2.2f);
        objectJohans.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(45f),0.0f,0.0f,1.0f);
        objectJohans.get(0).getChildObject().get(2).translateObject(-1.0f,1.7f,0.0f);

//        Tangan kanan
        objectJohans.get(0).getChildObject().get(2).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), -0.175f, 0.175f, 0.175f, 100, 100, 2));
        objectJohans.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-0.6f,0.0f,-1.2f);
        objectJohans.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float) Math.toRadians(45f),0.0f,0.0f,1.0f);
        objectJohans.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-0.1f,0.78f,0.0f);
        //        Engsel Tangan Kiri
        objectJohans.get(0).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), -0.05f/2, 0.05f/2, 0.05f/2, 100, 100, 5));
        objectJohans.get(0).getChildObject().get(3).translateObject(-0.6f,0.0f,-2.2f);
        objectJohans.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(45f),0.0f,0.0f,1.0f);
        objectJohans.get(0).getChildObject().get(3).translateObject(-1.0f,1.7f,0.0f);
        objectJohans.get(0).getChildObject().get(3).scaleObject(-1.0f, 1.0f, 1.0f);


//        Tangan kiri
        objectJohans.get(0).getChildObject().get(3).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), -0.175f, 0.175f, 0.175f, 100, 100, 2));
        objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-0.6f,0.0f,-1.2f);
        objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float) Math.toRadians(45f),0.0f,0.0f,1.0f);
        objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-0.1f,0.78f,0.0f);
        objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).scaleObject(-1.0f, 1.0f, 1.0f);

//        MATA bagian luar
        objectJohans.get(0).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)234/255,(float)245/255,(float)52/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), -0.1f, 0.05f, 0.1375f, 100, 100, 3));
        objectJohans.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(4).translateObject(0.0f,-0.1f,0.2f);
//        MATA bagian dalam
        objectJohans.get(0).getChildObject().get(4).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)198/255,(float)35/255,(float)26/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), -0.0375f, 0.01875f, 0.055f, 100, 100, 3));
        objectJohans.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(0.0f,-0.1f,0.24f);

        //        MATA bagian dalam - 2
        objectJohans.get(0).getChildObject().get(4).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)243/255,(float)150/255,(float)126/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), -0.0375f/3, 0.01875f/3, 0.055f/3, 100, 100, 3));
        objectJohans.get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(4).getChildObject().get(1).translateObject(0.0f,-0.08f,0.26f);


//        Antena kiri
        objectJohans.get(0).getChildObject().get(0).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)12/255,(float)80/255,(float)40/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.01f/2, 0.01f/2, 0.25f/2, 100, 100, 4));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-0.15f/2,1.4f/2,0.0f);

//        antena kanan
        objectJohans.get(0).getChildObject().get(0).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f((float)12/255,(float)80/255,(float)40/255,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.01f/2, 0.01f/2, 0.25f/2, 100, 100, 4));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-0.15f/2,1.4f/2,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(-1.0f, 1.0f, 1.0f);


//        ATRIBUT ANTENA - 1
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new CircleJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER),new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)), new ArrayList<>(List.of(new Vector3f(0.0f,0.0f,0.0f))), new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f), new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)), 0.05f/2,0.025f/2, 0.2f/2));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.05f/2,0.5f/2,0.0f);

//        Atribut antena - 2
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new CircleJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER),new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)), new ArrayList<>(List.of(new Vector3f(0.0f,0.0f,0.0f))), new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f), new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)), 0.05f/2,0.025f/2, 0.2f/2));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1).translateObject(0.05f/2,0.8f/2,0.0f);

//        Atribut Antena - 3
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new CircleJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER),new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)), new ArrayList<>(List.of(new Vector3f(0.0f,0.0f,0.0f))), new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f), new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)), 0.05f/2,0.025f/2, 0.2f/2));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).translateObject(0.05f/2,1.1f/2,0.0f);

//        MIRORRING KE KIRI
        //        ATRIBUT ANTENA - 1
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new CircleJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER),new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)), new ArrayList<>(List.of(new Vector3f(0.0f,0.0f,0.0f))), new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f), new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)), 0.05f/2,0.025f/2, 0.2f/2));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.05f/2,0.5f/2,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(-1.0f, 1.0f, 1.0f);

//        Atribut antena - 2
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new CircleJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER),new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)), new ArrayList<>(List.of(new Vector3f(0.0f,0.0f,0.0f))), new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f), new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)), 0.05f/2,0.025f/2, 0.2f/2));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.05f/2,0.8f/2,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(-1.0f, 1.0f, 1.0f);

//        Atribut Antena - 3
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new CircleJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER),new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)), new ArrayList<>(List.of(new Vector3f(0.0f,0.0f,0.0f))), new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f), new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)), 0.05f/2,0.025f/2, 0.2f/2));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.05f/2,1.1f/2,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(-1.0f, 1.0f, 1.0f);

        //      Alis
        objectJohans.get(0).getChildObject().get(0).getChildObject().add(new ObjectJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(),new Vector4f(0.0f, 0.0f, 0.0f, 1.0f)));

        objectJohans.get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(-0.15f/2, 0.15f/2, 0.3f/2));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(0.0f, 0.25f/2, 0.3f/2));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(0.15f/2, 0.15f/2, 0.3f/2));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(2).updateCurve(objectJohans.get(0).getChildObject().get(0).getChildObject().get(2).getVertices());
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(2).setThickness(10);

        //        Mulut
        objectJohans.get(0).getChildObject().add(new ObjectJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(),new Vector4f(0.0f, 0.0f, 0.0f, 1.0f)));

        objectJohans.get(0).getChildObject().get(5).addVertices(new Vector3f(-0.2f/2, -0.5f/2, 0.35f/2));
        objectJohans.get(0).getChildObject().get(5).addVertices(new Vector3f(0.0f/2, -0.7f/2, 0.35f/2));
        objectJohans.get(0).getChildObject().get(5).addVertices(new Vector3f(0.2f/2, -0.5f/2, 0.35f/2));
        objectJohans.get(0).getChildObject().get(5).updateCurve(objectJohans.get(0).getChildObject().get(5).getVertices());
        objectJohans.get(0).getChildObject().get(5).setThickness(5);

//enviroment
        objectJohans.add(new CircleJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER),new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)), new ArrayList<>(List.of(new Vector3f(0.0f,0.0f,0.0f))), new Vector4f(0.8901960784f,0.9176470588f,0.7764705882f,1.0f), new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)), 0.5f, 0.5f, 0.5f));
        objectJohans.get(1).scaleObject(5.0f,5.0f,0.5f);
        objectJohans.get(1).translateObject(0.0f,0.0f,1.25f);
        objectJohans.get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);

        //batu kanan (1)
        objectJohans.get(1).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.3254901961f,0.4196078431f,0.3882352941f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 5));
        objectJohans.get(1).getChildObject().get(0).scaleObject(0.5f,0.5f,0.5f);
        objectJohans.get(1).getChildObject().get(0).translateObject(1.6f,-1.2f,0.00f);

        //batu kanan (2)
        objectJohans.get(1).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.3254901961f,0.4196078431f,0.3882352941f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 5));
        objectJohans.get(1).getChildObject().get(1).scaleObject(0.5f,0.5f,0.5f);
        objectJohans.get(1).getChildObject().get(1).translateObject(-1.6f,-1.2f,0.00f);

        //batu kanan (3)
        objectJohans.get(1).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.3254901961f,0.4196078431f,0.3882352941f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 5));
        objectJohans.get(1).getChildObject().get(2).scaleObject(0.5f,0.5f,0.5f);
        objectJohans.get(1).getChildObject().get(2).translateObject(-1.6f/2,-1.2f,-1.3f);

        //batu kanan (4)
        objectJohans.get(1).getChildObject().add(new SphereJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.3254901961f,0.4196078431f,0.3882352941f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 5));
        objectJohans.get(1).getChildObject().get(3).scaleObject(0.5f,0.5f,0.5f);
        objectJohans.get(1).getChildObject().get(3).translateObject(1.6f/2,-1.2f,-1.3f);

        objectJohans.get(0).translateObject(-2.0f,0f,0f);

        //OBJEK JANE ================================================================================
        //Badan Gary (lendir yg bersentuhan dgn tanah)
        objectJane.add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72  ,3
        ));
        objectJane.get(0).scaleObject(0.12f,0.18f,0.1f);


        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(0).scaleObject(0.12f,0.18f,0.1f);
        objectJane.get(0).getChildObject().get(0).translateObject(0.08f,0.0f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(1).scaleObject(0.12f,0.18f,0.1f);
        objectJane.get(0).getChildObject().get(1).translateObject(0.145f,0.0f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(2).scaleObject(0.12f,0.18f,0.1f);
        objectJane.get(0).getChildObject().get(2).translateObject(0.208f,0.0f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(3).scaleObject(0.12f,0.18f,0.1f);
        objectJane.get(0).getChildObject().get(3).translateObject(0.275f,0.0f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(4).scaleObject(0.12f,0.18f,0.1f);
        objectJane.get(0).getChildObject().get(4).translateObject(0.345f,0.0f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(5).scaleObject(0.12f,0.18f,0.1f);
        objectJane.get(0).getChildObject().get(5).translateObject(0.415f,0.0f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(6).scaleObject(0.12f,0.18f,0.1f);
        objectJane.get(0).getChildObject().get(6).translateObject(0.485f,0.0f,0.0f);

        //cangkang bwh --> lendir yg sedikit
        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.6f,0.4f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(7).scaleObject(0.18f,0.15f,0.1f);
        objectJane.get(0).getChildObject().get(7).translateObject(0.235f,0.01003f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.6f,0.4f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(8).scaleObject(0.18f,0.15f,0.1f);
        objectJane.get(0).getChildObject().get(8).translateObject(0.255f,0.01003f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.6f,0.4f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(9).scaleObject(0.18f,0.15f,0.1f);
        objectJane.get(0).getChildObject().get(9).translateObject(0.275f,0.01003f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.6f,0.4f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(10).scaleObject(0.18f,0.15f,0.1f);
        objectJane.get(0).getChildObject().get(10).translateObject(0.295f,0.01003f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.6f,0.4f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(11).scaleObject(0.18f,0.15f,0.1f);
        objectJane.get(0).getChildObject().get(11).translateObject(0.315f,0.01003f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.6f,0.4f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(12).scaleObject(0.18f,0.15f,0.1f);
        objectJane.get(0).getChildObject().get(12).translateObject(0.335f,0.01003f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.6f,0.4f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(13).scaleObject(0.18f,0.15f,0.1f);
        objectJane.get(0).getChildObject().get(13).translateObject(0.355f,0.01003f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.6f,0.4f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(14).scaleObject(0.18f,0.15f,0.1f);
        objectJane.get(0).getChildObject().get(14).translateObject(0.375f,0.01003f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.6f,0.4f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(15).scaleObject(0.18f,0.15f,0.1f);
        objectJane.get(0).getChildObject().get(15).translateObject(0.395f,0.01003f,0.0f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.6f,0.4f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,3
        ));
        objectJane.get(0).getChildObject().get(16).scaleObject(0.18f,0.15f,0.1f);
        objectJane.get(0).getChildObject().get(16).translateObject(0.415f,0.01003f,0.0f);

        //cangkang atas --> cangkang besar
        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.6f,0.4f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                100,
                100,4
        ));
        objectJane.get(0).getChildObject().get(17).scaleObject(1.6f,1.001f,2f);
        objectJane.get(0).getChildObject().get(17).translateObject(0.315f,0.01f,0.0f);

        //cagak mata kiri (dari sudut pandang depan)
        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                100,
                100,10
        ));
        objectJane.get(0).getChildObject().get(18).scaleObject(0.1f,0.1f,0.7f);
        objectJane.get(0).getChildObject().get(18).translateObject(0.0025f,0.02f,0.08f);
        objectJane.get(0).getChildObject().get(18).rotateObject((float) Math.toRadians(-10),1.0f,0.0f,0.0f);

        //cagak mata kanan (dari sudut pandang depan)
        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                100,
                100,10
        ));
        objectJane.get(0).getChildObject().get(19).scaleObject(0.1f,0.1f,0.7f);
        objectJane.get(0).getChildObject().get(19).translateObject(0.0025f,-0.02f,0.08f);
        objectJane.get(0).getChildObject().get(19).rotateObject((float) Math.toRadians(10), 1.0f,0.0f,0.0f);

        //bola mata kiri (dari sudut pandang depan)
        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.6f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,2
        ));
        objectJane.get(0).getChildObject().get(20).scaleObject(0.4f,0.4f,0.4f);
        objectJane.get(0).getChildObject().get(20).translateObject(0.0025f,0.035f,0.2f);
        objectJane.get(0).getChildObject().get(20).rotateObject((float) Math.toRadians(-5),1.0f,0.0f,0.0f);

        //bola mata kanan (dari sudut pandang depan)
        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.6f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                72,
                72,2
        ));
        objectJane.get(0).getChildObject().get(21).scaleObject(0.4f,0.4f,0.4f);
        objectJane.get(0).getChildObject().get(21).translateObject(0.0025f,-0.02f,0.2f);
        objectJane.get(0).getChildObject().get(21).rotateObject((float) Math.toRadians(12),1.0f,0.0f,0.0f);

        //mata kecil yg orange kanan (dari sudut pandang depan)
        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.5f,0.117f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                400,
                400,2
        ));
        objectJane.get(0).getChildObject().get(22).scaleObject(0.2f,0.2f,0.2f);
        objectJane.get(0).getChildObject().get(22).translateObject(-0.03f,0.035f,0.2f);
        objectJane.get(0).getChildObject().get(22).rotateObject((float) Math.toRadians(27),1.0f,0.0f,0.0f);

        //mata kecil yg orange kiri (dari sudut pandang depan)
        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.5f,0.117f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                400,
                400,2
        ));
        objectJane.get(0).getChildObject().get(23).scaleObject(0.2f,0.2f,0.2f);
        objectJane.get(0).getChildObject().get(23).translateObject(-0.03f,0.015f,0.2f);
        objectJane.get(0).getChildObject().get(23).rotateObject((float) Math.toRadians(-12),1.0f,0.0f,0.0f);

        //mata kecil yg biru kiri (dari sudut pandang depan)
        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                400,
                400,2
        ));
        objectJane.get(0).getChildObject().get(24).scaleObject(0.1f,0.1f,0.1f);
        objectJane.get(0).getChildObject().get(24).translateObject(-0.05f,0.015f,0.2f);
        objectJane.get(0).getChildObject().get(24).rotateObject((float) Math.toRadians(-12),1.0f,0.0f,0.0f);

        //mata kecil yg biru kanan (dari sudut pandang depan)
        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                400,
                400,2
        ));
        objectJane.get(0).getChildObject().get(25).scaleObject(0.1f,0.1f,0.1f);
        objectJane.get(0).getChildObject().get(25).translateObject(-0.05f,0.035f,0.2f);
        objectJane.get(0).getChildObject().get(25).rotateObject((float) Math.toRadians(27),1.0f,0.0f,0.0f);

        //topi ultah gary --> yg warna hijau
        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                400,
                400,6
        ));
        objectJane.get(0).getChildObject().get(26).scaleObject(0.02f,0.03f,0.04f); //tertukar yg y jdi x, yg x jdi y
        objectJane.get(0).getChildObject().get(26).translateObject(0.01f,0.315f,-0.35f); //tertukar yg y jdi x, yg x jdi y
        objectJane.get(0).getChildObject().get(26).rotateObject((float) Math.toRadians(-90),0.0f,0.0f,1.0f);
        objectJane.get(0).getChildObject().get(26).rotateObject((float) Math.toRadians(-180),1.0f,0.0f,0.0f);

        //kurva bezier

        // melungker cangkang kanan dari sisi depan

        objectJane.get(0).getChildObject().add(new ObjectJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                new ArrayList<>()
                ,new Vector4f(0.0f, 0.0f, 1.0f, 1.0f)
        ));
        objectJane.get(0).getChildObject().get(27).addvertices(new Vector3f(0.3f, 0.3f, 0.0f));
        objectJane.get(0).getChildObject().get(27).addvertices(new Vector3f(0.32f, 0.38f, 0.05f));
        objectJane.get(0).getChildObject().get(27).addvertices(new Vector3f(0.38f, 0.34f, 0.0f));
        objectJane.get(0).getChildObject().get(27).addvertices(new Vector3f(0.35f, 0.3f, 0.0f));
        objectJane.get(0).getChildObject().get(27).addvertices(new Vector3f(0.33f, 0.32f, 0.0f));


        objectJane.get(0).getChildObject().get(27).updateCurve(objectJane.get(0).getChildObject().get(27).getVertices());
        objectJane.get(0).getChildObject().get(27).setThickness(2);
        objectJane.get(0).getChildObject().get(27).translateObject(-0.028f,-0.27f,0.12f);
        objectJane.get(0).getChildObject().get(27).rotateObject((float) Math.toRadians(85),1.0f,0.0f,0.0f);


        //melungker cangkang kiri dari sisi depan
        objectJane.get(0).getChildObject().add(new ObjectJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                new ArrayList<>()
                ,new Vector4f(0.0f, 0.0f, 1.0f, 1.0f)
        ));
        objectJane.get(0).getChildObject().get(28).addvertices(new Vector3f(0.3f, 0.3f, 0.0f));
        objectJane.get(0).getChildObject().get(28).addvertices(new Vector3f(0.32f, 0.38f, 0.05f));
        objectJane.get(0).getChildObject().get(28).addvertices(new Vector3f(0.38f, 0.34f, 0.0f));
        objectJane.get(0).getChildObject().get(28).addvertices(new Vector3f(0.35f, 0.3f, 0.0f));
        objectJane.get(0).getChildObject().get(28).addvertices(new Vector3f(0.33f, 0.32f, 0.0f));


        objectJane.get(0).getChildObject().get(28).updateCurve(objectJane.get(0).getChildObject().get(27).getVertices());
        objectJane.get(0).getChildObject().get(28).setThickness(2);
        objectJane.get(0).getChildObject().get(28).translateObject(-0.028f,-0.27f,0.12f);
        objectJane.get(0).getChildObject().get(28).rotateObject((float) Math.toRadians(85),1.0f,0.0f,0.0f);
        objectJane.get(0).getChildObject().get(28).scaleObject(1.0f,-1.13f,1.0f);

        // pentol2 di cangkang
        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.486f,0.98f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                400,
                400,3
        ));
        objectJane.get(0).getChildObject().get(29).scaleObject(0.1f,0.23f,-0.12f);
        objectJane.get(0).getChildObject().get(29).translateObject(0.375f,0.01f,0.09f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.486f,0.98f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                400,
                400,3
        ));
        objectJane.get(0).getChildObject().get(30).scaleObject(0.1f,0.215f,-0.12f);
        objectJane.get(0).getChildObject().get(30).translateObject(0.315f,0.0105f,0.135f);

        objectJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.486f,0.98f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                400,
                400,3
        ));
        objectJane.get(0).getChildObject().get(31).scaleObject(0.1f,0.215f,0.12f);
        objectJane.get(0).getChildObject().get(31).translateObject(0.24f,0.01f,0.09f);

        // mulut
        objectJane.get(0).getChildObject().add(new ObjectJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                new ArrayList<>()
                ,new Vector4f(1.0f, 0.0f, 0.0f, 1.0f)
        ));
        objectJane.get(0).getChildObject().get(32).addvertices(new Vector3f(-0.2f, 0.4f, 0.0f));
        objectJane.get(0).getChildObject().get(32).addvertices(new Vector3f(-0.4f, 0.2f, 0.05f));
        objectJane.get(0).getChildObject().get(32).addvertices(new Vector3f(-0.2f, 0.0f, 0.0f));
        objectJane.get(0).getChildObject().get(32).updateCurve(objectJane.get(0).getChildObject().get(32).getVertices());
        objectJane.get(0).getChildObject().get(32).setThickness(5);
        objectJane.get(0).getChildObject().get(32).rotateObject((float) Math.toRadians(-90), 0.0f,1.0f,0.0f);
        objectJane.get(0).getChildObject().get(32).scaleObject(0.3f,0.3f,0.3f);
        objectJane.get(0).getChildObject().get(32).translateObject(-0.06f,-0.068f,0.06f);


        //rotate seluruh object begitu di run --> sudut pandang samping
        objectJane.get(0).rotateObject((float) Math.toRadians(-90),1.0f,0.0f,0.0f);
        // jalankan code di bawah jika ingin langsung hadap kita saat di run
        //object1.get(0).rotateObject((float) Math.toRadians(90),0.0f,1.0f,0.0f); //hadap kita

        //OBJEK ANGELINA ====================================================================================

    }

    public void input(){
        //KEY AKSI JOHAN =================================================================================

        //gerakan tangan
        if (window.isKeyPressed(GLFW_KEY_E)){
            //        matrix tangan kanan
            float x10 = objectJohans.get(0).getChildObject().get(2).getMatrix().get(3,0);
            float x20 = objectJohans.get(0).getChildObject().get(2).getMatrix().get(3,1);
            float x30 = objectJohans.get(0).getChildObject().get(2).getMatrix().get(3,2);

            //        matrix tangan kiri
            float x11 = objectJohans.get(0).getChildObject().get(3).getMatrix().get(3,0);
            float x21 = objectJohans.get(0).getChildObject().get(3).getMatrix().get(3,1);
            float x31 = objectJohans.get(0).getChildObject().get(3).getMatrix().get(3,2);

            //        Animasi tangan kanan
            objectJohans.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-x10,-x20,-x30);
            objectJohans.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float) Math.toRadians(4.5f),1.0f,0.0f,0.0f);
            objectJohans.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(x10,x20,x30);

            //        Animasi tangan kiri
            objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-x11,-x21,-x31);
            objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).updateCenterPoint();
            objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float) Math.toRadians(6.5f),1.0f,0.0f,0.0f);
            objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(x11,x21,x31);
        }

        //reset posisi kaki
        if (window.isKeyPressed(GLFW_KEY_S) && window.isKeyPressed(GLFW_KEY_W) || window.isKeyPressed(GLFW_KEY_A) && window.isKeyPressed(GLFW_KEY_D) || window.isKeyPressed(GLFW_KEY_S) && window.isKeyPressed(GLFW_KEY_D) || window.isKeyPressed(GLFW_KEY_S) && window.isKeyPressed(GLFW_KEY_A) || window.isKeyPressed(GLFW_KEY_A) && window.isKeyPressed(GLFW_KEY_W) || window.isKeyPressed(GLFW_KEY_D) && window.isKeyPressed(GLFW_KEY_W)){
            isPressableJohan = false;
        }

        if (!window.isKeyPressed(GLFW_KEY_S)){
            isPressableJohan = true;
        }

        if (!window.isKeyPressed(GLFW_KEY_S) && !window.isKeyPressed(GLFW_KEY_W) && !window.isKeyPressed(GLFW_KEY_A) && !window.isKeyPressed(GLFW_KEY_D)){
            if (currentDegJohan != 0 && stateJohan == 0){ // S
                //        matrix kaki kiri
                float x11 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,0);
                float x21 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,1);
                float x31 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,2);

                //        matrix kaki kanan
                float x10 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,0);
                float x20 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,1);
                float x30 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,2);

                //        Animasi kaki
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(-x11,-x21,-x31);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(-x10,-x20,-x30);
                if (directionXJohan == -1 && currentDegJohan > 0){ // posisi kaki di depan, mau mundur
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-currentDegJohan), directionXJohan,0.0f,0.0f);
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(currentDegJohan), directionXJohan,0.0f,0.0f);

                } else if (directionXJohan == -1 && currentDegJohan < 0){ // posisi kaki blkg, mau mundur
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(currentDegJohan),-directionXJohan,0.0f,0.0f);
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-currentDegJohan), -directionXJohan,0.0f,0.0f);
                } else if (directionXJohan == 1 && currentDegJohan < 0){ // posisi kaki di blkg mau maju
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-currentDegJohan), -directionXJohan,0.0f,0.0f);
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(currentDegJohan), -directionXJohan,0.0f,0.0f);
                } else {  // posisi kaki di depan mau maju
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(currentDegJohan), directionXJohan,0.0f,0.0f);
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-currentDegJohan), directionXJohan,0.0f,0.0f);
                }
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(x11,x21,x31);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(x10,x20,x30);

                currentDegJohan += -1* currentDegJohan;
            } else if (currentDegJohan != 0 && stateJohan == 2){ // W
                //        matrix kaki kiri
                float x11 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,0);
                float x21 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,1);
                float x31 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,2);

                //        matrix kaki kanan
                float x10 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,0);
                float x20 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,1);
                float x30 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,2);

                //        Animasi kaki
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(-x11,-x21,-x31);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(-x10,-x20,-x30);
                if (directionXJohan == -1 && currentDegJohan > 0){ // posisi kaki di depan, mau mundur
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-currentDegJohan), directionXJohan,0.0f,0.0f);
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(currentDegJohan), directionXJohan,0.0f,0.0f);

                } else if (directionXJohan == -1 && currentDegJohan < 0){ // posisi kaki blkg, mau mundur
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(currentDegJohan),-directionXJohan,0.0f,0.0f);
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-currentDegJohan), -directionXJohan,0.0f,0.0f);
                } else if (directionXJohan == 1 && currentDegJohan < 0){ // posisi kaki di blkg mau maju
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-currentDegJohan), -directionXJohan,0.0f,0.0f);
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(currentDegJohan), -directionXJohan,0.0f,0.0f);
                } else {  // posisi kaki di depan mau maju
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(currentDegJohan), directionXJohan,0.0f,0.0f);
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-currentDegJohan), directionXJohan,0.0f,0.0f);
                }
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(x11,x21,x31);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(x10,x20,x30);

                currentDegJohan += -1* currentDegJohan;
            } else if (currentDegJohan != 0 && stateJohan == 1 || stateJohan == 3){ // A
                //        matrix kaki kiri
                float x11 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,0);
                float x21 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,1);
                float x31 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,2);

                //        matrix kaki kanan
                float x10 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,0);
                float x20 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,1);
                float x30 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,2);

                //        Animasi kaki
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(-x11,-x21,-x31);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(-x10,-x20,-x30);
                if (directionXJohan == -1 && currentDegJohan > 0){ // posisi kaki di depan, mau mundur
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-currentDegJohan), 0.0f,0.0f, directionXJohan);
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(currentDegJohan), 0.0f,0.0f, directionXJohan);

                } else if (directionXJohan == -1 && currentDegJohan < 0){ // posisi kaki blkg, mau mundur
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(currentDegJohan),0.0f,0.0f,-directionXJohan);
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-currentDegJohan), 0.0f,0.0f,-directionXJohan);
                } else if (directionXJohan == 1 && currentDegJohan < 0){ // posisi kaki di blkg mau maju
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-currentDegJohan), 0.0f,0.0f,-directionXJohan);
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(currentDegJohan), 0.0f,0.0f,-directionXJohan);
                } else {  // posisi kaki di depan mau maju
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(currentDegJohan),0.0f,0.0f, directionXJohan);
                    objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-currentDegJohan), 0.0f,0.0f, directionXJohan);
                }
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(x11,x21,x31);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(x10,x20,x30);

                currentDegJohan += -1* currentDegJohan;
            }
        }

        //        Animasi kaki
        if (window.isKeyPressed(GLFW_KEY_S)){
//            state 0
            if (isPressableJohan){
                isPressableJohan = false;
                if (currentDegJohan > 45f){
                    countDegJohan = -3.5f;
                    directionXJohan = -1f;
//                    System.out.println("Mundur");
                } else if (currentDegJohan < -45f){
                    countDegJohan =  3.5f;
                    directionXJohan = 1f;
//                    System.out.println("Maju");
                }

                objectJohans.get(0).updateCenterPoint();
                System.out.println("Current degree : " + currentDegJohan + " | direction : " + directionXJohan + " | Countdeg : "  + countDegJohan);

                //        matrix kaki kanan
                float x10 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,0);
                float x20 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,1);
                float x30 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,2);

                //        matrix kaki kiri
                float x11 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,0);
                float x21 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,1);
                float x31 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,2);

                //        Animasi kaki kanan
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(-x10,-x20,-x30);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(3.5f), directionXJohan,0.0f,0.0f);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(x10,x20,x30);

                //        Animasi kaki kiri
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(-x11,-x21,-x31);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-3.5f), directionXJohan,0.0f,0.0f);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(x11,x21,x31);

                objectJohans.get(0).translateObject(0.0f, 0.0f, 0.05f);
                Vector3f temp = objectJohans.get(0).getUpdateCenterPoint();
                objectJohans.get(0).translateObject(-temp.x, -temp.y, -temp.z);


//                    state 0 = S, 1 = A, 2 = W, 3 = D
                switch (stateJohan){
                    case 1:
                        directionBodyXJohan = 0.0f;
                        directionBodyYJohan = 1.0f;
                        objectJohans.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJohan, directionBodyYJohan, 0.0f);

                        break;
                    case 2:
                        directionBodyXJohan = 0.0f;
                        directionBodyYJohan = 1.0f;
                        //                set exclude kaki dari rotate
                        objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).setExclude(true);
                        objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).setExclude(true);

                        objectJohans.get(0).rotateObject((float)Math.toRadians(180f), directionBodyXJohan, directionBodyYJohan, 0.0f);
                        break;
                    case 3:
                        directionBodyXJohan = 0.0f;
                        directionBodyYJohan = -1.0f;
                        objectJohans.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJohan, directionBodyYJohan, 0.0f);
                        break;
                }
                stateJohan = 0;
                objectJohans.get(0).translateObject(temp.x, temp.y, temp.z);
                currentBodyDegreeJohan = currentBodyDegreeJohan + (270f - currentBodyDegreeJohan);
                currentDegJohan += countDegJohan;

                //                set exclude balik normal
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).setExclude(false);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).setExclude(false);

//            System.out.println(currentBodyDegree);
                isPressableJohan = true;
            }
        }

        if (!window.isKeyPressed(GLFW_KEY_W)){
            isPressableJohan = true;
        }

        if (window.isKeyPressed(GLFW_KEY_W)){
            if (isPressableJohan){
                isPressableJohan = false;
                if (currentDegJohan >= 45f){
                    countDegJohan = -3.5f;
                    directionXJohan = -1f;
                } else if (currentDegJohan <= -45f){
                    countDegJohan =  3.5f;
                    directionXJohan = 1f;
                }
                objectJohans.get(0).updateCenterPoint();
                System.out.println("Current degree : " + currentDegJohan + " | direction : " + directionXJohan + " | Countdeg : "  + countDegJohan);

                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).updateCenterPoint();
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).updateCenterPoint();

                //        matrix kaki kanan
                float x10 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,0);
                float x20 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,1);
                float x30 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,2);

                //        matrix kaki kiri
                float x11 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,0);
                float x21 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,1);
                float x31 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,2);

                //        Animasi kaki kanan
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(-x10,-x20,-x30);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(3.5f), directionXJohan,0.0f,0.0f);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(x10,x20,x30);

                //        Animasi kaki kiri
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(-x11,-x21,-x31);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-3.5f), directionXJohan,0.0f,0.0f);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(x11,x21,x31);

                objectJohans.get(0).translateObject(0.0f, 0.0f, -0.05f);
                Vector3f temp = objectJohans.get(0).getUpdateCenterPoint();
                objectJohans.get(0).translateObject(-temp.x, -temp.y, -temp.z);
                // state 0 = S, 1 = A, 2 = W, 3 = D
                switch (stateJohan){
                    case 0:
                        directionBodyXJohan = 0.0f;
                        directionBodyYJohan = 1.0f;
                        objectJohans.get(0).rotateObject((float)Math.toRadians(180f), directionBodyXJohan, directionBodyYJohan, 0.0f);
                        break;
                    case 1:
                        directionBodyXJohan = 0.0f;
                        directionBodyYJohan = -1.0f;
                        objectJohans.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJohan, directionBodyYJohan, 0.0f);
                        break;
                    case 3:
                        directionBodyXJohan = 0.0f;
                        directionBodyYJohan = 1.0f;
                        objectJohans.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJohan, directionBodyYJohan, 0.0f);
                        break;
                }
                stateJohan = 2;
                objectJohans.get(0).translateObject(temp.x, temp.y, temp.z);
                currentBodyDegreeJohan = currentBodyDegreeJohan + (90f - currentBodyDegreeJohan);
                currentDegJohan += countDegJohan;

//                set exclude balik normal
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).setExclude(false);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).setExclude(false);

                isPressableJohan = true;

//            System.out.println(currentBodyDegree);
            }
        }

        if (!window.isKeyPressed(GLFW_KEY_A)){
            isPressableJohan = true;
        }

        if (window.isKeyPressed(GLFW_KEY_A)){
            if (isPressableJohan){
                isPressableJohan = false;
                if (currentDegJohan >= 45f) {
                    countDegJohan = -3.5f;
                    directionXJohan = -1f;
                } else if (currentDegJohan <= -45f) {
                    countDegJohan = 3.5f;
                    directionXJohan = 1f;
                }
                objectJohans.get(0).updateCenterPoint();
                System.out.println("Current degree : " + currentDegJohan + " | direction : " + directionXJohan + " | Countdeg : " + countDegJohan);

                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).updateCenterPoint();
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).updateCenterPoint();

                //        matrix kaki kanan
                float x10 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,0);
                float x20 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,1);
                float x30 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,2);

                //        matrix kaki kiri
                float x11 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,0);
                float x21 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,1);
                float x31 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,2);

                //        Animasi kaki kanan
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(-x10, -x20, -x30);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(3.5f), 0.0f, 0.0f, directionXJohan);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(x10, x20, x30);

                //        Animasi kaki kiri
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(-x11, -x21, -x31);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-3.5f), 0.0f, 0.0f, directionXJohan);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(x11, x21, x31);

                objectJohans.get(0).translateObject(-0.005f, 0.0f, 0.0f);
                Vector3f temp = objectJohans.get(0).getUpdateCenterPoint();
                objectJohans.get(0).translateObject(-temp.x, -temp.y, -temp.z);
                // state 0 = S, 1 = A, 2 = W, 3 = D
                switch (stateJohan){
                    case 0:
                        directionBodyXJohan = 0.0f;
                        directionBodyYJohan = -1.0f;
                        objectJohans.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJohan, directionBodyYJohan, 0.0f);
                        break;
                    case 2:
                        directionBodyXJohan = 0.0f;
                        directionBodyYJohan = 1.0f;
                        objectJohans.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJohan, directionBodyYJohan, 0.0f);
                        break;
                    case 3:
                        directionBodyXJohan = 0.0f;
                        directionBodyYJohan = -1.0f;
                        //                set exclude kaki dari rotate
                        objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).setExclude(true);
                        objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).setExclude(true);

                        objectJohans.get(0).rotateObject((float)Math.toRadians(180f), directionBodyXJohan, directionBodyYJohan, 0.0f);
                        break;
                }
                stateJohan = 1;
                objectJohans.get(0).translateObject(temp.x, temp.y, temp.z);
                currentBodyDegreeJohan = currentBodyDegreeJohan + (180f - currentBodyDegreeJohan);
                currentDegJohan += countDegJohan;

////                set exclude balik normal
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).setExclude(false);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).setExclude(false);

                isPressableJohan = true;
            }
        }

        if (!window.isKeyPressed(GLFW_KEY_D)) {
            isPressableJohan = true;
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            if (isPressableJohan){
                isPressableJohan = false;
                if (currentDegJohan >= 45f) {
                    countDegJohan = -3.5f;
                    directionXJohan = -1f;
                } else if (currentDegJohan <= -45f) {
                    countDegJohan = 3.5f;
                    directionXJohan = 1f;
                }
                objectJohans.get(0).updateCenterPoint();
                System.out.println("Current degree : " + currentDegJohan + " | direction : " + directionXJohan + " | Countdeg : " + countDegJohan);

                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).updateCenterPoint();
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).updateCenterPoint();

                //        matrix kaki kanan
                float x10 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,0);
                float x20 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,1);
                float x30 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getMatrix().get(3,2);

                //        matrix kaki kiri
                float x11 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,0);
                float x21 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,1);
                float x31 = objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getMatrix().get(3,2);

                //        Animasi kaki kanan
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(-x10, -x20, -x30);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(3.5f), 0.0f, 0.0f, directionXJohan);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(x10, x20, x30);

                //        Animasi kaki kiri
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(-x11, -x21, -x31);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-3.5f), 0.0f, 0.0f, directionXJohan);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(x11, x21, x31);

                objectJohans.get(0).translateObject(0.005f, 0.0f, 0.0f);
                Vector3f temp = objectJohans.get(0).getUpdateCenterPoint();
                objectJohans.get(0).translateObject(-temp.x, -temp.y, -temp.z);
                // state 0 = S, 1 = A, 2 = W, 3 = D
                switch (stateJohan){
                    case 0:
                        directionBodyXJohan = 0.0f;
                        directionBodyYJohan = 1.0f;

                        objectJohans.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJohan, directionBodyYJohan, 0.0f);
                        break;
                    case 1:
                        directionBodyXJohan = 0.0f;
                        directionBodyYJohan = 1.0f;
                        //                set exclude kaki dari rotate
                        objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).setExclude(true);
                        objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).setExclude(true);

                        objectJohans.get(0).rotateObject((float)Math.toRadians(180f), directionBodyXJohan, directionBodyYJohan, 0.0f);
                        break;
                    case 2:
                        directionBodyXJohan = 0.0f;
                        directionBodyYJohan = -1.0f;

                        objectJohans.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJohan, directionBodyYJohan, 0.0f);
                        break;
                }
                stateJohan = 3;
                objectJohans.get(0).translateObject(temp.x, temp.y, temp.z);
                currentBodyDegreeJohan = currentBodyDegreeJohan + (360f - currentBodyDegreeJohan);
                currentDegJohan += countDegJohan;

////                set exclude balik normal
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).setExclude(false);
                objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).setExclude(false);

                isPressableJohan = true;
            }
        }
        //loncat
        if (window.isKeyPressed(GLFW_KEY_Q)){
            if (currentHighJohan >= 0.5f) {
                directionYJohan = -0.08f;
            } else if (currentHighJohan <= 0f) {
                directionYJohan = 0.0375f;
            }
            objectJohans.get(0).translateObject(0.0f, directionYJohan, 0.0f);
            currentHighJohan += directionYJohan;
        }

        //KEY AKSI JAMES =================================================================================
        //aksi 1 - praise the sun
        if(!window.isKeyPressed(GLFW_KEY_R)){
            isPressedJames = false;
        }
        if(window.isKeyPressed(GLFW_KEY_R)){
            if(!isPressedJames){
                isPressedJames = true;
                if(keyNaikDitekanJames){
                    keyNaikDitekanJames = false;
                    keyTurunDitekanJames = true;
                    aksi2James = false;
                    timerkeyAksi2James = -30f;
                }else{
                    objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getDerajat();
                    if(currentBodyDegreeJames != 0){
                        objekjames.get(0).rotateObject((float)Math.toRadians(-currentBodyDegreeJames),0.0f,1.0f,0.0f);
                    }

                    if(degreekepalaJames >= 36f){
                        countDegKepalaJames = 0f;
                        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getDerajat();
                    }
                    //gerakkan kepala ke atas
                    float x1 = objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,0);
                    float x2 = objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,1);
                    float x3 = objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,2);
                    objekjames.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-x1, -x2, -x3);
                    // buat ke atas dulu
                    if(currentBodyDegreeJames == 0.0f || currentBodyDegreeJames == 360.0f){
                        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepalaJames),0.0f,0.0f,1.0f);
                    }if(currentBodyDegreeJames == 90.0f){
                        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepalaJames),0.0f,0.0f,1.0f);
                    }else if(currentBodyDegreeJames == 180.0f){
                        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepalaJames),0.0f,0.0f,1.0f);
                    }else if(currentBodyDegreeJames == 270.0f){
                        objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepalaJames),0.0f,0.0f,1.0f);
                    }
                    objekjames.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(x1, x2, x3);
                    degreekepalaJames += countDegKepalaJames;

                    //gerakan tangan
                    if(degreetanganJames >= 135f){
                        countDegTanganJames = 0f;
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
                    if(currentBodyDegreeJames == 0.0f || currentBodyDegreeJames == 360.0f){
                        objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
                        objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
                    }if(currentBodyDegreeJames == 90.0f){
                        objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
                        objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
                    }else if(currentBodyDegreeJames == 180.0f){
                        objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
                        objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
                    }else if(currentBodyDegreeJames == 270.0f){
                        objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
                        objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
                    }
                    objekjames.get(0).getChildObject().get(1).translateObject(x1, x2, x3);
                    objekjames.get(0).getChildObject().get(2).translateObject(x4, x5, x6);
                    degreetanganJames += countDegTanganJames;

                    if(currentBodyDegreeJames != 0){
                        objekjames.get(0).rotateObject((float)Math.toRadians(currentBodyDegreeJames),0.0f,1.0f,0.0f);
                    }
                }
                isPressedJames = false;
            }
        }
        timerkeyAksi2James +=0.1f;
        if(timerkeyAksi2James > 0.1f){
            timerkeyAksi2James = -30f;
        }
        if(!keyNaikDitekanJames && timerkeyAksi2James > 0){
            aksi2James =true;
        }
        //turunin tangan
        if(aksi2James){
            keyTurunDitekanJames = false;
            keyNaikDitekanJames = true;

            if(currentBodyDegreeJames != 0){
                objekjames.get(0).rotateObject((float)Math.toRadians(-currentBodyDegreeJames),0.0f,1.0f,0.0f);
            }

            objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getDerajat();

            if(degreekepalaJames <= 0f){
                countDegKepalaJames = 0f;
            }else if(degreekepalaJames <= 36f){
                countDegKepalaJames = -1.5f;
            }
//            System.out.println("degreekepala: "+degreekepala+"   count deg kepala:"+countDegKepala);
            //gerakkan kepala ke bawah
            float x1 = objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,0);
            float x2 = objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,1);
            float x3 = objekjames.get(0).getChildObject().get(0).getChildObject().get(0).getMatrix().get(3,2);
            objekjames.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-x1, -x2, -x3);
//            System.out.println(currentBodyDegree);
            if(currentBodyDegreeJames == 0.0f || currentBodyDegreeJames == 360.0f){
                objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepalaJames),0.0f,0.0f,1.0f);
            }if(currentBodyDegreeJames == 90.0f){
                objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepalaJames),0.0f,0.0f,1.0f);
            }else if(currentBodyDegreeJames == 180.0f){
                objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepalaJames),0.0f,0.0f,1.0f);
            }else if(currentBodyDegreeJames == 270.0f){
                objekjames.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(countDegKepalaJames),0.0f,0.0f,1.0f);
            }
            objekjames.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(x1, x2, x3);
            degreekepalaJames += countDegKepalaJames;

            //gerakan tangan
            if(degreetanganJames <= 0f){
                countDegTanganJames = 0f;
            }else if(degreetanganJames <= 135f){
                countDegTanganJames = -1.5f;
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
            if(currentBodyDegreeJames == 0.0f || currentBodyDegreeJames == 360.0f){
                objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
                objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
            }if(currentBodyDegreeJames == 90.0f){
                objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
                objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
            }else if(currentBodyDegreeJames == 180.0f){
                objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
                objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
            }else if(currentBodyDegreeJames == 270.0f){
                objekjames.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
                objekjames.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(countDegTanganJames), 0.0f, 0.0f, 1.0f);
            }
            objekjames.get(0).getChildObject().get(1).translateObject(x1, x2, x3);
            objekjames.get(0).getChildObject().get(2).translateObject(x4, x5, x6);
            degreetanganJames += countDegTanganJames;

            if(currentBodyDegreeJames != 0){
                objekjames.get(0).rotateObject((float)Math.toRadians(currentBodyDegreeJames),0.0f,1.0f,0.0f);
            }
            if(degreetanganJames <=0f && degreekepalaJames <= 0){
                keyNaikDitekanJames = true;
                keyTurunDitekanJames = true;
                aksi2James = false;
                countDegKepalaJames = 1.5f;
                degreekepalaJames = 0f;
                countDegTanganJames = 1.5f;
                degreetanganJames = 0f;
            }
        }

        //aksi 1 - gerak kaki ke depan
        if(!window.isKeyPressed(GLFW_KEY_G)){
            isPressedJames = false;
        }
        if(window.isKeyPressed(GLFW_KEY_G)){
            if(!isPressedJames){
                isPressedJames = true;

                if (currentDegJames >= 36f){
                    countDegJames = -1.5f;
                    directionXJames = -1f;
                } else if (currentDegJames <= -36f){
                    countDegJames =  1.5f;
                    directionXJames = 1f;
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
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(1.5f), directionXJames,0.0f,0.0f);
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(x1,x2,x3);

                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-x4,-x5,-x6);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(-1.5f), directionXJames,0.0f,0.0f);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(x4,x5,x6);

                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(true);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(true);

                objekjames.get(0).translateObject(0.0f, 0.0f, 0.0005f);
                Vector3f temp = objekjames.get(0).getUpdateCenterPoint();
                objekjames.get(0).translateObject(-temp.x, -temp.y, -temp.z);

                switch (stateJames){
                    case 1:
                        directionBodyXJames = 0.0f;
                        directionBodyYJames = 1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJames, directionBodyYJames, 0.0f);
                        break;
                    case 2:
                        directionBodyXJames = 0.0f;
                        directionBodyYJames = -1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(180f), directionBodyXJames, directionBodyYJames, 0.0f);
                        break;
                    case 3:
                        directionBodyXJames = 0.0f;
                        directionBodyYJames = -1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJames, directionBodyYJames, 0.0f);
                        break;
                }
                stateJames = 0;
                objekjames.get(0).translateObject(temp.x, temp.y, temp.z);
                currentBodyDegreeJames = currentBodyDegreeJames + (270f - currentBodyDegreeJames);
                currentDegJames += countDegJames;

                //set exclude balik normal
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(false);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(false);
                isPressedJames = false;
            }
        }
        if(!window.isKeyPressed(GLFW_KEY_T)){
            isPressedJames = false;
        }
        if(window.isKeyPressed(GLFW_KEY_T)){
            if(!isPressedJames){
                isPressedJames = true;
                if (currentDegJames >= 35f){
                    countDegJames = -1.5f;
                    directionXJames = -1f;
                } else if (currentDegJames <= -35f){
                    countDegJames =  1.5f;
                    directionXJames = 1f;
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
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(1.5f), directionXJames,0.0f,0.0f);
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(x1,x2,x3);

                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-x4,-x5,-x6);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(-1.5f), directionXJames,0.0f,0.0f);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(x4,x5,x6);

                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(true);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(true);

                objekjames.get(0).translateObject(0.0f, 0.0f, -0.0005f);
                Vector3f temp = objekjames.get(0).getUpdateCenterPoint();
                objekjames.get(0).translateObject(-temp.x, -temp.y, -temp.z);

                switch (stateJames){
                    case 0:
                        directionBodyXJames = 0.0f;
                        directionBodyYJames = 1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(180f), directionBodyXJames, directionBodyYJames, 0.0f);
                        break;
                    case 1:
                        directionBodyXJames = 0.0f;
                        directionBodyYJames = -1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJames, directionBodyYJames, 0.0f);
                        break;
                    case 3:
                        directionBodyXJames = 0.0f;
                        directionBodyYJames = 1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJames, directionBodyYJames, 0.0f);
                        break;
                }
                stateJames = 2;
                objekjames.get(0).translateObject(temp.x, temp.y, temp.z);
                currentBodyDegreeJames = currentBodyDegreeJames + (90f - currentBodyDegreeJames);
                currentDegJames += countDegJames;

                //set exclude balik normal
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(false);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(false);
                isPressedJames = false;
            }
        }
        if(!window.isKeyPressed(GLFW_KEY_F)){
            isPressedJames = false;
        }
        if (window.isKeyPressed(GLFW_KEY_F)){
            if (!isPressedJames) {
                isPressedJames = true;
                if (currentDegJames >= 35f) {
                    countDegJames = -1.5f;
                    directionXJames = -1f;
                } else if (currentDegJames <= -35f) {
                    countDegJames = 1.5f;
                    directionXJames = 1f;
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
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,0.0f, directionXJames);
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(x1,x2,x3);

                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-x4,-x5,-x6);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(-1.5f),0.0f,0.0f, directionXJames);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(x4,x5,x6);

//                set exclude kaki dari rotate
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(true);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(true);

                objekjames.get(0).translateObject(-0.0005f, 0.0f, 0.0f);
                Vector3f temp = objekjames.get(0).getUpdateCenterPoint();
                objekjames.get(0).translateObject(-temp.x, -temp.y, -temp.z);
                // state 0 = S, 1 = A, 2 = W, 3 = D
                switch (stateJames){
                    case 0:
                        directionBodyXJames = 0.0f;
                        directionBodyYJames = -1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJames, directionBodyYJames, 0.0f);
                        break;
                    case 2:
                        directionBodyXJames = 0.0f;
                        directionBodyYJames = 1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJames, directionBodyYJames, 0.0f);
                        break;
                    case 3:
                        directionBodyXJames = 0.0f;
                        directionBodyYJames = -1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(180f), directionBodyXJames, directionBodyYJames, 0.0f);
                        break;
                }
                stateJames = 1;
                objekjames.get(0).translateObject(temp.x, temp.y, temp.z);
                currentBodyDegreeJames = currentBodyDegreeJames + (180f - currentBodyDegreeJames);
                currentDegJames += countDegJames;

////                set exclude balik normal
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(false);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(false);
                isPressedJames = false;
            }
        }
        if(!window.isKeyPressed(GLFW_KEY_H)){
            isPressedJames = false;
        }
        if (window.isKeyPressed(GLFW_KEY_H)){
            if (!isPressedJames) {
                isPressedJames = true;
                if (currentDegJames >= 35f) {
                    countDegJames = -1.5f;
                    directionXJames = -1f;
                } else if (currentDegJames <= -35f) {
                    countDegJames = 1.5f;
                    directionXJames = 1f;
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
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,0.0f, directionXJames);
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(x1,x2,x3);

                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-x4,-x5,-x6);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(-1.5f),0.0f,0.0f, directionXJames);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(x4,x5,x6);

//                set exclude kaki dari rotate
                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(true);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(true);

                objekjames.get(0).translateObject(0.0005f, 0.0f, 0.0f);
                Vector3f temp = objekjames.get(0).getUpdateCenterPoint();
                objekjames.get(0).translateObject(-temp.x, -temp.y, -temp.z);
                // state 0 = S, 1 = A, 2 = W, 3 = D
                switch (stateJames){
                    case 0:
                        directionBodyXJames = 0.0f;
                        directionBodyYJames = 1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJames, directionBodyYJames, 0.0f);
                        break;
                    case 1:
                        directionBodyXJames = 0.0f;
                        directionBodyYJames = 1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(180f), directionBodyXJames, directionBodyYJames, 0.0f);
                        break;
                    case 2:
                        directionBodyXJames = 0.0f;
                        directionBodyYJames = -1.0f;
                        objekjames.get(0).rotateObject((float)Math.toRadians(90f), directionBodyXJames, directionBodyYJames, 0.0f);
                        break;
                }
                stateJames = 3;
                objekjames.get(0).translateObject(temp.x, temp.y, temp.z);
                currentBodyDegreeJames = currentBodyDegreeJames + (360f - currentBodyDegreeJames);
                currentDegJames += countDegJames;

                objekjames.get(0).getChildObject().get(3).getChildObject().get(0).setExclude(false);
                objekjames.get(0).getChildObject().get(4).getChildObject().get(0).setExclude(false);
                isPressedJames = false;
            }
        }

        //KEY AKSI JANE
        //bergerak jalan ke kiri
        if (window.isKeyPressed(GLFW_KEY_Z)){
            objectJane.get(0).translateObject(-0.0006f,-0.0001f,0.0001f);
        }

        //putar balik --> sama seperti berputar pada sumbu Y
        if (window.isKeyPressed(GLFW_KEY_X)){
            objectJane.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
        }

        //bergerak jalan ke kanan
        if (window.isKeyPressed(GLFW_KEY_C)){
            objectJane.get(0).translateObject(0.0006f,-0.0001f,0.0001f);
        }

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
            for(ObjectJames objectJames : objekjames){
                objectJames.draw(camera,projection);
            }

            for(ObjectJohan objectJohan : objectJohans){
                objectJohan.draw(camera,projection);
            }

            for(ObjectJane object: objectJane){
                object.draw(camera,projection);

            }

//            for(ObjectJames lingkungan : enviromentJames){
//                lingkungan.draw(camera,projection);
//            }



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
        new ProjekGabungan().run();
    }
}