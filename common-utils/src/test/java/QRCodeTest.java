import org.junit.Test;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class QRCodeTest {
    /**
     * 生成图像
     */
    @Test
    public void testEncode() {
        // 二维码图片存放位置
        String filePath = "d://";
        // 二维码图片的名字
        String fileName = "zxing.jpg";
        // 内容
        String content = "http://www.baidu.com";
        // 图像宽度
        int width = 400;
        // 图像高度
        int height = 400;
        // 图像类型
        String format = "jpg";
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        // 内容所使用编码
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        try {
            // 生成矩阵
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                    BarcodeFormat.QR_CODE, width, height, hints);
            Path path = FileSystems.getDefault().getPath(filePath, fileName);
            // 输出图像
            MatrixToImageWriter.writeToPath(bitMatrix, format, path);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("二维码生成了");
    }
    /**
     * 解析图像
     */
    @Test
    public void testDecode() {
        //解析的图像的路径
        String filePath = "E://zxing.jpg";
        BufferedImage image;
        try {
            image = ImageIO.read(new File(filePath));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
            System.out.println("解析结果 = " + result.toString());
            System.out.println("二维码格式类型 = " + result.getBarcodeFormat());
            System.out.println("二维码文本内容 = " + result.getText());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
