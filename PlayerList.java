/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsouptester;

import java.util.Locale;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Naseem
 */
public class PlayerList {
    
    public static void main(String args[]) throws Exception{
        Document html = Jsoup.connect("https://www.mykhel.com/cricket/ipl-2018-bangalore-squad-tp57-s4/").get();
        Element body = html.body();
        Elements lis=body.select(".ipl-squads-container").first().select("li");
        for(Element li:lis){
            Element img=li.select(".ipl-sqaud-playerimg").first().select("img").first();
            Element div=li.select(".ipl-squad-playername").first();
            System.out.println(String.format(Locale.getDefault(), "%s # https://www.mykhel.com%s", div.text(),img.attr("src")));
        }
    }
    
}
