package com.example.accesskeybackend.template.service;

import com.example.accesskeybackend.exception.NotValidURLException;
import com.example.accesskeybackend.template.dto.IPv6Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class IPv6Service {

    private boolean matchesRegex(String url) {
        Pattern urlPattern = Pattern.compile(Constants.URL_PATTERN);
        Matcher matcher = urlPattern.matcher(url);
        return matcher.matches();
    }

    public IPv6Response checkURL(String siteUrl) throws NotValidURLException {
//        Checking whole URL
        if (!matchesRegex(siteUrl)) {
            throw new NotValidURLException(Constants.URL_NOT_VALID);
        }
        boolean success = false;
        try {
//            Getting domain name from url
            String name = siteUrl.replaceAll(Constants.DOMAIN_NAME, "");
            InetAddress[] addresses = InetAddress.getAllByName(name);
            for (InetAddress address : addresses) {
                if (address instanceof java.net.Inet6Address) {
//                    Checking if we can reach it(advisable, but not necessary)
                    success = address.isReachable(Constants.TIME_OUT);
                }
            }
        } catch (IOException e) {
            throw new NotValidURLException(Constants.CANT_CHECK_URL);
        }
        return new IPv6Response(success);
    }

    static class Constants {
        private final
        static String URL_PATTERN = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        private final static String URL_NOT_VALID = "Check that URL is written correctly";
        private final static String CANT_CHECK_URL = "Can't check that URL has IPv6 protocol";
        public static final int TIME_OUT = 3000;
        public static final String DOMAIN_NAME = "http(s)?://|www\\.|/.*";
    }
}
