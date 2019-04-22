class TopVotedCandidate {
    
    Map<Integer, Integer> count = new HashMap<>();
    
    int[] time_order;
    
    Integer lead = -1;
    
    Map<Integer, Integer> time2lead = new HashMap<>();
    
    public TopVotedCandidate(int[] persons, int[] times) {
        for (int i = 0; i< persons.length; ++i) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if (i == 0 || count.get(persons[i]) >= count.get(lead)) {
                lead = persons[i];
            }
            time2lead.put(times[i], lead);
        }
        time_order = times;
    }

    public int q(int t) {
        int index = Arrays.binarySearch(time_order, t);
        return index >= 0 ? time2lead.get(time_order[index]) : time2lead.get(time_order[-index-2]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */