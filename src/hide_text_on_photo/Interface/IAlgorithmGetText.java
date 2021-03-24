/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hide_text_on_photo.Interface;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author zGararz
 */
public interface IAlgorithmGetText {
    public String binaryCodeToText(String b);
    public List<Integer> getPositions(BufferedImage img2, int k);
    public String PositionToBinaryCOde(List<Integer> pos, BufferedImage img1);
}
