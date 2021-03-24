/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hide_text_on_photo.Interface;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zGararz
 */
public interface IAlgorithmHideText {
    public String textToBinaryCode(String text);
    public List<BufferedImage> splitImage(BufferedImage image);
    public String findPositions(String arr1, BufferedImage img1);
    public BufferedImage Substation(String arr4, BufferedImage img2, int k) throws Exception;
    public BufferedImage extractionStegoImage(BufferedImage img1, BufferedImage img2);
}
