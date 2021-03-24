/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hide_text_on_photo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author zGararz
 */
public class AlgorithmHideText implements IAlgorithmHideText{

   
    @Override
    public String textToBinaryCode(String text) {
        StringBuilder s = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            s.append("0" + Integer.toBinaryString(text.codePointAt(i)));
        }
        return s.toString();
    }

    @Override
    public List<BufferedImage> splitImage(BufferedImage image) {
        int h1 = image.getHeight() / 2;
        int h2 = image.getHeight() - h1;
        int w = image.getWidth();
        List<BufferedImage> list = new ArrayList<>();
        
        BufferedImage img1 = new BufferedImage(image.getWidth(), h1, BufferedImage.TYPE_INT_RGB);
        BufferedImage img2 = new BufferedImage(image.getWidth(), h2, BufferedImage.TYPE_INT_RGB);
        
        for (int i = 0; i < h1; i++) {
            for (int j = 0; j < w; j++) {
                img1.setRGB(j, i, image.getRGB(j, i));
            }
        }
        
        for (int i = 0; i < h2; i++) {
            for (int j = 0; j < w; j++) {
                img2.setRGB(j, i, image.getRGB(j, i + h1));
            }
        }
        
        
        list.add(img1);
        list.add(img2);
        return list;
    }

    @Override
    public String findPositions(String arr, BufferedImage img){
        try {
            String list = "";
        boolean check = false;
        
        for (int i = 0; i < arr.length(); i += 2) {
            check = false;
            for (int j = 0; j < img.getHeight(); j++) {
                if (check) {
                    break;
                }
                for (int k = 0; k < img.getWidth(); k++) {
                    Color c = new Color(img.getRGB(j, k));
                    String blue = Integer.toBinaryString(c.getBlue());
                    
                    blue = fillBit(blue, 8);
                    
                    String blue2 = blue.substring(0, blue.length() - 2);
                                   
                    if(arr.charAt(i) == blue.charAt(6) && arr.charAt(i+1) == blue.charAt(7)) {                                        
                        list += fillBit(Integer.toBinaryString(j), 8);
                        list += fillBit(Integer.toBinaryString(k), 8);
                        check = true;
                        break;
                    }
                }                           
            }
        }
        return list;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public BufferedImage Substation(String arr4, BufferedImage img2, int k) {
        int d = 0;
        for (int i = 0; i < img2.getHeight(); i++) {            
            for (int j = 0; j < img2.getWidth(); j++) {
                while (d < arr4.length()) {                    
                    Color c = new Color(img2.getRGB(j, i));
                    String blue = fillBit(Integer.toBinaryString(c.getBlue()), 8);
                    String blue1 = blue.substring(0, blue.length() - 2);
                                      
                    blue1 = blue1 + arr4.charAt(d) + arr4.charAt(d+1);                   
                    d += 2;
                }
            }
        }
        return img2;
    }

    @Override
    public BufferedImage extractionStegoImage(BufferedImage img1, BufferedImage img2) {
        int h = img1.getHeight() + img2.getHeight();
        int w = img1.getWidth();
        BufferedImage stegoImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
        for (int i = 0; i < img1.getHeight(); i++) {
            for (int j = 0; j < w; j++) {
                stegoImage.setRGB(j, i, img1.getRGB(j, i));
            }
        }
        
        for (int i = 0; i < img2.getHeight(); i++) {
            for (int j = 0; j < w; j++) {
                stegoImage.setRGB(j, i + img1.getHeight(), img2.getRGB(j, i));
            }
        }
        return stegoImage;
    }


    private String fillBit(String s, int n) {
        String s1 = "";
        if(s.length() < n) {
            int n1 = n - s.length();
            for (int l = 0; l < n1; l++) {
                s1 += "0";
            }
            s1 += s;                        
        }
        return s1;
    }
}
