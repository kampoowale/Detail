package com.example.myapplication.module.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "item", strict = false)
public class Item implements Serializable {

    @Element(required = false ,name = "title")
    String title;
    @Element(required = false ,name = "link")

    String link;
    @Element(required = false ,name = "pubDate")

    String pubDate;
       @Element(required = false ,name = "description")

    String description;

    public String getCategory() {
        return category;
    }

    public void setUrl(Content content) {
        this.content = content;
    }

    public String getUrl() {
        return content.url;
    }

//    @Element(required = false , name="content:encoded")
//    String encoded;
//

    @Element(name = "content", required = false)
    private Content content;

    @Root(name = "encoded", strict = false)
    static class Content {

        @Attribute(name = "url")
        private String url;
    }

    public String getMedia() {
        return media.keyword;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    @Element(name = "media", required = false)
    private Media media;

    @Root(name = "keywords", strict = false)
    static class Media {
        @Attribute(name = "")

        private String keyword;
    }



    public void setCategory(String category) {
        this.category = category;
    }

    @Element(required = false ,name = "category")

    String category;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
