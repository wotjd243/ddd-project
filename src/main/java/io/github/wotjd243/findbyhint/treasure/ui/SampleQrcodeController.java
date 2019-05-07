package io.github.wotjd243.findbyhint.treasure.ui;


import io.github.wotjd243.findbyhint.treasure.domain.QRCodeVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

@Controller
public class SampleQrcodeController {

    //controller
    @GetMapping(value="/makeQR")
    public View getQrCode(){

        //default config

        String url = "https://blog.naver.com/doyoung0205";
        int width = 300;
        int height = 300;
        QRCodeVO sampleQrCodeVO= new QRCodeVO(url,width,height,"0xff000000","0xffffffff","비밀번호");
        return sampleQrCodeVO.getQrView();
}


}
