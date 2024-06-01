class Solution {
    public int numUniqueEmails(String[] emails) {
        //replace "." with "" empty string
        //find +, remove the part between + and @ 
        //or build a new string from before + and after @ part
        //use set for unique
        Set<String> emailSet = new HashSet<>();
        for(String email: emails){
            //check @, do processing before this index only
            int atTheRateIndex = email.indexOf("@");
            
            boolean[] deletePositions = new boolean[email.length()];
            
            //plus handling
            int plusIndex = email.indexOf("+");
            if(plusIndex>=0 && plusIndex<atTheRateIndex){
                for(int i = plusIndex;i<atTheRateIndex;i++){
                    deletePositions[i]=true;
                }  
            }
        
            //check any dot character found before @index
            List<Integer> dotIndexes = new ArrayList<>();
            for(int i =0;i<atTheRateIndex;i++){
                if(email.charAt(i)=='.'){
                    deletePositions[i]=true;
                    //dotIndexes.add(i);
                }
            }
            
            // for(int i = dotIndexes.size()-1;i>=0;i--){
            //     sb = sb.deleteCharAt(dotIndexes.get(i));
            // }
            // int dotIndex = email.indexOf(".");
            // StringBuilder sb = new StringBuilder(email);
            // if(dotIndex>=0 && dotIndex<atTheRateIndex){
            //     while(dotIndex>=0 && dotIndex<atTheRateIndex){
            //         sb.deleteCharAt(dotIndex);
            //         dotIndex = sb.indexOf(".");
            //     }
            // }
            StringBuilder result = new StringBuilder();
            for(int i=0;i<email.length();i++){
                if(!deletePositions[i]){
                    result.append(email.charAt(i));
                }
            }
            
            emailSet.add(result.toString());
        }
        return emailSet.size();
    }
}