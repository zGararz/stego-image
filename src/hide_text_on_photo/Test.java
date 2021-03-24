/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hide_text_on_photo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author zGararz
 */
public class Test {
    public static void main(String[] args) throws IOException {
        
        AlgorithmHideText h = new AlgorithmHideText();
        AlgorithmGetText g = new AlgorithmGetText();
            List<String> list1 = new ArrayList<>();
            File imge = new File("C:\\Users\\zGararz\\Pictures\\fl_stego.jpg");
            File imge1 = new File("C:\\Users\\zGararz\\Pictures\\fl_stego.jpg");
            BufferedImage img = ImageIO.read(imge); 
            BufferedImage img1 = ImageIO.read(imge1); 
            
            ImageIO.write(HideText.hideText(img, "chao ban", 0), "png", imge1);
            System.out.println(HideText.getText(img1, 0));
            
//            String text = "anh yeu em";          
//            String s1 = h.textToBinaryCode(text);
//            List<BufferedImage> listImage = h.splitImage(img);
//            String pos = h.findPositions(s1, listImage.get(0));
//            if (pos != null && !pos.isEmpty()) {
//            BufferedImage img2 = h.Substation(pos, listImage.get(1), 0);
//            BufferedImage stegoImg = h.extractionStegoImage(listImage.get(0), img2);
//            
//            
//            ImageIO.write(stegoImg, "png", imge1);
//            System.out.println("done");
//                        
//            List<Integer> list = g.getPositions(img2, 0);
//                String code = g.PositionToBinaryCOde(list, listImage.get(0));
//                System.out.println(g.binaryCodeToText(code));
//            
//                 
//            
//            } else {
//                System.out.println("chon anh khac");
//            }
            
            
            
            
            
    }
}