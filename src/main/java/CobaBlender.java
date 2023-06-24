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
    boolean keyRditekan = false;
    float derajatkamera;
    private Window window =
            new Window
                    (800, 800, "Hello World");

    ArrayList<Sphere> enviroment = new ArrayList<>();
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
                        "resources/models/character/squidward.obj"
                )
        );
        character.get(0).translateObject(-1.5f,0f,-2f);
        character.get(0).scaleObject(2,2,2);
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
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.08627f, 0.19216f, 0.113725f, 1.0f),
                        "resources/models/enviroment/krustykrab/lantai.obj"
                )
        );
//        perahu
//        8
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.5176f, 0.1647f, 0.1607f, 1.0f),
                        "resources/models/enviroment/krustykrab/kapalbagiandalam.obj"
                )
        );
//        9
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
//        list kursi
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
//        25
//      bagian bawah krusty krab
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.32941f, 0.349019f, 0.37647f, 1.0f),
                        "resources/models/enviroment/krustykrab/bagianbawah1.obj"
                )
        );
//        26
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.254901f, 0.35686f, 0.13725f, 1.0f),
                        "resources/models/enviroment/krustykrab/bagianbawah2.obj"
                )
        );
//        27
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.58039f, 0.5647f, 0.36078f, 1.0f),
                        "resources/models/enviroment/krustykrab/bagianbawah3.obj"
                )
        );

        //        chandelier
//        28
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

        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveForward(move);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveLeft(move);
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveBackwards(move);

        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveRight(move);

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
            for (Sphere objects : this.character)
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
            for (Sphere objects : this.character)
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
            for (Sphere objects : this.character)
            {
                //gambar sekalian child
                objects.draw(camera, projection);
            }
            System.out.println(enviroment.get(0).getCpz());




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