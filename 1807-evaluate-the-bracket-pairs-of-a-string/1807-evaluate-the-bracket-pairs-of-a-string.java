class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> mpp = new HashMap<>();
        for(List<String> l : knowledge){
            String k = l.get(0);
            String v = l.get(1);
            mpp.put(k,v);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) != '('){
                sb.append(s.charAt(i));
            }else{
                i++;
                StringBuilder sb2 = new StringBuilder();
                while(s.charAt(i) != ')'){
                   sb2.append(s.charAt(i));
                   i++;
                }
                String st = mpp.getOrDefault(sb2.toString(),"?");
                sb.append(st);
            }
        }
return sb.toString();
    }
}