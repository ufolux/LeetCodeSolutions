//
// Created by Sines on 2021/2/3.
//

#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace L925_LongPressedName {
    using namespace std;

    class Solution : BaseSolution {
        bool isLongPressedName(string name, string typed) {
            if (name.length() > typed.length()) return false;
            int i = 0;
            int j = 0;
            while (i < name.length() && j < typed.length()) {
                if (name[i] == typed[j]) {
                    i++; j++;
                } else if (j > 0 && typed[j] == typed[j - 1]) {
                    j++;
                } else {
                    return false;
                }
            }
            while (j < typed.length()) {
                if (typed[j] != typed[j-1]) return false;
                j++;
            }
            return i == name.length();
        }

        void run() override {
            bool ans = isLongPressedName("alex", "aaleexa");
            cout << ans << endl;
        }
    };
};