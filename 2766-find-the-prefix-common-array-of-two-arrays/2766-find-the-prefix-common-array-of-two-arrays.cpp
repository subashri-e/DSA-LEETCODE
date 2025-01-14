class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
        int n = A.size();
        vector<int> C(n);
        unordered_set<int> seenA, seenB;

        for (int i = 0; i < n; ++i) {
            seenA.insert(A[i]);
            seenB.insert(B[i]);

            int commonCount = 0;
            for (const auto& num : seenA) {
                if (seenB.count(num)) {
                    commonCount++;
                }
            }
            C[i] = commonCount;
        }
        return C;
    }
};