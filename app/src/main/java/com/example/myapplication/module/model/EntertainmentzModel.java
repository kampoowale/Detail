package com.example.myapplication.module.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

@Root(name = "rss", strict = false)
public class EntertainmentzModel implements Serializable {

    @Element
    public RssChannel channel;

    @Override
    public String toString() {
        return "EntertainmentzModel [channel=" + channel + "]";
    }

}




