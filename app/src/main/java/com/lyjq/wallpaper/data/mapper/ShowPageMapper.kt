package com.lyjq.wallpaper.data.mapper

import com.lyjq.wallpaper.data.model.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.util.ArrayList
import java.util.regex.Pattern

/**
 * Created by liuxiaoyu on 2017/5/31.
 */
class ShowPageMapper (var string:String){

    fun transform():List<String>?{
        var doc = Jsoup.parse(string)
        if(doc != null){
            return parse(doc)
        }else{
            return null
        }
    }

    private fun parse(document: Document): List<String> {
        val tasks = arrayListOf<String>()
        val elements = document.select("div[class^=pages]")
        val pageElements = elements[0].select("li")
        if (!pageElements.isEmpty()) {
            val firstli = pageElements[0].text()
            val regEx = "[^0-9]"
            val p = Pattern.compile(regEx)
            val m = p.matcher(firstli)
            val total = Integer.parseInt(m.replaceAll("").trim { it <= ' ' })

            for (i in 2..total - 1) {
                tasks.add(i.toString() + "")
            }
        }
        return tasks
    }
}