import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

// FIXED
public class PROJECT {
    boolean checkCollision(List<Vector3f> vertices1, List<Vector3f> vertices2) {
        // Mengambil koordinat minimum dan maksimum dari AABB pertama
        float minX1 = 999999999999999f, minY1 = 999999999999999f, minZ1 = 999999999999999f;
        float maxX1 = -999999999999999f, maxY1 = -999999999999999f, maxZ1 = -999999999999999f;
        for (Vector3f vertex : vertices1) {
            minX1 = Math.min(minX1, vertex.x);
            minY1 = Math.min(minY1, vertex.y);
            minZ1 = Math.min(minZ1, vertex.z);
            maxX1 = Math.max(maxX1, vertex.x);
            maxY1 = Math.max(maxY1, vertex.y);
            maxZ1 = Math.max(maxZ1, vertex.z);
        }

        // Mengambil koordinat minimum dan maksimum dari AABB kedua
        float minX2 = 999999999999999f, minY2 = 999999999999999f, minZ2 = 999999999999999f;
        float maxX2 = -999999999999999f, maxY2 = -999999999999999f, maxZ2 = -999999999999999f;
        for (Vector3f vertex : vertices2) {
            minX2 = Math.min(minX2, vertex.x);
            minY2 = Math.min(minY2, vertex.y);
            minZ2 = Math.min(minZ2, vertex.z);
            maxX2 = Math.max(maxX2, vertex.x);
            maxY2 = Math.max(maxY2, vertex.y);
            maxZ2 = Math.max(maxZ2, vertex.z);
        }

        // Memeriksa tabrakan antara AABB pertama dan AABB kedua
        boolean collisionX = maxX1 >= minX2 && minX1 <= maxX2;
        boolean collisionY = maxY1 >= minY2 && minY1 <= maxY2;
        boolean collisionZ = maxZ1 >= minZ2 && minZ1 <= maxZ2;

        return collisionX && collisionY && collisionZ;
    }

    float derajatkamera=30f;
    private Window window = new Window(1000, 800, "PROJECT GRAFKOM");

    ArrayList<Sphere> enviroment = new ArrayList<>();
    ArrayList<Sphere> enviroment2 = new ArrayList<>();

    ArrayList<Sphere> lantai = new ArrayList<>();
    ArrayList<Sphere> lantai2 = new ArrayList<>();

    ArrayList<Sphere> character = new ArrayList<>();
    ArrayList<Sphere> pintuenvi2masuk = new ArrayList();
    ArrayList<Sphere> pintuenvi2masukpenjara = new ArrayList<>();
    ArrayList<Sphere> pintuenvi2keluarpenjara = new ArrayList<>();
    ArrayList<Sphere> pintuenvi2keluar = new ArrayList<>();
    ArrayList<Sphere> kamera = new ArrayList<>();

    float camRotation=0;
    private MouseInput mouseInput;
    static float rot = 0f;

    Projection projection = new Projection(window.getWidth(), window.getHeight());
    Camera camera = new Camera();

    boolean FPS = true;
    boolean TPS = false;
    boolean dienvi2 = false;
    boolean cinematography;
    boolean freeroam = true;
    int state=2;

    float camXTPS = 0f;
    float camYTPS = 5f;
    float camZTPS = 4f;

    float currentDeg = 0.0f, countDeg = 3.5f;
    float directionBodyX = 0f, directionBodyY = -1f;
    float currentBodyDegree = 270f;
    boolean isMrkrablari = false;
    float speedMrkrab1 = 0.1f;
    float totalLari = 0f;
    SkyBoxCube skybox;

    public void init() throws IOException {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        mouseInput = window.getMouseInput();
        camera.setPosition(0, 0f, 1.7f);
        camera.moveLeft(4f);
        camera.moveBackwards(20f);
        camera.moveUp(5f);

        skybox=new SkyBoxCube();

        character.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(1.0f, 0.894f, 0.0f, 1.0f),
                        "resources/models/character/spongebob.obj"
                )
        );
        character.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
                        "resources/models/character/squidward.obj"
                )
        );

        character.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.4f, 0.61568f, 0.61568f, 1.0f),
                        "resources/models/character/plankton.obj"
                )
        );
        character.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.96470f, 0.639f, 0.64705f, 1.0f),
                        "resources/models/character/patrick.obj"
                )
        );
        character.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.93725f, 0.18039f, 0.192156f, 1.0f),
                        "resources/models/character/mrkrabs.obj"
                )
        );

