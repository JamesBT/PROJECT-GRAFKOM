#version 330

layout (location=0) in vec3 position;
uniform mat4 model;
void main() {
//    ini DIBALIK karena komputer baca dari kanan
    gl_Position = model * vec4(position,1.0);
}