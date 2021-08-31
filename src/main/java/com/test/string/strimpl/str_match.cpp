#include <iostream>
#include <string>

using namespace std;

int patternMatching(string p1, string p2);

int main()
{
    string a = "testtest1sdfa";
    string b = "1sd";
    int result = patternMatching(a, b);
    cout << result << endl;
    return result;
}

int patternMatching(string p1, string p2)
{
    int i = 0, j = 0;
    while (i < p1.length() && j < p2.length())
    {
        if (p1[i] == p2[j])
        {
            i++;
            j++;
        }
        else
        {
            j = 0;
            i = i - j + 2;
        }
    }
    if (j == p2.length())
    {
        return i-j;
    }
    else
    {
        return -1;
    }
}