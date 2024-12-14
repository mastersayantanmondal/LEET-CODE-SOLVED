#include <queue>
#include <string>
using namespace std;

class Solution {
public:
    string predictPartyVictory(string senate) {
        // Two queues to track the senators' indices for each party
        queue<int> radiant_queue;
        queue<int> dire_queue;
        
        int n = senate.size();
        
        // Fill the queues with the indices of Radiant ('R') and Dire ('D') senators
        for (int i = 0; i < n; i++) {
            if (senate[i] == 'R') {
                radiant_queue.push(i);
            } else {
                dire_queue.push(i);
            }
        }
        
        // Process the rounds
        while (!radiant_queue.empty() && !dire_queue.empty()) {
            int radiant = radiant_queue.front();
            int dire = dire_queue.front();
            
            radiant_queue.pop();
            dire_queue.pop();
            
            // The senator with the smaller index bans the other
            if (radiant < dire) {
                // Radiant bans Dire, so Radiant goes to the back of the queue with a new index
                radiant_queue.push(radiant + n);
            } else {
                // Dire bans Radiant, so Dire goes to the back of the queue with a new index
                dire_queue.push(dire + n);
            }
        }
        
        // If Radiant's queue is not empty, Radiant wins, otherwise Dire wins
        return radiant_queue.empty() ? "Dire" : "Radiant";
    }
};
