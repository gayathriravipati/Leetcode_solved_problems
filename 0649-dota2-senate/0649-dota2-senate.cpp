class Solution {
public:
  string predictPartyVictory(string senate) {

    int n = senate.size();

    vector<bool> banned(n, false);

    vector<int> rIndices, dIndices;
    for (int i = 0; i < n; i++) {
      if (senate[i] == 'R')
        rIndices.push_back(i);
      else
        dIndices.push_back(i);
    }

    // Ban the senator of "indices" array next to "startAt"
    auto ban = [&](vector<int> &indices, int start_at) {
      // Find the index of "index of senator to ban" using Binary Search
      auto temp = lower_bound(indices.begin(), indices.end(), start_at);

      
      if (temp == indices.end()) {
        banned[indices[0]] = true;
        indices.erase(indices.begin());
      }

      else {
        banned[*temp] = true;
        indices.erase(temp);
      }
    };

    int turn = 0;

    while (!rIndices.empty() && !dIndices.empty()) {

      if (!banned[turn]) {
        if (senate[turn] == 'R')
          ban(dIndices, turn);
        else
          ban(rIndices, turn);
      }

      turn = (turn + 1) % n;
    }

    return dIndices.empty() ? "Radiant" : "Dire";
  }
};