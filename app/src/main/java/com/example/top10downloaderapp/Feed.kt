package com.example.top10downloaderapp

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "feed", strict = false)
class Feed constructor(


//    @field:Element(name = "title")
//    var title: String? = null,

    @field:ElementList(name = "entry",inline = true )
    var entry: List<Entry>? = null) : Serializable {
}