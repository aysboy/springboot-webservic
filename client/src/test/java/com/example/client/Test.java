package com.example.client;


import cn.hutool.core.util.XmlUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.Document;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.xpath.XPathConstants;
import java.util.Base64;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @org.junit.Test
    public void testPlatformDetails(){

        //投标人
        String xx = "<NewDataSet><ExecResult><ExecSuccessfully><![CDATA[1]]></ExecSuccessfully><Description><![CDATA[dvW96M0KcPZY+y4/2gjfUB6bqBQ86d62t6x6riDEaWyFMZliCjPZUxQfr+NqtXQsLDBQZuCHLPBQJ72QkWq3XZRmYf5ZctBANAFDP92h3siACeFBB6NXHTLBF8cvc3RL/MYFMwOkckWF0MivFbxFZslfOSkSqFpwfDZ8+XUHxsEDBfHVMRezsmAbCbsZ36oz6Qn1OkdhHglGbs2zhHk6W4nBcBhLudEePYLLe+yp+B21oMMo6oO1Wo04Ee06q0vyYmEOlZPPiK8UxgDM+/18SCHv6LcnfCx2pdfcTtX0Cy5V4NET6YmCkXmL4xC+zugRVVCkNz5yf72co6xcZQBvk8Y09o2cy51N86u7XwlixufAchVZfrWGGPlfy+f4ePEqfK5qhFNCBXkkfWFqeX/i8n3wi9/+9n6i5E6IrUAjLUuB0/JHiBqmccQuiwRDNGet58WEnVAxC0nA4mUio9N4qgKONtJPztDGppiVeYzw3fiuiGOni233eojr8VN51Z7nwEtGFJeJN4u1UukJe0XRhlCC3fokb0oobxQvRD5gSQA=]]></Description></ExecResult></NewDataSet>";

        String str = "dvW96M0KcPZY+y4/2gjfUB6bqBQ86d62t6x6riDEaWyFMZliCjPZUxQfr+NqtXQsLDBQZuCHLPBQJ72QkWq3XZRmYf5ZctBANAFDP92h3siACeFBB6NXHTLBF8cvc3RL/MYFMwOkckWF0MivFbxFZslfOSkSqFpwfDZ8+XUHxsEDBfHVMRezsmAbCbsZ36oz6Qn1OkdhHglGbs2zhHk6W4nBcBhLudEePYLLe+yp+B21oMMo6oO1Wo04Ee06q0vyYmEOlZPPiK8UxgDM+/18SCHv6LcnfCx2pdfcTtX0Cy5V4NET6YmCkXmL4xC+zugRVVCkNz5yf72co6xcZQBvk8Y09o2cy51N86u7XwlixufAchVZfrWGGPlfy+f4ePEqfK5qhFNCBXkkfWFqeX/i8n3wi9/+9n6i5E6IrUAjLUuB0/JHiBqmccQuiwRDNGet58WEnVAxC0nA4mUio9N4qgKONtJPztDGppiVeYzw3fiuiGOni233eojr8VN51Z7nwEtGFJeJN4u1UukJe0XRhlCC3fokb0oobxQvRD5gSQA=";


//        String str = "dvW96M0KcPZY+y4/2gjfUB6bqBQ86d62t6x6riDEaWyjgr4mNwf1uINpkFzRDdgkXAWfvtTKb+ZpYq3nAzyYmoo9Rs+/HCiOqDo6mbGq2QSYMjqVGqrZzFlgX7yijnd3t5lq+0jMt2rv8bL6OpUE6WkKgKLwf7r4lHr2e87cJa0b6belC07KAANrmzZ+xuM4Bnu27bTWn6t6MGSlELvucg5OvtYmcSetlDG0UYDQmfBWbfvlMpdyJi7L7Aue4CMkaJr0W+zO+/roP8r6KvKDZCE8/3SiIjMyICH11k/qNlTCC608DcqtimpHoVsQDp5N4LyIIEegIslEgEpW47wvQlPOpHKxBYrqJN5D98u9/cnw+YIJMEYR9j8a0xQYdDS2cHIEDa7BmA+VvMpsOIUJvTYk7SRY4TMqetKp9TqcRXx2r+Pmm0zGcBB6aStdEb1ml/Fx32MGZCjI7vfN7vw6jA==";


        Document document = XmlUtil.readXML(xx);

        Object byXPath = XmlUtil.getByXPath("//NewDataSet/ExecResult/ExecSuccessfully", document, XPathConstants.STRING);

        System.out.println(byXPath);

    }

}