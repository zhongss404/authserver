package com.example.security.domain;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Created by dashuai on 2017/11/18.
 */
public class ImageCode extends ValidateCode {

    private BufferedImage bufferedImage;

    public ImageCode() {
    }

    public ImageCode(String code,BufferedImage bufferedImage,int expireIn) {
        super(code,expireIn);
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
}
