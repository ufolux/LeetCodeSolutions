cmake_minimum_required(VERSION 3.17.0)

project(LeetCodeCpp)

set(CMAKE_CXX_STANDARD 14)

include_directories(./)
add_subdirectory(Solutions)
include_directories(Solutions)


aux_source_directory(. DIR_SRC)
add_executable(${PROJECT_NAME} ${DIR_SRC})
target_link_libraries(${PROJECT_NAME} Solutions)