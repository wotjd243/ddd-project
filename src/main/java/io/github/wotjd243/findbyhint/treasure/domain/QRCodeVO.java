package io.github.wotjd243.findbyhint.treasure.domain;

public class QRCodeVO {

    private String url;
    private int width;
    private int height;
    private String qrColor;
    private String backColor;

    private QRCodeVO(String url, int width, int height, String qrColor, String backColor) {
        this.url = url;
        this.width = width;
        this.height = height;
        this.qrColor = qrColor;
        this.backColor = backColor;
    }


    @Override
    public String toString() {
        return "QRCodeVO{" +
                "url='" + url + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", qrColor='" + qrColor + '\'' +
                ", backColor='" + backColor + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
