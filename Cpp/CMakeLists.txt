cmake_minimum_required(VERSION 3.16.0)

project(LeetCodeCpp)

set(CMAKE_CXX_STANDARD 14)
set(CMAKE_OSX_SYSROOT /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk)

include_directories(./)
add_subdirectory(Solutions)
include_directories(Solutions)
add_subdirectory(Utils)
include_directories(Utils)


aux_source_directory(. DIR_SRC)
add_executable(${PROJECT_NAME} ${DIR_SRC})
target_link_libraries(${PROJECT_NAME} Utils Solutions)
