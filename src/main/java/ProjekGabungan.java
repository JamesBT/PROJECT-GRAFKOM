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
    private ArrayList<ObjectJames> objekBurger = new ArrayList<>();
    private ArrayList<ObjectJames> enviromentMrKrab = new ArrayList<>();
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

    boolean bawaburger = false;
    //function Johan
    private ArrayList<ObjectJohan> objectJohans = new ArrayList<>();
    private ArrayList<ObjectJohan> enviromentJohans = new ArrayList<>();
    float directionBodyXJohan = 0f, directionBodyYJohan = -1f;
    float currentBodyDegreeJohan = 270f;
    float currentDegJohan = 0.0f, countDegJohan = 3.5f;
    float directionXJohan = 1f, directionYJohan = 1f;
    float currentHighJohan = 0f;
    int stateJohan = 2;
    boolean isPressableJohan = true;

    //function Jane
    private ArrayList<ObjectJane> objectJane = new ArrayList<>();
    int countDegreeJane = 0;
    private ArrayList<ObjectJane> environmentLabJane = new ArrayList<>();




    //function angel
    private ArrayList<ObjectAngel> objectAngels = new ArrayList<>();
    private ArrayList<ObjectAngel> enviromentAngel = new ArrayList<>();
    public void init(){
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        camera.setPosition(0,0,2.5f);
        camera.setRotation((float)Math.toRadians(30.0f),(float)Math.toRadians(0.0f));

        // OBJEK JAMES ======================================================================================================

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
        objectJohans.add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -0.175f,0.175f, 0.5f, 1
        ));
        objectJohans.get(0).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).rotateObject((float) Math.toRadians(-90f),0.0f,0.0f,1.0f);
        objectJohans.get(0).rotateObject((float) Math.toRadians(45f),0.0f,1.0f,0.0f);

        // Half sphere Atas
        objectJohans.get(0).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                -0.175f,
                0.175f,
                0.175f,
                100,
                100, 1
        ));
        objectJohans.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).translateObject(0.0f,-0.02f,0.0f);

        // Half sphere bawah
        objectJohans.get(0).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f),
                Arrays.asList(0.0f,0.0f,2.0f),
                -0.175f,
                0.175f,
                0.175f,
                100,
                100, 1
        ));
        objectJohans.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(-180f),0.0f,0.0f,1.0f);
        objectJohans.get(0).getChildObject().get(1).translateObject(0.0f,1.5f,0.0f);

//        Engsel kaki kiri
        objectJohans.get(0).getChildObject().get(1).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                -0.05f,
                0.05f,
                0.05f,
                100,
                100, 5
        ));
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(-0.07f,-0.6f,0.0f);
//   Kaki kiri
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                -0.175f,
                0.175f,
                0.175f,
                100,
                100, 2
        ));
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(-0.13f/2,-1.6f/2,0.0f);

//        Engsel kaki kanan
        objectJohans.get(0).getChildObject().get(1).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                -0.05f,
                0.05f,
                0.05f,
                100,
                100, 5
        ));
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).translateObject(0.07f,-0.6f,0.0f);
//  kaki kanan
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                -0.175f,
                0.175f,
                0.175f,
                100,
                100, 2
        ));
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(1).getChildObject().get(1).getChildObject().get(0).translateObject(0.13f/2,-1.6f/2,0.0f);

//        Engsel Tangan Kanan
        objectJohans.get(0).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                -0.05f/2,
                0.05f/2,
                0.05f/2,
                100,
                100, 5
        ));
        objectJohans.get(0).getChildObject().get(2).translateObject(-0.6f,0.0f,-2.2f);
        objectJohans.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(45f),0.0f,0.0f,1.0f);
        objectJohans.get(0).getChildObject().get(2).translateObject(-1.0f,1.7f,0.0f);

//        Tangan kanan
        objectJohans.get(0).getChildObject().get(2).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                -0.175f,
                0.175f,
                0.175f,
                100,
                100, 2
        ));
        objectJohans.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-0.6f,0.0f,-1.2f);
        objectJohans.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float) Math.toRadians(45f),0.0f,0.0f,1.0f);
        objectJohans.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-0.1f,0.78f,0.0f);
        //        Engsel Tangan Kiri
        objectJohans.get(0).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                -0.05f/2,
                0.05f/2,
                0.05f/2,
                100,
                100, 5
        ));
        objectJohans.get(0).getChildObject().get(3).translateObject(-0.6f,0.0f,-2.2f);
        objectJohans.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(45f),0.0f,0.0f,1.0f);
        objectJohans.get(0).getChildObject().get(3).translateObject(-1.0f,1.7f,0.0f);
        objectJohans.get(0).getChildObject().get(3).scaleObject(-1.0f, 1.0f, 1.0f);


//        Tangan kiri
        objectJohans.get(0).getChildObject().get(3).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)41/255,(float)126/255,(float)79/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                -0.175f,
                0.175f,
                0.175f,
                100,
                100, 2
        ));
        objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-0.6f,0.0f,-1.2f);
        objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float) Math.toRadians(45f),0.0f,0.0f,1.0f);
        objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-0.1f,0.78f,0.0f);
        objectJohans.get(0).getChildObject().get(3).getChildObject().get(0).scaleObject(-1.0f, 1.0f, 1.0f);

//        MATA bagian luar
        objectJohans.get(0).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)234/255,(float)245/255,(float)52/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                -0.1f,
                0.05f,
                0.1375f,
                100,
                100, 3
        ));
        objectJohans.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(4).translateObject(0.0f,-0.1f,0.2f);
//        MATA bagian dalam
        objectJohans.get(0).getChildObject().get(4).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)198/255,(float)35/255,(float)26/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                -0.0375f,
                0.01875f,
                0.055f,
                100,
                100, 3
        ));
        objectJohans.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(0.0f,-0.1f,0.24f);

        //        MATA bagian dalam - 2
        objectJohans.get(0).getChildObject().get(4).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)243/255,(float)150/255,(float)126/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                -0.0375f/3,
                0.01875f/3,
                0.055f/3,
                100,
                100, 3
        ));
        objectJohans.get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float) Math.toRadians(-90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(4).getChildObject().get(1).translateObject(0.0f,-0.08f,0.26f);


//        Antena kiri
        objectJohans.get(0).getChildObject().get(0).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)12/255,(float)80/255,(float)40/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.01f/2,
                0.01f/2,
                0.25f/2,
                100,
                100, 4
        ));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-0.15f/2,1.4f/2,0.0f);

//        antena kanan
        objectJohans.get(0).getChildObject().get(0).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)12/255,(float)80/255,(float)40/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.01f/2,
                0.01f/2,
                0.25f/2,
                100,
                100, 4
        ));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(90f),1.0f,0.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-0.15f/2,1.4f/2,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(-1.0f, 1.0f, 1.0f);


//        ATRIBUT ANTENA - 1
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                0.05f/2,0.025f/2, 0.2f/2, 1
        ));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.05f/2,0.5f/2,0.0f);

//        Atribut antena - 2
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                0.05f/2,0.025f/2, 0.2f/2, 1
        ));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1).translateObject(0.05f/2,0.8f/2,0.0f);

//        Atribut Antena - 3
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                0.05f/2,0.025f/2, 0.2f/2, 1
        ));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).translateObject(0.05f/2,1.1f/2,0.0f);

//        MIRORRING KE KIRI
        //        ATRIBUT ANTENA - 1
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                0.05f/2,0.025f/2, 0.2f/2, 1
        ));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.05f/2,0.5f/2,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(-1.0f, 1.0f, 1.0f);

//        Atribut antena - 2
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                0.05f/2,0.025f/2, 0.2f/2, 1
        ));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.05f/2,0.8f/2,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(-1.0f, 1.0f, 1.0f);

