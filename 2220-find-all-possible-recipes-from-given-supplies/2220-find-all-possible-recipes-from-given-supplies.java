class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        Map<String, Integer> recipeIndex = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        int[] inDegree = new int[recipes.length];

        for (int i = 0; i < recipes.length; i++) recipeIndex.put(recipes[i], i);

        for (int i = 0; i < recipes.length; i++) {
            for (String ing : ingredients.get(i)) {
                if (!suppliesSet.contains(ing)) {
                    graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipes[i]);
                    inDegree[i]++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < recipes.length; i++) if (inDegree[i] == 0) q.add(i);

        while (!q.isEmpty()) {
            int idx = q.poll();
            result.add(recipes[idx]);
            if (!graph.containsKey(recipes[idx])) continue;
            for (String dep : graph.get(recipes[idx])) 
                if (--inDegree[recipeIndex.get(dep)] == 0) q.add(recipeIndex.get(dep));
        }

        return result;
    }
}