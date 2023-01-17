package or.kr.smhrd.portal.utils;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

public class decoding {

    // String decode(Binary binary){
    // return (HexUtils)binary;
    // }

    public String decode(String binary) throws UnsupportedEncodingException {
        byte[] testBytes = binary.getBytes("UTF-8");
        return DatatypeConverter.printHexBinary(testBytes);
    }
}