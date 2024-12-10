cmake_minimum_required(VERSION 3.28)
project(untitled3)

set(CMAKE_CXX_STANDARD 17)

# Specify the path to the JDK
set(JAVA_HOME "/Library/Java/JavaVirtualMachines/jdk-23.jdk/Contents/Home")

# Add JNI include directories
include_directories(${JAVA_HOME}/include)
include_directories(${JAVA_HOME}/include/darwin)

# Add shared library
add_library(untitled3 SHARED JavaToPythonConverter.c)

# Link JNI libraries
find_package(JNI REQUIRED)
target_link_libraries(untitled3 ${JNI_LIBRARIES})