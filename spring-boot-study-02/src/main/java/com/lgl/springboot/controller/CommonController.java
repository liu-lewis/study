package com.lgl.springboot.controller;

import com.lgl.springboot.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommonController {

    @Value("${filePath}")
    private String filePath;

    @RequestMapping("/")
    public String index(Model model) {
        Person single = new Person("LeBron James", 35);
        List<Person> person = new ArrayList<>();
        person.add(new Person("Chris Paul", 34));
        person.add(new Person("Jhon Snow", 1));
        System.out.println(person);
        model.addAttribute("singlePerson", single);
        model.addAttribute("personList", person);
        return "index";
    }

    @RequestMapping(value = "/image/get/{size}", method = RequestMethod.GET)
    public void getJpg_01(HttpServletResponse response, @PathVariable("size")Integer size) throws IOException {
        if (size > 10240) {
            throw new RuntimeException("to large number!");
        }
        size = size * 8 * 1024;
        BigDecimal w = new BigDecimal(size).multiply(new BigDecimal(9)).divide(new BigDecimal(16), 0, BigDecimal.ROUND_HALF_DOWN);
        Integer HEIGHT = (int) Math.sqrt(w.intValue());
        Integer WIDTH = HEIGHT * 16 / 9;
        BufferedImage image = new BufferedImage(WIDTH , HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        response.setContentType("image/jpeg");
        OutputStream os = response.getOutputStream();
        File file = new File(filePath);
        Image imageTemp = ImageIO.read(file);
        g.drawImage(imageTemp, 0, 0, WIDTH, HEIGHT, null);
        ImageIO.write(image, "jpeg", os);
    }
}
