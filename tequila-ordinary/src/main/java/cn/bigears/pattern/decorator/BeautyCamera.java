package cn.bigears.pattern.decorator;

/**
 * BeautyCamera
 * @author shenyang
 * @date 2025-07-08
 */
public class BeautyCamera extends CameraDecorator {

    public BeautyCamera(BaseCamera baseCamera) {
        super(baseCamera);
    }

    @Override
    public void photo() {
        System.out.println("use beauty mode");
        super.photo();
    }
}