//        Atribut Antena - 3
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)0/255,(float)0/255,(float)0/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                0.05f/2,0.025f/2, 0.2f/2, 1
        ));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.05f/2,1.1f/2,0.0f);
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(-1.0f, 1.0f, 1.0f);

        //      Alis
        objectJohans.get(0).getChildObject().get(0).getChildObject().add(new ObjectJohan(
                Arrays.asList(
                        //Nama file disini bisa di custom (yang bagian secene.vart atau scene.frag)
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                new ArrayList<>()
                ,new Vector4f(0.0f, 0.0f, 0.0f, 1.0f)
        ));

        objectJohans.get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(-0.15f/2, 0.15f/2, 0.3f/2));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(0.0f, 0.25f/2, 0.3f/2));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(0.15f/2, 0.15f/2, 0.3f/2));
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(2).updateCurve(objectJohans.get(0).getChildObject().get(0).getChildObject().get(2).getVertices());
        objectJohans.get(0).getChildObject().get(0).getChildObject().get(2).setThickness(10);

        //        Mulut
        objectJohans.get(0).getChildObject().add(new ObjectJohan(
                Arrays.asList(
                        //Nama file disini bisa di custom (yang bagian secene.vart atau scene.frag)
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                new ArrayList<>()
                ,new Vector4f(0.0f, 0.0f, 0.0f, 1.0f)
        ));

        objectJohans.get(0).getChildObject().get(5).addVertices(new Vector3f(-0.2f/2, -0.5f/2, 0.35f/2));
        objectJohans.get(0).getChildObject().get(5).addVertices(new Vector3f(0.0f/2, -0.7f/2, 0.35f/2));
        objectJohans.get(0).getChildObject().get(5).addVertices(new Vector3f(0.2f/2, -0.5f/2, 0.35f/2));
        objectJohans.get(0).getChildObject().get(5).updateCurve(objectJohans.get(0).getChildObject().get(5).getVertices());
        objectJohans.get(0).getChildObject().get(5).setThickness(5);

        //BUAT PINDAHIN OBJEK JOHAN KE KIRI
        objectJohans.get(0).translateObject(-2.0f,-0.3f,0f);

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
        objectJane.get(0).translateObject(0.5f,-1f,0.0f);

        //OBJEK ANGELINA ====================================================================================

        objectAngels.add(new SpongeAngel( //kotak sponge
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.3f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.6f,
                0.3f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().add(new LineAngel(   //c1 garis sponge
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,0.9f,0.15f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.6f,
                0.3f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().add(new SphereAngel( //c2 mata kiri
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.07f,0.05f,0.15f),
                0.07f,
                0.08f,
                0.03f,
                36,
                36
        ));
        objectAngels.get(0).getChildObject().add(new SphereAngel( //c3 iris mata kiri
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.4f,1.0f,1.0f),
                Arrays.asList(0.07f,0.04f,0.17f),
                0.035f,
                0.04f,
                0.015f,
                36,
                36
        ));
        objectAngels.get(0).getChildObject().add(new SphereAngel( //c4 pupil mata kiri
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.07f,0.04f,0.18f),
                0.015f,
                0.02f,
                0.007f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().add(new SphereAngel( //c5 mata kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(-0.07f,0.05f,0.15f),
                0.07f,
                0.08f,
                0.03f,
                36,
                36
        ));
        objectAngels.get(0).getChildObject().add(new SphereAngel( //c6 iris mata kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.4f,1.0f,1.0f),
                Arrays.asList(-0.07f,0.04f,0.17f),
                0.035f,
                0.04f,
                0.015f,
                36,
                36
        ));
        objectAngels.get(0).getChildObject().add(new SphereAngel( //c7 pupil mata kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(-0.07f,0.04f,0.18f),
                0.015f,
                0.02f,
                0.007f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().add(new SpongeAngel( //c8 hem putih
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,-0.33f,0.0f),
                0.5f,
                0.07f,
                0.3f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().add(new SpongeAngel( //c9 celana coklat
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f,0.4f,0.15f,1.0f),
                Arrays.asList(0.0f,-0.4f,0.0f),
                0.5f,
                0.1f,
                0.3f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().add(new CylinderAngel(   //c10 celana coklat kiri
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f,0.4f,0.15f,1.0f),
                Arrays.asList(0.0f,-0.3f,0.0f),
                0.1f,
                0.07f,
                0.1f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().get(9).translateObject(0.0f,0.3f,0.0f);
        objectAngels.get(0).getChildObject().get(9).rotateObject((float)Math.toRadians(90.0f),1.0f,0f,0f);
        objectAngels.get(0).getChildObject().get(9).translateObject(0.15f,-0.45f,0.0f);
        objectAngels.get(0).getChildObject().get(9).scaleObject(0.8f,1.0f,0.8f);

        objectAngels.get(0).getChildObject().add(new CylinderAngel(   //c11 celana coklat kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f,0.4f,0.15f,1.0f),
                Arrays.asList(0.0f,-0.3f,0.0f),
                0.1f,
                0.07f,
                0.1f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().get(10).translateObject(0.0f,0.3f,0.0f);
        objectAngels.get(0).getChildObject().get(10).rotateObject((float)Math.toRadians(90.0f),1.0f,0f,0f);
        objectAngels.get(0).getChildObject().get(10).translateObject(-0.15f,-0.45f,0.0f);
        objectAngels.get(0).getChildObject().get(10).scaleObject(0.8f,1.0f,0.8f);

        objectAngels.get(0).getChildObject().add(new CylinderAngel(   //c12 kaki kiri
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.3f,1.0f),
                Arrays.asList(0.0f,-0.5f,0.0f),
                0.035f,
                0.1f,
                0.035f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().get(11).translateObject(0.0f,0.5f,0.0f);
        objectAngels.get(0).getChildObject().get(11).rotateObject((float)Math.toRadians(90.0f),1.0f,0f,0f);
        objectAngels.get(0).getChildObject().get(11).translateObject(-0.12f,-0.5f,0.0f);
        objectAngels.get(0).getChildObject().add(new CylinderAngel(   //c13 kaki kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.3f,1.0f),
                Arrays.asList(0.0f,-0.5f,0.0f),
                0.035f,
                0.1f,
                0.035f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().get(12).translateObject(0.0f,0.5f,0.0f);
        objectAngels.get(0).getChildObject().get(12).rotateObject((float)Math.toRadians(90.0f),1.0f,0f,0f);
        objectAngels.get(0).getChildObject().get(12).translateObject(0.12f,-0.5f,0.0f);
        objectAngels.get(0).getChildObject().add(new CylinderAngel(   //c14 kaos kaki kiri
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,-0.6f,0.0f),
                0.0355f,
                0.11f,
                0.0355f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().get(13).translateObject(0.0f,0.6f,0.0f);
        objectAngels.get(0).getChildObject().get(13).rotateObject((float)Math.toRadians(90.0f),1.0f,0f,0f);
        objectAngels.get(0).getChildObject().get(13).translateObject(0.12f,-0.6f,0.0f);
        objectAngels.get(0).getChildObject().add(new CylinderAngel(   //c15 kaos kaki kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,-0.6f,0.0f),
                0.0355f,
                0.11f,
                0.0355f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().get(14).translateObject(0.0f,0.6f,0.0f);
        objectAngels.get(0).getChildObject().get(14).rotateObject((float)Math.toRadians(90.0f),1.0f,0f,0f);
        objectAngels.get(0).getChildObject().get(14).translateObject(-0.12f,-0.6f,0.0f);
        objectAngels.get(0).getChildObject().add(new ConeAngel(   //c16 lengan tangan kiri
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().get(15).scaleObject(0.015f,0.01f,0.08f);
        objectAngels.get(0).getChildObject().get(15).rotateObject((float)Math.toRadians(90.0f),1.0f,0f,0f);
        objectAngels.get(0).getChildObject().get(15).rotateObject((float)Math.toRadians(30.0f),0.0f,0f,1.0f);
        objectAngels.get(0).getChildObject().get(15).translateObject(0.2f,0.0f,0.0f);
        objectAngels.get(0).getChildObject().add(new CylinderAngel(   //c17 tangan kiri
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.3f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.025f,
                0.15f,
                0.025f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().get(16).rotateObject((float)Math.toRadians(90.0f),1.0f,0f,0f);
        objectAngels.get(0).getChildObject().get(16).rotateObject((float)Math.toRadians(30.0f),0.0f,0f,1.0f);
        objectAngels.get(0).getChildObject().get(16).translateObject(0.3f,-0.2f,0.0f);
        objectAngels.get(0).getChildObject().add(new SphereAngel(   //c18 gloves hand kiri
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.42f,-0.35f,0.0f),
                0.07f,
                0.035f,
                0.04f,
                36,
                24
        ));
        objectAngels.get(0).getChildObject().get(17).translateObject(-0.42f,0.35f,0.0f);
        objectAngels.get(0).getChildObject().get(17).rotateObject((float)Math.toRadians(-50.0f),0.0f,0f,1.0f);
        objectAngels.get(0).getChildObject().get(17).translateObject(0.4f,-0.36f,0.0f);
        objectAngels.get(0).getChildObject().add(new SphereAngel(   //c19 gloves thumb kiri
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.5f,-0.4f,0.0f),
                0.045f,
                0.02f,
                0.02f,
                36,
                24
        ));
        objectAngels.get(0).getChildObject().get(18).translateObject(-0.5f,0.4f,0.0f);
        objectAngels.get(0).getChildObject().get(18).rotateObject((float)Math.toRadians(-50.0f),0.0f,0f,1.0f);
        objectAngels.get(0).getChildObject().get(18).rotateObject((float)Math.toRadians(-50.0f),1.0f,0f,0.0f);
        objectAngels.get(0).getChildObject().get(18).translateObject(0.42f,-0.35f,0.04f);

        objectAngels.get(0).getChildObject().add(new ConeAngel(   //c20 lengan tangan kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().get(19).scaleObject(0.015f,0.015f,0.08f);
        objectAngels.get(0).getChildObject().get(19).rotateObject((float)Math.toRadians(-90.0f),1.0f,0f,0f);
        objectAngels.get(0).getChildObject().get(19).rotateObject((float)Math.toRadians(90.0f),0.0f,0f,1.0f);
        objectAngels.get(0).getChildObject().get(19).translateObject(-0.15f,-0.1f,0.0f);
        objectAngels.get(0).getChildObject().add(new CylinderAngel(   //c21 lengan atas tangan kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.3f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.025f,
                0.125f,
                0.025f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().get(20).rotateObject((float)Math.toRadians(90.0f),0.0f,1.0f,0f);
        objectAngels.get(0).getChildObject().get(20).translateObject(-0.5f,-0.1f,0.0f);
        objectAngels.get(0).getChildObject().add(new SphereAngel(   //c22 engsel tangan kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.3f,1.0f),
                Arrays.asList(-0.5f,-0.1f,0.0f),
                0.025f,
                0.025f,
                0.025f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().get(21).getChildObject().add(new CylinderAngel(   //c23 lengan bawah kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.3f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.025f,
                0.145f,
                0.025f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().get(21).getChildObject().get(0).rotateObject((float)Math.toRadians(90.0f),0.0f,1.0f,0f);
        objectAngels.get(0).getChildObject().get(21).getChildObject().get(0).translateObject(-0.65f,-0.1f,0.0f);
        objectAngels.get(0).getChildObject().get(21).getChildObject().add(new SphereAngel(   //c24 gloves hand kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                Arrays.asList(-0.68f,-0.1f,0.0f),
                0.07f,
                0.035f,
                0.04f,
                36,
                24
        ));
        objectAngels.get(0).getChildObject().get(21).getChildObject().get(1).translateObject(0.68f,0.1f,0.0f);
        objectAngels.get(0).getChildObject().get(21).getChildObject().get(1).rotateObject((float)Math.toRadians(90.0f),1.0f,0f,0.0f);
        objectAngels.get(0).getChildObject().get(21).getChildObject().get(1).translateObject(-0.68f,-0.1f,0.0f);
        objectAngels.get(0).getChildObject().get(21).getChildObject().add(new SphereAngel(   //c25 gloves thumb kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                Arrays.asList(-0.68f,-0.05f,0.0f),
                0.045f,
                0.02f,
                0.02f,
                36,
                24
        ));
        objectAngels.get(0).getChildObject().get(21).getChildObject().get(2).translateObject(0.68f,0.05f,0.0f);
        objectAngels.get(0).getChildObject().get(21).getChildObject().get(2).rotateObject((float)Math.toRadians(-55.0f),0.0f,0f,1.0f);
        objectAngels.get(0).getChildObject().get(21).getChildObject().get(2).translateObject(-0.65f,-0.06f,0.0f);

        objectAngels.get(0).getChildObject().add(new CylinderAngel(   //c26 batang hidung
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.3f,1.0f),
                Arrays.asList(0.0f,0.0f,3.0f),
                0.02f,
                0.28f,
                0.02f,
                36,
                18
        ));
        objectAngels.get(0).getChildObject().add(new SphereAngel(   //c27 ujung hidung
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.3f,1.0f),
                Arrays.asList(0.0f,0.0f,0.28f),
                0.02f,
                0.02f,
                0.02f,
                36,
                18
        ));

        objectAngels.get(0).getChildObject().add(new SphereAngel(   //c28 sepatu kiri
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.12f,-0.73f,0.04f),
                0.04f,
                0.03f,
                0.1f,
                36,
                48
        ));

        objectAngels.get(0).getChildObject().add(new SphereAngel(   //c29 sepatu kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                Arrays.asList(-0.12f,-0.73f,0.04f),
                0.04f,
                0.03f,
                0.1f,
                36,
                48
        ));

        objectAngels.get(0).getChildObject().add(new ObjectAngel(    //c30 mulut
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                new ArrayList<>()
                ,new Vector4f(1.0f, 1.0f, 1.0f, 1.0f)
        ));
        objectAngels.get(0).getChildObject().get(26).addVertices(new Vector3f(-0.2f, -0.1f, 0.3f));
        objectAngels.get(0).getChildObject().get(26).addVertices(new Vector3f(-0.1f, -0.2f, 0.3f));
        objectAngels.get(0).getChildObject().get(26).addVertices(new Vector3f(0f, -0.25f, 0.3f));
        objectAngels.get(0).getChildObject().get(26).addVertices(new Vector3f(0.1f, -0.2f, 0.3f));
        objectAngels.get(0).getChildObject().get(26).addVertices(new Vector3f(0.2f, -0.1f, 0.3f));

        objectAngels.get(0).getChildObject().get(26).updateCurve(objectAngels.get(0).getChildObject().get(26).getVertices());
        objectAngels.get(0).getChildObject().get(26).setThickness(5);

        objectAngels.get(0).translateObject(2.0f,0.0f,0.0f);


//        objekjames.get(0).translateObject(1.275f,-28f,-12.5f);
        //ENVIROMENT
        //KRABBY PATTY

//enviroment
//        dataran
        enviromentJohans.add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.8901960784f,0.9176470588f,0.7764705882f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                15.5f,
                15.5f, 0.5f,
                36,
                18,
                6
        ));

        enviromentJohans.get(0).scaleObject(5.0f,5.0f,0.5f);
        enviromentJohans.get(0).translateObject(0.0f,0.0f,1.25f);
        enviromentJohans.get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);

        //batu kanan (1)
        enviromentJohans.get(0).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3254901961f,0.4196078431f,0.3882352941f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18,
                5
        ));
        enviromentJohans.get(0).getChildObject().get(0).scaleObject(0.5f,0.5f,0.5f);
        enviromentJohans.get(0).getChildObject().get(0).translateObject(1.6f,-1.2f,0.00f);

        //batu kanan (2)
        enviromentJohans.get(0).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3254901961f,0.4196078431f,0.3882352941f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18,
                5
        ));
        enviromentJohans.get(0).getChildObject().get(1).scaleObject(0.5f,0.5f,0.5f);
        enviromentJohans.get(0).getChildObject().get(1).translateObject(-1.6f,-1.2f,0.00f);

        //batu kanan (3)
        enviromentJohans.get(0).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3254901961f,0.4196078431f,0.3882352941f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18,
                5
        ));
        enviromentJohans.get(0).getChildObject().get(2).scaleObject(0.5f,0.5f,0.5f);
        enviromentJohans.get(0).getChildObject().get(2).translateObject(-1.6f/2,-1.2f,-1.3f);

        //batu kanan (4)
        enviromentJohans.get(0).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3254901961f,0.4196078431f,0.3882352941f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18,
                5
        ));
        enviromentJohans.get(0).getChildObject().get(3).scaleObject(0.5f,0.5f,0.5f);
        enviromentJohans.get(0).getChildObject().get(3).translateObject(1.6f/2,-1.2f,-1.3f);

        //        Krusty krab
        enviromentJohans.add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)84/255,(float)67/255,(float)39/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -5.175f,5.2f, 10.5f, 2
        ));

        enviromentJohans.get(1).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        enviromentJohans.get(1).translateObject(-3.0f,-1.1f,-15.0f);

//         sisi kiri
        enviromentJohans.get(1).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)100/255,(float)95/255,(float)60/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -6.175f,6.2f, 0.5f, 2
        ));

        enviromentJohans.get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        enviromentJohans.get(1).getChildObject().get(0).translateObject(-3.5f,-1.1f,-15.0f);

//         sisi kanan
        enviromentJohans.get(1).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)100/255,(float)95/255,(float)60/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -6.175f,6.2f, 0.5f, 2
        ));

        enviromentJohans.get(1).getChildObject().get(1).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        enviromentJohans.get(1).getChildObject().get(1).translateObject(-8.0f,-1.1f,-15.0f);
        enviromentJohans.get(1).getChildObject().get(1).scaleObject(-1.0f, 1.0f, 1.0f);

//        bagian bawah krustry krab
        enviromentJohans.get(1).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)100/255,(float)95/255,(float)60/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                4.5f,
                0.5f, 0.5f,
                36,
                18,
                6
        ));

        enviromentJohans.get(1).getChildObject().get(2).translateObject(-1.0f,-9.7f,1.0f);
        enviromentJohans.get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(90),1f,0f,0f);

