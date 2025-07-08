package cn.bigears.pattern.decorator;

/**
 * CameraDecorator
 * @author shenyang
 * @date 2025-07-08
 */
public class CameraDecorator implements Camera {

    public CameraDecorator(BaseCamera baseCamera) {
        this.baseCamera = baseCamera;
    }

    private BaseCamera baseCamera;

    @Override
    public void photo() {
        System.out.println("use camera decorator");
        baseCamera.photo();
    }
}
