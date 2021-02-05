//
// Created by Sines on 2021/2/3.
//

#include <Solutions/BaseSolution.h>
#include "PublicHeaders.h"
#include <cctype>

namespace TwoPointers {
    namespace L125_ValidPalindrome {
    using namespace std;
    class Solution: BaseSolution {
    public:
        bool isPalindrome(string s) {
            int len = s.length();
            for (int i = 0, j = len - 1; i < j;) {
                while (isalnum(s[i]) == 0 && i < j) i++;
                while (isalnum(s[j]) == 0 && i < j) j--;
                if (tolower(s[i]) != tolower(s[j])) return false;
                i++; j--;
            }
            return true;
        }

        void run() override {
            bool ans = isPalindrome("A man, a plan, a canal: Panama");
            cout << ans << endl;
        }
    };


};
}
