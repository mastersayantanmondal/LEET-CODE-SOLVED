class Solution {
public:
    double maxAverageRatio(vector<vector<int>>& classes, int extraStudents) {
        auto gain = [](int passCount, int totalCount) {
            return (double)(passCount + 1) / (totalCount + 1) - (double)passCount / totalCount;
        };

        priority_queue<pair<double, pair<int, int>>> maxHeap;

        for (const auto& c : classes) {
            int passCount = c[0], totalCount = c[1];
            maxHeap.push({gain(passCount, totalCount), {passCount, totalCount}});
        }

        for (int i = 0; i < extraStudents; ++i) {
            auto [currentGain, classData] = maxHeap.top();
            maxHeap.pop();

            int passCount = classData.first;
            int totalCount = classData.second;

            ++passCount;
            ++totalCount;

            maxHeap.push({gain(passCount, totalCount), {passCount, totalCount}});
        }

        double totalRatio = 0.0;
        while (!maxHeap.empty()) {
            auto [_, classData] = maxHeap.top();
            maxHeap.pop();

            int passCount = classData.first;
            int totalCount = classData.second;

            totalRatio += (double)passCount / totalCount;
        }

        return totalRatio / classes.size();
    }
};
