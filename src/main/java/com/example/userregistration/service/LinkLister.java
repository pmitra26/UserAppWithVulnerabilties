package com.example.userregistration.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.naming.LinkException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service

public class LinkLister {
  public List<String> getLinks(String url) throws IOException {
    List<String> result = new ArrayList<String>();
    Document doc = Jsoup.connect(url).get();
    Elements links = doc.select("a");
    for (Element link : links) {
      result.add(link.absUrl("href"));
    }
    return result;
  }

  public List<String> getLinksV2(String url) throws LinkException {
    try {
      URL aUrl= new URL(url);
      String host = aUrl.getHost();
      System.out.println(host);
      if (host.startsWith("172.") || host.startsWith("192.168") || host.startsWith("10.")){
        throw new LinkException("Use of Private IP");
      } else {
        return getLinks(url);
      }
    } catch(Exception e) {
      throw new LinkException(e.getMessage());
    }
  }
}