//          keatas krusty krab
//        character.get(0).translateObject(-1.15f,-0.1f,-7f);
//        character.get(0).scaleObject(3.25f,3.25f,-3.25f);

        character.get(0).translateObject(-1.15f,-0.1f,-7f);
        character.get(0).scaleObject(3.25f,3.25f,-3.25f);

        character.get(1).translateObject(-2.1f,0.2f,-2f);
        character.get(1).scaleObject(1.5f,1.5f,1.5f);

        character.get(2).translateObject(-2.2f,-1.3f,2.3f);
        character.get(2).scaleObject(12,12,10);

//        character.get(3).rotateObject((float)Math.toRadians(90),0f,0f,1f);
        character.get(3).translateObject(-15f,0.0f,2.0f);
        character.get(3).scaleObject(3,3,3);
        character.get(4).translateObject(15f,0.5f,20.0f);

//      bagian bawah krusty krab
        lantai.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.32941f, 0.349019f, 0.37647f, 1.0f),
                        "resources/models/enviroment/krustykrab/bagianbawah1.obj"
                )
        );
        lantai.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.254901f, 0.35686f, 0.13725f, 1.0f),
                        "resources/models/enviroment/krustykrab/bagianbawah2.obj"
                )
        );
        lantai.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.58039f, 0.5647f, 0.36078f, 1.0f),
                        "resources/models/enviroment/krustykrab/bagianbawah3.obj"
                )
        );
//        krustykrab
//        dinding depan kiri
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingdepankiri.obj"
                )
        );
//        dinding depan kanan
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingdepankanan.obj"
                )
        );
//        dinding kiri
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingsampingkiri.obj"
                )
        );
//        dinding kanan
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingsampingkanan.obj"
                )
        );
//        dinding belakang
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingbelakang.obj"
                )
        );
//        atap krusty krab
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/atap.obj"
                )
        );
//        dindingdalam
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.478431372f, 0.58823529411f, 0.615686274f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingdalam.obj"
                )
        );
//      lantai
        lantai.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.08627f, 0.19216f, 0.113725f, 1.0f),
                        "resources/models/enviroment/krustykrab/lantai.obj"
                )
        );
//        kapalbagiandalam
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.5176f, 0.1647f, 0.1607f, 1.0f),
                        "resources/models/enviroment/krustykrab/kapalbagiandalam.obj"
                )
        );
//        kapalbagianluar
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                        "resources/models/enviroment/krustykrab/kapalbagianluar.obj"
                )
        );
//        kasir
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                        "resources/models/enviroment/krustykrab/kasir.obj"
                )
        );
//        kursi
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.32549019607f, 0.215686274f, 0.1450980f, 1.0f),
                        "resources/models/enviroment/krustykrab/kursi1.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.32549019607f, 0.215686274f, 0.1450980f, 1.0f),
                        "resources/models/enviroment/krustykrab/kursi2.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.32549019607f, 0.215686274f, 0.1450980f, 1.0f),
                        "resources/models/enviroment/krustykrab/kursi3.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.32549019607f, 0.215686274f, 0.1450980f, 1.0f),
                        "resources/models/enviroment/krustykrab/kursi4.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.32549019607f, 0.215686274f, 0.1450980f, 1.0f),
                        "resources/models/enviroment/krustykrab/kursi5.obj"
                )
        );
