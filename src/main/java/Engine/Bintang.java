package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class Bintang extends Object2d{

    List<Integer> index;
    int ibo;
    public Bintang(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color,List<Integer> index) {
        super(shaderModuleDataList, vertices, color);
        this.index = index;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void draw(){
        drawSetup();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glDrawElements(GL_LINES,index.size(),GL_UNSIGNED_INT,0);
    }
}