//        bagian  bawah krusty krab - 2
        enviromentJohans.get(1).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)100/255,(float)95/255,(float)60/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                4.5f,
                0.5f, 0.5f,
                36,
                18,
                6
        ));

        enviromentJohans.get(1).getChildObject().get(3).translateObject(-1.0f,-9.7f,1.0f);
        enviromentJohans.get(1).getChildObject().get(3).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(1).getChildObject().get(3).translateObject(6.5f,0.0f,0.0f);

//        Pintu
        enviromentJohans.get(1).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)82/255,(float)176/255,(float)224/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                2.0f,
                0.2f, 2.0f,
                36,
                18,
                6
        ));

        enviromentJohans.get(1).getChildObject().get(4).translateObject(-1.0f,-9.7f,1.0f);
        enviromentJohans.get(1).getChildObject().get(4).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(1).getChildObject().get(4).translateObject(3.25f,0.8f,0.0f);

//        jendela
        enviromentJohans.get(1).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)82/255,(float)176/255,(float)224/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                3.0f,
                0.2f, 2.0f,
                36,
                18,
                6
        ));

        enviromentJohans.get(1).getChildObject().get(5).translateObject(-1.0f,-9.7f,1.0f);
        enviromentJohans.get(1).getChildObject().get(5).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(1).getChildObject().get(5).translateObject(0f,0.8f,0.0f);

//        jendela kanan
        enviromentJohans.get(1).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)82/255,(float)176/255,(float)224/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                3.0f,
                0.2f, 2.0f,
                36,
                18,
                6
        ));

        enviromentJohans.get(1).getChildObject().get(6).translateObject(-1.0f,-9.7f,1.0f);
        enviromentJohans.get(1).getChildObject().get(6).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(1).getChildObject().get(6).translateObject(6.6f,0.8f,0.0f);

//         bundaran krusty krab
        enviromentJohans.get(1).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)93/255,(float)117/255,(float)114/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -11.2f,11.2f, 0.01f, 1
        ));
        enviromentJohans.get(1).getChildObject().get(7).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(1).getChildObject().get(7).translateObject(2.2f, -1.1f, -15.0f);

