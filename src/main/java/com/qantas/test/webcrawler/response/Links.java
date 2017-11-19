package com.qantas.test.webcrawler.response;

import java.util.ArrayList;
import java.util.List;

public class Links {

    String url;
    String title;
    List<Links> nodes;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Links> getNodes() {
        if(null == nodes ) nodes = new ArrayList<>();
        return nodes;
    }

    public void setNodes(List<Links> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Links{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
