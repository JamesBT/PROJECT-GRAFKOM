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

//        krustykrab
//        dinding
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingdepankiri.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingdepankanan.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingsampingkiri.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingsampingkanan.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.423529f, 0.325490f, 0.145098f, 1.0f),
                        "resources/models/enviroment/krustykrab/dindingbelakang.obj"
                )
        );
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
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.5176f, 0.1647f, 0.1607f, 1.0f),
                        "resources/models/enviroment/krustykrab/kapalbagiandalam.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                        "resources/models/enviroment/krustykrab/kapalbagianluar.obj"
                )
        );
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
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.32549019607f, 0.215686274f, 0.1450980f, 1.0f),
                        "resources/models/enviroment/krustykrab/listkursi.obj"
                )
        );
//        meja
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0705f, 0.08235f, 0.15294f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja1.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.43921f, 0.11764f, 0.12549f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja2.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.57647f, 0.52549f, 0.25882f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja3.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.35686f, 0.450980f, 0.59215f, 1.0f),
                        "resources/models/enviroment/krustykrab/meja4.obj"
                )
        );
//        barang di atas (belakang menu)
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
//        pintu keluar
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
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.2902f, 0.3765f, 0.4911f, 1.0f),
                        "resources/models/enviroment/krustykrab/daftarmenu.obj"
                )
        );
//        pintu
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.435294f, 0.611764f, 0.654901f, 1.0f),
                        "resources/models/enviroment/krustykrab/pintu1.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.384313f, 0.47450f, 0.607843f, 1.0f),
                        "resources/models/enviroment/krustykrab/pintu2.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.00258f, 0.56078f, 0.56078f, 1.0f),
                        "resources/models/enviroment/krustykrab/pintu3.obj"
                )
        );
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.541176f, 0.541176f, 0.541176f, 1.0f),
                        "resources/models/enviroment/krustykrab/pintu4.obj"
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
        enviroment.add(new Sphere
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.254901f, 0.35686f, 0.13725f, 1.0f),
                        "resources/models/enviroment/krustykrab/bagianbawah2.obj"
                )
        );
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



            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
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