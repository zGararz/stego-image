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
interface IAlgorithmGetText {
    public String binaryCodeToText(String b);
    public List<Integer> getPositions(BufferedImage img1, BufferedImage img2);
}
