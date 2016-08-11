#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>
using namespace std;

int main()
{
	vector<int> coll;
	int n;
	
	while(cin >> n && n)
	{
		coll.push_back(n);
	}
	
	sort(coll.begin(), coll.end());
	
	cin >> n;
	if(binary_search(coll.begin(), coll.end(), n))
	{
		cout << "Find " << n << endl;
	}
	else
	{
		cout << "Not Found!" << endl;
	}

	return 0;
}