package com.william.SpringBootPlay.header;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping(path = "/header")
public class HeaderRestController {

    private static final int RETURN_HEADER_VERSION = 1;

    @GetMapping(path = "/return-header")
    public ResponseEntity<Car> returnHeader() throws Exception {
        if (RETURN_HEADER_VERSION == 1) {
            return returnHeaderVersion1();
        } else if (RETURN_HEADER_VERSION == 2) {
            return returnHeaderVersion2();
        } else {
            throw new Exception("This is not exist");
        }
    }

    public ResponseEntity<Car> returnHeaderVersion1() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("token", "XMATTOKENTEST");

        Car car = new Car("M3", 4000);
        return new ResponseEntity<>(car, headers, HttpStatus.OK);
    }

    public ResponseEntity<Car> returnHeaderVersion2() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("TOKEN", "KSD79879*SD&F8df");
        Car car = new Car("M3", 4000);
        return ResponseEntity.ok().headers(httpHeaders).body(car);
    }

    @GetMapping("/get-token")
    public String getHeaders(@RequestHeader HttpHeaders httpHeaders) {
        String result = "";
        result += httpHeaders.get("TOKEN");
        result += " " + httpHeaders.get("TOKEN2");
        System.out.println(httpHeaders.get("TOKEN"));
        System.out.println(httpHeaders.get("TOKEN2"));
        return result;
    }

}