//        meja
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0705f, 0.08235f, 0.15294f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja1-1.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0705f, 0.08235f, 0.15294f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja1-2.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0705f, 0.08235f, 0.15294f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja1-3.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0705f, 0.08235f, 0.15294f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja1-4.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0705f, 0.08235f, 0.15294f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja1-5.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.43921f, 0.11764f, 0.12549f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja2-1.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.43921f, 0.11764f, 0.12549f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja2-2.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.43921f, 0.11764f, 0.12549f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja2-3.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.43921f, 0.11764f, 0.12549f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja2-4.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.43921f, 0.11764f, 0.12549f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja2-5.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.57647f, 0.52549f, 0.25882f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja3-1.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.57647f, 0.52549f, 0.25882f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja3-2.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.57647f, 0.52549f, 0.25882f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja3-3.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.57647f, 0.52549f, 0.25882f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja3-4.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.57647f, 0.52549f, 0.25882f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja3-5.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.35686f, 0.450980f, 0.59215f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja4-1.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.35686f, 0.450980f, 0.59215f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja4-2.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.35686f, 0.450980f, 0.59215f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja4-3.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.35686f, 0.450980f, 0.59215f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja4-4.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.35686f, 0.450980f, 0.59215f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja4-5.obj"
                )
        );
//        barang di atas (belakang menu)
//        16
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.396078f, 0.37647f, 0.345098f, 1.0f),
                        "resources/models/enviroment/krustykrab/barangatas.obj"
                )
        );
//        handle pintu keluar
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.2902f, 0.3765f, 0.4911f, 1.0f),
                        "resources/models/enviroment/krustykrab/handle-pintu.obj"
                )
        );
//        pintu keluar krusty krab
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.450980f, 0.72156f, 0.83529f, 1.0f),
                        "resources/models/enviroment/krustykrab/pintu.obj"
                )
        );
//        prisoner cage environment 2
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-cage.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-crate.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-dinding1.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-dinding2.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-dinding3.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-dinding4.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-dinding5.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-dinding6.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-dinding7.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-dinding8.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-dinding9.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-dindingbelakang.obj"
                )
        );
//        enviroment2.add(new Sphere
//                (
//                        Arrays.asList
//                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
//                        new ArrayList<>(),
//                        new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                        "resources/models/enviroment/ruangbelakang/env2-tengkorak.obj"
//                )
//        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-fish.obj"
                )
        );
        lantai2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-atap.obj"
                )
        );
        lantai2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-lantai.obj"
                )
        );
//        pintu enviroment 2 - masuk penjara
        pintuenvi2masukpenjara.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.435294f, 0.611764f, 0.654901f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu4-1.obj"
                )
        );
        pintuenvi2masukpenjara.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.435294f, 0.611764f, 0.654901f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu4-2.obj"
                )
        );
        pintuenvi2masukpenjara.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.435294f, 0.611764f, 0.654901f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu4-3.obj"
                )
        );
//        pintu enviroment 2 - keluar penjara
        pintuenvi2keluarpenjara.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.435294f, 0.611764f, 0.654901f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu1-1.obj"
                )
        );
        pintuenvi2keluarpenjara.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.384313f, 0.47450f, 0.607843f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu1-2.obj"
                )
        );
        pintuenvi2keluarpenjara.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.00258f, 0.56078f, 0.56078f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu1-3.obj"
                )
        );
//        pintu enviroment 2 - masuk penjara
        pintuenvi2keluar.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.435294f, 0.611764f, 0.654901f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu2-1.obj"
                )
        );
        pintuenvi2keluar.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.384313f, 0.47450f, 0.607843f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu2-2.obj"
                )
        );
        pintuenvi2keluar.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.00258f, 0.56078f, 0.56078f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu2-3.obj"
                )
        );
//        menu
//        19
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.2902f, 0.3765f, 0.4911f, 1.0f),
                        "resources/models/enviroment/krustykrab/daftarmenu1.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                        "resources/models/enviroment/krustykrab/daftarmenu2.obj"
                )
        );
