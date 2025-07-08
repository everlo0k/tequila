package cn.bigears.pattern.decorator;

/**
 * FilterCamera
 * @author shenyang
 * @date 2025-07-08
 */
public class FilterCamera extends CameraDecorator {

    public FilterCamera(BaseCamera baseCamera) {
        super(baseCamera);
    }

    @Override
    public void photo() {
        System.out.println("use filter mode");
        super.photo();
    }

}
