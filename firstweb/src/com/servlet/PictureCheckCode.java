package com.servlet;

/**
 * Created by Wyy on 2017/12/28 14:12.
 */
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class PictureCheckCode extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
            //图像数据缓冲区  构造函数 第一个参数为宽 第二个参数为高  第三个为图片类型
            BufferedImage bi = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
            //绘制图片
            Graphics grap = bi.getGraphics();
            //设置字体
            Font f = new Font("宋体",Font.ITALIC ,20);
            grap.setFont(f);
            //背景颜色
            Color color = new Color(200,160,255);
            //设置背景颜色
            grap.setColor(color);
            grap.fillRect(0, 0, 100, 25);//坐标  绘制图片宽、高

            //验证码内容
//        char[] content = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
            char[] content = "0123456789".toCharArray();
            Random ran = new Random();//根据随机数来取组合验证码内容
            int len = content.length,index;
            StringBuffer generateCode = new StringBuffer();//存储随机生成的验证码
            //生成6位的验证码
            for(int i = 0;i<6;i++){
                index = ran.nextInt(len);
                //设置验证码颜色
                grap.setColor(new Color(ran.nextInt(100), ran.nextInt(180),ran.nextInt(255)));
                //将字符画在画板上
                grap.drawString(content[index]+"", i*16+3, 19);
                generateCode.append(content[index]);
            }
            //将生成的验证码放在session中以便之后验证用到
            httpServletRequest.getSession().setAttribute("verifyCode", generateCode.toString());
            //将生成的验证码图片输出
            ImageIO.write(bi, "PNG", httpServletResponse.getOutputStream());
        }

        public static boolean validateResponse(HttpServletRequest request, String userCaptchaResponse) {
            if(request.getSession(false) == null) {
                return false;
            } else {
                boolean validated = false;

                if(request.getSession().getAttribute("verifyCode").toString().equals(userCaptchaResponse)){
                    validated = true;
                }

                return validated;
            }
        }
}