//        krustykrab - pintu
        pintuenvi2masuk.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.435294f, 0.611764f, 0.654901f, 1.0f),
                        "resources/models/enviroment/krustykrab/door1-1.obj"
                )
        );
        pintuenvi2masuk.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.384313f, 0.47450f, 0.607843f, 1.0f),
                        "resources/models/enviroment/krustykrab/door1-2.obj"
                )
        );
        pintuenvi2masuk.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.00258f, 0.56078f, 0.56078f, 1.0f),
                        "resources/models/enviroment/krustykrab/door1-3.obj"
                )
        );
        pintuenvi2masuk.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.541176f, 0.541176f, 0.541176f, 1.0f),
                        "resources/models/enviroment/krustykrab/door1-4.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.435294f, 0.611764f, 0.654901f, 1.0f),
                        "resources/models/enviroment/krustykrab/door2-1.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.384313f, 0.47450f, 0.607843f, 1.0f),
                        "resources/models/enviroment/krustykrab/door2-2.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.00258f, 0.56078f, 0.56078f, 1.0f),
                        "resources/models/enviroment/krustykrab/door2-3.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.541176f, 0.541176f, 0.541176f, 1.0f),
                        "resources/models/enviroment/krustykrab/door2-4.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/krustykrab/pintu5.obj"
                )
        );
        //krusty krab - chandelier
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0f, 1.0f, 0.0f, 1.0f),
                        "resources/models/enviroment/krustykrab/listchandelier.obj"
                )
        );



    }

    public void input() {
        float move = 0.4f;

        //        if collision pintu menuju basement
        for (Object pintu : pintuenvi2masuk){
            if (checkCollision(character.get(0).getUpdatedVertice(), pintu.getVertices())){
//            Spongebob ke basement
                character.get(0).translateObject(+40f,-16.5f,-38f);

                Vector3f temp = character.get(0).getCenterPoint();

                // mr krab pindah ke basement
                character.get(4).translateObject(-40f,-16.5f,-70f);
//            Mr krab rotate lari ke kiri
                isMrkrablari = true;
                dienvi2=true;
                break;
            }
        }

        //        if collision pintu menuju keluar basement
        for (Object pintu : pintuenvi2keluar){
            if (checkCollision(character.get(0).getUpdatedVertice(), pintu.getVertices())){
//            Spongebob ke atas
                character.get(0).translateObject(-52f,16.5f,42f);
                dienvi2=false;
                break;
            }
        }

//        if collision pintu menuju penjara
        for (Object pintu : pintuenvi2masukpenjara){
            if (checkCollision(character.get(0).getUpdatedVertice(), pintu.getVertices())){
//            Spongebob ke penjara
                character.get(0).translateObject(-5f,0f,0f);
                break;
            }
        }

        //        if collision pintu menuju penjara
        for (Object pintu : pintuenvi2keluarpenjara){
            if (checkCollision(character.get(0).getUpdatedVertice(), pintu.getVertices())){
//            Spongebob ke penjara
                character.get(0).translateObject(5f,0f,0f);
                break;
            }
        }
        if (isMrkrablari){
//            lari keluar dari basement (ini just for showing the path of the road lah)
            if (totalLari < 30f) {
                character.get(4).translateObject(0f,0f,speedMrkrab1);
                totalLari+=speedMrkrab1;
            }else{
                totalLari=0;
                character.get(4).translateObject(40f,16.5f,40f);

                isMrkrablari = false;
            }
        }

//        mengambil titik tengah character spongebob
        int verticeSize = 0;
        Vector3f centerPoint = new Vector3f(0.0f, 0.0f, 0.0f);
        for (Vector3f vertex : character.get(0).getUpdatedVertice()) {
            centerPoint.x += vertex.x;
            centerPoint.y += vertex.y;
            centerPoint.z += vertex.z;
            verticeSize++;
        }

        centerPoint.x /= verticeSize;
        centerPoint.y /= verticeSize;
        centerPoint.z /= verticeSize;

        if (window.isKeyPressed(GLFW_KEY_I)) {
            for (Object object: enviroment){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveForward(-move);
                    break;
                }
            }
            for (Object object: enviroment2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveForward(-move);
                    break;
                }
            }
            for (Object object: lantai){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveForward(-move);
                    break;
                }
            }
            for (Object object: lantai2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveForward(-move);
                    break;
                }
            }

            character.get(0).translateObject(0.0f, 0.0f, -0.5f);

            for (Object object: enviroment){
                if (checkCollision(character.get(0).getUpdatedVertice(), object.getVertices())){
                    character.get(0).translateObject(0.0f, 0.0f, +0.5f);
                    break;
                }
            }
            for (Object object: enviroment2){
                if (checkCollision(character.get(0).getUpdatedVertice(), object.getVertices())){
                    character.get(0).translateObject(0.0f, 0.0f, +0.5f);
                    break;
                }
            }
