package cn.bigears.pattern.decorator;

/**
 * FilterAndBeautyCamera
 * @author shenyang
 * @date 2025-07-08
 */
public class FilterAndBeautyCamera extends BeautyCamera {

    public FilterAndBeautyCamera(BaseCamera baseCamera) {
        super(baseCamera);
    }

    @Override
    public void photo() {
        System.out.println("use filter mode");
        super.photo();
    }
}