//        road path menuju chum bucket
        enviromentJohans.get(1).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)93/255,(float)117/255,(float)114/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                45.0f,
                0.01f, 2.0f,
                36,
                18,
                6
        ));
        enviromentJohans.get(1).getChildObject().get(8).translateObject(-12.0f,-1.1f,2.2f);
        enviromentJohans.get(1).getChildObject().get(8).rotateObject((float)Math.toRadians(90),0f,1f,0f);

        enviromentJohans.get(1).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)93/255,(float)117/255,(float)114/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                77.0f,
                0.01f, 2.0f,
                36,
                18,
                6
        ));
        enviromentJohans.get(1).getChildObject().get(9).translateObject(0.0f,-1.1f,2.2f);

//        Kapal squidward
//         dinding kiri
        enviromentJohans.add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)194/255,(float)222/255,(float)241/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                2.5f,
                0.2f, 2.0f,
                36,
                18,
                6
        ));

        enviromentJohans.get(2).translateObject(-1.0f,-9.7f,1.0f);
        enviromentJohans.get(2).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(2).translateObject(0.0f,0.0f,7.0f);
        enviromentJohans.get(2).rotateObject((float)Math.toRadians(-90),0f,1f,0f);
        enviromentJohans.get(2).translateObject(-3.0f,0.8f,0.0f);

//      dinding kanan
        enviromentJohans.get(2).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)194/255,(float)222/255,(float)241/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                2.5f,
                0.2f, 2.0f,
                36,
                18,
                6
        ));

        enviromentJohans.get(2).getChildObject().get(0).translateObject(-1.0f,-9.7f,1.0f);
        enviromentJohans.get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(2).getChildObject().get(0).translateObject(0.0f,0.0f,7.0f);
        enviromentJohans.get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(-90),0f,1f,0f);
        enviromentJohans.get(2).getChildObject().get(0).translateObject(0.0f,0.8f,0.0f);

//        Bagian depan kapal
        enviromentJohans.get(2).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)194/255,(float)222/255,(float)241/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                1.2f,
                2.0f, 2.0f, 3
        ));

        enviromentJohans.get(2).getChildObject().get(1).translateObject(-1.0f,-9.7f,1.0f);
        enviromentJohans.get(2).getChildObject().get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(2).getChildObject().get(1).translateObject(0.0f,0.0f,7.0f);
        enviromentJohans.get(2).getChildObject().get(1).rotateObject((float)Math.toRadians(90),0f,-1f,0f);
        enviromentJohans.get(2).getChildObject().get(1).translateObject(-1.5f,1.8f,1.8f);

//        Pindahin object ke bawah dlu
        enviromentJohans.get(2).translateObject(0.0f, -5.0f, 0.0f);

//        chumbucket
        enviromentJohans.add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)33/255,(float)65/255,(float)86/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -3.175f,3.175f, 7.5f, 4
        ));
        enviromentJohans.get(3).translateObject(0.0f, 0.0f, -2.0f);
        enviromentJohans.get(3).rotateObject((float) Math.toRadians(90f),0.0f,1.0f,0.0f);
        enviromentJohans.get(3).rotateObject((float) Math.toRadians(-90f),0.0f,0.0f,1.0f);
        enviromentJohans.get(3).rotateObject((float) Math.toRadians(45f),0.0f,1.0f,0.0f);
        enviromentJohans.get(3).rotateObject((float) Math.toRadians(180f),0.0f,0.0f,1.0f);
        enviromentJohans.get(3).translateObject(1.5f, 0.8f, 32.0f);

//        Pegangan bucket nya
        enviromentJohans.get(3).getChildObject().add(new ObjectJohan(
                Arrays.asList(
                        //Nama file disini bisa di custom (yang bagian secene.vart atau scene.frag)
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                new ArrayList<>()
                ,new Vector4f((float)33/255,(float)65/255,(float)86/255, 1.0f)
        ));

        enviromentJohans.get(3).getChildObject().get(0).addVertices(new Vector3f(-2.5f, 6.15f, 0.0f)); // kanan
        enviromentJohans.get(3).getChildObject().get(0).addVertices(new Vector3f(-1.6f, 10.75f, 0.0f));
        enviromentJohans.get(3).getChildObject().get(0).addVertices(new Vector3f(-0.8f, 10.75f, 0.0f));
        enviromentJohans.get(3).getChildObject().get(0).addVertices(new Vector3f(0.0f, 10.75f, 0.0f));
        enviromentJohans.get(3).getChildObject().get(0).addVertices(new Vector3f(0.8f, 10.75f, 0.0f));
        enviromentJohans.get(3).getChildObject().get(0).addVertices(new Vector3f(1.6f, 10.75f, 0.0f));
        enviromentJohans.get(3).getChildObject().get(0).addVertices(new Vector3f(2.4f, 10.75f, 0.0f));
        enviromentJohans.get(3).getChildObject().get(0).addVertices(new Vector3f(3.2f, 10.75f, 0.0f));
        enviromentJohans.get(3).getChildObject().get(0).addVertices(new Vector3f(4.0f, 10.75f, 0.0f));
        enviromentJohans.get(3).getChildObject().get(0).addVertices(new Vector3f(4.8f, 10.75f, 0.0f));
        enviromentJohans.get(3).getChildObject().get(0).addVertices(new Vector3f(5.5f, 6.15f, 0.0f)); // kiri
        enviromentJohans.get(3).getChildObject().get(0).updateCurve(enviromentJohans.get(3).getChildObject().get(0).getVertices());
        enviromentJohans.get(3).getChildObject().get(0).setThickness(10);
        enviromentJohans.get(3).getChildObject().get(0).translateObject(0.0f, 0.0f, 32.0f);

//        Pintu chumbucket
        enviromentJohans.get(3).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)162/255,(float)132/255,(float)57/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                2.0f,
                0.3f, 4.0f,
                36,
                36,
                6
        ));

        enviromentJohans.get(3).getChildObject().get(1).translateObject(-1.0f,-9.7f,1.0f);
        enviromentJohans.get(3).getChildObject().get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(3).getChildObject().get(1).translateObject(2.5f,0.8f,38f);

//        bagian blkg pintu
        enviromentJohans.get(3).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)33/255,(float)65/255,(float)86/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                2.0f,
                0.4f, 4.0f,
                36,
                36,
                6
        ));

        enviromentJohans.get(3).getChildObject().get(2).translateObject(-1.0f,-9.7f,1.0f);
        enviromentJohans.get(3).getChildObject().get(2).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(3).getChildObject().get(2).translateObject(2.5f,0.8f,38.3f);

        //      Ruangan dalam krusty krab
        //         lantai
        enviromentJohans.add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)101/255,(float)140/255,(float)61/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                60.0f,
                0.2f, 30.0f,
                36,
                18,
                6
        ));
        enviromentJohans.get(4).translateObject(0.0f,-30.0f,0.0f);

//        dinding belakang
        enviromentJohans.get(4).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)125/255,(float)111/255,(float)36/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                60.0f,
                0.2f, 10.5f,
                36,
                18,
                6
        ));
        enviromentJohans.get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(4).getChildObject().get(0).translateObject(0.0f,-24.7f,-15.0f);

        //        dinding depan
        enviromentJohans.get(4).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)125/255,(float)111/255,(float)36/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                60.0f,
                0.2f, 10.5f,
                36,
                18,
                6
        ));
        enviromentJohans.get(4).getChildObject().get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(4).getChildObject().get(1).translateObject(0.0f,-24.7f,-15.0f);
        enviromentJohans.get(4).getChildObject().get(1).scaleObject(1.0f,1.0f,-1.0f);

//         dinding sisi kiri
        enviromentJohans.get(4).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)111/255,(float)98/255,(float)32/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                30.0f,
                0.2f, 10.5f,
                36,
                18,
                6
        ));
        enviromentJohans.get(4).getChildObject().get(2).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(4).getChildObject().get(2).translateObject(0.0f,-24.7f,-22.5f);
        enviromentJohans.get(4).getChildObject().get(2).rotateObject((float)Math.toRadians(90),0f,1f,0f);
        enviromentJohans.get(4).getChildObject().get(2).translateObject(-7.5f,0.0f,0.0f);

        //         dinding sisi kanan
        enviromentJohans.get(4).getChildObject().add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)111/255,(float)98/255,(float)32/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                30.0f,
                0.2f, 10.5f,
                36,
                18,
                6
        ));
        enviromentJohans.get(4).getChildObject().get(3).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(4).getChildObject().get(3).translateObject(0.0f,-24.7f,-22.5f);
        enviromentJohans.get(4).getChildObject().get(3).rotateObject((float)Math.toRadians(90),0f,1f,0f);
        enviromentJohans.get(4).getChildObject().get(3).translateObject(-7.5f,0.0f,0.0f);
        enviromentJohans.get(4).getChildObject().get(3).scaleObject(-1.0f,1.0f,1.0f);

//        Meja krusty krab - 1
        enviromentJohans.add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)200/255,(float)33/255,(float)64/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -3.0f,3.0f, 0.2f, 1
        ));
        enviromentJohans.get(5).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(5).translateObject(12.0f, -28.0f, 7.0f);