//                    state 0 = K, 1 = J, 2 = I, 3 = L
            switch (state){
                case 0:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;
                    character.get(0).translateObject(-centerPoint.x,-centerPoint.y,-centerPoint.z);
                    character.get(0).rotateObject(180f, directionBodyX, directionBodyY, 0.0f);
                    character.get(0).translateObject(centerPoint.x,centerPoint.y,centerPoint.z);
                    break;
                case 1:
                    directionBodyX = 0.0f;
                    directionBodyY = -1.0f;
                    character.get(0).translateObject(-centerPoint.x,-centerPoint.y,-centerPoint.z);
                    character.get(0).rotateObject(90f, directionBodyX, directionBodyY, 0.0f);
                    character.get(0).translateObject(centerPoint.x,centerPoint.y,centerPoint.z);
                    break;
                case 3:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;
                    character.get(0).translateObject(-centerPoint.x,-centerPoint.y,-centerPoint.z);
                    character.get(0).rotateObject(90f, directionBodyX, directionBodyY, 0.0f);
                    character.get(0).translateObject(centerPoint.x,centerPoint.y,centerPoint.z);
                    break;
            }
            state= 2;

            currentBodyDegree = currentBodyDegree + (90f - currentBodyDegree);
            currentDeg += countDeg;
        }
        if (window.isKeyPressed(GLFW_KEY_J)) {
            for (Object object: enviroment){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveLeft(-move);
                    break;
                }
            }
            for (Object object: enviroment2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveLeft(-move);
                    break;
                }
            }
            for (Object object: lantai){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveLeft(-move);
                    break;
                }
            }
            for (Object object: lantai2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveLeft(-move);
                    break;
                }
            }

            character.get(0).translateObject(-0.5f, 0.0f, 0f);
            for (Object object: enviroment){
                if (checkCollision(character.get(0).getUpdatedVertice(), object.getVertices())){
                    character.get(0).translateObject(+0.5f, 0.0f, 0f);
                    break;
                }
            }
            for (Object object: enviroment2){
                if (checkCollision(character.get(0).getUpdatedVertice(), object.getVertices())){
                    character.get(0).translateObject(+0.5f, 0.0f, 0f);
                    break;
                }
            }

            //                    state 0 = K, 1 = J, 2 = I, 3 = L
            switch (state){
                case 0:
                    directionBodyX = 0.0f;
                    directionBodyY = -1.0f;
                    character.get(0).translateObject(-centerPoint.x,-centerPoint.y,-centerPoint.z);
                    character.get(0).rotateObject(90f, directionBodyX, directionBodyY, 0.0f);
                    character.get(0).translateObject(centerPoint.x,centerPoint.y,centerPoint.z);
                    break;
                case 2:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;

                    character.get(0).translateObject(-centerPoint.x,-centerPoint.y,-centerPoint.z);
                    character.get(0).rotateObject(90f, directionBodyX, directionBodyY, 0.0f);
                    character.get(0).translateObject(centerPoint.x,centerPoint.y,centerPoint.z);

                    break;
                case 3:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;

                    character.get(0).translateObject(-centerPoint.x,-centerPoint.y,-centerPoint.z);
                    character.get(0).rotateObject(180f, directionBodyX, directionBodyY, 0.0f);
                    character.get(0).translateObject(centerPoint.x,centerPoint.y,centerPoint.z);

                    break;
            }
            state= 1;
            currentBodyDegree = currentBodyDegree + (180f - currentBodyDegree);
            currentDeg += countDeg;


        }
        if (window.isKeyPressed(GLFW_KEY_K)) {
            for (Object object: enviroment){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveBackwards(-move);
                    break;
                }
            }
            for (Object object: enviroment2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveBackwards(-move);
                    break;
                }
            }
            for (Object object: lantai){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveBackwards(-move);
                    break;
                }
            }
            for (Object object: lantai2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveBackwards(-move);
                    break;
                }
            }

            character.get(0).translateObject(0.0f, 0.0f, 0.5f);

            for (Object object: enviroment){
                if (checkCollision(character.get(0).getUpdatedVertice(), object.getVertices())){
                    character.get(0).translateObject(0.0f, 0.0f, -0.5f);
//                    System.out.println(((Sphere)object).getFilename());
                    break;
                }
            }
            for (Object object: enviroment2){
                if (checkCollision(character.get(0).getUpdatedVertice(), object.getVertices())){
                    character.get(0).translateObject(0.0f, 0.0f, -0.5f);
//                    System.out.println(((Sphere)object).getFilename());
                    break;
                }
            }
