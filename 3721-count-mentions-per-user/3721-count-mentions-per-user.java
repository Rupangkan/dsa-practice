class Solution {
    class E {
        String type;
        int t;
        List<String> data;
        int idx;

        E(List<String> data, int index) {
            this.type = data.get(0);
            this.t = Integer.parseInt(data.get(1));
            this.data = data;
            this.idx = index;
        }
    }
    
    public int[] countMentions(int n, List<List<String>> ev) {
        List<E> events = new ArrayList<>();
        
        for (int i = 0; i < ev.size(); i++) {
            events.add(new E(ev.get(i), i));
        }

        Collections.sort(events, (a, b) -> {
            if (a.t != b.t) {
                return Integer.compare(a.t, b.t);
            }
            boolean aOff = a.type.equals("OFFLINE");
            boolean bOff = b.type.equals("OFFLINE");
            if (aOff != bOff) {
                return aOff ? -1 : 1;
            }
            return Integer.compare(a.idx, b.idx);
        });

        int[] m = new int[n];
        int[] offUntil = new int[n];

        for (E e : events) {
            String type = e.type;
            int t = e.t;
            List<String> data = e.data;

            if (type.equals("OFFLINE")) {
                int id = Integer.parseInt(data.get(2));
                offUntil[id] = t + 60;
            } else if (type.equals("MESSAGE")) {
                String mentions = data.get(2);
                String[] tokens = mentions.split(" ");
                
                for (String token : tokens) {
                    if (token.equals("ALL")) {
                        for (int i = 0; i < n; i++) {
                            m[i]++;
                        }
                    } else if (token.equals("HERE")) {
                        for (int i = 0; i < n; i++) {
                            if (t >= offUntil[i]) {
                                m[i]++;
                            }
                        }
                    } else if (token.startsWith("id")) {
                        int id = Integer.parseInt(token.substring(2));
                        if (id >= 0 && id < n) {
                            m[id]++;
                        }
                    }
                }
            }
        }

        return m;
    }
}