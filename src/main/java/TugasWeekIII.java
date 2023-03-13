
import Engine.*;
import org.joml.Vector4f;
import java.util.ArrayList;
import java.util.Arrays;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL20.*;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;

public class TugasWeekIII
{
    private final Window window = new Window(800, 800, "Tugas III");

    ArrayList<CircleCopy> objects = new ArrayList<>();
    ArrayList<CircleCopy> objectsLine = new ArrayList<>();
    ArrayList<Object2dCopy> curve = new ArrayList<>();
    ArrayList<Object2dCopy> line = new ArrayList<>();

    CircleCopy target;
    Vector2f pos;
    boolean collisionFree = true, curveMode = true;
    double jarak;
    int index;

    public static void main(String[] args)
    {
        new TugasWeekIII().run();
    }

    public void run()
    {
        init();
        loop();
    }

    public void init()
    {
        window.init();
        GL.createCapabilities();

        //object khusus line lurus
        {
            line.add(new Object2dCopy(
                            Arrays.asList
                                    (
                                            new ShaderProgram.ShaderModuleData
                                                    ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                            new ShaderProgram.ShaderModuleData
                                                    ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                                    ),
                            new ArrayList<>(),
                            new Vector4f(0.0f, 1.0f, 0.0f, 1.0f)    //color
                    )
            );
        }

    }

