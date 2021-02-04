//
// Created by Sines on 2021/2/4.
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace L855_ExamRoom {
    using namespace std;
    class ExamRoom {
    private:
        map<int, int> seats;
    public:
        ExamRoom(int N) {

        }

        int seat() {

        }

        void leave(int p) {

        }
    };

    class Solution : BaseSolution {
        void run() override {
            auto *a = new ExamRoom(10);
            a->seat();
            a->seat();
            a->seat();
            a->seat();
            a->leave(4);
            a->seat();
            delete a;
        }
    };
};