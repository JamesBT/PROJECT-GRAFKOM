package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class Bintang extends Object2d{

    List<Integer> index;
    int ibo;
    double x, y, r, cx, cy;
    public Bintang(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color,List<Integer> index) {
        super(shaderModuleDataList, vertices, color);
        this.index = index;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public Bintang(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color,double besar, double cx,double cy, List<Integer> index)
    {
        super(shaderModuleDataList, vertices, color);
        this.r = besar;
        this.cx = cx;
        this.cy = cy;
        this.index=index;
        createStar();
        setupVAOVBO();
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void createStar()
    {
        //clear vertices
        vertices.clear();

        for (float i = 36; i < 396; i+=72)
        {
            x = cx + r * Math.cos(Math.toRadians(i));
            y = cy + r * Math.sin(Math.toRadians(i));
            System.out.println(x+"      "+y);
            vertices.add(new Vector3f((float) x, (float) y, 0.0f));
        }

    }

    public void draw(){
        drawSetup();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glDrawElements(GL_LINES,index.size(),GL_UNSIGNED_INT,0);
    }
}
