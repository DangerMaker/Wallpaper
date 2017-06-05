package com.lyjq.wallpaper.data.mapper

import com.lyjq.wallpaper.data.model.Task
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.util.ArrayList

/**
 * Created by liuxiaoyu on 2017/6/1.
 */
class CategoryMapper {

    companion object Mapper {

        fun transform(json: String): List<Task> {
            var doc = Jsoup.parse(json)
            return parse(doc)
        }

        fun parse(document: Document): List<Task> {
            val tasks = arrayListOf<Task>()
            val elements = document.select("div[class^=w960 r]")
            val elementMain = elements[0]

            val elementLlist = elementMain.select("div[class^=listBox]")
            val liList = elementLlist.select("li")

            for (info in liList) {
                val a = info.select("a")
                val title = a.attr("title")
                val href = a.attr("href")
                val img = a.select("img").attr("src")
                println(title)
                println(href)
                println(img)
                val task = Task(title, img, href, "")
                tasks.add(task)
            }
            return tasks
        }
    }
}