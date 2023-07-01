#include <iostream>
#include <string>
#include <functional>
#include <map>
#include <boost/any.hpp>

using namespace std;

bool replace(string& expr, const string& from, const string& to) {
    size_t start_pos = expr.find(from);
    if(start_pos == string::npos)
      return false;
    expr.replace(start_pos, from.length(), to);
    return true;
}

string replace_all(string expr, const map<string,string>& replacement) {
  for(auto const& [key, val] : replacement)
    while(replace(expr, key, val));
  return expr;
}

int main(int argc, char **argv) {
  map<string, string> months = {{"fox","cat"},{"dog","coon"},{"brown","red"}};
  cout << replace_all("The quick brown fox jumps over the lazy dog!", months) << endl;
  return 0;
}
