package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Circle extends Object
{
    double x, y, r, cpx, cpy;

    //constructor standar
    public Circle(List<ShaderProgram.ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double r, double cpx, double cpy)
    {
        super(shaderModuleDataList, vertices, color);
        this.r = r;
        this.cpx = cpx;
        this.cpy = cpy;
    }


    public void draw()
    {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_POLYGON, 0, vertices.size());
    }
}
