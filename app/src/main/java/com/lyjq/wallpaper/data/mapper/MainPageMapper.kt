package com.lyjq.wallpaper.data.mapper

import com.lyjq.wallpaper.data.model.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.util.ArrayList

/**
 * Created by liuxiaoyu on 2017/5/31.
 */
class MainPageMapper (var string:String){

    fun transform():List<Any>?{
        var doc = Jsoup.parse(string)
        if(doc != null){
            return parse(doc)
        }else{
            return null
        }
    }

    private fun parse(document: Document): List<Any> {
        var tempList = arrayListOf<Task>()

        val list = ArrayList<Any>()
        val elements = document.select("div[class^=w960 r]")
        val elementMain = elements[0]

        val elementBanner = elementMain.select("div[class^=hd l re]")
        val bannerinfos = elementBanner.select("a")
        for (info in bannerinfos) {
            val a = info.select("a")
            val title = a.attr("imgsm")
            val href = a.attr("href")
            val img = a.select("img").attr("src")
            println(title)
            println(href)
            println(img)
            val task = Task(title, img, href, "")
            tempList.add(task)
        }

        val bannerinfo = BannerInfo(arrayListOf())
        bannerinfo.list.addAll(tempList)
        list.add(bannerinfo)

        val elementRecent = elementMain.select("div[class^=w240 r BGfff]")
        val recentinfos = elementRecent.select("li")
        tempList.clear()
        for (info in recentinfos) {
            val a = info.select("a")
            val title = a.attr("title")
            val href = a.attr("href")
            val img = a.select("img").attr("src")
            println(title)
            println(href)
            println(img)
            val task = Task(title, img, href, "")
            tempList.add(task)
        }
        val recentinfo = RecentInfo(arrayListOf())
        recentinfo.list.addAll(tempList)
        list.add(recentinfo)

        tempList.clear()
        val elementWeiMei = elementMain.select("div[class^=Cstyle1]")
        val weimeiinfos = elementWeiMei.select("li")
        for (info in weimeiinfos) {
            val a = info.select("a")
            val title = a.select("img").attr("alt")
            val href = a.attr("href")
            val img = a.select("img").attr("src")
            println(title)
            println(href)
            println(img)
            val task = Task(title, img, href, "")
            tempList.add(task)
        }

        val weimeiinfo = WeiMeiInfo(arrayListOf())
        weimeiinfo.list.addAll(tempList)
        list.add(weimeiinfo)


        tempList.clear()
        val elementBeauty = elementMain.select("div[class^=Sstyle2]")[0]
        val beautyinfos = elementBeauty.select("li")
        for (info in beautyinfos) {
            val a = info.select("a")
            val title = a.select("img").attr("alt")
            val href = a.attr("href")
            val img = a.select("img").attr("src")
            println(title)
            println(href)
            println(img)
            val task = Task(title, img, href, "")
            tempList.add(task)
        }

        val beautyinfo = BeautyInfo(arrayListOf())
        beautyinfo.list.addAll(tempList)
        list.add(beautyinfo)

        tempList.clear()
        val elementHair = elementMain.select("div[class^=Sstyle2]")[1]
        val hairinfos = elementHair.select("li")
        for (info in hairinfos) {
            val a = info.select("a")
            val title = a.select("img").attr("alt")
            val href = a.attr("href")
            val img = a.select("img").attr("src")
            println(title)
            println(href)
            println(img)
            val task = Task(title, img, href, "")
            tempList.add(task)
        }

        val hairinfo = HairInfo(arrayListOf())
        hairinfo.list.addAll(tempList)
        list.add(hairinfo)

        tempList.clear()
        val elementSexy = elementMain.select("div[class^=Cstyle4]")
        val sexyinfos = elementSexy.select("li")
        for (info in sexyinfos) {
            val a = info.select("a")
            val title = a.select("img").attr("alt")
            val href = a.attr("href")
            val img = a.select("img").attr("src")
            println(title)
            println(href)
            println(img)
            val task = Task(title, img, href, "")
            tempList.add(task)
        }

        val sexyInfo = SexyInfo(arrayListOf())
        sexyInfo.list.addAll(tempList)
        list.add(sexyInfo)


        return list
    }

    private fun parseHair(document: Document): List<Any> {
        val list = ArrayList<Any>()
        val elements = document.select("div[class^=w960 r]")
        val elementMain = elements[0]

        val elementBanner = elementMain.select("div[class^=hd l re]")
        val bannerinfos = elementBanner.select("a")
        var tempList = arrayListOf<Task>()
        for (info in bannerinfos) {
            val a = info.select("a")
            val title = a.attr("imgsm")
            val href = a.attr("href")
            val img = a.select("img").attr("src")
            println(title)
            println(href)
            println(img)
            val task = Task(title, img, href, "")
            tempList.add(task)
        }

        val bannerinfo = BannerInfo(tempList)
        list.add(bannerinfo)
        return list
    }
}