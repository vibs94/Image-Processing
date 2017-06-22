/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageprocessing;

import java.awt.image.BufferedImage;

/**
 *
 * @author B.K.D.Vibodha
 */
public class Image {
    
    private int id = 0;
    private BufferedImage bufferedImage = null;

    
    public Image(BufferedImage image){
        this.bufferedImage = image;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
    
    
    
    
}
