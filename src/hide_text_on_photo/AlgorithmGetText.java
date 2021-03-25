/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hide_text_on_photo;

import hide_text_on_photo.Interface.IAlgorithmGetText;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zGararz
 */
public class AlgorithmGetText implements IAlgorithmGetText{
    //32-122
    final int START_CHAR = 32;
    static final char[] ASCII = {
        ' ', '!', '\"', '#', '$', '%', '&', '\'', '(', ')','*', '+', ',','-', '.', '/',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',':', ';', '<', '=', '>', '?', '@',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '[', '\\', ']', '^', '_', '`',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    
    @Override
    public String binaryCodeToText(String b) {
        StringBuilder s = new StringBuilder();
        try {
            for (int i = 0; i < b.length(); i += 8) {
            String b1 = b.substring(i, i + 8);
            int pos = Integer.parseInt(b1, 2) - START_CHAR;
            if(pos > -1 && pos < ASCII.length) {
                s.append(ASCII[pos]);
            } else {
                s.append('?');
            }
        }
        } catch (Exception e) {
        }
        
        System.out.println(s.toString());
        return s.toString();
    }

    @Override
    public List<Integer> getPositions(BufferedImage img2, int k) {
        StringBuilder s = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < img2.getHeight(); i++) {            
            for (int j = 0; j < img2.getWidth(); j++) {
               if ((i * img2.getWidth() + j) >= k) {    
                   Color c = new Color(img2.getRGB(j, i));
                   String blue = FixBit.fillBit(Integer.toBinaryString(c.getBlue()), 8);
                   s.append(blue.charAt(blue.length() - 2));  
                   s.append(blue.charAt(blue.length() - 1)); 
               }
                 
            }
        }
        
        list = binaryCodeToInt(s.toString());
        
        return list;
    }

    @Override
    public String PositionToBinaryCOde(List<Integer> pos, BufferedImage img1) {
        StringBuilder s = new StringBuilder();
        try {
            for (int i = 0; i < pos.size(); i += 2) {
           
            Color c = new Color(img1.getRGB(pos.get(i), pos.get(i + 1)));
            String blue = FixBit.fillBit(Integer.toBinaryString(c.getBlue()), 8);
            String blue1 = blue.substring(blue.length() - 2);            
            s.append(blue1);
        }
        } catch (Exception e) {
        }
        
        return s.toString();
    }
    
    public List<Integer> binaryCodeToInt(String b) {
        List<Integer> list = new ArrayList<>();
        try {
            for (int i = 0; i < b.length(); i += 16) {
            String b1 = b.substring(i, i + 16);
            int pos = Integer.parseInt(b1, 2);
            if (pos > 255) {
                pos = (int) (Math.random() * 20);
            }
            list.add(pos);
    
        }
        } catch (Exception e) {
        }             
        return list;
    }
    
}