    public void input()
    {
        if(window.getMouseInput().isLeftButtonPressed())
        {
            //ambil posisi
            pos = getPosition(window);



            //if buat cek kalo value lebih dari 1/-1 tidak usah ditampilkan
            if((!(pos.x > 1 || pos.x < -0.997) && !(-pos.y > 1 || -pos.y < -1)) && curveMode)
            {
                //collision detection
                index = -1;
                for(CircleCopy i : objects)
                {
                    index++;
                    jarak = Math.sqrt(Math.pow((pos.x - i.getCpx()), 2) + Math.pow((-pos.y - i.getCpy()), 2));
                    if(jarak < 0.095)
                    {
                        collisionFree = false;
                        target = i;
                        break;
                    }
                    else
                    {
                        collisionFree = true;
                    }
                }

                //kalo bebas collision, buat objek baru
                //kalo objek sudah 3, bikin kurva baru
                if(collisionFree)
                {
                    //gambar kurva tiap 3 titik
                    if(objects.size() % 3 == 2)
                    {
                        {
                            curve.add(new Object2dCopy(
                                            Arrays.asList
                                                    (
                                                            new ShaderProgram.ShaderModuleData
                                                                    ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                                            new ShaderProgram.ShaderModuleData
                                                                    ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                                                    ),
                                            new ArrayList<>(),
                                            new Vector4f(0.0f, 1.0f, 0.0f, 1.0f)    //color
                                    )
                            );
                        }
                        curve.get(curve.size()-1).addVertices(objects.get(objects.size()-2).getCpx(), objects.get(objects.size()-2).getCpy(), objects.get(objects.size()-1).getCpx(), objects.get(objects.size()-1).getCpy(), pos.x, -pos.y);
                    }

                    //buat kotak baru sesuai posisi mouse
                    {
                        objects.add(new CircleCopy
                                (
                                        Arrays.asList
                                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                                        new ArrayList<>(),
                                        new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),0.05, pos.x, -pos.y, 2
                                )
                        );
                    }
                }


                //kalo collision, update titik pusat kotak
                //kurva yg pake titik itu juga akan diubah sesuai dengan kotak yg lagi dipindah
                else
                {
                    target.updateCP(pos.x, -pos.y);
                    if(index >= 0 && objects.size() % 3 == 0)
                    {
                        if(index%3 == 0)
                        {
                            curve.get(index/3).addVertices(pos.x, -pos.y, objects.get(index+1).getCpx(), objects.get(index+1).getCpy(), objects.get(index+2).getCpx(), objects.get(index+2).getCpy());
                        }
                        else if(index%3 == 1)
                        {
                            curve.get(index/3).addVertices(objects.get(index-1).getCpx(), objects.get(index-1).getCpy(), pos.x, -pos.y, objects.get(index+1).getCpx(), objects.get(index+1).getCpy());
                        }
                        else
                        {
                            curve.get(index/3).addVertices(objects.get(index-2).getCpx(), objects.get(index-2).getCpy(), objects.get(index-1).getCpx(), objects.get(index-1).getCpy(), pos.x, -pos.y);
                        }
                    }

                }
            }

            else if((!(pos.x > 1 || pos.x < -0.997) && !(-pos.y > 1 || -pos.y < -1)) && !curveMode)
            {
                //collision detection
                index = -1;
                for(CircleCopy i : objectsLine)
                {
                    index++;
                    jarak = Math.sqrt(Math.pow((pos.x - i.getCpx()), 2) + Math.pow((-pos.y - i.getCpy()), 2));
                    if(jarak < 0.095)
                    {
                        collisionFree = false;
                        target = i;
                        break;
                    }
                    else
                    {
                        collisionFree = true;
                    }
                }

                //kalo bebas collision, buat objek baru
                if(collisionFree)
                {
                    //gambar garis setiap titik
                    line.get(0).addVertices(new Vector3f(pos.x, -pos.y, 0));

                    //buat kotak baru sesuai posisi mouse
                    {
                        objectsLine.add(new CircleCopy
                                (
                                        Arrays.asList
                                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                                        new ArrayList<>(),
                                        new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),0.05, pos.x, -pos.y, 2
                                )
                        );
                    }
                }


                //kalo collision, update titik pusat kotak
                //kurva yg pake titik itu juga akan diubah sesuai dengan kotak yg lagi dipindah
                else
                {
                    target.updateCP(pos.x, -pos.y);
                    line.get(0).updateVertice(index, new Vector3f(pos.x, -pos.y, 0));
                }
            }


        }

        //delete semua kalo pencet delete
        if(window.isKeyPressed(GLFW_KEY_DELETE))
        {
            objects.clear();
            objectsLine.clear();
            curve.clear();
            line.clear();
            line.add(new Object2dCopy(
                            Arrays.asList
                                    (
                                            new ShaderProgram.ShaderModuleData
                                                    ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                            new ShaderProgram.ShaderModuleData
                                                    ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                                    ),
                            new ArrayList<>(),
                            new Vector4f(0.0f, 1.0f, 0.0f, 1.0f)    //color
                    )
            );
            collisionFree = true;
        }

        if(window.isKeyPressed(GLFW_KEY_M))
        {
            System.out.println("NORMAL MODE");
            curveMode = false;
            collisionFree = true;

        }

        if(window.isKeyPressed(GLFW_KEY_N))
        {
            System.out.println("CURVE MODE");
            curveMode = true;
            collisionFree = true;
        }

    }

    public void loop()
    {
        while (window.isOpen())
        {
            //Restore State
            window.update();
            glClearColor(0.0f, 0.0f, 1.0f, 0.0f);
            GL.createCapabilities();

            //Code
            for (Object2dCopy object2d : curve)
            {
                //1 warna
                object2d.drawLine();
            }

            for (Object2dCopy object2d : line)
            {
                //1 warna
                object2d.drawLine();
            }

            for (Object2dCopy object2d : objects)
            {
                //1 warna
                object2d.draw();
            }

            for (Object2dCopy object2d : objectsLine)
            {
                //1 warna
                object2d.draw();
            }

            //Poll for window event
            glDisableVertexAttribArray(0);
            glfwPollEvents();

            input();
        }
    }

    public Vector2f getPosition(Window window)
    {
        Vector2f pos = window.getMouseInput().getCurrentPos();

        pos.x = (pos.x - (window.getWidth())/2f) / (window.getWidth() / 2f);
        pos.y = (pos.y - (window.getHeight())/2f) / (window.getHeight() / 2f);
        return pos;
    }
}