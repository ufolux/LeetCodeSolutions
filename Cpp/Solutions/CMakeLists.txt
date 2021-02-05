aux_source_directory(. DIR_SOLUTIONS_SRC)

add_subdirectory(DP)
include_directories(DP)
add_subdirectory(TwoPointers)
include_directories(TwoPointers)
add_subdirectory(Array)
include_directories(Array)

add_library(Solutions ${DIR_SOLUTIONS_SRC})
target_link_libraries(DP TwoPointers Array)