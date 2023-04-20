package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class CylinderAngel extends CircleAngel {
    float radiusZ;
    int stackCount;
    int sectorCount;
    List<ShaderModuleData> shaderModuleDataList;
    public CylinderAngel(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                         int sectorCount, int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.shaderModuleDataList=shaderModuleDataList;
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        createCylinder();
        setupVAOVBO();
    }
    public void createCylinder(){
        float count = 300;
        vertices.clear();
        for (float j = 0; j <= radiusY; j += radiusY/count) {
            for (float i = 0; i < 360; i += 360/count) {
                double rad = degToRad(i);
                float x = (float) (centerPoint.get(0) + Math.cos(rad) * radiusX);
                float z = (float) (centerPoint.get(1) + Math.sin(rad) * radiusZ);
                vertices.add(new Vector3f(x, z, j));
            }
        }

    }
    public void draw(Camera camera,Projection projection){
        drawSetup(camera,projection);
        glLineWidth(5); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        glDrawArrays(GL_POLYGON,0,vertices.size());
        for(ObjectAngel child:childObject){
            child.draw(camera,projection);
        }
    }
}