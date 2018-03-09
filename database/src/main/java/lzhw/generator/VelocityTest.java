package lzhw.generator;

import org.apache.velocity.app.VelocityEngine;

import java.net.URL;
import java.util.ResourceBundle;

public class VelocityTest {
    public static void main(String[] args) {
        URL url = VelocityTest.class.getResource("/template/Controller.vm");
        String controllerPath = url.getPath().replaceFirst("/", "");
        System.out.println(controllerPath);
        VelocityEngine engine = new VelocityEngine();

    }
}
