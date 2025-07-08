package cn.bigears.pattern.decorator;

/**
 * BaseCamera
 * @author shenyang
 * @date 2025-07-08
 */
public class BaseCamera implements Camera {

    @Override
    public void photo() {
        System.out.println("take a photo use Base Camera");
    }

}
