public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<LinkedList<String>> al = new ArrayList<LinkedList<String>>();
        ArrayList<String> res = new ArrayList<String>();
        if (words.length == 0) return res;
        int l = maxWidth;
        int index = 0;
        al.add(new LinkedList<String>());
        int[] length = new int[words.length];
        int sum = 0;
        for (String word : words) {
            int len = word.length();
            if (len <= l) {
                al.get(index).add(word);
                sum += len;
                l = l - word.length() - 1;
            } else {
                al.add(new LinkedList<String>());
                length[index] = sum;
                index++;
                al.get(index).add(word);
                l = maxWidth - word.length() - 1;
                sum = len;
            }
        }
        length[index] = sum;

        for (int i = 0; i < al.size(); ++i) {
            int rownumber = al.get(i).size();
            int rowlength = length[i];
            if (i<al.size()-1) res.add(getonerow(rownumber, rowlength, al.get(i), maxWidth));
            else {
                StringBuilder sb = new StringBuilder();
                int xxx = 0;
                for (String s: al.get(i)) {
                    sb.append(s);
                    xxx++;
                    if (maxWidth>rowlength && xxx-1<al.get(i).size()) {sb.append(' '); System.out.println(1);}
                }
                if (maxWidth-rowlength-xxx > 0){
                    System.out.println(2);
                    char b[] = new char[maxWidth - rowlength - xxx];
                    Arrays.fill(b, ' ');
                    sb.append(b);
                }
                res.add(sb.toString());
            }
        }

        return res;
    }

    private String getonerow(int number, int length, LinkedList<String> words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int interval = 0;
        if (number == 1) {
            sb.append(words.iterator().next());
            char b[] = new char[maxWidth - length];
            Arrays.fill(b, ' ');
            sb.append(b);
            return sb.toString();
        }

        maxWidth = maxWidth - length;
        int count = 1;
        int total = number;
        for (String word : words) {
            if (maxWidth % (number - 1) != 0) {
                interval = maxWidth / (number - 1) + 1;
                maxWidth = maxWidth - interval;
                number--;
            }
            else {
                interval = maxWidth / (number-1);
            }
            sb.append(word);
            char b[] = new char[interval];
            Arrays.fill(b, ' ');
            if (count<total) sb.append(b);
            count++;
        }

        return sb.toString();

    }

}
