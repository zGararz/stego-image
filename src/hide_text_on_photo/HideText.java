/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hide_text_on_photo;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author zGararz
 */
public class HideText {

    private HideText() {
    }
    
    public static BufferedImage hideText(BufferedImage img, String text, int k) {
        AlgorithmHideText hide = new AlgorithmHideText();       
        String s1;
        String pos;
        List<BufferedImage> listImage;
        BufferedImage img2;
        BufferedImage stegoImg;
        
        s1 = hide.textToBinaryCode(text);
        listImage = hide.splitImage(img);
        pos = hide.findPositions(s1, listImage.get(0));

        if (pos != null && !pos.isEmpty()) {
            img2 = hide.Substation(pos, listImage.get(1), 0);
            stegoImg = hide.extractionStegoImage(listImage.get(0), img2);
            
            return stegoImg;
        }
        return null;
    }
    
     public static String getText(BufferedImage img, int k) { 
         AlgorithmHideText hide = new AlgorithmHideText();       
         AlgorithmGetText get = new AlgorithmGetText();
         List<BufferedImage> listImage;
         List<Integer> list;
         String code;
          
         listImage = hide.splitImage(img);
          
         list = get.getPositions(listImage.get(1), 0);
         code = get.PositionToBinaryCOde(list, listImage.get(0));
                
         
         return get.binaryCodeToText(code);
     }
    
}
