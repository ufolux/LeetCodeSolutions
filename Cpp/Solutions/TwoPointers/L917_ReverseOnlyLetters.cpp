//
// Created by Sines on 2021/2/3.
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>
namespace TwoPointers {
    namespace L917_ReverseOnlyLetters {
    using namespace std;

    class Solution : BaseSolution {
    public:
        string reverseOnlyLetters(string s) {
            int len = s.length();
            for (int i = 0, j = len - 1; i < j;) {
                while (i < j && isalpha(s[i]) == 0) i++;
                while (i < j && isalpha(s[j]) == 0) j--;
                char t = s[i];
                s[i] = s[j];
                s[j] = t;
                i++;
                j--;
            }
            return s;
        }

        void run() override {
            string ans = reverseOnlyLetters("Test1ng-Leet=code-Q!");
            cout << ans << endl;
        }
    };
};
}