//            titik tengah
            switch (state){
                case 1:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;
                    character.get(0).translateObject(-centerPoint.x,-centerPoint.y,-centerPoint.z);
                    character.get(0).rotateObject(90f, directionBodyX, directionBodyY, 0.0f);
                    character.get(0).translateObject(centerPoint.x,centerPoint.y,centerPoint.z);

                    break;
                case 2:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;
                    character.get(0).translateObject(-centerPoint.x,-centerPoint.y,-centerPoint.z);
                    character.get(0).rotateObject(180f, directionBodyX, directionBodyY, 0.0f);
                    character.get(0).translateObject(centerPoint.x,centerPoint.y,centerPoint.z);
                    break;
                case 3:
                    directionBodyX = 0.0f;
                    directionBodyY = -1.0f;
                    character.get(0).translateObject(-centerPoint.x,-centerPoint.y,-centerPoint.z);
                    character.get(0).rotateObject(90f, directionBodyX, directionBodyY, 0.0f);
                    character.get(0).translateObject(centerPoint.x,centerPoint.y,centerPoint.z);

                    break;
            }
            state= 0;
            currentBodyDegree = currentBodyDegree + (270f - currentBodyDegree);
            currentDeg += countDeg;

        }
        if (window.isKeyPressed(GLFW_KEY_L)) {
            for (Object object: enviroment){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveRight(-move);
                    break;
                }
            }
            for (Object object: enviroment2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveRight(-move);
                    break;
                }
            }
            for (Object object: lantai){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveRight(-move);
                    break;
                }
            }
            for (Object object: lantai2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveRight(-move);
                    break;
                }
            }

            character.get(0).translateObject(0.5f, 0.0f, 0f);
            for (Object object: enviroment){
                if (checkCollision(character.get(0).getUpdatedVertice(), object.getVertices())){
                    character.get(0).translateObject(-0.5f, 0.0f, 0f);
                    break;
                }
            }
            for (Object object: enviroment2){
                if (checkCollision(character.get(0).getUpdatedVertice(), object.getVertices())){
                    character.get(0).translateObject(-0.5f, 0.0f, 0f);
                    break;
                }
            }
            //                    state 0 = K, 1 = J, 2 = I, 3 = L
            switch (state){
                case 0:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;
                    character.get(0).translateObject(-centerPoint.x,-centerPoint.y,-centerPoint.z);
                    character.get(0).rotateObject(90f, directionBodyX, directionBodyY, 0.0f);
                    character.get(0).translateObject(centerPoint.x,centerPoint.y,centerPoint.z);

                    break;
                case 1:
                    directionBodyX = 0.0f;
                    directionBodyY = 1.0f;
                    character.get(0).translateObject(-centerPoint.x,-centerPoint.y,-centerPoint.z);
                    character.get(0).rotateObject(180f, directionBodyX, directionBodyY, 0.0f);
                    character.get(0).translateObject(centerPoint.x,centerPoint.y,centerPoint.z);

                    break;
                case 2:
                    directionBodyX = 0.0f;
                    directionBodyY = -1.0f;
                    character.get(0).translateObject(-centerPoint.x,-centerPoint.y,-centerPoint.z);
                    character.get(0).rotateObject(90f, directionBodyX, directionBodyY, 0.0f);
                    character.get(0).translateObject(centerPoint.x,centerPoint.y,centerPoint.z);

                    break;
            }
            state= 3;
            currentBodyDegree = currentBodyDegree + (180f - currentBodyDegree);
            currentDeg += countDeg;
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveForward(move);
            for (Object object: enviroment){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveForward(-move);
                    break;
                }
            }
            for (Object object: enviroment2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveForward(-move);
                    break;
                }
            }
            for (Object object: lantai){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveForward(-move);
                    break;
                }
            }
            for (Object object: lantai2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveForward(-move);
                    break;
                }
            }

        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveLeft(move);
            for (Object object: enviroment){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveLeft(-move);
                    break;
                }
            }
            for (Object object: enviroment2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveLeft(-move);
                    break;
                }
            }
            for (Object object: lantai){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveLeft(-move);
                    break;
                }
            }
            for (Object object: lantai2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveLeft(-move);
                    break;
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveBackwards(move);
            for (Object object: enviroment){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveBackwards(-move);
                    break;
                }
            }
            for (Object object: enviroment2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveBackwards(-move);
                    break;
                }
            }
            for (Object object: lantai){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveBackwards(-move);
                    break;
                }
            }
            for (Object object: lantai2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveBackwards(-move);
                    break;
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveRight(move);
            for (Object object: enviroment){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
                    camera.moveRight(-move);
                    break;
                }
            }
            for (Object object: enviroment2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveRight(-move);
                    break;
                }
            }
            for (Object object: lantai){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveRight(-move);
                    break;
                }
            }
            for (Object object: lantai2){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.0001f, camera.getPosition().y+0.0001f, camera.getPosition().z+0.0001f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveRight(-move);
                    break;
                }
            }
        }

        if(window.isKeyPressed(GLFW_KEY_5)){
            System.out.println("CPX: "+centerPoint.x);
            System.out.println("CPY: "+centerPoint.y);
            System.out.println("CPZ: "+centerPoint.z);
        }