// kaki meja
        enviromentJohans.get(5).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)44/255,(float)84/255,(float)151/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -0.3f,0.3f, 2.0f, 1
        ));
        enviromentJohans.get(5).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(5).getChildObject().get(0).translateObject(12.0f, -28.0f, 7.0f);

        enviromentJohans.get(5).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)255/255,(float)249/255,(float)132/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -2.3f,2.3f, 0.2f, 1
        ));
        enviromentJohans.get(5).getChildObject().get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(5).getChildObject().get(1).translateObject(12.0f, -27.95f, 7.0f);

        enviromentJohans.get(5).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)129/255,(float)163/255,(float)198/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -0.3f,0.3f, 0.2f, 1
        ));
        enviromentJohans.get(5).getChildObject().get(2).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(5).getChildObject().get(2).translateObject(12.0f, -27.93f, 7.0f);

        //        Meja krusty krab - 2
        enviromentJohans.add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)200/255,(float)33/255,(float)64/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -3.0f,3.0f, 0.2f, 1
        ));
        enviromentJohans.get(6).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(6).translateObject(12.0f, -28.0f, 7.0f);

        // kaki meja
        enviromentJohans.get(6).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)44/255,(float)84/255,(float)151/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -0.3f,0.3f, 2.0f, 1
        ));
        enviromentJohans.get(6).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(6).getChildObject().get(0).translateObject(12.0f, -28.0f, 7.0f);

        enviromentJohans.get(6).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)255/255,(float)249/255,(float)132/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -2.3f,2.3f, 0.2f, 1
        ));
        enviromentJohans.get(6).getChildObject().get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(6).getChildObject().get(1).translateObject(12.0f, -27.95f, 7.0f);

        enviromentJohans.get(6).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)129/255,(float)163/255,(float)198/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -0.3f,0.3f, 0.2f, 1
        ));
        enviromentJohans.get(6).getChildObject().get(2).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(6).getChildObject().get(2).translateObject(12.0f, -27.93f, 7.0f);

        //        Meja krusty krab - 3
        enviromentJohans.add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)200/255,(float)33/255,(float)64/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -3.0f,3.0f, 0.2f, 1
        ));
        enviromentJohans.get(7).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(7).translateObject(12.0f, -28.0f, 7.0f);

        // kaki meja
        enviromentJohans.get(7).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)44/255,(float)84/255,(float)151/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -0.3f,0.3f, 2.0f, 1
        ));
        enviromentJohans.get(7).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(7).getChildObject().get(0).translateObject(12.0f, -28.0f, 7.0f);

        enviromentJohans.get(7).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)255/255,(float)249/255,(float)132/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -2.3f,2.3f, 0.2f, 1
        ));
        enviromentJohans.get(7).getChildObject().get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(7).getChildObject().get(1).translateObject(12.0f, -27.95f, 7.0f);

        enviromentJohans.get(7).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)129/255,(float)163/255,(float)198/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -0.3f,0.3f, 0.2f, 1
        ));
        enviromentJohans.get(7).getChildObject().get(2).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(7).getChildObject().get(2).translateObject(12.0f, -27.93f, 7.0f);

        //        Meja krusty krab - 4
        enviromentJohans.add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)200/255,(float)33/255,(float)64/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -3.0f,3.0f, 0.2f, 1
        ));
        enviromentJohans.get(8).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(8).translateObject(12.0f, -28.0f, 7.0f);

        // kaki meja
        enviromentJohans.get(8).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)44/255,(float)84/255,(float)151/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -0.3f,0.3f, 2.0f, 1
        ));
        enviromentJohans.get(8).getChildObject().get(0).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(8).getChildObject().get(0).translateObject(12.0f, -28.0f, 7.0f);

        enviromentJohans.get(8).getChildObject().add(new CircleJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.0f,0.0f)
                )
        ),
                new Vector4f((float)255/255,(float)249/255,(float)132/255,1.0f),
                new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)),
                -2.3f,2.3f, 0.2f, 1
        ));
        enviromentJohans.get(8).getChildObject().get(1).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(8).getChildObject().get(1).translateObject(12.0f, -27.95f, 7.0f);
        enviromentJohans.get(8).getChildObject().add(new CircleJohan(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert",GL_VERTEX_SHADER),new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)), new ArrayList<>(List.of(new Vector3f(0.0f,0.0f,0.0f))), new Vector4f((float)129/255,(float)163/255,(float)198/255,1.0f), new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f)), -0.3f,0.3f, 0.2f, 1));
        enviromentJohans.get(8).getChildObject().get(2).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(8).getChildObject().get(2).translateObject(12.0f, -27.93f, 7.0f);


//        Pindahin meja ke 1
        enviromentJohans.get(5).translateObject(8.0f, 0.0f, 0.0f);

        // pindahin meja ke 2
        enviromentJohans.get(6).translateObject(-34.0f, 0.0f, 2.0f);

//        pindahin meja ke 3
        enviromentJohans.get(7).translateObject(-20.0f, 0.0f, -10.0f);

        // pindahin meja ke 4
        enviromentJohans.get(8).translateObject(3.0f, 0.0f, -10.0f);

//        pintu ruangan mr krab
        enviromentJohans.add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)109/255,(float)142/255,(float)155/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                3.0f,
                0.2f, 6f,
                36,
                18,
                6
        ));
        enviromentJohans.get(9).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(9).translateObject(-20.0f,-26.9f,-14.8f);

//        pintu Gudang
        enviromentJohans.add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)109/255,(float)142/255,(float)155/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                3.0f,
                0.2f, 6f,
                36,
                18,
                6
        ));
        enviromentJohans.get(10).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(10).translateObject(-20.0f,-26.9f,-14.8f);
        enviromentJohans.get(10).scaleObject(-1.0f,1.0f,1.0f);
// pintu dapur
        enviromentJohans.add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)109/255,(float)142/255,(float)155/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                3.0f,
                0.2f, 6f,
                36,
                18,
                6
        ));
        enviromentJohans.get(11).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(11).translateObject(-20.0f,-26.9f,-14.8f);
        enviromentJohans.get(11).scaleObject(-1.0f,1.0f,1.0f);
        enviromentJohans.get(11).translateObject(-10.0f,0f,0f);
// pintu exit
        enviromentJohans.add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)109/255,(float)142/255,(float)155/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                3.0f,
                0.2f, 6f,
                36,
                18,
                6
        ));
        enviromentJohans.get(12).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        enviromentJohans.get(12).translateObject(-20.0f,-26.9f,-14.8f);
        enviromentJohans.get(12).scaleObject(-1.0f,1.0f,1.0f);
        enviromentJohans.get(12).translateObject(-20.0f,0f,0f);
        enviromentJohans.get(12).scaleObject(1.0f,1.0f,-1.0f);

        //        dataran bawah
        enviromentJohans.add(new SphereJohan(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float)125/255,(float)91/255,(float)54/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                15.5f,
                15.5f, 0.5f,
                36,
                18,
                6
        ));

        enviromentJohans.get(13).scaleObject(5.0f,5.0f,0.5f);
        enviromentJohans.get(13).translateObject(0.0f,0.0f,18.25f);
        enviromentJohans.get(13).rotateObject((float)Math.toRadians(90),1f,0f,0f);

//        kebawahin kapal squidward
        enviromentJohans.get(2).translateObject(-1.0f,-23.7f,-12.8f);

//         geser chumbucket
        enviromentJohans.get(3).translateObject(0.7f, 0.0f, 0.0f);

//        Plankton ku di bawahin
        objectJohans.get(0).translateObject(0.0f, -0.3f, 0.0f);

        //        Plankton ku di bawahin ke dalam krusty
        objectJohans.get(0).rotateObject((float) Math.toRadians(180f),0.0f,1.0f,0.0f);
