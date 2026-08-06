class Solution {
    class Pair {
        String s;;
        int level;

        Pair(String s, int level) {
            this.s = s;
            this.level = level;
        }
    }

    void generate(Pair p, Set<String> words) {
        for (int i = 0; i < p.s.length(); i++) {
            StringBuilder sb = new StringBuilder(p.s);
            char org = sb.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == org)
                    continue;
                sb.setCharAt(i, ch);
                if (words.contains(sb.toString())) {
                    q.offer(new Pair(sb.toString(), p.level + 1));
                    words.remove(sb.toString());
                }

            }
        }
    }

    Queue<Pair> q = new LinkedList<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            words.add(wordList.get(i));
        }

        q.offer(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            if (p.s.equals(endWord)) {
                return p.level;
            }
            generate(p, words);
        }
        return 0;
    }
}