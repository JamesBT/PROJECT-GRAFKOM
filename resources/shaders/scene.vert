#version 330

layout (location=0) in vec3 position;
uniform mat4 model;
uniform mat4 view;
uniform mat4 projection;
void main() {
//    ini DIBALIK karena komputer baca dari kanan
    gl_Position = projection * view * model * vec4(position,1.0);
}