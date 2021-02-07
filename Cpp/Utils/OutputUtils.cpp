//
// Created by Sines on 2021/2/7.
//

#include "OutputUtils.h"
using namespace std;

template<typename T>
void OutputUtils::printVector(vector <T> &vec) {
    cout << "{";
    for (T ele: vec) {
        cout << ele << ", ";
    }
    cout << endl;
}