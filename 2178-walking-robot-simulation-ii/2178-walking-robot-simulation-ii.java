class Robot {

    private boolean f = false;
    private int p = 0;
    private List<int[]> pts = new ArrayList<>();
    private List<Integer> d = new ArrayList<>();
    private Map<Integer, String> mp = new HashMap<>();

    public Robot(int width, int height) {
        mp.put(0, "East");
        mp.put(1, "North");
        mp.put(2, "West");
        mp.put(3, "South");

        for (int i = 0; i < width; i++) {
            pts.add(new int[]{i, 0});
            d.add(0);
        }
        for (int i = 1; i < height; i++) {
            pts.add(new int[]{width - 1, i});
            d.add(1);
        }
        for (int i = width - 2; i >= 0; i--) {
            pts.add(new int[]{i, height - 1});
            d.add(2);
        }
        for (int i = height - 2; i > 0; i--) {
            pts.add(new int[]{0, i});
            d.add(3);
        }
        d.set(0, 3);
    }

    public void step(int num) {
        f = true;
        p = (p + num) % pts.size();
    }

    public int[] getPos() {
        return pts.get(p);
    }

    public String getDir() {
        if (!f) return "East";
        return mp.get(d.get(p));
    }
}