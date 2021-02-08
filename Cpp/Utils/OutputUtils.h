//
// Created by Sines on 2021/2/7.
//

#ifndef LEETCODECPP_OUTPUTUTILS_H
#define LEETCODECPP_OUTPUTUTILS_H

#include "PublicHeaders.h"

class OutputUtils {
public:
    template<typename T>
    static void printVector(std::vector<T> &vec) {
        std::cout << "{";
        std::copy(vec.begin(), vec.end(), std::ostream_iterator<T> (std::cout, ","));
        std::cout << "}";
        std::cout << std::endl;
    }
};


#endif //LEETCODECPP_OUTPUTUTILS_H
