//
// Created by Sines on 2021/2/4.
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>
namespace TwoPointers {
    namespace L855_ExamRoom {
    using namespace std;
        class ExamRoom {
        private:
            set<int> seats;
            int n;
        public:
            ExamRoom(int N) {
                n = N;
            }

            int seat() {
                if (seats.empty()) {
                    seats.insert(0);
                    return 0;
                }
                // divide into n ranges
                int pre = *seats.begin();
                int max_dis = pre;
                int st = 0, ed = 0;
                for (auto s: seats) {
                    int dis = (s - pre) / 2;
                    if (dis > max_dis) {
                        max_dis = dis;
                        st = pre;
                        ed = s;
                    }
                    pre = s;
                }

                int ans = (ed + st) / 2;
                if (n - 1 - pre > max_dis) {
                    ans = n - 1;
                }
                seats.insert(ans);
                return ans;
            }

            void leave(int p) {
                seats.erase(p);
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
}
