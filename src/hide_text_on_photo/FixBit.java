/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hide_text_on_photo;

/**
 *
 * @author zGararz
 */
public class FixBit {
    public static String fillBit(String s, int n) {
        String s1 = "";
        if(s.length() < n) {
            int n1 = n - s.length();
            for (int l = 0; l < n1; l++) {
                s1 += "0";
            }
            s1 += s;                        
        } else {
            s1 = s;
        }
        return s1;
    }
}