//        objectJohans.get(0).translateObject(0.0f, -28.8f, 5.0f);

        //KANTOR MR KRAB
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
        enviromentMrKrab.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(1.0f,0.0f,0.0f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 0));
        enviromentMrKrab.get(0).getChildObject().get(5).scaleObject(2f,0.5f,9.5f);
        enviromentMrKrab.get(0).getChildObject().get(5).translateObject(0.0f,-1.0f,1.75f);
        enviromentMrKrab.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(90),1f,0f,0f);
        //brangkas bagian besar
        enviromentMrKrab.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.6f,0.5529411765f,0.7725490196f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 1));
        enviromentMrKrab.get(0).getChildObject().get(6).scaleObject(1.0f,1.0f,0.5f);
        enviromentMrKrab.get(0).getChildObject().get(6).translateObject(1.75f,0.5f,-1.075f);
        //brankas bagian kecil
        enviromentMrKrab.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.4078431373f,0.3725490196f,0.4784313725f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 1));
        enviromentMrKrab.get(0).getChildObject().get(7).scaleObject(0.75f,0.75f,0.5f);
        enviromentMrKrab.get(0).getChildObject().get(7).translateObject(1.75f,0.5f,-0.975f);
        //lemari
        enviromentMrKrab.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.2549019608f,0.1215686275f,0.1490196078f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 0));
        enviromentMrKrab.get(0).getChildObject().get(8).scaleObject(3.0f,4f,0.25f);
        enviromentMrKrab.get(0).getChildObject().get(8).translateObject(2.1f,0.0f,2.65f);
        enviromentMrKrab.get(0).getChildObject().get(8).rotateObject((float)Math.toRadians(270),0f,1f,0f);
        //pintu
        enviromentMrKrab.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.5294117647f,0.5921568627f,0.7450980392f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 0));
        enviromentMrKrab.get(0).getChildObject().get(9).scaleObject(2.5f,3f,0.25f);
        enviromentMrKrab.get(0).getChildObject().get(9).translateObject(-1.0f,-0.25f,2.65f);
        enviromentMrKrab.get(0).getChildObject().get(9).rotateObject((float)Math.toRadians(90),0f,1f,0f);
        enviromentMrKrab.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.5294117647f,0.5921568627f,0.7450980392f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 1));
        enviromentMrKrab.get(0).getChildObject().get(10).scaleObject(1.25f,1.25f,0.25f);
        enviromentMrKrab.get(0).getChildObject().get(10).translateObject(-1.0f,0.5f,2.65f);
        enviromentMrKrab.get(0).getChildObject().get(10).rotateObject((float)Math.toRadians(90),0f,1f,0f);
        //jendela di pintu
        enviromentMrKrab.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(1.0f,1.0f,1.0f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 1));
        enviromentMrKrab.get(0).getChildObject().get(11).scaleObject(0.95f,0.95f,0.25f);
        enviromentMrKrab.get(0).getChildObject().get(11).translateObject(-1.0f,0.5f,2.6f);
        enviromentMrKrab.get(0).getChildObject().get(11).rotateObject((float)Math.toRadians(90),0f,1f,0f);
        //jendela kecil di pintu
        enviromentMrKrab.get(0).getChildObject().add(new SphereJames(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)), new ArrayList<>(), new Vector4f(0.9490196078f,0.9333333333f,0.4117647059f,1.0f), Arrays.asList(0.0f,0.0f,0.0f), 0.5f, 0.5f, 0.5f, 36, 18, 1));
        enviromentMrKrab.get(0).getChildObject().get(12).scaleObject(0.65f,0.65f,0.25f);
        enviromentMrKrab.get(0).getChildObject().get(12).translateObject(-1.0f,0.5f,2.5f);
        enviromentMrKrab.get(0).getChildObject().get(12).rotateObject((float)Math.toRadians(90),0f,1f,0f);

        enviromentMrKrab.get(0).translateObject(100.0f,-29.0f,0.0f);
        //CHUMBUCKET
        //tembok kiri
        environmentLabJane.add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float) 57/255,(float) 79/255,(float) 83/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                4.0f,
                3.2f,
                0.01f,
                100,
                100,
                12
        ));
        environmentLabJane.get(0).translateObject(-0.65f,0.0f,-1.65f);
        environmentLabJane.get(0).rotateObject((float) Math.toRadians(90),0.0f,1.0f,0.0f);

        //tembok kanan
        environmentLabJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float) 57/255,(float) 79/255,(float) 83/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                4.0f,
                3.2f,
                0.01f,
                100,
                100,
                12
        ));
        environmentLabJane.get(0).getChildObject().get(0).translateObject(-0.65f,0.0f,2.35f);
        environmentLabJane.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(90),0.0f,1.0f,0.0f);
        environmentLabJane.get(0).getChildObject().get(0).scaleObject(1.0f,-1.0f,1.0f);


        //tembok belakang
        environmentLabJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float) 86/255,(float) 127/255,(float) 129/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                4.0f,
                3.2f,
                0.01f,
                100,
                100,
                12
        ));
        environmentLabJane.get(0).getChildObject().get(1).translateObject(0.35f,0.0f,-1.35f);


        //lantai bawah
        environmentLabJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float) 146/255,(float) 179/255,(float) 185/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                4.0f,
                0.01f,
                4.0f,
                100,
                100,
                12
        ));
        environmentLabJane.get(0).getChildObject().get(2).translateObject(0.35f,-1.6f,0.65f);

        //atap
        environmentLabJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float) 43/255,(float) 52/255,(float) 53/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                4.0f,
                0.01f,
                4.0f,
                100,
                100,
                12
        ));
        environmentLabJane.get(0).getChildObject().get(3).translateObject(0.35f,1.6f,0.65f);

        environmentLabJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float) 147/255,(float) 88/255,(float) 47/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.2f,
                0.2f,
                0.2f,
                100,
                100,
                11
        ));
        environmentLabJane.get(0).getChildObject().get(4).translateObject(0.0f,-1.0f,1.4f);
        environmentLabJane.get(0).getChildObject().get(4).rotateObject((float)Math.toRadians(90),1.0f,0.0f,0.0f);

        //tabung poison kecil
        environmentLabJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float) 53/255,(float) 142/255,(float) 142/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.1f,
                0.1f,
                0.4f,
                100,
                100,
                11
        ));
        environmentLabJane.get(0).getChildObject().get(5).translateObject(1.97f,-1.0f,1.2f);
        environmentLabJane.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(90),1.0f,0.0f,0.0f);

        //tabung poison besar
        environmentLabJane.get(0).getChildObject().add(new SphereJane(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f((float) 53/255,(float) 142/255,(float) 142/255,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.1f,
                0.1f,
                0.55f,
                100,
                100,
                11
        ));
        environmentLabJane.get(0).getChildObject().get(6).translateObject(2.2f,-1.0f,1.05f);
        environmentLabJane.get(0).getChildObject().get(6).rotateObject((float)Math.toRadians(90),1.0f,0.0f,0.0f);

//        objectJohans.get(0).scaleObject(0.7f,0.7f,0.7f);
        //NEW OBJECT! (KAREN)
        enviromentAngel.add(new BoxAngel( //o2 monitor box
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.1f,0.1f,0.6f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                1.6f,
                1.2f,
                0.3f,
                36,
                18
        ));
        enviromentAngel.get(0).getChildObject().add(new LineAngel(   //o2c1 garis monitor box
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.1f,0.1f,0.4f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                1.6f,
                1.2f,
                0.3f,
                36,
                18,
                3
        ));
        enviromentAngel.get(0).getChildObject().add(new BoxAngel( //o2c2 tampak depan monitor box
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.1f,0.2f,0.7f,1.0f),
                Arrays.asList(0.0f,0.0f,0.15f),
                1.59f,
                1.19f,
                0.01f,
                36,
                18
        ));
        enviromentAngel.get(0).getChildObject().add(new BoxAngel(   //o2c3 monitor screen
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.05f,0.05f,0.11f,1.0f),
                Arrays.asList(0.0f,0.0f,0.15f),
                1.38f,
                1.0f,
                0.015f,
                36,
                30
        ));
        enviromentAngel.get(0).getChildObject().add(new CylinderAngel(   //o2c4 pipa1
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.2f,0.3f,0.2f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.065f,
                1.0f,
                0.065f,
                36,
                18
        ));
        enviromentAngel.get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(90.0f),0.0f,1.0f,0f);
        enviromentAngel.get(0).getChildObject().get(3).translateObject(0.8f,0.35f,0.0f);
        enviromentAngel.get(0).getChildObject().add(new CylinderAngel(   //o2c5 pipa2
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.2f,0.3f,0.2f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.055f,
                1.0f,
                0.055f,
                36,
                18
        ));
        enviromentAngel.get(0).getChildObject().get(4).rotateObject((float)Math.toRadians(90.0f),0.0f,1.0f,0f);
        enviromentAngel.get(0).getChildObject().get(4).translateObject(0.8f,0.01f,0.0f);
        enviromentAngel.get(0).getChildObject().add(new CylinderAngel(   //o2c6 pipa3
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.2f,0.3f,0.2f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.065f,
                1.0f,
                0.065f,
                36,
                18
        ));
        enviromentAngel.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(90.0f),0.0f,1.0f,0f);
        enviromentAngel.get(0).getChildObject().get(5).translateObject(0.8f,-0.36f,0.0f);
        enviromentAngel.get(0).getChildObject().add(new CylinderAngel(   //o2c7 pipa kanan atas
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.2f,0.28f,0.2f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.058f,
                1.4f,
                0.058f,
                36,
                18
        ));
        enviromentAngel.get(0).getChildObject().get(6).rotateObject((float)Math.toRadians(-90.0f),1.0f,0.0f,0f);
        enviromentAngel.get(0).getChildObject().get(6).translateObject(1.8f,-0.6f,0.0f);
        enviromentAngel.get(0).getChildObject().add(new CylinderAngel(   //o2c8 cylinder pipa kanan atas
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.15f,0.2f,0.15f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.2f,
                0.04f,
                0.2f,
                36,
                18
        ));
        enviromentAngel.get(0).getChildObject().get(7).rotateObject((float)Math.toRadians(-90.0f),1.0f,0.0f,0f);
        enviromentAngel.get(0).getChildObject().get(7).translateObject(1.8f,0.8f,0.0f);
        enviromentAngel.get(0).getChildObject().add(new CylinderAngel(   //o2c9 pipa kanan tengah
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.2f,0.25f,0.2f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.05f,
                0.2f,
                0.05f,
                36,
                18
        ));
        enviromentAngel.get(0).getChildObject().get(8).rotateObject((float)Math.toRadians(90.0f),0.0f,1.0f,0f);
        enviromentAngel.get(0).getChildObject().get(8).rotateObject((float)Math.toRadians(-15.0f),0.0f,0.0f,1.0f);
        enviromentAngel.get(0).getChildObject().get(8).translateObject(1.75f,-0.555f,0.0f);
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().add(new BoxAngel( //o2c9.1 box saklar atas
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.25f,0.3f,0.25f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.2f,
                0.4f,
                0.12f,
                100,
                70
        ));
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(0).translateObject(2.03f,-0.6f,0.0f);
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().add(new SphereAngel( //o2c9.2 oval saklar atas
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.28f,0.3f,0.28f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.1f,
                0.2f,
                0.06f,
                100,
                75
        ));
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(1).translateObject(2.03f,-0.6f,0.05f);
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().add(new BoxAngel( //o2c9.3 box saklar bawah
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.26f,0.3f,0.26f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.2f,
                0.2f,
                0.12f,
                100,
                70
        ));
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(2).translateObject(2.03f,-0.9f,0.0f);
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().add(new SphereAngel( //o2c9.4 oval saklar bawah
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.28f,0.3f,0.28f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.1f,
                0.1f,
                0.06f,
                100,
                70
        ));
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(3).translateObject(2.03f,-0.9f,0.05f);
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().add(new SphereAngel( //o2c9.5 sphere pegangan saklar
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.28f,0.3f,0.28f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.09f,
                0.05f,
                0.05f,
                100,
                70
        ));
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(4).getChildObject().add(new CylinderAngel(   //o2c9.5.1 pegangan saklar kiri
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.55f,0.1f,0.1f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.01f,
                0.16f,
                0.01f,
                36,
                18
        ));
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(-45.0f),1.0f,0.0f,0f);
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(4).getChildObject().get(0).translateObject(-0.035f,0.0f,0.0f);
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(4).getChildObject().add(new CylinderAngel(   //o2c9.5.2 pegangan saklar kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.55f,0.1f,0.1f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.01f,
                0.16f,
                0.01f,
                36,
                18
        ));
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(4).getChildObject().get(1).rotateObject((float)Math.toRadians(-45.0f),1.0f,0.0f,0f);
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(4).getChildObject().get(1).translateObject(0.035f,0.0f,0.0f);
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(4).getChildObject().add(new CylinderAngel(   //o2c9.5.3 pegangan saklar horizontal
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.55f,0.1f,0.1f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.016f,
                0.16f,
                0.016f,
                36,
                18
        ));
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(4).getChildObject().get(2).rotateObject((float)Math.toRadians(-90.0f),0.0f,1.0f,0f);
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(4).getChildObject().get(2).translateObject(0.08f,0.113f,0.113f);
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(4).getChildObject().add(new CylinderAngel(   //o2c9.5.4 pegangan saklar horizontal (2)
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.65f,0.1f,0.1f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.016f,
                0.16f,
                0.016f,
                36,
                18
        ));
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(4).getChildObject().get(3).rotateObject((float)Math.toRadians(90.0f),0.0f,1.0f,0f);
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(4).getChildObject().get(3).translateObject(-0.08f,0.113f,0.113f);
        enviromentAngel.get(0).getChildObject().get(8).getChildObject().get(4).translateObject(2.03f,-0.6f,0.045f);
        enviromentAngel.get(0).getChildObject().add(new CylinderAngel(   //o2c10 pipa kanan bawah
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.2f,0.25f,0.2f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.025f,
                0.7f,
                0.025f,
                36,
                18
        ));
        enviromentAngel.get(0).getChildObject().get(9).rotateObject((float)Math.toRadians(90.0f),1.0f,0.0f,0f);
        enviromentAngel.get(0).getChildObject().get(9).translateObject(2.03f,-1.0f,0.0f);

        //NEW OBJECT! (MEJA CONTROL)
        enviromentAngel.add(new BoxAngel(   //o3 meja bagian belakang
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.21f,0.28f,0.22f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                1.1f,
                1.0f,
                0.3f,
                36,
                36
        ));
        enviromentAngel.get(1).getChildObject().add(new BoxAngel( //o3c1 meja bagian depan bawah
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.21f,0.28f,0.22f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                1.1f,
                0.5f,
                0.4f,
                36,
                36
        ));
        enviromentAngel.get(1).getChildObject().get(0).translateObject(0.0f,-0.25f,0.35f);
        enviromentAngel.get(1).getChildObject().add(new BoxAngel( //o3c2 meja bagian depan atas
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.21f,0.28f,0.22f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                1.1f,1.1f,
                0.4f,0.001f,
                0.4f,0.4f,
                36,
                36
        ));
        enviromentAngel.get(1).getChildObject().get(1).translateObject(0.0f,0.0f,0.35f);
        enviromentAngel.get(1).getChildObject().add(new BoxAngel(   //o3c3 tampak depan meja bagian depan bawah
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f,0.3f,0.3f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                1.095f,
                0.495f,
                0.4f,
                36,
                36
        ));
        enviromentAngel.get(1).getChildObject().get(2).translateObject(0.0f,-0.25f,0.351f);
        enviromentAngel.get(1).getChildObject().add(new BoxAngel( //o3c4 tampak depan meja bagian depan atas
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.45f,0.45f,0.45f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                1.095f,1.095f,
                0.4f,0.001f,
                0.4f,0.4f,
                36,
                36
        ));
        enviromentAngel.get(1).getChildObject().get(3).translateObject(0.0f,0.001f,0.351f);
        enviromentAngel.get(1).getChildObject().add(new BoxAngel(   //o3c5 tampak depan meja bagian belakang
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.25f,0.3f,0.26f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                1.095f,
                0.995f,
                0.3f,
                100,
                75
        ));
        enviromentAngel.get(1).getChildObject().get(4).translateObject(0.0f,0.0f,0.001f);

        enviromentAngel.get(0).translateObject(-0.3f,0.0f,-0.5f);
        enviromentAngel.get(1).translateObject(-0.3f,-1.2f,-0.5f);


        //===================================================================== BURGER

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

