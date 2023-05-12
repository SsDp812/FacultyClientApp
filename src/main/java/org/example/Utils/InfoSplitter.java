package org.example.Utils;

public class InfoSplitter {
    public static String[] splitInfo(String str){
        StringBuilder builder = new StringBuilder(str);
        StringBuilder builder1 = new StringBuilder("");

        boolean flag = false;
        for(int i = 0; i < builder.length();i++){
            if(builder.charAt(i) == '{'){
                flag = true;
                continue;
            }
            builder1.append(builder.charAt(i));
        }
        builder1.deleteCharAt(builder1.length()-1);

        String[] temp = builder1.toString().split(", ");
        String[] ans = new String[temp.length];
        for(int i = 0; i < temp.length;i++){
            StringBuilder tempBuilder = new StringBuilder(temp[i].split("=")[1]);
            if(tempBuilder.charAt(0) == '\'' && tempBuilder.charAt(tempBuilder.length()-1) == '\'') {
                tempBuilder.deleteCharAt(0);
                tempBuilder.deleteCharAt(tempBuilder.length() - 1);
            }
            ans[i] = tempBuilder.toString();
        }
        return ans;
    }
}
