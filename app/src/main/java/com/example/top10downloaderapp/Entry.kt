package com.example.top10downloaderapp

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "entry", strict = false)
class Entry{

    @field:Element(name = "title")
    var title: String? = null
}