//        enable FPS
        if(window.isKeyPressed(GLFW_KEY_1)){
            FPS = true;
            TPS = false;
            freeroam = false;
            cinematography = false;
            derajatkamera=30f;
        }
        if(window.isKeyPressed(GLFW_KEY_2)){
            FPS=false;
            TPS=true;
            freeroam=false;
            cinematography=false;
        }
        if(window.isKeyPressed(GLFW_KEY_3)){
            FPS=false;
            TPS=false;
            freeroam=false;
            cinematography=true;
            derajatkamera=30f;

        }
        if(window.isKeyPressed(GLFW_KEY_4)){
            FPS=false;
            TPS=false;
            freeroam=true;
            cinematography=false;
            derajatkamera=30f;
        }
        if(TPS){

            camera.setPosition(centerPoint.x+camXTPS,centerPoint.y+camYTPS,centerPoint.z+camZTPS);


            if(derajatkamera==30f){
                camera.setRotation((float)Math.toRadians(30),0);
                derajatkamera=0f;
            }
        }
        if(FPS){
            camera.setPosition(centerPoint.x,centerPoint.y,centerPoint.z);
        }
        if(window.isKeyPressed(GLFW_KEY_LEFT) && cinematography){
            Vector3f pos = camera.getPosition();
            camera.setPosition(-pos.x, -pos.y, -pos.z);
            camera.addRotation(0f, (float) Math.toRadians(5));
            camera.setPosition(pos.x, pos.y, pos.z);
            camRotation-=5;

            if (camRotation > 355) {
                camRotation = 0;
            }
            if (camRotation < 0) {
                camRotation = 355;
            }
            updateCameraCinematic();
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT) && cinematography){
            Vector3f pos = camera.getPosition();
            camera.setPosition(-pos.x, -pos.y, -pos.z);
            camera.addRotation(0f, (float) Math.toRadians(-5));
            camera.setPosition(pos.x, pos.y, pos.z);
            camRotation+=5;

            if (camRotation > 355) {
                camRotation = 0;
            }
            if (camRotation < 0) {
                camRotation = 355;
            }
            updateCameraCinematic();
        }

        if(mouseInput.isLeftButtonPressed()){
            Vector2f displayVec = window.getMouseInput().getDisplVec();
            camera.addRotation((float)Math.toRadians(displayVec.x * 0.1f),
                    (float)Math.toRadians(displayVec.y * 0.1f));
        }
        if(window.getMouseInput().getScroll().y != 0){
            projection.setFOV(projection.getFOV()- (window.getMouseInput().getScroll().y*0.01f));
            window.getMouseInput().setScroll(new Vector2f());
        }
