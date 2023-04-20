import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class MainAngel {
    private Window window = new Window(800,800,"Hello World");
    private ArrayList<ObjectAngel> objectAngels
            = new ArrayList<>();
    private ArrayList<ObjectAngel> objectsRectangle
            = new ArrayList<>();

    private ArrayList<ObjectAngel> objectsPointsControl
            = new ArrayList<>();
    private MouseInput mouseInput;
    Camera camera=new Camera();
    Projection projection=new Projection(window.getWidth(),window.getHeight());
    public void init(){
        window.init();
        GL.createCapabilities();
        mouseInput = window.getMouseInput();
        camera.setPosition(0,0,2.5f);
        camera.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(0.0f));
        //code
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
        objectAngels.get(0).getChildObject().add(new CylinderAngel(   //c23 lengan bawah kanan
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
        objectAngels.get(0).getChildObject().get(22).rotateObject((float)Math.toRadians(90.0f),0.0f,1.0f,0f);
        objectAngels.get(0).getChildObject().get(22).translateObject(-0.65f,-0.1f,0.0f);
        objectAngels.get(0).getChildObject().add(new SphereAngel(   //c24 gloves hand kanan
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
        objectAngels.get(0).getChildObject().get(23).translateObject(0.68f,0.1f,0.0f);
        objectAngels.get(0).getChildObject().get(23).rotateObject((float)Math.toRadians(90.0f),1.0f,0f,0.0f);
        objectAngels.get(0).getChildObject().get(23).translateObject(-0.68f,-0.1f,0.0f);
        objectAngels.get(0).getChildObject().add(new SphereAngel(   //c25 gloves thumb kanan
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
        objectAngels.get(0).getChildObject().get(24).translateObject(0.68f,0.05f,0.0f);
        objectAngels.get(0).getChildObject().get(24).rotateObject((float)Math.toRadians(-55.0f),0.0f,0f,1.0f);
        objectAngels.get(0).getChildObject().get(24).translateObject(-0.65f,-0.06f,0.0f);

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
        objectAngels.get(0).getChildObject().get(29).addVertices(new Vector3f(-0.2f, -0.1f, 0.3f));
        objectAngels.get(0).getChildObject().get(29).addVertices(new Vector3f(-0.1f, -0.2f, 0.3f));
        objectAngels.get(0).getChildObject().get(29).addVertices(new Vector3f(0f, -0.25f, 0.3f));
        objectAngels.get(0).getChildObject().get(29).addVertices(new Vector3f(0.1f, -0.2f, 0.3f));
        objectAngels.get(0).getChildObject().get(29).addVertices(new Vector3f(0.2f, -0.1f, 0.3f));

        objectAngels.get(0).getChildObject().get(29).updateCurve(objectAngels.get(0).getChildObject().get(29).getVertices());
        objectAngels.get(0).getChildObject().get(29).setThickness(5);
    }
    public void input(){
        if(window.isKeyPressed(GLFW_KEY_W)) {   //rotasi sumbu z
            for(ObjectAngel object: objectAngels){
                object.rotateObject((float)Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_A)) {   //rotasi sumbu y
            for(ObjectAngel object: objectAngels){
                object.rotateObject((float)Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_S)) {   //rotasi sumbu x
            for(ObjectAngel object: objectAngels){
                object.rotateObject((float)Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_Q)) {   //tangan gerak
            Vector3f tempCenterPoint= objectAngels.get(0).getChildObject().get(22).updateCenterPoint();
            objectAngels.get(0).getChildObject().get(22).translateObject(-tempCenterPoint.x,-tempCenterPoint.y,-tempCenterPoint.z);
            objectAngels.get(0).getChildObject().get(22).rotateObject((float)Math.toRadians(-0.5f),0.0f,0.0f,1.0f);
            objectAngels.get(0).getChildObject().get(22).translateObject(tempCenterPoint.x,tempCenterPoint.y,tempCenterPoint.z);
        }
        if(window.isKeyPressed(GLFW_KEY_E)) {   //terbang
            objectAngels.get(0).translateObject(0.0f,0.1f,0.0f);
        }
        if(window.isKeyPressed(GLFW_KEY_R)) {   //mendarat
            objectAngels.get(0).translateObject(0.0f,-0.1f,0.0f);
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
            for(ObjectAngel object: objectAngels){
                object.draw(camera,projection);
            }
//            for(ObjectG object: objectsRectangle){
//                object.draw();
//            }
//            for(ObjectG object: objectsPointsControl){
//                object.drawLine();
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
        new MainAngel().run();
    }
}