//        objekBurger.get(0).translateObject(100f,-29f,0.0f);


        objectAngels.get(0).translateObject(1.2f,0.0f,-7f);
        objekjames.get(0).translateObject(1.2f,0.0f,-7f);
        objectJane.get(0).translateObject(1.2f,0.0f,-7f);
    }

    public void input(){
        //KEY AKSI JOHAN =================================================================================
        camera.setPosition(objectJohans.get(0).getMatrix().get(3,0),objectJohans.get(0).getMatrix().get(3,1)+1.5f,objectJohans.get(0).getMatrix().get(3,2)+2.0f);
//        camera.setPosition(objectJane.get(0).getMatrix().get(3,0),objectJane.get(0).getMatrix().get(3,1)+2.5f,objectJane.get(0).getMatrix().get(3,2)+2.0f);
        float xPlankton = objectJohans.get(0).getMatrix().get(3,2) + ((CircleJohan)objectJohans.get(0)).getRadiusX();
        float yPlankton = objectJohans.get(0).getMatrix().get(3,1) + ((CircleJohan)objectJohans.get(0)).getRadiusY();
        float zPlankton = objectJohans.get(0).getMatrix().get(3,0) + 0.5f;
//        Pintu ke Dalam ruangan mr krab
        if (jarakEuclidean3D(xPlankton, enviromentJohans.get(9).getMatrix().get(3,2), yPlankton, enviromentJohans.get(9).getMatrix().get(3,1), zPlankton, enviromentJohans.get(9).getMatrix().get(3,0)) < 2.67) {
            objectJohans.get(0).translateObject(120f, 0.0f, 15f);
        }
        //pintu keluar ruangan mr krab
        if (jarakEuclidean3D(xPlankton, enviromentMrKrab.get(0).getChildObject().get(9).getMatrix().get(3,2), yPlankton, enviromentMrKrab.get(0).getChildObject().get(9).getMatrix().get(3,1), zPlankton, enviromentMrKrab.get(0).getChildObject().get(9).getMatrix().get(3,0)) < 1.00) {
            objectJohans.get(0).translateObject(-115f, 0.0f, -10f);
            if(bawaburger){
                objekBurger.get(0).translateObject(-115f,0.0f,-10f);
            }

        }
//         Pintu ke luar krusty krab
        if (jarakEuclidean3D(xPlankton, enviromentJohans.get(12).getMatrix().get(3,2), yPlankton, enviromentJohans.get(12).getMatrix().get(3,1), zPlankton, enviromentJohans.get(12).getMatrix().get(3,0)) < 2.67) {
            objectJohans.get(0).translateObject(2.3f, 28.8f, -20.0f);
            if(bawaburger){
                System.out.println("KELUAR");
                objekBurger.get(0).translateObject(2.3f,28.8f, -20.0f);
            }
        }

        //         Pintu masuk ke krusty krab
        if (jarakEuclidean3D(xPlankton, enviromentJohans.get(1).getChildObject().get(4).getMatrix().get(3,2), yPlankton, enviromentJohans.get(1).getChildObject().get(4).getMatrix().get(3,1), zPlankton, enviromentJohans.get(1).getChildObject().get(4).getMatrix().get(3,0)) < 1.5) {
            objectJohans.get(0).translateObject(-2.3f, -28.8f, 18.0f);
            if(bawaburger){
                objekBurger.get(0).translateObject(-2.3f,-28.8f, 18.0f);
            }
        }
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
            if(bawaburger){
                objekBurger.get(0).translateObject(0.0f, 0.0f, 0.025f);
            }
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
//                System.out.println("Current degree : " + currentDegJohan + " | direction : " + directionXJohan + " | Countdeg : "  + countDegJohan);

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

                objectJohans.get(0).translateObject(0.0f, 0.0f, 0.025f);
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
            if(bawaburger){
                objekBurger.get(0).translateObject(0.0f, 0.0f, -0.025f);
            }
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
//                System.out.println("Current degree : " + currentDegJohan + " | direction : " + directionXJohan + " | Countdeg : "  + countDegJohan);

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

                objectJohans.get(0).translateObject(0.0f, 0.0f, -0.025f);
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
            if(bawaburger){
                objekBurger.get(0).translateObject(-0.025f, 0.0f, 0.0f);
            }
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
//                System.out.println("Current degree : " + currentDegJohan + " | direction : " + directionXJohan + " | Countdeg : " + countDegJohan);

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

                objectJohans.get(0).translateObject(-0.025f, 0.0f, 0.0f);
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
            if(bawaburger){
                objekBurger.get(0).translateObject(0.025f, 0.0f, 0.0f);
            }
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
//                System.out.println("Current degree : " + currentDegJohan + " | direction : " + directionXJohan + " | Countdeg : " + countDegJohan);

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

                objectJohans.get(0).translateObject(0.025f, 0.0f, 0.0f);
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
//                    timerkeyAksi2James = -30f;
                }
                isPressedJames = false;
            }
        }
        timerkeyAksi2James +=0.1f;
        if(timerkeyAksi2James > 0.2f){
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

                objekjames.get(0).translateObject(0.0f, 0.0f, 0.025f);
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

                objectAngels.get(0).translateObject(0.0f, 0.0f, 0.025f);
                objectJane.get(0).translateObject(0.0f,0.0f,0.025f);
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

                objekjames.get(0).translateObject(0.0f, 0.0f, -0.025f);
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

//                objectAngels.get(0).translateObject(0.0f, 0.0f, -0.05f);
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

                objekjames.get(0).translateObject(-0.025f, 0.0f, 0.0f);
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
//                objectAngels.get(0).translateObject(-0.05f, 0.0f, 0.0f);
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

                objekjames.get(0).translateObject(0.025f, 0.0f, 0.0f);
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

//                objectAngels.get(0).translateObject(0.05f, 0.0f, 0.0f);
                isPressedJames = false;
            }
        }

