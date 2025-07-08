package cn.bigears.pattern.decorator;

/**
 * MainCameraDecorator
 * @author shenyang
 * @date 2025-07-08
 */
public class MainCameraDecorator {

    public static void main(String[] args) {

        BeautyCamera beautyCamera = new BeautyCamera(new BaseCamera());

        beautyCamera.photo();

        System.out.println("----------------------");

        FilterAndBeautyCamera filterAndBeautyCamera = new FilterAndBeautyCamera(new BaseCamera());

        filterAndBeautyCamera.photo();

    }


}
