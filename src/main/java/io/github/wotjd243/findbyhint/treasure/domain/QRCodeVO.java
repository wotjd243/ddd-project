package io.github.wotjd243.findbyhint.treasure.domain;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;


public class QRCodeVO {

    private String qrUrl;
    private int width;
    private int height;
    private String qrColor;
    private String backColor;
    private String qrPw;

    public QRCodeVO(String qrUrl, int width, int height, String qrColor, String backColor,String qrPw) {
        this.qrUrl = qrUrl;
        this.width = width;
        this.height = height;
        this.qrColor = qrColor;
        this.backColor = backColor;
        this.qrPw = qrPw;
    }


    public BitMatrix makeQRMatrix(){
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix matrix = null;
        MatrixToImageConfig config = null;
        //BufferedImage  qrImage = null;
        try {
            this.qrUrl = new String(this.qrUrl.getBytes("UTF-8"), "ISO-8859-1");

            matrix = qrCodeWriter.encode(this.qrUrl, BarcodeFormat.QR_CODE, width, height);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return matrix;
    }

    public MatrixToImageConfig makeColorConfig(){

        int intQrColor = 0;
        int intBackColor = 0;

        try{
            intQrColor = Integer.parseUnsignedInt(qrColor,16);
        }catch(Exception e){
            intQrColor = 0xff000000;
        }

        try{
            intBackColor = Integer.parseUnsignedInt(backColor,16);
        }catch(Exception e){
            intBackColor = 0xffffffff;
        }


        return new MatrixToImageConfig(intQrColor, intBackColor);
    }

    //view
     public View getQrView() {
        return new AbstractView() {

            final BitMatrix matrix = makeQRMatrix();

            final MatrixToImageConfig config = makeColorConfig();


            @Override
            protected void renderMergedOutputModel(Map<String, Object> model,
                                                   HttpServletRequest request,
                                                   HttpServletResponse response) throws Exception {

                response.setContentType("image/png; charset=UTF-8");
                response.setHeader("Content-Transfer-Encoding", "binary");

                OutputStream out = response.getOutputStream();

                MatrixToImageWriter.writeToStream(matrix, "png", out, config);
                out.flush();
            }

        };
    }

    public String getUrl() {
        return qrUrl;
    }

    public void setUrl(String qrUrl) {
        this.qrUrl = qrUrl;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getQrColor() {
        return qrColor;
    }

    public void setQrColor(String qrColor) {
        this.qrColor = qrColor;
    }

    public String getBackColor() {
        return backColor;
    }

    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }


    public boolean isEmpty() {
        return  StringUtils.isEmpty(this.qrUrl) || StringUtils.isEmpty(this.width) || StringUtils.isEmpty(this.height)
                || StringUtils.isEmpty(this.qrColor) || StringUtils.isEmpty(this.backColor) || StringUtils.isEmpty(this.qrPw);
    }


    @Override
    public String toString() {
        return "QRCodeVO{" +
                "qrUrl='" + qrUrl + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", qrColor='" + qrColor + '\'' +
                ", backColor='" + backColor + '\'' +
                ", qrPw='" + qrPw + '\'' +
                '}';
    }

}
