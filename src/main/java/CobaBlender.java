import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class CobaBlender {
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

    boolean keyRditekan = false;
    float derajatkamera;
    private Window window =
            new Window
                    (800, 800, "Hello World");

    ArrayList<Sphere> enviroment = new ArrayList<>();
    ArrayList<Sphere> enviroment2 = new ArrayList<>();

    ArrayList<Sphere> lantai = new ArrayList<>();
    ArrayList<Sphere> lantai2 = new ArrayList<>();

    ArrayList<Sphere> character = new ArrayList<>();

    private MouseInput mouseInput;
    static float rot = 0f;

    Projection projection = new Projection(window.getWidth(), window.getHeight());
    Camera camera = new Camera();

    public void init() throws IOException {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        mouseInput = window.getMouseInput();
        camera.setPosition(0, 1f, 1.7f);
        camera.moveDown(0.6f);


        character.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
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
                        new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
                        "resources/models/character/plankton.obj"
                )
        );
        character.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
                        "resources/models/character/patrick.obj"
                )
        );

        character.get(0).translateObject(-1.5f,-0.1f,5.2f);
        character.get(0).scaleObject(3.25f,3.25f,3.25f);

        character.get(1).translateObject(-1.5f,0.2f,-2f);
        character.get(1).scaleObject(1.5f,1.5f,1.5f);

        character.get(2).translateObject(-2.2f,-1.3f,2.3f);
        character.get(2).scaleObject(12,12,10);

        character.get(3).translateObject(-25f,0.0f,0.0f);
        character.get(3).scaleObject(3,3,3);

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
//        dinding-0
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingdepankiri.obj"
                )
        );
//        1
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingdepankanan.obj"
                )
        );
//        2
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingsampingkiri.obj"
                )
        );
//        3
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingsampingkanan.obj"
                )
        );
//        4
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingbelakang.obj"
                )
        );
//        5
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/atap.obj"
                )
        );
//        6
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
//        7
        lantai.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.08627f, 0.19216f, 0.113725f, 1.0f),
                        "resources/models/enviroment/krustykrab/lantai.obj"
                )
        );
////        perahu
////        8
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.5176f, 0.1647f, 0.1607f, 1.0f),
                        "resources/models/enviroment/krustykrab/kapalbagiandalam.obj"
                )
        );
////        9
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                        "resources/models/enviroment/krustykrab/kapalbagianluar.obj"
                )
        );
//        10
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
//        11
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
//        12
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
//        13
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
//        14
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
//        15
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
//        17
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.2902f, 0.3765f, 0.4911f, 1.0f),
                        "resources/models/enviroment/krustykrab/handle-pintu.obj"
                )
        );
//        pintu keluar
//        18
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.450980f, 0.72156f, 0.83529f, 1.0f),
                        "resources/models/enviroment/krustykrab/pintu.obj"
                )
        );
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
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu1-1.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu1-2.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu1-3.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu2-1.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/ruangbelakang/env2-pintu2-2.obj"
                )
        );
        enviroment2.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
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
//        pintu
//        20
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.435294f, 0.611764f, 0.654901f, 1.0f),
                        "resources/models/enviroment/krustykrab/pintu1.obj"
                )
        );
//        21
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.384313f, 0.47450f, 0.607843f, 1.0f),
                        "resources/models/enviroment/krustykrab/pintu2.obj"
                )
        );
//        22
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.00258f, 0.56078f, 0.56078f, 1.0f),
                        "resources/models/enviroment/krustykrab/pintu3.obj"
                )
        );
//        23
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.541176f, 0.541176f, 0.541176f, 1.0f),
                        "resources/models/enviroment/krustykrab/pintu4.obj"
                )
        );
//        24
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.501960f, 0.474509f, 0.38431f, 1.0f),
                        "resources/models/enviroment/krustykrab/pintu5.obj"
                )
        );
        //        chandelier
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
        System.out.println("X: "+camera.getPosition().x);
        System.out.println("Y: "+camera.getPosition().y);
        System.out.println("Z: "+camera.getPosition().z);
        if (window.isKeyPressed(GLFW_KEY_I)) {
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
        }
        if (window.isKeyPressed(GLFW_KEY_J)) {
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
        }
        if (window.isKeyPressed(GLFW_KEY_K)) {
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
        }
        if (window.isKeyPressed(GLFW_KEY_L)) {
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
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveForward(move);
            for (Object object: enviroment){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.025f, camera.getPosition().y+0.025f, camera.getPosition().z+0.025f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveForward(-move);
                    break;
                }
            }

        }


        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveLeft(move);
            for (Object object: enviroment){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.025f, camera.getPosition().y+0.025f, camera.getPosition().z+0.025f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveLeft(-move);
                    break;
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveBackwards(move);
            for (Object object: enviroment){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.025f, camera.getPosition().y+0.025f, camera.getPosition().z+0.025f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveBackwards(-move);
                    break;
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveRight(move);
            for (Object object: enviroment){
                if (checkCollision(new ArrayList<>(Arrays.asList(new Vector3f(camera.getPosition().x+0.025f, camera.getPosition().y+0.025f, camera.getPosition().z+0.025f))), object.getVertices())){
//                    System.out.println("COLLISION with " + ((Sphere)object).getFilename());
                    camera.moveRight(-move);
                    break;
                }
            }
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
                //gambar sekalian child
                objects.draw(camera, projection);
            }
            for (Sphere objects : this.enviroment2)
            {
                //gambar sekalian child
                objects.draw(camera, projection);
            }
            for (Sphere objects : this.character)
            {
                //gambar sekalian child
                objects.draw(camera, projection);
            }

            for (Sphere objects : this.lantai)
            {
                //gambar sekalian child
                objects.draw(camera, projection);
            }
            for (Sphere objects : this.lantai2)
            {
                //gambar sekalian child
                objects.draw(camera, projection);
            }

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

    public static void setRot(float rot) {
        Main.rot += rot;
    }

    public static void main(String[] args) throws IOException {
        new CobaBlender().run();
    }
}