//        System.out.println(jarakEuclidean3D(xPlankton, objekBurger.get(0).getMatrix().get(3,2), yPlankton, objekBurger.get(0).getMatrix().get(3,1), zPlankton, objekBurger.get(0).getMatrix().get(3,0)));
        if (jarakEuclidean3D(xPlankton, objekBurger.get(0).getMatrix().get(3,2), yPlankton, objekBurger.get(0).getMatrix().get(3,1), zPlankton, objekBurger.get(0).getMatrix().get(3,0)) < 0.53) {
            bawaburger = true;
        }
        if(!bawaburger){
            System.out.println(jarakEuclidean3D(xPlankton, objekBurger.get(0).getMatrix().get(3,2), yPlankton, objekBurger.get(0).getMatrix().get(3,1), zPlankton, objekBurger.get(0).getMatrix().get(3,0)));

            if (window.isKeyPressed(GLFW_KEY_UP)){
                objekBurger.get(0).translateObject(0.0f,0.0f,-0.025f);
            }
            if (window.isKeyPressed(GLFW_KEY_DOWN)){
                objekBurger.get(0).translateObject(0.0f,0.0f,0.025f);
            }
            if (window.isKeyPressed(GLFW_KEY_LEFT)){
                objekBurger.get(0).translateObject(-0.025f,0.0f,0.0f);
            }
            if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
                objekBurger.get(0).translateObject(0.025f, 0.0f, 0.0f);
            }
            if(window.isKeyPressed(GLFW_KEY_PAGE_UP)){
                objekBurger.get(0).translateObject(0.0f, -0.025f, 0.0f);
            }
            if(window.isKeyPressed(GLFW_KEY_PAGE_DOWN)){
                objekBurger.get(0).translateObject(0.0f, 0.025f, 0.0f);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_O)){
            bawaburger = false;
        }



        //KEY AKSI JANE
        //bergerak jalan ke kiri
        if (window.isKeyPressed(GLFW_KEY_Z)){
            objectJane.get(0).translateObject(-0.06f,0.0f,0.01f);
        }
        //putar balik --> sama seperti berputar pada sumbu Y
        if (window.isKeyPressed(GLFW_KEY_X)){
            float x9 = objectJane.get(0).getMatrix().get(3,0);
            float y9 = objectJane.get(0).getMatrix().get(3,1);
            float z9 = objectJane.get(0).getMatrix().get(3,2);
            objectJane.get(0).translateObject(-x9,-y9,-z9);
            objectJane.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
            objectJane.get(0).translateObject(x9,y9,z9);

//            objectJane.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
//            objectJane.get(0).rotateObjectOnPoint(0.005f,0.0f,1.0f,0.0f,objectJane.get(0).getMatrix().get(3,0),objectJane.get(0).getMatrix().get(3,1),objectJane.get(0).getMatrix().get(3,2));
        }

        //bergerak jalan ke kanan
        if (window.isKeyPressed(GLFW_KEY_C)){
            objectJane.get(0).translateObject(0.06f,0.0f,0.01f);
        }


        //KEY AKSI ANGEL
        if(window.isKeyPressed(GLFW_KEY_J))

        {   //tangan gerak
            Vector3f tempCenterPoint= objectAngels.get(0).getChildObject().get(20).updateCenterPoint();
            objectAngels.get(0).getChildObject().get(21).translateObject(-tempCenterPoint.x,-tempCenterPoint.y,-tempCenterPoint.z);
            objectAngels.get(0).getChildObject().get(21).rotateObject((float)Math.toRadians(-0.5f),0.0f,0.0f,1.0f);
            objectAngels.get(0).getChildObject().get(21).translateObject(tempCenterPoint.x,tempCenterPoint.y,tempCenterPoint.z);
        }
        if(window.isKeyPressed(GLFW_KEY_U))

        {   //tangan gerak
            Vector3f tempCenterPoint= objectAngels.get(0).getChildObject().get(20).updateCenterPoint();
            objectAngels.get(0).getChildObject().get(21).translateObject(-tempCenterPoint.x,-tempCenterPoint.y,-tempCenterPoint.z);
            objectAngels.get(0).getChildObject().get(21).rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
            objectAngels.get(0).getChildObject().get(21).translateObject(tempCenterPoint.x,tempCenterPoint.y,tempCenterPoint.z);
        }
        if(window.isKeyPressed(GLFW_KEY_K)) {   //terbang
            objectAngels.get(0).translateObject(0.0f,0.1f,0.0f);
        }
        if(window.isKeyPressed(GLFW_KEY_L)) {   //mendarat
            objectAngels.get(0).translateObject(0.0f,-0.1f,0.0f);
        }

        //ROTASI KAMERA

//        if (window.isKeyPressed(GLFW_KEY_UP)){
//            camera.moveForward(0.01f);
//        }
//        if (window.isKeyPressed(GLFW_KEY_DOWN)){
//            camera.moveBackwards(0.05f);
//        }
//        if (window.isKeyPressed(GLFW_KEY_LEFT)){
//            camera.moveLeft(0.05f);
//        }
//        if (window.isKeyPressed(GLFW_KEY_RIGHT)){
//            camera.moveRight(0.05f);
//        }
//        if(window.isKeyPressed(GLFW_KEY_PAGE_UP)){
//            camera.moveUp(0.05f);
//        }
//        if(window.isKeyPressed(GLFW_KEY_PAGE_DOWN)){
//            camera.moveDown(0.05f);
//        }

        if (window.isKeyPressed(GLFW_KEY_N)){
            camera.addRotation(0.0f, 0.05f);
        }
        if (window.isKeyPressed(GLFW_KEY_M)){
            camera.addRotation(0.0f, -0.05f);
        }
        if(window.isKeyPressed(GLFW_KEY_1)) {   //rotasi sumbu z
            for(ObjectAngel object: objectAngels){
                object.rotateObject((float)Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_2)) {   //rotasi sumbu y
            Vector3f tempCenterPoint= objectAngels.get(0).updateCenterPoint();
            for(ObjectAngel object: objectAngels){
                objectAngels.get(0).translateObject(-tempCenterPoint.x,-tempCenterPoint.y,-tempCenterPoint.z);
                object.rotateObject((float)Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                objectAngels.get(0).translateObject(tempCenterPoint.x,tempCenterPoint.y,tempCenterPoint.z);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_3)) {   //rotasi sumbu x
            for(ObjectAngel object: objectAngels){
                object.rotateObject((float)Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            }
        }
    }

    static double jarakEuclidean3D(float x1, float x2, float y1, float y2, float z1, float z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
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

//            for(ObjectJames lingkungan : enviromentMrKrab){
//                lingkungan.draw(camera,projection);
//            }

            for(ObjectJames burger : objekBurger){
                burger.draw(camera,projection);
            }

//            for(ObjectJames objectJames : objekjames){
//                objectJames.draw(camera,projection);
//            }

            for(ObjectJohan objectJohan : objectJohans){
                objectJohan.draw(camera,projection);
            }

//            for(ObjectJohan envJohan : enviromentJohans){
//                envJohan.draw(camera,projection);
//            }
            //animasi tambahan jane
            //lendir bergerak sendiri begitu program di run
//            for(ObjectJane object: objectJane){
//                object.draw(camera,projection);
//            }

            for(ObjectJane lingkunganLab : environmentLabJane){
                lingkunganLab.draw(camera,projection);
            }

            for (int i=0;i<=6;i++){
                objectJane.get(0).getChildObject().get(i).rotateObjectOnPoint((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f,
                        objectJane.get(0).getChildObject().get(i).getMatrix().get(3,0),
                        objectJane.get(0).getChildObject().get(i).getMatrix().get(3,1),
                        objectJane.get(0).getChildObject().get(i).getMatrix().get(3,2)
                );
            }

//            for(ObjectAngel object: objectAngels){
//                object.draw(camera,projection);
//            }

            for(ObjectAngel lingkunganchumbucket:enviromentAngel){
                lingkunganchumbucket.draw(camera,projection);
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
        new ProjekGabungan().run();
    }
}