//        untuk pagi
        if (window.isKeyPressed(GLFW_KEY_P)) {
            for (Sphere objects : this.enviroment)
            {
                //gambar sekalian child
                objects.setupVariabel(3250);
            }
            for (Sphere objects : this.enviroment2)
            {
                //gambar sekalian child
                objects.setupVariabel(3250);
            }
            for (Sphere objects : this.character)
            {
                //gambar sekalian child
                objects.setupVariabel(3250);
            }
            for (Sphere objects : this.lantai)
            {
                //gambar sekalian child
                objects.setupVariabel(3250);
            }
            for (Sphere objects : this.lantai2)
            {
                //gambar sekalian child
                objects.setupVariabel(3250);
            }

            skybox.gantiWaktu(3250);
        }
//        untuk malam
        if (window.isKeyPressed(GLFW_KEY_M)) {
            for (Sphere objects : this.enviroment)
            {
                //gambar sekalian child
                objects.setupVariabel(65);
            }
            for (Sphere objects : this.enviroment2)
            {
                //gambar sekalian child
                objects.setupVariabel(65);
            }
            for (Sphere objects : this.character)
            {
                //gambar sekalian child
                objects.setupVariabel(65);
            }
            for (Sphere objects : this.lantai)
            {
                //gambar sekalian child
                objects.setupVariabel(65);
            }
            for (Sphere objects : this.lantai2)
            {
                //gambar sekalian child
                objects.setupVariabel(65);
            }

            skybox.gantiWaktu(65);
        }

    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            GL.createCapabilities();
            input();
            for (Sphere objects : this.enviroment)
            {
                objects.draw(camera, projection);
            }
            for (Sphere objects : this.enviroment2)
            {
                objects.draw(camera, projection);
            }
            for(int i=0;i<character.size();i++){
                if(FPS){
                    if(i>0){
                        character.get(i).draw(camera,projection);
                    }
                }else{
                    character.get(i).draw(camera,projection);
                }
            }


            for (Sphere objects : this.lantai)
            {
                objects.draw(camera, projection);
            }
            for (Sphere objects : this.lantai2)
            {
                objects.draw(camera, projection);
            }
            for (Sphere objects : this.pintuenvi2keluarpenjara)
            {
                objects.draw(camera, projection);
            }
            for (Sphere objects : this.pintuenvi2keluar)
            {
                objects.draw(camera, projection);
            }
            for (Sphere objects : this.pintuenvi2masuk)
            {
                objects.draw(camera, projection);
            }
            for (Sphere objects : this.kamera)
            {
                objects.draw(camera, projection);
            }for (Sphere objects : this.pintuenvi2masukpenjara)
            {
                objects.draw(camera, projection);
            }


            skybox.draw(camera, projection);

            // Restore state
            glDisableVertexAttribArray(0);

            glfwPollEvents();
        }
    }

    public void run() throws IOException {

        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static float getRot() {
        return rot;
    }


    public static void main(String[] args) throws IOException {
        new PROJECT().run();
    }
    public void updateCameraCinematic(){
        ArrayList<Vector3f> track = new ArrayList<>(List.of());
        for (double i=0; i<360; i+= 360/360){
            float x = (float)(100f*Math.sin(Math.toRadians(i)));
            float z = (float)(100f*Math.cos(Math.toRadians(i)));
            track.add(new Vector3f(x, 50, z));
        }
        camera.setPosition(track.get((int)camRotation).x, track.get((int)camRotation).y, track.get((int)camRotation).z);
    }
}